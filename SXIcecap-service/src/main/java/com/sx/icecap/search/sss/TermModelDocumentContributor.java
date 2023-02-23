package com.sx.icecap.search.sss;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.model.Term;

import org.osgi.service.component.annotations.Component;

/**
 * The contributor is a actual indexer when each Term data is added or updated.
 * Super interface ModelDocumentContributor has only one unimplemented API.
 * 
**/
@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.sss.model.Term",
		service = ModelDocumentContributor.class
)
public class TermModelDocumentContributor implements ModelDocumentContributor<Term> {
	private static final Log _log = LogFactoryUtil.getLog(TermModelDocumentContributor.class);
	
	@Override
	public void contribute(Document document, Term term) {
//			System.out.println("TermModelDocumentContributor.......");
		Debug.printHeader("TermModelDocumentContributor");
			document.addDate(Field.MODIFIED_DATE, term.getModifiedDate());
			document.addLocalizedKeyword(IcecapSSSTermAttributes.DISPLAY_NAME, term.getDisplayNameMap(), true);
			document.addKeyword(IcecapSSSTermAttributes.TERM_NAME, term.getTermName());
			document.addLocalizedKeyword(IcecapSSSTermAttributes.DEFINITION, term.getDefinitionMap(), true);
			document.addLocalizedKeyword(IcecapSSSTermAttributes.TOOLTIP, term.getTooltipMap(), true);
			document.addKeyword(IcecapSSSTermAttributes.SYNONYMS, term.getSynonyms());
			document.addKeyword(IcecapSSSTermAttributes.TERM_TYPE, term.getTermType());
			document.addKeyword(IcecapSSSTermAttributes.STANDARD, term.getStandard());
			document.addKeyword(IcecapSSSTermAttributes.STATUS, term.getStatus());
			
			document.toString();
		Debug.printFooter("TermModelDocumentContributor");
	}
	
}
