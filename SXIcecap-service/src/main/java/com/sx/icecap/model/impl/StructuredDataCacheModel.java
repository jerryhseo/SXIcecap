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

import com.sx.icecap.model.StructuredData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StructuredData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StructuredDataCacheModel
	implements CacheModel<StructuredData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StructuredDataCacheModel)) {
			return false;
		}

		StructuredDataCacheModel structuredDataCacheModel =
			(StructuredDataCacheModel)object;

		if (structuredDataId == structuredDataCacheModel.structuredDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, structuredDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{structuredDataId=");
		sb.append(structuredDataId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", structuredData=");
		sb.append(structuredData);
		sb.append(", patientId=");
		sb.append(patientId);
		sb.append(", crfId=");
		sb.append(crfId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StructuredData toEntityModel() {
		StructuredDataImpl structuredDataImpl = new StructuredDataImpl();

		structuredDataImpl.setStructuredDataId(structuredDataId);
		structuredDataImpl.setGroupId(groupId);
		structuredDataImpl.setCompanyId(companyId);
		structuredDataImpl.setUserId(userId);

		if (userName == null) {
			structuredDataImpl.setUserName("");
		}
		else {
			structuredDataImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			structuredDataImpl.setCreateDate(null);
		}
		else {
			structuredDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			structuredDataImpl.setModifiedDate(null);
		}
		else {
			structuredDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		structuredDataImpl.setDataSetId(dataSetId);
		structuredDataImpl.setDataTypeId(dataTypeId);

		if (structuredData == null) {
			structuredDataImpl.setStructuredData("");
		}
		else {
			structuredDataImpl.setStructuredData(structuredData);
		}

		structuredDataImpl.setPatientId(patientId);
		structuredDataImpl.setCrfId(crfId);

		structuredDataImpl.resetOriginalValues();

		return structuredDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		structuredDataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataTypeId = objectInput.readLong();
		structuredData = objectInput.readUTF();

		patientId = objectInput.readLong();

		crfId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(structuredDataId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(dataSetId);

		objectOutput.writeLong(dataTypeId);

		if (structuredData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structuredData);
		}

		objectOutput.writeLong(patientId);

		objectOutput.writeLong(crfId);
	}

	public long structuredDataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dataSetId;
	public long dataTypeId;
	public String structuredData;
	public long patientId;
	public long crfId;

}