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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TermLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TermLocalService
 * @generated
 */
public class TermLocalServiceWrapper
	implements ServiceWrapper<TermLocalService>, TermLocalService {

	public TermLocalServiceWrapper(TermLocalService termLocalService) {
		_termLocalService = termLocalService;
	}

	@Override
	public com.sx.icecap.model.Term addTerm(
			String termName, String termVersion, String termType,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> definitionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, String synonyms,
			String attributes, String groupTermId, int status, boolean standard,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.addTerm(
			termName, termVersion, termType, displayNameMap, definitionMap,
			tooltipMap, synonyms, attributes, groupTermId, status, standard,
			sc);
	}

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
	@Override
	public com.sx.icecap.model.Term addTerm(com.sx.icecap.model.Term term) {
		return _termLocalService.addTerm(term);
	}

	@Override
	public int countAllTerms() {
		return _termLocalService.countAllTerms();
	}

	@Override
	public int countApprovedTerms(long groupId) {
		return _termLocalService.countApprovedTerms(groupId);
	}

	@Override
	public int countTermsByG_S(long groupId, int status) {
		return _termLocalService.countTermsByG_S(groupId, status);
	}

	@Override
	public int countTermsByG_U_S(long groupId, long userId, int status) {
		return _termLocalService.countTermsByG_U_S(groupId, userId, status);
	}

	@Override
	public int countTermsByGroupId(long groupId) {
		return _termLocalService.countTermsByGroupId(groupId);
	}

	@Override
	public int countTermsByStatus(int status) {
		return _termLocalService.countTermsByStatus(status);
	}

	@Override
	public int countTermsByU_S(long userId, int status) {
		return _termLocalService.countTermsByU_S(userId, status);
	}

	@Override
	public int countTermsByUserId(long userId) {
		return _termLocalService.countTermsByUserId(userId);
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public com.sx.icecap.model.Term createTerm(long termId) {
		return _termLocalService.createTerm(termId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.deletePersistedModel(persistedModel);
	}

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
	@Override
	public com.sx.icecap.model.Term deleteTerm(long termId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.deleteTerm(termId);
	}

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
	@Override
	public com.sx.icecap.model.Term deleteTerm(com.sx.icecap.model.Term term) {
		return _termLocalService.deleteTerm(term);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _termLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _termLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _termLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _termLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _termLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _termLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.Term fetchTerm(long termId) {
		return _termLocalService.fetchTerm(termId);
	}

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public com.sx.icecap.model.Term fetchTermByUuidAndGroupId(
		String uuid, long groupId) {

		return _termLocalService.fetchTermByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _termLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getAllTerms() {
		return _termLocalService.getAllTerms();
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getAllTerms(
		int start, int end) {

		return _termLocalService.getAllTerms(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getAllTerms(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getAllTerms(start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getApprovedTerms(
		long groupId) {

		return _termLocalService.getApprovedTerms(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getApprovedTerms(
		long groupId, int start, int end) {

		return _termLocalService.getApprovedTerms(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getApprovedTerms(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getApprovedTerms(
			groupId, start, end, comparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _termLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _termLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public String getName(long termId, java.util.Locale locale)
		throws com.sx.icecap.exception.NoSuchTermException {

		return _termLocalService.getName(termId, locale);
	}

	@Override
	public com.liferay.portal.kernel.util.OrderByComparator
		<com.sx.icecap.model.Term> getOrderByNameComparator(
			String orderByCol, String orderByType) {

		return _termLocalService.getOrderByNameComparator(
			orderByCol, orderByType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _termLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer
					<com.sx.icecap.model.Term> searchContainer)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getSearchContainerResults(searchContainer);
	}

	/**
	 * Returns the term with the primary key.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws PortalException if a term with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.Term getTerm(long termId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getTerm(termId);
	}

	@Override
	public com.sx.icecap.model.Term getTerm(String termName, String termVersion)
		throws com.sx.icecap.exception.NoSuchTermException {

		return _termLocalService.getTerm(termName, termVersion);
	}

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term
	 * @throws PortalException if a matching term could not be found
	 */
	@Override
	public com.sx.icecap.model.Term getTermByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.getTermByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public long getTermId(String termName, String termVersion)
		throws com.sx.icecap.exception.NoSuchTermException {

		return _termLocalService.getTermId(termName, termVersion);
	}

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
	@Override
	public java.util.List<com.sx.icecap.model.Term> getTerms(
		int start, int end) {

		return _termLocalService.getTerms(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_S(
		long groupId, int status) {

		return _termLocalService.getTermsByG_S(groupId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_S(
		long groupId, int status, int start, int end) {

		return _termLocalService.getTermsByG_S(groupId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByG_S(
			groupId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_U_S(
		long groupId, long userId, int status) {

		return _termLocalService.getTermsByG_U_S(groupId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return _termLocalService.getTermsByG_U_S(
			groupId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByGroupId(
		long groupId) {

		return _termLocalService.getTermsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByGroupId(
		long groupId, int start, int end) {

		return _termLocalService.getTermsByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByName(
		String termName) {

		return _termLocalService.getTermsByName(termName);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByStatus(
		int status) {

		return _termLocalService.getTermsByStatus(status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByStatus(
		int status, int start, int end) {

		return _termLocalService.getTermsByStatus(status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByStatus(
			status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByU_S(
		long userId, int status) {

		return _termLocalService.getTermsByU_S(userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByU_S(
		long userId, int status, int start, int end) {

		return _termLocalService.getTermsByU_S(userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByU_S(
			userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByUserId(
		long userId) {

		return _termLocalService.getTermsByUserId(userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByUserId(
		long userId, int start, int end) {

		return _termLocalService.getTermsByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> comparator) {

		return _termLocalService.getTermsByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the terms matching the UUID and company.
	 *
	 * @param uuid the UUID of the terms
	 * @param companyId the primary key of the company
	 * @return the matching terms, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByUuidAndCompanyId(
		String uuid, long companyId) {

		return _termLocalService.getTermsByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<com.sx.icecap.model.Term> getTermsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.Term> orderByComparator) {

		return _termLocalService.getTermsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	@Override
	public int getTermsCount() {
		return _termLocalService.getTermsCount();
	}

	@Override
	public com.sx.icecap.model.Term removeTerm(long termId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.removeTerm(termId);
	}

	@Override
	public void removeTerms(long[] termIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_termLocalService.removeTerms(termIds);
	}

	@Override
	public com.sx.icecap.model.Term updateStatus(
			long userId, long termId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _termLocalService.updateStatus(userId, termId, status, sc);
	}

	@Override
	public com.sx.icecap.model.Term updateTerm(
			long termId, String termName, String termVersion, String termType,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> definitionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, String synonyms,
			String attributes, String groupTermId, int status, boolean standard,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _termLocalService.updateTerm(
			termId, termName, termVersion, termType, displayNameMap,
			definitionMap, tooltipMap, synonyms, attributes, groupTermId,
			status, standard, sc);
	}

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
	@Override
	public com.sx.icecap.model.Term updateTerm(com.sx.icecap.model.Term term) {
		return _termLocalService.updateTerm(term);
	}

	@Override
	public TermLocalService getWrappedService() {
		return _termLocalService;
	}

	@Override
	public void setWrappedService(TermLocalService termLocalService) {
		_termLocalService = termLocalService;
	}

	private TermLocalService _termLocalService;

}