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

import com.sx.icecap.model.DataPackEntry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the data pack entry service. This utility wraps <code>com.sx.icecap.service.persistence.impl.DataPackEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntryPersistence
 * @generated
 */
public class DataPackEntryUtil {

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
	public static void clearCache(DataPackEntry dataPackEntry) {
		getPersistence().clearCache(dataPackEntry);
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
	public static Map<Serializable, DataPackEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DataPackEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DataPackEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DataPackEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DataPackEntry update(DataPackEntry dataPackEntry) {
		return getPersistence().update(dataPackEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DataPackEntry update(
		DataPackEntry dataPackEntry, ServiceContext serviceContext) {

		return getPersistence().update(dataPackEntry, serviceContext);
	}

	/**
	 * Returns all the data pack entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the data pack entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUuid_First(
			String uuid, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUuid_First(
		String uuid, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUuid_Last(
			String uuid, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUuid_Last(
		String uuid, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByUuid_PrevAndNext(
			long dataPackEntryId, String uuid,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_PrevAndNext(
			dataPackEntryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of data pack entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data pack entries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataPackEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the data pack entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data pack entry that was removed
	 */
	public static DataPackEntry removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of data pack entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data pack entries
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByUuid_C_PrevAndNext(
			long dataPackEntryId, String uuid, long companyId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			dataPackEntryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data pack entries
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the data pack entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the data pack entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByGroupId_First(
			long groupId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByGroupId_First(
		long groupId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByGroupId_Last(
			long groupId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByGroupId_PrevAndNext(
			long dataPackEntryId, long groupId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			dataPackEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of data pack entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data pack entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the data pack entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the data pack entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByUserId(
		long userId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUserId_First(
			long userId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUserId_First(
		long userId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByUserId_Last(
			long userId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByUserId_Last(
		long userId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByUserId_PrevAndNext(
			long dataPackEntryId, long userId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByUserId_PrevAndNext(
			dataPackEntryId, userId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of data pack entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data pack entries
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the data pack entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the data pack entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByStatus(
		int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByStatus_First(
			int status, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByStatus_First(
		int status, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByStatus_Last(
			int status, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByStatus_Last(
		int status, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where status = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByStatus_PrevAndNext(
			long dataPackEntryId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByStatus_PrevAndNext(
			dataPackEntryId, status, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of data pack entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_U_First(
			long groupId, long userId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByG_U_PrevAndNext(
			long dataPackEntryId, long groupId, long userId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_PrevAndNext(
			dataPackEntryId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data pack entries
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns all the data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByG_S_PrevAndNext(
			long dataPackEntryId, long groupId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			dataPackEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns all the data pack entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the data pack entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByU_S_First(
			long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByU_S_First(
		long userId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByU_S_Last(
			long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByU_S_PrevAndNext(
			long dataPackEntryId, long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByU_S_PrevAndNext(
			dataPackEntryId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of data pack entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByG_U_S_PrevAndNext(
			long dataPackEntryId, long groupId, long userId, int status,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByG_U_S_PrevAndNext(
			dataPackEntryId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the data pack entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the data pack entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataSetId_First(
			long dataSetId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataSetId_First(
		long dataSetId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataSetId_Last(
			long dataSetId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByDataSetId_PrevAndNext(
			long dataPackEntryId, long dataSetId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetId_PrevAndNext(
			dataPackEntryId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of data pack entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data pack entries
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the data pack entries where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId) {

		return getPersistence().findByDataSetFolderId(dataSetFolderId);
	}

	/**
	 * Returns a range of all the data pack entries where dataSetFolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end) {

		return getPersistence().findByDataSetFolderId(
			dataSetFolderId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataSetFolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByDataSetFolderId(
			dataSetFolderId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataSetFolderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetFolderId(
			dataSetFolderId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataSetFolderId_First(
			long dataSetFolderId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetFolderId_First(
			dataSetFolderId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataSetFolderId_First(
		long dataSetFolderId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataSetFolderId_First(
			dataSetFolderId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataSetFolderId_Last(
			long dataSetFolderId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetFolderId_Last(
			dataSetFolderId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataSetFolderId_Last(
		long dataSetFolderId,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataSetFolderId_Last(
			dataSetFolderId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByDataSetFolderId_PrevAndNext(
			long dataPackEntryId, long dataSetFolderId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataSetFolderId_PrevAndNext(
			dataPackEntryId, dataSetFolderId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where dataSetFolderId = &#63; from the database.
	 *
	 * @param dataSetFolderId the data set folder ID
	 */
	public static void removeByDataSetFolderId(long dataSetFolderId) {
		getPersistence().removeByDataSetFolderId(dataSetFolderId);
	}

	/**
	 * Returns the number of data pack entries where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @return the number of matching data pack entries
	 */
	public static int countByDataSetFolderId(long dataSetFolderId) {
		return getPersistence().countByDataSetFolderId(dataSetFolderId);
	}

	/**
	 * Returns all the data pack entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data pack entries
	 */
	public static List<DataPackEntry> findByDataPackId(long dataPackId) {
		return getPersistence().findByDataPackId(dataPackId);
	}

	/**
	 * Returns a range of all the data pack entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end) {

		return getPersistence().findByDataPackId(dataPackId, start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries where dataPackId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dataPackId the data pack ID
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching data pack entries
	 */
	public static List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataPackId(
			dataPackId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataPackId_First(
			long dataPackId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the first data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataPackId_First(
		long dataPackId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataPackId_First(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public static DataPackEntry findByDataPackId_Last(
			long dataPackId, OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the last data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchByDataPackId_Last(
		long dataPackId, OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().fetchByDataPackId_Last(
			dataPackId, orderByComparator);
	}

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry[] findByDataPackId_PrevAndNext(
			long dataPackEntryId, long dataPackId,
			OrderByComparator<DataPackEntry> orderByComparator)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByDataPackId_PrevAndNext(
			dataPackEntryId, dataPackId, orderByComparator);
	}

	/**
	 * Removes all the data pack entries where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public static void removeByDataPackId(long dataPackId) {
		getPersistence().removeByDataPackId(dataPackId);
	}

	/**
	 * Returns the number of data pack entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data pack entries
	 */
	public static int countByDataPackId(long dataPackId) {
		return getPersistence().countByDataPackId(dataPackId);
	}

	/**
	 * Caches the data pack entry in the entity cache if it is enabled.
	 *
	 * @param dataPackEntry the data pack entry
	 */
	public static void cacheResult(DataPackEntry dataPackEntry) {
		getPersistence().cacheResult(dataPackEntry);
	}

	/**
	 * Caches the data pack entries in the entity cache if it is enabled.
	 *
	 * @param dataPackEntries the data pack entries
	 */
	public static void cacheResult(List<DataPackEntry> dataPackEntries) {
		getPersistence().cacheResult(dataPackEntries);
	}

	/**
	 * Creates a new data pack entry with the primary key. Does not add the data pack entry to the database.
	 *
	 * @param dataPackEntryId the primary key for the new data pack entry
	 * @return the new data pack entry
	 */
	public static DataPackEntry create(long dataPackEntryId) {
		return getPersistence().create(dataPackEntryId);
	}

	/**
	 * Removes the data pack entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry that was removed
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry remove(long dataPackEntryId)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().remove(dataPackEntryId);
	}

	public static DataPackEntry updateImpl(DataPackEntry dataPackEntry) {
		return getPersistence().updateImpl(dataPackEntry);
	}

	/**
	 * Returns the data pack entry with the primary key or throws a <code>NoSuchDataPackEntryException</code> if it could not be found.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry findByPrimaryKey(long dataPackEntryId)
		throws com.sx.icecap.exception.NoSuchDataPackEntryException {

		return getPersistence().findByPrimaryKey(dataPackEntryId);
	}

	/**
	 * Returns the data pack entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry, or <code>null</code> if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry fetchByPrimaryKey(long dataPackEntryId) {
		return getPersistence().fetchByPrimaryKey(dataPackEntryId);
	}

	/**
	 * Returns all the data pack entries.
	 *
	 * @return the data pack entries
	 */
	public static List<DataPackEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the data pack entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of data pack entries
	 */
	public static List<DataPackEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the data pack entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data pack entries
	 */
	public static List<DataPackEntry> findAll(
		int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the data pack entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data pack entries
	 */
	public static List<DataPackEntry> findAll(
		int start, int end, OrderByComparator<DataPackEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the data pack entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of data pack entries.
	 *
	 * @return the number of data pack entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DataPackEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DataPackEntryPersistence _persistence;

}