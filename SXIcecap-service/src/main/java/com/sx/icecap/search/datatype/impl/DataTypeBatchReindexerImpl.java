package com.sx.icecap.search.datatype.impl;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;
import com.sx.icecap.model.DataType;
import com.sx.icecap.search.datatype.DataTypeBatchReindexer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = DataTypeBatchReindexer.class
)
public class DataTypeBatchReindexerImpl implements DataTypeBatchReindexer {

	@Override
	public void reindex(long dataTypeId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = _indexerWriter.getBatchIndexingActionable();

		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property dataTypeIdProperty = PropertyFactoryUtil.forName("dataTypeId");
			dynamicQuery.add(dataTypeIdProperty.eq(dataTypeId));
		});

		batchIndexingActionable.setCompanyId(companyId);

		batchIndexingActionable.setPerformActionMethod((DataType dataType) -> {
			Document document = _indexerDocumentBuilder.getDocument(dataType);
			batchIndexingActionable.addDocuments(document);
		});

		batchIndexingActionable.performActions();
	}

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataType)"
	)
	protected IndexerDocumentBuilder _indexerDocumentBuilder;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataType)"
	)
	protected IndexerWriter<DataType> _indexerWriter;
}
