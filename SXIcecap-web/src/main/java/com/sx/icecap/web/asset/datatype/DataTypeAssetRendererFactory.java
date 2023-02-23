package com.sx.icecap.web.asset.datatype;

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
import com.sx.icecap.web.security.permission.resource.datatype.DataTypeModelPermissionHelper;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapDataTypeMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

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
public class DataTypeAssetRendererFactory extends BaseAssetRendererFactory<DataType> {
	
	@Reference(unbind = "-")
	protected void setDataTypeLocalService(
			DataTypeLocalService dataTypeLocalService) {
		System.out.println("===== DataTypeLocalService referenced in RendererFactory ");
		_dataTypeLocalService = dataTypeLocalService;
	}
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference(
			target = "(osgi.web.symbolicname="+IcecapConstants.ICECAP_WEB_BUNDLE_NAME+")", 
			unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}
	private ServletContext _servletContext;
	
	public static final String TYPE = "dataType";
    private static final boolean _LINKABLE = true;

    private ModelResourcePermission<DataType> _dataTypeModelResourcePermission;

	public DataTypeAssetRendererFactory() {
		super.setClassName(DataType.class.getName());
		super.setLinkable(true);
		super.setPortletId(IcecapWebPortletKeys.DATATYPE_MANAGEMENT);
		super.setSearchable(true);
		super.setSelectable(true);
	}

	@Override
	public AssetRenderer<DataType> getAssetRenderer(long dataTypeId, int type) throws PortalException {
		DataType dataType = _dataTypeLocalService.getDataType(dataTypeId);

		DataTypeAssetRenderer dataTypeAssetRenderer = 
				new DataTypeAssetRenderer(dataType, _dataTypeModelResourcePermission);

		dataTypeAssetRenderer.setAssetRendererType(type);
		dataTypeAssetRenderer.setServletContext(_servletContext);

		return dataTypeAssetRenderer;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getClassName() {
		return DataType.class.getName();
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
					IcecapDataTypeMVCCommands.RENDER_DATATYPE_EDIT);
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
	    return "dataType";
	}
	
	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, 
			long classPK, 
			String actionId) throws Exception {

		return DataTypeModelPermissionHelper.contains(
				permissionChecker, classPK, actionId);
	}
	
	
}
