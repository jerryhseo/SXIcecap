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

package com.sx.icecap.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermService;
import com.sx.icecap.service.TermServiceUtil;
import com.sx.icecap.service.persistence.DataPackEntryPersistence;
import com.sx.icecap.service.persistence.DataPackPersistence;
import com.sx.icecap.service.persistence.DataPackStructurePersistence;
import com.sx.icecap.service.persistence.DataSetPersistence;
import com.sx.icecap.service.persistence.DataTypePersistence;
import com.sx.icecap.service.persistence.DataTypeStructurePersistence;
import com.sx.icecap.service.persistence.StructuredDataPersistence;
import com.sx.icecap.service.persistence.TermPersistence;
import com.sx.icecap.service.persistence.VisualizerLinkPersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the term remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sx.icecap.service.impl.TermServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sx.icecap.service.impl.TermServiceImpl
 * @generated
 */
public abstract class TermServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, TermService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TermService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TermServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TermService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		termService = (TermService)aopProxy;

		_setServiceUtilService(termService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TermService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Term.class;
	}

	protected String getModelClassName() {
		return Term.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = termPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(TermService termService) {
		try {
			Field field = TermServiceUtil.class.getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, termService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected DataPackPersistence dataPackPersistence;

	@Reference
	protected DataPackEntryPersistence dataPackEntryPersistence;

	@Reference
	protected DataPackStructurePersistence dataPackStructurePersistence;

	@Reference
	protected DataSetPersistence dataSetPersistence;

	@Reference
	protected DataTypePersistence dataTypePersistence;

	@Reference
	protected DataTypeStructurePersistence dataTypeStructurePersistence;

	@Reference
	protected StructuredDataPersistence structuredDataPersistence;

	@Reference
	protected com.sx.icecap.service.TermLocalService termLocalService;

	protected TermService termService;

	@Reference
	protected TermPersistence termPersistence;

	@Reference
	protected VisualizerLinkPersistence visualizerLinkPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.ratings.kernel.service.RatingsStatsLocalService
		ratingsStatsLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashEntryLocalService
		trashEntryLocalService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashEntryService
		trashEntryService;

	@Reference
	protected com.liferay.trash.kernel.service.TrashVersionLocalService
		trashVersionLocalService;

}