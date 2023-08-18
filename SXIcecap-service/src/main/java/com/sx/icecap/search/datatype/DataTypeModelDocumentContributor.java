package com.sx.icecap.search.datatype;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Iterator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The contributor is a actual indexer when each DataType data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.DataType",
		service = ModelDocumentContributor.class
)
public class DataTypeModelDocumentContributor implements ModelDocumentContributor<DataType> {
	private static final Log _log = LogFactoryUtil.getLog(DataTypeModelDocumentContributor.class);
	
	@Override
	public void contribute(Document document, DataType dataType) {
			//Debug.printHeader("DataTypeModelDocumentContributor");
			
			document.addKeyword(IcecapDataTypeAttributes.DATATYPE_ID, dataType.getPrimaryKey());
			document.addDate(Field.MODIFIED_DATE, dataType.getModifiedDate());
			document.addText(IcecapDataTypeAttributes.DATATYPE_NAME, dataType.getDataTypeName());
			document.addLocalizedText(IcecapDataTypeAttributes.DESCRIPTION, dataType.getDescriptionMap());
			document.addLocalizedKeyword(IcecapDataTypeAttributes.DISPLAY_NAME, dataType.getDisplayNameMap(), true);
			
			try {
				JSONObject jsonDataStructure = _dataTypeLocalService.getDataTypeStructureJSONObject( dataType.getPrimaryKey() );
				
				StringBuilder termNames = new StringBuilder();
				JSONArray jsonTerms = jsonDataStructure.getJSONArray(IcecapDataTypeAttributes.TERMS);
				jsonTerms.forEach( jsonTerm ->{
					termNames.append(  ((JSONObject)jsonTerm).getString( IcecapSSSTermAttributes.TERM_NAME ) );
					termNames.append( StringPool.SPACE );
				});
				
				document.addText("terms", termNames.toString());
				
				//System.out.println("Term names of "+dataType.getPrimaryKey());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Debug.printFooter("DataTypeModelDocumentContributor");
	}
	
	@Reference
    private DataTypeLocalService _dataTypeLocalService;
}
