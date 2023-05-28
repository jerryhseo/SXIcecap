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
 * The extended model interface for the DataPack service. Represents a row in the &quot;SX_ICECAP_DataPack&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataPackImpl")
@ProviderType
public interface DataPack extends DataPackModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataPackImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataPack, String> UUID_ACCESSOR =
		new Accessor<DataPack, String>() {

			@Override
			public String get(DataPack dataPack) {
				return dataPack.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataPack> getTypeClass() {
				return DataPack.class;
			}

		};

	public static final Accessor<DataPack, Long> DATA_PACK_ID_ACCESSOR =
		new Accessor<DataPack, Long>() {

			@Override
			public Long get(DataPack dataPack) {
				return dataPack.getDataPackId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataPack> getTypeClass() {
				return DataPack.class;
			}

		};

}