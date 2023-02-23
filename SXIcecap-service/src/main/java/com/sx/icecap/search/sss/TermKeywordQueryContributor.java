package com.sx.icecap.search.sss;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSSSTermAttributes;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.sss.model.Term",
        service = KeywordQueryContributor.class
)
public class TermKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
		Debug.printHeader("TermKeywordQueryContributor: contribute");
		System.out.println("Keywords: "+keywords);
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapSSSTermAttributes.TERM_NAME, true);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, IcecapSSSTermAttributes.DISPLAY_NAME, false);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, IcecapSSSTermAttributes.DEFINITION, false);
		queryHelper.addSearchLocalizedTerm(
				booleanQuery, searchContext, IcecapSSSTermAttributes.TOOLTIP, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapSSSTermAttributes.SYNONYMS, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapSSSTermAttributes.STATUS, false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, IcecapSSSTermAttributes.STANDARD, false);
		
		if( Validator.isNotNull( searchContext.getBooleanClauses() ) ) {
			System.out.println("searchContext" + searchContext.getBooleanClauses().toString());
		}
		
		Debug.printFooter("TermKeywordQueryContributor: contribute");
	}

	@Reference
    protected QueryHelper queryHelper;
}
