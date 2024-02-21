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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.sx.icecap.model.VisualizerLink;
import com.sx.icecap.model.VisualizerLinkModel;
import com.sx.icecap.model.VisualizerLinkSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the VisualizerLink service. Represents a row in the &quot;SX_ICECAP_VisualizerLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>VisualizerLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VisualizerLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisualizerLinkImpl
 * @generated
 */
@JSON(strict = true)
public class VisualizerLinkModelImpl
	extends BaseModelImpl<VisualizerLink> implements VisualizerLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a visualizer link model instance should use the <code>VisualizerLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "SX_ICECAP_VisualizerLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"VisualizerLink", Types.BIGINT}, {"dataTypeId", Types.BIGINT},
		{"visualizerId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("VisualizerLink", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dataTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("visualizerId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SX_ICECAP_VisualizerLink (VisualizerLink LONG not null primary key,dataTypeId LONG,visualizerId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table SX_ICECAP_VisualizerLink";

	public static final String ORDER_BY_JPQL =
		" ORDER BY visualizerLink.VisualizerLink ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SX_ICECAP_VisualizerLink.VisualizerLink ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long DATATYPEID_COLUMN_BITMASK = 1L;

	public static final long VISUALIZERID_COLUMN_BITMASK = 2L;

	public static final long VISUALIZERLINK_COLUMN_BITMASK = 4L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VisualizerLink toModel(VisualizerLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VisualizerLink model = new VisualizerLinkImpl();

		model.setVisualizerLink(soapModel.getVisualizerLink());
		model.setDataTypeId(soapModel.getDataTypeId());
		model.setVisualizerId(soapModel.getVisualizerId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VisualizerLink> toModels(
		VisualizerLinkSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<VisualizerLink> models = new ArrayList<VisualizerLink>(
			soapModels.length);

		for (VisualizerLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public VisualizerLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _VisualizerLink;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVisualizerLink(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _VisualizerLink;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VisualizerLink.class;
	}

	@Override
	public String getModelClassName() {
		return VisualizerLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<VisualizerLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<VisualizerLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VisualizerLink, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((VisualizerLink)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<VisualizerLink, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<VisualizerLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(VisualizerLink)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<VisualizerLink, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<VisualizerLink, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, VisualizerLink>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			VisualizerLink.class.getClassLoader(), VisualizerLink.class,
			ModelWrapper.class);

		try {
			Constructor<VisualizerLink> constructor =
				(Constructor<VisualizerLink>)proxyClass.getConstructor(
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

	private static final Map<String, Function<VisualizerLink, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<VisualizerLink, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<VisualizerLink, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<VisualizerLink, Object>>();
		Map<String, BiConsumer<VisualizerLink, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<VisualizerLink, ?>>();

		attributeGetterFunctions.put(
			"VisualizerLink", VisualizerLink::getVisualizerLink);
		attributeSetterBiConsumers.put(
			"VisualizerLink",
			(BiConsumer<VisualizerLink, Long>)
				VisualizerLink::setVisualizerLink);
		attributeGetterFunctions.put(
			"dataTypeId", VisualizerLink::getDataTypeId);
		attributeSetterBiConsumers.put(
			"dataTypeId",
			(BiConsumer<VisualizerLink, Long>)VisualizerLink::setDataTypeId);
		attributeGetterFunctions.put(
			"visualizerId", VisualizerLink::getVisualizerId);
		attributeSetterBiConsumers.put(
			"visualizerId",
			(BiConsumer<VisualizerLink, Long>)VisualizerLink::setVisualizerId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getVisualizerLink() {
		return _VisualizerLink;
	}

	@Override
	public void setVisualizerLink(long VisualizerLink) {
		_VisualizerLink = VisualizerLink;
	}

	@JSON
	@Override
	public long getDataTypeId() {
		return _dataTypeId;
	}

	@Override
	public void setDataTypeId(long dataTypeId) {
		_columnBitmask |= DATATYPEID_COLUMN_BITMASK;

		if (!_setOriginalDataTypeId) {
			_setOriginalDataTypeId = true;

			_originalDataTypeId = _dataTypeId;
		}

		_dataTypeId = dataTypeId;
	}

	public long getOriginalDataTypeId() {
		return _originalDataTypeId;
	}

	@JSON
	@Override
	public long getVisualizerId() {
		return _visualizerId;
	}

	@Override
	public void setVisualizerId(long visualizerId) {
		_columnBitmask |= VISUALIZERID_COLUMN_BITMASK;

		if (!_setOriginalVisualizerId) {
			_setOriginalVisualizerId = true;

			_originalVisualizerId = _visualizerId;
		}

		_visualizerId = visualizerId;
	}

	public long getOriginalVisualizerId() {
		return _originalVisualizerId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, VisualizerLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VisualizerLink toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, VisualizerLink>
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
		VisualizerLinkImpl visualizerLinkImpl = new VisualizerLinkImpl();

		visualizerLinkImpl.setVisualizerLink(getVisualizerLink());
		visualizerLinkImpl.setDataTypeId(getDataTypeId());
		visualizerLinkImpl.setVisualizerId(getVisualizerId());

		visualizerLinkImpl.resetOriginalValues();

		return visualizerLinkImpl;
	}

	@Override
	public int compareTo(VisualizerLink visualizerLink) {
		long primaryKey = visualizerLink.getPrimaryKey();

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

		if (!(object instanceof VisualizerLink)) {
			return false;
		}

		VisualizerLink visualizerLink = (VisualizerLink)object;

		long primaryKey = visualizerLink.getPrimaryKey();

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
		_originalDataTypeId = _dataTypeId;

		_setOriginalDataTypeId = false;

		_originalVisualizerId = _visualizerId;

		_setOriginalVisualizerId = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<VisualizerLink> toCacheModel() {
		VisualizerLinkCacheModel visualizerLinkCacheModel =
			new VisualizerLinkCacheModel();

		visualizerLinkCacheModel.VisualizerLink = getVisualizerLink();

		visualizerLinkCacheModel.dataTypeId = getDataTypeId();

		visualizerLinkCacheModel.visualizerId = getVisualizerId();

		return visualizerLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<VisualizerLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<VisualizerLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VisualizerLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((VisualizerLink)this);

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
		Map<String, Function<VisualizerLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<VisualizerLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<VisualizerLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((VisualizerLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, VisualizerLink>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _VisualizerLink;
	private long _dataTypeId;
	private long _originalDataTypeId;
	private boolean _setOriginalDataTypeId;
	private long _visualizerId;
	private long _originalVisualizerId;
	private boolean _setOriginalVisualizerId;
	private long _columnBitmask;
	private VisualizerLink _escapedModel;

}