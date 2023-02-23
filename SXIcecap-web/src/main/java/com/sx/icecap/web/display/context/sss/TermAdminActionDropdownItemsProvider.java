package com.sx.icecap.web.display.context.sss;

import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.configuration.kernel.util.PortletConfigurationApplicationType;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.Term;
import com.sx.icecap.web.security.permission.resource.sss.TermModelPermissionHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.MutableRenderParameters;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

public class TermAdminActionDropdownItemsProvider {
	public TermAdminActionDropdownItemsProvider(
			Term term, 
			RenderRequest renderRequest,
			RenderResponse renderResponse, 
			PermissionChecker permissionChecker) {

		_term = term;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_liferayPortletRequest = PortalUtil.getLiferayPortletRequest(renderRequest);
		_liferayPortletResponse = PortalUtil.getLiferayPortletResponse(renderResponse);
		_locale = renderRequest.getLocale();
		_permissionChecker = permissionChecker;

		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}

	public List<DropdownItem> getActionDropdownItems() {
		System.out.println(" getActionDropdownItems().........");
		return new DropdownItemList() {
			{
				if (_hasUpdatePermission()) {
					add(_getEditEntryActionUnsafeConsumer());
				}

				if (_hasDeletePermission()) {
//					if (_isTrashEnabled()) {
//						add(_getMoveEntryToTrashActionUnsafeConsumer());
//					}
//					else {
//						add(_getDeleteEntryActionUnsafeConsumer());
//					}
					add(_getDeleteEntryActionUnsafeConsumer());
				}
			}
		};
	}
	
	private static boolean _isShowPublishMenuItem(	Group group, String portletId) {

		try {
			if (group.isLayout()) {
				return false;
			}

			if ((group.isStagingGroup() || group.isStagedRemotely()) &&
				group.isStagedPortlet(portletId)) {

				return true;
			}

			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	private static boolean _isShowPublishMenuItem(
		Group group, String portletId, String className, String uuid) {

		try {
			StagedModelDataHandler stagedModelDataHandler =
				StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(className);

			StagedModel stagedModel =
				stagedModelDataHandler.fetchStagedModelByUuidAndGroupId(uuid, group.getGroupId());

			if (stagedModel == null) {
				return false;
			}

			if (stagedModel instanceof WorkflowedModel) {
				WorkflowedModel workflowedModel = (WorkflowedModel)stagedModel;

				if (!ArrayUtil.contains(
						stagedModelDataHandler.getExportableStatuses(),
						workflowedModel.getStatus())) {

					return false;
				}
			}

			return _isShowPublishMenuItem(group, portletId);
		}
		catch (Exception e) {
			return false;
		}
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getDeleteEntryActionUnsafeConsumer() {

		PortletURL deleteURL =  _liferayPortletResponse.createActionURL();
		
		long[] termIds = { _term.getTermId()};
//		deleteURL.setParameter(IcecapSSSWebKeys.MVC_ACTION_COMMAND_NAME, MVCCommandNames.ACTION_TERM_DELETE);
		deleteURL.setParameter(ActionRequest.ACTION_NAME, IcecapSSSMVCCommands.ACTION_ADMIN_TERM_DELETE);
		deleteURL.setParameter(Constants.CMD, Constants.DELETE);
		deleteURL.setParameter(StationXWebKeys.REDIRECT, _getRedirectURL());
		deleteURL.setParameter(StationXWebKeys.TERM_IDS, Arrays.toString(termIds) );
		
		System.out.println("deleteURL: "+deleteURL.toString());

		return dropdownItem -> {
			dropdownItem.setHref(deleteURL);
			dropdownItem.setIcon("delete");
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getEditEntryActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.setHref(
				_renderResponse.createRenderURL(), 
				StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT, 
				Constants.CMD, Constants.UPDATE,
				StationXWebKeys.REDIRECT, _getRedirectURL(), 
				IcecapSSSTermAttributes.TERM_ID, _term.getTermId());

			dropdownItem.setIcon("edit");
			dropdownItem.setLabel(LanguageUtil.get(_locale, "edit"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getMoveEntryToTrashActionUnsafeConsumer() {

		ActionURL moveToTrashURL = _renderResponse.createActionURL();

		moveToTrashURL.setParameter(
					ActionRequest.ACTION_NAME, IcecapSSSMVCCommands.ACTION_ADMIN_TERM_DELETE);
		moveToTrashURL.setParameter(Constants.CMD, Constants.MOVE_TO_TRASH);
		moveToTrashURL.setParameter(StationXWebKeys.REDIRECT, _getRedirectURL());
		moveToTrashURL.setParameter(IcecapSSSTermAttributes.TERM_ID, String.valueOf(_term.getTermId()));

		return dropdownItem -> {
			dropdownItem.setHref(moveToTrashURL);
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "move-to-recycle-bin"));
		};
	}

	private UnsafeConsumer<DropdownItem, Exception>
		_getPermissionsActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.putData("action", "permissions");
			dropdownItem.putData("permissionsURL", _getPermissionsURL());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "permissions"));
		};
	}
	
	private String _getPermissionsURL() {
		ThemeDisplay themeDisplay =
				(ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			return doTag(
					StringPool.BLANK, 
					Term.class.getName(),
					_term.getDisplayName(themeDisplay.getLocale()),
					null, 
					String.valueOf(_term.getTermId()),
					LiferayWindowState.POP_UP.toString(), 
					null,
					_httpServletRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private  String doTag(
			String redirect, String modelResource,
			String modelResourceDescription, Object resourceGroupId,
			String resourcePrimKey, String windowState, int[] roleTypes,
			HttpServletRequest httpServletRequest)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (resourceGroupId instanceof Number) {
			Number resourceGroupIdNumber = (Number)resourceGroupId;

			if (resourceGroupIdNumber.longValue() < 0) {
				resourceGroupId = null;
			}
		}
		else if (resourceGroupId instanceof String) {
			String esourceGroupIdString = (String)resourceGroupId;

			if (esourceGroupIdString.length() == 0) {
				resourceGroupId = null;
			}
		}

		if (resourceGroupId == null) {
			resourceGroupId = String.valueOf(themeDisplay.getScopeGroupId());
		}

		if (Validator.isNull(redirect) &&
			(Validator.isNull(windowState) ||
			 !windowState.equals(LiferayWindowState.POP_UP.toString()))) {

			redirect = PortalUtil.getCurrentURL(httpServletRequest);
		}

		PortletURL portletURL = PortletProviderUtil.getPortletURL(
			httpServletRequest,
			PortletConfigurationApplicationType.PortletConfiguration.CLASS_NAME,
			PortletProvider.Action.VIEW);
		MutableRenderParameters renderParameters = portletURL.getRenderParameters();

		if (Validator.isNotNull(windowState)) {
			portletURL.setWindowState(
				WindowStateFactory.getWindowState(windowState));
		}
		else if (themeDisplay.isStatePopUp()) {
			portletURL.setWindowState(LiferayWindowState.POP_UP);
		}
		else {
			portletURL.setWindowState(WindowState.MAXIMIZED);
		}

		portletURL.setParameter("mvcPath", "/edit_permissions.jsp");

		if (Validator.isNotNull(redirect)) {
			portletURL.setParameter(StationXWebKeys.REDIRECT, redirect);

			if (!themeDisplay.isStateMaximized()) {
				portletURL.setParameter("returnToFullPageURL", redirect);
			}
		}

		portletURL.setParameter("portletConfiguration", Boolean.TRUE.toString());

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		portletURL.setParameter("portletResource", portletDisplay.getId());

		portletURL.setParameter("modelResource", modelResource);
		portletURL.setParameter(
			"modelResourceDescription", modelResourceDescription);
		portletURL.setParameter(
			"resourceGroupId", String.valueOf(resourceGroupId));
		portletURL.setParameter("resourcePrimKey", resourcePrimKey);

		if (roleTypes != null) {
			portletURL.setParameter("roleTypes", StringUtil.merge(roleTypes));
		}

		return portletURL.toString();
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
		_getPublishToLiveEntryActionUnsafeConsumer() {

		ActionURL publishEntryURL = _renderResponse.createActionURL();

		publishEntryURL.setParameter(
				ActionRequest.ACTION_NAME, IcecapSSSMVCCommands.ACTION_ADMIN_TERM_PUBLISH);
		publishEntryURL.setParameter(StationXWebKeys.BACK_URL, _getRedirectURL());
		publishEntryURL.setParameter(
				IcecapSSSTermAttributes.TERM_ID, String.valueOf(_term.getTermId()));

		return dropdownItem -> {
			dropdownItem.putData("action", "publishToLive");
			dropdownItem.putData("publishEntryURL", publishEntryURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "publish-to-live"));
		};
	}

	private String _getRedirectURL() {
		PortletURL redirectURL = _renderResponse.createRenderURL();

		redirectURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST);

		return redirectURL.toString();
	}

	private boolean _hasDeletePermission() {
		boolean hasPermission = false;
		try {
			hasPermission = TermModelPermissionHelper.contains(
						_permissionChecker, _term, ActionKeys.DELETE);
			System.out.println("Delete Permission: "+hasPermission);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasPermission;
	}

	private boolean _hasExportImportPortletInfoPermission() {
		boolean hasPermission = false;
		try {
			hasPermission = GroupPermissionUtil.contains(
				_permissionChecker, _term.getGroupId(),
				ActionKeys.EXPORT_IMPORT_PORTLET_INFO);
			System.out.println("ExportImportPortletInfo Permission: "+hasPermission);
		}
		catch (PortalException pe) {
			pe.printStackTrace();
		}
		
		return hasPermission;
	}

	private boolean _hasPermissionsPermission() {
		boolean hasPermission = false;
		try {
			hasPermission = TermModelPermissionHelper.contains(
				_permissionChecker, _term, ActionKeys.PERMISSIONS);
			System.out.println("Permissions Permission: "+hasPermission);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return hasPermission;
	}

	private boolean _hasUpdatePermission() {
		boolean hasPermission = false;
		try {
			hasPermission = TermModelPermissionHelper.contains(
				_permissionChecker, _term, ActionKeys.UPDATE);
			System.out.println("Update Permission: "+hasPermission);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hasPermission;
	}

	private boolean _isShowPublishMenuItem() {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return _isShowPublishMenuItem(
			themeDisplay.getScopeGroup(), IcecapWebPortletKeys.TERM_ADMIN,
			Term.class.getName(), _term.getUuid());
	}

	private final Term _term;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final Locale _locale;
}
