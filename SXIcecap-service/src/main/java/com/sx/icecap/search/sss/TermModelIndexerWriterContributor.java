package com.sx.icecap.search.sss;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.debug.Debug;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.sss.model.Term",
        service = ModelIndexerWriterContributor.class
)
public class TermModelIndexerWriterContributor implements ModelIndexerWriterContributor<Term> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
//		System.out.println("TermModelIndexerWriterContributor......");
		Debug.printHeader("TermModelIndexerWriterContributor");
		batchIndexingActionable.setPerformActionMethod((Term term) -> {
//			System.out.println("setPerformActionMethod....");
			Document document = modelIndexerWriterDocumentHelper.getDocument(term);

			batchIndexingActionable.addDocuments(document);
		});
		
		Debug.printFooter("TermModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = _termLocalService.getIndexableActionableDynamicQuery();
		
		System.out.println("getBatchIndexingActionable: " + indexableActionableDynamicQuery.toString() );
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_termLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Term term) {
		return term.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected TermLocalService _termLocalService;
}
