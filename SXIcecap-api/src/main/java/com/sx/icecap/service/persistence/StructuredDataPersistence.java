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
	 * Returns all the structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByCrf(long crfId);

	/**
	 * Returns a range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCrf(
		long crfId, int start, int end);

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCrf(
		long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCrf(
		long crfId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByCrf_First(
			long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByCrf_First(
		long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByCrf_Last(
			long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByCrf_Last(
		long crfId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where crfId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByCrf_PrevAndNext(
			long structuredDataId, long crfId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where crfId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 */
	public void removeByCrf(long crfId);

	/**
	 * Returns the number of structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the number of matching structured datas
	 */
	public int countByCrf(long crfId);

	/**
	 * Returns all the structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findBypatientId(long patientId);

	/**
	 * Returns a range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public java.util.List<StructuredData> findBypatientId(
		long patientId, int start, int end);

	/**
	 * Returns an ordered range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findBypatientId_First(
			long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchBypatientId_First(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findBypatientId_Last(
			long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchBypatientId_Last(
		long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where patientId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findBypatientId_PrevAndNext(
			long structuredDataId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public void removeBypatientId(long patientId);

	/**
	 * Returns the number of structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	public int countBypatientId(long patientId);

	/**
	 * Returns all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	public java.util.List<StructuredData> findByCP(long crfId, long patientId);

	/**
	 * Returns a range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end);

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	public java.util.List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByCP_First(
			long crfId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByCP_First(
		long crfId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public StructuredData findByCP_Last(
			long crfId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public StructuredData fetchByCP_Last(
		long crfId, long patientId,
		com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
			orderByComparator);

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public StructuredData[] findByCP_PrevAndNext(
			long structuredDataId, long crfId, long patientId,
			com.liferay.portal.kernel.util.OrderByComparator<StructuredData>
				orderByComparator)
		throws NoSuchStructuredDataException;

	/**
	 * Removes all the structured datas where crfId = &#63; and patientId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 */
	public void removeByCP(long crfId, long patientId);

	/**
	 * Returns the number of structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	public int countByCP(long crfId, long patientId);

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