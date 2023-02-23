package com.sx.icecap.exportimport.data.handler.datatype;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class DataTypeStagedModelDataHandler extends BaseStagedModelDataHandler<DataType> {
	@Reference(unbind = "-")
	protected void setDataTypeLocalService(DataTypeLocalService dataTypeLocalService) {

		_dataTypeLocalService = dataTypeLocalService;
	}
	private DataTypeLocalService _dataTypeLocalService;
	
	public static final String[] CLASS_NAMES = { DataType.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, DataType dataType) throws Exception {

		Element dataTypeElement = portletDataContext.getExportDataElement(dataType);

		portletDataContext.addClassedModel(
				dataTypeElement, ExportImportPathUtil.getModelPath(dataType), dataType);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, DataType dataType) throws Exception {
		long userId = portletDataContext.getUserId(dataType.getUserUuid());

		DataType importedDataType = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(dataType);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			DataType existingDataType= super.fetchStagedModelByUuidAndGroupId(
					dataType.getUuid(), portletDataContext.getScopeGroupId());

			if (existingDataType == null) {
				serviceContext.setUuid(dataType.getUuid());

				importedDataType = _dataTypeLocalService.addDataType(
						dataType.getDataTypeName(), 
						dataType.getDataTypeVersion(),
						dataType.getExtension(),
						dataType.getDisplayNameMap(),
						dataType.getDescriptionMap(),
						dataType.getTooltipMap(),
						dataType.getStatus(),
						serviceContext);
			}
			else {
				importedDataType = _dataTypeLocalService.updateDataType(
						existingDataType.getDataTypeId(), 
						dataType.getDataTypeName(), 
						dataType.getDataTypeVersion(),
						dataType.getExtension(),
						dataType.getDisplayNameMap(),
						dataType.getDescriptionMap(),
						dataType.getTooltipMap(),
						dataType.getStatus(),
						serviceContext);

			}
		}
		else {
			importedDataType = _dataTypeLocalService.addDataType(
					dataType.getDataTypeName(), 
					dataType.getDataTypeVersion(),
					dataType.getExtension(),
					dataType.getDisplayNameMap(),
					dataType.getDescriptionMap(),
					dataType.getTooltipMap(),
					dataType.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(dataType, importedDataType);

	}

	@Override
	public String getDisplayName(DataType stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long dataTypeId) throws Exception {
		
		DataType existingDataType = fetchMissingReference(uuid, groupId);

		if (existingDataType == null) {
			return;
		}

		Map<Long, Long> dataTypeIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( DataType.class);

		dataTypeIds.put(dataTypeId, existingDataType.getDataTypeId());
	}

	@Override
	public DataType fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _dataTypeLocalService.fetchDataTypeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<DataType> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _dataTypeLocalService.getDataTypesByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<DataType>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		DataType dataType = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (dataType != null) {
			deleteStagedModel(dataType);
		}
	}

	@Override
	public void deleteStagedModel(DataType dataType) throws PortalException {
		_dataTypeLocalService.deleteDataType(dataType);
	}

}
