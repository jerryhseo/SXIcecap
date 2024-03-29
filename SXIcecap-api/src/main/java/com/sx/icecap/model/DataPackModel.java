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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DataPack service. Represents a row in the &quot;SX_ICECAP_DataPack&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sx.icecap.model.impl.DataPackModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sx.icecap.model.impl.DataPackImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataPack
 * @generated
 */
@ProviderType
public interface DataPackModel
	extends BaseModel<DataPack>, LocalizedModel, ShardedModel,
			StagedGroupedModel, TrashedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data pack model instance should use the {@link DataPack} interface instead.
	 */

	/**
	 * Returns the primary key of this data pack.
	 *
	 * @return the primary key of this data pack
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this data pack.
	 *
	 * @param primaryKey the primary key of this data pack
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this data pack.
	 *
	 * @return the uuid of this data pack
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this data pack.
	 *
	 * @param uuid the uuid of this data pack
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the data pack ID of this data pack.
	 *
	 * @return the data pack ID of this data pack
	 */
	public long getDataPackId();

	/**
	 * Sets the data pack ID of this data pack.
	 *
	 * @param dataPackId the data pack ID of this data pack
	 */
	public void setDataPackId(long dataPackId);

	/**
	 * Returns the company ID of this data pack.
	 *
	 * @return the company ID of this data pack
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this data pack.
	 *
	 * @param companyId the company ID of this data pack
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this data pack.
	 *
	 * @return the group ID of this data pack
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this data pack.
	 *
	 * @param groupId the group ID of this data pack
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this data pack.
	 *
	 * @return the user ID of this data pack
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this data pack.
	 *
	 * @param userId the user ID of this data pack
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this data pack.
	 *
	 * @return the user uuid of this data pack
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this data pack.
	 *
	 * @param userUuid the user uuid of this data pack
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this data pack.
	 *
	 * @return the user name of this data pack
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this data pack.
	 *
	 * @param userName the user name of this data pack
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this data pack.
	 *
	 * @return the create date of this data pack
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this data pack.
	 *
	 * @param createDate the create date of this data pack
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this data pack.
	 *
	 * @return the modified date of this data pack
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this data pack.
	 *
	 * @param modifiedDate the modified date of this data pack
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this data pack.
	 *
	 * @return the last publish date of this data pack
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this data pack.
	 *
	 * @param lastPublishDate the last publish date of this data pack
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this data pack.
	 *
	 * @return the status of this data pack
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this data pack.
	 *
	 * @param status the status of this data pack
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this data pack.
	 *
	 * @return the status by user ID of this data pack
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this data pack.
	 *
	 * @param statusByUserId the status by user ID of this data pack
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this data pack.
	 *
	 * @return the status by user uuid of this data pack
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this data pack.
	 *
	 * @param statusByUserUuid the status by user uuid of this data pack
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this data pack.
	 *
	 * @return the status by user name of this data pack
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this data pack.
	 *
	 * @param statusByUserName the status by user name of this data pack
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this data pack.
	 *
	 * @return the status date of this data pack
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this data pack.
	 *
	 * @param statusDate the status date of this data pack
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the data set ID of this data pack.
	 *
	 * @return the data set ID of this data pack
	 */
	public long getDataSetId();

	/**
	 * Sets the data set ID of this data pack.
	 *
	 * @param dataSetId the data set ID of this data pack
	 */
	public void setDataSetId(long dataSetId);

	/**
	 * Returns the data set folder ID of this data pack.
	 *
	 * @return the data set folder ID of this data pack
	 */
	public long getDataSetFolderId();

	/**
	 * Sets the data set folder ID of this data pack.
	 *
	 * @param dataSetFolderId the data set folder ID of this data pack
	 */
	public void setDataSetFolderId(long dataSetFolderId);

	/**
	 * Returns the data pack name of this data pack.
	 *
	 * @return the data pack name of this data pack
	 */
	@AutoEscape
	public String getDataPackName();

	/**
	 * Sets the data pack name of this data pack.
	 *
	 * @param dataPackName the data pack name of this data pack
	 */
	public void setDataPackName(String dataPackName);

	/**
	 * Returns the data pack version of this data pack.
	 *
	 * @return the data pack version of this data pack
	 */
	@AutoEscape
	public String getDataPackVersion();

	/**
	 * Sets the data pack version of this data pack.
	 *
	 * @param dataPackVersion the data pack version of this data pack
	 */
	public void setDataPackVersion(String dataPackVersion);

	/**
	 * Returns the display name of this data pack.
	 *
	 * @return the display name of this data pack
	 */
	public String getDisplayName();

	/**
	 * Returns the localized display name of this data pack in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized display name of this data pack
	 */
	@AutoEscape
	public String getDisplayName(Locale locale);

	/**
	 * Returns the localized display name of this data pack in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data pack. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDisplayName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized display name of this data pack in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized display name of this data pack
	 */
	@AutoEscape
	public String getDisplayName(String languageId);

	/**
	 * Returns the localized display name of this data pack in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized display name of this data pack
	 */
	@AutoEscape
	public String getDisplayName(String languageId, boolean useDefault);

	@AutoEscape
	public String getDisplayNameCurrentLanguageId();

	@AutoEscape
	public String getDisplayNameCurrentValue();

	/**
	 * Returns a map of the locales and localized display names of this data pack.
	 *
	 * @return the locales and localized display names of this data pack
	 */
	public Map<Locale, String> getDisplayNameMap();

	/**
	 * Sets the display name of this data pack.
	 *
	 * @param displayName the display name of this data pack
	 */
	public void setDisplayName(String displayName);

	/**
	 * Sets the localized display name of this data pack in the language.
	 *
	 * @param displayName the localized display name of this data pack
	 * @param locale the locale of the language
	 */
	public void setDisplayName(String displayName, Locale locale);

	/**
	 * Sets the localized display name of this data pack in the language, and sets the default locale.
	 *
	 * @param displayName the localized display name of this data pack
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDisplayName(
		String displayName, Locale locale, Locale defaultLocale);

	public void setDisplayNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized display names of this data pack from the map of locales and localized display names.
	 *
	 * @param displayNameMap the locales and localized display names of this data pack
	 */
	public void setDisplayNameMap(Map<Locale, String> displayNameMap);

	/**
	 * Sets the localized display names of this data pack from the map of locales and localized display names, and sets the default locale.
	 *
	 * @param displayNameMap the locales and localized display names of this data pack
	 * @param defaultLocale the default locale
	 */
	public void setDisplayNameMap(
		Map<Locale, String> displayNameMap, Locale defaultLocale);

	/**
	 * Returns the description of this data pack.
	 *
	 * @return the description of this data pack
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this data pack in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this data pack
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this data pack in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data pack. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this data pack in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this data pack
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this data pack in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data pack
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this data pack.
	 *
	 * @return the locales and localized descriptions of this data pack
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this data pack.
	 *
	 * @param description the description of this data pack
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this data pack in the language.
	 *
	 * @param description the localized description of this data pack
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this data pack in the language, and sets the default locale.
	 *
	 * @param description the localized description of this data pack
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this data pack from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data pack
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this data pack from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data pack
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the trash entry created when this data pack was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this data pack.
	 *
	 * @return the trash entry created when this data pack was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException;

	/**
	 * Returns the class primary key of the trash entry for this data pack.
	 *
	 * @return the class primary key of the trash entry for this data pack
	 */
	@Override
	public long getTrashEntryClassPK();

	/**
	 * Returns the trash handler for this data pack.
	 *
	 * @return the trash handler for this data pack
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler();

	/**
	 * Returns <code>true</code> if this data pack is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this data pack is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash();

	/**
	 * Returns <code>true</code> if the parent of this data pack is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this data pack is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer();

	@Override
	public boolean isInTrashExplicitly();

	@Override
	public boolean isInTrashImplicitly();

	/**
	 * Returns <code>true</code> if this data pack is approved.
	 *
	 * @return <code>true</code> if this data pack is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this data pack is denied.
	 *
	 * @return <code>true</code> if this data pack is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this data pack is a draft.
	 *
	 * @return <code>true</code> if this data pack is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this data pack is expired.
	 *
	 * @return <code>true</code> if this data pack is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this data pack is inactive.
	 *
	 * @return <code>true</code> if this data pack is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this data pack is incomplete.
	 *
	 * @return <code>true</code> if this data pack is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this data pack is pending.
	 *
	 * @return <code>true</code> if this data pack is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this data pack is scheduled.
	 *
	 * @return <code>true</code> if this data pack is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}