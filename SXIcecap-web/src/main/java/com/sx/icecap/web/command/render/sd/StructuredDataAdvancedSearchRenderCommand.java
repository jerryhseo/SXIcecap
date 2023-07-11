package com.sx.icecap.web.command.render.sd;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_ADVANCED_SEARCH
	    },
	    service = MVCRenderCommand.class
)
public class StructuredDataAdvancedSearchRenderCommand implements MVCRenderCommand {
	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	StructuredDataLocalService _structuredDataLocalService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID, 0);
		
		if( dataTypeId <= 0 ) {
			throw new PortletException( "A Data type ID is needed to edit or add a structured data..." );
		}

		DataType dataType = null;
		JSONObject dataStructure = null;
		try {
			dataType = _dataTypeLocalService.getDataType( dataTypeId );
			dataStructure = _dataTypeLocalService.getDataTypeStructureJSONObject(dataTypeId);
			renderRequest.setAttribute(IcecapWebKeys.DATATYPE, dataType);
			renderRequest.setAttribute(IcecapWebKeys.DATA_STRUCTURE, dataStructure);
		} catch (Exception e) {
			throw new PortletException( "Cannot find data type: " + dataTypeId );
		}

		return IcecapJsps.STRUCTURED_DATA_ADVANCED_SEARCH_VIEW;
	}
	
}
