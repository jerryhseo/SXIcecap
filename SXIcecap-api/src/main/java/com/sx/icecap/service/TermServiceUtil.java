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

package com.sx.icecap.service;

import com.liferay.portal.kernel.exception.PortalException;

import com.sx.icecap.model.Term;

/**
 * Provides the remote service utility for Term. This utility wraps
 * <code>com.sx.icecap.service.impl.TermServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TermService
 * @generated
 */
public class TermServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sx.icecap.service.impl.TermServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Term addTerm(
			String name, String version, String type, String strDisplayName,
			String strDefinition, String strTooltip, String synonyms,
			String attributes, String groupTermId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().addTerm(
			name, version, type, strDisplayName, strDefinition, strTooltip,
			synonyms, attributes, groupTermId, sc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Term getTerm(long termId) throws PortalException {
		return getService().getTerm(termId);
	}

	public static TermService getService() {
		return _service;
	}

	private static volatile TermService _service;

}