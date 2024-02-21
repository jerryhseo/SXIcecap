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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import com.sx.icecap.model.DataPack;
import com.sx.icecap.service.DataPackLocalService;
import com.sx.icecap.service.DataPackLocalServiceUtil;
import com.sx.icecap.service.persistence.DataPackEntryPersistence;
import com.sx.icecap.service.persistence.DataPackPersistence;
import com.sx.icecap.service.persistence.DataPackStructurePersistence;
import com.sx.icecap.service.persistence.DataSetPersistence;
import com.sx.icecap.service.persistence.DataTypePersistence;
import com.sx.icecap.service.persistence.DataTypeStructurePersistence;
import com.sx.icecap.service.persistence.StructuredDataPersistence;
import com.sx.icecap.service.persistence.TermPersistence;
import com.sx.icecap.service.persistence.VisualizerLinkPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the data pack local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sx.icecap.service.impl.DataPackLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sx.icecap.service.impl.DataPackLocalServiceImpl
 * @generated
 */
public abstract class DataPackLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, DataPackLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DataPackLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DataPackLocalServiceUtil</code>.
	 */

	/**
	 * Adds the data pack to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataPack addDataPack(DataPack dataPack) {
		dataPack.setNew(true);

		return dataPackPersistence.update(dataPack);
	}

	/**
	 * Creates a new data pack with the primary key. Does not add the data pack to the database.
	 *
	 * @param dataPackId the primary key for the new data pack
	 * @return the new data pack
	 */
	@Override
	@Transactional(enabled = false)
	public DataPack createDataPack(long dataPackId) {
		return dataPackPersistence.create(dataPackId);
	}

	/**
	 * Deletes the data pack with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack that was removed
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataPack deleteDataPack(long dataPackId) throws PortalException {
		return dataPackPersistence.remove(dataPackId);
	}

	/**
	 * Deletes the data pack from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DataPack deleteDataPack(DataPack dataPack) {
		return dataPackPersistence.remove(dataPack);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DataPack.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dataPackPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return dataPackPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return dataPackPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dataPackPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return dataPackPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DataPack fetchDataPack(long dataPackId) {
		return dataPackPersistence.fetchByPrimaryKey(dataPackId);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack, or <code>null</code> if a matching data pack could not be found
	 */
	@Override
	public DataPack fetchDataPackByUuidAndGroupId(String uuid, long groupId) {
		return dataPackPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the data pack with the primary key.
	 *
	 * @param dataPackId the primary key of the data pack
	 * @return the data pack
	 * @throws PortalException if a data pack with the primary key could not be found
	 */
	@Override
	public DataPack getDataPack(long dataPackId) throws PortalException {
		return dataPackPersistence.findByPrimaryKey(dataPackId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dataPackLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DataPack.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dataPackId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			dataPackLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DataPack.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("dataPackId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(dataPackLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DataPack.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dataPackId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					if (modifiedDateCriterion != null) {
						Conjunction conjunction =
							RestrictionsFactoryUtil.conjunction();

						conjunction.add(modifiedDateCriterion);

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(
							RestrictionsFactoryUtil.gtProperty(
								"modifiedDate", "lastPublishDate"));

						Property lastPublishDateProperty =
							PropertyFactoryUtil.forName("lastPublishDate");

						disjunction.add(lastPublishDateProperty.isNull());

						conjunction.add(disjunction);

						modifiedDateCriterion = conjunction;
					}

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									DataPack.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<DataPack>() {

				@Override
				public void performAction(DataPack dataPack)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, dataPack);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(DataPack.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return dataPackLocalService.deleteDataPack((DataPack)persistedModel);
	}

	public BasePersistence<DataPack> getBasePersistence() {
		return dataPackPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return dataPackPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @return the matching data packs, or an empty list if no matches were found
	 */
	@Override
	public List<DataPack> getDataPacksByUuidAndCompanyId(
		String uuid, long companyId) {

		return dataPackPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of data packs matching the UUID and company.
	 *
	 * @param uuid the UUID of the data packs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching data packs, or an empty list if no matches were found
	 */
	@Override
	public List<DataPack> getDataPacksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DataPack> orderByComparator) {

		return dataPackPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the data pack matching the UUID and group.
	 *
	 * @param uuid the data pack's UUID
	 * @param groupId the primary key of the group
	 * @return the matching data pack
	 * @throws PortalException if a matching data pack could not be found
	 */
	@Override
	public DataPack getDataPackByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return dataPackPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the data packs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sx.icecap.model.impl.DataPackModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data packs
	 * @param end the upper bound of the range of data packs (not inclusive)
	 * @return the range of data packs
	 */
	@Override
	public List<DataPack> getDataPacks(int start, int end) {
		return dataPackPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of data packs.
	 *
	 * @return the number of data packs
	 */
	@Override
	public int getDataPacksCount() {
		return dataPackPersistence.countAll();
	}

	/**
	 * Updates the data pack in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DataPackLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param dataPack the data pack
	 * @return the data pack that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DataPack updateDataPack(DataPack dataPack) {
		return dataPackPersistence.update(dataPack);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			DataPackLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		dataPackLocalService = (DataPackLocalService)aopProxy;

		_setLocalServiceUtilService(dataPackLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DataPackLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DataPack.class;
	}

	protected String getModelClassName() {
		return DataPack.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dataPackPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		DataPackLocalService dataPackLocalService) {

		try {
			Field field = DataPackLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, dataPackLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected DataPackLocalService dataPackLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService
		workflowInstanceLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

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
	protected com.liferay.trash.kernel.service.TrashVersionLocalService
		trashVersionLocalService;

}