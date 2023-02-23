package com.sx.icecap.web.command.render.sss;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.debug.Debug;
import com.sx.icecap.service.TermLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_SEARCH_TERMS
	    },
	    service = MVCRenderCommand.class
	)
public class SearchTermsRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Debug.printHeader("SearchTermsRenderCommand");
		
		/*
		Enumeration<String> keys = renderRequest.getParameterNames();
		while( keys.hasMoreElements() ) {
			String key = keys.nextElement();
			System.out.println(key + ": "+ParamUtil.getString(renderRequest, key));
		}
		
		TermAdminDisplayContext termAdminDisplayContext = 
					new TermAdminDisplayContext(
												PortalUtil.getLiferayPortletRequest(renderRequest),
												PortalUtil.getLiferayPortletResponse(renderResponse),
												PortalUtil.getHttpServletRequest(renderRequest),
												_termLocalService,
												_trashHelper);
		
		TermAdminManagementToolbarDisplayContext termAdminManagementToolbarDisplayContext =
				new TermAdminManagementToolbarDisplayContext(
							renderRequest, 
							renderResponse, 
							termAdminDisplayContext
				);
		renderRequest.setAttribute(
				TermAdminManagementToolbarDisplayContext.class.getName(), 
				termAdminManagementToolbarDisplayContext );
		*/
		Debug.printFooter("SearchTermsRenderCommand");
		return IcecapJsps.ADMIN_TERM_LIST_JSP;
	}

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
	private TermLocalService _termLocalService;
}
