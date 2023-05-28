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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StructuredDataSoap implements Serializable {

	public static StructuredDataSoap toSoapModel(StructuredData model) {
		StructuredDataSoap soapModel = new StructuredDataSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStructuredDataId(model.getStructuredDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataSetDisplayName(model.getDataSetDisplayName());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setDataTypeDisplayName(model.getDataTypeDisplayName());
		soapModel.setDataSetFolderId(model.getDataSetFolderId());
		soapModel.setDataSetFolderName(model.getDataSetFolderName());
		soapModel.setDataPackId(model.getDataPackId());
		soapModel.setDataPackDisplayName(model.getDataPackDisplayName());
		soapModel.setRecordType(model.getRecordType());
		soapModel.setRecordDelimiter(model.getRecordDelimiter());
		soapModel.setRecordFormat(model.getRecordFormat());
		soapModel.setEntryCount(model.getEntryCount());
		soapModel.setStartEntryNo(model.getStartEntryNo());
		soapModel.setEndEntryNo(model.getEndEntryNo());
		soapModel.setStructuredData(model.getStructuredData());

		return soapModel;
	}

	public static StructuredDataSoap[] toSoapModels(StructuredData[] models) {
		StructuredDataSoap[] soapModels = new StructuredDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StructuredDataSoap[][] toSoapModels(
		StructuredData[][] models) {

		StructuredDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StructuredDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StructuredDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StructuredDataSoap[] toSoapModels(
		List<StructuredData> models) {

		List<StructuredDataSoap> soapModels = new ArrayList<StructuredDataSoap>(
			models.size());

		for (StructuredData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StructuredDataSoap[soapModels.size()]);
	}

	public StructuredDataSoap() {
	}

	public long getPrimaryKey() {
		return _structuredDataId;
	}

	public void setPrimaryKey(long pk) {
		setStructuredDataId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStructuredDataId() {
		return _structuredDataId;
	}

	public void setStructuredDataId(long structuredDataId) {
		_structuredDataId = structuredDataId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public String getDataSetDisplayName() {
		return _dataSetDisplayName;
	}

	public void setDataSetDisplayName(String dataSetDisplayName) {
		_dataSetDisplayName = dataSetDisplayName;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getDataTypeDisplayName() {
		return _dataTypeDisplayName;
	}

	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		_dataTypeDisplayName = dataTypeDisplayName;
	}

	public long getDataSetFolderId() {
		return _dataSetFolderId;
	}

	public void setDataSetFolderId(long dataSetFolderId) {
		_dataSetFolderId = dataSetFolderId;
	}

	public String getDataSetFolderName() {
		return _dataSetFolderName;
	}

	public void setDataSetFolderName(String dataSetFolderName) {
		_dataSetFolderName = dataSetFolderName;
	}

	public long getDataPackId() {
		return _dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	public String getDataPackDisplayName() {
		return _dataPackDisplayName;
	}

	public void setDataPackDisplayName(String dataPackDisplayName) {
		_dataPackDisplayName = dataPackDisplayName;
	}

	public String getRecordType() {
		return _recordType;
	}

	public void setRecordType(String recordType) {
		_recordType = recordType;
	}

	public String getRecordDelimiter() {
		return _recordDelimiter;
	}

	public void setRecordDelimiter(String recordDelimiter) {
		_recordDelimiter = recordDelimiter;
	}

	public String getRecordFormat() {
		return _recordFormat;
	}

	public void setRecordFormat(String recordFormat) {
		_recordFormat = recordFormat;
	}

	public int getEntryCount() {
		return _entryCount;
	}

	public void setEntryCount(int entryCount) {
		_entryCount = entryCount;
	}

	public int getStartEntryNo() {
		return _startEntryNo;
	}

	public void setStartEntryNo(int startEntryNo) {
		_startEntryNo = startEntryNo;
	}

	public int getEndEntryNo() {
		return _endEntryNo;
	}

	public void setEndEntryNo(int endEntryNo) {
		_endEntryNo = endEntryNo;
	}

	public String getStructuredData() {
		return _structuredData;
	}

	public void setStructuredData(String structuredData) {
		_structuredData = structuredData;
	}

	private String _uuid;
	private long _structuredDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _dataSetId;
	private String _dataSetDisplayName;
	private long _dataTypeId;
	private String _dataTypeDisplayName;
	private long _dataSetFolderId;
	private String _dataSetFolderName;
	private long _dataPackId;
	private String _dataPackDisplayName;
	private String _recordType;
	private String _recordDelimiter;
	private String _recordFormat;
	private int _entryCount;
	private int _startEntryNo;
	private int _endEntryNo;
	private String _structuredData;

}