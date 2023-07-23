package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSDSearchFields;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = "indexer.class.name=com.sx.icecap.model.StructuredData",
		service = ModelSummaryContributor.class
)
public class StructuredDataModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
		Debug.printHeader("StructuredDataModelSummaryContributor");
		Summary summary = createSummary(document, locale);
		summary.setMaxContentLength(256);

		Debug.printFooter("StructuredDataModelSummaryContributor");
		return summary;
	}

	private Summary createSummary(Document document, Locale locale) {
//		System.out.println("StructuredDataModelSummaryContributor: createSummary");
		String title = document.get( locale, IcecapSDSearchFields.DATASET_NAME );
		
		String content = document.get( locale, IcecapSDSearchFields.DATATYPE_NAME );
 
		return new Summary(locale, title, content);
	}
}
