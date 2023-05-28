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

package com.sx.icecap.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import com.sx.icecap.exception.NoSuchDataPackStructureException;
import com.sx.icecap.model.DataPackStructure;
import com.sx.icecap.model.impl.DataPackStructureImpl;
import com.sx.icecap.model.impl.DataPackStructureModelImpl;
import com.sx.icecap.service.persistence.DataPackStructurePersistence;
import com.sx.icecap.service.persistence.DataPackStructureUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the data pack structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DataPackStructurePersistence.class)
public class DataPackStructurePersistenceImpl
	extends BasePersistenceImpl<DataPackStructure>
	implements DataPackStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DataPackStructureUtil</code> to access the data pack structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DataPackStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DataPackStructurePersistenceImpl() {
		setModelClass(DataPackStructure.class);

		setModelImplClass(DataPackStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the data pack structure in the entity cache if it is enabled.
	 *
	 * @param dataPackStructure the data pack structure
	 */
	@Override
	public void cacheResult(DataPackStructure dataPackStructure) {
		entityCache.putResult(
			entityCacheEnabled, DataPackStructureImpl.class,
			dataPackStructure.getPrimaryKey(), dataPackStructure);

		dataPackStructure.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the data pack structures in the entity cache if it is enabled.
	 *
	 * @param dataPackStructures the data pack structures
	 */
	@Override
	public void cacheResult(List<DataPackStructure> dataPackStructures) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dataPackStructures.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DataPackStructure dataPackStructure : dataPackStructures) {
			if (entityCache.getResult(
					entityCacheEnabled, DataPackStructureImpl.class,
					dataPackStructure.getPrimaryKey()) == null) {

				cacheResult(dataPackStructure);
			}
			else {
				dataPackStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all data pack structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DataPackStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the data pack structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DataPackStructure dataPackStructure) {
		entityCache.removeResult(
			entityCacheEnabled, DataPackStructureImpl.class,
			dataPackStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DataPackStructure> dataPackStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DataPackStructure dataPackStructure : dataPackStructures) {
			entityCache.removeResult(
				entityCacheEnabled, DataPackStructureImpl.class,
				dataPackStructure.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, DataPackStructureImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new data pack structure with the primary key. Does not add the data pack structure to the database.
	 *
	 * @param dataPackId the primary key for the new data pack structure
	 * @return the new data pack structure
	 */
	@Override
	public DataPackStructure create(long dataPackId) {
		DataPackStructure dataPackStructure = new DataPackStructureImpl();

		dataPackStructure.setNew(true);
		dataPackStructure.setPrimaryKey(dataPackId);

		return dataPackStructure;
	}

	/**
	 * Removes the data pack structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure that was removed
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	@Override
	public DataPackStructure remove(long dataPackId)
		throws NoSuchDataPackStructureException {

		return remove((Serializable)dataPackId);
	}

	/**
	 * Removes the data pack structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the data pack structure
	 * @return the data pack structure that was removed
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	@Override
	public DataPackStructure remove(Serializable primaryKey)
		throws NoSuchDataPackStructureException {

		Session session = null;

		try {
			session = openSession();

			DataPackStructure dataPackStructure =
				(DataPackStructure)session.get(
					DataPackStructureImpl.class, primaryKey);

			if (dataPackStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDataPackStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dataPackStructure);
		}
		catch (NoSuchDataPackStructureException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DataPackStructure removeImpl(
		DataPackStructure dataPackStructure) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dataPackStructure)) {
				dataPackStructure = (DataPackStructure)session.get(
					DataPackStructureImpl.class,
					dataPackStructure.getPrimaryKeyObj());
			}

			if (dataPackStructure != null) {
				session.delete(dataPackStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dataPackStructure != null) {
			clearCache(dataPackStructure);
		}

		return dataPackStructure;
	}

	@Override
	public DataPackStructure updateImpl(DataPackStructure dataPackStructure) {
		boolean isNew = dataPackStructure.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dataPackStructure);

				dataPackStructure.setNew(false);
			}
			else {
				dataPackStructure = (DataPackStructure)session.merge(
					dataPackStructure);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, DataPackStructureImpl.class,
			dataPackStructure.getPrimaryKey(), dataPackStructure, false);

		dataPackStructure.resetOriginalValues();

		return dataPackStructure;
	}

	/**
	 * Returns the data pack structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the data pack structure
	 * @return the data pack structure
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	@Override
	public DataPackStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDataPackStructureException {

		DataPackStructure dataPackStructure = fetchByPrimaryKey(primaryKey);

		if (dataPackStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDataPackStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dataPackStructure;
	}

	/**
	 * Returns the data pack structure with the primary key or throws a <code>NoSuchDataPackStructureException</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure
	 * @throws NoSuchDataPackStructureException if a data pack structure with the primary key could not be found
	 */
	@Override
	public DataPackStructure findByPrimaryKey(long dataPackId)
		throws NoSuchDataPackStructureException {

		return findByPrimaryKey((Serializable)dataPackId);
	}

	/**
	 * Returns the data pack structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataPackId the primary key of the data pack structure
	 * @return the data pack structure, or <code>null</code> if a data pack structure with the primary key could not be found
	 */
	@Override
	public DataPackStructure fetchByPrimaryKey(long dataPackId) {
		return fetchByPrimaryKey((Serializable)dataPackId);
	}

	/**
	 * Returns all the data pack structures.
	 *
	 * @return the data pack structures
	 */
	@Override
	public List<DataPackStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @return the range of data pack structures
	 */
	@Override
	public List<DataPackStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data pack structures
	 */
	@Override
	public List<DataPackStructure> findAll(
		int start, int end,
		OrderByComparator<DataPackStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the data pack structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataPackStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data pack structures
	 * @param end the upper bound of the range of data pack structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data pack structures
	 */
	@Override
	public List<DataPackStructure> findAll(
		int start, int end,
		OrderByComparator<DataPackStructure> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<DataPackStructure> list = null;

		if (useFinderCache) {
			list = (List<DataPackStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DATAPACKSTRUCTURE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DATAPACKSTRUCTURE;

				sql = sql.concat(DataPackStructureModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DataPackStructure>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the data pack structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DataPackStructure dataPackStructure : findAll()) {
			remove(dataPackStructure);
		}
	}

	/**
	 * Returns the number of data pack structures.
	 *
	 * @return the number of data pack structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DATAPACKSTRUCTURE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "dataPackId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DATAPACKSTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DataPackStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the data pack structure persistence.
	 */
	@Activate
	public void activate() {
		DataPackStructureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		DataPackStructureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataPackStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, DataPackStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_setDataPackStructureUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDataPackStructureUtilPersistence(null);

		entityCache.removeCache(DataPackStructureImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setDataPackStructureUtilPersistence(
		DataPackStructurePersistence dataPackStructurePersistence) {

		try {
			Field field = DataPackStructureUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dataPackStructurePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.sx.icecap.model.DataPackStructure"),
			true);
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SX_ICECAPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DATAPACKSTRUCTURE =
		"SELECT dataPackStructure FROM DataPackStructure dataPackStructure";

	private static final String _SQL_COUNT_DATAPACKSTRUCTURE =
		"SELECT COUNT(dataPackStructure) FROM DataPackStructure dataPackStructure";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dataPackStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DataPackStructure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DataPackStructurePersistenceImpl.class);

}