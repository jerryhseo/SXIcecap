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
 * Provides a wrapper for {@link DataTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeLocalService
 * @generated
 */
public class DataTypeLocalServiceWrapper
	implements DataTypeLocalService, ServiceWrapper<DataTypeLocalService> {

	public DataTypeLocalServiceWrapper(
		DataTypeLocalService dataTypeLocalService) {

		_dataTypeLocalService = dataTypeLocalService;
	}

	/**
	 * Adds the data type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was added
	 */
	@Override
	public com.sx.icecap.model.DataType addDataType(
		com.sx.icecap.model.DataType dataType) {

		return _dataTypeLocalService.addDataType(dataType);
	}

	@Override
	public com.sx.icecap.model.DataType addDataType(
			String dataTypeName, String dataTypeVersion, String extension,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.addDataType(
			dataTypeName, dataTypeVersion, extension, displayNameMap,
			descriptionMap, tooltipMap, status, sc);
	}

	@Override
	public com.sx.icecap.model.StructuredData addStructuredData(
			long dataSetId, long dataTypeId, String data, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.addStructuredData(
			dataSetId, dataTypeId, data, status, sc);
	}

	@Override
	public com.sx.icecap.model.DataType copyDataType(
			long dataTypeId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.copyDataType(dataTypeId, sc);
	}

	@Override
	public int countAllDataTypes() {
		return _dataTypeLocalService.countAllDataTypes();
	}

	@Override
	public int countApprovedDataTypes(long groupId) {
		return _dataTypeLocalService.countApprovedDataTypes(groupId);
	}

	@Override
	public int countDataTypesByG_S(long groupId, int status) {
		return _dataTypeLocalService.countDataTypesByG_S(groupId, status);
	}

	@Override
	public int countDataTypesByG_U_S(long groupId, long userId, int status) {
		return _dataTypeLocalService.countDataTypesByG_U_S(
			groupId, userId, status);
	}

	@Override
	public int countDataTypesByGroupId(long groupId) {
		return _dataTypeLocalService.countDataTypesByGroupId(groupId);
	}

	@Override
	public int countDataTypesByStatus(int status) {
		return _dataTypeLocalService.countDataTypesByStatus(status);
	}

	@Override
	public int countDataTypesByU_S(long userId, int status) {
		return _dataTypeLocalService.countDataTypesByU_S(userId, status);
	}

	@Override
	public int countDataTypesByUserId(long userId) {
		return _dataTypeLocalService.countDataTypesByUserId(userId);
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeId the primary key for the new data type
	 * @return the new data type
	 */
	@Override
	public com.sx.icecap.model.DataType createDataType(long dataTypeId) {
		return _dataTypeLocalService.createDataType(dataTypeId);
	}

	/**
	 * Deletes the data type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was removed
	 */
	@Override
	public com.sx.icecap.model.DataType deleteDataType(
		com.sx.icecap.model.DataType dataType) {

		return _dataTypeLocalService.deleteDataType(dataType);
	}

	/**
	 * Deletes the data type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type that was removed
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataType deleteDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.deleteDataType(dataTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dataTypeLocalService.dynamicQuery();
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

		return _dataTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataTypeModelImpl</code>.
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

		return _dataTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataTypeModelImpl</code>.
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

		return _dataTypeLocalService.dynamicQuery(
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

		return _dataTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _dataTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.sx.icecap.model.DataType fetchDataType(long dataTypeId) {
		return _dataTypeLocalService.fetchDataType(dataTypeId);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Override
	public com.sx.icecap.model.DataType fetchDataTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return _dataTypeLocalService.fetchDataTypeByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<String> getAbstractFields(
			long dataTypeId, boolean abstractKey)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getAbstractFields(dataTypeId, abstractKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _dataTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getAllDataTypes() {
		return _dataTypeLocalService.getAllDataTypes();
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getAllDataTypes(
		int start, int end) {

		return _dataTypeLocalService.getAllDataTypes(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getAllDataTypes(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getAllDataTypes(start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getApprovedDataTypes(
		long groupId) {

		return _dataTypeLocalService.getApprovedDataTypes(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getApprovedDataTypes(
		long groupId, int start, int end) {

		return _dataTypeLocalService.getApprovedDataTypes(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getApprovedDataTypes(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getApprovedDataTypes(
			groupId, start, end, comparator);
	}

	@Override
	public long getDataFileFolderId(
			long repositoryId, long parentFoderId, String dataTypeName,
			String dataTypeVersion, long dataId, String termName,
			String termVersion,
			com.liferay.portal.kernel.service.ServiceContext sc,
			boolean createWhenNoExist)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getDataFileFolderId(
			repositoryId, parentFoderId, dataTypeName, dataTypeVersion, dataId,
			termName, termVersion, sc, createWhenNoExist);
	}

	/**
	 * Returns the data type with the primary key.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	@Override
	public com.sx.icecap.model.DataType getDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getDataType(dataTypeId);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type
	 * @throws PortalException if a matching data type could not be found
	 */
	@Override
	public com.sx.icecap.model.DataType getDataTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getDataTypeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the data types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @return the range of data types
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypes(
		int start, int end) {

		return _dataTypeLocalService.getDataTypes(start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_S(
		long groupId, int status) {

		return _dataTypeLocalService.getDataTypesByG_S(groupId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end) {

		return _dataTypeLocalService.getDataTypesByG_S(
			groupId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByG_S(
			groupId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status) {

		return _dataTypeLocalService.getDataTypesByG_U_S(
			groupId, userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return _dataTypeLocalService.getDataTypesByG_U_S(
			groupId, userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByGroupId(
		long groupId) {

		return _dataTypeLocalService.getDataTypesByGroupId(groupId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByGroupId(
		long groupId, int start, int end) {

		return _dataTypeLocalService.getDataTypesByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByGroupId(
			groupId, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByName(
		String dataTypeName) {

		return _dataTypeLocalService.getDataTypesByName(dataTypeName);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByStatus(
		int status) {

		return _dataTypeLocalService.getDataTypesByStatus(status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByStatus(
		int status, int start, int end) {

		return _dataTypeLocalService.getDataTypesByStatus(status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByStatus(
			status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByU_S(
		long userId, int status) {

		return _dataTypeLocalService.getDataTypesByU_S(userId, status);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByU_S(
		long userId, int status, int start, int end) {

		return _dataTypeLocalService.getDataTypesByU_S(
			userId, status, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByU_S(
			userId, status, start, end, comparator);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByUserId(
		long userId) {

		return _dataTypeLocalService.getDataTypesByUserId(userId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByUserId(
		long userId, int start, int end) {

		return _dataTypeLocalService.getDataTypesByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.sx.icecap.model.DataType> getDataTypesByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.sx.icecap.model.DataType> comparator) {

		return _dataTypeLocalService.getDataTypesByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @return the matching data types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataType>
		getDataTypesByUuidAndCompanyId(String uuid, long companyId) {

		return _dataTypeLocalService.getDataTypesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data types
	 * @param end the upper bound of the range of data types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data types, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.sx.icecap.model.DataType>
		getDataTypesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.sx.icecap.model.DataType> orderByComparator) {

		return _dataTypeLocalService.getDataTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	@Override
	public int getDataTypesCount() {
		return _dataTypeLocalService.getDataTypesCount();
	}

	@Override
	public String getDataTypeStructure(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchDataTypeStructureException {

		return _dataTypeLocalService.getDataTypeStructure(dataTypeId);
	}

	/**
	 * Get data structure as a JSON object.
	 *
	 * @return null,	if the data type has no structure
	 JSONObject, if has a proper structure.
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject
			getDataTypeStructureJSONObject(long dataTypeId)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getDataTypeStructureJSONObject(dataTypeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getDLFolderFiles(
		long repositoryId, long folderId) {

		return _dataTypeLocalService.getDLFolderFiles(repositoryId, folderId);
	}

	@Override
	public java.util.List<String> getDownloadableFields(
			long dataTypeId, boolean downloadable)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getDownloadableFields(
			dataTypeId, downloadable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _dataTypeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _dataTypeLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public String getName(long dataTypeId, java.util.Locale locale)
		throws com.sx.icecap.exception.NoSuchDataTypeException {

		return _dataTypeLocalService.getName(dataTypeId, locale);
	}

	@Override
	public com.liferay.portal.kernel.util.OrderByComparator
		<com.sx.icecap.model.DataType> getOrderByNameComparator(
			String orderByCol, String orderByType) {

		return _dataTypeLocalService.getOrderByNameComparator(
			orderByCol, orderByType);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dataTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<String> getSearchableFields(
			long dataTypeId, boolean searchable)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getSearchableFields(
			dataTypeId, searchable);
	}

	@Override
	public com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer
					<com.sx.icecap.model.DataType> searchContainer)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getSearchContainerResults(searchContainer);
	}

	@Override
	public com.sx.icecap.model.StructuredData getStructuredData(
		long structuredDataId) {

		return _dataTypeLocalService.getStructuredData(structuredDataId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatas(long dataTypeId) {

		return _dataTypeLocalService.getStructuredDatas(dataTypeId);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
		getStructuredDatas(long dataTypeId, int start, int end) {

		return _dataTypeLocalService.getStructuredDatas(dataTypeId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
			getStructuredDataWithValues(long dataTypeId, long structuredDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.getStructuredDataWithValues(
			dataTypeId, structuredDataId);
	}

	@Deprecated
	@Override
	public com.liferay.portal.kernel.json.JSONObject
			getStructuredDataWithValues(long dataTypeId, String structuredData)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getStructuredDataWithValues(
			dataTypeId, structuredData);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getTermByName(
			long dataTypeId, String termName)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.getTermByName(dataTypeId, termName);
	}

	@Override
	public java.util.Map<String, Object> parseStructuredData(
		String termDelimiter, String valueDelimiter, String structuredData) {

		return _dataTypeLocalService.parseStructuredData(
			termDelimiter, valueDelimiter, structuredData);
	}

	@Override
	public java.util.List<com.sx.icecap.model.StructuredData>
			performAdvancedSearchOnStructuredData(
				long dataTypeId, String advancedQuery, int start, int end)
		throws com.liferay.portal.kernel.json.JSONException {

		return _dataTypeLocalService.performAdvancedSearchOnStructuredData(
			dataTypeId, advancedQuery, start, end);
	}

	@Override
	public com.sx.icecap.model.DataType removeDataType(long dataTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.removeDataType(dataTypeId);
	}

	@Override
	public void removeDataTypes(long[] dataTypeIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dataTypeLocalService.removeDataTypes(dataTypeIds);
	}

	@Override
	public void removeDataTypeStructure(long dataTypeId) {
		_dataTypeLocalService.removeDataTypeStructure(dataTypeId);
	}

	@Override
	public com.sx.icecap.model.StructuredData removeStructuredData(
			long structuredDataId, long dataFileFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.removeStructuredData(
			structuredDataId, dataFileFolderId);
	}

	/**
	 * Set the data structure for the dataType specified by dataTypeId.
	 *
	 * @since 1.0
	 * @see com.sx.icecap.datatype.service
	 * @author Jerry H. Seo
	 * @param long Datatype ID
	 String Data Structure
	 * @throws void
	 * @return void
	 */
	@Override
	public void setDataTypeStructure(long dataTypeId, String dataStructure) {
		_dataTypeLocalService.setDataTypeStructure(dataTypeId, dataStructure);
	}

	/**
	 * Updates the data type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataType the data type
	 * @return the data type that was updated
	 */
	@Override
	public com.sx.icecap.model.DataType updateDataType(
		com.sx.icecap.model.DataType dataType) {

		return _dataTypeLocalService.updateDataType(dataType);
	}

	@Override
	public com.sx.icecap.model.DataType updateDataType(
			long dataTypeId, String dataTypeName, String dataTypeVersion,
			String extension,
			java.util.Map<java.util.Locale, String> displayNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> tooltipMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.updateDataType(
			dataTypeId, dataTypeName, dataTypeVersion, extension,
			displayNameMap, descriptionMap, tooltipMap, status, sc);
	}

	@Override
	public com.sx.icecap.model.DataType updateStatus(
			long userId, long dataTypeId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dataTypeLocalService.updateStatus(
			userId, dataTypeId, status, sc);
	}

	@Override
	public com.sx.icecap.model.StructuredData updateStructuredData(
			long structuredDataId, long dataSetId, long dataTypeId, String data,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dataTypeLocalService.updateStructuredData(
			structuredDataId, dataSetId, dataTypeId, data, status, sc);
	}

	@Override
	public com.sx.icecap.model.StructuredData updateStructuredDataStatus(
			long userId, long structuredDataId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _dataTypeLocalService.updateStructuredDataStatus(
			userId, structuredDataId, status, sc);
	}

	@Override
	public DataTypeLocalService getWrappedService() {
		return _dataTypeLocalService;
	}

	@Override
	public void setWrappedService(DataTypeLocalService dataTypeLocalService) {
		_dataTypeLocalService = dataTypeLocalService;
	}

	private DataTypeLocalService _dataTypeLocalService;

}