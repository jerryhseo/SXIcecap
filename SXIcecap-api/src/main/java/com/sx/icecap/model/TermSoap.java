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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sx.icecap.service.http.TermServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TermSoap implements Serializable {

	public static TermSoap toSoapModel(Term model) {
		TermSoap soapModel = new TermSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTermId(model.getTermId());
		soapModel.setGroupTermId(model.getGroupTermId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setTermName(model.getTermName());
		soapModel.setTermVersion(model.getTermVersion());
		soapModel.setTermType(model.getTermType());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDefinition(model.getDefinition());
		soapModel.setTooltip(model.getTooltip());
		soapModel.setSynonyms(model.getSynonyms());
		soapModel.setAttributesJSON(model.getAttributesJSON());
		soapModel.setStandard(model.isStandard());

		return soapModel;
	}

	public static TermSoap[] toSoapModels(Term[] models) {
		TermSoap[] soapModels = new TermSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[][] toSoapModels(Term[][] models) {
		TermSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TermSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TermSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TermSoap[] toSoapModels(List<Term> models) {
		List<TermSoap> soapModels = new ArrayList<TermSoap>(models.size());

		for (Term model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TermSoap[soapModels.size()]);
	}

	public TermSoap() {
	}

	public long getPrimaryKey() {
		return _termId;
	}

	public void setPrimaryKey(long pk) {
		setTermId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public String getGroupTermId() {
		return _groupTermId;
	}

	public void setGroupTermId(String groupTermId) {
		_groupTermId = groupTermId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	public String getTermName() {
		return _termName;
	}

	public void setTermName(String termName) {
		_termName = termName;
	}

	public String getTermVersion() {
		return _termVersion;
	}

	public void setTermVersion(String termVersion) {
		_termVersion = termVersion;
	}

	public String getTermType() {
		return _termType;
	}

	public void setTermType(String termType) {
		_termType = termType;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getDefinition() {
		return _definition;
	}

	public void setDefinition(String definition) {
		_definition = definition;
	}

	public String getTooltip() {
		return _tooltip;
	}

	public void setTooltip(String tooltip) {
		_tooltip = tooltip;
	}

	public String getSynonyms() {
		return _synonyms;
	}

	public void setSynonyms(String synonyms) {
		_synonyms = synonyms;
	}

	public String getAttributesJSON() {
		return _attributesJSON;
	}

	public void setAttributesJSON(String attributesJSON) {
		_attributesJSON = attributesJSON;
	}

	public boolean getStandard() {
		return _standard;
	}

	public boolean isStandard() {
		return _standard;
	}

	public void setStandard(boolean standard) {
		_standard = standard;
	}

	private String _uuid;
	private long _termId;
	private String _groupTermId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private Date _lastPublishDate;
	private String _termName;
	private String _termVersion;
	private String _termType;
	private String _displayName;
	private String _definition;
	private String _tooltip;
	private String _synonyms;
	private String _attributesJSON;
	private boolean _standard;

}