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
 * The extended model interface for the DataPackEntry service. Represents a row in the &quot;SX_ICECAP_DataPackEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntryModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.DataPackEntryImpl")
@ProviderType
public interface DataPackEntry extends DataPackEntryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.DataPackEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DataPackEntry, String> UUID_ACCESSOR =
		new Accessor<DataPackEntry, String>() {

			@Override
			public String get(DataPackEntry dataPackEntry) {
				return dataPackEntry.getUuid();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<DataPackEntry> getTypeClass() {
				return DataPackEntry.class;
			}

		};

	public static final Accessor<DataPackEntry, Long>
		DATA_PACK_ENTRY_ID_ACCESSOR = new Accessor<DataPackEntry, Long>() {

			@Override
			public Long get(DataPackEntry dataPackEntry) {
				return dataPackEntry.getDataPackEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DataPackEntry> getTypeClass() {
				return DataPackEntry.class;
			}

		};

}