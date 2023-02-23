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

package com.sx.icecap.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalServiceUtil;
import com.sx.icecap.service.base.TermServiceBaseImpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the term remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.sx.icecap.sss.service.TermService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo, Won Cheol Ryu
 * @see TermServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=sss",
		"json.web.service.context.path=Term"
	},
	service = AopService.class
)
public class TermServiceImpl extends TermServiceBaseImpl {

	public Term addTerm(
			String name,
			String version,
			String type,
			String strDisplayName,
			String strDefinition,
			String strTooltip,
			String synonyms,
			String attributes, // attributes for each type
			String groupTermId,
			ServiceContext sc) throws PortalException {
		
		_portletResourcePermission.check(
		        getPermissionChecker(), sc.getScopeGroupId(),
		        ActionKeys.ADD_ENTRY);
		
		JSONObject jsonDisplayName = JSONFactoryUtil.createJSONObject(strDisplayName);
		Map<Locale, String> displayNameMap = new HashMap<>();
		Iterator<String> displayNameKeys = jsonDisplayName.keys();
		while( displayNameKeys.hasNext() ) {
			String key = displayNameKeys.next();
			displayNameMap.put( LanguageUtil.getLocale( key ), jsonDisplayName.getString(key) );
		}
		
		JSONObject jsonDefinition = JSONFactoryUtil.createJSONObject(strDefinition);
		Map<Locale, String> definitionMap = new HashMap<>();
		Iterator<String> definitionKeys = jsonDefinition.keys();
		while( definitionKeys.hasNext() ) {
			String key = definitionKeys.next();
			definitionMap.put( LanguageUtil.getLocale( key ), jsonDefinition.getString(key) );
		}
		
		JSONObject jsonTooltip = JSONFactoryUtil.createJSONObject(strTooltip);
		Map<Locale, String> tooltipMap = new HashMap<>();
		Iterator<String> tooltipKeys = jsonTooltip.keys();
		while( tooltipKeys.hasNext() ) {
			String key = tooltipKeys.next();
			tooltipMap.put( LanguageUtil.getLocale( key ), jsonTooltip.getString(key) );
		}

		return TermLocalServiceUtil.addTerm(name, version, type, displayNameMap, definitionMap, tooltipMap, synonyms, attributes, groupTermId, WorkflowConstants.STATUS_DRAFT, false, sc);
	}
	
	public Term getTerm( long termId ) throws PortalException {
		return TermLocalServiceUtil.getTerm(termId);
	}
	
	
	private static volatile ModelResourcePermission<Term>
			_termModelResourcePermission = ModelResourcePermissionFactory.getInstance(
					TermServiceImpl.class, "_termModelResourcePermission", Term.class);
	private static volatile PortletResourcePermission
			_portletResourcePermission = PortletResourcePermissionFactory.getInstance(
					TermServiceImpl.class, "_portletResourcePermission", IcecapConstants.TERM_RESOURCE_NAME);

}