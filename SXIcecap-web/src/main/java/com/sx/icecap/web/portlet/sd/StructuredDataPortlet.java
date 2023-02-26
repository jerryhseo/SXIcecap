package com.sx.icecap.web.portlet.sd;

import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author jerry
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sx.icecap",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Structured Data Management",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + IcecapConstants.STRUCTURED_DATA_VIEW_TEMPLATE,
		"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class StructuredDataPortlet extends MVCPortlet {
}