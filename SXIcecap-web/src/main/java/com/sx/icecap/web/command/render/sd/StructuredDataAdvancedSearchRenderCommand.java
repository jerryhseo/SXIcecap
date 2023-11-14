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
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.List;
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
		System.out.println("StructuredDataListRenderCommand.render()");
		String strAdvancedQuery = ParamUtil.getString(renderRequest, IcecapWebKeys.STRUCTURED_DATA_QUERY, "");
		System.out.println("SD Advanced SearchQuery: " + strAdvancedQuery);
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID );
		
		System.out.println("datatype id: "+dataTypeId);
		String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL );
		System.out.println("backURL: "+backURL);
		
		try {
			DataType dataType = _dataTypeLocalService.getDataType( dataTypeId );
			JSONObject dataStructure = _dataTypeLocalService.getDataTypeStructureJSONObject(dataTypeId);
			
			List<StructuredData> dataList = _dataTypeLocalService.getStructuredDatas(dataTypeId);
			
			JSONArray structuredDataList = JSONFactoryUtil.createJSONArray();
			for( int i=0; i<dataList.size(); i++ ) {
				StructuredData structuredData = dataList.get(i);
				JSONObject jsonData = JSONFactoryUtil.createJSONObject();
				jsonData.put("id", structuredData.getPrimaryKey() );
				jsonData.put("data", JSONFactoryUtil.createJSONObject(structuredData.getStructuredData()) );
				structuredDataList.put( jsonData );
			}
			
			List<String> abstractFieldList = _dataTypeLocalService.getAbstractFields( dataTypeId, true );
			JSONArray jsonAbstractFields = JSONFactoryUtil.createJSONArray();
			abstractFieldList.forEach(abstractField ->{
				jsonAbstractFields.put(abstractField);
			});
			
			renderRequest.setAttribute(
					StationXWebKeys.DATATYPE, 
					dataType );
			renderRequest.setAttribute(
					IcecapWebKeys.DATA_STRUCTURE, 
					dataStructure );
			renderRequest.setAttribute(
					StationXWebKeys.ABSTRACT_FIELDS, 
					jsonAbstractFields );
			renderRequest.setAttribute(
					"structuredDataList",
					structuredDataList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return IcecapJsps.STRUCTURED_DATA_ADVANCED_SEARCH_VIEW;
	}
	
}
