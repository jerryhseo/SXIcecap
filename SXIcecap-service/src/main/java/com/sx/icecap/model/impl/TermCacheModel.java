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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sx.icecap.model.Term;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Term in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TermCacheModel implements CacheModel<Term>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TermCacheModel)) {
			return false;
		}

		TermCacheModel termCacheModel = (TermCacheModel)object;

		if (termId == termCacheModel.termId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, termId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", termId=");
		sb.append(termId);
		sb.append(", groupTermId=");
		sb.append(groupTermId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", termName=");
		sb.append(termName);
		sb.append(", termVersion=");
		sb.append(termVersion);
		sb.append(", termType=");
		sb.append(termType);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", definition=");
		sb.append(definition);
		sb.append(", tooltip=");
		sb.append(tooltip);
		sb.append(", synonyms=");
		sb.append(synonyms);
		sb.append(", attributesJSON=");
		sb.append(attributesJSON);
		sb.append(", standard=");
		sb.append(standard);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Term toEntityModel() {
		TermImpl termImpl = new TermImpl();

		if (uuid == null) {
			termImpl.setUuid("");
		}
		else {
			termImpl.setUuid(uuid);
		}

		termImpl.setTermId(termId);

		if (groupTermId == null) {
			termImpl.setGroupTermId("");
		}
		else {
			termImpl.setGroupTermId(groupTermId);
		}

		termImpl.setGroupId(groupId);
		termImpl.setCompanyId(companyId);
		termImpl.setUserId(userId);

		if (userName == null) {
			termImpl.setUserName("");
		}
		else {
			termImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			termImpl.setCreateDate(null);
		}
		else {
			termImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			termImpl.setModifiedDate(null);
		}
		else {
			termImpl.setModifiedDate(new Date(modifiedDate));
		}

		termImpl.setStatus(status);
		termImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			termImpl.setStatusByUserName("");
		}
		else {
			termImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			termImpl.setStatusDate(null);
		}
		else {
			termImpl.setStatusDate(new Date(statusDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			termImpl.setLastPublishDate(null);
		}
		else {
			termImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		if (termName == null) {
			termImpl.setTermName("");
		}
		else {
			termImpl.setTermName(termName);
		}

		if (termVersion == null) {
			termImpl.setTermVersion("");
		}
		else {
			termImpl.setTermVersion(termVersion);
		}

		if (termType == null) {
			termImpl.setTermType("");
		}
		else {
			termImpl.setTermType(termType);
		}

		if (displayName == null) {
			termImpl.setDisplayName("");
		}
		else {
			termImpl.setDisplayName(displayName);
		}

		if (definition == null) {
			termImpl.setDefinition("");
		}
		else {
			termImpl.setDefinition(definition);
		}

		if (tooltip == null) {
			termImpl.setTooltip("");
		}
		else {
			termImpl.setTooltip(tooltip);
		}

		if (synonyms == null) {
			termImpl.setSynonyms("");
		}
		else {
			termImpl.setSynonyms(synonyms);
		}

		if (attributesJSON == null) {
			termImpl.setAttributesJSON("");
		}
		else {
			termImpl.setAttributesJSON(attributesJSON);
		}

		termImpl.setStandard(standard);

		termImpl.resetOriginalValues();

		return termImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		termId = objectInput.readLong();
		groupTermId = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();
		termName = objectInput.readUTF();
		termVersion = objectInput.readUTF();
		termType = objectInput.readUTF();
		displayName = objectInput.readUTF();
		definition = objectInput.readUTF();
		tooltip = objectInput.readUTF();
		synonyms = objectInput.readUTF();
		attributesJSON = objectInput.readUTF();

		standard = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(termId);

		if (groupTermId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(groupTermId);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeLong(lastPublishDate);

		if (termName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(termName);
		}

		if (termVersion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(termVersion);
		}

		if (termType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(termType);
		}

		if (displayName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (definition == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(definition);
		}

		if (tooltip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tooltip);
		}

		if (synonyms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(synonyms);
		}

		if (attributesJSON == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attributesJSON);
		}

		objectOutput.writeBoolean(standard);
	}

	public String uuid;
	public long termId;
	public String groupTermId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long lastPublishDate;
	public String termName;
	public String termVersion;
	public String termType;
	public String displayName;
	public String definition;
	public String tooltip;
	public String synonyms;
	public String attributesJSON;
	public boolean standard;

}