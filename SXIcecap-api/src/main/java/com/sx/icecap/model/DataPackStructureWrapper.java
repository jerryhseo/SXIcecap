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

package com.sx.icecap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataPackStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPackStructure
 * @generated
 */
public class DataPackStructureWrapper
	extends BaseModelWrapper<DataPackStructure>
	implements DataPackStructure, ModelWrapper<DataPackStructure> {

	public DataPackStructureWrapper(DataPackStructure dataPackStructure) {
		super(dataPackStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dataPackId", getDataPackId());
		attributes.put("structure", getStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
		}

		String structure = (String)attributes.get("structure");

		if (structure != null) {
			setStructure(structure);
		}
	}

	/**
	 * Returns the data pack ID of this data pack structure.
	 *
	 * @return the data pack ID of this data pack structure
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the primary key of this data pack structure.
	 *
	 * @return the primary key of this data pack structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structure of this data pack structure.
	 *
	 * @return the structure of this data pack structure
	 */
	@Override
	public String getStructure() {
		return model.getStructure();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data pack ID of this data pack structure.
	 *
	 * @param dataPackId the data pack ID of this data pack structure
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the primary key of this data pack structure.
	 *
	 * @param primaryKey the primary key of this data pack structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structure of this data pack structure.
	 *
	 * @param structure the structure of this data pack structure
	 */
	@Override
	public void setStructure(String structure) {
		model.setStructure(structure);
	}

	@Override
	protected DataPackStructureWrapper wrap(
		DataPackStructure dataPackStructure) {

		return new DataPackStructureWrapper(dataPackStructure);
	}

}