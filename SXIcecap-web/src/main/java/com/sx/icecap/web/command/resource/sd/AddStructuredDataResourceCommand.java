package com.sx.icecap.web.command.resource.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RESOURCE_STRUCTURED_DATA_ADD_SAMPLE
	    },
	    service = MVCResourceCommand.class
)
public class AddStructuredDataResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, "dataTypeId");
		String sampleData = ParamUtil.getString(resourceRequest, "sampleData");
		
		System.out.println( "Sample data: " + sampleData);
		
		ServiceContext sc = ServiceContextFactory.getInstance(StructuredData.class.getName(), resourceRequest);
//		System.out.println("Created date: " + sc.getCreateDate().toString());
//		System.out.println("Modified date: " + sc.getModifiedDate().toString());

		PrintWriter pw = resourceResponse.getWriter();
		try {
			_dataTypeLocalService.addStructuredData(dataTypeId, dataTypeId, sampleData, WorkflowConstants.STATUS_APPROVED, sc);
			pw.write("sample data added successfully....");
		} catch( PortalException e ) {
			pw.write("Failed to add sample data...." + sampleData);
		} finally {
			pw.flush();
			pw.close();
		}
		
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
}
