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

import com.sx.icecap.exception.NoSuchTermException;
import com.sx.icecap.model.Term;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TermUtil
 * @generated
 */
@ProviderType
public interface TermPersistence extends BasePersistence<Term> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TermUtil} to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the terms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching terms
	 */
	public java.util.List<Term> findByUuid(String uuid);

	/**
	 * Returns a range of all the terms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the terms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where uuid = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByUuid_PrevAndNext(
			long termId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of terms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching terms
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the term where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTermException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUUID_G(String uuid, long groupId)
		throws NoSuchTermException;

	/**
	 * Returns the term where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the term where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the term where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the term that was removed
	 */
	public Term removeByUUID_G(String uuid, long groupId)
		throws NoSuchTermException;

	/**
	 * Returns the number of terms where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching terms
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the terms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the terms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByUuid_C_PrevAndNext(
			long termId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of terms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching terms
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByGroupId(long groupId);

	/**
	 * Returns a range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByGroupId(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByGroupId_PrevAndNext(
			long termId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns all the terms that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the terms that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the terms that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set of terms that the user has permission to view where groupId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] filterFindByGroupId_PrevAndNext(
			long termId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching terms
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of terms that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching terms that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the terms where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByUserId(long userId);

	/**
	 * Returns a range of all the terms where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByUserId(long userId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where userId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByUserId_PrevAndNext(
			long termId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of terms where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching terms
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the terms where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching terms
	 */
	public java.util.List<Term> findByStatus(int status);

	/**
	 * Returns a range of all the terms where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByStatus(int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByStatus_PrevAndNext(
			long termId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of terms where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching terms
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the terms where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching terms
	 */
	public java.util.List<Term> findByG_U(long groupId, long userId);

	/**
	 * Returns a range of all the terms where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_U_First(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_U_First(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_U_Last(
			long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_U_Last(
		long groupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByG_U_PrevAndNext(
			long termId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns all the terms that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U(long groupId, long userId);

	/**
	 * Returns a range of all the terms that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U(
		long groupId, long userId, int start, int end);

	/**
	 * Returns an ordered range of all the terms that the user has permissions to view where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U(
		long groupId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set of terms that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] filterFindByG_U_PrevAndNext(
			long termId, long groupId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	public void removeByG_U(long groupId, long userId);

	/**
	 * Returns the number of terms where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching terms
	 */
	public int countByG_U(long groupId, long userId);

	/**
	 * Returns the number of terms that the user has permission to view where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching terms that the user has permission to view
	 */
	public int filterCountByG_U(long groupId, long userId);

	/**
	 * Returns all the terms where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching terms
	 */
	public java.util.List<Term> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the terms where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByG_S_PrevAndNext(
			long termId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns all the terms that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_S(long groupId, int status);

	/**
	 * Returns a range of all the terms that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set of terms that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] filterFindByG_S_PrevAndNext(
			long termId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of terms where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching terms
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of terms that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching terms that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the terms where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching terms
	 */
	public java.util.List<Term> findByU_S(long userId, int status);

	/**
	 * Returns a range of all the terms where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByU_S(
		long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByU_S(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByU_S_First(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByU_S_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByU_S_Last(
			long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByU_S_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where userId = &#63; and status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByU_S_PrevAndNext(
			long termId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where userId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByU_S(long userId, int status);

	/**
	 * Returns the number of terms where userId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching terms
	 */
	public int countByU_S(long userId, int status);

	/**
	 * Returns all the terms where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching terms
	 */
	public java.util.List<Term> findByG_U_S(
		long groupId, long userId, int status);

	/**
	 * Returns a range of all the terms where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByG_U_S(
		long groupId, long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_U_S_First(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_U_S_First(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByG_U_S_Last(
			long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByG_U_S_Last(
		long groupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByG_U_S_PrevAndNext(
			long termId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns all the terms that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U_S(
		long groupId, long userId, int status);

	/**
	 * Returns a range of all the terms that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the terms that the user has permissions to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms that the user has permission to view
	 */
	public java.util.List<Term> filterFindByG_U_S(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set of terms that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] filterFindByG_U_S_PrevAndNext(
			long termId, long groupId, long userId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where groupId = &#63; and userId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 */
	public void removeByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of terms where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching terms
	 */
	public int countByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns the number of terms that the user has permission to view where groupId = &#63; and userId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param status the status
	 * @return the number of matching terms that the user has permission to view
	 */
	public int filterCountByG_U_S(long groupId, long userId, int status);

	/**
	 * Returns all the terms where termName = &#63;.
	 *
	 * @param termName the term name
	 * @return the matching terms
	 */
	public java.util.List<Term> findByName(String termName);

	/**
	 * Returns a range of all the terms where termName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param termName the term name
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	public java.util.List<Term> findByName(String termName, int start, int end);

	/**
	 * Returns an ordered range of all the terms where termName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param termName the term name
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByName(
		String termName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms where termName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param termName the term name
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	public java.util.List<Term> findByName(
		String termName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first term in the ordered set where termName = &#63;.
	 *
	 * @param termName the term name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByName_First(
			String termName,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the first term in the ordered set where termName = &#63;.
	 *
	 * @param termName the term name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByName_First(
		String termName,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the last term in the ordered set where termName = &#63;.
	 *
	 * @param termName the term name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByName_Last(
			String termName,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Returns the last term in the ordered set where termName = &#63;.
	 *
	 * @param termName the term name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByName_Last(
		String termName,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns the terms before and after the current term in the ordered set where termName = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param termName the term name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term[] findByName_PrevAndNext(
			long termId, String termName,
			com.liferay.portal.kernel.util.OrderByComparator<Term>
				orderByComparator)
		throws NoSuchTermException;

	/**
	 * Removes all the terms where termName = &#63; from the database.
	 *
	 * @param termName the term name
	 */
	public void removeByName(String termName);

	/**
	 * Returns the number of terms where termName = &#63;.
	 *
	 * @param termName the term name
	 * @return the number of matching terms
	 */
	public int countByName(String termName);

	/**
	 * Returns the term where termName = &#63; and termVersion = &#63; or throws a <code>NoSuchTermException</code> if it could not be found.
	 *
	 * @param termName the term name
	 * @param termVersion the term version
	 * @return the matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	public Term findByNameVersion(String termName, String termVersion)
		throws NoSuchTermException;

	/**
	 * Returns the term where termName = &#63; and termVersion = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param termName the term name
	 * @param termVersion the term version
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByNameVersion(String termName, String termVersion);

	/**
	 * Returns the term where termName = &#63; and termVersion = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param termName the term name
	 * @param termVersion the term version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching term, or <code>null</code> if a matching term could not be found
	 */
	public Term fetchByNameVersion(
		String termName, String termVersion, boolean useFinderCache);

	/**
	 * Removes the term where termName = &#63; and termVersion = &#63; from the database.
	 *
	 * @param termName the term name
	 * @param termVersion the term version
	 * @return the term that was removed
	 */
	public Term removeByNameVersion(String termName, String termVersion)
		throws NoSuchTermException;

	/**
	 * Returns the number of terms where termName = &#63; and termVersion = &#63;.
	 *
	 * @param termName the term name
	 * @param termVersion the term version
	 * @return the number of matching terms
	 */
	public int countByNameVersion(String termName, String termVersion);

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	public void cacheResult(Term term);

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	public void cacheResult(java.util.List<Term> terms);

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	public Term create(long termId);

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term remove(long termId) throws NoSuchTermException;

	public Term updateImpl(Term term);

	/**
	 * Returns the term with the primary key or throws a <code>NoSuchTermException</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	public Term findByPrimaryKey(long termId) throws NoSuchTermException;

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 */
	public Term fetchByPrimaryKey(long termId);

	/**
	 * Returns all the terms.
	 *
	 * @return the terms
	 */
	public java.util.List<Term> findAll();

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	public java.util.List<Term> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 */
	public java.util.List<Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator);

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of terms
	 */
	public java.util.List<Term> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Term>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the terms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	public int countAll();

}