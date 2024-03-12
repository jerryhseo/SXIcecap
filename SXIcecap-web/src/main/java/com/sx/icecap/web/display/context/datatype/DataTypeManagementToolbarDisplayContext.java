package com.sx.icecap.web.display.context.datatype;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownGroupItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.RowChecker;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.web.security.permission.resource.datatype.DataTypeModelPermissionHelper;
import com.sx.icecap.web.security.permission.resource.datatype.DataTypeResourcePermissionHelper;
import com.sx.icecap.web.taglib.clay.datatype.DataTypeVerticalCard;
import com.sx.icecap.constant.IcecapActionKeys;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.model.DataType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.RenderURL;
import javax.servlet.http.HttpServletRequest;

public class DataTypeManagementToolbarDisplayContext 
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

	public DataTypeManagementToolbarDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			HttpServletRequest httpServletRequest,
			SearchContainer<DataType> searchContainer,
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
		DisplayTerms displayDataTypes = searchContainer.getSearchTerms();
		_keywords = Validator.isNotNull(displayDataTypes) ? displayDataTypes.getKeywords() : "";
		
		/* Status to be displayed.  It's set in the management toolbar.  */
		_status = ParamUtil.getInteger(httpServletRequest, IcecapDataTypeAttributes.STATUS, WorkflowConstants.STATUS_ANY);
		
		/* Show add button or not */
		_showAddButton = ParamUtil.getBoolean(httpServletRequest, StationXWebKeys.SHOW_ADD_BUTTON, true);
		_multipleSelection = ParamUtil.getBoolean( httpServletRequest, StationXWebKeys.MULTIPLE_SELECTION, true);
		_showScheduled = ParamUtil.getBoolean(httpServletRequest, StationXWebKeys.SHOW_SCHEDULED, false);
		
		_themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		_namespace = _themeDisplay.getPortletDisplay().getNamespace();
		_eventName = ParamUtil.getString(
				httpServletRequest, StationXWebKeys.EVENT_NAME,
				_namespace + StationXWebKeys.SELECT_DATATYPE);
		
		_httpServletRequest = httpServletRequest;
		_locale = _themeDisplay.getLocale();
		_groupId = _themeDisplay.getScopeGroupId();
		
		_permissionChecker = _themeDisplay.getPermissionChecker();
		_trashHelper = trashHelper;
		
	}
	
	@Override
	protected PortletURL getPortletURL() {
		PortletURL portletURL = super.liferayPortletResponse.createRenderURL();
		
		portletURL.setParameter(StationXWebKeys.GROUP_ID, String.valueOf(_groupId));

		if (_getListable() != null) {
			portletURL.setParameter(StationXWebKeys.LISTABLE, String.valueOf(_getListable()));
		}

		portletURL.setParameter( 
				StationXWebKeys.MULTIPLE_SELECTION, 
				String.valueOf(_multipleSelection));

		portletURL.setParameter(StationXWebKeys.SHOW_ADD_BUTTON, String.valueOf(_showAddButton));

		portletURL.setParameter(
				StationXWebKeys.SHOW_SCHEDULED, String.valueOf(_showScheduled));

		portletURL.setParameter(StationXWebKeys.EVENT_NAME, _eventName);
		
		portletURL.setParameter(StationXWebKeys.DISPLAY_STYLE, _displayStyle);
		portletURL.setParameter(StationXWebKeys.ORDER_BY_COL, _orderByCol);
		portletURL.setParameter(StationXWebKeys.ORDER_BY_TYPE, _orderByType);
		portletURL.setParameter(StationXWebKeys.NAVIGATION, _navigation);
		portletURL.setParameter(StationXWebKeys.KEYWORDS, _keywords);
		
		return portletURL;
	}

	@Override
	public String getClearResultsURL() {
//		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getClearResultsURL()");
		PortletURL clearResultsURL = getPortletURL();
		clearResultsURL.setParameter(StationXWebKeys.KEYWORDS, StringPool.BLANK);
//		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getClearResultsURL()");
		return clearResultsURL.toString();
	}
	
	@Override
	public String getSearchContainerId() {
		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getSearchContainerId()");
//		String searchContainerId = _dataTypeAdminDisplayContext.getSearchContainerId();
		String searchContainerId = super.searchContainer.getId( _httpServletRequest, _namespace);
		
		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getSearchContainerId()");
		return searchContainerId;
	}
	
	public SearchContainer<DataType> getSearchContainer(){
		return super.searchContainer;
	}
	
	@Override
	public String getSearchActionURL() {
		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getSearchActionURL()");
		PortletURL searchURL =  getPortletURL();
		
		searchURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME, 
				IcecapMVCCommands.RENDER_DATATYPE_LIST);
		
		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getSearchActionURL()");

		return searchURL.toString();
	}
	
	public PortletURL getFilterURL() {
		PortletURL filterURL =  getPortletURL();
		filterURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME,
				IcecapMVCCommands.RENDER_DATATYPE_LIST);

		return filterURL;
	}
	
	@Override
	protected String[] getDisplayViews() {
//		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getDisplayViews()");
		String[] viewTypes = new String[] { 
				StationXConstants.VIEW_TYPE_CARDS, 
				StationXConstants.VIEW_TYPE_LIST,
				StationXConstants.VIEW_TYPE_TABLE};
//		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getDisplayViews()");
		return viewTypes;
	}
	
	@Override
	protected String[] getNavigationKeys() {
//		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getNavigationKeys()");
//		System.out.println("Default NavigationKeys are define in StationXConstants");
//		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getNavigationKeys()");
		return StationXConstants.NAVIGATION_KEYS();
	}
	
	protected Map<String, Integer> getStatusMap(){

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
	
	protected List<DropdownItem> getFilterByStatusDropdownItems() {
		return getStatusDropdownItems(
						getStatusMap(), 
						getFilterURL(), 
						getStatusParam(),
						getFilterStatus());
	}
	
	protected List<DropdownItem> getStatusDropdownItems(
			Map<String, Integer> statusMap, 
			PortletURL filterURL,
			String parameterName, 
			int parameterValue){
		return new DropdownItemList() {
			{
				for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
					add(
						dropdownItem -> {
							dropdownItem.setActive(parameterValue == entry.getValue());
							dropdownItem.setHref(
									filterURL, parameterName, entry.getValue());
							dropdownItem.setLabel(
								LanguageUtil.get(request, entry.getKey()));
						});
				}
			}
		};
	}
	
	protected int getFilterStatus() {
		return ParamUtil.getInteger(
			super.liferayPortletRequest, getStatusParam(), WorkflowConstants.STATUS_ANY);
	}
	
	protected String getStatusParam() {
		return "status";
	}
	
	// Dropdown Items for management toolbar. multi selection.
	// These items appear on the management toolbar.
	@Override
	public List<DropdownItem> getActionDropdownItems() {
//		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getActionDropdownItems()");
		List<DropdownItem> itemList = 
					new DropdownItemList() {
						{
							boolean stagedActions = false;
							
							add(
								dropdownItem -> {
									dropdownItem.setIcon("trash");
									dropdownItem.setLabel(LanguageUtil.get(request, "delete"));
									dropdownItem.setQuickAction(true);
									dropdownItem.putData("cmd", IcecapActionKeys.DELETE_DATATYPE);
								});
						}
					};
					
//		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getActionDropdownItems()");
		return itemList;
	}
	
	public List<String> getAvailableActions( DataType dataType ) throws PortalException{
		
		List<String> availableActions = new ArrayList<>();

		PermissionChecker permissionChecker =
			_themeDisplay.getPermissionChecker();

		if (DataTypeModelPermissionHelper.contains(
				permissionChecker, dataType, IcecapActionKeys.DELETE_DATATYPE)) {

			availableActions.add(IcecapActionKeys.DELETE_DATATYPE);
		}
		
		if (DataTypeModelPermissionHelper.contains(
				permissionChecker, dataType, IcecapActionKeys.UPDATE_DATATYPE)) {

			availableActions.add(IcecapActionKeys.UPDATE_DATATYPE);
		}
		
		if (DataTypeModelPermissionHelper.contains(
				permissionChecker, dataType, IcecapActionKeys.ADD_DATATYPE)) {

			availableActions.add(IcecapActionKeys.ADD_DATATYPE);
		}

		if (DataTypeModelPermissionHelper.contains(
				permissionChecker, dataType, IcecapActionKeys.REVIEW_DATATYPE)) {

			availableActions.add(IcecapActionKeys.REVIEW_DATATYPE);
		}

		if (DataTypeModelPermissionHelper.contains(
				permissionChecker, dataType, IcecapActionKeys.APPROVE_DATATYPE)) {

			availableActions.add(IcecapActionKeys.APPROVE_DATATYPE);
		}
		
		return availableActions;

	}
	
	public String getBulkActionURL() {
		PortletURL actionURL = liferayPortletResponse.createActionURL();
		actionURL.setParameter("actionName", IcecapMVCCommands.ACTION_BULK);
		
		return actionURL.toString();
	}
	
	public List<DropdownItem> getItemActionDropdownItems( PortletRequest portletRequest, long dataTypeId, String url ){
//		Debug.printHeader("DataTypeManagementToolbarDisplayContext.getItemActionDropdownItems()");
		long plid = super.liferayPortletRequest.getPlid();
		
		List<DropdownItem> itemList = 
				new DropdownItemList() {
					{
						if (_hasUpdatePermission( dataTypeId )) {
							add(dropdownItem -> {
								dropdownItem.setHref(
										liferayPortletResponse.createActionURL(), 
										ActionRequest.ACTION_NAME, IcecapMVCCommands.ACTION_DATATYPE_COPY, 
										StationXWebKeys.BACK_URL, _themeDisplay.getURLCurrent(), 
										StationXWebKeys.DATATYPE_ID, dataTypeId);
									dropdownItem.setIcon("copy");
									dropdownItem.setLabel(LanguageUtil.get(_locale, "copy"));
							});
						}
						
						if (_hasUpdatePermission( dataTypeId )) {
							add(dropdownItem -> {
								dropdownItem.setHref(
										getPortletURL(), 
										StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_EDIT, 
										Constants.CMD, Constants.UPDATE,
										StationXWebKeys.BACK_URL, _themeDisplay.getURLCurrent(), 
										StationXWebKeys.DATATYPE_ID, dataTypeId);
									dropdownItem.setIcon("edit");
									dropdownItem.setLabel(LanguageUtil.get(_locale, "edit"));
							});
						}

						if (_hasDeletePermission( dataTypeId )) {
							/*
							PortletURL deleteURL = liferayPortletResponse.createActionURL();
							
							deleteURL.setParameter(ActionRequest.ACTION_NAME, IcecapMVCCommands.ACTION_DATATYPE_DELETE);
							deleteURL.setParameter(Constants.CMD, Constants.DELETE);
							deleteURL.setParameter(StationXWebKeys.BACK_URL, _themeDisplay.getURLCurrent());
							deleteURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
							*/
							add( dropdownItem -> {
								String href = "javascript:" + liferayPortletResponse.getNamespace() + "deleteDataType(" + dataTypeId + ")";
								dropdownItem.setHref(href);
//								dropdownItem.setHref(deleteURL);
								dropdownItem.setIcon("delete");
								dropdownItem.setLabel(
									LanguageUtil.get(request, "delete"));
							});		
						}
						{
							add(dropdownItem -> {
								PortletURL actionURL = liferayPortletResponse.createActionURL();
								actionURL.setParameter(ActionRequest.ACTION_NAME, IcecapMVCCommands.ACTION_DATATYPE_REDIRECT_TO_SD_LIST);
								actionURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId));
								actionURL.setParameter(StationXWebKeys.BACK_URL, _themeDisplay.getURLCurrent());
								
								dropdownItem.setHref(actionURL);
								dropdownItem.setIcon("view");
								dropdownItem.setLabel(LanguageUtil.get(_locale, "view-data-list"));
							});	
						}
					}
				};
				
//		Debug.printFooter("DataTypeManagementToolbarDisplayContext.getItemActionDropdownItems()");
		return itemList;
	}

	@Override
	public CreationMenu getCreationMenu() {
		
		if( !DataTypeResourcePermissionHelper.contains(
				_permissionChecker, 
				_themeDisplay.getScopeGroupId(), 
				"ADD_DATATYPE")) {
			
			System.out.println("Do not have ADD_DATATYPE permission");
			return null;
		}
		
		CreationMenu menu = 
				new CreationMenu() {
					{
						addDropdownItem(
								dropdownItem -> {
									dropdownItem.setHref(
											getPortletURL(),
											StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_EDIT,
											StationXWebKeys.REDIRECT, currentURLObj.toString(),
											Constants.CMD, Constants.ADD);
									dropdownItem.setLabel(
											LanguageUtil.get(request, "add-dataType"));
								});
					}
				};
		
		return menu;
	}
	
	public DataTypeVerticalCard getVerticalCard( 
			DataType dataType, 
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			RowChecker rowChecker,
			String dataTypeViewURL) {
		
		PortletRequest portletRequest = (PortletRequest)renderRequest.getAttribute("javax.portlet.request");
		return new DataTypeVerticalCard(
				dataType, 
				renderRequest, 
				renderResponse, 
				rowChecker, 
				dataTypeViewURL, 
				getItemActionDropdownItems(portletRequest, dataType.getDataTypeId(), ""));
	}

	private boolean _hasDeletePermission( long dataTypeId ) {
		boolean hasPermission = false;
		try {
			hasPermission = DataTypeModelPermissionHelper.contains(
						_permissionChecker, dataTypeId, ActionKeys.DELETE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Delete Permission: "+hasPermission);
		return hasPermission;
	}
	
	private boolean _hasUpdatePermission( long dataTypeId ) {
		boolean hasPermission = false;
		try {
			hasPermission = DataTypeModelPermissionHelper.contains(
				_permissionChecker, dataTypeId, ActionKeys.UPDATE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("Update Permission: "+hasPermission);
		return hasPermission;
	}
	
	private String _getBackURL() {
		PortletURL backURL = getPortletURL();

		return backURL.toString();
	}

	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		if (ArrayUtil.isEmpty(getDisplayViews())) {
			return null;
		}

		List<ViewTypeItem> viewTypeItemList = new ArrayList<ViewTypeItem>();

		String[] displayViews = getDisplayViews();
		
		RenderURL renderURL = liferayPortletResponse.createRenderURL();
		
		String renderCommand = IcecapMVCCommands.RENDER_DATATYPE_LIST;
		if( Validator.isNotNull(_keywords) && !_keywords.isEmpty() ) {
			renderCommand = IcecapMVCCommands.RENDER_SEARCH_DATATYPES;
		}
		
		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_CARDS)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_CARDS) );
			viewType.setHref(renderURL,
						StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_CARDS,
						StationXWebKeys.KEYWORDS, _keywords);
			viewType.setIcon("cards2");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "cards"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_LIST)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_LIST) );
			viewType.setHref(renderURL,
						StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_LIST,
						StationXWebKeys.KEYWORDS, _keywords);
			viewType.setIcon("list");
			viewType.setLabel(LanguageUtil.get(LocaleUtil.getMostRelevantLocale(), "list"));
			viewTypeItemList.add(viewType);
		}

		if (ArrayUtil.contains(displayViews, StationXConstants.VIEW_TYPE_TABLE)) {
			ViewTypeItem viewType = new ViewTypeItem();
			
			viewType.setActive( _displayStyle.equals(StationXConstants.VIEW_TYPE_TABLE) );
			viewType.setHref(renderURL,
						StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand,
						StationXWebKeys.DISPLAY_STYLE, StationXConstants.VIEW_TYPE_TABLE,
						StationXWebKeys.KEYWORDS, _keywords);
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

	@Override
	protected List<DropdownItem> getFilterNavigationDropdownItems() {

		DropdownItemList filterNavigationDropdownItems = new DropdownItemList();
		
		List<DropdownItem> filterByScopeDropdownItemList = super.getFilterNavigationDropdownItems();
		DropdownGroupItem filterByScopeGroup = new DropdownGroupItem();
//		filterByScopeGroup.setLabel("Filter By Scope");
		filterByScopeGroup.setDropdownItems(filterByScopeDropdownItemList);
		filterNavigationDropdownItems.add(filterByScopeGroup);
		
		List<DropdownItem> filterByStatusDropdownItemList = getFilterByStatusDropdownItems();
		DropdownGroupItem filterByStatusGroup = new DropdownGroupItem();
		filterByStatusGroup.setLabel("Filter By Status");
		filterByStatusGroup.setDropdownItems(filterByStatusDropdownItemList);
		filterNavigationDropdownItems.add(filterByStatusGroup);
		
		return filterNavigationDropdownItems;
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
		return IcecapConstants.DATATYPE_SEARCH_CONTAINER_ID;
	}

	/*
	@Override
	public String getSearchFormMethod() {
//		System.out.println("----- Search Form Method: "+super.getSearchFormMethod());
		return "post";
	}
	*/

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
	
	private Boolean _getListable() {
		Boolean listable = null;

		String listableValue = ParamUtil.getString(
			super.liferayPortletRequest, StationXWebKeys.LISTABLE, null);

		if (Validator.isNotNull(listableValue)) {
			listable = ParamUtil.getBoolean(
					super.liferayPortletRequest, StationXWebKeys.LISTABLE, true);
		}

		return listable;
	}

}
