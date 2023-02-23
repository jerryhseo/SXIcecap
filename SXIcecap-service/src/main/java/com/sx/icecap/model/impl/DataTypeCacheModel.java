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

import com.sx.icecap.model.DataType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataTypeCacheModel
	implements CacheModel<DataType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataTypeCacheModel)) {
			return false;
		}

		DataTypeCacheModel dataTypeCacheModel = (DataTypeCacheModel)object;

		if (dataTypeId == dataTypeCacheModel.dataTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", dataTypeName=");
		sb.append(dataTypeName);
		sb.append(", dataTypeVersion=");
		sb.append(dataTypeVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", extension=");
		sb.append(extension);
		sb.append(", sampleFileId=");
		sb.append(sampleFileId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", tooltip=");
		sb.append(tooltip);
		sb.append(", hasDataStructure=");
		sb.append(hasDataStructure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataType toEntityModel() {
		DataTypeImpl dataTypeImpl = new DataTypeImpl();

		if (uuid == null) {
			dataTypeImpl.setUuid("");
		}
		else {
			dataTypeImpl.setUuid(uuid);
		}

		dataTypeImpl.setDataTypeId(dataTypeId);
		dataTypeImpl.setCompanyId(companyId);
		dataTypeImpl.setGroupId(groupId);
		dataTypeImpl.setUserId(userId);

		if (userName == null) {
			dataTypeImpl.setUserName("");
		}
		else {
			dataTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataTypeImpl.setCreateDate(null);
		}
		else {
			dataTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataTypeImpl.setModifiedDate(null);
		}
		else {
			dataTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataTypeImpl.setStatus(status);
		dataTypeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataTypeImpl.setStatusByUserName("");
		}
		else {
			dataTypeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataTypeImpl.setStatusDate(null);
		}
		else {
			dataTypeImpl.setStatusDate(new Date(statusDate));
		}

		if (dataTypeName == null) {
			dataTypeImpl.setDataTypeName("");
		}
		else {
			dataTypeImpl.setDataTypeName(dataTypeName);
		}

		if (dataTypeVersion == null) {
			dataTypeImpl.setDataTypeVersion("");
		}
		else {
			dataTypeImpl.setDataTypeVersion(dataTypeVersion);
		}

		if (displayName == null) {
			dataTypeImpl.setDisplayName("");
		}
		else {
			dataTypeImpl.setDisplayName(displayName);
		}

		if (extension == null) {
			dataTypeImpl.setExtension("");
		}
		else {
			dataTypeImpl.setExtension(extension);
		}

		dataTypeImpl.setSampleFileId(sampleFileId);

		if (description == null) {
			dataTypeImpl.setDescription("");
		}
		else {
			dataTypeImpl.setDescription(description);
		}

		if (tooltip == null) {
			dataTypeImpl.setTooltip("");
		}
		else {
			dataTypeImpl.setTooltip(tooltip);
		}

		dataTypeImpl.setHasDataStructure(hasDataStructure);

		dataTypeImpl.resetOriginalValues();

		return dataTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataTypeId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		dataTypeName = objectInput.readUTF();
		dataTypeVersion = objectInput.readUTF();
		displayName = objectInput.readUTF();
		extension = objectInput.readUTF();

		sampleFileId = objectInput.readLong();
		description = objectInput.readUTF();
		tooltip = objectInput.readUTF();

		hasDataStructure = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

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

		if (dataTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeName);
		}

		if (dataTypeVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataTypeVersion);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (extension == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(extension);
		}

		objectOutput.writeLong(sampleFileId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (tooltip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tooltip);
		}

		objectOutput.writeBoolean(hasDataStructure);
	}

	public String uuid;
	public long dataTypeId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String dataTypeName;
	public String dataTypeVersion;
	public String displayName;
	public String extension;
	public long sampleFileId;
	public String description;
	public String tooltip;
	public boolean hasDataStructure;

}