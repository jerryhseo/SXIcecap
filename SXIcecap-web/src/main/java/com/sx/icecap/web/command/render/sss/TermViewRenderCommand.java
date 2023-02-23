package com.sx.icecap.web.command.render.sss;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_TERM_VIEW
	    },
	    service = MVCRenderCommand.class
	)
public class TermViewRenderCommand implements MVCRenderCommand {
	
	@Reference
	TermLocalService _termLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long termId = ParamUtil.getLong(renderRequest, "termId");
		
		Term term = null;
		try {
			term =  _termLocalService.getTerm(termId);
		} catch(  PortalException pe ) {
			pe.printStackTrace();
			throw new PortletException("Cannot find term by id: "+termId);
		}
		
		List<Term> history = _termLocalService.getTermsByName(term.getTermName());
		
		renderRequest.setAttribute("term", term);
		renderRequest.setAttribute("termHistory", history);
		
		return IcecapJsps.ADMIN_VIEW_TERM_JSP;
	}
}
