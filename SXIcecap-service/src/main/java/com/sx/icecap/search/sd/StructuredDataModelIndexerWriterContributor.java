package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.debug.Debug;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.StructuredData",
        service = ModelIndexerWriterContributor.class
)
public class StructuredDataModelIndexerWriterContributor implements ModelIndexerWriterContributor<StructuredData> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		Debug.printHeader("StructuredDataModelIndexerWriterContributor");
		batchIndexingActionable.setPerformActionMethod((StructuredData structuredData) -> {
//			System.out.println("setPerformActionMethod....");
			Document document = modelIndexerWriterDocumentHelper.getDocument(structuredData);

			batchIndexingActionable.addDocuments(document);
		});
		
		Debug.printFooter("StructuredDataModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_structuredDataLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(StructuredData structuredData) {
		return structuredData.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected StructuredDataLocalService _structuredDataLocalService;
}
