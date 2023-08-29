package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.StructuredData",
        service = KeywordQueryContributor.class
)
public class StructuredDataKeywordQueryContributor implements KeywordQueryContributor {

	@Reference
	protected QueryHelper queryHelper;
	
	@Reference 
	protected DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public void contribute(
			String keywords, 
			BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
		Debug.printHeader("StructuredDataKeywordQueryContributor: contribute");
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();
		String query = searchContext.getKeywords();
		String advancedQuery = (String)searchContext.getAttribute(IcecapWebKeys.STRUCTURED_DATA_QUERY);
		
		
		/*
		System.out.println("Query: " + query);
		
		Map<String, Serializable> attrs = searchContext.getAttributes();
		attrs.forEach((String key, Serializable content ) ->{
			System.out.println( key + " : " + content);
		});
		*/
		
//		queryHelper.addSearchTerm( booleanQuery, searchContext, Field.CONTENT, true );
		long dataTypeId = Long.parseLong( searchContext.getAttribute(IcecapDataTypeAttributes.DATATYPE_ID).toString() );
		/**
		 *  I added a MUST query field to restrain search.  
		 */
		booleanQuery.addRequiredTerm(IcecapDataTypeAttributes.DATATYPE_ID, dataTypeId);
		
		if( !advancedQuery.isEmpty() ) {
			try {
				JSONObject jsonAdvanceQuery = JSONFactoryUtil.createJSONObject(advancedQuery);
				
				JSONArray searchFields = jsonAdvanceQuery.getJSONArray("fields");
				for( int i=0; i<searchFields.length(); i++ ) {
					JSONObject searchField = searchFields.getJSONObject(i);
					System.out.println( searchField.toString(4) );
					String fieldType = searchField.getString("type");
					if( fieldType.equalsIgnoreCase("String") ) {
						JSONArray searchTerms = searchField.getJSONArray("keywords");
						for(int j=0; j<searchTerms.length(); j++ ) {
							booleanQuery.addTerm(searchField.getString("fieldName"), searchTerms.getString(j));
						}
					}
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		queryHelper.addSearchTerm(booleanQuery, searchContext,IcecapDataTypeAttributes.DATATYPE_ID, false);
		
		try {
			List<String> searchableFields = _dataTypeLocalService.getSearchableFields(dataTypeId, true);
			searchableFields.forEach( field -> {
				queryHelper.addSearchTerm( booleanQuery, searchContext, field, false );
				System.out.println("Search field: " + field );;
			});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//queryHelper.addSearchLocalizedTerm( booleanQuery, searchContext, "dataTypeDisplayName", true);
		//queryHelper.addSearchTerm( booleanQuery, searchContext, "status", false);
		// queryHelper.addSearchTerm( booleanQuery, searchContext, Field.MODIFIED_DATE, false);
		
		System.out.println( "Boolean Query: " + booleanQuery.toString() );
		
		Debug.printFooter("StructuredDataKeywordQueryContributor");
	}

}
