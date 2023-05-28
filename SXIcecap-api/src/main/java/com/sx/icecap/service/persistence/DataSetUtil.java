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

package com.sx.icecap.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.DataSet;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data set service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DataSetPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataSetPersistence
 * @generated
 */
public class DataSetUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DataSet dataSet) {
		getPersistence().clearCache(dataSet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, DataSet> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataSet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataSet update(DataSet dataSet) {
		return getPersistence().update(dataSet);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataSet update(
		DataSet dataSet, ServiceContext serviceContext) {

		return getPersistence().update(dataSet, serviceContext);
	}

	/**
	 * Returns all the data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data sets
	 */
	public static List<DataSet> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUuid_First(
			String uuid, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUuid_First(
		String uuid, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUuid_Last(
			String uuid, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUuid_Last(
		String uuid, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where uuid = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByUuid_PrevAndNext(
			long dataSetId, String uuid,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_PrevAndNext(
			dataSetId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data sets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data sets
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataSetException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data set where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data set that was removed
	 */
	public static DataSet removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data sets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data sets
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data sets
	 */
	public static List<DataSet> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByUuid_C_PrevAndNext(
			long dataSetId, String uuid, long companyId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataSetId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data sets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data sets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data sets
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data sets
	 */
	public static List<DataSet> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByGroupId_First(
			long groupId, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByGroupId_First(
		long groupId, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByGroupId_Last(
			long groupId, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByGroupId_Last(
		long groupId, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByGroupId_PrevAndNext(
			long dataSetId, long groupId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataSetId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data sets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data sets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data sets
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the data sets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data sets
	 */
	public static List<DataSet> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the data sets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUserId_First(
			long userId, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUserId_First(
		long userId, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByUserId_Last(
			long userId, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByUserId_Last(
		long userId, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where userId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByUserId_PrevAndNext(
			long dataSetId, long userId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByUserId_PrevAndNext(
			dataSetId, userId, orderByComparator);
	}

	/**
	 * Removes all the data sets where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of data sets where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data sets
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the data sets where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data sets
	 */
	public static List<DataSet> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByStatus_First(
			int status, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByStatus_First(
		int status, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByStatus_Last(
			int status, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByStatus_Last(
		int status, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where status = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByStatus_PrevAndNext(
			long dataSetId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByStatus_PrevAndNext(
			dataSetId, status, orderByComparator);
	}

	/**
	 * Removes all the data sets where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of data sets where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data sets
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data sets
	 */
	public static List<DataSet> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByG_U_PrevAndNext(
			long dataSetId, long groupId, long userId,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_PrevAndNext(
			dataSetId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the data sets where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data sets where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data sets
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns all the data sets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data sets
	 */
	public static List<DataSet> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data sets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_S_First(
			long groupId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByG_S_PrevAndNext(
			long dataSetId, long groupId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_S_PrevAndNext(
			dataSetId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the data sets where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of data sets where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data sets
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the data sets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data sets
	 */
	public static List<DataSet> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the data sets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByU_S_First(
			long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByU_S_First(
		long userId, int status, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByU_S_Last(
			long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByU_S_Last(
		long userId, int status, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByU_S_PrevAndNext(
			long dataSetId, long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByU_S_PrevAndNext(
			dataSetId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data sets where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of data sets where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data sets
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the data sets where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data sets
	 */
	public static List<DataSet> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data sets where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByG_U_S_PrevAndNext(
			long dataSetId, long groupId, long userId, int status,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByG_U_S_PrevAndNext(
			dataSetId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data sets where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data sets where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data sets
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the data sets where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @return the matching data sets
	 */
	public static List<DataSet> findByName(String dataSetName) {
		return getPersistence().findByName(dataSetName);
	}

	/**
	 * Returns a range of all the data sets where dataSetName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetName the data set name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of matching data sets
	 */
	public static List<DataSet> findByName(
		String dataSetName, int start, int end) {

		return getPersistence().findByName(dataSetName, start, end);
	}

	/**
	 * Returns an ordered range of all the data sets where dataSetName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetName the data set name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByName(
		String dataSetName, int start, int end,
		OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findByName(
			dataSetName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets where dataSetName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetName the data set name
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data sets
	 */
	public static List<DataSet> findByName(
		String dataSetName, int start, int end,
		OrderByComparator<DataSet> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByName(
			dataSetName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data set in the ordered set where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByName_First(
			String dataSetName, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByName_First(
			dataSetName, orderByComparator);
	}

	/**
	 * Returns the first data set in the ordered set where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByName_First(
		String dataSetName, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByName_First(
			dataSetName, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByName_Last(
			String dataSetName, OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByName_Last(dataSetName, orderByComparator);
	}

	/**
	 * Returns the last data set in the ordered set where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByName_Last(
		String dataSetName, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().fetchByName_Last(
			dataSetName, orderByComparator);
	}

	/**
	 * Returns the data sets before and after the current data set in the ordered set where dataSetName = &#63;.
	 *
	 * @param dataSetId the primary key of the current data set
	 * @param dataSetName the data set name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet[] findByName_PrevAndNext(
			long dataSetId, String dataSetName,
			OrderByComparator<DataSet> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByName_PrevAndNext(
			dataSetId, dataSetName, orderByComparator);
	}

	/**
	 * Removes all the data sets where dataSetName = &#63; from the database.
	 *
	 * @param dataSetName the data set name
	 */
	public static void removeByName(String dataSetName) {
		getPersistence().removeByName(dataSetName);
	}

	/**
	 * Returns the number of data sets where dataSetName = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @return the number of matching data sets
	 */
	public static int countByName(String dataSetName) {
		return getPersistence().countByName(dataSetName);
	}

	/**
	 * Returns the data set where dataSetName = &#63; and dataSetVersion = &#63; or throws a <code>NoSuchDataSetException</code> if it could not be found.
	 *
	 * @param dataSetName the data set name
	 * @param dataSetVersion the data set version
	 * @return the matching data set
	 * @throws NoSuchDataSetException if a matching data set could not be found
	 */
	public static DataSet findByNameVersion(
			String dataSetName, String dataSetVersion)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByNameVersion(dataSetName, dataSetVersion);
	}

	/**
	 * Returns the data set where dataSetName = &#63; and dataSetVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dataSetName the data set name
	 * @param dataSetVersion the data set version
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByNameVersion(
		String dataSetName, String dataSetVersion) {

		return getPersistence().fetchByNameVersion(dataSetName, dataSetVersion);
	}

	/**
	 * Returns the data set where dataSetName = &#63; and dataSetVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dataSetName the data set name
	 * @param dataSetVersion the data set version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data set, or <code>null</code> if a matching data set could not be found
	 */
	public static DataSet fetchByNameVersion(
		String dataSetName, String dataSetVersion, boolean useFinderCache) {

		return getPersistence().fetchByNameVersion(
			dataSetName, dataSetVersion, useFinderCache);
	}

	/**
	 * Removes the data set where dataSetName = &#63; and dataSetVersion = &#63; from the database.
	 *
	 * @param dataSetName the data set name
	 * @param dataSetVersion the data set version
	 * @return the data set that was removed
	 */
	public static DataSet removeByNameVersion(
			String dataSetName, String dataSetVersion)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().removeByNameVersion(
			dataSetName, dataSetVersion);
	}

	/**
	 * Returns the number of data sets where dataSetName = &#63; and dataSetVersion = &#63;.
	 *
	 * @param dataSetName the data set name
	 * @param dataSetVersion the data set version
	 * @return the number of matching data sets
	 */
	public static int countByNameVersion(
		String dataSetName, String dataSetVersion) {

		return getPersistence().countByNameVersion(dataSetName, dataSetVersion);
	}

	/**
	 * Caches the data set in the entity cache if it is enabled.
	 *
	 * @param dataSet the data set
	 */
	public static void cacheResult(DataSet dataSet) {
		getPersistence().cacheResult(dataSet);
	}

	/**
	 * Caches the data sets in the entity cache if it is enabled.
	 *
	 * @param dataSets the data sets
	 */
	public static void cacheResult(List<DataSet> dataSets) {
		getPersistence().cacheResult(dataSets);
	}

	/**
	 * Creates a new data set with the primary key. Does not add the data set to the database.
	 *
	 * @param dataSetId the primary key for the new data set
	 * @return the new data set
	 */
	public static DataSet create(long dataSetId) {
		return getPersistence().create(dataSetId);
	}

	/**
	 * Removes the data set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set that was removed
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet remove(long dataSetId)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().remove(dataSetId);
	}

	public static DataSet updateImpl(DataSet dataSet) {
		return getPersistence().updateImpl(dataSet);
	}

	/**
	 * Returns the data set with the primary key or throws a <code>NoSuchDataSetException</code> if it could not be found.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set
	 * @throws NoSuchDataSetException if a data set with the primary key could not be found
	 */
	public static DataSet findByPrimaryKey(long dataSetId)
		throws com.sx.icecap.exception.NoSuchDataSetException {

		return getPersistence().findByPrimaryKey(dataSetId);
	}

	/**
	 * Returns the data set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataSetId the primary key of the data set
	 * @return the data set, or <code>null</code> if a data set with the primary key could not be found
	 */
	public static DataSet fetchByPrimaryKey(long dataSetId) {
		return getPersistence().fetchByPrimaryKey(dataSetId);
	}

	/**
	 * Returns all the data sets.
	 *
	 * @return the data sets
	 */
	public static List<DataSet> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @return the range of data sets
	 */
	public static List<DataSet> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data sets
	 */
	public static List<DataSet> findAll(
		int start, int end, OrderByComparator<DataSet> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data sets
	 * @param end the upper bound of the range of data sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data sets
	 */
	public static List<DataSet> findAll(
		int start, int end, OrderByComparator<DataSet> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data sets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data sets.
	 *
	 * @return the number of data sets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataSetPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataSetPersistence _persistence;

}