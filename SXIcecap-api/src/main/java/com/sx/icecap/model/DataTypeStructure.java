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
 * The extended model interface for the DataTypeStructure service. Represents a row in the &quot;SX_ICECAP_DataTypeStructure&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataTypeStructureModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataTypeStructureImpl")
@ProviderType
public interface DataTypeStructure
	extends DataTypeStructureModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataTypeStructureImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataTypeStructure, Long>
		DATA_TYPE_ID_ACCESSOR = new Accessor<DataTypeStructure, Long>() {

			@Override
			public Long get(DataTypeStructure dataTypeStructure) {
				return dataTypeStructure.getDataTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataTypeStructure> getTypeClass() {
				return DataTypeStructure.class;
			}

		};

}