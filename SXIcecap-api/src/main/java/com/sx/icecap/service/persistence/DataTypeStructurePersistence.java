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

import com.sx.icecap.exception.NoSuchDataTypeStructureException;
import com.sx.icecap.model.DataTypeStructure;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data type structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeStructureUtil
 * @generated
 */
@ProviderType
public interface DataTypeStructurePersistence
	extends BasePersistence<DataTypeStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeStructureUtil} to access the data type structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the data type structure in the entity cache if it is enabled.
	 *
	 * @param dataTypeStructure the data type structure
	 */
	public void cacheResult(DataTypeStructure dataTypeStructure);

	/**
	 * Caches the data type structures in the entity cache if it is enabled.
	 *
	 * @param dataTypeStructures the data type structures
	 */
	public void cacheResult(
		java.util.List<DataTypeStructure> dataTypeStructures);

	/**
	 * Creates a new data type structure with the primary key. Does not add the data type structure to the database.
	 *
	 * @param dataTypeId the primary key for the new data type structure
	 * @return the new data type structure
	 */
	public DataTypeStructure create(long dataTypeId);

	/**
	 * Removes the data type structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure that was removed
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	public DataTypeStructure remove(long dataTypeId)
		throws NoSuchDataTypeStructureException;

	public DataTypeStructure updateImpl(DataTypeStructure dataTypeStructure);

	/**
	 * Returns the data type structure with the primary key or throws a <code>NoSuchDataTypeStructureException</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure
	 * @throws NoSuchDataTypeStructureException if a data type structure with the primary key could not be found
	 */
	public DataTypeStructure findByPrimaryKey(long dataTypeId)
		throws NoSuchDataTypeStructureException;

	/**
	 * Returns the data type structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataTypeId the primary key of the data type structure
	 * @return the data type structure, or <code>null</code> if a data type structure with the primary key could not be found
	 */
	public DataTypeStructure fetchByPrimaryKey(long dataTypeId);

	/**
	 * Returns all the data type structures.
	 *
	 * @return the data type structures
	 */
	public java.util.List<DataTypeStructure> findAll();

	/**
	 * Returns a range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @return the range of data type structures
	 */
	public java.util.List<DataTypeStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data type structures
	 */
	public java.util.List<DataTypeStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data type structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataTypeStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data type structures
	 * @param end the upper bound of the range of data type structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data type structures
	 */
	public java.util.List<DataTypeStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataTypeStructure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data type structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data type structures.
	 *
	 * @return the number of data type structures
	 */
	public int countAll();

}