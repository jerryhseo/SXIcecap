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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;

import java.io.Serializable;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataTypeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the data type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link DataTypeLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public DataType addDataType(DataType dataType);

	@Indexable(type = IndexableType.REINDEX)
	public DataType addDataType(
			String dataTypeName, String dataTypeVersion, String extension,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> tooltipMap,
			int status, ServiceContext sc)
		throws PortalException;

	public StructuredData addStructuredData(
			long dataSetId, long dataTypeId, String data, int status,
			ServiceContext sc)
		throws PortalException;

	public int countAllDataTypes();

	public int countApprovedDataTypes(long groupId);

	public int countDataTypesByG_S(long groupId, int status);

	public int countDataTypesByG_U_S(long groupId, long userId, int status);

	public int countDataTypesByGroupId(long groupId);

	public int countDataTypesByStatus(int status);

	public int countDataTypesByU_S(long userId, int status);

	public int countDataTypesByUserId(long userId);

	/**
	 * Creates a new data type with the primary key. Does not add the data type to the database.
	 *
	 * @param dataTypeId the primary key for the new data type
	 * @return the new data type
	 */
	@Transactional(enabled = false)
	public DataType createDataType(long dataTypeId);

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
	@Indexable(type = IndexableType.DELETE)
	public DataType deleteDataType(DataType dataType);

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
	@Indexable(type = IndexableType.DELETE)
	public DataType deleteDataType(long dataTypeId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataType fetchDataType(long dataTypeId);

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type, or <code>null</code> if a matching data type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataType fetchDataTypeByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getAllDataTypes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getAllDataTypes(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getAllDataTypes(
		int start, int end, OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getApprovedDataTypes(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getApprovedDataTypes(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getApprovedDataTypes(
		long groupId, int start, int end,
		OrderByComparator<DataType> comparator);

	/**
	 * Returns the data type with the primary key.
	 *
	 * @param dataTypeId the primary key of the data type
	 * @return the data type
	 * @throws PortalException if a data type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataType getDataType(long dataTypeId) throws PortalException;

	/**
	 * Returns the data type matching the UUID and group.
	 *
	 * @param uuid the data type's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data type
	 * @throws PortalException if a matching data type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataType getDataTypeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypes(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_S(long groupId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByName(String dataTypeName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByStatus(int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByStatus(int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByStatus(
		int status, int start, int end, OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByU_S(long userId, int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByU_S(
		long userId, int status, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataType> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByUserId(long userId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByUserId(
		long userId, int start, int end,
		OrderByComparator<DataType> comparator);

	/**
	 * Returns all the data types matching the UUID and company.
	 *
	 * @param uuid the UUID of the data types
	 * @param companyId the primary key of the company
	 * @return the matching data types, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataType> getDataTypesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataType> orderByComparator);

	/**
	 * Returns the number of data types.
	 *
	 * @return the number of data types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataTypesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDataTypeStructure(long dataTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getDataTypeStructureJSONObject(long dataTypeId)
		throws JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getName(long dataTypeId, Locale locale)
		throws NoSuchDataTypeException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrderByComparator<DataType> getOrderByNameComparator(
		String orderByCol, String orderByType);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<DataType> searchContainer)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StructuredData getStructuredData(long structuredDataId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StructuredData> getStructuredDatas(long dataTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StructuredData> getStructuredDatas(
		long dataTypeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getStructuredDataWithValues(
			long dataTypeId, long structuredDataId)
		throws JSONException;

	public Map<String, Object> parseStructuredData(
		String termDelimiter, String valueDelimiter, String structuredData);

	@Indexable(type = IndexableType.DELETE)
	public DataType removeDataType(long dataTypeId) throws PortalException;

	public void removeDataTypes(long[] dataTypeIds) throws PortalException;

	public void removeDataTypeStructure(long dataTypeId);

	public StructuredData removeStructuredData(long structuredDataId)
		throws PortalException;

	public void removeStructuredDatas(long[] structuredDataIds)
		throws PortalException;

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
	public void setDataTypeStructure(long dataTypeId, String dataStructure);

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
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateDataType(DataType dataType);

	@Indexable(type = IndexableType.REINDEX)
	public DataType updateDataType(
			long dataTypeId, String dataTypeName, String dataTypeVersion,
			String extension, Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> tooltipMap,
			int status, ServiceContext sc)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public DataType updateStatus(
			long userId, long dataTypeId, Integer status, ServiceContext sc)
		throws PortalException, SystemException;

	public StructuredData updateStructuredData(
			long structuredDataId, long dataSetId, long dataTypeId, String data,
			int status, ServiceContext sc)
		throws PortalException;

	public StructuredData updateStructuredDataStatus(
			long userId, long structuredDataId, Integer status,
			ServiceContext sc)
		throws PortalException, SystemException;

}