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

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the VisualizerLink service. Represents a row in the &quot;SX_ICECAP_VisualizerLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.sx.icecap.model.impl.VisualizerLinkModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.sx.icecap.model.impl.VisualizerLinkImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisualizerLink
 * @generated
 */
@ProviderType
public interface VisualizerLinkModel extends BaseModel<VisualizerLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a visualizer link model instance should use the {@link VisualizerLink} interface instead.
	 */

	/**
	 * Returns the primary key of this visualizer link.
	 *
	 * @return the primary key of this visualizer link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this visualizer link.
	 *
	 * @param primaryKey the primary key of this visualizer link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the visualizer link of this visualizer link.
	 *
	 * @return the visualizer link of this visualizer link
	 */
	public long getVisualizerLink();

	/**
	 * Sets the visualizer link of this visualizer link.
	 *
	 * @param VisualizerLink the visualizer link of this visualizer link
	 */
	public void setVisualizerLink(long VisualizerLink);

	/**
	 * Returns the data type ID of this visualizer link.
	 *
	 * @return the data type ID of this visualizer link
	 */
	public long getDataTypeId();

	/**
	 * Sets the data type ID of this visualizer link.
	 *
	 * @param dataTypeId the data type ID of this visualizer link
	 */
	public void setDataTypeId(long dataTypeId);

	/**
	 * Returns the visualizer ID of this visualizer link.
	 *
	 * @return the visualizer ID of this visualizer link
	 */
	public long getVisualizerId();

	/**
	 * Sets the visualizer ID of this visualizer link.
	 *
	 * @param visualizerId the visualizer ID of this visualizer link
	 */
	public void setVisualizerId(long visualizerId);

}