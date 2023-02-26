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

import com.sx.icecap.exception.NoSuchStructuredDataException;
import com.sx.icecap.model.StructuredData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the structured data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataUtil
 * @generated
 */
@ProviderType
public interface StructuredDataPersistence
	extends BasePersistence<StructuredData> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StructuredDataUtil} to access the structured data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByUuid(String uuid);

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
	public java.util.List<StructuredData> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<StructuredData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where uuid = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByUuid_PrevAndNext(
			long structuredDataId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of structured datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching structured datas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUUID_G(String uuid, long groupId)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the structured data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the structured data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the structured data that was removed
	 */
	public StructuredData removeByUUID_G(String uuid, long groupId)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the number of structured datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] findByUuid_C_PrevAndNext(
			long structuredDataId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of structured datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching structured datas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByGroupId(long groupId);

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
	public java.util.List<StructuredData> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public java.util.List<StructuredData> filterFindByGroupId(long groupId);

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
	public java.util.List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<StructuredData> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] filterFindByGroupId_PrevAndNext(
			long structuredDataId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of structured datas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByUserId(long userId);

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
	public java.util.List<StructuredData> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<StructuredData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where userId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByUserId_PrevAndNext(
			long structuredDataId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of structured datas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByStatus(int status);

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
	public java.util.List<StructuredData> findByStatus(
		int status, int start, int end);

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
	public java.util.List<StructuredData> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where status = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByStatus_PrevAndNext(
			long structuredDataId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of structured datas where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByG_U(long groupId, long userId);

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
	public java.util.List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] findByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching structured datas that the user has permission to view
	 */
	public java.util.List<StructuredData> filterFindByG_U(
		long groupId, long userId);

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
	public java.util.List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end);

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
	public java.util.List<StructuredData> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] filterFindByG_U_PrevAndNext(
			long structuredDataId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByG_S(long groupId, int status);

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
	public java.util.List<StructuredData> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] findByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public java.util.List<StructuredData> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<StructuredData> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] filterFindByG_S_PrevAndNext(
			long structuredDataId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of structured datas where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByU_S(long userId, int status);

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
	public java.util.List<StructuredData> findByU_S(
		long userId, int status, int start, int end);

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
	public java.util.List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] findByU_S_PrevAndNext(
			long structuredDataId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of structured datas where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

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
	public StructuredData findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] findByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns all the structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching structured datas that the user has permission to view
	 */
	public java.util.List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status);

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
	public java.util.List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

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
	public java.util.List<StructuredData> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public StructuredData[] filterFindByG_U_S_PrevAndNext(
			long structuredDataId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of structured datas where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of structured datas that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching structured datas that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByDataSetId(long dataSetId);

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
	public java.util.List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end);

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
	public java.util.List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByDataSetId(
		long dataSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByDataSetId_First(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByDataSetId_First(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByDataSetId_Last(
			long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByDataSetId_Last(
		long dataSetId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataSetId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataSetId the data set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByDataSetId_PrevAndNext(
			long structuredDataId, long dataSetId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where dataSetId = &#63; from the database.
	 *
	 * @param dataSetId the data set ID
	 */
	public void removeByDataSetId(long dataSetId);

	/**
	 * Returns the number of structured datas where dataSetId = &#63;.
	 *
	 * @param dataSetId the data set ID
	 * @return the number of matching structured datas
	 */
	public int countByDataSetId(long dataSetId);

	/**
	 * Returns all the structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByDataTypeId(long dataTypeId);

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
	public java.util.List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end);

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
	public java.util.List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where dataTypeId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByDataTypeId_PrevAndNext(
			long structuredDataId, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of structured datas where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching structured datas
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Caches the structured data in the entity cache if it is enabled.
	 *
	 * @param structuredData the structured data
	 */
	public void cacheResult(StructuredData structuredData);

	/**
	 * Caches the structured datas in the entity cache if it is enabled.
	 *
	 * @param structuredDatas the structured datas
	 */
	public void cacheResult(java.util.List<StructuredData> structuredDatas);

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	public StructuredData create(long structuredDataId);

	/**
	 * Removes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData remove(long structuredDataId)
		throws NoSuchStructuredDataException;

	public StructuredData updateImpl(StructuredData structuredData);

	/**
	 * Returns the structured data with the primary key or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData findByPrimaryKey(long structuredDataId)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the structured data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data, or <code>null</code> if a structured data with the primary key could not be found
	 */
	public StructuredData fetchByPrimaryKey(long structuredDataId);

	/**
	 * Returns all the structured datas.
	 *
	 * @return the structured datas
	 */
	public java.util.List<StructuredData> findAll();

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
	public java.util.List<StructuredData> findAll(int start, int end);

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
	public java.util.List<StructuredData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

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
	public java.util.List<StructuredData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the structured datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	public int countAll();

}