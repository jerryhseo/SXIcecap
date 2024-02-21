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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sx.icecap.service.http.VisualizerLinkServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VisualizerLinkSoap implements Serializable {

	public static VisualizerLinkSoap toSoapModel(VisualizerLink model) {
		VisualizerLinkSoap soapModel = new VisualizerLinkSoap();

		soapModel.setVisualizerLink(model.getVisualizerLink());
		soapModel.setDataTypeId(model.getDataTypeId());
		soapModel.setVisualizerId(model.getVisualizerId());

		return soapModel;
	}

	public static VisualizerLinkSoap[] toSoapModels(VisualizerLink[] models) {
		VisualizerLinkSoap[] soapModels = new VisualizerLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VisualizerLinkSoap[][] toSoapModels(
		VisualizerLink[][] models) {

		VisualizerLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new VisualizerLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VisualizerLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VisualizerLinkSoap[] toSoapModels(
		List<VisualizerLink> models) {

		List<VisualizerLinkSoap> soapModels = new ArrayList<VisualizerLinkSoap>(
			models.size());

		for (VisualizerLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VisualizerLinkSoap[soapModels.size()]);
	}

	public VisualizerLinkSoap() {
	}

	public long getPrimaryKey() {
		return _VisualizerLink;
	}

	public void setPrimaryKey(long pk) {
		setVisualizerLink(pk);
	}

	public long getVisualizerLink() {
		return _VisualizerLink;
	}

	public void setVisualizerLink(long VisualizerLink) {
		_VisualizerLink = VisualizerLink;
	}

	public long getDataTypeId() {
		return _dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		_dataTypeId = dataTypeId;
	}

	public long getVisualizerId() {
		return _visualizerId;
	}

	public void setVisualizerId(long visualizerId) {
		_visualizerId = visualizerId;
	}

	private long _VisualizerLink;
	private long _dataTypeId;
	private long _visualizerId;

}