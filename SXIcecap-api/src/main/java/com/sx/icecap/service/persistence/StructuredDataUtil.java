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

import com.sx.icecap.model.StructuredData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the structured data service. This utility wraps <code>com.sx.icecap.service.persistence.impl.StructuredDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataPersistence
 * @generated
 */
public class StructuredDataUtil {

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
	public static void clearCache(StructuredData structuredData) {
		getPersistence().clearCache(structuredData);
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
	public static Map<Serializable, StructuredData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StructuredData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StructuredData update(StructuredData structuredData) {
		return getPersistence().update(structuredData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StructuredData update(
		StructuredData structuredData, ServiceContext serviceContext) {

		return getPersistence().update(structuredData, serviceContext);
	}

	/**
	 * Returns all the structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_First(
			String uuid, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_First(
		String uuid, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_Last(
			String uuid, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_Last(
		String uuid, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where uuid = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUuid_PrevAndNext(
			long structuredDataId, String uuid,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_PrevAndNext(
			structuredDataId, uuid, orderByComparator);
	}

	/**
	 * Removes all the structured datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching structured datas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the structured data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the structured data that was removed
	 */
	public static StructuredData removeByUUID_G(String uuid, long groupId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUuid_C_PrevAndNext(
			long structuredDataId, String uuid, long companyId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUuid_C_PrevAndNext(
			structuredDataId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching structured datas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_First(
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_First(
		long groupId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByGroupId_Last(
			long groupId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByGroupId_Last(
		long groupId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByGroupId_PrevAndNext(
			structuredDataId, groupId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			structuredDataId, groupId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByUserId(
		long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_First(
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_First(
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByUserId_Last(
			long userId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByUserId_Last(
		long userId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByUserId_PrevAndNext(
			long structuredDataId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByUserId_PrevAndNext(
			structuredDataId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByStatus(
		int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByStatus_First(
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByStatus_First(
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByStatus_Last(
			int status, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByStatus_Last(
		int status, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByStatus_PrevAndNext(
			long structuredDataId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByStatus_PrevAndNext(
			structuredDataId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U(
			groupId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_First(
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_First(
		long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_First(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_Last(
			long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_Last(
		long groupId, long userId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_Last(
			groupId, userId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_PrevAndNext(
			structuredDataId, groupId, userId, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId) {

		return getPersistence().filterFindByG_U(groupId, userId);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end) {

		return getPersistence().filterFindByG_U(groupId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_U(
			groupId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_U_PrevAndNext(
			structuredDataId, groupId, userId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_U(long groupId, long userId) {
		return getPersistence().filterCountByG_U(groupId, userId);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_S_First(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_S_Last(
			long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			structuredDataId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByU_S(long userId, int status) {
		return getPersistence().findByU_S(userId, status);
	}

	/**
	 * Returns a range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end) {

		return getPersistence().findByU_S(userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_S(
			userId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByU_S_First(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByU_S_First(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByU_S_First(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByU_S_Last(
			long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByU_S_Last(
		long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByU_S_Last(
			userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByU_S_PrevAndNext(
			long structuredDataId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByU_S_PrevAndNext(
			structuredDataId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByU_S(long userId, int status) {
		getPersistence().removeByU_S(userId, status);
	}

	/**
	 * Returns the number of structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByU_S(long userId, int status) {
		return getPersistence().countByU_S(userId, status);
	}

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().findByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_U_S(
			groupId, userId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_S_First(
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_S_First(
		long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_S_First(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByG_U_S_Last(
			long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByG_U_S_Last(
			groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByG_U_S_PrevAndNext(
			structuredDataId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterFindByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns a range of all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas that the user has permission to view
	 */
	public static List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().filterFindByG_U_S(
			groupId, userId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] filterFindByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().filterFindByG_U_S_PrevAndNext(
			structuredDataId, groupId, userId, status, orderByComparator);
	}

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public static void removeByG_U_S(long groupId, long userId, int status) {
		getPersistence().removeByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public static int countByG_U_S(long groupId, long userId, int status) {
		return getPersistence().countByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public static int filterCountByG_U_S(
		long groupId, long userId, int status) {

		return getPersistence().filterCountByG_U_S(groupId, userId, status);
	}

	/**
	 * Returns all the structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(long dataSetId) {
		return getPersistence().findByDataSetId(dataSetId);
	}

	/**
	 * Returns a range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end) {

		return getPersistence().findByDataSetId(dataSetId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataSetId the data set ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataSetId(
			dataSetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_First(
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_First(
		long dataSetId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_First(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataSetId_Last(
			long dataSetId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataSetId_Last(
		long dataSetId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataSetId_Last(
			dataSetId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataSetId_PrevAndNext(
			long structuredDataId, long dataSetId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataSetId_PrevAndNext(
			structuredDataId, dataSetId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public static void removeByDataSetId(long dataSetId) {
		getPersistence().removeByDataSetId(dataSetId);
	}

	/**
	 * Returns the number of structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataSetId(long dataSetId) {
		return getPersistence().countByDataSetId(dataSetId);
	}

	/**
	 * Returns all the structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public static List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByDataTypeId_PrevAndNext(
			long structuredDataId, long dataTypeId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			structuredDataId, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Caches the structured data in the entity cache if it is enabled.
	 *
	 * @param structuredData the structured data
	 */
	public static void cacheResult(StructuredData structuredData) {
		getPersistence().cacheResult(structuredData);
	}

	/**
	 * Caches the structured datas in the entity cache if it is enabled.
	 *
	 * @param structuredDatas the structured datas
	 */
	public static void cacheResult(List<StructuredData> structuredDatas) {
		getPersistence().cacheResult(structuredDatas);
	}

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	public static StructuredData create(long structuredDataId) {
		return getPersistence().create(structuredDataId);
	}

	/**
	 * Removes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData remove(long structuredDataId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().remove(structuredDataId);
	}

	public static StructuredData updateImpl(StructuredData structuredData) {
		return getPersistence().updateImpl(structuredData);
	}

	/**
	 * Returns the structured data with the primary key or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData findByPrimaryKey(long structuredDataId)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByPrimaryKey(structuredDataId);
	}

	/**
	 * Returns the structured data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data, or <code>null</code> if a structured data with the primary key could not be found
	 */
	public static StructuredData fetchByPrimaryKey(long structuredDataId) {
		return getPersistence().fetchByPrimaryKey(structuredDataId);
	}

	/**
	 * Returns all the structured datas.
	 *
	 * @return the structured datas
	 */
	public static List<StructuredData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of structured datas
	 */
	public static List<StructuredData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of structured datas
	 */
	public static List<StructuredData> findAll(
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of structured datas
	 */
	public static List<StructuredData> findAll(
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the structured datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StructuredDataPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StructuredDataPersistence _persistence;

}