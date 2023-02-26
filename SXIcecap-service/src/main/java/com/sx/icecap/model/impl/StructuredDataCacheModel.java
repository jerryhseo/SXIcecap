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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", structuredDataId=");
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
		sb.append(", dataSetDisplayName=");
		sb.append(dataSetDisplayName);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", dataTypeDisplayName=");
		sb.append(dataTypeDisplayName);
		sb.append(", structuredData=");
		sb.append(structuredData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StructuredData toEntityModel() {
		StructuredDataImpl structuredDataImpl = new StructuredDataImpl();

		if (uuid == null) {
			structuredDataImpl.setUuid("");
		}
		else {
			structuredDataImpl.setUuid(uuid);
		}

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

		structuredDataImpl.setStatus(status);
		structuredDataImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			structuredDataImpl.setStatusByUserName("");
		}
		else {
			structuredDataImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			structuredDataImpl.setStatusDate(null);
		}
		else {
			structuredDataImpl.setStatusDate(new Date(statusDate));
		}

		structuredDataImpl.setDataSetId(dataSetId);

		if (dataSetDisplayName == null) {
			structuredDataImpl.setDataSetDisplayName("");
		}
		else {
			structuredDataImpl.setDataSetDisplayName(dataSetDisplayName);
		}

		structuredDataImpl.setDataTypeId(dataTypeId);

		if (dataTypeDisplayName == null) {
			structuredDataImpl.setDataTypeDisplayName("");
		}
		else {
			structuredDataImpl.setDataTypeDisplayName(dataTypeDisplayName);
		}

		if (structuredData == null) {
			structuredDataImpl.setStructuredData("");
		}
		else {
			structuredDataImpl.setStructuredData(structuredData);
		}

		structuredDataImpl.resetOriginalValues();

		return structuredDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		structuredDataId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		dataSetId = objectInput.readLong();
		dataSetDisplayName = objectInput.readUTF();

		dataTypeId = objectInput.readLong();
		dataTypeDisplayName = objectInput.readUTF();
		structuredData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

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

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(dataSetId);

		if (dataSetDisplayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataSetDisplayName);
		}

		objectOutput.writeLong(dataTypeId);

		if (dataTypeDisplayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeDisplayName);
		}

		if (structuredData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structuredData);
		}
	}

	public String uuid;
	public long structuredDataId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long dataSetId;
	public String dataSetDisplayName;
	public long dataTypeId;
	public String dataTypeDisplayName;
	public String structuredData;

}