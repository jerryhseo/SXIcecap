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
	 * Returns all the structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCrf(long crfId) {
		return getPersistence().findByCrf(crfId);
	}

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
	public static List<StructuredData> findByCrf(
		long crfId, int start, int end) {

		return getPersistence().findByCrf(crfId, start, end);
	}

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
	public static List<StructuredData> findByCrf(
		long crfId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCrf(crfId, start, end, orderByComparator);
	}

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
	public static List<StructuredData> findByCrf(
		long crfId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCrf(
			crfId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCrf_First(
			long crfId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCrf_First(crfId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCrf_First(
		long crfId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCrf_First(crfId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCrf_Last(
			long crfId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCrf_Last(crfId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCrf_Last(
		long crfId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCrf_Last(crfId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where crfId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findByCrf_PrevAndNext(
			long structuredDataId, long crfId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCrf_PrevAndNext(
			structuredDataId, crfId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where crfId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 */
	public static void removeByCrf(long crfId) {
		getPersistence().removeByCrf(crfId);
	}

	/**
	 * Returns the number of structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the number of matching structured datas
	 */
	public static int countByCrf(long crfId) {
		return getPersistence().countByCrf(crfId);
	}

	/**
	 * Returns all the structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findBypatientId(long patientId) {
		return getPersistence().findBypatientId(patientId);
	}

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
	public static List<StructuredData> findBypatientId(
		long patientId, int start, int end) {

		return getPersistence().findBypatientId(patientId, start, end);
	}

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
	public static List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findBypatientId(
			patientId, start, end, orderByComparator);
	}

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
	public static List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypatientId(
			patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBypatientId_First(
			long patientId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBypatientId_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBypatientId_First(
		long patientId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBypatientId_First(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findBypatientId_Last(
			long patientId, OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBypatientId_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchBypatientId_Last(
		long patientId, OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchBypatientId_Last(
			patientId, orderByComparator);
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where patientId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	public static StructuredData[] findBypatientId_PrevAndNext(
			long structuredDataId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findBypatientId_PrevAndNext(
			structuredDataId, patientId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	public static void removeBypatientId(long patientId) {
		getPersistence().removeBypatientId(patientId);
	}

	/**
	 * Returns the number of structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	public static int countBypatientId(long patientId) {
		return getPersistence().countBypatientId(patientId);
	}

	/**
	 * Returns all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	public static List<StructuredData> findByCP(long crfId, long patientId) {
		return getPersistence().findByCP(crfId, patientId);
	}

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
	public static List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end) {

		return getPersistence().findByCP(crfId, patientId, start, end);
	}

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
	public static List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().findByCP(
			crfId, patientId, start, end, orderByComparator);
	}

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
	public static List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCP(
			crfId, patientId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCP_First(
			long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCP_First(
			crfId, patientId, orderByComparator);
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCP_First(
		long crfId, long patientId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCP_First(
			crfId, patientId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	public static StructuredData findByCP_Last(
			long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCP_Last(
			crfId, patientId, orderByComparator);
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	public static StructuredData fetchByCP_Last(
		long crfId, long patientId,
		OrderByComparator<StructuredData> orderByComparator) {

		return getPersistence().fetchByCP_Last(
			crfId, patientId, orderByComparator);
	}

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
	public static StructuredData[] findByCP_PrevAndNext(
			long structuredDataId, long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws com.sx.icecap.exception.NoSuchStructuredDataException {

		return getPersistence().findByCP_PrevAndNext(
			structuredDataId, crfId, patientId, orderByComparator);
	}

	/**
	 * Removes all the structured datas where crfId = &#63; and patientId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 */
	public static void removeByCP(long crfId, long patientId) {
		getPersistence().removeByCP(crfId, patientId);
	}

	/**
	 * Returns the number of structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	public static int countByCP(long crfId, long patientId) {
		return getPersistence().countByCP(crfId, patientId);
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