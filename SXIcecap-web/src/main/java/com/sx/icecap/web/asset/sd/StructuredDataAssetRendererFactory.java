package com.sx.icecap.web.asset.sd;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.web.security.permission.resource.sd.StructuredDataModelPermissionHelper;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT
		},
		service = AssetRendererFactory.class
)
public class StructuredDataAssetRendererFactory extends BaseAssetRendererFactory<StructuredData> {
	
	@Reference(unbind = "-")
	protected void setStructuredDataLocalService(
			StructuredDataLocalService structuredDataLocalService) {
		System.out.println("===== StructuredDataLocalService referenced in RendererFactory ");
		_structuredDataLocalService = structuredDataLocalService;
	}
	private StructuredDataLocalService _structuredDataLocalService;
	
	@Reference(
			target = "(osgi.web.symbolicname="+IcecapConstants.ICECAP_WEB_BUNDLE_NAME+")", 
			unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}
	private ServletContext _servletContext;
	
	public static final String TYPE = "structuredData";
    private static final boolean _LINKABLE = true;

    private ModelResourcePermission<StructuredData> _structuredDataModelResourcePermission;

	public StructuredDataAssetRendererFactory() {
		super.setClassName(StructuredData.class.getName());
		super.setLinkable(true);
		super.setPortletId(IcecapWebPortletKeys.DATATYPE_MANAGEMENT);
		super.setSearchable(true);
		super.setSelectable(true);
	}

	@Override
	public AssetRenderer<StructuredData> getAssetRenderer(long structuredDataId, int type) throws PortalException {
		StructuredData structuredData = _structuredDataLocalService.getStructuredData(structuredDataId);

		StructuredDataAssetRenderer structuredDataAssetRenderer = 
				new StructuredDataAssetRenderer(structuredData, _structuredDataModelResourcePermission);

		structuredDataAssetRenderer.setAssetRendererType(type);
		structuredDataAssetRenderer.setServletContext(_servletContext);

		return structuredDataAssetRenderer;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getClassName() {
		return StructuredData.class.getName();
	}
	
	@Override
	public PortletURL getURLAdd (
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, 
			long classTypeId){
		
		PortletURL portletURL = null;
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			portletURL = liferayPortletResponse.createLiferayPortletURL(
					getControlPanelPlid(themeDisplay), 
					IcecapWebPortletKeys.DATATYPE_MANAGEMENT, 
					PortletRequest.RENDER_PHASE);
			portletURL.setParameter(
					StationXWebKeys.MVC_RENDER_COMMAND_NAME, 
					IcecapMVCCommands.RENDER_DATATYPE_EDIT);
			portletURL.setParameter(StationXWebKeys.SHOW_BACK, Boolean.FALSE.toString());
		}
		catch( PortalException e) {
		}

		return portletURL;
	}

	@Override
	public PortletURL getURLView(
			LiferayPortletResponse liferayPortletResponse,
			WindowState windowState) {

		LiferayPortletURL liferayPortletURL =
				liferayPortletResponse.createLiferayPortletURL(
						IcecapWebPortletKeys.DATATYPE_MANAGEMENT, 
						PortletRequest.RENDER_PHASE);

		try {
			liferayPortletURL.setWindowState(windowState);
		}
		catch (WindowStateException wse) {
		}

		return liferayPortletURL;
	}
	
	@Override
    public boolean isLinkable() {
        return _LINKABLE;
    }
	
	@Override
	public String getIconCssClass() {
	    return "structuredData";
	}
	
	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, 
			long classPK, 
			String actionId) throws Exception {

		return StructuredDataModelPermissionHelper.contains(
				permissionChecker, classPK, actionId);
	}
	
	
}
