package com.sx.icecap.exportimport.data.handler.sd;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class StructuredDataStagedModelDataHandler extends BaseStagedModelDataHandler<StructuredData> {
	@Reference(unbind = "-")
	protected void setDataTypeLocalService(StructuredDataLocalService structuredDataLocalService) {

		_structuredDataLocalService =structuredDataLocalService;
	}
	private StructuredDataLocalService _structuredDataLocalService;
	
	public static final String[] CLASS_NAMES = { StructuredData.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, StructuredData structuredData) throws Exception {

		Element structuredDataElement = portletDataContext.getExportDataElement(structuredData);

		portletDataContext.addClassedModel(
				structuredDataElement, ExportImportPathUtil.getModelPath(structuredData), structuredData);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, StructuredData structuredData) throws Exception {
		long userId = portletDataContext.getUserId(structuredData.getUserUuid());

		StructuredData importedData = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(structuredData);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			StructuredData existingData= super.fetchStagedModelByUuidAndGroupId(
					structuredData.getUuid(), portletDataContext.getScopeGroupId());

			if (existingData == null) {
				serviceContext.setUuid(structuredData.getUuid());

				importedData = _structuredDataLocalService.addStructuredData(
						structuredData.getDataSetId(), 
						structuredData.getDataTypeId(),
						structuredData.getStructuredData(),
						structuredData.getStatus(),
						serviceContext);
			}
			else {
				importedData = _structuredDataLocalService.updateStructuredData(
						existingData.getDataTypeId(), 
						structuredData.getDataSetId(), 
						structuredData.getDataTypeId(),
						structuredData.getStructuredData(),
						structuredData.getStatus(),
						serviceContext);
			}
		}
		else {
			importedData = _structuredDataLocalService.addStructuredData(
					structuredData.getDataSetId(), 
					structuredData.getDataTypeId(),
					structuredData.getStructuredData(),
					structuredData.getStatus(),
					serviceContext);
		}

		portletDataContext.importClassedModel(structuredData, importedData);

	}

	@Override
	public String getDisplayName(StructuredData stagedModel) {
		return stagedModel.getDataSetDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long structuredDataId) throws Exception {
		
		StructuredData existingData = fetchMissingReference(uuid, groupId);

		if (existingData == null) {
			return;
		}

		Map<Long, Long> structuredDataIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( StructuredData.class);

		structuredDataIds.put(structuredDataId, existingData.getStructuredDataId());
	}

	@Override
	public StructuredData fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _structuredDataLocalService.fetchStructuredDataByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<StructuredData> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _structuredDataLocalService.getStructuredDatasByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<StructuredData>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		StructuredData structuredData = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (structuredData != null) {
			deleteStagedModel(structuredData);
		}
	}

	@Override
	public void deleteStagedModel(StructuredData structuredData) throws PortalException {
		_structuredDataLocalService.deleteStructuredData(structuredData);
	}

}
