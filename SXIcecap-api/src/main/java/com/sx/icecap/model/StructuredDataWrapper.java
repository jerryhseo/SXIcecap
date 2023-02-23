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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StructuredData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredData
 * @generated
 */
public class StructuredDataWrapper
	extends BaseModelWrapper<StructuredData>
	implements ModelWrapper<StructuredData>, StructuredData {

	public StructuredDataWrapper(StructuredData structuredData) {
		super(structuredData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("structuredDataId", getStructuredDataId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dataSetId", getDataSetId());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("structuredData", getStructuredData());
		attributes.put("patientId", getPatientId());
		attributes.put("crfId", getCrfId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long structuredDataId = (Long)attributes.get("structuredDataId");

		if (structuredDataId != null) {
			setStructuredDataId(structuredDataId);
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

		Long dataSetId = (Long)attributes.get("dataSetId");

		if (dataSetId != null) {
			setDataSetId(dataSetId);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String structuredData = (String)attributes.get("structuredData");

		if (structuredData != null) {
			setStructuredData(structuredData);
		}

		Long patientId = (Long)attributes.get("patientId");

		if (patientId != null) {
			setPatientId(patientId);
		}

		Long crfId = (Long)attributes.get("crfId");

		if (crfId != null) {
			setCrfId(crfId);
		}
	}

	/**
	 * Returns the company ID of this structured data.
	 *
	 * @return the company ID of this structured data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this structured data.
	 *
	 * @return the create date of this structured data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crf ID of this structured data.
	 *
	 * @return the crf ID of this structured data
	 */
	@Override
	public long getCrfId() {
		return model.getCrfId();
	}

	/**
	 * Returns the data set ID of this structured data.
	 *
	 * @return the data set ID of this structured data
	 */
	@Override
	public long getDataSetId() {
		return model.getDataSetId();
	}

	/**
	 * Returns the data type ID of this structured data.
	 *
	 * @return the data type ID of this structured data
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the group ID of this structured data.
	 *
	 * @return the group ID of this structured data
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this structured data.
	 *
	 * @return the modified date of this structured data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient ID of this structured data.
	 *
	 * @return the patient ID of this structured data
	 */
	@Override
	public long getPatientId() {
		return model.getPatientId();
	}

	/**
	 * Returns the primary key of this structured data.
	 *
	 * @return the primary key of this structured data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structured data of this structured data.
	 *
	 * @return the structured data of this structured data
	 */
	@Override
	public String getStructuredData() {
		return model.getStructuredData();
	}

	/**
	 * Returns the structured data ID of this structured data.
	 *
	 * @return the structured data ID of this structured data
	 */
	@Override
	public long getStructuredDataId() {
		return model.getStructuredDataId();
	}

	/**
	 * Returns the user ID of this structured data.
	 *
	 * @return the user ID of this structured data
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this structured data.
	 *
	 * @return the user name of this structured data
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this structured data.
	 *
	 * @return the user uuid of this structured data
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this structured data.
	 *
	 * @param companyId the company ID of this structured data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this structured data.
	 *
	 * @param createDate the create date of this structured data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crf ID of this structured data.
	 *
	 * @param crfId the crf ID of this structured data
	 */
	@Override
	public void setCrfId(long crfId) {
		model.setCrfId(crfId);
	}

	/**
	 * Sets the data set ID of this structured data.
	 *
	 * @param dataSetId the data set ID of this structured data
	 */
	@Override
	public void setDataSetId(long dataSetId) {
		model.setDataSetId(dataSetId);
	}

	/**
	 * Sets the data type ID of this structured data.
	 *
	 * @param dataTypeId the data type ID of this structured data
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the group ID of this structured data.
	 *
	 * @param groupId the group ID of this structured data
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this structured data.
	 *
	 * @param modifiedDate the modified date of this structured data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient ID of this structured data.
	 *
	 * @param patientId the patient ID of this structured data
	 */
	@Override
	public void setPatientId(long patientId) {
		model.setPatientId(patientId);
	}

	/**
	 * Sets the primary key of this structured data.
	 *
	 * @param primaryKey the primary key of this structured data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structured data of this structured data.
	 *
	 * @param structuredData the structured data of this structured data
	 */
	@Override
	public void setStructuredData(String structuredData) {
		model.setStructuredData(structuredData);
	}

	/**
	 * Sets the structured data ID of this structured data.
	 *
	 * @param structuredDataId the structured data ID of this structured data
	 */
	@Override
	public void setStructuredDataId(long structuredDataId) {
		model.setStructuredDataId(structuredDataId);
	}

	/**
	 * Sets the user ID of this structured data.
	 *
	 * @param userId the user ID of this structured data
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this structured data.
	 *
	 * @param userName the user name of this structured data
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this structured data.
	 *
	 * @param userUuid the user uuid of this structured data
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected StructuredDataWrapper wrap(StructuredData structuredData) {
		return new StructuredDataWrapper(structuredData);
	}

}