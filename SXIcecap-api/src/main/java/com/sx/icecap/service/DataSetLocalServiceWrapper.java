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
 * Provides a wrapper for {@link DataSetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataSetLocalService
 * @generated
 */
public class DataSetLocalServiceWrapper
	implements DataSetLocalService, ServiceWrapper<DataSetLocalService> {

	public DataSetLocalServiceWrapper(DataSetLocalService dataSetLocalService) {
		_dataSetLocalService = dataSetLocalService;
	}

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
	@Override
	public com.sx.icecap.model.DataSet addDataSet(
		com.sx.icecap.model.DataSet dataSet) {

		return _dataSetLocalService.addDataSet(dataSet);
	}

	@Override
	public com.sx.icecap.model.DataSet addDataSet(
			String dataSetName, String dataSetVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.addDataSet(
			dataSetName, dataSetVersion, displayNameMap, descriptionMap, status,
			sc);
	}

	@Override
	public int countAllDataSets() {
		return _dataSetLocalService.countAllDataSets();
	}

	@Override
	public int countApprovedDataSets(long groupId) {
		return _dataSetLocalService.countApprovedDataSets(groupId);
	}

	@Override
	public int countDataSetsByG_S(long groupId, int status) {
		return _dataSetLocalService.countDataSetsByG_S(groupId, status);
	}

	@Override
	public int countDataSetsByG_U_S(long groupId, long userId, int status) {
		return _dataSetLocalService.countDataSetsByG_U_S(
			groupId, userId, status);
	}

	@Override
	public int countDataSetsByGroupId(long groupId) {
		return _dataSetLocalService.countDataSetsByGroupId(groupId);
	}

	@Override
	public int countDataSetsByName(String dataSetName) {
		return _dataSetLocalService.countDataSetsByName(dataSetName);
	}

	@Override
	public int countDataSetsByStatus(int status) {
		return _dataSetLocalService.countDataSetsByStatus(status);
	}

	@Override
	public int countDataSetsByU_S(long userId, int status) {
		return _dataSetLocalService.countDataSetsByU_S(userId, status);
	}

	@Override
	public int countDataSetsByUserId(long userId) {
		return _dataSetLocalService.countDataSetsByUserId(userId);
	}

	/**
	 * Creates a new data set with the primary key. Does not add the data set to the database.
	 *
	 * @param dataSetId the primary key for the new data set
	 * @return the new data set
	 */
	@Override
	public com.sx.icecap.model.DataSet createDataSet(long dataSetId) {
		return _dataSetLocalService.createDataSet(dataSetId);
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
	@Override
	public com.sx.icecap.model.DataSet deleteDataSet(
		com.sx.icecap.model.DataSet dataSet) {

		return _dataSetLocalService.deleteDataSet(dataSet);
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
	@Override
	public com.sx.icecap.model.DataSet deleteDataSet(long dataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.deleteDataSet(dataSetId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataSetLocalService.dynamicQuery();
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

		return _dataSetLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _dataSetLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _dataSetLocalService.dynamicQuery(
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

		return _dataSetLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataSetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataSet fetchDataSet(long dataSetId) {
		return _dataSetLocalService.fetchDataSet(dataSetId);
	}

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	@Override
	public com.sx.icecap.model.DataSet fetchDataSetByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataSetLocalService.fetchDataSetByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataSetLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getAllDataSets() {
		return _dataSetLocalService.getAllDataSets();
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getAllDataSets(
		int start, int end) {

		return _dataSetLocalService.getAllDataSets(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getAllDataSets(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getAllDataSets(start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getApprovedDataSets(
		long groupId) {

		return _dataSetLocalService.getApprovedDataSets(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getApprovedDataSets(
		long groupId, int start, int end) {

		return _dataSetLocalService.getApprovedDataSets(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getApprovedDataSets(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getApprovedDataSets(
			groupId, start, end, comparator);
	}

	/**
	 * Returns the data set with the primary key.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set
	 * @throws PortalException if a data set with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataSet getDataSet(long dataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.getDataSet(dataSetId);
	}

	@Override
	public com.sx.icecap.model.DataSet getDataSet(
			String dataSetName, String dataSetVersion)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return _dataSetLocalService.getDataSet(dataSetName, dataSetVersion);
	}

	/**
	 * Returns the data set matching the UUID and group.
	 *
	 * @param uuid the data set's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data set
	 * @throws PortalException if a matching data set could not be found
	 */
	@Override
	public com.sx.icecap.model.DataSet getDataSetByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.getDataSetByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSets(
		int start, int end) {

		return _dataSetLocalService.getDataSets(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_S(
		long groupId, int status) {

		return _dataSetLocalService.getDataSetsByG_S(groupId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_S(
		long groupId, int status, int start, int end) {

		return _dataSetLocalService.getDataSetsByG_S(
			groupId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByG_S(
			groupId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status) {

		return _dataSetLocalService.getDataSetsByG_U_S(groupId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return _dataSetLocalService.getDataSetsByG_U_S(
			groupId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByGroupId(
		long groupId) {

		return _dataSetLocalService.getDataSetsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByGroupId(
		long groupId, int start, int end) {

		return _dataSetLocalService.getDataSetsByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByName(
		String dataSetName) {

		return _dataSetLocalService.getDataSetsByName(dataSetName);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByName(
		String dataSetName, int start, int end) {

		return _dataSetLocalService.getDataSetsByName(dataSetName, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByName(
		String dataSetName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByName(
			dataSetName, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByStatus(
		int status) {

		return _dataSetLocalService.getDataSetsByStatus(status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByStatus(
		int status, int start, int end) {

		return _dataSetLocalService.getDataSetsByStatus(status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByStatus(
			status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByU_S(
		long userId, int status) {

		return _dataSetLocalService.getDataSetsByU_S(userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByU_S(
		long userId, int status, int start, int end) {

		return _dataSetLocalService.getDataSetsByU_S(
			userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByU_S(
			userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByUserId(
		long userId) {

		return _dataSetLocalService.getDataSetsByUserId(userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByUserId(
		long userId, int start, int end) {

		return _dataSetLocalService.getDataSetsByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataSet> getDataSetsByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataSet> comparator) {

		return _dataSetLocalService.getDataSetsByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the data sets matching the UUID and company.
	 *
	 * @param uuid the UUID of the data sets
	 * @param companyId the primary key of the company
	 * @return the matching data sets, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataSet>
		getDataSetsByUuidAndCompanyId(String uuid, long companyId) {

		return _dataSetLocalService.getDataSetsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.sx.icecap.model.DataSet>
		getDataSetsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.DataSet> orderByComparator) {

		return _dataSetLocalService.getDataSetsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data sets.
	 *
	 * @return the number of data sets
	 */
	@Override
	public int getDataSetsCount() {
		return _dataSetLocalService.getDataSetsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataSetLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataSetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataSetLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.sx.icecap.model.DataSet removeDataSet(long dataSetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.removeDataSet(dataSetId);
	}

	@Override
	public void removeDataSets(long[] dataSetIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataSetLocalService.removeDataSets(dataSetIds);
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
	@Override
	public com.sx.icecap.model.DataSet updateDataSet(
		com.sx.icecap.model.DataSet dataSet) {

		return _dataSetLocalService.updateDataSet(dataSet);
	}

	@Override
	public com.sx.icecap.model.DataSet updateDataSet(
			long dataSetId, String dataSetName, String dataSetVersion,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataSetLocalService.updateDataSet(
			dataSetId, dataSetName, dataSetVersion, displayNameMap,
			descriptionMap, status, sc);
	}

	@Override
	public com.sx.icecap.model.DataSet updateStatus(
			long userId, long dataSetId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dataSetLocalService.updateStatus(userId, dataSetId, status, sc);
	}

	@Override
	public DataSetLocalService getWrappedService() {
		return _dataSetLocalService;
	}

	@Override
	public void setWrappedService(DataSetLocalService dataSetLocalService) {
		_dataSetLocalService = dataSetLocalService;
	}

	private DataSetLocalService _dataSetLocalService;

}