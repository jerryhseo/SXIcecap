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

		soapModel.setStructuredDataId(model.getStructuredDataId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDataSetId(model.getDataSetId());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setStructuredData(model.getStructuredData());
		soapModel.setPatientId(model.getPatientId());
		soapModel.setCrfId(model.getCrfId());

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

	public long getDataSetId() {
		return _dataSetId;
	}

	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public String getStructuredData() {
		return _structuredData;
	}

	public void setStructuredData(String structuredData) {
		_structuredData = structuredData;
	}

	public long getPatientId() {
		return _patientId;
	}

	public void setPatientId(long patientId) {
		_patientId = patientId;
	}

	public long getCrfId() {
		return _crfId;
	}

	public void setCrfId(long crfId) {
		_crfId = crfId;
	}

	private long _structuredDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dataSetId;
	private long _dataTypeId;
	private String _structuredData;
	private long _patientId;
	private long _crfId;

}