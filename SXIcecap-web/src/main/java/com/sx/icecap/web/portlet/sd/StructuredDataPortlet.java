package com.sx.icecap.web.portlet.sd;

import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapWebPortletKeys;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author jerry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.sx.icecap",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Structured Data Management",
		"javax.portlet.init-param.template-path="+IcecapJsps.STRUCTURED_DATA_TERMPLATE_PATH,
		"javax.portlet.init-param.view-template=" + IcecapJsps.STRUCTURED_DATA_LIST_VIEW,
		"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StructuredDataPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		System.out.println("StructuredDataPortlet --- doView");
		
		Debug.printAllAttributes(renderRequest);
		
		super.doView(renderRequest, renderResponse);
	}
}