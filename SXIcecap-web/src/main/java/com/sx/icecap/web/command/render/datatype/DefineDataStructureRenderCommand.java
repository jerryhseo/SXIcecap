package com.sx.icecap.web.command.render.datatype;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_DEFINE_DATA_STRUCTURE
	    },
	    service = MVCRenderCommand.class
)
public class DefineDataStructureRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID);
		
		
		if( dataTypeId <= 0 ) {
			throw new PortletException("A data type should be specified!");
		}
			
		DataType dataType = null;
			
		try {
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
			renderRequest.setAttribute(StationXWebKeys.DATATYPE, dataType);
		} catch (Exception e) {
			throw new PortletException( "Cannot find data type: " + dataTypeId );
		}
		
		if( dataType.getHasDataStructure() ) {
			String strDataStructure = _dataTypeLocalService.getDataTypeStructure(dataTypeId);

			JSONObject jsonDataStructure = null;
			try{
				jsonDataStructure = JSONFactoryUtil.createJSONObject(strDataStructure);
			} catch( JSONException e ) {
				throw new PortletException(e.getMessage());
			}
			
			renderRequest.setAttribute(StationXWebKeys.DATA_STRUCTURE, jsonDataStructure);
		}

		return IcecapConstants.JSP_DATATYPE_DEFINE_STRUTURE;
	}

	@Reference
	DataTypeLocalService _dataTypeLocalService;
}
