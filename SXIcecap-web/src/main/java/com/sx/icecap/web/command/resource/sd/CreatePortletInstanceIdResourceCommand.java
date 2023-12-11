package com.sx.icecap.web.command.resource.sd;

import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.util.SXPortalUtil;
import com.sx.util.portlet.SXPortletURLUtil;

import java.io.PrintWriter;

import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "mvc.command.name="+IcecapMVCCommands.RESOURCE_CREATE_PORTLET_INSTANCE
	    },
	    service = MVCResourceCommand.class
)
public class CreatePortletInstanceIdResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		String portletName = ParamUtil.getString(resourceRequest, "portletName");
		final String instance = "_INSTANCE_";

		String portletInstanceId = SXPortalUtil.generatePortletInstanceId();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String portletURL = SXPortletURLUtil.createURL(
				resourceRequest, 
				themeDisplay, 
				portletName+instance+portletInstanceId,
				null,
				LiferayPortletMode.VIEW,
				LiferayWindowState.EXCLUSIVE );
		 
		PrintWriter pw = resourceResponse.getWriter();
		pw.write(portletURL);
		pw.flush();
		pw.close();
	}
}
