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

import com.sx.icecap.exception.NoSuchVisualizerLinkException;
import com.sx.icecap.model.VisualizerLink;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisualizerLinkUtil
 * @generated
 */
@ProviderType
public interface VisualizerLinkPersistence
	extends BasePersistence<VisualizerLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisualizerLinkUtil} to access the visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching visualizer links
	 */
	public java.util.List<VisualizerLink> findByDataTypeId(long dataTypeId);

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
	public java.util.List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end);

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
	public java.util.List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

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
	public java.util.List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public VisualizerLink findByDataTypeId_First(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public VisualizerLink fetchByDataTypeId_First(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public VisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public VisualizerLink fetchByDataTypeId_Last(
		long dataTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public VisualizerLink[] findByDataTypeId_PrevAndNext(
			long VisualizerLink, long dataTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Removes all the visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	public void removeByDataTypeId(long dataTypeId);

	/**
	 * Returns the number of visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching visualizer links
	 */
	public int countByDataTypeId(long dataTypeId);

	/**
	 * Returns all the visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching visualizer links
	 */
	public java.util.List<VisualizerLink> findByVisualizerId(long visualizerId);

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
	public java.util.List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end);

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
	public java.util.List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

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
	public java.util.List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public VisualizerLink findByVisualizerId_First(
			long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public VisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	public VisualizerLink findByVisualizerId_Last(
			long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	public VisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public VisualizerLink[] findByVisualizerId_PrevAndNext(
			long VisualizerLink, long visualizerId,
			com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
				orderByComparator)
		throws NoSuchVisualizerLinkException;

	/**
	 * Removes all the visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	public void removeByVisualizerId(long visualizerId);

	/**
	 * Returns the number of visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching visualizer links
	 */
	public int countByVisualizerId(long visualizerId);

	/**
	 * Caches the visualizer link in the entity cache if it is enabled.
	 *
	 * @param visualizerLink the visualizer link
	 */
	public void cacheResult(VisualizerLink visualizerLink);

	/**
	 * Caches the visualizer links in the entity cache if it is enabled.
	 *
	 * @param visualizerLinks the visualizer links
	 */
	public void cacheResult(java.util.List<VisualizerLink> visualizerLinks);

	/**
	 * Creates a new visualizer link with the primary key. Does not add the visualizer link to the database.
	 *
	 * @param VisualizerLink the primary key for the new visualizer link
	 * @return the new visualizer link
	 */
	public VisualizerLink create(long VisualizerLink);

	/**
	 * Removes the visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link that was removed
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public VisualizerLink remove(long VisualizerLink)
		throws NoSuchVisualizerLinkException;

	public VisualizerLink updateImpl(VisualizerLink visualizerLink);

	/**
	 * Returns the visualizer link with the primary key or throws a <code>NoSuchVisualizerLinkException</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	public VisualizerLink findByPrimaryKey(long VisualizerLink)
		throws NoSuchVisualizerLinkException;

	/**
	 * Returns the visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link, or <code>null</code> if a visualizer link with the primary key could not be found
	 */
	public VisualizerLink fetchByPrimaryKey(long VisualizerLink);

	/**
	 * Returns all the visualizer links.
	 *
	 * @return the visualizer links
	 */
	public java.util.List<VisualizerLink> findAll();

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
	public java.util.List<VisualizerLink> findAll(int start, int end);

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
	public java.util.List<VisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator);

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
	public java.util.List<VisualizerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<VisualizerLink>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the visualizer links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of visualizer links.
	 *
	 * @return the number of visualizer links
	 */
	public int countAll();

}