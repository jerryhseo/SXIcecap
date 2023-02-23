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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DataTypeStructure service. Represents a row in the &quot;SX_ICECAP_DataTypeStructure&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sx.icecap.model.impl.DataTypeStructureModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sx.icecap.model.impl.DataTypeStructureImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeStructure
 * @generated
 */
@ProviderType
public interface DataTypeStructureModel extends BaseModel<DataTypeStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data type structure model instance should use the {@link DataTypeStructure} interface instead.
	 */

	/**
	 * Returns the primary key of this data type structure.
	 *
	 * @return the primary key of this data type structure
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this data type structure.
	 *
	 * @param primaryKey the primary key of this data type structure
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the data type ID of this data type structure.
	 *
	 * @return the data type ID of this data type structure
	 */
	public long getDataTypeId();

	/**
	 * Sets the data type ID of this data type structure.
	 *
	 * @param dataTypeId the data type ID of this data type structure
	 */
	public void setDataTypeId(long dataTypeId);

	/**
	 * Returns the structure of this data type structure.
	 *
	 * @return the structure of this data type structure
	 */
	@AutoEscape
	public String getStructure();

	/**
	 * Sets the structure of this data type structure.
	 *
	 * @param structure the structure of this data type structure
	 */
	public void setStructure(String structure);

}