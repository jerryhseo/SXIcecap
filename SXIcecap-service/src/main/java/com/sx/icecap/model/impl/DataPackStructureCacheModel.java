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

package com.sx.icecap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.DataPackStructure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DataPackStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataPackStructureCacheModel
	implements CacheModel<DataPackStructure>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataPackStructureCacheModel)) {
			return false;
		}

		DataPackStructureCacheModel dataPackStructureCacheModel =
			(DataPackStructureCacheModel)object;

		if (dataPackId == dataPackStructureCacheModel.dataPackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataPackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{dataPackId=");
		sb.append(dataPackId);
		sb.append(", structure=");
		sb.append(structure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataPackStructure toEntityModel() {
		DataPackStructureImpl dataPackStructureImpl =
			new DataPackStructureImpl();

		dataPackStructureImpl.setDataPackId(dataPackId);

		if (structure == null) {
			dataPackStructureImpl.setStructure("");
		}
		else {
			dataPackStructureImpl.setStructure(structure);
		}

		dataPackStructureImpl.resetOriginalValues();

		return dataPackStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dataPackId = objectInput.readLong();
		structure = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(dataPackId);

		if (structure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structure);
		}
	}

	public long dataPackId;
	public String structure;

}