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

package com.sx.icecap.service;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.exception.NoSuchTermException;
import com.sx.icecap.model.Term;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Term. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TermLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TermLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.TermLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the term local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TermLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Term addTerm(
			String termName, String termVersion, String termType,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap, Map<Locale, String> tooltipMap,
			String synonyms, String attributes, String groupTermId, int status,
			boolean standard, ServiceContext sc)
		throws PortalException;

	/**
	 * Adds the term to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TermLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param term the term
	 * @return the term that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Term addTerm(Term term);

	public int countAllTerms();

	public int countApprovedTerms(long groupId);

	public int countTermsByG_S(long groupId, int status);

	public int countTermsByG_U_S(long groupId, long userId, int status);

	public int countTermsByGroupId(long groupId);

	public int countTermsByStatus(int status);

	public int countTermsByU_S(long userId, int status);

	public int countTermsByUserId(long userId);

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Transactional(enabled = false)
	public Term createTerm(long termId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TermLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws PortalException if a term with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Term deleteTerm(long termId) throws PortalException;

	/**
	 * Deletes the term from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TermLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param term the term
	 * @return the term that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Term deleteTerm(Term term);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TermModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TermModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Term fetchTerm(long termId);

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Term fetchTermByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getAllTerms();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getAllTerms(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getAllTerms(
		int start, int end, OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getApprovedTerms(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getApprovedTerms(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getApprovedTerms(
		long groupId, int start, int end, OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getName(long termId, Locale locale)
		throws NoSuchTermException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrderByComparator<Term> getOrderByNameComparator(
		String orderByCol, String orderByType);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<Term> searchContainer)
		throws PortalException;

	/**
	 * Returns the term with the primary key.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws PortalException if a term with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Term getTerm(long termId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Term getTerm(String termName, String termVersion)
		throws NoSuchTermException;

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term
	 * @throws PortalException if a matching term could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Term getTermByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getTermId(String termName, String termVersion)
		throws NoSuchTermException;

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTerms(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_S(long groupId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_S(
		long groupId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_U_S(long groupId, long userId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByGroupId(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByGroupId(
		long groupId, int start, int end, OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByName(String termName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByStatus(int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByStatus(int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByStatus(
		int status, int start, int end, OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByU_S(long userId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByU_S(
		long userId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Term> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByUserId(long userId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByUserId(
		long userId, int start, int end, OrderByComparator<Term> comparator);

	/**
	 * Returns all the terms matching the UUID and company.
	 *
	 * @param uuid the UUID of the terms
	 * @param companyId the primary key of the company
	 * @return the matching terms, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of terms matching the UUID and company.
	 *
	 * @param uuid the UUID of the terms
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching terms, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Term> getTermsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator);

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTermsCount();

	@Indexable(type = IndexableType.DELETE)
	public Term removeTerm(long termId) throws PortalException;

	public void removeTerms(long[] termIds) throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public Term updateStatus(
			long userId, long termId, Integer status, ServiceContext sc)
		throws PortalException, SystemException;

	@Indexable(type = IndexableType.REINDEX)
	public Term updateTerm(
			long termId, String termName, String termVersion, String termType,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> definitionMap, Map<Locale, String> tooltipMap,
			String synonyms, String attributes, String groupTermId, int status,
			boolean standard, ServiceContext sc)
		throws PortalException;

	/**
	 * Updates the term in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TermLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param term the term
	 * @return the term that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Term updateTerm(Term term);

}