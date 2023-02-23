package com.sx.icecap.web.command.render.sss;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
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
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_TERM_DELETE
	    },
	    service = MVCRenderCommand.class
	)
public class DeleteTermRenderCommand implements MVCRenderCommand {

	public String render( 
			RenderRequest renderRequest, 
			RenderResponse renderResponse) throws PortletException {
		
		System.out.println("DELETE RENDER COMMAND");
		
		return IcecapJsps.ADMIN_TERM_LIST_JSP;
	}
	
	@Reference
	private volatile TermLocalService _termLocalService;
}
