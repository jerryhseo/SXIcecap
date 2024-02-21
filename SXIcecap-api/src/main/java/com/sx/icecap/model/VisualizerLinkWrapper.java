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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VisualizerLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisualizerLink
 * @generated
 */
public class VisualizerLinkWrapper
	extends BaseModelWrapper<VisualizerLink>
	implements ModelWrapper<VisualizerLink>, VisualizerLink {

	public VisualizerLinkWrapper(VisualizerLink visualizerLink) {
		super(visualizerLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("VisualizerLink", getVisualizerLink());
		attributes.put("dataTypeId", getDataTypeId());
		attributes.put("visualizerId", getVisualizerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long VisualizerLink = (Long)attributes.get("VisualizerLink");

		if (VisualizerLink != null) {
			setVisualizerLink(VisualizerLink);
		}

		Long dataTypeId = (Long)attributes.get("dataTypeId");

		if (dataTypeId != null) {
			setDataTypeId(dataTypeId);
		}

		Long visualizerId = (Long)attributes.get("visualizerId");

		if (visualizerId != null) {
			setVisualizerId(visualizerId);
		}
	}

	/**
	 * Returns the data type ID of this visualizer link.
	 *
	 * @return the data type ID of this visualizer link
	 */
	@Override
	public long getDataTypeId() {
		return model.getDataTypeId();
	}

	/**
	 * Returns the primary key of this visualizer link.
	 *
	 * @return the primary key of this visualizer link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the visualizer ID of this visualizer link.
	 *
	 * @return the visualizer ID of this visualizer link
	 */
	@Override
	public long getVisualizerId() {
		return model.getVisualizerId();
	}

	/**
	 * Returns the visualizer link of this visualizer link.
	 *
	 * @return the visualizer link of this visualizer link
	 */
	@Override
	public long getVisualizerLink() {
		return model.getVisualizerLink();
	}

	/**
	 * Sets the data type ID of this visualizer link.
	 *
	 * @param dataTypeId the data type ID of this visualizer link
	 */
	@Override
	public void setDataTypeId(long dataTypeId) {
		model.setDataTypeId(dataTypeId);
	}

	/**
	 * Sets the primary key of this visualizer link.
	 *
	 * @param primaryKey the primary key of this visualizer link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the visualizer ID of this visualizer link.
	 *
	 * @param visualizerId the visualizer ID of this visualizer link
	 */
	@Override
	public void setVisualizerId(long visualizerId) {
		model.setVisualizerId(visualizerId);
	}

	/**
	 * Sets the visualizer link of this visualizer link.
	 *
	 * @param VisualizerLink the visualizer link of this visualizer link
	 */
	@Override
	public void setVisualizerLink(long VisualizerLink) {
		model.setVisualizerLink(VisualizerLink);
	}

	@Override
	protected VisualizerLinkWrapper wrap(VisualizerLink visualizerLink) {
		return new VisualizerLinkWrapper(visualizerLink);
	}

}