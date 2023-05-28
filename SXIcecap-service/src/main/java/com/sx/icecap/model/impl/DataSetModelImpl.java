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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.sx.icecap.model.DataSet;
import com.sx.icecap.model.DataSetModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DataSet service. Represents a row in the &quot;SX_ICECAP_DataSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DataSetModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataSetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataSetImpl
 * @generated
 */
public class DataSetModelImpl
	extends BaseModelImpl<DataSet> implements DataSetModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a data set model instance should use the <code>DataSet</code> interface instead.
	 */
	public static final String TABLE_NAME = "SX_ICECAP_DataSet";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"dataSetId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"lastPublishDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"dataSetName", Types.VARCHAR},
		{"dataSetVersion", Types.VARCHAR}, {"displayName", Types.VARCHAR},
		{"description", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dataSetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dataSetName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dataSetVersion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("displayName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SX_ICECAP_DataSet (uuid_ VARCHAR(75) null,dataSetId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,lastPublishDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,dataSetName VARCHAR(75) null,dataSetVersion VARCHAR(75) null,displayName STRING null,description STRING null)";

	public static final String TABLE_SQL_DROP = "drop table SX_ICECAP_DataSet";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dataSet.dataSetId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SX_ICECAP_DataSet.dataSetId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long DATASETNAME_COLUMN_BITMASK = 2L;

	public static final long DATASETVERSION_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long STATUS_COLUMN_BITMASK = 16L;

	public static final long USERID_COLUMN_BITMASK = 32L;

	public static final long UUID_COLUMN_BITMASK = 64L;

	public static final long DATASETID_COLUMN_BITMASK = 128L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public DataSetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dataSetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDataSetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dataSetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DataSet.class;
	}

	@Override
	public String getModelClassName() {
		return DataSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DataSet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DataSet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSet, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((DataSet)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DataSet, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DataSet, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DataSet)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DataSet, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DataSet, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DataSet>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DataSet.class.getClassLoader(), DataSet.class, ModelWrapper.class);

		try {
			Constructor<DataSet> constructor =
				(Constructor<DataSet>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<DataSet, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DataSet, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DataSet, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DataSet, Object>>();
		Map<String, BiConsumer<DataSet, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DataSet, ?>>();

		attributeGetterFunctions.put("uuid", DataSet::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<DataSet, String>)DataSet::setUuid);
		attributeGetterFunctions.put("dataSetId", DataSet::getDataSetId);
		attributeSetterBiConsumers.put(
			"dataSetId", (BiConsumer<DataSet, Long>)DataSet::setDataSetId);
		attributeGetterFunctions.put("companyId", DataSet::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<DataSet, Long>)DataSet::setCompanyId);
		attributeGetterFunctions.put("groupId", DataSet::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<DataSet, Long>)DataSet::setGroupId);
		attributeGetterFunctions.put("userId", DataSet::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<DataSet, Long>)DataSet::setUserId);
		attributeGetterFunctions.put("userName", DataSet::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<DataSet, String>)DataSet::setUserName);
		attributeGetterFunctions.put("createDate", DataSet::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<DataSet, Date>)DataSet::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", DataSet::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<DataSet, Date>)DataSet::setModifiedDate);
		attributeGetterFunctions.put(
			"lastPublishDate", DataSet::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<DataSet, Date>)DataSet::setLastPublishDate);
		attributeGetterFunctions.put("status", DataSet::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<DataSet, Integer>)DataSet::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", DataSet::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<DataSet, Long>)DataSet::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", DataSet::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<DataSet, String>)DataSet::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", DataSet::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<DataSet, Date>)DataSet::setStatusDate);
		attributeGetterFunctions.put("dataSetName", DataSet::getDataSetName);
		attributeSetterBiConsumers.put(
			"dataSetName",
			(BiConsumer<DataSet, String>)DataSet::setDataSetName);
		attributeGetterFunctions.put(
			"dataSetVersion", DataSet::getDataSetVersion);
		attributeSetterBiConsumers.put(
			"dataSetVersion",
			(BiConsumer<DataSet, String>)DataSet::setDataSetVersion);
		attributeGetterFunctions.put("displayName", DataSet::getDisplayName);
		attributeSetterBiConsumers.put(
			"displayName",
			(BiConsumer<DataSet, String>)DataSet::setDisplayName);
		attributeGetterFunctions.put("description", DataSet::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<DataSet, String>)DataSet::setDescription);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getDataSetId() {
		return _dataSetId;
	}

	@Override
	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public String getDataSetName() {
		if (_dataSetName == null) {
			return "";
		}
		else {
			return _dataSetName;
		}
	}

	@Override
	public void setDataSetName(String dataSetName) {
		_columnBitmask |= DATASETNAME_COLUMN_BITMASK;

		if (_originalDataSetName == null) {
			_originalDataSetName = _dataSetName;
		}

		_dataSetName = dataSetName;
	}

	public String getOriginalDataSetName() {
		return GetterUtil.getString(_originalDataSetName);
	}

	@Override
	public String getDataSetVersion() {
		if (_dataSetVersion == null) {
			return "";
		}
		else {
			return _dataSetVersion;
		}
	}

	@Override
	public void setDataSetVersion(String dataSetVersion) {
		_columnBitmask |= DATASETVERSION_COLUMN_BITMASK;

		if (_originalDataSetVersion == null) {
			_originalDataSetVersion = _dataSetVersion;
		}

		_dataSetVersion = dataSetVersion;
	}

	public String getOriginalDataSetVersion() {
		return GetterUtil.getString(_originalDataSetVersion);
	}

	@Override
	public String getDisplayName() {
		if (_displayName == null) {
			return "";
		}
		else {
			return _displayName;
		}
	}

	@Override
	public String getDisplayName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDisplayName(languageId);
	}

	@Override
	public String getDisplayName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDisplayName(languageId, useDefault);
	}

	@Override
	public String getDisplayName(String languageId) {
		return LocalizationUtil.getLocalization(getDisplayName(), languageId);
	}

	@Override
	public String getDisplayName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDisplayName(), languageId, useDefault);
	}

	@Override
	public String getDisplayNameCurrentLanguageId() {
		return _displayNameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDisplayNameCurrentValue() {
		Locale locale = getLocale(_displayNameCurrentLanguageId);

		return getDisplayName(locale);
	}

	@Override
	public Map<Locale, String> getDisplayNameMap() {
		return LocalizationUtil.getLocalizationMap(getDisplayName());
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	@Override
	public void setDisplayName(String displayName, Locale locale) {
		setDisplayName(displayName, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDisplayName(
		String displayName, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(displayName)) {
			setDisplayName(
				LocalizationUtil.updateLocalization(
					getDisplayName(), "DisplayName", displayName, languageId,
					defaultLanguageId));
		}
		else {
			setDisplayName(
				LocalizationUtil.removeLocalization(
					getDisplayName(), "DisplayName", languageId));
		}
	}

	@Override
	public void setDisplayNameCurrentLanguageId(String languageId) {
		_displayNameCurrentLanguageId = languageId;
	}

	@Override
	public void setDisplayNameMap(Map<Locale, String> displayNameMap) {
		setDisplayNameMap(displayNameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDisplayNameMap(
		Map<Locale, String> displayNameMap, Locale defaultLocale) {

		if (displayNameMap == null) {
			return;
		}

		setDisplayName(
			LocalizationUtil.updateLocalization(
				displayNameMap, getDisplayName(), "DisplayName",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(DataSet.class.getName()));
	}

	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException {

		if (!isInTrash()) {
			return null;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if (Validator.isNotNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException noSuchModelException) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler =
					com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
						getTrashHandler(
							trashHandler.getContainerModelClassName(
								containerModel.getContainerModelId()));

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(
					containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
			getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if ((trashHandler == null) ||
			Validator.isNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			return false;
		}

		try {
			ContainerModel containerModel =
				trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception exception) {
		}

		return false;
	}

	@Override
	public boolean isInTrashExplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isInTrashImplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DataSet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> displayNameMap = getDisplayNameMap();

		for (Map.Entry<Locale, String> entry : displayNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getDisplayName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			DataSet.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String displayName = getDisplayName(defaultLocale);

		if (Validator.isNull(displayName)) {
			setDisplayName(
				getDisplayName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDisplayName(
				getDisplayName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public DataSet toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DataSet>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DataSetImpl dataSetImpl = new DataSetImpl();

		dataSetImpl.setUuid(getUuid());
		dataSetImpl.setDataSetId(getDataSetId());
		dataSetImpl.setCompanyId(getCompanyId());
		dataSetImpl.setGroupId(getGroupId());
		dataSetImpl.setUserId(getUserId());
		dataSetImpl.setUserName(getUserName());
		dataSetImpl.setCreateDate(getCreateDate());
		dataSetImpl.setModifiedDate(getModifiedDate());
		dataSetImpl.setLastPublishDate(getLastPublishDate());
		dataSetImpl.setStatus(getStatus());
		dataSetImpl.setStatusByUserId(getStatusByUserId());
		dataSetImpl.setStatusByUserName(getStatusByUserName());
		dataSetImpl.setStatusDate(getStatusDate());
		dataSetImpl.setDataSetName(getDataSetName());
		dataSetImpl.setDataSetVersion(getDataSetVersion());
		dataSetImpl.setDisplayName(getDisplayName());
		dataSetImpl.setDescription(getDescription());

		dataSetImpl.resetOriginalValues();

		return dataSetImpl;
	}

	@Override
	public int compareTo(DataSet dataSet) {
		long primaryKey = dataSet.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DataSet)) {
			return false;
		}

		DataSet dataSet = (DataSet)object;

		long primaryKey = dataSet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		_originalUuid = _uuid;

		_originalCompanyId = _companyId;

		_setOriginalCompanyId = false;

		_originalGroupId = _groupId;

		_setOriginalGroupId = false;

		_originalUserId = _userId;

		_setOriginalUserId = false;

		_setModifiedDate = false;

		_originalStatus = _status;

		_setOriginalStatus = false;

		_originalDataSetName = _dataSetName;

		_originalDataSetVersion = _dataSetVersion;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<DataSet> toCacheModel() {
		DataSetCacheModel dataSetCacheModel = new DataSetCacheModel();

		dataSetCacheModel.uuid = getUuid();

		String uuid = dataSetCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dataSetCacheModel.uuid = null;
		}

		dataSetCacheModel.dataSetId = getDataSetId();

		dataSetCacheModel.companyId = getCompanyId();

		dataSetCacheModel.groupId = getGroupId();

		dataSetCacheModel.userId = getUserId();

		dataSetCacheModel.userName = getUserName();

		String userName = dataSetCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dataSetCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dataSetCacheModel.createDate = createDate.getTime();
		}
		else {
			dataSetCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dataSetCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dataSetCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			dataSetCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			dataSetCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		dataSetCacheModel.status = getStatus();

		dataSetCacheModel.statusByUserId = getStatusByUserId();

		dataSetCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = dataSetCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			dataSetCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			dataSetCacheModel.statusDate = statusDate.getTime();
		}
		else {
			dataSetCacheModel.statusDate = Long.MIN_VALUE;
		}

		dataSetCacheModel.dataSetName = getDataSetName();

		String dataSetName = dataSetCacheModel.dataSetName;

		if ((dataSetName != null) && (dataSetName.length() == 0)) {
			dataSetCacheModel.dataSetName = null;
		}

		dataSetCacheModel.dataSetVersion = getDataSetVersion();

		String dataSetVersion = dataSetCacheModel.dataSetVersion;

		if ((dataSetVersion != null) && (dataSetVersion.length() == 0)) {
			dataSetCacheModel.dataSetVersion = null;
		}

		dataSetCacheModel.displayName = getDisplayName();

		String displayName = dataSetCacheModel.displayName;

		if ((displayName != null) && (displayName.length() == 0)) {
			dataSetCacheModel.displayName = null;
		}

		dataSetCacheModel.description = getDescription();

		String description = dataSetCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			dataSetCacheModel.description = null;
		}

		return dataSetCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DataSet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DataSet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSet, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((DataSet)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<DataSet, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DataSet, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DataSet, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DataSet)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DataSet>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _dataSetId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _dataSetName;
	private String _originalDataSetName;
	private String _dataSetVersion;
	private String _originalDataSetVersion;
	private String _displayName;
	private String _displayNameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private long _columnBitmask;
	private DataSet _escapedModel;

}