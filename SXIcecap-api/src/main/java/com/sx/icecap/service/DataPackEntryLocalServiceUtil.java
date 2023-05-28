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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sx.icecap.model.DataPackEntry;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for DataPackEntry. This utility wraps
 * <code>com.sx.icecap.service.impl.DataPackEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntryLocalService
 * @generated
 */
public class DataPackEntryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.DataPackEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the data pack entry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was added
	 */
	public static DataPackEntry addDataPackEntry(DataPackEntry dataPackEntry) {
		return getService().addDataPackEntry(dataPackEntry);
	}

	/**
	 * Creates a new data pack entry with the primary key. Does not add the data pack entry to the database.
	 *
	 * @param dataPackEntryId the primary key for the new data pack entry
	 * @return the new data pack entry
	 */
	public static DataPackEntry createDataPackEntry(long dataPackEntryId) {
		return getService().createDataPackEntry(dataPackEntryId);
	}

	/**
	 * Deletes the data pack entry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was removed
	 */
	public static DataPackEntry deleteDataPackEntry(
		DataPackEntry dataPackEntry) {

		return getService().deleteDataPackEntry(dataPackEntry);
	}

	/**
	 * Deletes the data pack entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry that was removed
	 * @throws PortalException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry deleteDataPackEntry(long dataPackEntryId)
		throws PortalException {

		return getService().deleteDataPackEntry(dataPackEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static DataPackEntry fetchDataPackEntry(long dataPackEntryId) {
		return getService().fetchDataPackEntry(dataPackEntryId);
	}

	/**
	 * Returns the data pack entry matching the UUID and group.
	 *
	 * @param uuid the data pack entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack entry, or <code>null</code> if a matching data pack entry could not be found
	 */
	public static DataPackEntry fetchDataPackEntryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDataPackEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the data pack entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @return the range of data pack entries
	 */
	public static List<DataPackEntry> getDataPackEntries(int start, int end) {
		return getService().getDataPackEntries(start, end);
	}

	/**
	 * Returns all the data pack entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data pack entries
	 * @param companyId the primary key of the company
	 * @return the matching data pack entries, or an empty list if no matches were found
	 */
	public static List<DataPackEntry> getDataPackEntriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDataPackEntriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of data pack entries matching the UUID and company.
	 *
	 * @param uuid the UUID of the data pack entries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data pack entries
	 * @param end the upper bound of the range of data pack entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data pack entries, or an empty list if no matches were found
	 */
	public static List<DataPackEntry> getDataPackEntriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPackEntry> orderByComparator) {

		return getService().getDataPackEntriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of data pack entries.
	 *
	 * @return the number of data pack entries
	 */
	public static int getDataPackEntriesCount() {
		return getService().getDataPackEntriesCount();
	}

	/**
	 * Returns the data pack entry with the primary key.
	 *
	 * @param dataPackEntryId the primary key of the data pack entry
	 * @return the data pack entry
	 * @throws PortalException if a data pack entry with the primary key could not be found
	 */
	public static DataPackEntry getDataPackEntry(long dataPackEntryId)
		throws PortalException {

		return getService().getDataPackEntry(dataPackEntryId);
	}

	/**
	 * Returns the data pack entry matching the UUID and group.
	 *
	 * @param uuid the data pack entry's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack entry
	 * @throws PortalException if a matching data pack entry could not be found
	 */
	public static DataPackEntry getDataPackEntryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDataPackEntryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the data pack entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackEntryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackEntry the data pack entry
	 * @return the data pack entry that was updated
	 */
	public static DataPackEntry updateDataPackEntry(
		DataPackEntry dataPackEntry) {

		return getService().updateDataPackEntry(dataPackEntry);
	}

	public static DataPackEntryLocalService getService() {
		return _service;
	}

	private static volatile DataPackEntryLocalService _service;

}