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
//			System.out.println("dataSetId: " + dataSetId);
//			System.out.println("dataTypeId: " + dataTypeId);
//			System.out.println("structuredDataId: " + structuredDataId);
//			System.out.println("structuredData: " + structuredData.getStructuredData());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
//		String data = structuredData.getStructuredData();
		
		document.addDate(Field.MODIFIED_DATE, structuredData.getModifiedDate());
		document.addNumber(IcecapSDSearchFields.DATASET_ID, dataSetId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATASET_NAME, structuredData.getDataSetDisplayNameMap(), true);
		document.addNumber(IcecapSDSearchFields.DATATYPE_ID, dataTypeId);
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
		
		StringBuilder content = new StringBuilder();
		
		for( int i=0; i< terms.length(); i++) {
			JSONObject term = terms.getJSONObject(i);
			if( searchableFieldList.contains(term.getString(IcecapSSSTermAttributes.TERM_NAME)) ) {
				String fieldName = term.getString("termName");
				String fieldType = term.getString("termType");
				System.out.println("Create index for: " + fieldName + "-" + fieldType + " " + fieldType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) );
				//Object value = term.get( IcecapSSSTermAttributes.VALUE);
				
				if( Validator.isNull(term.get( IcecapSSSTermAttributes.VALUE)) ) {
					//System.out.println("No value: " + fieldName);
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

					content.append( date.getTime() );
					content.append(StringPool.BLANK);
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
					content.append( value );
					content.append(StringPool.BLANK);

					
					System.out.println( fieldName + " is added as an index text: " + fieldType + " - " + value);
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.LIST) ) {
					try {
					JSONArray aryValues = JSONFactoryUtil.createJSONArray(term.getString(IcecapSSSTermAttributes.VALUE) );
					
						for( int j=0; j<aryValues.length(); j++) {
							document.addText( fieldName, aryValues.getString(j) );
//							document.addText( Field.CONTENT, aryValues.getString(j) );
							content.append(aryValues.getString(j));
							content.append(StringPool.BLANK);
							System.out.println( fieldName + " is added as an index keyword: " + fieldType + " - " + aryValues.getString(j)  );
						}
					
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.BOOLEAN) ) {
					boolean value = term.getBoolean(IcecapSSSTermAttributes.VALUE);
					document.addText(fieldName, String.valueOf(value) );
					content.append( value);
					content.append(StringPool.BLANK);

					System.out.println( fieldName + " is added as an index keyword: " + fieldType + " - " + value);
				}
				else if( fieldType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) ){
					double value = term.getDouble(IcecapSSSTermAttributes.VALUE);
					document.addNumber( fieldName,  value );
					content.append( value);
					content.append(StringPool.BLANK);
					System.out.println( fieldName + " is added as an index number: " + fieldType + " - " + value);
				}
				else {
					System.out.println("Un-recognizable term type: " + fieldType);
				}
			}
		} // end og for()
		
//		document.addText(Field.CONTENT, content.toString() );
			
		Debug.printFooter("StructuredDataModelDocumentContributor");
	}
	
}
