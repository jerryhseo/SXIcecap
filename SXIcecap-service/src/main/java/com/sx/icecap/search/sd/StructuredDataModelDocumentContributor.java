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
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.model.StructuredData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

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
	
	@Override
	public void contribute(Document document, StructuredData structuredData) {
		
		long dataSetId = structuredData.getDataSetId();
		long dataTypeId = structuredData.getDataTypeId();
		String data = structuredData.getStructuredData();
		
		document.addKeyword(Field.COMPANY_ID,structuredData.getCompanyId());
		document.addKeyword(Field.GROUP_ID, structuredData.getGroupId());
		document.addKeyword(Field.UID, structuredData.getUuid());
		document.addKeyword(Field.USER_ID, structuredData.getUserId());
		document.addKeyword(Field.USER_NAME, structuredData.getUserName());
		document.addDate(Field.CREATE_DATE, structuredData.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, structuredData.getModifiedDate());
		document.addKeyword(Field.STATUS, structuredData.getStatus());
		document.addKeyword(IcecapSDSearchFields.DATASET_ID, dataSetId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATASET_TITLE, structuredData.getDataSetDisplayNameMap(), true);
		document.addKeyword(IcecapSDSearchFields.DATATYPE_ID, dataTypeId);
		document.addLocalizedKeyword(IcecapSDSearchFields.DATATYPE_TITLE, structuredData.getDataTypeDisplayNameMap(), true);
		
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
	}
	
}
