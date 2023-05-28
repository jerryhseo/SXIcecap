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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sx.icecap.exception.NoSuchDataPackEntryException;
import com.sx.icecap.model.DataPackEntry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data pack entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntryUtil
 * @generated
 */
@ProviderType
public interface DataPackEntryPersistence
	extends BasePersistence<DataPackEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataPackEntryUtil} to access the data pack entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the data pack entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByUuid(String uuid);

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
	public java.util.List<DataPackEntry> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DataPackEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where uuid = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByUuid_PrevAndNext(
			long dataPackEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of data pack entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching data pack entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDataPackEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the data pack entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the data pack entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the data pack entry that was removed
	 */
	public DataPackEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the number of data pack entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching data pack entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry[] findByUuid_C_PrevAndNext(
			long dataPackEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of data pack entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching data pack entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the data pack entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByGroupId(long groupId);

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
	public java.util.List<DataPackEntry> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<DataPackEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where groupId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByGroupId_PrevAndNext(
			long dataPackEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of data pack entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching data pack entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the data pack entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByUserId(long userId);

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
	public java.util.List<DataPackEntry> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<DataPackEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where userId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByUserId_PrevAndNext(
			long dataPackEntryId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of data pack entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching data pack entries
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the data pack entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByStatus(int status);

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
	public java.util.List<DataPackEntry> findByStatus(
		int status, int start, int end);

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
	public java.util.List<DataPackEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where status = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByStatus_PrevAndNext(
			long dataPackEntryId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of data pack entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByG_U(long groupId, long userId);

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
	public java.util.List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry[] findByG_U_PrevAndNext(
			long dataPackEntryId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of data pack entries where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching data pack entries
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns all the data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByG_S(long groupId, int status);

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
	public java.util.List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry[] findByG_S_PrevAndNext(
			long dataPackEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of data pack entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns all the data pack entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByU_S(long userId, int status);

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
	public java.util.List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry[] findByU_S_PrevAndNext(
			long dataPackEntryId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of data pack entries where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

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
	public DataPackEntry findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public DataPackEntry[] findByG_U_S_PrevAndNext(
			long dataPackEntryId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of data pack entries where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching data pack entries
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the data pack entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByDataSetId(long dataSetId);

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
	public java.util.List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByDataSetId_PrevAndNext(
			long dataPackEntryId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of data pack entries where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching data pack entries
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the data pack entries where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId);

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
	public java.util.List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end);

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
	public java.util.List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByDataSetFolderId(
		long dataSetFolderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataSetFolderId_First(
			long dataSetFolderId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataSetFolderId_First(
		long dataSetFolderId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataSetFolderId_Last(
			long dataSetFolderId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataSetFolderId_Last(
		long dataSetFolderId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataSetFolderId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataSetFolderId the data set folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByDataSetFolderId_PrevAndNext(
			long dataPackEntryId, long dataSetFolderId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where dataSetFolderId = &#63; from the database.
	 *
	 * @param dataSetFolderId the data set folder ID
	 */
	public void removeByDataSetFolderId(long dataSetFolderId);

	/**
	 * Returns the number of data pack entries where dataSetFolderId = &#63;.
	 *
	 * @param dataSetFolderId the data set folder ID
	 * @return the number of matching data pack entries
	 */
	public int countByDataSetFolderId(long dataSetFolderId);

	/**
	 * Returns all the data pack entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the matching data pack entries
	 */
	public java.util.List<DataPackEntry> findByDataPackId(long dataPackId);

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
	public java.util.List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end);

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
	public java.util.List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findByDataPackId(
		long dataPackId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataPackId_First(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the first data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataPackId_First(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the last data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry
	 * @throws NoSuchDataPackEntryException if a matching data pack entry could not be found
	 */
	public DataPackEntry findByDataPackId_Last(
			long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the last data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public DataPackEntry fetchByDataPackId_Last(
		long dataPackId,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

	/**
	 * Returns the data pack entries before and after the current data pack entry in the ordered set where dataPackId = &#63;.
	 *
	 * @param dataPackEntryId the primary key of the current data pack entry
	 * @param dataPackId the data pack ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry[] findByDataPackId_PrevAndNext(
			long dataPackEntryId, long dataPackId,
			com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
				orderByComparator)
		throws NoSuchDataPackEntryException;

	/**
	 * Removes all the data pack entries where dataPackId = &#63; from the database.
	 *
	 * @param dataPackId the data pack ID
	 */
	public void removeByDataPackId(long dataPackId);

	/**
	 * Returns the number of data pack entries where dataPackId = &#63;.
	 *
	 * @param dataPackId the data pack ID
	 * @return the number of matching data pack entries
	 */
	public int countByDataPackId(long dataPackId);

	/**
	 * Caches the data pack entry in the entity cache if it is enabled.
	 *
	 * @param dataPackEntry the data pack entry
	 */
	public void cacheResult(DataPackEntry dataPackEntry);

	/**
	 * Caches the data pack entries in the entity cache if it is enabled.
	 *
	 * @param dataPackEntries the data pack entries
	 */
	public void cacheResult(java.util.List<DataPackEntry> dataPackEntries);

	/**
	 * Creates a new data pack entry with the primary key. Does not add the data pack entry to the database.
	 *
	 * @param dataPackEntryId the primary key for the new data pack entry
	 * @return the new data pack entry
	 */
	public DataPackEntry create(long dataPackEntryId);

	/**
	 * Removes the data pack entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry that was removed
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry remove(long dataPackEntryId)
		throws NoSuchDataPackEntryException;

	public DataPackEntry updateImpl(DataPackEntry dataPackEntry);

	/**
	 * Returns the data pack entry with the primary key or throws a <code>NoSuchDataPackEntryException</code> if it could not be found.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry
	 * @throws NoSuchDataPackEntryException if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry findByPrimaryKey(long dataPackEntryId)
		throws NoSuchDataPackEntryException;

	/**
	 * Returns the data pack entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry, or <code>null</code> if a data pack entry with the primary key could not be found
	 */
	public DataPackEntry fetchByPrimaryKey(long dataPackEntryId);

	/**
	 * Returns all the data pack entries.
	 *
	 * @return the data pack entries
	 */
	public java.util.List<DataPackEntry> findAll();

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
	public java.util.List<DataPackEntry> findAll(int start, int end);

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
	public java.util.List<DataPackEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator);

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
	public java.util.List<DataPackEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data pack entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data pack entries.
	 *
	 * @return the number of data pack entries
	 */
	public int countAll();

}