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
 * Provides a wrapper for {@link DataPackEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntryLocalService
 * @generated
 */
public class DataPackEntryLocalServiceWrapper
	implements DataPackEntryLocalService,
			   ServiceWrapper<DataPackEntryLocalService> {

	public DataPackEntryLocalServiceWrapper(
		DataPackEntryLocalService dataPackEntryLocalService) {

		_dataPackEntryLocalService = dataPackEntryLocalService;
	}

	/**
	 * Adds the data pack entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was added
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry addDataPackEntry(
		com.sx.icecap.model.DataPackEntry dataPackEntry) {

		return _dataPackEntryLocalService.addDataPackEntry(dataPackEntry);
	}

	/**
	 * Creates a new data pack entry with the primary key. Does not add the data pack entry to the database.
	 *
	 * @param dataPackEntryId the primary key for the new data pack entry
	 * @return the new data pack entry
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry createDataPackEntry(
		long dataPackEntryId) {

		return _dataPackEntryLocalService.createDataPackEntry(dataPackEntryId);
	}

	/**
	 * Deletes the data pack entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was removed
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry deleteDataPackEntry(
		com.sx.icecap.model.DataPackEntry dataPackEntry) {

		return _dataPackEntryLocalService.deleteDataPackEntry(dataPackEntry);
	}

	/**
	 * Deletes the data pack entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry that was removed
	 * @throws PortalException if a data pack entry with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry deleteDataPackEntry(
			long dataPackEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackEntryLocalService.deleteDataPackEntry(dataPackEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataPackEntryLocalService.dynamicQuery();
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

		return _dataPackEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
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

		return _dataPackEntryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
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

		return _dataPackEntryLocalService.dynamicQuery(
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

		return _dataPackEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataPackEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataPackEntry fetchDataPackEntry(
		long dataPackEntryId) {

		return _dataPackEntryLocalService.fetchDataPackEntry(dataPackEntryId);
	}

	/**
	 * Returns the data pack entry matching the UUID and group.
	 *
	 * @param uuid the data pack entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry fetchDataPackEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataPackEntryLocalService.fetchDataPackEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataPackEntryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the data pack entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of data pack entries
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPackEntry> getDataPackEntries(
		int start, int end) {

		return _dataPackEntryLocalService.getDataPackEntries(start, end);
	}

	/**
	 * Returns all the data pack entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data pack entries
	 * @param companyId the primary key of the company
	 * @return the matching data pack entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPackEntry>
		getDataPackEntriesByUuidAndCompanyId(String uuid, long companyId) {

		return _dataPackEntryLocalService.getDataPackEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data pack entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data pack entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data pack entries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPackEntry>
		getDataPackEntriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.DataPackEntry> orderByComparator) {

		return _dataPackEntryLocalService.getDataPackEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data pack entries.
	 *
	 * @return the number of data pack entries
	 */
	@Override
	public int getDataPackEntriesCount() {
		return _dataPackEntryLocalService.getDataPackEntriesCount();
	}

	/**
	 * Returns the data pack entry with the primary key.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry
	 * @throws PortalException if a data pack entry with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry getDataPackEntry(
			long dataPackEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackEntryLocalService.getDataPackEntry(dataPackEntryId);
	}

	/**
	 * Returns the data pack entry matching the UUID and group.
	 *
	 * @param uuid the data pack entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack entry
	 * @throws PortalException if a matching data pack entry could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry getDataPackEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackEntryLocalService.getDataPackEntryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataPackEntryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataPackEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataPackEntryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the data pack entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was updated
	 */
	@Override
	public com.sx.icecap.model.DataPackEntry updateDataPackEntry(
		com.sx.icecap.model.DataPackEntry dataPackEntry) {

		return _dataPackEntryLocalService.updateDataPackEntry(dataPackEntry);
	}

	@Override
	public DataPackEntryLocalService getWrappedService() {
		return _dataPackEntryLocalService;
	}

	@Override
	public void setWrappedService(
		DataPackEntryLocalService dataPackEntryLocalService) {

		_dataPackEntryLocalService = dataPackEntryLocalService;
	}

	private DataPackEntryLocalService _dataPackEntryLocalService;

}