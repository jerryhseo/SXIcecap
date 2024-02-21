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

import com.sx.icecap.model.VisualizerLink;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VisualizerLink in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VisualizerLinkCacheModel
	implements CacheModel<VisualizerLink>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisualizerLinkCacheModel)) {
			return false;
		}

		VisualizerLinkCacheModel visualizerLinkCacheModel =
			(VisualizerLinkCacheModel)object;

		if (VisualizerLink == visualizerLinkCacheModel.VisualizerLink) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, VisualizerLink);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{VisualizerLink=");
		sb.append(VisualizerLink);
		sb.append(", dataTypeId=");
		sb.append(dataTypeId);
		sb.append(", visualizerId=");
		sb.append(visualizerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VisualizerLink toEntityModel() {
		VisualizerLinkImpl visualizerLinkImpl = new VisualizerLinkImpl();

		visualizerLinkImpl.setVisualizerLink(VisualizerLink);
		visualizerLinkImpl.setDataTypeId(dataTypeId);
		visualizerLinkImpl.setVisualizerId(visualizerId);

		visualizerLinkImpl.resetOriginalValues();

		return visualizerLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		VisualizerLink = objectInput.readLong();

		dataTypeId = objectInput.readLong();

		visualizerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(VisualizerLink);

		objectOutput.writeLong(dataTypeId);

		objectOutput.writeLong(visualizerId);
	}

	public long VisualizerLink;
	public long dataTypeId;
	public long visualizerId;

}