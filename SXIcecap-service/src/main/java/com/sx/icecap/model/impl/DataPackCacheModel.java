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

import com.sx.icecap.model.DataPack;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataPack in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataPackCacheModel
	implements CacheModel<DataPack>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataPackCacheModel)) {
			return false;
		}

		DataPackCacheModel dataPackCacheModel = (DataPackCacheModel)object;

		if (dataPackId == dataPackCacheModel.dataPackId) {
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
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataPackId=");
		sb.append(dataPackId);
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
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
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
		sb.append(", dataPackName=");
		sb.append(dataPackName);
		sb.append(", dataPackVersion=");
		sb.append(dataPackVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataPack toEntityModel() {
		DataPackImpl dataPackImpl = new DataPackImpl();

		if (uuid == null) {
			dataPackImpl.setUuid("");
		}
		else {
			dataPackImpl.setUuid(uuid);
		}

		dataPackImpl.setDataPackId(dataPackId);
		dataPackImpl.setCompanyId(companyId);
		dataPackImpl.setGroupId(groupId);
		dataPackImpl.setUserId(userId);

		if (userName == null) {
			dataPackImpl.setUserName("");
		}
		else {
			dataPackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataPackImpl.setCreateDate(null);
		}
		else {
			dataPackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataPackImpl.setModifiedDate(null);
		}
		else {
			dataPackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataPackImpl.setLastPublishDate(null);
		}
		else {
			dataPackImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		dataPackImpl.setStatus(status);
		dataPackImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataPackImpl.setStatusByUserName("");
		}
		else {
			dataPackImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataPackImpl.setStatusDate(null);
		}
		else {
			dataPackImpl.setStatusDate(new Date(statusDate));
		}

		dataPackImpl.setDataSetId(dataSetId);
		dataPackImpl.setDataSetFolderId(dataSetFolderId);

		if (dataPackName == null) {
			dataPackImpl.setDataPackName("");
		}
		else {
			dataPackImpl.setDataPackName(dataPackName);
		}

		if (dataPackVersion == null) {
			dataPackImpl.setDataPackVersion("");
		}
		else {
			dataPackImpl.setDataPackVersion(dataPackVersion);
		}

		if (displayName == null) {
			dataPackImpl.setDisplayName("");
		}
		else {
			dataPackImpl.setDisplayName(displayName);
		}

		if (description == null) {
			dataPackImpl.setDescription("");
		}
		else {
			dataPackImpl.setDescription(description);
		}

		dataPackImpl.resetOriginalValues();

		return dataPackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataPackId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		dataSetId = objectInput.readLong();

		dataSetFolderId = objectInput.readLong();
		dataPackName = objectInput.readUTF();
		dataPackVersion = objectInput.readUTF();
		displayName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dataPackId);

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
		objectOutput.writeLong(lastPublishDate);

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

		if (dataPackName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataPackName);
		}

		if (dataPackVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataPackVersion);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long dataPackId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long dataSetId;
	public long dataSetFolderId;
	public String dataPackName;
	public String dataPackVersion;
	public String displayName;
	public String description;

}