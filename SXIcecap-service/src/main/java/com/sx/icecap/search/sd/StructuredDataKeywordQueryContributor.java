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
import java.util.Collection;
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
		Debug.printHeader("StructuredDataKeywordQueryContributor");
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();
		String query = searchContext.getKeywords();
		String advancedQuery = (String)searchContext.getAttribute(IcecapWebKeys.STRUCTURED_DATA_QUERY);
		
		System.out.println( "Boolean Query at Start: " + booleanQuery.toString() );
//		System.out.println( "Search context Boolean Query at Start: " + booleanQuery.get );
		
		System.out.println("Advanced Query: " + advancedQuery);
		
//		queryHelper.addSearchTerm( booleanQuery, searchContext, Field.CONTENT, true );
		long dataTypeId = Validator.isNotNull(searchContext.getAttribute(IcecapDataTypeAttributes.DATATYPE_ID)) ?
													Long.parseLong( searchContext.getAttribute(IcecapDataTypeAttributes.DATATYPE_ID).toString() ) : 0;
		
													/*
		if( dataTypeId > 0 ) {
			//booleanQuery.addRequiredTerm(IcecapDataTypeAttributes.DATATYPE_ID, dataTypeId);
			try {
//				booleanQuery.addTerm(IcecapDataTypeAttributes.DATATYPE_ID, dataTypeId);
				queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapDataTypeAttributes.DATATYPE_ID, false);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// queryHelper.addSearchTerm(booleanQuery, searchContext,IcecapDataTypeAttributes.DATATYPE_ID, false);
		}
		*/
		
		//queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapDataTypeAttributes.DATATYPE_ID, false);
		//queryHelper.addSearchTerm(booleanQuery, searchContext, Field.CONTENT, false);
		
		Debug.printFooter("StructuredDataKeywordQueryContributor");
	}

}
