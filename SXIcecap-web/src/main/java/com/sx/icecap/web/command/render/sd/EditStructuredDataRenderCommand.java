package com.sx.icecap.web.command.render.sd;

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

import java.util.Arrays;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT
	    },
	    service = MVCRenderCommand.class
)
public class EditStructuredDataRenderCommand implements MVCRenderCommand {
	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	StructuredDataLocalService _structuredDataLocalService;
	

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(renderRequest, IcecapWebKeys.STRUCTURED_DATA_ID, 0);
		
		if( dataTypeId <= 0 ) {
			throw new PortletException( "A Data type ID is needed to edit or add a structured data..." );
		}

		DataType dataType = null;
		try {
			dataType = _dataTypeLocalService.getDataType( dataTypeId );
			renderRequest.setAttribute(DataType.class.getName(), dataType);
		} catch (Exception e) {
			throw new PortletException( "Cannot find data type: " + dataTypeId );
		}

		JSONObject jsonData = getStructuredDataWithValues(dataTypeId, structuredDataId);
		
		if( structuredDataId <= 0 ) {
			renderRequest.setAttribute( StationXWebKeys.CMD, StationXConstants.CMD_ADD );
			renderRequest.setAttribute( IcecapWebKeys.STRUCTURED_DATA_ID, "0" );
		}
		else {
			renderRequest.setAttribute(StationXWebKeys.CMD, StationXConstants.CMD_UPDATE);
			renderRequest.setAttribute( IcecapWebKeys.STRUCTURED_DATA_ID, String.valueOf(structuredDataId) );
		}
		renderRequest.setAttribute(IcecapWebKeys.STRUCTURED_DATA_JSON_OBJECT, jsonData);
		
		return IcecapJsps.STRUCTURED_DATA_EDIT;
	}
	
	private JSONObject getStructuredDataWithValues( 
			long dataTypeId, long structuredDataId ) throws PortletException  {
//		DataType dataType = super.dataTypePersistence.fetchByPrimaryKey(dataTypeId);
		DataType dataType = null;
		try {
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
		} catch (Exception e) {
			throw new PortletException("Cannot find the data type: " + dataTypeId);
		}
		
		String dataStructure = _dataTypeLocalService.getDataTypeStructure( dataTypeId ); 
		
		JSONObject jsonData = null;
		try {
			jsonData = JSONFactoryUtil.createJSONObject( dataStructure );
		} catch (Exception e) {
			throw new PortletException("Cannot create JSONObject: " + dataStructure);
		}
		
		if( structuredDataId > 0 ) {
			StructuredData structuredData = null;
			try {
				structuredData = 
						_structuredDataLocalService.getStructuredData(structuredDataId);
			} catch (Exception e) {
				throw new PortletException("Cannot find data structure: " + structuredDataId);
			}
			
			jsonData = setStructuredDataValues( jsonData, structuredData.getStructuredData() );
		}
		
		return jsonData;
	}
	
	private JSONObject setStructuredDataValues( 
			JSONObject dataStructure, String structuredData ){
		
		String termDelimiter = dataStructure.getString(IcecapDataTypeAttributes.TERM_DELIMITER);
		
		System.out.println("Term Delimiter: " + termDelimiter);
		String[] lines = structuredData.split(termDelimiter);
		
		System.out.println("Line count: " + lines.length);
		
		Arrays.stream(lines).forEach(line->{
			line = line.trim();
			System.out.println("Line: [" + line + "]" );
			
			String valueDelimiter = dataStructure.getString(IcecapDataTypeAttributes.TERM_VALUE_DELIMITER);
			System.out.println("Value Delimiter: " + valueDelimiter);
			
			if( ! line.isEmpty() ) {
				String[] tokens = line.split(valueDelimiter);
				tokens = Arrays.stream(tokens).filter(token -> token.trim().isEmpty() ).toArray(String[]::new);
				
				System.out.println("Tokens length: " + tokens.length);
				System.out.println("Key: " + tokens[0] + ", Value: "+tokens[1]);
			}
			
		});
		
		return dataStructure;
	}
}
