package com.sx.icecap.web.display.context.sd;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownGroupItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.web.security.permission.resource.datatype.DataTypeResourcePermissionHelper;
import com.sx.icecap.web.security.permission.resource.sd.StructuredDataModelPermissionHelper;
import com.sx.icecap.constant.IcecapActionKeys;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.model.StructuredData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
import javax.servlet.http.HttpServletRequest;

public class StructuredDataManagementToolbarDisplayContext 
						extends SearchContainerManagementToolbarDisplayContext{

	private final ThemeDisplay _themeDisplay;
	private final String _displayStyle;
	private final String _keywords;
	private final String _orderByCol;
	private final String _orderByType;
	private final long _groupId;
	private final boolean _showAddButton;
	private final Integer _status;
	private final String _navigation;
	private final Boolean _multipleSelection;
	private final String _eventName;
	private final Boolean _showScheduled;

	
	private final String _namespace;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final TrashHelper _trashHelper;
	
	private final Locale _locale;
	
	private final long _dataTypeId;

	public StructuredDataManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest httpServletRequest,
			SearchContainer<StructuredData> searchContainer,
			TrashHelper trashHelper) {

		super(
				liferayPortletRequest, 
				liferayPortletResponse, 
				httpServletRequest,
				searchContainer);
		
		/* For the scope to search. mine, group, all. It's set in the management toolbar. */
		_navigation = ParamUtil.getString(httpServletRequest, StationXWebKeys.NAVIGATION, StationXConstants.NAVIGATION_MINE);
		/* For the display style. card, list, table.  It's set in the management toolbar. */
		_displayStyle = ParamUtil.getString(
				httpServletRequest, StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_TABLE);
		/* For sorting by column.  It's set in the management toolbar. */
		_orderByCol = searchContainer.getOrderByCol();
		/* For sorting by ascending or descending.  It's set in the management toolbar. */
		_orderByType = searchContainer.getOrderByType();
		
		/* Keywords for searched.  It's set in the management toolbar. */
		DisplayTerms displayStructuredDatas = searchContainer.getSearchTerms();
		_keywords = Validator.isNotNull(displayStructuredDatas) ? displayStructuredDatas.getKeywords() : "";
		
		/* Status to be displayed.  It's set in the management toolbar.  */
		_status = ParamUtil.getInteger(httpServletRequest, IcecapSDSearchFields.STATUS, WorkflowConstants.STATUS_ANY);
		
		/* Show add button or not */
		_showAddButton = ParamUtil.getBoolean(httpServletRequest, StationXWebKeys.SHOW_ADD_BUTTON, true);
		_multipleSelection = ParamUtil.getBoolean( httpServletRequest, StationXWebKeys.MULTIPLE_SELECTION, true);
		_showScheduled = ParamUtil.getBoolean(httpServletRequest, StationXWebKeys.SHOW_SCHEDULED, false);
		
		_themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		_namespace = _themeDisplay.getPortletDisplay().getNamespace();
		_eventName = ParamUtil.getString(
				httpServletRequest, StationXWebKeys.EVENT_NAME,
				_namespace + StationXWebKeys.SELECT_STRUCTURED_DATA);
		
		_httpServletRequest = httpServletRequest;
		_locale = _themeDisplay.getLocale();
		_groupId = _themeDisplay.getScopeGroupId();
		
		_permissionChecker = _themeDisplay.getPermissionChecker();
		_trashHelper = trashHelper;
		
		_dataTypeId = ParamUtil.getLong(_httpServletRequest, StationXWebKeys.DATATYPE_ID);
		
	}
	
	@Override
	public CreationMenu getCreationMenu() {
		
		if( !DataTypeResourcePermissionHelper.contains(
				_permissionChecker, 
				_themeDisplay.getScopeGroupId(), 
				"ADD_STRUCTURED_DATA")) {
			
			System.out.println("Do not have ADD_STRUCTURED_DATA permission");
			return null;
		}
		
		CreationMenu menu = 
				new CreationMenu() {
					{
						addDropdownItem(
								dropdownItem -> {
									PortletURL renderURL = liferayPortletResponse.createRenderURL(Copy.ALL);
									renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT);
									renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_dataTypeId) );
									renderURL.setParameter(StationXWebKeys.BACK_URL, currentURLObj.toString());
									
									dropdownItem.setHref( renderURL );
									dropdownItem.setLabel(
											LanguageUtil.get(request, "add-data"));
								});
					}
				};
		
		return menu;
	}
	
	public SearchContainer<StructuredData> getSearchContainer(){
		return super.searchContainer;
	}
	
	@Override
	public String getSearchActionURL() {
		PortletURL searchURL =  getPortletURL();
		
		searchURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME, 
				IcecapMVCCommands.RENDER_DATATYPE_LIST);
		
		return searchURL.toString();
	}
	
	@Override
	protected String[] getDisplayViews() {
		String[] viewTypes = new String[] { 
				StationXConstants.VIEW_TYPE_CARDS, 
				StationXConstants.VIEW_TYPE_LIST,
				StationXConstants.VIEW_TYPE_TABLE};
		return viewTypes;
	}
	
	@Override
	protected String[] getNavigationKeys() {
		return StationXConstants.NAVIGATION_KEYS();
	}
	
	// Dropdown Items for management toolbar. multi selection.
	// These items appear on the management toolbar.
	@Override
	public List<DropdownItem> getActionDropdownItems() {
		List<DropdownItem> itemList = 
					new DropdownItemList() {
						{
							boolean stagedActions = false;
							
							add(
								dropdownItem -> {
									dropdownItem.setIcon("trash");
									dropdownItem.setLabel(LanguageUtil.get(request, "delete"));
									dropdownItem.setQuickAction(true);
									dropdownItem.putData("cmd", IcecapActionKeys.DELETE_STRUCTURED_DATA);
								});
						}
					};
					
		return itemList;
	}
	
	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		if (ArrayUtil.isEmpty(getDisplayViews())) {
			return null;
		}

		List<ViewTypeItem> viewTypeItemList = new ArrayList<ViewTypeItem>();

		String[] displayViews = getDisplayViews();
		
		String renderCommand = IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST;
		
		RenderURL renderURL = liferayPortletResponse.createRenderURL();
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand);
		renderURL.setParameter(StationXWebKeys.KEYWORDS, _keywords);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_dataTypeId) );
		
		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_CARDS)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_CARDS) );
			renderURL.setParameter(StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_CARDS);
			viewType.setHref(renderURL);
			viewType.setIcon("cards2");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "cards"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_LIST)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_LIST) );
			renderURL.setParameter(StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_LIST);
			viewType.setHref(renderURL);
			viewType.setIcon("list");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "list"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_TABLE)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_TABLE) );
			renderURL.setParameter(StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_TABLE);
			viewType.setHref(renderURL);
			viewType.setIcon("table");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "table"));
			viewTypeItemList.add(viewType);
		}
		
		return viewTypeItemList;
	}
	
	@Override
	protected String getDefaultDisplayStyle() {
		return StationXConstants.VIEW_TYPE_TABLE;
	}
	
	@Override
	protected String getDisplayStyle() {
		return _displayStyle;
	}
	
	@Override
	public String getSortingURL() {
		Debug.printHeader("getSortingURL");
		
		PortletURL portletURL = getPortletURL();
		if( _orderByType.equals(StationXConstants.ASC) ) {
			portletURL.setParameter(StationXWebKeys.ORDER_BY_TYPE, StationXConstants.DSC);
		}
		else {
			portletURL.setParameter(StationXWebKeys.ORDER_BY_TYPE, StationXConstants.ASC);
		}
		
		Debug.printFooter("getSortingURL");
		return portletURL.toString();
	}

	private Map<String, Integer> _getStatusMap(){

		Map<String, Integer> statusMap = new LinkedHashMap<>();

		statusMap.put("Any", Integer.valueOf(WorkflowConstants.STATUS_ANY));
		statusMap.put("Pending", Integer.valueOf(WorkflowConstants.STATUS_PENDING));
		statusMap.put("Approved", Integer.valueOf(WorkflowConstants.STATUS_APPROVED));
//		statusMap.put("Draft", Integer.valueOf(WorkflowConstants.STATUS_DRAFT));
//		statusMap.put("Denied", Integer.valueOf(WorkflowConstants.STATUS_DENIED));
//		statusMap.put("Scheduled", Integer.valueOf(WorkflowConstants.STATUS_SCHEDULED));
//		statusMap.put("Expired", Integer.valueOf(WorkflowConstants.STATUS_EXPIRED));

		return statusMap;
	}
	
	@Override
	protected List<DropdownItem> getFilterNavigationDropdownItems() {

		DropdownItemList filterNavigationDropdownItems = new DropdownItemList();
		
		List<DropdownItem> filterByScopeDropdownItemList = super.getFilterNavigationDropdownItems();
		DropdownGroupItem filterByScopeGroup = new DropdownGroupItem();
//		filterByScopeGroup.setLabel("Filter By Scope");
		filterByScopeGroup.setDropdownItems(filterByScopeDropdownItemList);
		filterNavigationDropdownItems.add(filterByScopeGroup);
		
		Map<String, Integer> statusMap = _getStatusMap();
		PortletURL filterURL =  getPortletURL();
		filterURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME,
				IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST);
		
		List<DropdownItem> filterByStatusDropdownItemList =  new DropdownItemList() {
			{
				for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
					add(
						dropdownItem -> {
							dropdownItem.setActive(_status == entry.getValue());
							dropdownItem.setHref(
									filterURL, StationXWebKeys.STATUS, entry.getValue());
							dropdownItem.setLabel(
								LanguageUtil.get(request, entry.getKey()));
						});
				}
			}
		};
		DropdownGroupItem filterByStatusGroup = new DropdownGroupItem();
		filterByStatusGroup.setLabel("Filter By Status");
		filterByStatusGroup.setDropdownItems(filterByStatusDropdownItemList);
		filterNavigationDropdownItems.add(filterByStatusGroup);
		
		return filterNavigationDropdownItems;
	}
	
	public List<DropdownItem> getItemActionDropdownItems( PortletRequest portletRequest,  long structuredDataId ){

		long plid = super.liferayPortletRequest.getPlid();
		
		String currentURL = PortalUtil.getCurrentURL(portletRequest);
		
		List<DropdownItem> itemList = 
				new DropdownItemList() {
					{
						if (_hasUpdatePermission( structuredDataId )) {
							PortletURL updateURL = liferayPortletResponse.createRenderURL();
							updateURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT);
							updateURL.setParameter(Constants.CMD, Constants.UPDATE);
							updateURL.setParameter(StationXWebKeys.BACK_URL, currentURL);
							updateURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_dataTypeId) );
							updateURL.setParameter(StationXWebKeys.STRUCTURED_DATA_ID, String.valueOf(structuredDataId) );
							
							add(dropdownItem -> {
								dropdownItem.setHref( updateURL );
									dropdownItem.setIcon("edit");
									dropdownItem.setLabel(LanguageUtil.get(_locale, "edit"));
							});
						}

						if (_hasDeletePermission( structuredDataId )) {
							PortletURL deleteURL = liferayPortletResponse.createActionURL();
							
							deleteURL.setParameter(ActionRequest.ACTION_NAME, IcecapMVCCommands.ACTION_STRUCTURED_DATA_DELETE);
							deleteURL.setParameter(StationXWebKeys.BACK_URL, currentURL);
							deleteURL.setParameter(StationXWebKeys.STRUCTURED_DATA_ID, String.valueOf(structuredDataId) );
							
							add( dropdownItem -> {
								dropdownItem.setHref(deleteURL);
								dropdownItem.setIcon("delete");
								dropdownItem.setLabel(
									LanguageUtil.get(request, "delete"));
							});		
						}
					}
				};
				
		return itemList;
	}

	private boolean _hasDeletePermission( long structuredDataId ) {
		boolean hasPermission = false;
		try {
			hasPermission = StructuredDataModelPermissionHelper.contains(
						_permissionChecker, structuredDataId, ActionKeys.DELETE);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return hasPermission;
	}
	
	private boolean _hasUpdatePermission( long structuredDataId ) {
		boolean hasPermission = false;
		try {
			hasPermission = StructuredDataModelPermissionHelper.contains(
				_permissionChecker, structuredDataId, ActionKeys.UPDATE);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return hasPermission;
	}
	
	@Override
	protected String getFilterNavigationDropdownItemsLabel() {
		return LanguageUtil.get(request, "filter-by-scope");
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {LanguageUtil.get(_locale, "parameter-name"), LanguageUtil.get(_locale, "modified-date")};
	}

	@Override
	public Boolean isSelectable() {
		return true;
	}

	@Override
	public Boolean getSupportsBulkActions() {
		return true;
	}

	@Override
	public Boolean isShowAdvancedSearch() {
		return false;
	}

	@Override
	public String getComponentId() {
		return "dataTypeManagementToolbar";
	}

	@Override
	public String getSearchFormMethod() {
//		System.out.println("----- Search Form Method: "+super.getSearchFormMethod());
		return super.getSearchFormMethod();
	}

	@Override
	public String getSearchFormName() {
//		System.out.println("----- Search Form Name: "+super.getSearchFormName());
		return "searchForm";
	}

	@Override
	public String getSearchInputName() {
//		System.out.println("----- Search Input Name: "+super.getSearchInputName());
		return super.getSearchInputName();
	}

	@Override
	public String getSearchValue() {
//		System.out.println("----- Search Value: "+super.getSearchValue());
		return super.getSearchValue();
	}

	@Override
	public int getSelectedItems() {
//		System.out.println("----- Selected Items: "+super.getSelectedItems());
		return super.getSelectedItems();
	}

	@Override
	public String getDefaultEventHandler() {
		if( Validator.isNull(super.getDefaultEventHandler())) {
//			System.out.println("Default Event Handler is null.");
			return null;
		}
		else {
//			System.out.println("Default Event Handler: "+super.getDefaultEventHandler());
		}
		return super.getDefaultEventHandler();
	}
}
