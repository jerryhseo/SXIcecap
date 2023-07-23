package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataType data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.StructuredData",
		service = ModelDocumentContributor.class
)
public class StructuredDataModelDocumentContributor implements ModelDocumentContributor<StructuredData> {
	private static final Log _log = LogFactoryUtil.getLog(StructuredDataModelDocumentContributor.class);
	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public void contribute(Document document, StructuredData structuredData) {
		
		Debug.printHeader("StructuredDataModelDocumentContributor");
		long dataSetId = structuredData.getDataSetId();
		long dataTypeId = structuredData.getDataTypeId();
		long structuredDataId = structuredData.getStructuredDataId();
		
		JSONObject data = null;
		try {
			data = _dataTypeLocalService.getStructuredDataWithValues(dataTypeId, structuredData.getStructuredData());
			System.out.println("dataSetId: " + dataSetId);
			System.out.println("dataTypeId: " + dataTypeId);
			System.out.println("structuredData: " + structuredData.getStructuredData());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
//		String data = structuredData.getStructuredData();
		
		document.addDate(Field.MODIFIED_DATE, structuredData.getModifiedDate());
		document.addKeyword(IcecapSDSearchFields.DATASET_ID, dataSetId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATASET_NAME, structuredData.getDataSetDisplayNameMap(), true);
		document.addKeyword(IcecapSDSearchFields.DATASET_ID, dataSetId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATASET_NAME, structuredData.getDataSetDisplayNameMap(), true);
		document.addKeyword(IcecapSDSearchFields.DATATYPE_ID, dataTypeId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATATYPE_NAME, structuredData.getDataTypeDisplayNameMap(), true);
		
		List<String> searchableFieldList = null;;
		try {
			searchableFieldList = _dataTypeLocalService.getSearchableFields(dataTypeId, true);
			
			JSONArray terms = data.getJSONArray("terms");
			
			terms.forEach( term -> {
				JSONObject jsonTerm = (JSONObject)term;
				 System.out.println("Searchable: " + jsonTerm.getString("termName") + "-" +  jsonTerm.getBoolean("searchable") );
				if( jsonTerm.getBoolean("searchable") == true ) {
					System.out.println("Searchable Fields for " + dataTypeId  + ":" );
					String fieldName = jsonTerm.getString("termName");
					String fieldType = jsonTerm.getString("termType");
					String fieldVersion = jsonTerm.getString("termVersion", "1.0.0");
					JSONObject displayName = jsonTerm.getJSONObject("displayName");
					Object value = jsonTerm.get( IcecapSSSTermAttributes.VALUE);
					
					System.out.println( fieldName + ", " + fieldType + ", " + fieldVersion + ", " + displayName.toString());
					
					System.out.println("^^^^^^^^^");
					
					if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.DATE) )
						document.addDateSortable(fieldName, (Date)value);
					else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.STRING) || 
								 fieldType.equalsIgnoreCase(IcecapSSSTermTypes.BOOLEAN) ||
								 fieldType.equalsIgnoreCase(IcecapSSSTermTypes.LIST) ) {
						document.addText(fieldName, (String)value);
					}
					else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) ){
						document.addNumberSortable( fieldName,  Double.parseDouble((String)value) );
					}
				}
			});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return;
		}
		
		Map<String, Field> fields = document.getFields();
		fields.forEach((key, field)->{
			System.out.println( key + ":" + field.getName() + "-" + field.getValue() );
		});
		
		/*
		try {
			JSONObject jsonData = JSONFactoryUtil.createJSONObject( data );
			JSONArray values = jsonData.getJSONArray(IcecapSDSearchFields.VALUES);
			
			values.forEach( (json) -> {
				JSONObject obj = (JSONObject )json;
				String termName = obj.getString(IcecapSDSearchFields.TERM_NAME);
				String termType = obj.getString(IcecapSDSearchFields.TERM_TYPE);
				
				if( termType.equalsIgnoreCase(IcecapSSSTermTypes.STRING)) {
					String value = obj.getString(IcecapSDSearchFields.VALUE);
					document.addKeyword(termName, value);
				}
				else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) ) {
					Double value = obj.getDouble(IcecapSDSearchFields.VALUE);
					document.addNumber(termName, value);
				}
				else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.DATE) ) {
					long value = obj.getLong(IcecapSDSearchFields.VALUE);
					Date date = DateUtil.newDate(value);
					document.addDate(termName, date);
				}
			});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		Debug.printFooter("StructuredDataModelDocumentContributor");
	}
	
}
