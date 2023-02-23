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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DataType service. Represents a row in the &quot;SX_ICECAP_DataType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataTypeImpl")
@ProviderType
public interface DataType extends DataTypeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataType, String> UUID_ACCESSOR =
		new Accessor<DataType, String>() {

			@Override
			public String get(DataType dataType) {
				return dataType.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataType> getTypeClass() {
				return DataType.class;
			}

		};

	public static final Accessor<DataType, Long> DATA_TYPE_ID_ACCESSOR =
		new Accessor<DataType, Long>() {

			@Override
			public Long get(DataType dataType) {
				return dataType.getDataTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataType> getTypeClass() {
				return DataType.class;
			}

		};

}