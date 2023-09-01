package com.sx.icecap.web.display.context.sd;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchResult;
import com.liferay.portal.kernel.search.SearchResultUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;
import com.sx.icecap.service.StructuredDataLocalServiceUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.MimeResponse.Copy;
import javax.servlet.http.HttpServletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class StructuredDataSearchContainerProvider {
	private SearchContainer<StructuredData> _searchContainer = null;
	private RenderRequest _renderRequest = null;
	private RenderResponse _renderResponse = null;
	private String _searchContainerId = "";
	private PortletURL _searchURL = null;
	private StructuredDataLocalService _structuredDataLocalService = null;
	private ThemeDisplay _themeDisplay = null;
	private String _advancedQuery = "";
	long _assetCategoryId = 0; 
	String _assetTagName = "";
	String _keywords = "";
	String _navigation = "";
	String _orderByCol = "";
	String _orderByType = "";
	int _status = WorkflowConstants.STATUS_APPROVED;
	DataType _dataType = null;


	public StructuredDataSearchContainerProvider( 
			DataType dataType,
			String strAdvancedQuery,
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			String searchContainerId,
			StructuredDataLocalService structuredDataLocalService ){
		
			this._dataType = dataType;
			this._renderRequest = renderRequest;
			this._renderResponse = renderResponse;
			this._searchContainerId = searchContainerId;
			this._searchURL = _getSearchURL(); 
			this._structuredDataLocalService = structuredDataLocalService;
			this._themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			this._keywords = ParamUtil.getString(renderRequest, StationXWebKeys.KEYWORDS, "");
			this._advancedQuery = strAdvancedQuery;
			System.out.println("Keywords: " + this._keywords);
			
			_assetCategoryId = ParamUtil.getLong(renderRequest, StationXWebKeys.CATEGORY_ID);
			_assetTagName = ParamUtil.getString(renderRequest, StationXWebKeys.TAG);
			_navigation = ParamUtil.getString( renderRequest, StationXWebKeys.NAVIGATION, StationXConstants.NAVIGATION_ALL);
			_orderByCol = ParamUtil.getString( renderRequest, StationXWebKeys.ORDER_BY_COL, IcecapSDSearchFields.DATATYPE_NAME);
			_orderByType = ParamUtil.getString( renderRequest, StationXWebKeys.ORDER_BY_TYPE, StationXConstants.ASC);
			_status = ParamUtil.getInteger( _renderRequest, IcecapSDSearchFields.STATUS, WorkflowConstants.STATUS_APPROVED);
	}
	
	public SearchContainer<StructuredData> createSearchContainer() throws PortalException{
		_searchContainer = 
				new SearchContainer<StructuredData>(
						_renderRequest,
						_searchURL, // URL for iteration of pagenation.
						null,
						"no-data-were-found" );
		
		_setSearchOptions();
		
		if ((_assetCategoryId != 0) || Validator.isNotNull(_assetTagName)) {
			_trySearchThroughCategoryTree();
		}
		else if( Validator.isNotNull(  _advancedQuery ) ) {
			_tryAdvancedSearch();
		}
		else if( Validator.isNotNull( _keywords ) ) {
			_trySearchWithKeywords();
		}
		else {
			_trySearchThroughService();
		}

		return _searchContainer;
	}
	
	private void _trySearchThroughCategoryTree() throws PortalException {
		Debug.printHeader("_trySearchThroughCategoryTree");
		
		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(StructuredData.class.getName(), _searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(ParamUtil.getString(_renderRequest, StationXWebKeys.ORDER_BY_COL));
		assetEntryQuery.setOrderByType1(ParamUtil.getString(_renderRequest, StationXWebKeys.ORDER_BY_TYPE));
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(_searchContainer.getEnd());
		assetEntryQuery.setStart(_searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(assetEntryQuery);

		_searchContainer.setTotal(total);

//			Sentance using functional programming
		List<StructuredData> entriesResults = assetEntries.stream()
				.map( this::_toStructuredDataOptional )
				.filter( Optional::isPresent )
				.map( Optional::get )
				.collect( Collectors.toList() );
		
//			Sentance using Lambda expression only
//			assetEntries.forEach(assetEntry -> entriesResults.add(StructuredDataTypeLocalServiceUtil.getStructuredData(assetEntry.getClassPK())));
		
		/* Using imperative programming
		 * 
		 * for (AssetEntry assetEntry : assetEntries) {
		 * 		entriesResults.add(StructuredDataLocalServiceUtil.getStructuredData(assetEntry.getClassPK());
		 * }
		 */
		
		_searchContainer.setResults(entriesResults);
		
		Debug.printFooter("_trySearchThroughCategoryTree");
	}
	
	private boolean _tryAdvancedSearch() {
		Debug.printHeader("_tryAdvancedSearch");
		Indexer<StructuredData> indexer = IndexerRegistryUtil.getIndexer(StructuredData.class);

		
		SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(_renderRequest));

		searchContext.setAttribute( Field.STATUS, String.valueOf(_status) );
		searchContext.setAttribute("pagenationType", "more");
		searchContext.setStart(_searchContainer.getStart());
		searchContext.setEnd(_searchContainer.getEnd());
		searchContext.setIncludeDiscussions(true);
		searchContext.setKeywords(_keywords);
		searchContext.setLocale(_themeDisplay.getLocale());
		

		if (!_navigation.equals(StationXConstants.NAVIGATION_MINE)) {
			searchContext.setOwnerUserId(_themeDisplay.getUserId());
		}

		boolean reverseSort = false;

		if (_orderByType.equals(StationXConstants.DSC)) {
			reverseSort = true;
		}

		Sort sort = SortFactoryUtil.create(_orderByCol, Sort.STRING_TYPE, reverseSort);

		searchContext.setSorts(sort);

		List<StructuredData> entriesResults = new ArrayList<StructuredData>();
		Hits hits = null;
		try {
			hits = indexer.search(searchContext);
			System.out.println("Advanced Search Result Count: " + hits.getLength());
		} catch (Exception e1) {
			e1.printStackTrace();
			_searchContainer.setTotal( 0 );
			_searchContainer.setResults(entriesResults);
			
			return true;
		}

		_searchContainer.setTotal( hits.getLength() );

		List<SearchResult> searchResults =
				SearchResultUtil.getSearchResults( hits, _themeDisplay.getLocale() );

		// Imperative programming
		Document[] docs = hits.getDocs();
		
		for( Document doc : docs ) {
			long structuredDataId = GetterUtil.getLong( doc.get(Field.ENTRY_CLASS_PK) );
			StructuredData structuredData = null;
			try {
				structuredData = _structuredDataLocalService.getStructuredData( structuredDataId );
				entriesResults.add(structuredData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println( "==== Begin Document Fields - "+doc.get(Field.ENTRY_CLASS_PK) );
			
			Map<String, Field> fields = doc.getFields();
			fields.forEach((key, field) ->{
				System.out.println(key + ": (" + field.getName() + "-"+ field.getValue());
			});
			System.out.println( "==== End Document Fields" );
		}
		
		/* Functional programming
		 * 

		Stream<SearchResult> stream = searchResults.stream();

		entriesResults = stream.map(
			this::_toTermOptional
		).filter(
			Optional::isPresent
		).map(
			Optional::get
		).collect(
			Collectors.toList()
		);
		*/
		Debug.printFooter("_tryAdvancedSearch");
		return true;
	}
	
	private void _trySearchThroughService () {
		Debug.printHeader("_trySearchThroughService");
		
		List<StructuredData> entriesResults = null;

		if ( _navigation.equals(StationXConstants.NAVIGATION_MINE) ) {
			_searchContainer.setTotal(
					_structuredDataLocalService.countStructuredDatasByDataTypeId_U_S(
							_dataType.getPrimaryKey(), 
							_themeDisplay.getUserId(),
							_status));
	
			entriesResults = _structuredDataLocalService.getStructuredDatasByDataTypeId_U_S(
					_dataType.getPrimaryKey(), 
					_themeDisplay.getUserId(),
					_status, 
					_searchContainer.getStart(),
					_searchContainer.getEnd(),
					_searchContainer.getOrderByComparator() );
		}
		else if( _navigation.equals(StationXConstants.NAVIGATION_GROUP)){
			_searchContainer.setTotal(
					_structuredDataLocalService.countStructuredDatasByDataTypeId_G_S(
							_dataType.getPrimaryKey(), 
							_themeDisplay.getScopeGroupId(),
							_status));
			
			entriesResults = _structuredDataLocalService.getStructuredDatasByDataTypeId_G_S(
					_dataType.getPrimaryKey(), 
					_themeDisplay.getScopeGroupId(),
					_status, 
					_searchContainer.getStart(),
					_searchContainer.getEnd(),
					_searchContainer.getOrderByComparator());
		}
		else {
			_searchContainer.setTotal(
					_structuredDataLocalService.countStructuredDatasByDataTypeId_S(
							_dataType.getPrimaryKey(),
							_status));
			
			entriesResults = _structuredDataLocalService.getStructuredDatasByDataTypeId_S(
					_dataType.getPrimaryKey(),
					_status,
					_searchContainer.getStart(),
					_searchContainer.getEnd() ,
			        _searchContainer.getOrderByComparator());
		}
		
		System.out.println("Search Result: "+entriesResults.size());
		_searchContainer.setResults(entriesResults);
		
		Debug.printFooter("_trySearchThroughService");
	}
	
	private boolean _trySearchWithKeywords() {
		Debug.printHeader("_trySearchWithKeywords");
		if( _keywords.isEmpty() ) {
			return false;
		}

		Indexer<StructuredData> indexer = IndexerRegistryUtil.getIndexer(StructuredData.class);

		
		SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(_renderRequest));

		searchContext.setAttribute( Field.STATUS, String.valueOf(_status) );
		searchContext.setAttribute("pagenationType", "more");
		searchContext.setStart(_searchContainer.getStart());
		searchContext.setEnd(_searchContainer.getEnd());
		searchContext.setIncludeDiscussions(true);
		searchContext.setKeywords(_keywords);
		searchContext.setLocale(_themeDisplay.getLocale());
		
		/*
		System.out.println("Search Container Attributes.....");
		Map<String, Serializable> attrs = searchContext.getAttributes();
		Set<String> keySet = attrs.keySet();
		Iterator<String> iter = keySet.iterator();
		while( iter.hasNext() ) {
			String key = iter.next();
			
			System.out.println(key + " - " + attrs.get(key) );
		}
		System.out.println("End of Search Container Attributes.....");
		*/

		if (!_navigation.equals(StationXConstants.NAVIGATION_MINE)) {
			searchContext.setOwnerUserId(_themeDisplay.getUserId());
		}

		boolean reverseSort = false;

		if (_orderByType.equals(StationXConstants.DSC)) {
			reverseSort = true;
		}

		Sort sort = SortFactoryUtil.create(_orderByCol, Sort.STRING_TYPE, reverseSort);

		searchContext.setSorts(sort);

		List<StructuredData> entriesResults = new ArrayList<StructuredData>();
		Hits hits = null;
		try {
			hits = indexer.search(searchContext);
			System.out.println("Keyword Search Result count: " + hits.getLength() );
		} catch (Exception e1) {
			_searchContainer.setTotal( 0 );
			_searchContainer.setResults(entriesResults);
			
			e1.printStackTrace();
			return true;
		}

		_searchContainer.setTotal( hits.getLength() );

		List<SearchResult> searchResults =
				SearchResultUtil.getSearchResults( hits, _themeDisplay.getLocale() );

		// Imperative programming
		Document[] docs = hits.getDocs();
		
		for( Document doc : docs ) {
			long structuredDataId = GetterUtil.getLong( doc.get(Field.ENTRY_CLASS_PK) );
			StructuredData structuredData = null;
			try {
				structuredData = _structuredDataLocalService.getStructuredData( structuredDataId );
				entriesResults.add(structuredData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/*
			System.out.println( "==== Begin Document Fields in SD search container - "+doc.get(Field.ENTRY_CLASS_PK) );
			
			Map<String, Field> fields = doc.getFields();
			fields.forEach((key, field) ->{
				System.out.println(key + ": (" + field.getName() + "-"+ field.getValue());
			});
			System.out.println( "==== End Document Fields" );
			*/
		}
		
		_searchContainer.setResults(entriesResults);
		
		/* Functional programming
		 * 

		Stream<SearchResult> stream = searchResults.stream();

		entriesResults = stream.map(
			this::_toTermOptional
		).filter(
			Optional::isPresent
		).map(
			Optional::get
		).collect(
			Collectors.toList()
		);
		*/
		Debug.printFooter("_trySearchWithKeywords");
		return true;
	}
	
	
	private PortletURL _getSearchURL() {
		PortletURL searchURL = _renderResponse.createRenderURL(Copy.ALL);
		Map<String, String[]> params = searchURL.getParameterMap();
		params.forEach( (k, v) -> System.out.println("key: "+k+", value: "+v));
		
		return searchURL;
	}
	
	private void _setSearchOptions(){
		_searchContainer.setId(_searchContainerId);
		_searchContainer.setOrderByCol(
				ParamUtil.getString(
						_renderRequest, 
						StationXWebKeys.ORDER_BY_COL, 
						IcecapSDSearchFields.DATATYPE_NAME));
		_searchContainer.setOrderByType(
				ParamUtil.getString(
						_renderRequest, 
						StationXWebKeys.ORDER_BY_TYPE, 
						StationXConstants.ASC));
		

		_searchContainer.setForcePost(true);
		
		/*
		_searchContainer.setOrderByComparator( 
				_structuredDataLocalService.getOrderByNameComparator(
						_searchContainer.getOrderByCol(), searchContainer.getOrderByType()) );
		 */
		_searchContainer.setRowChecker( new EmptyOnClickRowChecker(_renderResponse) );
	}
	
	private Optional<StructuredData> _toStructuredDataOptional(AssetEntry assetEntry) {

		try {
			return Optional.of(
				StructuredDataLocalServiceUtil.getStructuredData(assetEntry.getClassPK()));
		}
		catch (Exception e) {
			System.out.println("StructuredData  search index is stale and contains entry " +
					assetEntry.getClassPK() );
			return Optional.empty();
		}

	}
}
