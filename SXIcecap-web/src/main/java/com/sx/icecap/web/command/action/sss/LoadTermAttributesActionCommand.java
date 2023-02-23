package com.sx.icecap.web.command.action.sss;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
				"mvc.command.name=" + IcecapSSSMVCCommands.ACTION_ADMIN_LOAD_TERM_ATTRIBURES
		},
		service = MVCActionCommand.class
)
public class LoadTermAttributesActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String termType = ParamUtil.getString(actionRequest, IcecapSSSTermAttributes.TERM_TYPE);
		String renderCommand = ParamUtil.getString(actionRequest, "mvcRenderCommandName");
		String termListViewURL = ParamUtil.getString(actionRequest, "termListViewURL" );
		
		System.out.println("Action termType: "+ termType);
		System.out.println("MVC Render Command: " + renderCommand);
		System.out.println("termListViewURL: " + termListViewURL);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		renderURL.setParameter(IcecapSSSTermAttributes.TERM_TYPE, termType);
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand);
		renderURL.setParameter(StationXWebKeys.REDIRECT, termListViewURL);
		
		System.out.println("Render URL: "+renderURL.toString());
		
		actionResponse.sendRedirect(renderURL.toString());
	}

}
