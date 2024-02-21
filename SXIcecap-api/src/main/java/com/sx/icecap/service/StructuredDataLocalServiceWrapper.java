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
 * Provides a wrapper for {@link StructuredDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataLocalService
 * @generated
 */
public class StructuredDataLocalServiceWrapper
	implements ServiceWrapper<StructuredDataLocalService>,
			   StructuredDataLocalService {

	public StructuredDataLocalServiceWrapper(
		StructuredDataLocalService structuredDataLocalService) {

		_structuredDataLocalService = structuredDataLocalService;
	}

	@Override
	public com.sx.icecap.model.StructuredData addStructuredData(
			long dataSetId, long dataTypeId, String data, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.addStructuredData(
			dataSetId, dataTypeId, data, status, sc);
	}

	/**
	 * Adds the structured data to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was added
	 */
	@Override
	public com.sx.icecap.model.StructuredData addStructuredData(
		com.sx.icecap.model.StructuredData structuredData) {

		return _structuredDataLocalService.addStructuredData(structuredData);
	}

	@Override
	public int countAllStructuredDatas() {
		return _structuredDataLocalService.countAllStructuredDatas();
	}

	@Override
	public int countApprovedStructuredDatas(long groupId) {
		return _structuredDataLocalService.countApprovedStructuredDatas(
			groupId);
	}

	@Override
	public int countStructuredDatasByDataTypeId(long groupId) {
		return _structuredDataLocalService.countStructuredDatasByDataTypeId(
			groupId);
	}

	@Override
	public int countStructuredDatasByDataTypeId_G(
		long dataTypeId, long groupId) {

		return _structuredDataLocalService.countStructuredDatasByDataTypeId_G(
			dataTypeId, groupId);
	}

	@Override
	public int countStructuredDatasByDataTypeId_G_S(
		long dataTypeId, long groupId, int status) {

		return _structuredDataLocalService.countStructuredDatasByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	@Override
	public int countStructuredDatasByDataTypeId_S(long dataTypeId, int status) {
		return _structuredDataLocalService.countStructuredDatasByDataTypeId_S(
			dataTypeId, status);
	}

	@Override
	public int countStructuredDatasByDataTypeId_U(
		long dataTypeId, long userId) {

		return _structuredDataLocalService.countStructuredDatasByDataTypeId_U(
			dataTypeId, userId);
	}

	@Override
	public int countStructuredDatasByDataTypeId_U_S(
		long dataTypeId, long userId, int status) {

		return _structuredDataLocalService.countStructuredDatasByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	@Override
	public int countStructuredDatasByG_S(long groupId, int status) {
		return _structuredDataLocalService.countStructuredDatasByG_S(
			groupId, status);
	}

	@Override
	public int countStructuredDatasByG_U_S(
		long groupId, long userId, int status) {

		return _structuredDataLocalService.countStructuredDatasByG_U_S(
			groupId, userId, status);
	}

	@Override
	public int countStructuredDatasByG_U_SDataTypeId_(
		long dataTypeId, long groupId, long userId, int status) {

		return _structuredDataLocalService.
			countStructuredDatasByG_U_SDataTypeId_(
				dataTypeId, groupId, userId, status);
	}

	@Override
	public int countStructuredDatasByGroupId(long groupId) {
		return _structuredDataLocalService.countStructuredDatasByGroupId(
			groupId);
	}

	@Override
	public int countStructuredDatasByStatus(int status) {
		return _structuredDataLocalService.countStructuredDatasByStatus(status);
	}

	@Override
	public int countStructuredDatasByU_S(long userId, int status) {
		return _structuredDataLocalService.countStructuredDatasByU_S(
			userId, status);
	}

	@Override
	public int countStructuredDatasByUserId(long userId) {
		return _structuredDataLocalService.countStructuredDatasByUserId(userId);
	}

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	@Override
	public com.sx.icecap.model.StructuredData createStructuredData(
		long structuredDataId) {

		return _structuredDataLocalService.createStructuredData(
			structuredDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws PortalException if a structured data with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.StructuredData deleteStructuredData(
			long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.deleteStructuredData(
			structuredDataId);
	}

	/**
	 * Deletes the structured data from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was removed
	 */
	@Override
	public com.sx.icecap.model.StructuredData deleteStructuredData(
		com.sx.icecap.model.StructuredData structuredData) {

		return _structuredDataLocalService.deleteStructuredData(structuredData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _structuredDataLocalService.dynamicQuery();
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

		return _structuredDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
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

		return _structuredDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
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

		return _structuredDataLocalService.dynamicQuery(
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

		return _structuredDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _structuredDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.StructuredData fetchStructuredData(
		long structuredDataId) {

		return _structuredDataLocalService.fetchStructuredData(
			structuredDataId);
	}

	/**
	 * Returns the structured data matching the UUID and group.
	 *
	 * @param uuid the structured data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public com.sx.icecap.model.StructuredData
		fetchStructuredDataByUuidAndGroupId(String uuid, long groupId) {

		return _structuredDataLocalService.fetchStructuredDataByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _structuredDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getAllStructuredDatas() {

		return _structuredDataLocalService.getAllStructuredDatas();
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getAllStructuredDatas(int start, int end) {

		return _structuredDataLocalService.getAllStructuredDatas(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getAllStructuredDatas(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getAllStructuredDatas(
			start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getApprovedStructuredDatas(long groupId) {

		return _structuredDataLocalService.getApprovedStructuredDatas(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getApprovedStructuredDatas(long groupId, int start, int end) {

		return _structuredDataLocalService.getApprovedStructuredDatas(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getApprovedStructuredDatas(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getApprovedStructuredDatas(
			groupId, start, end, comparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _structuredDataLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _structuredDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _structuredDataLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer
					<com.sx.icecap.model.StructuredData> searchContainer)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.getSearchContainerResults(
			searchContainer);
	}

	/**
	 * Returns the structured data with the primary key.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws PortalException if a structured data with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.StructuredData getStructuredData(
			long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.getStructuredData(structuredDataId);
	}

	/**
	 * Returns the structured data matching the UUID and group.
	 *
	 * @param uuid the structured data's UUID
	 * @param groupId the primary key of the group
	 * @return the matching structured data
	 * @throws PortalException if a matching structured data could not be found
	 */
	@Override
	public com.sx.icecap.model.StructuredData getStructuredDataByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.getStructuredDataByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getStructuredDataJSON(
			long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.getStructuredDataJSON(
			structuredDataId);
	}

	/**
	 * Returns a range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of structured datas
	 */
	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatas(int start, int end) {

		return _structuredDataLocalService.getStructuredDatas(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId(long dataTypeId) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId(
			dataTypeId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId(long dataTypeId, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId(
			dataTypeId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId(
			long dataTypeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId(
			dataTypeId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G(long dataTypeId, long groupId) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G(
			dataTypeId, groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G(
			long dataTypeId, long groupId, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G(
			dataTypeId, groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G(
			long dataTypeId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G(
			dataTypeId, groupId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_S(
			long dataTypeId, long groupId, int status) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_S(
			dataTypeId, groupId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_S(
			long dataTypeId, long groupId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_S(
			long dataTypeId, long groupId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_S(
			dataTypeId, groupId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_U_S(
			long dataTypeId, long groupId, long userId, int status) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_U_S(
			long dataTypeId, long groupId, long userId, int status, int start,
			int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_G_U_S(
			long dataTypeId, long groupId, long userId, int status, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_G_U_S(
			dataTypeId, groupId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_S(long dataTypeId, int status) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_S(
			dataTypeId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_S(
			long dataTypeId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_S(
			dataTypeId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_S(
			long dataTypeId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_S(
			dataTypeId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U(long dataTypeId, long userId) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U(
			dataTypeId, userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U(
			long dataTypeId, long userId, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U(
			dataTypeId, userId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U(
			long dataTypeId, long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U(
			dataTypeId, userId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U_S(
			long dataTypeId, long userId, int status) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U_S(
			dataTypeId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U_S(
			long dataTypeId, long userId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U_S(
			dataTypeId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByDataTypeId_U_S(
			long dataTypeId, long userId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByDataTypeId_U_S(
			dataTypeId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_S(long groupId, int status) {

		return _structuredDataLocalService.getStructuredDatasByG_S(
			groupId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_S(long groupId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByG_S(
			groupId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_S(
			long groupId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByG_S(
			groupId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_U_S(long groupId, long userId, int status) {

		return _structuredDataLocalService.getStructuredDatasByG_U_S(
			groupId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_U_S(
			long groupId, long userId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByG_U_S(
			groupId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByG_U_S(
			long groupId, long userId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByGroupId(long groupId) {

		return _structuredDataLocalService.getStructuredDatasByGroupId(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByGroupId(long groupId, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByStatus(int status) {

		return _structuredDataLocalService.getStructuredDatasByStatus(status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByStatus(int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByStatus(
			status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByStatus(
			int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByStatus(
			status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByU_S(long userId, int status) {

		return _structuredDataLocalService.getStructuredDatasByU_S(
			userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByU_S(long userId, int status, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByU_S(
			userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByU_S(
			long userId, int status, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByU_S(
			userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByUserId(long userId) {

		return _structuredDataLocalService.getStructuredDatasByUserId(userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByUserId(long userId, int start, int end) {

		return _structuredDataLocalService.getStructuredDatasByUserId(
			userId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByUserId(
			long userId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> comparator) {

		return _structuredDataLocalService.getStructuredDatasByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the structured datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the structured datas
	 * @param companyId the primary key of the company
	 * @return the matching structured datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByUuidAndCompanyId(String uuid, long companyId) {

		return _structuredDataLocalService.getStructuredDatasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of structured datas matching the UUID and company.
	 *
	 * @param uuid the UUID of the structured datas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching structured datas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.StructuredData> orderByComparator) {

		return _structuredDataLocalService.getStructuredDatasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	@Override
	public int getStructuredDatasCount() {
		return _structuredDataLocalService.getStructuredDatasCount();
	}

	@Override
	public com.sx.icecap.model.StructuredData removeStructuredData(
			long structuredDataId, long dataFileFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.removeStructuredData(
			structuredDataId, dataFileFolderId);
	}

	@Override
	public com.sx.icecap.model.StructuredData updateStatus(
			long userId, long structuredDataId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _structuredDataLocalService.updateStatus(
			userId, structuredDataId, status, sc);
	}

	@Override
	public com.sx.icecap.model.StructuredData updateStructuredData(
			long structuredDataId, long dataSetId, long dataTypeId, String data,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _structuredDataLocalService.updateStructuredData(
			structuredDataId, dataSetId, dataTypeId, data, status, sc);
	}

	/**
	 * Updates the structured data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StructuredDataLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param structuredData the structured data
	 * @return the structured data that was updated
	 */
	@Override
	public com.sx.icecap.model.StructuredData updateStructuredData(
		com.sx.icecap.model.StructuredData structuredData) {

		return _structuredDataLocalService.updateStructuredData(structuredData);
	}

	@Override
	public StructuredDataLocalService getWrappedService() {
		return _structuredDataLocalService;
	}

	@Override
	public void setWrappedService(
		StructuredDataLocalService structuredDataLocalService) {

		_structuredDataLocalService = structuredDataLocalService;
	}

	private StructuredDataLocalService _structuredDataLocalService;

}