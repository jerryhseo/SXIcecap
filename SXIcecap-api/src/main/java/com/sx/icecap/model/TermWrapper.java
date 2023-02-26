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
 * This class is a wrapper for {@link Term}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Term
 * @generated
 */
public class TermWrapper
	extends BaseModelWrapper<Term> implements ModelWrapper<Term>, Term {

	public TermWrapper(Term term) {
		super(term);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("termId", getTermId());
		attributes.put("groupTermId", getGroupTermId());
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
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("termName", getTermName());
		attributes.put("termVersion", getTermVersion());
		attributes.put("termType", getTermType());
		attributes.put("displayName", getDisplayName());
		attributes.put("definition", getDefinition());
		attributes.put("tooltip", getTooltip());
		attributes.put("synonyms", getSynonyms());
		attributes.put("attributesJSON", getAttributesJSON());
		attributes.put("standard", isStandard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String groupTermId = (String)attributes.get("groupTermId");

		if (groupTermId != null) {
			setGroupTermId(groupTermId);
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

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		String termName = (String)attributes.get("termName");

		if (termName != null) {
			setTermName(termName);
		}

		String termVersion = (String)attributes.get("termVersion");

		if (termVersion != null) {
			setTermVersion(termVersion);
		}

		String termType = (String)attributes.get("termType");

		if (termType != null) {
			setTermType(termType);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String definition = (String)attributes.get("definition");

		if (definition != null) {
			setDefinition(definition);
		}

		String tooltip = (String)attributes.get("tooltip");

		if (tooltip != null) {
			setTooltip(tooltip);
		}

		String synonyms = (String)attributes.get("synonyms");

		if (synonyms != null) {
			setSynonyms(synonyms);
		}

		String attributesJSON = (String)attributes.get("attributesJSON");

		if (attributesJSON != null) {
			setAttributesJSON(attributesJSON);
		}

		Boolean standard = (Boolean)attributes.get("standard");

		if (standard != null) {
			setStandard(standard);
		}
	}

	/**
	 * Returns the attributes json of this term.
	 *
	 * @return the attributes json of this term
	 */
	@Override
	public String getAttributesJSON() {
		return model.getAttributesJSON();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this term.
	 *
	 * @return the company ID of this term
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this term.
	 *
	 * @return the create date of this term
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the definition of this term.
	 *
	 * @return the definition of this term
	 */
	@Override
	public String getDefinition() {
		return model.getDefinition();
	}

	/**
	 * Returns the localized definition of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized definition of this term
	 */
	@Override
	public String getDefinition(java.util.Locale locale) {
		return model.getDefinition(locale);
	}

	/**
	 * Returns the localized definition of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDefinition(java.util.Locale locale, boolean useDefault) {
		return model.getDefinition(locale, useDefault);
	}

	/**
	 * Returns the localized definition of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized definition of this term
	 */
	@Override
	public String getDefinition(String languageId) {
		return model.getDefinition(languageId);
	}

	/**
	 * Returns the localized definition of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized definition of this term
	 */
	@Override
	public String getDefinition(String languageId, boolean useDefault) {
		return model.getDefinition(languageId, useDefault);
	}

	@Override
	public String getDefinitionCurrentLanguageId() {
		return model.getDefinitionCurrentLanguageId();
	}

	@Override
	public String getDefinitionCurrentValue() {
		return model.getDefinitionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized definitions of this term.
	 *
	 * @return the locales and localized definitions of this term
	 */
	@Override
	public Map<java.util.Locale, String> getDefinitionMap() {
		return model.getDefinitionMap();
	}

	/**
	 * Returns the display name of this term.
	 *
	 * @return the display name of this term
	 */
	@Override
	public String getDisplayName() {
		return model.getDisplayName();
	}

	/**
	 * Returns the localized display name of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this term
	 */
	@Override
	public String getDisplayName(java.util.Locale locale) {
		return model.getDisplayName(locale);
	}

	/**
	 * Returns the localized display name of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDisplayName(java.util.Locale locale, boolean useDefault) {
		return model.getDisplayName(locale, useDefault);
	}

	/**
	 * Returns the localized display name of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this term
	 */
	@Override
	public String getDisplayName(String languageId) {
		return model.getDisplayName(languageId);
	}

	/**
	 * Returns the localized display name of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this term
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
	 * Returns a map of the locales and localized display names of this term.
	 *
	 * @return the locales and localized display names of this term
	 */
	@Override
	public Map<java.util.Locale, String> getDisplayNameMap() {
		return model.getDisplayNameMap();
	}

	@Override
	public String getDisplayTitle(java.util.Locale locale) {
		return model.getDisplayTitle(locale);
	}

	/**
	 * Returns the group ID of this term.
	 *
	 * @return the group ID of this term
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the group term ID of this term.
	 *
	 * @return the group term ID of this term
	 */
	@Override
	public String getGroupTermId() {
		return model.getGroupTermId();
	}

	/**
	 * Returns the last publish date of this term.
	 *
	 * @return the last publish date of this term
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the modified date of this term.
	 *
	 * @return the modified date of this term
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this term.
	 *
	 * @return the primary key of this term
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the standard of this term.
	 *
	 * @return the standard of this term
	 */
	@Override
	public boolean getStandard() {
		return model.getStandard();
	}

	/**
	 * Returns the status of this term.
	 *
	 * @return the status of this term
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this term.
	 *
	 * @return the status by user ID of this term
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this term.
	 *
	 * @return the status by user name of this term
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this term.
	 *
	 * @return the status by user uuid of this term
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this term.
	 *
	 * @return the status date of this term
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the synonyms of this term.
	 *
	 * @return the synonyms of this term
	 */
	@Override
	public String getSynonyms() {
		return model.getSynonyms();
	}

	/**
	 * Returns the term ID of this term.
	 *
	 * @return the term ID of this term
	 */
	@Override
	public long getTermId() {
		return model.getTermId();
	}

	/**
	 * Returns the term name of this term.
	 *
	 * @return the term name of this term
	 */
	@Override
	public String getTermName() {
		return model.getTermName();
	}

	/**
	 * Returns the term type of this term.
	 *
	 * @return the term type of this term
	 */
	@Override
	public String getTermType() {
		return model.getTermType();
	}

	/**
	 * Returns the term version of this term.
	 *
	 * @return the term version of this term
	 */
	@Override
	public String getTermVersion() {
		return model.getTermVersion();
	}

	/**
	 * Returns the tooltip of this term.
	 *
	 * @return the tooltip of this term
	 */
	@Override
	public String getTooltip() {
		return model.getTooltip();
	}

	/**
	 * Returns the localized tooltip of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized tooltip of this term
	 */
	@Override
	public String getTooltip(java.util.Locale locale) {
		return model.getTooltip(locale);
	}

	/**
	 * Returns the localized tooltip of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this term. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTooltip(java.util.Locale locale, boolean useDefault) {
		return model.getTooltip(locale, useDefault);
	}

	/**
	 * Returns the localized tooltip of this term in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized tooltip of this term
	 */
	@Override
	public String getTooltip(String languageId) {
		return model.getTooltip(languageId);
	}

	/**
	 * Returns the localized tooltip of this term in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized tooltip of this term
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
	 * Returns a map of the locales and localized tooltips of this term.
	 *
	 * @return the locales and localized tooltips of this term
	 */
	@Override
	public Map<java.util.Locale, String> getTooltipMap() {
		return model.getTooltipMap();
	}

	/**
	 * Returns the trash entry created when this term was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this term.
	 *
	 * @return the trash entry created when this term was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this term.
	 *
	 * @return the class primary key of the trash entry for this term
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this term.
	 *
	 * @return the trash handler for this term
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns the user ID of this term.
	 *
	 * @return the user ID of this term
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this term.
	 *
	 * @return the user name of this term
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this term.
	 *
	 * @return the user uuid of this term
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this term.
	 *
	 * @return the uuid of this term
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this term is approved.
	 *
	 * @return <code>true</code> if this term is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this term is denied.
	 *
	 * @return <code>true</code> if this term is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this term is a draft.
	 *
	 * @return <code>true</code> if this term is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this term is expired.
	 *
	 * @return <code>true</code> if this term is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this term is inactive.
	 *
	 * @return <code>true</code> if this term is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this term is incomplete.
	 *
	 * @return <code>true</code> if this term is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this term is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this term is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this term is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this term is in the Recycle Bin; <code>false</code> otherwise
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
	 * Returns <code>true</code> if this term is pending.
	 *
	 * @return <code>true</code> if this term is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this term is scheduled.
	 *
	 * @return <code>true</code> if this term is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this term is standard.
	 *
	 * @return <code>true</code> if this term is standard; <code>false</code> otherwise
	 */
	@Override
	public boolean isStandard() {
		return model.isStandard();
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
	 * Sets the attributes json of this term.
	 *
	 * @param attributesJSON the attributes json of this term
	 */
	@Override
	public void setAttributesJSON(String attributesJSON) {
		model.setAttributesJSON(attributesJSON);
	}

	/**
	 * Sets the company ID of this term.
	 *
	 * @param companyId the company ID of this term
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this term.
	 *
	 * @param createDate the create date of this term
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the definition of this term.
	 *
	 * @param definition the definition of this term
	 */
	@Override
	public void setDefinition(String definition) {
		model.setDefinition(definition);
	}

	/**
	 * Sets the localized definition of this term in the language.
	 *
	 * @param definition the localized definition of this term
	 * @param locale the locale of the language
	 */
	@Override
	public void setDefinition(String definition, java.util.Locale locale) {
		model.setDefinition(definition, locale);
	}

	/**
	 * Sets the localized definition of this term in the language, and sets the default locale.
	 *
	 * @param definition the localized definition of this term
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefinition(
		String definition, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDefinition(definition, locale, defaultLocale);
	}

	@Override
	public void setDefinitionCurrentLanguageId(String languageId) {
		model.setDefinitionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized definitions of this term from the map of locales and localized definitions.
	 *
	 * @param definitionMap the locales and localized definitions of this term
	 */
	@Override
	public void setDefinitionMap(Map<java.util.Locale, String> definitionMap) {
		model.setDefinitionMap(definitionMap);
	}

	/**
	 * Sets the localized definitions of this term from the map of locales and localized definitions, and sets the default locale.
	 *
	 * @param definitionMap the locales and localized definitions of this term
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefinitionMap(
		Map<java.util.Locale, String> definitionMap,
		java.util.Locale defaultLocale) {

		model.setDefinitionMap(definitionMap, defaultLocale);
	}

	/**
	 * Sets the display name of this term.
	 *
	 * @param displayName the display name of this term
	 */
	@Override
	public void setDisplayName(String displayName) {
		model.setDisplayName(displayName);
	}

	/**
	 * Sets the localized display name of this term in the language.
	 *
	 * @param displayName the localized display name of this term
	 * @param locale the locale of the language
	 */
	@Override
	public void setDisplayName(String displayName, java.util.Locale locale) {
		model.setDisplayName(displayName, locale);
	}

	/**
	 * Sets the localized display name of this term in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this term
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
	 * Sets the localized display names of this term from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this term
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap) {

		model.setDisplayNameMap(displayNameMap);
	}

	/**
	 * Sets the localized display names of this term from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this term
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDisplayNameMap(
		Map<java.util.Locale, String> displayNameMap,
		java.util.Locale defaultLocale) {

		model.setDisplayNameMap(displayNameMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this term.
	 *
	 * @param groupId the group ID of this term
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the group term ID of this term.
	 *
	 * @param groupTermId the group term ID of this term
	 */
	@Override
	public void setGroupTermId(String groupTermId) {
		model.setGroupTermId(groupTermId);
	}

	/**
	 * Sets the last publish date of this term.
	 *
	 * @param lastPublishDate the last publish date of this term
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this term.
	 *
	 * @param modifiedDate the modified date of this term
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this term.
	 *
	 * @param primaryKey the primary key of this term
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this term is standard.
	 *
	 * @param standard the standard of this term
	 */
	@Override
	public void setStandard(boolean standard) {
		model.setStandard(standard);
	}

	/**
	 * Sets the status of this term.
	 *
	 * @param status the status of this term
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this term.
	 *
	 * @param statusByUserId the status by user ID of this term
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this term.
	 *
	 * @param statusByUserName the status by user name of this term
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this term.
	 *
	 * @param statusByUserUuid the status by user uuid of this term
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this term.
	 *
	 * @param statusDate the status date of this term
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the synonyms of this term.
	 *
	 * @param synonyms the synonyms of this term
	 */
	@Override
	public void setSynonyms(String synonyms) {
		model.setSynonyms(synonyms);
	}

	/**
	 * Sets the term ID of this term.
	 *
	 * @param termId the term ID of this term
	 */
	@Override
	public void setTermId(long termId) {
		model.setTermId(termId);
	}

	/**
	 * Sets the term name of this term.
	 *
	 * @param termName the term name of this term
	 */
	@Override
	public void setTermName(String termName) {
		model.setTermName(termName);
	}

	/**
	 * Sets the term type of this term.
	 *
	 * @param termType the term type of this term
	 */
	@Override
	public void setTermType(String termType) {
		model.setTermType(termType);
	}

	/**
	 * Sets the term version of this term.
	 *
	 * @param termVersion the term version of this term
	 */
	@Override
	public void setTermVersion(String termVersion) {
		model.setTermVersion(termVersion);
	}

	/**
	 * Sets the tooltip of this term.
	 *
	 * @param tooltip the tooltip of this term
	 */
	@Override
	public void setTooltip(String tooltip) {
		model.setTooltip(tooltip);
	}

	/**
	 * Sets the localized tooltip of this term in the language.
	 *
	 * @param tooltip the localized tooltip of this term
	 * @param locale the locale of the language
	 */
	@Override
	public void setTooltip(String tooltip, java.util.Locale locale) {
		model.setTooltip(tooltip, locale);
	}

	/**
	 * Sets the localized tooltip of this term in the language, and sets the default locale.
	 *
	 * @param tooltip the localized tooltip of this term
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
	 * Sets the localized tooltips of this term from the map of locales and localized tooltips.
	 *
	 * @param tooltipMap the locales and localized tooltips of this term
	 */
	@Override
	public void setTooltipMap(Map<java.util.Locale, String> tooltipMap) {
		model.setTooltipMap(tooltipMap);
	}

	/**
	 * Sets the localized tooltips of this term from the map of locales and localized tooltips, and sets the default locale.
	 *
	 * @param tooltipMap the locales and localized tooltips of this term
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTooltipMap(
		Map<java.util.Locale, String> tooltipMap,
		java.util.Locale defaultLocale) {

		model.setTooltipMap(tooltipMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this term.
	 *
	 * @param userId the user ID of this term
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this term.
	 *
	 * @param userName the user name of this term
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this term.
	 *
	 * @param userUuid the user uuid of this term
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this term.
	 *
	 * @param uuid the uuid of this term
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSONObject(
			java.util.Set<java.util.Locale> locales)
		throws com.liferay.portal.kernel.json.JSONException {

		return model.toJSONObject(locales);
	}

	@Override
	public String toJSONString(java.util.Set<java.util.Locale> locales)
		throws com.liferay.portal.kernel.json.JSONException {

		return model.toJSONString(locales);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected TermWrapper wrap(Term term) {
		return new TermWrapper(term);
	}

}