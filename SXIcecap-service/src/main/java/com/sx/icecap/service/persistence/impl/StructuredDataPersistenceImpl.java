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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.sx.icecap.exception.NoSuchStructuredDataException;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.model.impl.StructuredDataImpl;
import com.sx.icecap.model.impl.StructuredDataModelImpl;
import com.sx.icecap.service.persistence.StructuredDataPersistence;
import com.sx.icecap.service.persistence.StructuredDataUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the structured data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StructuredDataPersistence.class)
public class StructuredDataPersistenceImpl
	extends BasePersistenceImpl<StructuredData>
	implements StructuredDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StructuredDataUtil</code> to access the structured data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StructuredDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCrf;
	private FinderPath _finderPathWithoutPaginationFindByCrf;
	private FinderPath _finderPathCountByCrf;

	/**
	 * Returns all the structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the matching structured datas
	 */
	@Override
	public List<StructuredData> findByCrf(long crfId) {
		return findByCrf(crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCrf(long crfId, int start, int end) {
		return findByCrf(crfId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCrf(
		long crfId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return findByCrf(crfId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCrf(
		long crfId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCrf;
				finderArgs = new Object[] {crfId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCrf;
			finderArgs = new Object[] {crfId, start, end, orderByComparator};
		}

		List<StructuredData> list = null;

		if (useFinderCache) {
			list = (List<StructuredData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StructuredData structuredData : list) {
					if (crfId != structuredData.getCrfId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_CRF_CRFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				list = (List<StructuredData>)QueryUtil.list(
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
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findByCrf_First(
			long crfId, OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchByCrf_First(
			crfId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchByCrf_First(
		long crfId, OrderByComparator<StructuredData> orderByComparator) {

		List<StructuredData> list = findByCrf(crfId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findByCrf_Last(
			long crfId, OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchByCrf_Last(
			crfId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchByCrf_Last(
		long crfId, OrderByComparator<StructuredData> orderByComparator) {

		int count = countByCrf(crfId);

		if (count == 0) {
			return null;
		}

		List<StructuredData> list = findByCrf(
			crfId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where crfId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param crfId the crf ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData[] findByCrf_PrevAndNext(
			long structuredDataId, long crfId,
			OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = findByPrimaryKey(structuredDataId);

		Session session = null;

		try {
			session = openSession();

			StructuredData[] array = new StructuredDataImpl[3];

			array[0] = getByCrf_PrevAndNext(
				session, structuredData, crfId, orderByComparator, true);

			array[1] = structuredData;

			array[2] = getByCrf_PrevAndNext(
				session, structuredData, crfId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StructuredData getByCrf_PrevAndNext(
		Session session, StructuredData structuredData, long crfId,
		OrderByComparator<StructuredData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

		sb.append(_FINDER_COLUMN_CRF_CRFID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(crfId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						structuredData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StructuredData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the structured datas where crfId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 */
	@Override
	public void removeByCrf(long crfId) {
		for (StructuredData structuredData :
				findByCrf(crfId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(structuredData);
		}
	}

	/**
	 * Returns the number of structured datas where crfId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @return the number of matching structured datas
	 */
	@Override
	public int countByCrf(long crfId) {
		FinderPath finderPath = _finderPathCountByCrf;

		Object[] finderArgs = new Object[] {crfId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_CRF_CRFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CRF_CRFID_2 =
		"structuredData.crfId = ?";

	private FinderPath _finderPathWithPaginationFindBypatientId;
	private FinderPath _finderPathWithoutPaginationFindBypatientId;
	private FinderPath _finderPathCountBypatientId;

	/**
	 * Returns all the structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	@Override
	public List<StructuredData> findBypatientId(long patientId) {
		return findBypatientId(
			patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	@Override
	public List<StructuredData> findBypatientId(
		long patientId, int start, int end) {

		return findBypatientId(patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return findBypatientId(patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structured datas where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findBypatientId(
		long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypatientId;
				finderArgs = new Object[] {patientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypatientId;
			finderArgs = new Object[] {
				patientId, start, end, orderByComparator
			};
		}

		List<StructuredData> list = null;

		if (useFinderCache) {
			list = (List<StructuredData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StructuredData structuredData : list) {
					if (patientId != structuredData.getPatientId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientId);

				list = (List<StructuredData>)QueryUtil.list(
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
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findBypatientId_First(
			long patientId, OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchBypatientId_First(
			patientId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the first structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchBypatientId_First(
		long patientId, OrderByComparator<StructuredData> orderByComparator) {

		List<StructuredData> list = findBypatientId(
			patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findBypatientId_Last(
			long patientId, OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchBypatientId_Last(
			patientId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the last structured data in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchBypatientId_Last(
		long patientId, OrderByComparator<StructuredData> orderByComparator) {

		int count = countBypatientId(patientId);

		if (count == 0) {
			return null;
		}

		List<StructuredData> list = findBypatientId(
			patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where patientId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData[] findBypatientId_PrevAndNext(
			long structuredDataId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = findByPrimaryKey(structuredDataId);

		Session session = null;

		try {
			session = openSession();

			StructuredData[] array = new StructuredDataImpl[3];

			array[0] = getBypatientId_PrevAndNext(
				session, structuredData, patientId, orderByComparator, true);

			array[1] = structuredData;

			array[2] = getBypatientId_PrevAndNext(
				session, structuredData, patientId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StructuredData getBypatientId_PrevAndNext(
		Session session, StructuredData structuredData, long patientId,
		OrderByComparator<StructuredData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

		sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(patientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						structuredData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StructuredData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the structured datas where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	@Override
	public void removeBypatientId(long patientId) {
		for (StructuredData structuredData :
				findBypatientId(
					patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(structuredData);
		}
	}

	/**
	 * Returns the number of structured datas where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	@Override
	public int countBypatientId(long patientId) {
		FinderPath finderPath = _finderPathCountBypatientId;

		Object[] finderArgs = new Object[] {patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(patientId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PATIENTID_PATIENTID_2 =
		"structuredData.patientId = ?";

	private FinderPath _finderPathWithPaginationFindByCP;
	private FinderPath _finderPathWithoutPaginationFindByCP;
	private FinderPath _finderPathCountByCP;

	/**
	 * Returns all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the matching structured datas
	 */
	@Override
	public List<StructuredData> findByCP(long crfId, long patientId) {
		return findByCP(
			crfId, patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end) {

		return findByCP(crfId, patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return findByCP(crfId, patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching structured datas
	 */
	@Override
	public List<StructuredData> findByCP(
		long crfId, long patientId, int start, int end,
		OrderByComparator<StructuredData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCP;
				finderArgs = new Object[] {crfId, patientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCP;
			finderArgs = new Object[] {
				crfId, patientId, start, end, orderByComparator
			};
		}

		List<StructuredData> list = null;

		if (useFinderCache) {
			list = (List<StructuredData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StructuredData structuredData : list) {
					if ((crfId != structuredData.getCrfId()) ||
						(patientId != structuredData.getPatientId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_CP_CRFID_2);

			sb.append(_FINDER_COLUMN_CP_PATIENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(patientId);

				list = (List<StructuredData>)QueryUtil.list(
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
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findByCP_First(
			long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchByCP_First(
			crfId, patientId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the first structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchByCP_First(
		long crfId, long patientId,
		OrderByComparator<StructuredData> orderByComparator) {

		List<StructuredData> list = findByCP(
			crfId, patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data
	 * @throws NoSuchStructuredDataException if a matching structured data could not be found
	 */
	@Override
	public StructuredData findByCP_Last(
			long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchByCP_Last(
			crfId, patientId, orderByComparator);

		if (structuredData != null) {
			return structuredData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crfId=");
		sb.append(crfId);

		sb.append(", patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchStructuredDataException(sb.toString());
	}

	/**
	 * Returns the last structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching structured data, or <code>null</code> if a matching structured data could not be found
	 */
	@Override
	public StructuredData fetchByCP_Last(
		long crfId, long patientId,
		OrderByComparator<StructuredData> orderByComparator) {

		int count = countByCP(crfId, patientId);

		if (count == 0) {
			return null;
		}

		List<StructuredData> list = findByCP(
			crfId, patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the structured datas before and after the current structured data in the ordered set where crfId = &#63; and patientId = &#63;.
	 *
	 * @param structuredDataId the primary key of the current structured data
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData[] findByCP_PrevAndNext(
			long structuredDataId, long crfId, long patientId,
			OrderByComparator<StructuredData> orderByComparator)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = findByPrimaryKey(structuredDataId);

		Session session = null;

		try {
			session = openSession();

			StructuredData[] array = new StructuredDataImpl[3];

			array[0] = getByCP_PrevAndNext(
				session, structuredData, crfId, patientId, orderByComparator,
				true);

			array[1] = structuredData;

			array[2] = getByCP_PrevAndNext(
				session, structuredData, crfId, patientId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StructuredData getByCP_PrevAndNext(
		Session session, StructuredData structuredData, long crfId,
		long patientId, OrderByComparator<StructuredData> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STRUCTUREDDATA_WHERE);

		sb.append(_FINDER_COLUMN_CP_CRFID_2);

		sb.append(_FINDER_COLUMN_CP_PATIENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StructuredDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(crfId);

		queryPos.add(patientId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						structuredData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StructuredData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the structured datas where crfId = &#63; and patientId = &#63; from the database.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 */
	@Override
	public void removeByCP(long crfId, long patientId) {
		for (StructuredData structuredData :
				findByCP(
					crfId, patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(structuredData);
		}
	}

	/**
	 * Returns the number of structured datas where crfId = &#63; and patientId = &#63;.
	 *
	 * @param crfId the crf ID
	 * @param patientId the patient ID
	 * @return the number of matching structured datas
	 */
	@Override
	public int countByCP(long crfId, long patientId) {
		FinderPath finderPath = _finderPathCountByCP;

		Object[] finderArgs = new Object[] {crfId, patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STRUCTUREDDATA_WHERE);

			sb.append(_FINDER_COLUMN_CP_CRFID_2);

			sb.append(_FINDER_COLUMN_CP_PATIENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crfId);

				queryPos.add(patientId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CP_CRFID_2 =
		"structuredData.crfId = ? AND ";

	private static final String _FINDER_COLUMN_CP_PATIENTID_2 =
		"structuredData.patientId = ?";

	public StructuredDataPersistenceImpl() {
		setModelClass(StructuredData.class);

		setModelImplClass(StructuredDataImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the structured data in the entity cache if it is enabled.
	 *
	 * @param structuredData the structured data
	 */
	@Override
	public void cacheResult(StructuredData structuredData) {
		entityCache.putResult(
			entityCacheEnabled, StructuredDataImpl.class,
			structuredData.getPrimaryKey(), structuredData);

		structuredData.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the structured datas in the entity cache if it is enabled.
	 *
	 * @param structuredDatas the structured datas
	 */
	@Override
	public void cacheResult(List<StructuredData> structuredDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (structuredDatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (StructuredData structuredData : structuredDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, StructuredDataImpl.class,
					structuredData.getPrimaryKey()) == null) {

				cacheResult(structuredData);
			}
			else {
				structuredData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all structured datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StructuredDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the structured data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StructuredData structuredData) {
		entityCache.removeResult(
			entityCacheEnabled, StructuredDataImpl.class,
			structuredData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StructuredData> structuredDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StructuredData structuredData : structuredDatas) {
			entityCache.removeResult(
				entityCacheEnabled, StructuredDataImpl.class,
				structuredData.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, StructuredDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new structured data with the primary key. Does not add the structured data to the database.
	 *
	 * @param structuredDataId the primary key for the new structured data
	 * @return the new structured data
	 */
	@Override
	public StructuredData create(long structuredDataId) {
		StructuredData structuredData = new StructuredDataImpl();

		structuredData.setNew(true);
		structuredData.setPrimaryKey(structuredDataId);

		structuredData.setCompanyId(CompanyThreadLocal.getCompanyId());

		return structuredData;
	}

	/**
	 * Removes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData remove(long structuredDataId)
		throws NoSuchStructuredDataException {

		return remove((Serializable)structuredDataId);
	}

	/**
	 * Removes the structured data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the structured data
	 * @return the structured data that was removed
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData remove(Serializable primaryKey)
		throws NoSuchStructuredDataException {

		Session session = null;

		try {
			session = openSession();

			StructuredData structuredData = (StructuredData)session.get(
				StructuredDataImpl.class, primaryKey);

			if (structuredData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStructuredDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(structuredData);
		}
		catch (NoSuchStructuredDataException noSuchEntityException) {
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
	protected StructuredData removeImpl(StructuredData structuredData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(structuredData)) {
				structuredData = (StructuredData)session.get(
					StructuredDataImpl.class,
					structuredData.getPrimaryKeyObj());
			}

			if (structuredData != null) {
				session.delete(structuredData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (structuredData != null) {
			clearCache(structuredData);
		}

		return structuredData;
	}

	@Override
	public StructuredData updateImpl(StructuredData structuredData) {
		boolean isNew = structuredData.isNew();

		if (!(structuredData instanceof StructuredDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(structuredData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					structuredData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in structuredData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StructuredData implementation " +
					structuredData.getClass());
		}

		StructuredDataModelImpl structuredDataModelImpl =
			(StructuredDataModelImpl)structuredData;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (structuredData.getCreateDate() == null)) {
			if (serviceContext == null) {
				structuredData.setCreateDate(date);
			}
			else {
				structuredData.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!structuredDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				structuredData.setModifiedDate(date);
			}
			else {
				structuredData.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(structuredData);

				structuredData.setNew(false);
			}
			else {
				structuredData = (StructuredData)session.merge(structuredData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {structuredDataModelImpl.getCrfId()};

			finderCache.removeResult(_finderPathCountByCrf, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCrf, args);

			args = new Object[] {structuredDataModelImpl.getPatientId()};

			finderCache.removeResult(_finderPathCountBypatientId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBypatientId, args);

			args = new Object[] {
				structuredDataModelImpl.getCrfId(),
				structuredDataModelImpl.getPatientId()
			};

			finderCache.removeResult(_finderPathCountByCP, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCP, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((structuredDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCrf.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					structuredDataModelImpl.getOriginalCrfId()
				};

				finderCache.removeResult(_finderPathCountByCrf, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCrf, args);

				args = new Object[] {structuredDataModelImpl.getCrfId()};

				finderCache.removeResult(_finderPathCountByCrf, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCrf, args);
			}

			if ((structuredDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBypatientId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					structuredDataModelImpl.getOriginalPatientId()
				};

				finderCache.removeResult(_finderPathCountBypatientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypatientId, args);

				args = new Object[] {structuredDataModelImpl.getPatientId()};

				finderCache.removeResult(_finderPathCountBypatientId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypatientId, args);
			}

			if ((structuredDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCP.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					structuredDataModelImpl.getOriginalCrfId(),
					structuredDataModelImpl.getOriginalPatientId()
				};

				finderCache.removeResult(_finderPathCountByCP, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCP, args);

				args = new Object[] {
					structuredDataModelImpl.getCrfId(),
					structuredDataModelImpl.getPatientId()
				};

				finderCache.removeResult(_finderPathCountByCP, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCP, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, StructuredDataImpl.class,
			structuredData.getPrimaryKey(), structuredData, false);

		structuredData.resetOriginalValues();

		return structuredData;
	}

	/**
	 * Returns the structured data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the structured data
	 * @return the structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStructuredDataException {

		StructuredData structuredData = fetchByPrimaryKey(primaryKey);

		if (structuredData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStructuredDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return structuredData;
	}

	/**
	 * Returns the structured data with the primary key or throws a <code>NoSuchStructuredDataException</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data
	 * @throws NoSuchStructuredDataException if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData findByPrimaryKey(long structuredDataId)
		throws NoSuchStructuredDataException {

		return findByPrimaryKey((Serializable)structuredDataId);
	}

	/**
	 * Returns the structured data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param structuredDataId the primary key of the structured data
	 * @return the structured data, or <code>null</code> if a structured data with the primary key could not be found
	 */
	@Override
	public StructuredData fetchByPrimaryKey(long structuredDataId) {
		return fetchByPrimaryKey((Serializable)structuredDataId);
	}

	/**
	 * Returns all the structured datas.
	 *
	 * @return the structured datas
	 */
	@Override
	public List<StructuredData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @return the range of structured datas
	 */
	@Override
	public List<StructuredData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of structured datas
	 */
	@Override
	public List<StructuredData> findAll(
		int start, int end,
		OrderByComparator<StructuredData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the structured datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StructuredDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of structured datas
	 * @param end the upper bound of the range of structured datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of structured datas
	 */
	@Override
	public List<StructuredData> findAll(
		int start, int end, OrderByComparator<StructuredData> orderByComparator,
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

		List<StructuredData> list = null;

		if (useFinderCache) {
			list = (List<StructuredData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STRUCTUREDDATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STRUCTUREDDATA;

				sql = sql.concat(StructuredDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StructuredData>)QueryUtil.list(
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
	 * Removes all the structured datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StructuredData structuredData : findAll()) {
			remove(structuredData);
		}
	}

	/**
	 * Returns the number of structured datas.
	 *
	 * @return the number of structured datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STRUCTUREDDATA);

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
		return "structuredDataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STRUCTUREDDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StructuredDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the structured data persistence.
	 */
	@Activate
	public void activate() {
		StructuredDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		StructuredDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCrf = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCrf",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCrf = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCrf",
			new String[] {Long.class.getName()},
			StructuredDataModelImpl.CRFID_COLUMN_BITMASK);

		_finderPathCountByCrf = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCrf",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBypatientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypatientId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBypatientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypatientId",
			new String[] {Long.class.getName()},
			StructuredDataModelImpl.PATIENTID_COLUMN_BITMASK);

		_finderPathCountBypatientId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypatientId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCP = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCP",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCP = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, StructuredDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCP",
			new String[] {Long.class.getName(), Long.class.getName()},
			StructuredDataModelImpl.CRFID_COLUMN_BITMASK |
			StructuredDataModelImpl.PATIENTID_COLUMN_BITMASK);

		_finderPathCountByCP = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCP",
			new String[] {Long.class.getName(), Long.class.getName()});

		_setStructuredDataUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStructuredDataUtilPersistence(null);

		entityCache.removeCache(StructuredDataImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setStructuredDataUtilPersistence(
		StructuredDataPersistence structuredDataPersistence) {

		try {
			Field field = StructuredDataUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, structuredDataPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.StructuredData"),
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

	private static final String _SQL_SELECT_STRUCTUREDDATA =
		"SELECT structuredData FROM StructuredData structuredData";

	private static final String _SQL_SELECT_STRUCTUREDDATA_WHERE =
		"SELECT structuredData FROM StructuredData structuredData WHERE ";

	private static final String _SQL_COUNT_STRUCTUREDDATA =
		"SELECT COUNT(structuredData) FROM StructuredData structuredData";

	private static final String _SQL_COUNT_STRUCTUREDDATA_WHERE =
		"SELECT COUNT(structuredData) FROM StructuredData structuredData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "structuredData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StructuredData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StructuredData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StructuredDataPersistenceImpl.class);

}