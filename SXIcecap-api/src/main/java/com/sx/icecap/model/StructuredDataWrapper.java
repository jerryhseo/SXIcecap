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

		attributes.put("uuid", getUuid());
		attributes.put("structuredDataId", getStructuredDataId());
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
		attributes.put("dataSetDisplayName", getDataSetDisplayName());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("dataTypeDisplayName", getDataTypeDisplayName());
		attributes.put("structuredData", getStructuredData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

		String dataSetDisplayName = (String)attributes.get(
			"dataSetDisplayName");

		if (dataSetDisplayName != null) {
			setDataSetDisplayName(dataSetDisplayName);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		String dataTypeDisplayName = (String)attributes.get(
			"dataTypeDisplayName");

		if (dataTypeDisplayName != null) {
			setDataTypeDisplayName(dataTypeDisplayName);
		}

		String structuredData = (String)attributes.get("structuredData");

		if (structuredData != null) {
			setStructuredData(structuredData);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
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
	 * Returns the data set display name of this structured data.
	 *
	 * @return the data set display name of this structured data
	 */
	@Override
	public String getDataSetDisplayName() {
		return model.getDataSetDisplayName();
	}

	/**
	 * Returns the localized data set display name of this structured data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data set display name of this structured data
	 */
	@Override
	public String getDataSetDisplayName(java.util.Locale locale) {
		return model.getDataSetDisplayName(locale);
	}

	/**
	 * Returns the localized data set display name of this structured data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data set display name of this structured data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataSetDisplayName(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataSetDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized data set display name of this structured data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data set display name of this structured data
	 */
	@Override
	public String getDataSetDisplayName(String languageId) {
		return model.getDataSetDisplayName(languageId);
	}

	/**
	 * Returns the localized data set display name of this structured data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data set display name of this structured data
	 */
	@Override
	public String getDataSetDisplayName(String languageId, boolean useDefault) {
		return model.getDataSetDisplayName(languageId, useDefault);
	}

	@Override
	public String getDataSetDisplayNameCurrentLanguageId() {
		return model.getDataSetDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDataSetDisplayNameCurrentValue() {
		return model.getDataSetDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data set display names of this structured data.
	 *
	 * @return the locales and localized data set display names of this structured data
	 */
	@Override
	public Map<java.util.Locale, String> getDataSetDisplayNameMap() {
		return model.getDataSetDisplayNameMap();
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
	 * Returns the data type display name of this structured data.
	 *
	 * @return the data type display name of this structured data
	 */
	@Override
	public String getDataTypeDisplayName() {
		return model.getDataTypeDisplayName();
	}

	/**
	 * Returns the localized data type display name of this structured data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized data type display name of this structured data
	 */
	@Override
	public String getDataTypeDisplayName(java.util.Locale locale) {
		return model.getDataTypeDisplayName(locale);
	}

	/**
	 * Returns the localized data type display name of this structured data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this structured data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDataTypeDisplayName(
		java.util.Locale locale, boolean useDefault) {

		return model.getDataTypeDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized data type display name of this structured data in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized data type display name of this structured data
	 */
	@Override
	public String getDataTypeDisplayName(String languageId) {
		return model.getDataTypeDisplayName(languageId);
	}

	/**
	 * Returns the localized data type display name of this structured data in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized data type display name of this structured data
	 */
	@Override
	public String getDataTypeDisplayName(
		String languageId, boolean useDefault) {

		return model.getDataTypeDisplayName(languageId, useDefault);
	}

	@Override
	public String getDataTypeDisplayNameCurrentLanguageId() {
		return model.getDataTypeDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDataTypeDisplayNameCurrentValue() {
		return model.getDataTypeDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized data type display names of this structured data.
	 *
	 * @return the locales and localized data type display names of this structured data
	 */
	@Override
	public Map<java.util.Locale, String> getDataTypeDisplayNameMap() {
		return model.getDataTypeDisplayNameMap();
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

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
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
	 * Returns the primary key of this structured data.
	 *
	 * @return the primary key of this structured data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this structured data.
	 *
	 * @return the status of this structured data
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this structured data.
	 *
	 * @return the status by user ID of this structured data
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this structured data.
	 *
	 * @return the status by user name of this structured data
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this structured data.
	 *
	 * @return the status by user uuid of this structured data
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this structured data.
	 *
	 * @return the status date of this structured data
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
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
	 * Returns the trash entry created when this structured data was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this structured data.
	 *
	 * @return the trash entry created when this structured data was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this structured data.
	 *
	 * @return the class primary key of the trash entry for this structured data
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this structured data.
	 *
	 * @return the trash handler for this structured data
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
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

	/**
	 * Returns the uuid of this structured data.
	 *
	 * @return the uuid of this structured data
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this structured data is approved.
	 *
	 * @return <code>true</code> if this structured data is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this structured data is denied.
	 *
	 * @return <code>true</code> if this structured data is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this structured data is a draft.
	 *
	 * @return <code>true</code> if this structured data is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this structured data is expired.
	 *
	 * @return <code>true</code> if this structured data is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this structured data is inactive.
	 *
	 * @return <code>true</code> if this structured data is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this structured data is incomplete.
	 *
	 * @return <code>true</code> if this structured data is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this structured data is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this structured data is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this structured data is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this structured data is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this structured data is pending.
	 *
	 * @return <code>true</code> if this structured data is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this structured data is scheduled.
	 *
	 * @return <code>true</code> if this structured data is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
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
	 * Sets the data set display name of this structured data.
	 *
	 * @param dataSetDisplayName the data set display name of this structured data
	 */
	@Override
	public void setDataSetDisplayName(String dataSetDisplayName) {
		model.setDataSetDisplayName(dataSetDisplayName);
	}

	/**
	 * Sets the localized data set display name of this structured data in the language.
	 *
	 * @param dataSetDisplayName the localized data set display name of this structured data
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataSetDisplayName(
		String dataSetDisplayName, java.util.Locale locale) {

		model.setDataSetDisplayName(dataSetDisplayName, locale);
	}

	/**
	 * Sets the localized data set display name of this structured data in the language, and sets the default locale.
	 *
	 * @param dataSetDisplayName the localized data set display name of this structured data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataSetDisplayName(
		String dataSetDisplayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataSetDisplayName(dataSetDisplayName, locale, defaultLocale);
	}

	@Override
	public void setDataSetDisplayNameCurrentLanguageId(String languageId) {
		model.setDataSetDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data set display names of this structured data from the map of locales and localized data set display names.
	 *
	 * @param dataSetDisplayNameMap the locales and localized data set display names of this structured data
	 */
	@Override
	public void setDataSetDisplayNameMap(
		Map<java.util.Locale, String> dataSetDisplayNameMap) {

		model.setDataSetDisplayNameMap(dataSetDisplayNameMap);
	}

	/**
	 * Sets the localized data set display names of this structured data from the map of locales and localized data set display names, and sets the default locale.
	 *
	 * @param dataSetDisplayNameMap the locales and localized data set display names of this structured data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataSetDisplayNameMap(
		Map<java.util.Locale, String> dataSetDisplayNameMap,
		java.util.Locale defaultLocale) {

		model.setDataSetDisplayNameMap(dataSetDisplayNameMap, defaultLocale);
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
	 * Sets the data type display name of this structured data.
	 *
	 * @param dataTypeDisplayName the data type display name of this structured data
	 */
	@Override
	public void setDataTypeDisplayName(String dataTypeDisplayName) {
		model.setDataTypeDisplayName(dataTypeDisplayName);
	}

	/**
	 * Sets the localized data type display name of this structured data in the language.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this structured data
	 * @param locale the locale of the language
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale) {

		model.setDataTypeDisplayName(dataTypeDisplayName, locale);
	}

	/**
	 * Sets the localized data type display name of this structured data in the language, and sets the default locale.
	 *
	 * @param dataTypeDisplayName the localized data type display name of this structured data
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayName(
		String dataTypeDisplayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayName(
			dataTypeDisplayName, locale, defaultLocale);
	}

	@Override
	public void setDataTypeDisplayNameCurrentLanguageId(String languageId) {
		model.setDataTypeDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized data type display names of this structured data from the map of locales and localized data type display names.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this structured data
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap);
	}

	/**
	 * Sets the localized data type display names of this structured data from the map of locales and localized data type display names, and sets the default locale.
	 *
	 * @param dataTypeDisplayNameMap the locales and localized data type display names of this structured data
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDataTypeDisplayNameMap(
		Map<java.util.Locale, String> dataTypeDisplayNameMap,
		java.util.Locale defaultLocale) {

		model.setDataTypeDisplayNameMap(dataTypeDisplayNameMap, defaultLocale);
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
	 * Sets the primary key of this structured data.
	 *
	 * @param primaryKey the primary key of this structured data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this structured data.
	 *
	 * @param status the status of this structured data
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this structured data.
	 *
	 * @param statusByUserId the status by user ID of this structured data
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this structured data.
	 *
	 * @param statusByUserName the status by user name of this structured data
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this structured data.
	 *
	 * @param statusByUserUuid the status by user uuid of this structured data
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this structured data.
	 *
	 * @param statusDate the status date of this structured data
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
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

	/**
	 * Sets the uuid of this structured data.
	 *
	 * @param uuid the uuid of this structured data
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
	protected StructuredDataWrapper wrap(StructuredData structuredData) {
		return new StructuredDataWrapper(structuredData);
	}

}