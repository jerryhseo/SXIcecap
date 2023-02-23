package com.sx.icecap.web.command.action.sss;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.trash.TrashHelper;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.TermLocalService;
import com.sx.icecap.web.display.context.sss.TermAdminDisplayContext;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse.Copy;
import javax.portlet.RenderURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
				"mvc.command.name=" + IcecapSSSMVCCommands.ACTION_ADMIN_SEARCH_TERMS
		},
		service = MVCActionCommand.class
)
public class SearchTermsActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

//		System.out.println("SearchTermsActionCommand.doProcessAction");
		
		TermAdminDisplayContext termAdminDisplayContext = 
				new TermAdminDisplayContext(
				PortalUtil.getLiferayPortletRequest(actionRequest),
				PortalUtil.getLiferayPortletResponse(actionResponse),
				PortalUtil.getHttpServletRequest(actionRequest),
				_termLocalService,
				_trashHelper );

		actionRequest.setAttribute(TermAdminDisplayContext.class.getName(), termAdminDisplayContext);
		
		RenderURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		renderURL.setParameter(
				StationXWebKeys.MVC_RENDER_COMMAND_NAME, 
				IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST);
		
		actionResponse.sendRedirect(renderURL.toString());
		
	}

	@Reference
	private TermLocalService _termLocalService;
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
}
