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
 * Provides a wrapper for {@link DataPackStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackStructureLocalService
 * @generated
 */
public class DataPackStructureLocalServiceWrapper
	implements DataPackStructureLocalService,
			   ServiceWrapper<DataPackStructureLocalService> {

	public DataPackStructureLocalServiceWrapper(
		DataPackStructureLocalService dataPackStructureLocalService) {

		_dataPackStructureLocalService = dataPackStructureLocalService;
	}

	/**
	 * Adds the data pack structure to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackStructure the data pack structure
	 * @return the data pack structure that was added
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure addDataPackStructure(
		com.sx.icecap.model.DataPackStructure dataPackStructure) {

		return _dataPackStructureLocalService.addDataPackStructure(
			dataPackStructure);
	}

	/**
	 * Creates a new data pack structure with the primary key. Does not add the data pack structure to the database.
	 *
	 * @param dataPackId the primary key for the new data pack structure
	 * @return the new data pack structure
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure createDataPackStructure(
		long dataPackId) {

		return _dataPackStructureLocalService.createDataPackStructure(
			dataPackId);
	}

	/**
	 * Deletes the data pack structure from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackStructure the data pack structure
	 * @return the data pack structure that was removed
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure deleteDataPackStructure(
		com.sx.icecap.model.DataPackStructure dataPackStructure) {

		return _dataPackStructureLocalService.deleteDataPackStructure(
			dataPackStructure);
	}

	/**
	 * Deletes the data pack structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure that was removed
	 * @throws PortalException if a data pack structure with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure deleteDataPackStructure(
			long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackStructureLocalService.deleteDataPackStructure(
			dataPackId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackStructureLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataPackStructureLocalService.dynamicQuery();
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

		return _dataPackStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackStructureModelImpl</code>.
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

		return _dataPackStructureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackStructureModelImpl</code>.
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

		return _dataPackStructureLocalService.dynamicQuery(
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

		return _dataPackStructureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataPackStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataPackStructure fetchDataPackStructure(
		long dataPackId) {

		return _dataPackStructureLocalService.fetchDataPackStructure(
			dataPackId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataPackStructureLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the data pack structure with the primary key.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure
	 * @throws PortalException if a data pack structure with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure getDataPackStructure(
			long dataPackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackStructureLocalService.getDataPackStructure(dataPackId);
	}

	/**
	 * Returns a range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @return the range of data pack structures
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataPackStructure>
		getDataPackStructures(int start, int end) {

		return _dataPackStructureLocalService.getDataPackStructures(start, end);
	}

	/**
	 * Returns the number of data pack structures.
	 *
	 * @return the number of data pack structures
	 */
	@Override
	public int getDataPackStructuresCount() {
		return _dataPackStructureLocalService.getDataPackStructuresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataPackStructureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataPackStructureLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataPackStructureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the data pack structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackStructureLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackStructure the data pack structure
	 * @return the data pack structure that was updated
	 */
	@Override
	public com.sx.icecap.model.DataPackStructure updateDataPackStructure(
		com.sx.icecap.model.DataPackStructure dataPackStructure) {

		return _dataPackStructureLocalService.updateDataPackStructure(
			dataPackStructure);
	}

	@Override
	public DataPackStructureLocalService getWrappedService() {
		return _dataPackStructureLocalService;
	}

	@Override
	public void setWrappedService(
		DataPackStructureLocalService dataPackStructureLocalService) {

		_dataPackStructureLocalService = dataPackStructureLocalService;
	}

	private DataPackStructureLocalService _dataPackStructureLocalService;

}