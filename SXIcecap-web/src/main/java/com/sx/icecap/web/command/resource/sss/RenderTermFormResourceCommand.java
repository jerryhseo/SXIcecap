package com.sx.icecap.web.command.resource.sss;

import com.liferay.portal.freemarker.FreeMarkerUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
	        "mvc.command.name="+IcecapSSSMVCCommands.RESOURCE_ADMIN_RENDER_TERM
	    },
	    service = MVCResourceCommand.class
	)
public class RenderTermFormResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		System.out.println("Render Term with FTL");
		
		Map<String, Object> context = new HashMap<>();
		
		Writer writer = null;;
		try {
			writer = resourceResponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
			
			throw new PortletException(e.getMessage()) ;
		}
		
		try {
			FreeMarkerUtil.process(
					"com/sx/icecap/sss/web/term/admin/templates" + "/string-attributes.ftl",
					context, writer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PortletException(e.getMessage()) ;
		}
		
		return false;
	}
	
}
