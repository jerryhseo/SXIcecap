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

import com.sx.icecap.model.DataPackEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataPackEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataPackEntryCacheModel
	implements CacheModel<DataPackEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataPackEntryCacheModel)) {
			return false;
		}

		DataPackEntryCacheModel dataPackEntryCacheModel =
			(DataPackEntryCacheModel)object;

		if (dataPackEntryId == dataPackEntryCacheModel.dataPackEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataPackEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataPackEntryId=");
		sb.append(dataPackEntryId);
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
		sb.append(", dataSetFolderId=");
		sb.append(dataSetFolderId);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
		sb.append(", entryData=");
		sb.append(entryData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataPackEntry toEntityModel() {
		DataPackEntryImpl dataPackEntryImpl = new DataPackEntryImpl();

		if (uuid == null) {
			dataPackEntryImpl.setUuid("");
		}
		else {
			dataPackEntryImpl.setUuid(uuid);
		}

		dataPackEntryImpl.setDataPackEntryId(dataPackEntryId);
		dataPackEntryImpl.setGroupId(groupId);
		dataPackEntryImpl.setCompanyId(companyId);
		dataPackEntryImpl.setUserId(userId);

		if (userName == null) {
			dataPackEntryImpl.setUserName("");
		}
		else {
			dataPackEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataPackEntryImpl.setCreateDate(null);
		}
		else {
			dataPackEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataPackEntryImpl.setModifiedDate(null);
		}
		else {
			dataPackEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dataPackEntryImpl.setStatus(status);
		dataPackEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataPackEntryImpl.setStatusByUserName("");
		}
		else {
			dataPackEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataPackEntryImpl.setStatusDate(null);
		}
		else {
			dataPackEntryImpl.setStatusDate(new Date(statusDate));
		}

		dataPackEntryImpl.setDataSetId(dataSetId);
		dataPackEntryImpl.setDataSetFolderId(dataSetFolderId);
		dataPackEntryImpl.setDataPackId(dataPackId);

		if (entryData == null) {
			dataPackEntryImpl.setEntryData("");
		}
		else {
			dataPackEntryImpl.setEntryData(entryData);
		}

		dataPackEntryImpl.resetOriginalValues();

		return dataPackEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataPackEntryId = objectInput.readLong();

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

		dataSetFolderId = objectInput.readLong();

		dataPackId = objectInput.readLong();
		entryData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataPackEntryId);

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

		objectOutput.writeLong(dataSetFolderId);

		objectOutput.writeLong(dataPackId);

		if (entryData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entryData);
		}
	}

	public String uuid;
	public long dataPackEntryId;
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
	public long dataSetFolderId;
	public long dataPackId;
	public String entryData;

}