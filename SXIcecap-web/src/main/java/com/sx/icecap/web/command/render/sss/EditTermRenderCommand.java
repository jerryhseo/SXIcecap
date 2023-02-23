package com.sx.icecap.web.command.render.sss;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.Term;
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
	        "mvc.command.name="+IcecapSSSMVCCommands.RENDER_ADMIN_TERM_EDIT
	    },
	    service = MVCRenderCommand.class
	)
public class EditTermRenderCommand implements MVCRenderCommand {

	public String render( 
			RenderRequest renderRequest, 
			RenderResponse renderResponse) throws PortletException {
		
		long termId = ParamUtil.getLong(renderRequest, StationXWebKeys.TERM_ID, 0);
		
		if( termId > 0 ) {
			System.out.println("Term ID: "+termId);
			try {
				Term term = _termLocalService.getTerm(termId);
				
				renderRequest.setAttribute(StationXWebKeys.TERM, term);
			}
			catch( PortalException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Term Creation Mode!!!");
//			String termType = ParamUtil.getString(renderRequest, StationXWebKeys.TERM_TYPE);
//			System.out.println("In Edit Render: termType - " + termType );
		}
		
//		Debug.printAllParameters(renderRequest);
		
		return IcecapJsps.ADMIN_EDIT_TERM_JSP;
	}
	
	@Reference
	private volatile TermLocalService _termLocalService;
}
