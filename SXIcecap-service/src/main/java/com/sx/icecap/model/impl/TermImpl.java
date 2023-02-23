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

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sx.icecap.constant.IcecapSSSTermAttributes;

import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/**
 * The extended model implementation for the Term service. Represents a row in the &quot;sxicecapsss_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.sx.icecap.sss.model.Term</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class TermImpl extends TermBaseImpl {

	public TermImpl() {
	}

	public String getDisplayTitle( Locale locale ) {
		return super.getDisplayName( locale ) + " ver. " + super.getTermVersion();
	}
	
	public JSONObject toJSONObject( Set<Locale> locales ) throws JSONException {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		
		jsonObj.put( IcecapSSSTermAttributes.TERM_ID, super.getTermId() );
		jsonObj.put( IcecapSSSTermAttributes.TERM_NAME, super.getTermName() );
		jsonObj.put( IcecapSSSTermAttributes.TERM_VERSION, super.getTermVersion() );
		jsonObj.put( IcecapSSSTermAttributes.TERM_TYPE, super.getTermType() );
			
		JSONObject jsonSub =  JSONFactoryUtil.createJSONObject( super.getGroupTermId() );
		jsonObj.put( IcecapSSSTermAttributes.GROUP_TERM_ID, jsonSub );
		
		JSONObject jsonDisplayName = JSONFactoryUtil.createJSONObject();
		JSONObject jsonDefinition = JSONFactoryUtil.createJSONObject();
		JSONObject jsonTooltip = JSONFactoryUtil.createJSONObject();
		locales.forEach(locale->{
			jsonDisplayName.put(locale.toString(), super.getDisplayName(locale));
			jsonDefinition.put(locale.toString(), super.getDefinition(locale));
			jsonTooltip.put(locale.toString(), super.getTooltip(locale));
		});
		jsonObj.put( IcecapSSSTermAttributes.DISPLAY_NAME, jsonDisplayName );
		jsonObj.put( IcecapSSSTermAttributes.DEFINITION, jsonDefinition );
		jsonObj.put( IcecapSSSTermAttributes.TOOLTIP, jsonTooltip );
		
		jsonSub = JSONFactoryUtil.createJSONObject( super.getAttributesJSON() );
		Iterator<String> keys = jsonSub.keys();
		while( keys.hasNext() ) {
			String key = keys.next();
			jsonObj.put( key,  jsonSub.get(key) );
		}
		
		jsonObj.put( IcecapSSSTermAttributes.STATUS, super.getStatus() );
		jsonObj.put(IcecapSSSTermAttributes.STANDARD, super.getStandard() );
		
		return jsonObj;
	}
	
	public String toJSONString( Set<Locale> locales )  throws JSONException {
		return toJSONObject(locales).toJSONString().replace("'", "\"");
	}
}