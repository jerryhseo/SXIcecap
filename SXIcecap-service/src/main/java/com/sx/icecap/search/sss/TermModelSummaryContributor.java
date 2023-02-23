package com.sx.icecap.search.sss;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSSSTermAttributes;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.sss.model.Term",
		service = ModelSummaryContributor.class
)
public class TermModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
//		System.out.println("TermModelSummaryContributor: getSummary");
		Debug.printHeader("TermModelSummaryContributor");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		Debug.printFooter("TermModelSummaryContributor");
		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("TermModelSummaryContributor: createSummary");
		String title = document.get(IcecapSSSTermAttributes.DISPLAY_NAME, IcecapSSSTermAttributes.TERM_VERSION);
		String content = document.get(
				IcecapSSSTermAttributes.TERM_NAME +
				IcecapSSSTermAttributes.DEFINITION
		);
 
		return new Summary(locale, title, content);
	}
}
