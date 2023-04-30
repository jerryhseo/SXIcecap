package com.sx.icecap.web.portlet.datatype;

import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
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
		"javax.portlet.display-name=DataType Management",
		"javax.portlet.init-param.template-path="+IcecapJsps.DATATYPE_MANAGEMENT_TERMPLATE_PATH,
		"javax.portlet.init-param.view-template=" + IcecapJsps.DATATYPE_LIST,
		"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class DataTypeManagementPortlet extends MVCPortlet {
}