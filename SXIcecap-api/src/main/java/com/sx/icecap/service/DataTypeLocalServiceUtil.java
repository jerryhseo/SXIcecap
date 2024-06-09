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

import com.sx.icecap.model.DataType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for DataType. This utility wraps
 * <code>com.sx.icecap.service.impl.DataTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeLocalService
 * @generated
 */
public class DataTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static DataType addDataType(DataType dataType) {
		return getService().addDataType(dataType);
	}

	public static DataType addDataType(
			String dataTypeName, String dataTypeVersion, String extension,
			Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap,
			Map<java.util.Locale, String> tooltipMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addDataType(
			dataTypeName, dataTypeVersion, extension, displayNameMap,
			descriptionMap, tooltipMap, status, sc);
	}

	public static com.sx.icecap.model.StructuredData addStructuredData(
			long dataSetId, long dataTypeId, String data, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addStructuredData(
			dataSetId, dataTypeId, data, status, sc);
	}

	public static DataType copyDataType(
			long dataTypeId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().copyDataType(dataTypeId, sc);
	}

	public static int countAllDataTypes() {
		return getService().countAllDataTypes();
	}

	public static int countApprovedDataTypes(long groupId) {
		return getService().countApprovedDataTypes(groupId);
	}

	public static int countDataTypesByG_S(long groupId, int status) {
		return getService().countDataTypesByG_S(groupId, status);
	}

	public static int countDataTypesByG_U_S(
		long groupId, long userId, int status) {

		return getService().countDataTypesByG_U_S(groupId, userId, status);
	}

	public static int countDataTypesByGroupId(long groupId) {
		return getService().countDataTypesByGroupId(groupId);
	}

	public static int countDataTypesByStatus(int status) {
		return getService().countDataTypesByStatus(status);
	}

	public static int countDataTypesByU_S(long userId, int status) {
		return getService().countDataTypesByU_S(userId, status);
	}

	public static int countDataTypesByUserId(long userId) {
		return getService().countDataTypesByUserId(userId);
	}

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeId the primary key for the new data type
	 * @return the new data type
	 */
	public static DataType createDataType(long dataTypeId) {
		return getService().createDataType(dataTypeId);
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
	public static DataType deleteDataType(DataType dataType) {
		return getService().deleteDataType(dataType);
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
	public static DataType deleteDataType(long dataTypeId)
		throws PortalException {

		return getService().deleteDataType(dataTypeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataTypeModelImpl</code>.
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

	public static DataType fetchDataType(long dataTypeId) {
		return getService().fetchDataType(dataTypeId);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	public static DataType fetchDataTypeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataTypeByUuidAndGroupId(uuid, groupId);
	}

	public static List<String> getAbstractFields(
			long dataTypeId, boolean abstractKey)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getAbstractFields(dataTypeId, abstractKey);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<DataType> getAllDataTypes() {
		return getService().getAllDataTypes();
	}

	public static List<DataType> getAllDataTypes(int start, int end) {
		return getService().getAllDataTypes(start, end);
	}

	public static List<DataType> getAllDataTypes(
		int start, int end, OrderByComparator<DataType> comparator) {

		return getService().getAllDataTypes(start, end, comparator);
	}

	public static List<DataType> getApprovedDataTypes(long groupId) {
		return getService().getApprovedDataTypes(groupId);
	}

	public static List<DataType> getApprovedDataTypes(
		long groupId, int start, int end) {

		return getService().getApprovedDataTypes(groupId, start, end);
	}

	public static List<DataType> getApprovedDataTypes(
		long groupId, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getApprovedDataTypes(
			groupId, start, end, comparator);
	}

	public static long getDataFileFolderId(
			long repositoryId, long parentFoderId, String dataTypeName,
			String dataTypeVersion, long dataId, String termName,
			String termVersion,
			com.liferay.portal.kernel.service.ServiceContext sc,
			boolean createWhenNoExist)
		throws PortalException {

		return getService().getDataFileFolderId(
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
	public static DataType getDataType(long dataTypeId) throws PortalException {
		return getService().getDataType(dataTypeId);
	}

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type
	 * @throws PortalException if a matching data type could not be found
	 */
	public static DataType getDataTypeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDataTypeByUuidAndGroupId(uuid, groupId);
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
	public static List<DataType> getDataTypes(int start, int end) {
		return getService().getDataTypes(start, end);
	}

	public static List<DataType> getDataTypesByG_S(long groupId, int status) {
		return getService().getDataTypesByG_S(groupId, status);
	}

	public static List<DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end) {

		return getService().getDataTypesByG_S(groupId, status, start, end);
	}

	public static List<DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByG_S(
			groupId, status, start, end, comparator);
	}

	public static List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status) {

		return getService().getDataTypesByG_U_S(groupId, userId, status);
	}

	public static List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getService().getDataTypesByG_U_S(
			groupId, userId, status, start, end);
	}

	public static List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByG_U_S(
			groupId, userId, status, start, end, comparator);
	}

	public static List<DataType> getDataTypesByGroupId(long groupId) {
		return getService().getDataTypesByGroupId(groupId);
	}

	public static List<DataType> getDataTypesByGroupId(
		long groupId, int start, int end) {

		return getService().getDataTypesByGroupId(groupId, start, end);
	}

	public static List<DataType> getDataTypesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByGroupId(
			groupId, start, end, comparator);
	}

	public static List<DataType> getDataTypesByName(String dataTypeName) {
		return getService().getDataTypesByName(dataTypeName);
	}

	public static List<DataType> getDataTypesByStatus(int status) {
		return getService().getDataTypesByStatus(status);
	}

	public static List<DataType> getDataTypesByStatus(
		int status, int start, int end) {

		return getService().getDataTypesByStatus(status, start, end);
	}

	public static List<DataType> getDataTypesByStatus(
		int status, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByStatus(
			status, start, end, comparator);
	}

	public static List<DataType> getDataTypesByU_S(long userId, int status) {
		return getService().getDataTypesByU_S(userId, status);
	}

	public static List<DataType> getDataTypesByU_S(
		long userId, int status, int start, int end) {

		return getService().getDataTypesByU_S(userId, status, start, end);
	}

	public static List<DataType> getDataTypesByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByU_S(
			userId, status, start, end, comparator);
	}

	public static List<DataType> getDataTypesByUserId(long userId) {
		return getService().getDataTypesByUserId(userId);
	}

	public static List<DataType> getDataTypesByUserId(
		long userId, int start, int end) {

		return getService().getDataTypesByUserId(userId, start, end);
	}

	public static List<DataType> getDataTypesByUserId(
		long userId, int start, int end,
		OrderByComparator<DataType> comparator) {

		return getService().getDataTypesByUserId(
			userId, start, end, comparator);
	}

	/**
	 * Returns all the data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @return the matching data types, or an empty list if no matches were found
	 */
	public static List<DataType> getDataTypesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataTypesByUuidAndCompanyId(uuid, companyId);
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
	public static List<DataType> getDataTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataType> orderByComparator) {

		return getService().getDataTypesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	public static int getDataTypesCount() {
		return getService().getDataTypesCount();
	}

	public static String getDataTypeStructure(long dataTypeId)
		throws com.sx.icecap.exception.NoSuchDataTypeStructureException {

		return getService().getDataTypeStructure(dataTypeId);
	}

	/**
	 * Get data structure as a JSON object.
	 *
	 * @return null,	if the data type has no structure
	 JSONObject, if has a proper structure.
	 */
	public static com.liferay.portal.kernel.json.JSONObject
			getDataTypeStructureJSONObject(long dataTypeId)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getDataTypeStructureJSONObject(dataTypeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getDLFolderFiles(
		long repositoryId, long folderId) {

		return getService().getDLFolderFiles(repositoryId, folderId);
	}

	public static List<String> getDownloadableFields(
			long dataTypeId, boolean downloadable)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getDownloadableFields(dataTypeId, downloadable);
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

	public static String getName(long dataTypeId, java.util.Locale locale)
		throws com.sx.icecap.exception.NoSuchDataTypeException {

		return getService().getName(dataTypeId, locale);
	}

	public static OrderByComparator<DataType> getOrderByNameComparator(
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

	public static List<String> getSearchableFields(
			long dataTypeId, boolean searchable)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getSearchableFields(dataTypeId, searchable);
	}

	public static com.liferay.portal.kernel.dao.search.SearchContainerResults
		<com.liferay.asset.kernel.model.AssetEntry> getSearchContainerResults(
				com.liferay.portal.kernel.dao.search.SearchContainer<DataType>
					searchContainer)
			throws PortalException {

		return getService().getSearchContainerResults(searchContainer);
	}

	public static String getStructuredData(long structuredDataId) {
		return getService().getStructuredData(structuredDataId);
	}

	public static List<com.sx.icecap.model.StructuredData> getStructuredDatas(
		long dataTypeId) {

		return getService().getStructuredDatas(dataTypeId);
	}

	public static List<com.sx.icecap.model.StructuredData> getStructuredDatas(
		long dataTypeId, int start, int end) {

		return getService().getStructuredDatas(dataTypeId, start, end);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getStructuredDatasJSON(long dataTypeId) {

		return getService().getStructuredDatasJSON(dataTypeId);
	}

	@Deprecated
	public static com.liferay.portal.kernel.json.JSONObject
			getStructuredDataWithValues(long dataTypeId, String structuredData)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getStructuredDataWithValues(
			dataTypeId, structuredData);
	}

	public static com.liferay.portal.kernel.json.JSONObject getTermByName(
			long dataTypeId, String termName)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getTermByName(dataTypeId, termName);
	}

	public static Map<String, Object> parseStructuredData(
		String termDelimiter, String valueDelimiter, String structuredData) {

		return getService().parseStructuredData(
			termDelimiter, valueDelimiter, structuredData);
	}

	public static List<com.sx.icecap.model.StructuredData>
			performAdvancedSearchOnStructuredData(
				long dataTypeId, String advancedQuery, int start, int end)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().performAdvancedSearchOnStructuredData(
			dataTypeId, advancedQuery, start, end);
	}

	public static DataType removeDataType(long dataTypeId)
		throws PortalException {

		return getService().removeDataType(dataTypeId);
	}

	public static void removeDataTypes(long[] dataTypeIds)
		throws PortalException {

		getService().removeDataTypes(dataTypeIds);
	}

	public static void removeDataTypeStructure(long dataTypeId) {
		getService().removeDataTypeStructure(dataTypeId);
	}

	public static com.sx.icecap.model.StructuredData removeStructuredData(
			long structuredDataId, long dataFileFolderId)
		throws PortalException {

		return getService().removeStructuredData(
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
	public static void setDataTypeStructure(
		long dataTypeId, String dataStructure) {

		getService().setDataTypeStructure(dataTypeId, dataStructure);
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
	public static DataType updateDataType(DataType dataType) {
		return getService().updateDataType(dataType);
	}

	public static DataType updateDataType(
			long dataTypeId, String dataTypeName, String dataTypeVersion,
			String extension, Map<java.util.Locale, String> displayNameMap,
			Map<java.util.Locale, String> descriptionMap,
			Map<java.util.Locale, String> tooltipMap, int status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDataType(
			dataTypeId, dataTypeName, dataTypeVersion, extension,
			displayNameMap, descriptionMap, tooltipMap, status, sc);
	}

	public static DataType updateStatus(
			long userId, long dataTypeId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStatus(userId, dataTypeId, status, sc);
	}

	public static com.sx.icecap.model.StructuredData updateStructuredData(
			long structuredDataId, long dataSetId, long dataTypeId, String data,
			int status, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateStructuredData(
			structuredDataId, dataSetId, dataTypeId, data, status, sc);
	}

	public static com.sx.icecap.model.StructuredData updateStructuredDataStatus(
			long userId, long structuredDataId, Integer status,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException, SystemException {

		return getService().updateStructuredDataStatus(
			userId, structuredDataId, status, sc);
	}

	public static DataTypeLocalService getService() {
		return _service;
	}

	private static volatile DataTypeLocalService _service;

}