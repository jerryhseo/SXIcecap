package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.icecap.constant.IcecapDataTypeAttributes;

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
	
	@Override
	public void contribute(
			String keywords, 
			BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
//		System.out.println("DataTypeKeywordQueryContributor: contribute");
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext,"dataTypeId", true);
		queryHelper.addSearchLocalizedTerm( booleanQuery, searchContext, "dataTypeDisplayName", false);
		queryHelper.addSearchTerm( booleanQuery, searchContext, "status", false);
		queryHelper.addSearchTerm( booleanQuery, searchContext, Field.MODIFIED_DATE, false);
		
	}

}
