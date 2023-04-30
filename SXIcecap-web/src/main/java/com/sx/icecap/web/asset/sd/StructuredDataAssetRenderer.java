package com.sx.icecap.web.asset.sd;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.StructuredData;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StructuredDataAssetRenderer extends BaseJSPAssetRenderer<StructuredData> {

	private final ModelResourcePermission<StructuredData> _structuredDataModelResourcePermission;
    private StructuredData _structuredData;
    
    public StructuredDataAssetRenderer( StructuredData structuredData, ModelResourcePermission<StructuredData> modelResoucePermission ) {
    	_structuredData = structuredData;
    	_structuredDataModelResourcePermission = modelResoucePermission;
    }

	@Override
	public StructuredData getAssetObject() {
		return _structuredData;
	}

	@Override
	public long getGroupId() {
		return _structuredData.getGroupId();
	}

	@Override
	public long getUserId() {
		return _structuredData.getUserId();
	}

	@Override
	public String getUserName() {
		return _structuredData.getUserName();
	}

	@Override
	public String getUuid() {
		return _structuredData.getUuid();
	}

	@Override
	public String getClassName() {
		return StructuredData.class.getName();
	}

	@Override
	public long getClassPK() {
		return _structuredData.getStructuredDataId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		return _structuredData.getDataSetDisplayName( themeDisplay.getLocale() );
	}

	@Override
	public String getTitle(Locale locale) {
		return _structuredData.getDataSetDisplayName( locale );
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		if( template.equals(TEMPLATE_FULL_CONTENT) || 
			template.equals(TEMPLATE_ABSTRACT )) {
			
			httpServletRequest.setAttribute(StationXWebKeys.DATATYPE, _structuredData);
			
			return IcecapJsps.STRUCTURED_DATA_TERMPLATE_PATH + template + ".jsp";
		}
		return null;
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		httpServletRequest.setAttribute(StationXWebKeys.DATATYPE, _structuredData);
		httpServletRequest.setAttribute(StationXWebKeys.HTML_UTIL, HtmlUtil.getHtml());
		httpServletRequest.setAttribute(StationXWebKeys.STRING_UTIL, new StringUtil());
		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_EDIT);
        portletURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_structuredData.getStructuredDataId()));
        portletURL.setParameter(StationXWebKeys.SHOW_BACK, Boolean.FALSE.toString());
        
        return portletURL;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		return super.getURLView(liferayPortletResponse, windowState);
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		try {
            long plid = PortalUtil.getPlidFromPortletId(
            		_structuredData.getGroupId(),
                    IcecapWebPortletKeys.DATATYPE_MANAGEMENT);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                		getControlPanelPlid(liferayPortletRequest),
                		IcecapWebPortletKeys.DATATYPE_MANAGEMENT, 
                		PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(
                		liferayPortletRequest,
                		IcecapWebPortletKeys.DATATYPE_MANAGEMENT, 
                		plid, 
                		PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_VIEW);
            portletURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(_structuredData.getStructuredDataId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter(StationXWebKeys.REDIRECT, currentUrl);

            return portletURL.toString();

        } catch (PortalException e) {

        } catch (SystemException e) {
        }

        return noSuchEntryRedirect;
    }

	@Override
	public boolean isPrintable() {
		return true;
	}
    
    
}
