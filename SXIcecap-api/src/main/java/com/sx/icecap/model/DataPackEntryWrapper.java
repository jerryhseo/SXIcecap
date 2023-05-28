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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DataPackEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPackEntry
 * @generated
 */
public class DataPackEntryWrapper
	extends BaseModelWrapper<DataPackEntry>
	implements DataPackEntry, ModelWrapper<DataPackEntry> {

	public DataPackEntryWrapper(DataPackEntry dataPackEntry) {
		super(dataPackEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataPackEntryId", getDataPackEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataSetFolderId", getDataSetFolderId());
		attributes.put("dataPackId", getDataPackId());
		attributes.put("entryData", getEntryData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dataPackEntryId = (Long)attributes.get("dataPackEntryId");

		if (dataPackEntryId != null) {
			setDataPackEntryId(dataPackEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataSetFolderId = (Long)attributes.get("dataSetFolderId");

		if (dataSetFolderId != null) {
			setDataSetFolderId(dataSetFolderId);
		}

		Long dataPackId = (Long)attributes.get("dataPackId");

		if (dataPackId != null) {
			setDataPackId(dataPackId);
		}

		String entryData = (String)attributes.get("entryData");

		if (entryData != null) {
			setEntryData(entryData);
		}
	}

	/**
	 * Returns the company ID of this data pack entry.
	 *
	 * @return the company ID of this data pack entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this data pack entry.
	 *
	 * @return the create date of this data pack entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data pack entry ID of this data pack entry.
	 *
	 * @return the data pack entry ID of this data pack entry
	 */
	@Override
	public long getDataPackEntryId() {
		return model.getDataPackEntryId();
	}

	/**
	 * Returns the data pack ID of this data pack entry.
	 *
	 * @return the data pack ID of this data pack entry
	 */
	@Override
	public long getDataPackId() {
		return model.getDataPackId();
	}

	/**
	 * Returns the data set folder ID of this data pack entry.
	 *
	 * @return the data set folder ID of this data pack entry
	 */
	@Override
	public long getDataSetFolderId() {
		return model.getDataSetFolderId();
	}

	/**
	 * Returns the data set ID of this data pack entry.
	 *
	 * @return the data set ID of this data pack entry
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the entry data of this data pack entry.
	 *
	 * @return the entry data of this data pack entry
	 */
	@Override
	public String getEntryData() {
		return model.getEntryData();
	}

	/**
	 * Returns the group ID of this data pack entry.
	 *
	 * @return the group ID of this data pack entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this data pack entry.
	 *
	 * @return the modified date of this data pack entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this data pack entry.
	 *
	 * @return the primary key of this data pack entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this data pack entry.
	 *
	 * @return the status of this data pack entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data pack entry.
	 *
	 * @return the status by user ID of this data pack entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data pack entry.
	 *
	 * @return the status by user name of this data pack entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data pack entry.
	 *
	 * @return the status by user uuid of this data pack entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data pack entry.
	 *
	 * @return the status date of this data pack entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the trash entry created when this data pack entry was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this data pack entry.
	 *
	 * @return the trash entry created when this data pack entry was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this data pack entry.
	 *
	 * @return the class primary key of the trash entry for this data pack entry
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this data pack entry.
	 *
	 * @return the trash handler for this data pack entry
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this data pack entry.
	 *
	 * @return the user ID of this data pack entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data pack entry.
	 *
	 * @return the user name of this data pack entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data pack entry.
	 *
	 * @return the user uuid of this data pack entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data pack entry.
	 *
	 * @return the uuid of this data pack entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is approved.
	 *
	 * @return <code>true</code> if this data pack entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is denied.
	 *
	 * @return <code>true</code> if this data pack entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is a draft.
	 *
	 * @return <code>true</code> if this data pack entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is expired.
	 *
	 * @return <code>true</code> if this data pack entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is inactive.
	 *
	 * @return <code>true</code> if this data pack entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is incomplete.
	 *
	 * @return <code>true</code> if this data pack entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this data pack entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this data pack entry is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this data pack entry is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is pending.
	 *
	 * @return <code>true</code> if this data pack entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data pack entry is scheduled.
	 *
	 * @return <code>true</code> if this data pack entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this data pack entry.
	 *
	 * @param companyId the company ID of this data pack entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this data pack entry.
	 *
	 * @param createDate the create date of this data pack entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data pack entry ID of this data pack entry.
	 *
	 * @param dataPackEntryId the data pack entry ID of this data pack entry
	 */
	@Override
	public void setDataPackEntryId(long dataPackEntryId) {
		model.setDataPackEntryId(dataPackEntryId);
	}

	/**
	 * Sets the data pack ID of this data pack entry.
	 *
	 * @param dataPackId the data pack ID of this data pack entry
	 */
	@Override
	public void setDataPackId(long dataPackId) {
		model.setDataPackId(dataPackId);
	}

	/**
	 * Sets the data set folder ID of this data pack entry.
	 *
	 * @param dataSetFolderId the data set folder ID of this data pack entry
	 */
	@Override
	public void setDataSetFolderId(long dataSetFolderId) {
		model.setDataSetFolderId(dataSetFolderId);
	}

	/**
	 * Sets the data set ID of this data pack entry.
	 *
	 * @param dataSetId the data set ID of this data pack entry
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the entry data of this data pack entry.
	 *
	 * @param entryData the entry data of this data pack entry
	 */
	@Override
	public void setEntryData(String entryData) {
		model.setEntryData(entryData);
	}

	/**
	 * Sets the group ID of this data pack entry.
	 *
	 * @param groupId the group ID of this data pack entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this data pack entry.
	 *
	 * @param modifiedDate the modified date of this data pack entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this data pack entry.
	 *
	 * @param primaryKey the primary key of this data pack entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this data pack entry.
	 *
	 * @param status the status of this data pack entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data pack entry.
	 *
	 * @param statusByUserId the status by user ID of this data pack entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data pack entry.
	 *
	 * @param statusByUserName the status by user name of this data pack entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data pack entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this data pack entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data pack entry.
	 *
	 * @param statusDate the status date of this data pack entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this data pack entry.
	 *
	 * @param userId the user ID of this data pack entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data pack entry.
	 *
	 * @param userName the user name of this data pack entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data pack entry.
	 *
	 * @param userUuid the user uuid of this data pack entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data pack entry.
	 *
	 * @param uuid the uuid of this data pack entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected DataPackEntryWrapper wrap(DataPackEntry dataPackEntry) {
		return new DataPackEntryWrapper(dataPackEntry);
	}

}