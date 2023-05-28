package com.sx.icecap.exportimport.data.handler.dataset;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.DataSetLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class DataSetStagedModelDataHandler extends BaseStagedModelDataHandler<DataSet> {
	@Reference(unbind = "-")
	protected void setDataSetLocalService(DataSetLocalService dataSetLocalService) {

		_dataSetLocalService = dataSetLocalService;
	}
	private DataSetLocalService _dataSetLocalService;
	
	public static final String[] CLASS_NAMES = { DataSet.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, DataSet dataSet) throws Exception {

		Element dataSetElement = portletDataContext.getExportDataElement(dataSet);

		portletDataContext.addClassedModel(
				dataSetElement, ExportImportPathUtil.getModelPath(dataSet), dataSet);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, DataSet dataSet) throws Exception {
		long userId = portletDataContext.getUserId(dataSet.getUserUuid());

		DataSet importedDataSet = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(dataSet);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			DataSet existingDataSet= super.fetchStagedModelByUuidAndGroupId(
					dataSet.getUuid(), portletDataContext.getScopeGroupId());

			if (existingDataSet == null) {
				serviceContext.setUuid(dataSet.getUuid());

				importedDataSet = _dataSetLocalService.addDataSet(
						dataSet.getDataSetName(), 
						dataSet.getDataSetVersion(),
						dataSet.getDisplayNameMap(),
						dataSet.getDescriptionMap(),
						dataSet.getStatus(),
						serviceContext);
			}
			else {
				importedDataSet = _dataSetLocalService.updateDataSet(
						existingDataSet.getDataSetId(), 
						dataSet.getDataSetName(), 
						dataSet.getDataSetVersion(),
						dataSet.getDisplayNameMap(),
						dataSet.getDescriptionMap(),
						dataSet.getStatus(),
						serviceContext);

			}
		}
		else {
			importedDataSet = _dataSetLocalService.addDataSet(
					dataSet.getDataSetName(), 
					dataSet.getDataSetVersion(),
					dataSet.getDisplayNameMap(),
					dataSet.getDescriptionMap(),
					dataSet.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(dataSet, importedDataSet);

	}

	@Override
	public String getDisplayName(DataSet stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long dataSetId) throws Exception {
		
		DataSet existingDataSet = fetchMissingReference(uuid, groupId);

		if (existingDataSet == null) {
			return;
		}

		Map<Long, Long> dataSetIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( DataSet.class);

		dataSetIds.put(dataSetId, existingDataSet.getDataSetId());
	}

	@Override
	public DataSet fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _dataSetLocalService.fetchDataSetByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<DataSet> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _dataSetLocalService.getDataSetsByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<DataSet>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		DataSet dataSet = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (dataSet != null) {
			deleteStagedModel(dataSet);
		}
	}

	@Override
	public void deleteStagedModel(DataSet dataSet) throws PortalException {
		_dataSetLocalService.deleteDataSet(dataSet);
	}

}
