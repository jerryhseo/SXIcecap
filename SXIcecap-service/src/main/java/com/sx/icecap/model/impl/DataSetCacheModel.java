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

import com.sx.icecap.model.DataSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DataSet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataSetCacheModel implements CacheModel<DataSet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataSetCacheModel)) {
			return false;
		}

		DataSetCacheModel dataSetCacheModel = (DataSetCacheModel)object;

		if (dataSetId == dataSetCacheModel.dataSetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dataSetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", dataSetId=");
		sb.append(dataSetId);
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
		sb.append(", dataSetName=");
		sb.append(dataSetName);
		sb.append(", dataSetVersion=");
		sb.append(dataSetVersion);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DataSet toEntityModel() {
		DataSetImpl dataSetImpl = new DataSetImpl();

		if (uuid == null) {
			dataSetImpl.setUuid("");
		}
		else {
			dataSetImpl.setUuid(uuid);
		}

		dataSetImpl.setDataSetId(dataSetId);
		dataSetImpl.setCompanyId(companyId);
		dataSetImpl.setGroupId(groupId);
		dataSetImpl.setUserId(userId);

		if (userName == null) {
			dataSetImpl.setUserName("");
		}
		else {
			dataSetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dataSetImpl.setCreateDate(null);
		}
		else {
			dataSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dataSetImpl.setModifiedDate(null);
		}
		else {
			dataSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			dataSetImpl.setLastPublishDate(null);
		}
		else {
			dataSetImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		dataSetImpl.setStatus(status);
		dataSetImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			dataSetImpl.setStatusByUserName("");
		}
		else {
			dataSetImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			dataSetImpl.setStatusDate(null);
		}
		else {
			dataSetImpl.setStatusDate(new Date(statusDate));
		}

		if (dataSetName == null) {
			dataSetImpl.setDataSetName("");
		}
		else {
			dataSetImpl.setDataSetName(dataSetName);
		}

		if (dataSetVersion == null) {
			dataSetImpl.setDataSetVersion("");
		}
		else {
			dataSetImpl.setDataSetVersion(dataSetVersion);
		}

		if (displayName == null) {
			dataSetImpl.setDisplayName("");
		}
		else {
			dataSetImpl.setDisplayName(displayName);
		}

		if (description == null) {
			dataSetImpl.setDescription("");
		}
		else {
			dataSetImpl.setDescription(description);
		}

		dataSetImpl.resetOriginalValues();

		return dataSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		dataSetId = objectInput.readLong();

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
		dataSetName = objectInput.readUTF();
		dataSetVersion = objectInput.readUTF();
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

		objectOutput.writeLong(dataSetId);

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

		if (dataSetName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataSetName);
		}

		if (dataSetVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dataSetVersion);
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
	public long dataSetId;
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
	public String dataSetName;
	public String dataSetVersion;
	public String displayName;
	public String description;

}