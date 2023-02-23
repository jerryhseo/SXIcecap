package com.sx.icecap.exportimport.data.handler.sss;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.xml.Element;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
		immediate = true, 
		service = StagedModelDataHandler.class
	)
public class TermStagedModelDataHandler extends BaseStagedModelDataHandler<Term> {
	@Reference(unbind = "-")
	protected void setTermLocalService(TermLocalService termLocalService) {

		_termLocalService = termLocalService;
	}
	private TermLocalService _termLocalService;
	
	public static final String[] CLASS_NAMES = { Term.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(PortletDataContext portletDataContext, Term term) throws Exception {

		Element termElement = portletDataContext.getExportDataElement(term);

		portletDataContext.addClassedModel(
				termElement, ExportImportPathUtil.getModelPath(term), term);
		
	}

	@Override
	protected void doImportStagedModel(PortletDataContext portletDataContext, Term term) throws Exception {
		long userId = portletDataContext.getUserId(term.getUserUuid());

		Map<Long, Long> termIds =
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap(Term.class);
		
		long termId = MapUtil.getLong( termIds, term.getTermId(), term.getTermId());

		Term importedTerm = null;

		ServiceContext serviceContext =
				portletDataContext.createServiceContext(term);
		serviceContext.setUserId(userId);
		
		if (portletDataContext.isDataStrategyMirror()) {

			Term existingTerm= super.fetchStagedModelByUuidAndGroupId(
					term.getUuid(), portletDataContext.getScopeGroupId());

			if (existingTerm == null) {
				serviceContext.setUuid(term.getUuid());

				importedTerm = _termLocalService.addTerm(
						term.getTermName(), 
						term.getTermVersion(),
						term.getTermType(),
						term.getDisplayNameMap(),
						term.getDefinitionMap(),
						term.getTooltipMap(),
						term.getSynonyms(),
						term.getAttributesJSON(),
						term.getGroupTermId(),
						term.getStatus(),
						term.getStandard(),
						serviceContext);
			}
			else {
				importedTerm = _termLocalService.updateTerm(
						existingTerm.getTermId(), 
						term.getTermName(), 
						term.getTermVersion(),
						term.getTermType(),
						term.getDisplayNameMap(),
						term.getDefinitionMap(),
						term.getTooltipMap(),
						term.getSynonyms(),
						term.getAttributesJSON(),
						term.getGroupTermId(),
						term.getStatus(),
						term.getStandard(),
						serviceContext);

			}
		}
		else {
			importedTerm = _termLocalService.addTerm(
					term.getTermName(), 
					term.getTermVersion(),
					term.getTermType(),
					term.getDisplayNameMap(),
					term.getDefinitionMap(),
					term.getTooltipMap(),
					term.getSynonyms(),
					term.getAttributesJSON(),
					term.getGroupTermId(),
					term.getStatus(),
					term.getStandard(),
					serviceContext);
		}

		portletDataContext.importClassedModel(term, importedTerm);

	}

	@Override
	public String getDisplayName(Term stagedModel) {
		return stagedModel.getDisplayName();
	}

	@Override
	protected void doImportMissingReference(
			PortletDataContext portletDataContext, 
			String uuid, 
			long groupId,
			long termId) throws Exception {
		Term existingTerm = fetchMissingReference(uuid, groupId);

		if (existingTerm == null) {
			return;
		}

		Map<Long, Long> termIds = 
				(Map<Long, Long>) portletDataContext.getNewPrimaryKeysMap( Term.class);

		termIds.put(termId, existingTerm.getTermId());
	}

	@Override
	public Term fetchStagedModelByUuidAndGroupId(String uuid, long groupId) {
		return _termLocalService.fetchTermByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public List<Term> fetchStagedModelsByUuidAndCompanyId(String uuid, long companyId) {
		return _termLocalService.getTermsByUuidAndCompanyId(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				new StagedModelModifiedDateComparator<Term>());
	}

	@Override
	public void deleteStagedModel(String uuid, long groupId, String className, String extraData)
			throws PortalException {
		Term term = fetchStagedModelByUuidAndGroupId(uuid, groupId);

		if (term != null) {
			deleteStagedModel(term);
		}
	}

	@Override
	public void deleteStagedModel(Term term) throws PortalException {
		_termLocalService.deleteTerm(term);
	}

}
