package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.BooleanClauseFactory;
import com.liferay.portal.kernel.search.BooleanClauseFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.Validator;
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
		
		System.out.println( "Boolean Query at Start: " + booleanQuery.toString() );
		
		System.out.println("Query: " + query);
		
		Map<String, Serializable> attrs = searchContext.getAttributes();
		attrs.forEach((String key, Serializable content ) ->{
			System.out.println( key + " : " + content);
		});
		
		
//		queryHelper.addSearchTerm( booleanQuery, searchContext, Field.CONTENT, true );
		long dataTypeId = Validator.isNotNull(searchContext.getAttribute(IcecapDataTypeAttributes.DATATYPE_ID)) ?
													Long.parseLong( searchContext.getAttribute(IcecapDataTypeAttributes.DATATYPE_ID).toString() ) : 0;
		/**
		 *  I added a MUST query field to restrain search.  
		 */
		if( dataTypeId > 0 ) {
			booleanQuery.addRequiredTerm(IcecapDataTypeAttributes.DATATYPE_ID, dataTypeId);
			queryHelper.addSearchTerm(booleanQuery, searchContext,IcecapDataTypeAttributes.DATATYPE_ID, false);
		}
		
		if( Validator.isNotNull(advancedQuery) && !advancedQuery.isEmpty() ) {
			//BooleanClause<Query> booleanClause = BooleanClauseFactoryUtil.;
			
			try {
				JSONObject jsonAdvanceQuery = JSONFactoryUtil.createJSONObject(advancedQuery);
				
				JSONArray searchFields = jsonAdvanceQuery.getJSONArray("fields");
				
				for( int i=0; i<searchFields.length(); i++ ) {
					JSONObject searchField = searchFields.getJSONObject(i);
					System.out.println( searchField.toString(4) );
					String fieldName = searchField.getString("fieldName");
					String fieldType = searchField.getString("type");
					if( fieldType.equalsIgnoreCase("String") ) {
						JSONArray searchTerms = searchField.getJSONArray("keywords");
						for(int j=0; j<searchTerms.length(); j++ ) {
							booleanQuery.addTerm(fieldName, searchTerms.getString(j), true);
							queryHelper.addSearchTerm(booleanQuery, searchContext, fieldName, true);
						}
					}
					else if( fieldType.equalsIgnoreCase("Numeric") ) {
						boolean isRange = searchField.has("range");
						
						if( isRange ) {
							JSONObject jsonRange = searchField.getJSONObject("range");
							long gte = jsonRange.getLong("gte");
							long lte = jsonRange.getLong("lte");
							
							booleanQuery.addNumericRangeTerm(fieldName, gte, lte);
						}
						else {
							JSONArray searchTerms = searchField.getJSONArray("keywords");
							for(int j=0; j<searchTerms.length(); j++ ) {
								searchTerms.forEach(value->{
									booleanQuery.addExactTerm(fieldName, (Double)value );
									queryHelper.addSearchTerm(booleanQuery, searchContext, fieldName, true);
								});
							}
						}
					}
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
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
		}
		
		//queryHelper.addSearchLocalizedTerm( booleanQuery, searchContext, "dataTypeDisplayName", true);
		//queryHelper.addSearchTerm( booleanQuery, searchContext, "status", false);
		// queryHelper.addSearchTerm( booleanQuery, searchContext, Field.MODIFIED_DATE, false);
		
		//System.out.println( "Boolean Query: " + booleanQuery.toString() );
		
		Debug.printFooter("StructuredDataKeywordQueryContributor");
	}

}
