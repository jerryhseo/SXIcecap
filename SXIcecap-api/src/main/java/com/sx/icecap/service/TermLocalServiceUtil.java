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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.Term;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Term. This utility wraps
 * <code>com.sx.icecap.service.impl.TermLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TermLocalService
 * @generated
 */
public class TermLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.TermLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Term addTerm(
			String termName, String termVersion, String termType,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> definitionMap,
			Map<java.util.Locale, String> tooltipMap, String synonyms,
			String attributes, String groupTermId, int status, boolean standard,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addTerm(
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
	public static Term addTerm(Term term) {
		return getService().addTerm(term);
	}

	public static int countAllTerms() {
		return getService().countAllTerms();
	}

	public static int countApprovedTerms(long groupId) {
		return getService().countApprovedTerms(groupId);
	}

	public static int countTermsByG_S(long groupId, int status) {
		return getService().countTermsByG_S(groupId, status);
	}

	public static int countTermsByG_U_S(long groupId, long userId, int status) {
		return getService().countTermsByG_U_S(groupId, userId, status);
	}

	public static int countTermsByGroupId(long groupId) {
		return getService().countTermsByGroupId(groupId);
	}

	public static int countTermsByStatus(int status) {
		return getService().countTermsByStatus(status);
	}

	public static int countTermsByU_S(long userId, int status) {
		return getService().countTermsByU_S(userId, status);
	}

	public static int countTermsByUserId(long userId) {
		return getService().countTermsByUserId(userId);
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	public static Term createTerm(long termId) {
		return getService().createTerm(termId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Term deleteTerm(long termId) throws PortalException {
		return getService().deleteTerm(termId);
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
	public static Term deleteTerm(Term term) {
		return getService().deleteTerm(term);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Term fetchTerm(long termId) {
		return getService().fetchTerm(termId);
	}

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	public static Term fetchTermByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchTermByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Term> getAllTerms() {
		return getService().getAllTerms();
	}

	public static List<Term> getAllTerms(int start, int end) {
		return getService().getAllTerms(start, end);
	}

	public static List<Term> getAllTerms(
		int start, int end, OrderByComparator<Term> comparator) {

		return getService().getAllTerms(start, end, comparator);
	}

	public static List<Term> getApprovedTerms(long groupId) {
		return getService().getApprovedTerms(groupId);
	}

	public static List<Term> getApprovedTerms(
		long groupId, int start, int end) {

		return getService().getApprovedTerms(groupId, start, end);
	}

	public static List<Term> getApprovedTerms(
		long groupId, int start, int end, OrderByComparator<Term> comparator) {

		return getService().getApprovedTerms(groupId, start, end, comparator);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static String getName(long termId, java.util.Locale locale)
		throws com.sx.icecap.exception.NoSuchTermException {

		return getService().getName(termId, locale);
	}

	public static OrderByComparator<Term> getOrderByNameComparator(
		String orderByCol, String orderByType) {

		return getService().getOrderByNameComparator(orderByCol, orderByType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer<Term>
					searchContainer)
			throws PortalException {

		return getService().getSearchContainerResults(searchContainer);
	}

	/**
	 * Returns the term with the primary key.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws PortalException if a term with the primary key could not be found
	 */
	public static Term getTerm(long termId) throws PortalException {
		return getService().getTerm(termId);
	}

	/**
	 * Returns the term matching the UUID and group.
	 *
	 * @param uuid the term's UUID
	 * @param groupId the primary key of the group
	 * @return the matching term
	 * @throws PortalException if a matching term could not be found
	 */
	public static Term getTermByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getTermByUuidAndGroupId(uuid, groupId);
	}

	public static long getTermIdByNameVersion(
			String termName, String termVersion)
		throws com.sx.icecap.exception.NoSuchTermException {

		return getService().getTermIdByNameVersion(termName, termVersion);
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
	public static List<Term> getTerms(int start, int end) {
		return getService().getTerms(start, end);
	}

	public static List<Term> getTermsByG_S(long groupId, int status) {
		return getService().getTermsByG_S(groupId, status);
	}

	public static List<Term> getTermsByG_S(
		long groupId, int status, int start, int end) {

		return getService().getTermsByG_S(groupId, status, start, end);
	}

	public static List<Term> getTermsByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Term> comparator) {

		return getService().getTermsByG_S(
			groupId, status, start, end, comparator);
	}

	public static List<Term> getTermsByG_U_S(
		long groupId, long userId, int status) {

		return getService().getTermsByG_U_S(groupId, userId, status);
	}

	public static List<Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getService().getTermsByG_U_S(
			groupId, userId, status, start, end);
	}

	public static List<Term> getTermsByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<Term> comparator) {

		return getService().getTermsByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	public static List<Term> getTermsByGroupId(long groupId) {
		return getService().getTermsByGroupId(groupId);
	}

	public static List<Term> getTermsByGroupId(
		long groupId, int start, int end) {

		return getService().getTermsByGroupId(groupId, start, end);
	}

	public static List<Term> getTermsByGroupId(
		long groupId, int start, int end, OrderByComparator<Term> comparator) {

		return getService().getTermsByGroupId(groupId, start, end, comparator);
	}

	public static List<Term> getTermsByName(String termName) {
		return getService().getTermsByName(termName);
	}

	public static List<Term> getTermsByStatus(int status) {
		return getService().getTermsByStatus(status);
	}

	public static List<Term> getTermsByStatus(int status, int start, int end) {
		return getService().getTermsByStatus(status, start, end);
	}

	public static List<Term> getTermsByStatus(
		int status, int start, int end, OrderByComparator<Term> comparator) {

		return getService().getTermsByStatus(status, start, end, comparator);
	}

	public static List<Term> getTermsByU_S(long userId, int status) {
		return getService().getTermsByU_S(userId, status);
	}

	public static List<Term> getTermsByU_S(
		long userId, int status, int start, int end) {

		return getService().getTermsByU_S(userId, status, start, end);
	}

	public static List<Term> getTermsByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<Term> comparator) {

		return getService().getTermsByU_S(
			userId, status, start, end, comparator);
	}

	public static List<Term> getTermsByUserId(long userId) {
		return getService().getTermsByUserId(userId);
	}

	public static List<Term> getTermsByUserId(long userId, int start, int end) {
		return getService().getTermsByUserId(userId, start, end);
	}

	public static List<Term> getTermsByUserId(
		long userId, int start, int end, OrderByComparator<Term> comparator) {

		return getService().getTermsByUserId(userId, start, end, comparator);
	}

	/**
	 * Returns all the terms matching the UUID and company.
	 *
	 * @param uuid the UUID of the terms
	 * @param companyId the primary key of the company
	 * @return the matching terms, or an empty list if no matches were found
	 */
	public static List<Term> getTermsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTermsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Term> getTermsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return getService().getTermsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	public static int getTermsCount() {
		return getService().getTermsCount();
	}

	public static Term removeTerm(long termId) throws PortalException {
		return getService().removeTerm(termId);
	}

	public static void removeTerms(long[] termIds) throws PortalException {
		getService().removeTerms(termIds);
	}

	public static Term updateStatus(
			long userId, long termId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, termId, status, sc);
	}

	public static Term updateTerm(
			long termId, String termName, String termVersion, String termType,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> definitionMap,
			Map<java.util.Locale, String> tooltipMap, String synonyms,
			String attributes, String groupTermId, int status, boolean standard,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateTerm(
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
	public static Term updateTerm(Term term) {
		return getService().updateTerm(term);
	}

	public static TermLocalService getService() {
		return _service;
	}

	private static volatile TermLocalService _service;

}