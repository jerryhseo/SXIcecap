/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.constant.StationXConstants;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.exception.DuplicatedTermNameException;
import com.sx.icecap.exception.InvalidTermNameException;
import com.sx.icecap.exception.NoSuchTermException;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.base.TermLocalServiceBaseImpl;
import com.sx.icecap.util.comparator.sss.TermModifiedDateComparator;
import com.sx.icecap.util.comparator.sss.TermNameComparator;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;


/**
 * The implementation of the term local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.sx.icecap.sss.service.TermLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo, Won Cheol Ryu
 * @see TermLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.sx.icecap.sss.model.Term",
	service = AopService.class
)
public class TermLocalServiceImpl extends TermLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public Term addTerm(
			String termName,
			String termVersion,
			String termType,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap,
			Map<Locale, String> tooltipMap,
			String synonyms,
			String attributes, // attributes for each type
			String groupTermId,
			int status,
			boolean standard,
			ServiceContext sc) throws PortalException {
		
		if( !verifyTerm(termName, termVersion) ) {
			throw new InvalidTermNameException(termName+" "+termVersion+" Invalid"); 
		}
		
		long termId = super.counterLocalService.increment();
		Term term = super.termLocalService.createTerm(termId);
		
		term.setTermName(termName);
		term.setTermVersion(termVersion);
		term.setTermType(termType);
		
		term.setDisplayNameMap(displayNameMap, sc.getLocale());
		term.setDefinitionMap(definitionMap, sc.getLocale());
		term.setTooltipMap(tooltipMap, sc.getLocale());
		term.setSynonyms(synonyms);
		if( attributes != null ) {
			term.setAttributesJSON(attributes);
		}
		
		term.setGroupTermId(groupTermId);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		term.setCompanyId(sc.getCompanyId());
		term.setGroupId(sc.getScopeGroupId());
		term.setUserId(user.getUserId());
		term.setUserName(user.getFullName());
		term.setCreateDate(now);
		term.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			term.setStatus(status);
		}
		else {
			term.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		term.setStatusByUserId(sc.getUserId());
		term.setStatusByUserName(user.getFullName());
		term.setStatusDate(sc.getModifiedDate(null));
		
		term.setStandard(standard);
		
		term.setExpandoBridgeAttributes(sc);
		
		super.termPersistence.update(term, sc);
//		System.out.println("Add Finished....");
		
		super.resourceLocalService.addResources(
				term.getCompanyId(), 
				term.getGroupId(), 
				term.getUserId(), 
				Term.class.getName(), 
				term.getPrimaryKey(), 
				false, 
				true, 
				true);
//		System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			term.getUserId(), 
			term.getGroupId(), 
			term.getCreateDate(), 
			term.getModifiedDate(),
			Term.class.getName(), 
			term.getPrimaryKey(), 
			term.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			term.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			term.getTermName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				term.getCompanyId(), 
				term.getGroupId(), 
				term.getUserId(), 
				Term.class.getName(), 
				term.getPrimaryKey(), 
				term, 
				sc);
		
		return term;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Term updateTerm(
			long termId, 
			String termName, 
			String termVersion,
			String termType, 
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap,
			Map<Locale, String> tooltipMap,
			String synonyms,
			String attributes, // attributes for each type
			String groupTermId,
			int status,
			boolean standard,
			ServiceContext sc) throws PortalException {
		Term term = super.termPersistence.findByPrimaryKey(termId);
		
		term.setTermName(termName);
		term.setTermVersion(termVersion);
		term.setTermType(termType);
		term.setDisplayNameMap(displayNameMap, sc.getLocale());
		term.setDefinitionMap(definitionMap, sc.getLocale());
		term.setTooltipMap(tooltipMap, sc.getLocale());
		term.setSynonyms(synonyms);
		if( attributes != null ) {
			term.setAttributesJSON(attributes);
		}
		term.setGroupTermId(groupTermId);
		
		term.setUserId(sc.getUserId());
		term.setGroupId(sc.getScopeGroupId());
		term.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != term.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			term.setStatus(status);
			term.setStatusByUserId(user.getUserId());
			term.setStatusByUserName(user.getFullName());
			term.setStatusDate(new Date());
			statusChanged = true;
		}
		
		term.setStandard(standard);
		
		term.setExpandoBridgeAttributes(sc);
		
		super.termPersistence.update(term, sc);
		
		super.resourceLocalService.updateResources(
				term.getCompanyId(),
				term.getGroupId(), 
				Term.class.getName(), 
				term.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				term.getUserId(), 
				term.getGroupId(), 
				term.getCreateDate(), 
				term.getModifiedDate(),
				Term.class.getName(), 
				term.getPrimaryKey(), 
				term.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				term.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				term.getTermName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(Term.class.getName(), termId, true);
			} else {
				super.assetEntryLocalService.updateVisible(Term.class.getName(), termId, false);
			}
		}
		
		return term;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public Term updateStatus(
			long userId, 
			long termId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Term term = super.termPersistence.findByPrimaryKey(termId);

		term.setStatus(status);
		term.setStatusByUserId(userId);
		term.setStatusByUserName(user.getFullName());
		term.setStatusDate(new Date());

		super.termPersistence.update(term, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(Term.class.getName(), termId, true);
		} else {
			super.assetEntryLocalService.updateVisible(Term.class.getName(), termId, false);
		}

		return term;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public Term removeTerm( long termId ) throws PortalException {
		Term term = super.termPersistence.remove(termId);
		
		super.assetEntryLocalService.deleteEntry(Term.class.getName(), term.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				term.getCompanyId(), 
				Term.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				term.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    term.getCompanyId(), term.getGroupId(),
			    Term.class.getName(), term.getTermId());
		
		return term;
	}
	
	public void removeTerms( long[] termIds ) throws PortalException {
		for( long termId : termIds ) {
			this.removeTerm(termId);
		}
	}
	
	public List<Term> getAllTerms(){
		return super.termPersistence.findAll();
	}
	public List<Term> getAllTerms( int start, int end ){
		return super.termPersistence.findAll(start, end);
	}
	public List<Term> getAllTerms( int start, int end, OrderByComparator<Term> comparator){
		return super.termPersistence.findAll(start, end, comparator);
	}
	public int countAllTerms() {
		return super.termPersistence.countAll();
	}
	
	
	public List<Term> getTermsByGroupId( long groupId ){
		return super.termPersistence.findByGroupId(groupId);
	}
	public List<Term>  getTermsByGroupId( long groupId, int start, int end ){
		return super.termPersistence.findByGroupId(groupId, start, end);
	}
	public List<Term>  getTermsByGroupId( long groupId, int start, int end, OrderByComparator<Term> comparator ){
		return super.termPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countTermsByGroupId(long groupId) {
		return super.termPersistence.countByGroupId(groupId);
	}

	public List<Term> getTermsByUserId( long userId ){
		return super.termPersistence.findByUserId(userId);
	}
	public List<Term>  getTermsByUserId( long userId, int start, int end ){
		return super.termPersistence.findByUserId(userId, start, end);
	}
	public List<Term>  getTermsByUserId( long userId, int start, int end, OrderByComparator<Term> comparator ){
		return super.termPersistence.findByUserId(userId, start, end, comparator);
	}
	public int countTermsByUserId(long userId) {
		return super.termPersistence.countByUserId(userId);
	}

	public List<Term> getTermsByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findAll();
		else
			return super.termPersistence.findByStatus(status);
	}
	public List<Term>  getTermsByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findAll(start, end);
		else
			return super.termPersistence.findByStatus(status, start, end);
	}
	public List<Term>  getTermsByStatus( int status, int start, int end, OrderByComparator<Term> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findAll(start, end, comparator);
		else
			return super.termPersistence.findByStatus(status, start, end, comparator);
	}
	public int countTermsByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.countAll();
		else
			return super.termPersistence.countByStatus(status);
	}

	public List<Term> getTermsByName( String termName ){
		return super.termPersistence.findByName(termName);
	}
	
	public long getTermIdByNameVersion( String termName, String termVersion ) throws NoSuchTermException{
		Term term = super.termPersistence.findByNameVersion(termName, termVersion);
		
		return term.getPrimaryKey();
	}
	
	public List<Term> getTermsByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByGroupId(groupId);
		else
			return super.termPersistence.findByG_S(groupId, status);
	}
	public List<Term> getTermsByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByGroupId(groupId, start, end);
		else
			return super.termPersistence.findByG_S(groupId, status, start, end);
	}
	public List<Term> getTermsByG_S( long groupId, int status, int start, int end, OrderByComparator<Term> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.termPersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countTermsByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.countByGroupId(groupId);
		else
			return super.termPersistence.countByG_S(groupId, status);
	}
	
	public List<Term> getTermsByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByUserId(userId);
		else
			return super.termPersistence.findByU_S(userId, status);
	}
	public List<Term> getTermsByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByUserId(userId, start, end);
		else
			return super.termPersistence.findByU_S(userId, status, start, end);
	}
	public List<Term> getTermsByU_S( long userId, int status, int start, int end, OrderByComparator<Term> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByUserId(userId, start, end, comparator);
		else
			return super.termPersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countTermsByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.countByUserId(userId);
		else
			return super.termPersistence.countByU_S(userId, status);
	}
	
	public List<Term> getTermsByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByG_U(groupId, userId);
		else
			return super.termPersistence.findByG_U_S(groupId, userId, status);
	}
	public List<Term> getTermsByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByG_U(groupId, userId, start, end);
		else
			return super.termPersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<Term> getTermsByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<Term> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.termPersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countTermsByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.termPersistence.countByG_U(groupId, userId);
		else
			return super.termPersistence.countByG_U_S(groupId, userId, status);
	}
	
	public List<Term> getApprovedTerms( long groupId ){
		return super.termPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<Term> getApprovedTerms( long groupId, int start, int end ){
		return super.termPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<Term> getApprovedTerms( long groupId, int start, int end, OrderByComparator<Term> comparator ){
		return super.termPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedTerms( long groupId ) {
		return super.termPersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public String getName( long termId, Locale locale ) throws NoSuchTermException {
		Term term = super.termPersistence.findByPrimaryKey(termId);
		
		return term.getDisplayName(locale);
	}
	
	public OrderByComparator<Term> getOrderByNameComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = true;

		if (orderByType.equals(StationXConstants.DSC)) {
			orderByAsc = false;
		}

		OrderByComparator<Term> orderByComparator = null;

		if (orderByCol.equals(IcecapSSSTermAttributes.TERM_NAME)) {
			orderByComparator = new TermNameComparator(orderByAsc);
		}
		else {
			orderByComparator = new TermModifiedDateComparator(orderByAsc);
		}

		return orderByComparator;
	}
	
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<Term> searchContainer)
		throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
			Term.class.getName(), searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(searchContainer.getOrderByCol());
		assetEntryQuery.setOrderByType1(searchContainer.getOrderByType());
		
		System.out.println("TermLocalService.getSearchContainerResults Type: "+searchContainer.getOrderByType());
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(searchContainer.getEnd());
		assetEntryQuery.setStart(searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
			assetEntryQuery);

		return new SearchContainerResults<AssetEntry>(assetEntries, total);
	}
	
	/**
	 * 
	 * @param termName
	 * @param termVersion
	 * @return true if the term is verified.
	 * @throws DuplicatedTermNameException 
	 */
	private boolean verifyTerm( String termName, String termVersion ){
		// Check uniqueness of the termName
		 try {
			super.termPersistence.findByNameVersion(termName, termVersion);
		} catch (NoSuchTermException e) {
			return true;
		}

		 return false;
	}
}