package com.sx.icecap.web.command.resource.datatype;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RESOURCE_DATATYPE_LOAD_STRUCTURE
	    },
	    service = MVCResourceCommand.class
)
public class LoadDataStructureResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, StationXWebKeys.DATATYPE_ID, 0);
		
		System.out.println("LoadDataStructureResourceCommand: " + dataTypeId );
		
		PrintWriter pw = resourceResponse.getWriter();
		JSONObject result = JSONFactoryUtil.createJSONObject();
		try {
			JSONObject dataStructure = _dataTypeLocalService.getDataTypeStructureJSONObject( dataTypeId );
			result.put("dataStructure", dataStructure);
			JSONArray datas = _dataTypeLocalService.getStructuredDatasJSON( dataTypeId );
			result.put("data", datas);
		} catch( PortalException e ) {
			result.put( "error", "Failed to read data: "+dataTypeId );
		} finally {
			pw.write(result.toString());
			pw.flush();
			pw.close();
		}
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
}
