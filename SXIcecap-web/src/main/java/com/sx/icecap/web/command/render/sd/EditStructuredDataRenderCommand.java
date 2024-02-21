package com.sx.icecap.web.command.render.sd;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.documentlibrary.constants.DLConstants;
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
import com.sx.util.SXPortalUtil;

import java.util.Iterator;
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
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT
	    },
	    service = MVCRenderCommand.class
)
public class EditStructuredDataRenderCommand implements MVCRenderCommand {
	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	StructuredDataLocalService _structuredDataLocalService;
	
	@Reference
	DLAppService _dlAppService;
	
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
		
		JSONObject jsonData = null;
		try {
			jsonData = _dataTypeLocalService.getStructuredDataWithValues(dataTypeId, structuredDataId);
		} catch (Exception e) {
			throw new PortletException( e.getMessage() );
		}
		
		if( structuredDataId <= 0 ) {
			renderRequest.setAttribute( StationXWebKeys.CMD, StationXConstants.CMD_ADD );
		}
		else {
			renderRequest.setAttribute(StationXWebKeys.CMD, StationXConstants.CMD_UPDATE);
		}
		
		renderRequest.setAttribute(IcecapWebKeys.STRUCTURED_DATA_JSON_OBJECT, jsonData);
		
		return IcecapJsps.STRUCTURED_DATA_EDIT;
	}
	
	private JSONObject _getStructuredDataWithValues( 
			long dataTypeId, long structuredDataId ) throws PortletException  {
		DataType dataType = null;
		try {
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
		} catch (Exception e) {
			throw new PortletException("Cannot find the data type: " + dataTypeId);
		}
		
		
		JSONObject jsonData = null;
		try {
			String dataStructure = _dataTypeLocalService.getDataTypeStructure( dataTypeId ); 
			jsonData = JSONFactoryUtil.createJSONObject( dataStructure );
		} catch (Exception e) {
			throw new PortletException("Cannot create JSONObject: ");
		}
		
		if( structuredDataId > 0 ) {
			StructuredData structuredData = null;
			try {
				structuredData = 
						_structuredDataLocalService.getStructuredData(structuredDataId);
			} catch (Exception e) {
				throw new PortletException("Cannot find data structure: " + structuredDataId);
			}
			
			jsonData = _setStructuredDataValues( jsonData, structuredData.getStructuredData() );
		}
		
		return jsonData;
	}
	
	private JSONObject _setStructuredDataValues( 
			JSONObject dataStructure, String structuredData ){
		
		String valueDelimiter = dataStructure.getString(IcecapDataTypeAttributes.TERM_VALUE_DELIMITER);

		JSONObject jsonData = null;
		try {
			jsonData = JSONFactoryUtil.createJSONObject(structuredData);
		} 
		catch( Exception e ) {
			e.printStackTrace();
			return null;
		}
		
		JSONArray terms = dataStructure.getJSONArray("terms");
		JSONArray valuedTerms = JSONFactoryUtil.createJSONArray();
		Set<String> keySet = jsonData.keySet();
		for( int i=0; i<terms.length(); i++ ) {
			JSONObject term = terms.getJSONObject(i);
			String termName = term.getString("termName");
			if( keySet.contains( termName ) ) {
				String termType = term.getString("termType");
				if( termType.equalsIgnoreCase("List") ) {
					term.put("value", jsonData.getJSONArray(termName) );
				}
				else if( termType.equalsIgnoreCase("File") ) {
					JSONObject folderInfo = jsonData.getJSONObject(termName);
					if( Validator.isNull(folderInfo) ) {
						System.out.println("Term "+termName+" has no folder information");
					}
					else if( folderInfo.length() == 0 ){
						System.out.println("Term "+termName+" has empty information.");
					}
					else {
						List<FileEntry> fileEntries = null;
						try {
							fileEntries = _dlAppService.getFileEntries( folderInfo.getLong("repositoryId"), folderInfo.getLong("folderId") );
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						JSONObject value = JSONFactoryUtil.createJSONObject();
						for( FileEntry fileEntry : fileEntries ) {
							JSONObject fileInfo = JSONFactoryUtil.createJSONObject();
							fileInfo.put("parentFolderId", fileEntry.getFolderId() );
							fileInfo.put("fileId", fileEntry.getFileEntryId() );
							fileInfo.put("name", fileEntry.getFileName() );
							fileInfo.put("size", fileEntry.getSize() );
							fileInfo.put("type", fileEntry.getMimeType() );
							fileInfo.put("downloadURL", "/documents/" + fileEntry.getGroupId() + StringPool.BACK_SLASH + fileEntry.getFolderId() + StringPool.BACK_SLASH + fileEntry.getFileName() + StringPool.BACK_SLASH + fileEntry.getUuid() );
							
							value.put( fileEntry.getFileName(), fileInfo);
						}
						term.put("value", value );
					}
				}
				else {
					term.put("value",jsonData.getString(termName));
				}
			}
		}
		
		return dataStructure;
	}
}
