package com.sx.icecap.web.asset.sss;

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
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapAssetRendererPaths;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.Term;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TermAssetRenderer extends BaseJSPAssetRenderer<Term> {

	private final ModelResourcePermission<Term> _termModelResourcePermission;
    private Term _term;
    
    public TermAssetRenderer( Term term, ModelResourcePermission<Term> modelResoucePermission ) {
    	_term = term;
    	_termModelResourcePermission = modelResoucePermission;
    }

	@Override
	public Term getAssetObject() {
		return _term;
	}

	@Override
	public long getGroupId() {
		return _term.getGroupId();
	}

	@Override
	public long getUserId() {
		return _term.getUserId();
	}

	@Override
	public String getUserName() {
		return _term.getUserName();
	}

	@Override
	public String getUuid() {
		return _term.getUuid();
	}

	@Override
	public String getClassName() {
		return Term.class.getName();
	}

	@Override
	public long getClassPK() {
		return _term.getTermId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		return _term.getDefinition(locale);
	}

	@Override
	public String getTitle(Locale locale) {
		return _term.getDisplayTitle(locale);
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		if( template.equals(TEMPLATE_FULL_CONTENT) || 
			template.equals(TEMPLATE_ABSTRACT )) {
			
			httpServletRequest.setAttribute(StationXWebKeys.TERM, _term);
			
			return IcecapAssetRendererPaths.ADMIN_TERM_ASSET_RENDERER_PATH + "/" + template + ".jsp";
		}
		return null;
	}

	@Override
	public boolean include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String template) throws Exception {
		httpServletRequest.setAttribute(StationXWebKeys.TERM, _term);
		httpServletRequest.setAttribute(StationXWebKeys.HTML_UTIL, HtmlUtil.getHtml());
		httpServletRequest.setAttribute(StationXWebKeys.STRING_UTIL, new StringUtil());
		return super.include(httpServletRequest, httpServletResponse, template);
	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), IcecapWebPortletKeys.TERM_ADMIN,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter(StationXWebKeys.MVC_PATH, IcecapJsps.ADMIN_EDIT_TERM_JSP);
        portletURL.setParameter(StationXWebKeys.TERM_ID, String.valueOf(_term.getTermId()));
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
            		_term.getGroupId(),
                    IcecapWebPortletKeys.TERM_ADMIN);

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                		getControlPanelPlid(liferayPortletRequest),
                		IcecapWebPortletKeys.TERM_ADMIN, 
                		PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(
                		liferayPortletRequest,
                		IcecapWebPortletKeys.TERM_ADMIN, 
                		plid, 
                		PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter(StationXWebKeys.MVC_PATH, IcecapJsps.ADMIN_VIEW_TERM_JSP);
            portletURL.setParameter(StationXWebKeys.TERM_ID, String.valueOf(_term.getTermId()));

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
