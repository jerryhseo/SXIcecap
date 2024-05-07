package com.sx.icecap.constant;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author selab-ryu
 */
public class IcecapWebPortletKeys {

	public static final String TERM_ADMIN = "com_sx_icecap_web_portlet_sss_TermAdminPortlet";
	public static final String DATATYPE_MANAGEMENT = "com_sx_icecap_web_portlet_datatype_DataTypeManagementPortlet";
	public static final String STRUCTURED_DATA = "com_sx_icecap_web_portlet_sd_StructuredDataPortlet";
	public static final String QUERY_EDITOR_PORTLET = "com_sx_icecap_web_portlet_QueryEditorPortlet";
	
	
	public static final String getNamespace( String portletKey, String instanceId ) {
		if( Validator.isNotNull(instanceId) && !instanceId.isEmpty() ) {
			return "_"+portletKey+"_INSTANCE_"+instanceId+"_";
		}
		else {
			return "_"+portletKey+"_";
		}
	}
}