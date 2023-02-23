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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Term service. Represents a row in the &quot;SX_ICECAP_Term&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TermModel
 * @generated
 */
@ImplementationClassName("com.sx.icecap.model.impl.TermImpl")
@ProviderType
public interface Term extends PersistedModel, TermModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sx.icecap.model.impl.TermImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Term, Long> TERM_ID_ACCESSOR =
		new Accessor<Term, Long>() {

			@Override
			public Long get(Term term) {
				return term.getTermId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Term> getTypeClass() {
				return Term.class;
			}

		};

	public String getDisplayTitle(java.util.Locale locale);

	public com.liferay.portal.kernel.json.JSONObject toJSONObject(
			java.util.Set<java.util.Locale> locales)
		throws com.liferay.portal.kernel.json.JSONException;

	public String toJSONString(java.util.Set<java.util.Locale> locales)
		throws com.liferay.portal.kernel.json.JSONException;

}