package com.sx.icecap.search.sd;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;
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
		/**
		 *  Be sure there is not a single error during the document processing. 
		 *  If any kind errors happen, the indexer would come into sleep 
		 *  without any behavious or warnings and never finish this contribute function.
		 */
		
		Debug.printHeader("StructuredDataModelDocumentContributor");
		long dataSetId = structuredData.getDataSetId();
		long dataTypeId = structuredData.getDataTypeId();
		long structuredDataId = structuredData.getStructuredDataId();
		
		JSONObject data = null;
		try {
			data = _dataTypeLocalService.getStructuredDataWithValues(dataTypeId, structuredData.getStructuredData());
			System.out.println("dataSetId: " + dataSetId);
			System.out.println("dataTypeId: " + dataTypeId);
			System.out.println("structuredDataId: " + structuredDataId);
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
		
		List<String> searchableFieldList = null;
		
		try {
			searchableFieldList = _dataTypeLocalService.getSearchableFields(dataTypeId, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONArray terms = data.getJSONArray("terms");
		System.out.println("Document terms: " + searchableFieldList.toString() );
		
		for( int i=0; i< terms.length(); i++) {
			JSONObject term = terms.getJSONObject(i);
			if( searchableFieldList.contains(term.getString(IcecapSSSTermAttributes.TERM_NAME)) ) {
				String fieldName = term.getString("termName");
				String fieldType = term.getString("termType");
				System.out.println("Create index for: " + fieldName + "-" + fieldType + " " + fieldType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) );
				//Object value = term.get( IcecapSSSTermAttributes.VALUE);
				
				if( Validator.isNull(term.get( IcecapSSSTermAttributes.VALUE)) ) {
					System.out.println("No value: " + fieldName);
					continue;
				}
				
				if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.DATE) ) {
					Long value = term.getLong( IcecapSSSTermAttributes.VALUE);
					System.out.println("Date value: " + value);
					
					Date date = new Date(value);
					
					/*
					if( NumberUtils.isCreatable(strValue) ) {
						date = new Date( Long.parseLong(strValue) );
					}
					else {
						System.out.println( strValue + " is not a number.");
						try {
							if( !strValue.isEmpty() && term.getBoolean("enableTime") == true ) {
								date = DateUtil.parseDate("yyyy. MM. dd. h:m", strValue, PortalUtil.getSiteDefaultLocale(structuredData.getGroupId()) );
							}
							else if( !strValue.isEmpty() ){
								date = DateUtil.parseDate("yyyy. MM. dd.", strValue, PortalUtil.getSiteDefaultLocale(structuredData.getGroupId()) );
							}
						} catch (PortalException | ParseException e) {
							System.out.println(e.getMessage());
						}
					}
					*/
					
					document.addDate(fieldName, date);
					System.out.println( fieldName + " is added as an index date: " + date.toString());
					
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.STRING) || 
							 fieldType.equalsIgnoreCase(IcecapSSSTermTypes.FILE) ) {
					
					String value = term.getString(IcecapSSSTermAttributes.VALUE);
					
					/*
					String[] keywords = ((String)value).split("\\s+");
					document.addKeywords(fieldName, keywords);
					document.addKeywords(Field.CONTENT, keywords);
					*/
					document.addText(fieldName, value);
					document.addText(Field.CONTENT, value);
					
					System.out.println( fieldName + " is added as an index text: " + fieldType + " - " + value);
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.LIST) ) {
					try {
						System.out.println("List Term Indexing........" + term.toString(4) );
					} catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//JSONArray values = term.getJSONArray(IcecapSSSTermAttributes.VALUE);
					/*
					for( int j=0; j<jsonValues.length(); j++) {
						document.addKeyword( fieldName, jsonValues.getString(j) );
						document.addKeyword( Field.CONTENT, jsonValues.getString(j) );
						System.out.println( fieldName + " is added as an index keyword: " + fieldType + " - " + jsonValues.getString(j) + ",  Value Mode: " + term.getString("valueMode") );
					}
					*/
					try {
						JSONArray values = JSONFactoryUtil.createJSONArray(term.getString(IcecapSSSTermAttributes.VALUE) );
						//JSONArray values = term.getJSONArray(IcecapSSSTermAttributes.VALUE);
						System.out.println("Value JSON: " + values.toString());
						document.addText( fieldName, values.join(StringPool.BLANK) );
						document.addText( Field.CONTENT, values.join(StringPool.BLANK) );
						System.out.println( fieldName + " is added as an index keyword: " + fieldType + " - " + values.join(StringPool.BLANK)  );
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.BOOLEAN) ) {
					boolean value = term.getBoolean(IcecapSSSTermAttributes.VALUE);
					document.addKeyword(fieldName, value );
					document.addKeyword(Field.CONTENT, value );
					System.out.println( fieldName + " is added as an index keyword: " + fieldType + " - " + value);
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) ){
					double value = term.getDouble(IcecapSSSTermAttributes.VALUE);
					document.addNumber( fieldName,  value );
					document.addKeyword(Field.CONTENT, String.valueOf(value) );
					System.out.println( fieldName + " is added as an index number: " + fieldType + " - " + value);
				}
				else {
					System.out.println("Un-recognizable term type: " + fieldType);
				}
			}
		}
			
		Debug.printFooter("StructuredDataModelDocumentContributor");
	}
	
}
