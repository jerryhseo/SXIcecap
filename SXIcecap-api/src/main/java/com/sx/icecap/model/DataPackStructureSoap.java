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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DataPackStructureSoap implements Serializable {

	public static DataPackStructureSoap toSoapModel(DataPackStructure model) {
		DataPackStructureSoap soapModel = new DataPackStructureSoap();

		soapModel.setDataPackId(model.getDataPackId());
		soapModel.setStructure(model.getStructure());

		return soapModel;
	}

	public static DataPackStructureSoap[] toSoapModels(
		DataPackStructure[] models) {

		DataPackStructureSoap[] soapModels =
			new DataPackStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DataPackStructureSoap[][] toSoapModels(
		DataPackStructure[][] models) {

		DataPackStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DataPackStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DataPackStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DataPackStructureSoap[] toSoapModels(
		List<DataPackStructure> models) {

		List<DataPackStructureSoap> soapModels =
			new ArrayList<DataPackStructureSoap>(models.size());

		for (DataPackStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DataPackStructureSoap[soapModels.size()]);
	}

	public DataPackStructureSoap() {
	}

	public long getPrimaryKey() {
		return _dataPackId;
	}

	public void setPrimaryKey(long pk) {
		setDataPackId(pk);
	}

	public long getDataPackId() {
		return _dataPackId;
	}

	public void setDataPackId(long dataPackId) {
		_dataPackId = dataPackId;
	}

	public String getStructure() {
		return _structure;
	}

	public void setStructure(String structure) {
		_structure = structure;
	}

	private long _dataPackId;
	private String _structure;

}