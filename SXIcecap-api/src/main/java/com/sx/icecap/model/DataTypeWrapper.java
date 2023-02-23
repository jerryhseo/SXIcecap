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
 * This class is a wrapper for {@link DataType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataType
 * @generated
 */
public class DataTypeWrapper
	extends BaseModelWrapper<DataType>
	implements DataType, ModelWrapper<DataType> {

	public DataTypeWrapper(DataType dataType) {
		super(dataType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("dataTypeName", getDataTypeName());
		attributes.put("dataTypeVersion", getDataTypeVersion());
		attributes.put("displayName", getDisplayName());
		attributes.put("extension", getExtension());
		attributes.put("sampleFileId", getSampleFileId());
		attributes.put("description", getDescription());
		attributes.put("tooltip", getTooltip());
		attributes.put("hasDataStructure", isHasDataStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String dataTypeName = (String)attributes.get("dataTypeName");

		if (dataTypeName != null) {
			setDataTypeName(dataTypeName);
		}

		String dataTypeVersion = (String)attributes.get("dataTypeVersion");

		if (dataTypeVersion != null) {
			setDataTypeVersion(dataTypeVersion);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String extension = (String)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}

		Long sampleFileId = (Long)attributes.get("sampleFileId");

		if (sampleFileId != null) {
			setSampleFileId(sampleFileId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String tooltip = (String)attributes.get("tooltip");

		if (tooltip != null) {
			setTooltip(tooltip);
		}

		Boolean hasDataStructure = (Boolean)attributes.get("hasDataStructure");

		if (hasDataStructure != null) {
			setHasDataStructure(hasDataStructure);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this data type.
	 *
	 * @return the company ID of this data type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this data type.
	 *
	 * @return the create date of this data type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data type ID of this data type.
	 *
	 * @return the data type ID of this data type
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the data type name of this data type.
	 *
	 * @return the data type name of this data type
	 */
	@Override
	public String getDataTypeName() {
		return model.getDataTypeName();
	}

	/**
	 * Returns the data type version of this data type.
	 *
	 * @return the data type version of this data type
	 */
	@Override
	public String getDataTypeVersion() {
		return model.getDataTypeVersion();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this data type.
	 *
	 * @return the description of this data type
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this data type
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this data type
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data type
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this data type.
	 *
	 * @return the locales and localized descriptions of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the display name of this data type.
	 *
	 * @return the display name of this data type
	 */
	@Override
	public String getDisplayName() {
		return model.getDisplayName();
	}

	/**
	 * Returns the localized display name of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this data type
	 */
	@Override
	public String getDisplayName(java.util.Locale locale) {
		return model.getDisplayName(locale);
	}

	/**
	 * Returns the localized display name of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDisplayName(java.util.Locale locale, boolean useDefault) {
		return model.getDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized display name of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this data type
	 */
	@Override
	public String getDisplayName(String languageId) {
		return model.getDisplayName(languageId);
	}

	/**
	 * Returns the localized display name of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data type
	 */
	@Override
	public String getDisplayName(String languageId, boolean useDefault) {
		return model.getDisplayName(languageId, useDefault);
	}

	@Override
	public String getDisplayNameCurrentLanguageId() {
		return model.getDisplayNameCurrentLanguageId();
	}

	@Override
	public String getDisplayNameCurrentValue() {
		return model.getDisplayNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized display names of this data type.
	 *
	 * @return the locales and localized display names of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getDisplayNameMap() {
		return model.getDisplayNameMap();
	}

	/**
	 * Returns the extension of this data type.
	 *
	 * @return the extension of this data type
	 */
	@Override
	public String getExtension() {
		return model.getExtension();
	}

	/**
	 * Returns the group ID of this data type.
	 *
	 * @return the group ID of this data type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has data structure of this data type.
	 *
	 * @return the has data structure of this data type
	 */
	@Override
	public boolean getHasDataStructure() {
		return model.getHasDataStructure();
	}

	/**
	 * Returns the modified date of this data type.
	 *
	 * @return the modified date of this data type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this data type.
	 *
	 * @return the primary key of this data type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sample file ID of this data type.
	 *
	 * @return the sample file ID of this data type
	 */
	@Override
	public long getSampleFileId() {
		return model.getSampleFileId();
	}

	/**
	 * Returns the status of this data type.
	 *
	 * @return the status of this data type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this data type.
	 *
	 * @return the status by user ID of this data type
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this data type.
	 *
	 * @return the status by user name of this data type
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this data type.
	 *
	 * @return the status by user uuid of this data type
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this data type.
	 *
	 * @return the status date of this data type
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the tooltip of this data type.
	 *
	 * @return the tooltip of this data type
	 */
	@Override
	public String getTooltip() {
		return model.getTooltip();
	}

	/**
	 * Returns the localized tooltip of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized tooltip of this data type
	 */
	@Override
	public String getTooltip(java.util.Locale locale) {
		return model.getTooltip(locale);
	}

	/**
	 * Returns the localized tooltip of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTooltip(java.util.Locale locale, boolean useDefault) {
		return model.getTooltip(locale, useDefault);
	}

	/**
	 * Returns the localized tooltip of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized tooltip of this data type
	 */
	@Override
	public String getTooltip(String languageId) {
		return model.getTooltip(languageId);
	}

	/**
	 * Returns the localized tooltip of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this data type
	 */
	@Override
	public String getTooltip(String languageId, boolean useDefault) {
		return model.getTooltip(languageId, useDefault);
	}

	@Override
	public String getTooltipCurrentLanguageId() {
		return model.getTooltipCurrentLanguageId();
	}

	@Override
	public String getTooltipCurrentValue() {
		return model.getTooltipCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized tooltips of this data type.
	 *
	 * @return the locales and localized tooltips of this data type
	 */
	@Override
	public Map<java.util.Locale, String> getTooltipMap() {
		return model.getTooltipMap();
	}

	/**
	 * Returns the user ID of this data type.
	 *
	 * @return the user ID of this data type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this data type.
	 *
	 * @return the user name of this data type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this data type.
	 *
	 * @return the user uuid of this data type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this data type.
	 *
	 * @return the uuid of this data type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this data type is approved.
	 *
	 * @return <code>true</code> if this data type is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this data type is denied.
	 *
	 * @return <code>true</code> if this data type is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this data type is a draft.
	 *
	 * @return <code>true</code> if this data type is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this data type is expired.
	 *
	 * @return <code>true</code> if this data type is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this data type is has data structure.
	 *
	 * @return <code>true</code> if this data type is has data structure; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasDataStructure() {
		return model.isHasDataStructure();
	}

	/**
	 * Returns <code>true</code> if this data type is inactive.
	 *
	 * @return <code>true</code> if this data type is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this data type is incomplete.
	 *
	 * @return <code>true</code> if this data type is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this data type is pending.
	 *
	 * @return <code>true</code> if this data type is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this data type is scheduled.
	 *
	 * @return <code>true</code> if this data type is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this data type.
	 *
	 * @param companyId the company ID of this data type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this data type.
	 *
	 * @param createDate the create date of this data type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data type ID of this data type.
	 *
	 * @param dataTypeId the data type ID of this data type
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the data type name of this data type.
	 *
	 * @param dataTypeName the data type name of this data type
	 */
	@Override
	public void setDataTypeName(String dataTypeName) {
		model.setDataTypeName(dataTypeName);
	}

	/**
	 * Sets the data type version of this data type.
	 *
	 * @param dataTypeVersion the data type version of this data type
	 */
	@Override
	public void setDataTypeVersion(String dataTypeVersion) {
		model.setDataTypeVersion(dataTypeVersion);
	}

	/**
	 * Sets the description of this data type.
	 *
	 * @param description the description of this data type
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this data type in the language.
	 *
	 * @param description the localized description of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this data type in the language, and sets the default locale.
	 *
	 * @param description the localized description of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this data type from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data type
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this data type from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the display name of this data type.
	 *
	 * @param displayName the display name of this data type
	 */
	@Override
	public void setDisplayName(String displayName) {
		model.setDisplayName(displayName);
	}

	/**
	 * Sets the localized display name of this data type in the language.
	 *
	 * @param displayName the localized display name of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setDisplayName(String displayName, java.util.Locale locale) {
		model.setDisplayName(displayName, locale);
	}

	/**
	 * Sets the localized display name of this data type in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayName(
		String displayName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDisplayName(displayName, locale, defaultLocale);
	}

	@Override
	public void setDisplayNameCurrentLanguageId(String languageId) {
		model.setDisplayNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized display names of this data type from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this data type
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap) {

		model.setDisplayNameMap(displayNameMap);
	}

	/**
	 * Sets the localized display names of this data type from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap,
		java.util.Locale defaultLocale) {

		model.setDisplayNameMap(displayNameMap, defaultLocale);
	}

	/**
	 * Sets the extension of this data type.
	 *
	 * @param extension the extension of this data type
	 */
	@Override
	public void setExtension(String extension) {
		model.setExtension(extension);
	}

	/**
	 * Sets the group ID of this data type.
	 *
	 * @param groupId the group ID of this data type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this data type is has data structure.
	 *
	 * @param hasDataStructure the has data structure of this data type
	 */
	@Override
	public void setHasDataStructure(boolean hasDataStructure) {
		model.setHasDataStructure(hasDataStructure);
	}

	/**
	 * Sets the modified date of this data type.
	 *
	 * @param modifiedDate the modified date of this data type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this data type.
	 *
	 * @param primaryKey the primary key of this data type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sample file ID of this data type.
	 *
	 * @param sampleFileId the sample file ID of this data type
	 */
	@Override
	public void setSampleFileId(long sampleFileId) {
		model.setSampleFileId(sampleFileId);
	}

	/**
	 * Sets the status of this data type.
	 *
	 * @param status the status of this data type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this data type.
	 *
	 * @param statusByUserId the status by user ID of this data type
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this data type.
	 *
	 * @param statusByUserName the status by user name of this data type
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this data type.
	 *
	 * @param statusByUserUuid the status by user uuid of this data type
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this data type.
	 *
	 * @param statusDate the status date of this data type
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the tooltip of this data type.
	 *
	 * @param tooltip the tooltip of this data type
	 */
	@Override
	public void setTooltip(String tooltip) {
		model.setTooltip(tooltip);
	}

	/**
	 * Sets the localized tooltip of this data type in the language.
	 *
	 * @param tooltip the localized tooltip of this data type
	 * @param locale the locale of the language
	 */
	@Override
	public void setTooltip(String tooltip, java.util.Locale locale) {
		model.setTooltip(tooltip, locale);
	}

	/**
	 * Sets the localized tooltip of this data type in the language, and sets the default locale.
	 *
	 * @param tooltip the localized tooltip of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTooltip(
		String tooltip, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTooltip(tooltip, locale, defaultLocale);
	}

	@Override
	public void setTooltipCurrentLanguageId(String languageId) {
		model.setTooltipCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized tooltips of this data type from the map of locales and localized tooltips.
	 *
	 * @param tooltipMap the locales and localized tooltips of this data type
	 */
	@Override
	public void setTooltipMap(Map<java.util.Locale, String> tooltipMap) {
		model.setTooltipMap(tooltipMap);
	}

	/**
	 * Sets the localized tooltips of this data type from the map of locales and localized tooltips, and sets the default locale.
	 *
	 * @param tooltipMap the locales and localized tooltips of this data type
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTooltipMap(
		Map<java.util.Locale, String> tooltipMap,
		java.util.Locale defaultLocale) {

		model.setTooltipMap(tooltipMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this data type.
	 *
	 * @param userId the user ID of this data type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this data type.
	 *
	 * @param userName the user name of this data type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this data type.
	 *
	 * @param userUuid the user uuid of this data type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this data type.
	 *
	 * @param uuid the uuid of this data type
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
	protected DataTypeWrapper wrap(DataType dataType) {
		return new DataTypeWrapper(dataType);
	}

}