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

import com.sx.icecap.model.DataSet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DataSet. This utility wraps
 * <code>com.sx.icecap.service.impl.DataSetLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataSetLocalService
 * @generated
 */
public class DataSetLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataSetLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data set to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataSetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataSet the data set
	 * @return the data set that was added
	 */
	public static DataSet addDataSet(DataSet dataSet) {
		return getService().addDataSet(dataSet);
	}

	public static DataSet addDataSet(
			String dataSetName, String dataSetVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addDataSet(
			dataSetName, dataSetVersion, displayNameMap, descriptionMap, status,
			sc);
	}

	public static int countAllDataSets() {
		return getService().countAllDataSets();
	}

	public static int countApprovedDataSets(long groupId) {
		return getService().countApprovedDataSets(groupId);
	}

	public static int countDataSetsByG_S(long groupId, int status) {
		return getService().countDataSetsByG_S(groupId, status);
	}

	public static int countDataSetsByG_U_S(
		long groupId, long userId, int status) {

		return getService().countDataSetsByG_U_S(groupId, userId, status);
	}

	public static int countDataSetsByGroupId(long groupId) {
		return getService().countDataSetsByGroupId(groupId);
	}

	public static int countDataSetsByName(String dataSetName) {
		return getService().countDataSetsByName(dataSetName);
	}

	public static int countDataSetsByStatus(int status) {
		return getService().countDataSetsByStatus(status);
	}

	public static int countDataSetsByU_S(long userId, int status) {
		return getService().countDataSetsByU_S(userId, status);
	}

	public static int countDataSetsByUserId(long userId) {
		return getService().countDataSetsByUserId(userId);
	}

	/**
	 * Creates a new data set with the primary key. Does not add the data set to the database.
	 *
	 * @param dataSetId the primary key for the new data set
	 * @return the new data set
	 */
	public static DataSet createDataSet(long dataSetId) {
		return getService().createDataSet(dataSetId);
	}

	/**
	 * Deletes the data set from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataSetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataSet the data set
	 * @return the data set that was removed
	 */
	public static DataSet deleteDataSet(DataSet dataSet) {
		return getService().deleteDataSet(dataSet);
	}

	/**
	 * Deletes the data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataSetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set that was removed
	 * @throws PortalException if a data set with the primary key could not be found
	 */
	public static DataSet deleteDataSet(long dataSetId) throws PortalException {
		return getService().deleteDataSet(dataSetId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataSetModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataSetModelImpl</code>.
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

	public static DataSet fetchDataSet(long dataSetId) {
		return getService().fetchDataSet(dataSetId);
	}

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchDataSetByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataSetByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DataSet> getAllDataSets() {
		return getService().getAllDataSets();
	}

	public static List<DataSet> getAllDataSets(int start, int end) {
		return getService().getAllDataSets(start, end);
	}

	public static List<DataSet> getAllDataSets(
		int start, int end, OrderByComparator<DataSet> comparator) {

		return getService().getAllDataSets(start, end, comparator);
	}

	public static List<DataSet> getApprovedDataSets(long groupId) {
		return getService().getApprovedDataSets(groupId);
	}

	public static List<DataSet> getApprovedDataSets(
		long groupId, int start, int end) {

		return getService().getApprovedDataSets(groupId, start, end);
	}

	public static List<DataSet> getApprovedDataSets(
		long groupId, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getApprovedDataSets(
			groupId, start, end, comparator);
	}

	/**
	 * Returns the data set with the primary key.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set
	 * @throws PortalException if a data set with the primary key could not be found
	 */
	public static DataSet getDataSet(long dataSetId) throws PortalException {
		return getService().getDataSet(dataSetId);
	}

	public static DataSet getDataSet(String dataSetName, String dataSetVersion)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getService().getDataSet(dataSetName, dataSetVersion);
	}

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set
	 * @throws PortalException if a matching data set could not be found
	 */
	public static DataSet getDataSetByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getDataSetByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of data sets
	 */
	public static List<DataSet> getDataSets(int start, int end) {
		return getService().getDataSets(start, end);
	}

	public static List<DataSet> getDataSetsByG_S(long groupId, int status) {
		return getService().getDataSetsByG_S(groupId, status);
	}

	public static List<DataSet> getDataSetsByG_S(
		long groupId, int status, int start, int end) {

		return getService().getDataSetsByG_S(groupId, status, start, end);
	}

	public static List<DataSet> getDataSetsByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByG_S(
			groupId, status, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status) {

		return getService().getDataSetsByG_U_S(groupId, userId, status);
	}

	public static List<DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getService().getDataSetsByG_U_S(
			groupId, userId, status, start, end);
	}

	public static List<DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByGroupId(long groupId) {
		return getService().getDataSetsByGroupId(groupId);
	}

	public static List<DataSet> getDataSetsByGroupId(
		long groupId, int start, int end) {

		return getService().getDataSetsByGroupId(groupId, start, end);
	}

	public static List<DataSet> getDataSetsByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByGroupId(
			groupId, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByName(String dataSetName) {
		return getService().getDataSetsByName(dataSetName);
	}

	public static List<DataSet> getDataSetsByName(
		String dataSetName, int start, int end) {

		return getService().getDataSetsByName(dataSetName, start, end);
	}

	public static List<DataSet> getDataSetsByName(
		String dataSetName, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByName(
			dataSetName, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByStatus(int status) {
		return getService().getDataSetsByStatus(status);
	}

	public static List<DataSet> getDataSetsByStatus(
		int status, int start, int end) {

		return getService().getDataSetsByStatus(status, start, end);
	}

	public static List<DataSet> getDataSetsByStatus(
		int status, int start, int end, OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByStatus(status, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByU_S(long userId, int status) {
		return getService().getDataSetsByU_S(userId, status);
	}

	public static List<DataSet> getDataSetsByU_S(
		long userId, int status, int start, int end) {

		return getService().getDataSetsByU_S(userId, status, start, end);
	}

	public static List<DataSet> getDataSetsByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByU_S(
			userId, status, start, end, comparator);
	}

	public static List<DataSet> getDataSetsByUserId(long userId) {
		return getService().getDataSetsByUserId(userId);
	}

	public static List<DataSet> getDataSetsByUserId(
		long userId, int start, int end) {

		return getService().getDataSetsByUserId(userId, start, end);
	}

	public static List<DataSet> getDataSetsByUserId(
		long userId, int start, int end,
		OrderByComparator<DataSet> comparator) {

		return getService().getDataSetsByUserId(userId, start, end, comparator);
	}

	/**
	 * Returns all the data sets matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sets
	 * @param companyId the primary key of the company
	 * @return the matching data sets, or an empty list if no matches were found
	 */
	public static List<DataSet> getDataSetsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataSetsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of data sets matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data sets, or an empty list if no matches were found
	 */
	public static List<DataSet> getDataSetsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getService().getDataSetsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data sets.
	 *
	 * @return the number of data sets
	 */
	public static int getDataSetsCount() {
		return getService().getDataSetsCount();
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

	public static DataSet removeDataSet(long dataSetId) throws PortalException {
		return getService().removeDataSet(dataSetId);
	}

	public static void removeDataSets(long[] dataSetIds)
		throws PortalException {

		getService().removeDataSets(dataSetIds);
	}

	/**
	 * Updates the data set in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataSetLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataSet the data set
	 * @return the data set that was updated
	 */
	public static DataSet updateDataSet(DataSet dataSet) {
		return getService().updateDataSet(dataSet);
	}

	public static DataSet updateDataSet(
			long dataSetId, String dataSetName, String dataSetVersion,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDataSet(
			dataSetId, dataSetName, dataSetVersion, displayNameMap,
			descriptionMap, status, sc);
	}

	public static DataSet updateStatus(
			long userId, long dataSetId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, dataSetId, status, sc);
	}

	public static DataSetLocalService getService() {
		return _service;
	}

	private static volatile DataSetLocalService _service;

}