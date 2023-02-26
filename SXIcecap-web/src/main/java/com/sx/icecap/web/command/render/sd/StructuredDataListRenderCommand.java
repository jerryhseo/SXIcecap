package com.sx.icecap.web.command.render.sd;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;
import com.sx.icecap.web.display.context.sd.StructuredDataManagementToolbarDisplayContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST
	    },
	    service = MVCRenderCommand.class
	)
public class StructuredDataListRenderCommand implements MVCRenderCommand {
	
	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		  this._portal = portal;
	}
	protected Portal _portal;
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
	
	@Reference
	private StructuredDataLocalService _structuredDataLocalService;


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
//		System.out.println("TermListViewRenderCommand.render()");
		
		SearchContainer<StructuredData> searchContainer = null;
		try {
			searchContainer = _createSearchContainer( 
					renderRequest,
					renderResponse,
					IcecapConstants.STRUCTURED_DATA_SEARCH_CONTAINER_ID, 
					_getSearchURL( renderResponse )  // URL for iteration of pagenation
			);
		} catch (PortalException e) {
			throw new PortletException(e.getMessage());
		}
		
		StructuredDataManagementToolbarDisplayContext structuredDataManagementToolbarDisplayContext =
				new StructuredDataManagementToolbarDisplayContext(
						PortalUtil.getLiferayPortletRequest(renderRequest),
						PortalUtil.getLiferayPortletResponse(renderResponse),
						PortalUtil.getHttpServletRequest(renderRequest),
						searchContainer,
						_trashHelper);
		
		renderRequest.setAttribute(
				StructuredDataManagementToolbarDisplayContext.class.getName(), 
				structuredDataManagementToolbarDisplayContext );
		
		return IcecapConstants.JSP_SD_LIST_VIEW;
	}

	private SearchContainer<StructuredData> _createSearchContainer(
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			String searchContainerId,
			PortletURL iterateURL
			) throws PortalException{

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		SearchContainer<StructuredData> searchContainer = 
				new SearchContainer<StructuredData>(
						renderRequest,
						_getSearchURL( renderResponse ), // URL for iteration of pagenation.
						null,
						"no-data-types-were-found" );
		
		_setSearchOptions(
				renderRequest,
				renderResponse,
				searchContainer,
				searchContainerId
				);
		
		
		if( _trySearchThroughCategoryTree( renderRequest, renderResponse, searchContainer ) ) {
		}
		else if( _trySearchThroughService( renderRequest, renderResponse, searchContainer ) ) {
		}
		else {
			_trySearchWithIndexer(  renderRequest, renderResponse, searchContainer );
		}

		return searchContainer;

	}
	
	private boolean _trySearchThroughCategoryTree(
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			SearchContainer<StructuredData> searchContainer ) throws PortalException {
		
		long assetCategoryId = ParamUtil.getLong(renderRequest, StationXWebKeys.CATEGORY_ID);
		String assetTagName = ParamUtil.getString(renderRequest, StationXWebKeys.TAG);
		
		if ((assetCategoryId != 0) || Validator.isNotNull(assetTagName)) {
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery(StructuredData.class.getName(), searchContainer);

			assetEntryQuery.setExcludeZeroViewCount(false);
			assetEntryQuery.setOrderByCol1(ParamUtil.getString(renderRequest, StationXWebKeys.ORDER_BY_COL));
			assetEntryQuery.setOrderByType1(ParamUtil.getString(renderRequest, StationXWebKeys.ORDER_BY_TYPE));
			assetEntryQuery.setVisible(Boolean.TRUE);

			int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

			assetEntryQuery.setEnd(searchContainer.getEnd());
			assetEntryQuery.setStart(searchContainer.getStart());

			List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(assetEntryQuery);

			searchContainer.setTotal(total);

//			Sentance using functional programming
			List<StructuredData> entriesResults = assetEntries.stream()
					.map( this::_toStructuredDataOptional )
					.filter( Optional::isPresent )
					.map( Optional::get )
					.collect( Collectors.toList() );
			
//			Sentance using Lambda expression only
//			assetEntries.forEach(assetEntry -> entriesResults.add(_structuredDataLocalService.getStructuredData(assetEntry.getClassPK())));
			
			/* Using imperative programming
			 * 
			 * for (AssetEntry assetEntry : assetEntries) {
			 * 		entriesResults.add(_structuredDataLocalService.getStructuredData(assetEntry.getClassPK());
			 * }
			 */
			
			searchContainer.setResults(entriesResults);
			return true;
		}
		
		return false;
	}
	
	private boolean _trySearchThroughService (
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			SearchContainer<StructuredData> searchContainer ) {
		
		String Keywords = ParamUtil.getString( renderRequest, StationXWebKeys.KEYWORDS, StringPool.BLANK);
		if( !Keywords.isEmpty() ) {
			return false;
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navigation = ParamUtil.getString( renderRequest, StationXWebKeys.NAVIGATION, StationXConstants.NAVIGATION_ALL);
		int status = ParamUtil.getInteger( renderRequest, IcecapSDSearchFields.STATUS, WorkflowConstants.STATUS_APPROVED);
		
		System.out.println("status: "+status);
		System.out.println("navigation: "+navigation);
		
		List<StructuredData> entriesResults = null;
	
		if (navigation.equals(StationXConstants.NAVIGATION_MINE)) {
			searchContainer.setTotal(
				_structuredDataLocalService.countStructuredDatasByU_S(
					themeDisplay.getUserId(),
					status));
	
			entriesResults = _structuredDataLocalService.getStructuredDatasByU_S(
					themeDisplay.getUserId(),
					status, 
					searchContainer.getStart(),
					searchContainer.getEnd(),
					searchContainer.getOrderByComparator());
		}
		else if( navigation.equals(StationXConstants.NAVIGATION_GROUP)){
			searchContainer.setTotal(
					_structuredDataLocalService.countStructuredDatasByG_S(
					themeDisplay.getScopeGroupId(),
					status));
			
			entriesResults = _structuredDataLocalService.getStructuredDatasByG_S(
					themeDisplay.getScopeGroupId(),
					status, 
					searchContainer.getStart(),
					searchContainer.getEnd(),
					searchContainer.getOrderByComparator());
		}
		else {
			searchContainer.setTotal(_structuredDataLocalService.countStructuredDatasByStatus(status));
			
			entriesResults = _structuredDataLocalService.getStructuredDatasByStatus(
					status,
					searchContainer.getStart(),
					searchContainer.getEnd() ,
			        searchContainer.getOrderByComparator());
		}
		
		System.out.println("Search Result: "+entriesResults.size());
		searchContainer.setResults(entriesResults);
		
		return true;
	}
	
	private boolean _trySearchWithIndexer(
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			SearchContainer<StructuredData> searchContainer ) {
		
		String keywords = ParamUtil.getString( renderRequest, StationXWebKeys.KEYWORDS, StringPool.BLANK);
		if( keywords.isEmpty() ) {
			return false;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String navigation = ParamUtil.getString( renderRequest, StationXWebKeys.NAVIGATION, StationXConstants.NAVIGATION_ALL);
		String orderByCol = ParamUtil.getString( renderRequest, StationXWebKeys.ORDER_BY_COL, IcecapSDSearchFields.MODIFIED_DATE);
		String orderByType = ParamUtil.getString( renderRequest, StationXWebKeys.ORDER_BY_TYPE, StationXConstants.ASC);
		int status = ParamUtil.getInteger( renderRequest, IcecapSDSearchFields.STATUS, WorkflowConstants.STATUS_APPROVED);

		Indexer<StructuredData> indexer = IndexerRegistryUtil.getIndexer(StructuredData.class);

		
		SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));

		searchContext.setAttribute( Field.STATUS, String.valueOf(status) );
		searchContext.setAttribute("pagenationType", "more");
		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());
		searchContext.setIncludeDiscussions(true);
		searchContext.setKeywords(keywords);
		searchContext.setLocale(themeDisplay.getLocale());

		if (!navigation.equals(StationXConstants.NAVIGATION_MINE)) {
			searchContext.setOwnerUserId(themeDisplay.getUserId());
		}

		boolean reverseSort = false;

		if (orderByType.equals(StationXConstants.DSC)) {
			reverseSort = true;
		}

		Sort sort = SortFactoryUtil.create(orderByCol, Sort.STRING_TYPE, reverseSort);

		searchContext.setSorts(sort);

		List<StructuredData> entriesResults = new ArrayList<StructuredData>();
		Hits hits = null;
		try {
			hits = indexer.search(searchContext);
		} catch (Exception e1) {
			searchContainer.setTotal( 0 );
			searchContainer.setResults(entriesResults);
			
			return true;
		}

		searchContainer.setTotal( hits.getLength() );

		List<SearchResult> searchResults =
				SearchResultUtil.getSearchResults(
						hits, themeDisplay.getLocale() );

		// Imperative programming
		Document[] docs = hits.getDocs();
		
		for( Document doc : docs ) {
			long structuredDataId = GetterUtil.getLong( doc.get(Field.ENTRY_CLASS_PK) );
			StructuredData structuredData = null;
			try {
				structuredData = _structuredDataLocalService.getStructuredData(structuredDataId);
				entriesResults.add(structuredData);
			} catch (Exception e) {
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
		return true;
	}
	
	private void _setSearchOptions(
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			SearchContainer<StructuredData> searchContainer,
			String searchContainerId
			){
		
		searchContainer.setId(searchContainerId);
		searchContainer.setOrderByCol(
				ParamUtil.getString(
						renderRequest, 
						StationXWebKeys.ORDER_BY_COL, 
						IcecapSDSearchFields.DATASET_TITLE));
		searchContainer.setOrderByType(
				ParamUtil.getString(
						renderRequest, 
						StationXWebKeys.ORDER_BY_TYPE, 
						StationXConstants.ASC));
	}
	
	private PortletURL _getSearchURL( RenderResponse renderResponse ) {
		PortletURL searchURL = renderResponse.createRenderURL(Copy.ALL);
		Map<String, String[]> params = searchURL.getParameterMap();
		params.forEach( (k, v) -> System.out.println("key: "+k+", value: "+v));
		
		return searchURL;
	}
	
	private Optional<StructuredData> _toStructuredDataOptional(SearchResult searchResult) {

		try {
			return Optional.of(
				_structuredDataLocalService.getStructuredData(searchResult.getClassPK()));
		}
		catch (Exception e) {
			System.out.println("StructuredData  search index is stale and contains entry " +
				searchResult.getClassPK() );
			return Optional.empty();
		}

	}

	private Optional<StructuredData> _toStructuredDataOptional(AssetEntry assetEntry) {

		try {
			return Optional.of(
				_structuredDataLocalService.getStructuredData(assetEntry.getClassPK()));
		}
		catch (Exception e) {
			System.out.println("StructuredData  asset entry is stale and contains entry " +
					assetEntry.getClassPK() );
			return Optional.empty();
		}

	}

}
