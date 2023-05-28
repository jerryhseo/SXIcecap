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

import com.sx.icecap.exception.NoSuchDataPackStructureException;
import com.sx.icecap.model.DataPackStructure;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data pack structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPackStructureUtil
 * @generated
 */
@ProviderType
public interface DataPackStructurePersistence
	extends BasePersistence<DataPackStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataPackStructureUtil} to access the data pack structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the data pack structure in the entity cache if it is enabled.
	 *
	 * @param dataPackStructure the data pack structure
	 */
	public void cacheResult(DataPackStructure dataPackStructure);

	/**
	 * Caches the data pack structures in the entity cache if it is enabled.
	 *
	 * @param dataPackStructures the data pack structures
	 */
	public void cacheResult(
		java.util.List<DataPackStructure> dataPackStructures);

	/**
	 * Creates a new data pack structure with the primary key. Does not add the data pack structure to the database.
	 *
	 * @param dataPackId the primary key for the new data pack structure
	 * @return the new data pack structure
	 */
	public DataPackStructure create(long dataPackId);

	/**
	 * Removes the data pack structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure that was removed
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	public DataPackStructure remove(long dataPackId)
		throws NoSuchDataPackStructureException;

	public DataPackStructure updateImpl(DataPackStructure dataPackStructure);

	/**
	 * Returns the data pack structure with the primary key or throws a <code>NoSuchDataPackStructureException</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	public DataPackStructure findByPrimaryKey(long dataPackId)
		throws NoSuchDataPackStructureException;

	/**
	 * Returns the data pack structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure, or <code>null</code> if a data pack structure with the primary key could not be found
	 */
	public DataPackStructure fetchByPrimaryKey(long dataPackId);

	/**
	 * Returns all the data pack structures.
	 *
	 * @return the data pack structures
	 */
	public java.util.List<DataPackStructure> findAll();

	/**
	 * Returns a range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @return the range of data pack structures
	 */
	public java.util.List<DataPackStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data pack structures
	 */
	public java.util.List<DataPackStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data pack structures
	 */
	public java.util.List<DataPackStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataPackStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data pack structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data pack structures.
	 *
	 * @return the number of data pack structures
	 */
	public int countAll();

}