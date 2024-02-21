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

import com.sx.icecap.model.VisualizerLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the visualizer link service. This utility wraps <code>com.sx.icecap.service.persistence.impl.VisualizerLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisualizerLinkPersistence
 * @generated
 */
public class VisualizerLinkUtil {

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
	public static void clearCache(VisualizerLink visualizerLink) {
		getPersistence().clearCache(visualizerLink);
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
	public static Map<Serializable, VisualizerLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VisualizerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static VisualizerLink update(VisualizerLink visualizerLink) {
		return getPersistence().update(visualizerLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static VisualizerLink update(
		VisualizerLink visualizerLink, ServiceContext serviceContext) {

		return getPersistence().update(visualizerLink, serviceContext);
	}

	/**
	 * Returns all the visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching visualizer links
	 */
	public static List<VisualizerLink> findByDataTypeId(long dataTypeId) {
		return getPersistence().findByDataTypeId(dataTypeId);
	}

	/**
	 * Returns a range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of matching visualizer links
	 */
	public static List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return getPersistence().findByDataTypeId(dataTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visualizer links
	 */
	public static List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visualizer links
	 */
	public static List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDataTypeId(
			dataTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public static VisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public static VisualizerLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_First(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public static VisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public static VisualizerLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);
	}

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public static VisualizerLink[] findByDataTypeId_PrevAndNext(
			long VisualizerLink, long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByDataTypeId_PrevAndNext(
			VisualizerLink, dataTypeId, orderByComparator);
	}

	/**
	 * Removes all the visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public static void removeByDataTypeId(long dataTypeId) {
		getPersistence().removeByDataTypeId(dataTypeId);
	}

	/**
	 * Returns the number of visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching visualizer links
	 */
	public static int countByDataTypeId(long dataTypeId) {
		return getPersistence().countByDataTypeId(dataTypeId);
	}

	/**
	 * Returns all the visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching visualizer links
	 */
	public static List<VisualizerLink> findByVisualizerId(long visualizerId) {
		return getPersistence().findByVisualizerId(visualizerId);
	}

	/**
	 * Returns a range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of matching visualizer links
	 */
	public static List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end) {

		return getPersistence().findByVisualizerId(visualizerId, start, end);
	}

	/**
	 * Returns an ordered range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visualizer links
	 */
	public static List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().findByVisualizerId(
			visualizerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visualizer links
	 */
	public static List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVisualizerId(
			visualizerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public static VisualizerLink findByVisualizerId_First(
			long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByVisualizerId_First(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public static VisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerId_First(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public static VisualizerLink findByVisualizerId_Last(
			long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByVisualizerId_Last(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public static VisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().fetchByVisualizerId_Last(
			visualizerId, orderByComparator);
	}

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public static VisualizerLink[] findByVisualizerId_PrevAndNext(
			long VisualizerLink, long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByVisualizerId_PrevAndNext(
			VisualizerLink, visualizerId, orderByComparator);
	}

	/**
	 * Removes all the visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	public static void removeByVisualizerId(long visualizerId) {
		getPersistence().removeByVisualizerId(visualizerId);
	}

	/**
	 * Returns the number of visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching visualizer links
	 */
	public static int countByVisualizerId(long visualizerId) {
		return getPersistence().countByVisualizerId(visualizerId);
	}

	/**
	 * Caches the visualizer link in the entity cache if it is enabled.
	 *
	 * @param visualizerLink the visualizer link
	 */
	public static void cacheResult(VisualizerLink visualizerLink) {
		getPersistence().cacheResult(visualizerLink);
	}

	/**
	 * Caches the visualizer links in the entity cache if it is enabled.
	 *
	 * @param visualizerLinks the visualizer links
	 */
	public static void cacheResult(List<VisualizerLink> visualizerLinks) {
		getPersistence().cacheResult(visualizerLinks);
	}

	/**
	 * Creates a new visualizer link with the primary key. Does not add the visualizer link to the database.
	 *
	 * @param VisualizerLink the primary key for the new visualizer link
	 * @return the new visualizer link
	 */
	public static VisualizerLink create(long VisualizerLink) {
		return getPersistence().create(VisualizerLink);
	}

	/**
	 * Removes the visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link that was removed
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public static VisualizerLink remove(long VisualizerLink)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().remove(VisualizerLink);
	}

	public static VisualizerLink updateImpl(VisualizerLink visualizerLink) {
		return getPersistence().updateImpl(visualizerLink);
	}

	/**
	 * Returns the visualizer link with the primary key or throws a <code>NoSuchVisualizerLinkException</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public static VisualizerLink findByPrimaryKey(long VisualizerLink)
		throws com.sx.icecap.exception.NoSuchVisualizerLinkException {

		return getPersistence().findByPrimaryKey(VisualizerLink);
	}

	/**
	 * Returns the visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link, or <code>null</code> if a visualizer link with the primary key could not be found
	 */
	public static VisualizerLink fetchByPrimaryKey(long VisualizerLink) {
		return getPersistence().fetchByPrimaryKey(VisualizerLink);
	}

	/**
	 * Returns all the visualizer links.
	 *
	 * @return the visualizer links
	 */
	public static List<VisualizerLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of visualizer links
	 */
	public static List<VisualizerLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visualizer links
	 */
	public static List<VisualizerLink> findAll(
		int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visualizer links
	 */
	public static List<VisualizerLink> findAll(
		int start, int end, OrderByComparator<VisualizerLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the visualizer links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of visualizer links.
	 *
	 * @return the number of visualizer links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VisualizerLinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile VisualizerLinkPersistence _persistence;

}