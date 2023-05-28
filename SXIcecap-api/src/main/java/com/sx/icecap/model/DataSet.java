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
 * The extended model interface for the DataSet service. Represents a row in the &quot;SX_ICECAP_DataSet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataSetModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataSetImpl")
@ProviderType
public interface DataSet extends DataSetModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataSetImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataSet, String> UUID_ACCESSOR =
		new Accessor<DataSet, String>() {

			@Override
			public String get(DataSet dataSet) {
				return dataSet.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataSet> getTypeClass() {
				return DataSet.class;
			}

		};

	public static final Accessor<DataSet, Long> DATA_SET_ID_ACCESSOR =
		new Accessor<DataSet, Long>() {

			@Override
			public Long get(DataSet dataSet) {
				return dataSet.getDataSetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataSet> getTypeClass() {
				return DataSet.class;
			}

		};

}