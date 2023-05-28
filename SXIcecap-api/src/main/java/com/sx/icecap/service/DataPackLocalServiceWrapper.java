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
 * Provides a wrapper for {@link DataPackLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackLocalService
 * @generated
 */
public class DataPackLocalServiceWrapper
	implements DataPackLocalService, ServiceWrapper<DataPackLocalService> {

	public DataPackLocalServiceWrapper(
		DataPackLocalService dataPackLocalService) {

		_dataPackLocalService = dataPackLocalService;
	}

	/**
	 * Adds the data pack to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was added
	 */
	@Override
	public com.sx.icecap.model.DataPack addDataPack(
		com.sx.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.addDataPack(dataPack);
	}

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	@Override
	public com.sx.icecap.model.DataPack createDataPack(long dataPackId) {
		return _dataPackLocalService.createDataPack(dataPackId);
	}

	/**
	 * Deletes the data pack from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was removed
	 */
	@Override
	public com.sx.icecap.model.DataPack deleteDataPack(
		com.sx.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.deleteDataPack(dataPack);
	}

	/**
	 * Deletes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPack deleteDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.deleteDataPack(dataPackId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataPackLocalService.dynamicQuery();
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

		return _dataPackLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
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

		return _dataPackLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
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

		return _dataPackLocalService.dynamicQuery(
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

		return _dataPackLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataPackLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataPack fetchDataPack(long dataPackId) {
		return _dataPackLocalService.fetchDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPack fetchDataPackByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataPackLocalService.fetchDataPackByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataPackLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data pack with the primary key.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPack getDataPack(long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getDataPack(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack
	 * @throws PortalException if a matching data pack could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPack getDataPackByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getDataPackByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of data packs
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPack> getDataPacks(
		int start, int end) {

		return _dataPackLocalService.getDataPacks(start, end);
	}

	/**
	 * Returns all the data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @return the matching data packs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(String uuid, long companyId) {

		return _dataPackLocalService.getDataPacksByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data packs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPack>
		getDataPacksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.DataPack> orderByComparator) {

		return _dataPackLocalService.getDataPacksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	@Override
	public int getDataPacksCount() {
		return _dataPackLocalService.getDataPacksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataPackLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataPackLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataPackLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the data pack in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was updated
	 */
	@Override
	public com.sx.icecap.model.DataPack updateDataPack(
		com.sx.icecap.model.DataPack dataPack) {

		return _dataPackLocalService.updateDataPack(dataPack);
	}

	@Override
	public DataPackLocalService getWrappedService() {
		return _dataPackLocalService;
	}

	@Override
	public void setWrappedService(DataPackLocalService dataPackLocalService) {
		_dataPackLocalService = dataPackLocalService;
	}

	private DataPackLocalService _dataPackLocalService;

}