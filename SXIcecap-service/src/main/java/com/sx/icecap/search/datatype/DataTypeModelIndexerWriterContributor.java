package com.sx.icecap.search.datatype;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.sx.debug.Debug;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=com.sx.icecap.model.DataType",
        service = ModelIndexerWriterContributor.class
)
public class DataTypeModelIndexerWriterContributor implements ModelIndexerWriterContributor<DataType> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		//Debug.printHeader("DataTypeModelIndexerWriterContributor");

		batchIndexingActionable.setPerformActionMethod((DataType dataType) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(dataType);
			
			batchIndexingActionable.addDocuments(document);
		});
		
		//Debug.printFooter("DataTypeModelIndexerWriterContributor");
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				_dataTypeLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(DataType dataType) {
		return dataType.getCompanyId();
	}
 
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory	_dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected DataTypeLocalService _dataTypeLocalService;
}
