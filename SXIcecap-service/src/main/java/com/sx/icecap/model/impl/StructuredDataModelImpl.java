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
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sx.icecap.model.StructuredData;
import com.sx.icecap.model.StructuredDataModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the StructuredData service. Represents a row in the &quot;SX_ICECAP_StructuredData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StructuredDataModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StructuredDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StructuredDataImpl
 * @generated
 */
public class StructuredDataModelImpl
	extends BaseModelImpl<StructuredData> implements StructuredDataModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a structured data model instance should use the <code>StructuredData</code> interface instead.
	 */
	public static final String TABLE_NAME = "SX_ICECAP_StructuredData";

	public static final Object[][] TABLE_COLUMNS = {
		{"structuredDataId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"dataSetId", Types.BIGINT},
		{"dataTypeId", Types.BIGINT}, {"structuredData", Types.VARCHAR},
		{"patientId", Types.BIGINT}, {"crfId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("structuredDataId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dataSetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("structuredData", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("crfId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SX_ICECAP_StructuredData (structuredDataId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dataSetId LONG,dataTypeId LONG,structuredData VARCHAR(75) null,patientId LONG,crfId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table SX_ICECAP_StructuredData";

	public static final String ORDER_BY_JPQL =
		" ORDER BY structuredData.structuredDataId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SX_ICECAP_StructuredData.structuredDataId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CRFID_COLUMN_BITMASK = 1L;

	public static final long PATIENTID_COLUMN_BITMASK = 2L;

	public static final long STRUCTUREDDATAID_COLUMN_BITMASK = 4L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public StructuredDataModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _structuredDataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStructuredDataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _structuredDataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StructuredData.class;
	}

	@Override
	public String getModelClassName() {
		return StructuredData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StructuredData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StructuredData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StructuredData, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StructuredData)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StructuredData, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StructuredData, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StructuredData)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StructuredData, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StructuredData, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StructuredData>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StructuredData.class.getClassLoader(), StructuredData.class,
			ModelWrapper.class);

		try {
			Constructor<StructuredData> constructor =
				(Constructor<StructuredData>)proxyClass.getConstructor(
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

	private static final Map<String, Function<StructuredData, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<StructuredData, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<StructuredData, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<StructuredData, Object>>();
		Map<String, BiConsumer<StructuredData, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<StructuredData, ?>>();

		attributeGetterFunctions.put(
			"structuredDataId", StructuredData::getStructuredDataId);
		attributeSetterBiConsumers.put(
			"structuredDataId",
			(BiConsumer<StructuredData, Long>)
				StructuredData::setStructuredDataId);
		attributeGetterFunctions.put("groupId", StructuredData::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<StructuredData, Long>)StructuredData::setGroupId);
		attributeGetterFunctions.put("companyId", StructuredData::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<StructuredData, Long>)StructuredData::setCompanyId);
		attributeGetterFunctions.put("userId", StructuredData::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<StructuredData, Long>)StructuredData::setUserId);
		attributeGetterFunctions.put("userName", StructuredData::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<StructuredData, String>)StructuredData::setUserName);
		attributeGetterFunctions.put(
			"createDate", StructuredData::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<StructuredData, Date>)StructuredData::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", StructuredData::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<StructuredData, Date>)StructuredData::setModifiedDate);
		attributeGetterFunctions.put("dataSetId", StructuredData::getDataSetId);
		attributeSetterBiConsumers.put(
			"dataSetId",
			(BiConsumer<StructuredData, Long>)StructuredData::setDataSetId);
		attributeGetterFunctions.put(
			"dataTypeId", StructuredData::getDataTypeId);
		attributeSetterBiConsumers.put(
			"dataTypeId",
			(BiConsumer<StructuredData, Long>)StructuredData::setDataTypeId);
		attributeGetterFunctions.put(
			"structuredData", StructuredData::getStructuredData);
		attributeSetterBiConsumers.put(
			"structuredData",
			(BiConsumer<StructuredData, String>)
				StructuredData::setStructuredData);
		attributeGetterFunctions.put("patientId", StructuredData::getPatientId);
		attributeSetterBiConsumers.put(
			"patientId",
			(BiConsumer<StructuredData, Long>)StructuredData::setPatientId);
		attributeGetterFunctions.put("crfId", StructuredData::getCrfId);
		attributeSetterBiConsumers.put(
			"crfId",
			(BiConsumer<StructuredData, Long>)StructuredData::setCrfId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStructuredDataId() {
		return _structuredDataId;
	}

	@Override
	public void setStructuredDataId(long structuredDataId) {
		_structuredDataId = structuredDataId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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
	public long getDataSetId() {
		return _dataSetId;
	}

	@Override
	public void setDataSetId(long dataSetId) {
		_dataSetId = dataSetId;
	}

	@Override
	public long getDataTypeId() {
		return _dataTypeId;
	}

	@Override
	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	@Override
	public String getStructuredData() {
		if (_structuredData == null) {
			return "";
		}
		else {
			return _structuredData;
		}
	}

	@Override
	public void setStructuredData(String structuredData) {
		_structuredData = structuredData;
	}

	@Override
	public long getPatientId() {
		return _patientId;
	}

	@Override
	public void setPatientId(long patientId) {
		_columnBitmask |= PATIENTID_COLUMN_BITMASK;

		if (!_setOriginalPatientId) {
			_setOriginalPatientId = true;

			_originalPatientId = _patientId;
		}

		_patientId = patientId;
	}

	public long getOriginalPatientId() {
		return _originalPatientId;
	}

	@Override
	public long getCrfId() {
		return _crfId;
	}

	@Override
	public void setCrfId(long crfId) {
		_columnBitmask |= CRFID_COLUMN_BITMASK;

		if (!_setOriginalCrfId) {
			_setOriginalCrfId = true;

			_originalCrfId = _crfId;
		}

		_crfId = crfId;
	}

	public long getOriginalCrfId() {
		return _originalCrfId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), StructuredData.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StructuredData toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StructuredData>
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
		StructuredDataImpl structuredDataImpl = new StructuredDataImpl();

		structuredDataImpl.setStructuredDataId(getStructuredDataId());
		structuredDataImpl.setGroupId(getGroupId());
		structuredDataImpl.setCompanyId(getCompanyId());
		structuredDataImpl.setUserId(getUserId());
		structuredDataImpl.setUserName(getUserName());
		structuredDataImpl.setCreateDate(getCreateDate());
		structuredDataImpl.setModifiedDate(getModifiedDate());
		structuredDataImpl.setDataSetId(getDataSetId());
		structuredDataImpl.setDataTypeId(getDataTypeId());
		structuredDataImpl.setStructuredData(getStructuredData());
		structuredDataImpl.setPatientId(getPatientId());
		structuredDataImpl.setCrfId(getCrfId());

		structuredDataImpl.resetOriginalValues();

		return structuredDataImpl;
	}

	@Override
	public int compareTo(StructuredData structuredData) {
		long primaryKey = structuredData.getPrimaryKey();

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

		if (!(object instanceof StructuredData)) {
			return false;
		}

		StructuredData structuredData = (StructuredData)object;

		long primaryKey = structuredData.getPrimaryKey();

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
		_setModifiedDate = false;

		_originalPatientId = _patientId;

		_setOriginalPatientId = false;

		_originalCrfId = _crfId;

		_setOriginalCrfId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<StructuredData> toCacheModel() {
		StructuredDataCacheModel structuredDataCacheModel =
			new StructuredDataCacheModel();

		structuredDataCacheModel.structuredDataId = getStructuredDataId();

		structuredDataCacheModel.groupId = getGroupId();

		structuredDataCacheModel.companyId = getCompanyId();

		structuredDataCacheModel.userId = getUserId();

		structuredDataCacheModel.userName = getUserName();

		String userName = structuredDataCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			structuredDataCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			structuredDataCacheModel.createDate = createDate.getTime();
		}
		else {
			structuredDataCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			structuredDataCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			structuredDataCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		structuredDataCacheModel.dataSetId = getDataSetId();

		structuredDataCacheModel.dataTypeId = getDataTypeId();

		structuredDataCacheModel.structuredData = getStructuredData();

		String structuredData = structuredDataCacheModel.structuredData;

		if ((structuredData != null) && (structuredData.length() == 0)) {
			structuredDataCacheModel.structuredData = null;
		}

		structuredDataCacheModel.patientId = getPatientId();

		structuredDataCacheModel.crfId = getCrfId();

		return structuredDataCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StructuredData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StructuredData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StructuredData, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((StructuredData)this);

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
		Map<String, Function<StructuredData, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StructuredData, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StructuredData, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StructuredData)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StructuredData>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _structuredDataId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _dataSetId;
	private long _dataTypeId;
	private String _structuredData;
	private long _patientId;
	private long _originalPatientId;
	private boolean _setOriginalPatientId;
	private long _crfId;
	private long _originalCrfId;
	private boolean _setOriginalCrfId;
	private long _columnBitmask;
	private StructuredData _escapedModel;

}