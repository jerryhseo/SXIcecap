package com.sx.icecap.search.sd.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.debug.Debug;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.search.sd.StructuredDataBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = StructuredDataBatchReindexer.class
)
public class StructuredDataBatchReindexerImpl implements StructuredDataBatchReindexer {

	@Override
	public void reindex(long structuredDataId, long companyId) {
		Debug.printHeader("StructuredDataBatchReindexerImpl");
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property structuredDataIdProperty = PropertyFactoryUtil.forName("structuredDataId");
			dynamicQuery.add(structuredDataIdProperty.eq(structuredDataId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((StructuredData structuredData) -> {
			Document document = _indexerDocumentBuilder.getDocument(structuredData);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
		
Debug.printFooter("StructuredDataBatchReindexerImpl");
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.StructuredData)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.StructuredData)"
	)
	protected IndexerWriter<StructuredData> _indexerWriter;
}
