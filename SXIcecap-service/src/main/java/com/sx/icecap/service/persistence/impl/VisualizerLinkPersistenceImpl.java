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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.sx.icecap.exception.NoSuchVisualizerLinkException;
import com.sx.icecap.model.VisualizerLink;
import com.sx.icecap.model.impl.VisualizerLinkImpl;
import com.sx.icecap.model.impl.VisualizerLinkModelImpl;
import com.sx.icecap.service.persistence.VisualizerLinkPersistence;
import com.sx.icecap.service.persistence.VisualizerLinkUtil;
import com.sx.icecap.service.persistence.impl.constants.SX_ICECAPPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the visualizer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VisualizerLinkPersistence.class)
public class VisualizerLinkPersistenceImpl
	extends BasePersistenceImpl<VisualizerLink>
	implements VisualizerLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VisualizerLinkUtil</code> to access the visualizer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VisualizerLinkImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByDataTypeId;
	private FinderPath _finderPathWithoutPaginationFindByDataTypeId;
	private FinderPath _finderPathCountByDataTypeId;

	/**
	 * Returns all the visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByDataTypeId(long dataTypeId) {
		return findByDataTypeId(
			dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end) {

		return findByDataTypeId(dataTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return findByDataTypeId(
			dataTypeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visualizer links where dataTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param dataTypeId the data type ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByDataTypeId(
		long dataTypeId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDataTypeId;
				finderArgs = new Object[] {dataTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDataTypeId;
			finderArgs = new Object[] {
				dataTypeId, start, end, orderByComparator
			};
		}

		List<VisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<VisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisualizerLink visualizerLink : list) {
					if (dataTypeId != visualizerLink.getDataTypeId()) {
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

			sb.append(_SQL_SELECT_VISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

				list = (List<VisualizerLink>)QueryUtil.list(
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
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink findByDataTypeId_First(
			long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = fetchByDataTypeId_First(
			dataTypeId, orderByComparator);

		if (visualizerLink != null) {
			return visualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink fetchByDataTypeId_First(
		long dataTypeId, OrderByComparator<VisualizerLink> orderByComparator) {

		List<VisualizerLink> list = findByDataTypeId(
			dataTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink findByDataTypeId_Last(
			long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = fetchByDataTypeId_Last(
			dataTypeId, orderByComparator);

		if (visualizerLink != null) {
			return visualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dataTypeId=");
		sb.append(dataTypeId);

		sb.append("}");

		throw new NoSuchVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink fetchByDataTypeId_Last(
		long dataTypeId, OrderByComparator<VisualizerLink> orderByComparator) {

		int count = countByDataTypeId(dataTypeId);

		if (count == 0) {
			return null;
		}

		List<VisualizerLink> list = findByDataTypeId(
			dataTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where dataTypeId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param dataTypeId the data type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink[] findByDataTypeId_PrevAndNext(
			long VisualizerLink, long dataTypeId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = findByPrimaryKey(VisualizerLink);

		Session session = null;

		try {
			session = openSession();

			VisualizerLink[] array = new VisualizerLinkImpl[3];

			array[0] = getByDataTypeId_PrevAndNext(
				session, visualizerLink, dataTypeId, orderByComparator, true);

			array[1] = visualizerLink;

			array[2] = getByDataTypeId_PrevAndNext(
				session, visualizerLink, dataTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected VisualizerLink getByDataTypeId_PrevAndNext(
		Session session, VisualizerLink visualizerLink, long dataTypeId,
		OrderByComparator<VisualizerLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

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
			sb.append(VisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dataTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						visualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visualizer links where dataTypeId = &#63; from the database.
	 *
	 * @param dataTypeId the data type ID
	 */
	@Override
	public void removeByDataTypeId(long dataTypeId) {
		for (VisualizerLink visualizerLink :
				findByDataTypeId(
					dataTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visualizerLink);
		}
	}

	/**
	 * Returns the number of visualizer links where dataTypeId = &#63;.
	 *
	 * @param dataTypeId the data type ID
	 * @return the number of matching visualizer links
	 */
	@Override
	public int countByDataTypeId(long dataTypeId) {
		FinderPath finderPath = _finderPathCountByDataTypeId;

		Object[] finderArgs = new Object[] {dataTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_DATATYPEID_DATATYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dataTypeId);

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

	private static final String _FINDER_COLUMN_DATATYPEID_DATATYPEID_2 =
		"visualizerLink.dataTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByVisualizerId;
	private FinderPath _finderPathWithoutPaginationFindByVisualizerId;
	private FinderPath _finderPathCountByVisualizerId;

	/**
	 * Returns all the visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByVisualizerId(long visualizerId) {
		return findByVisualizerId(
			visualizerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end) {

		return findByVisualizerId(visualizerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return findByVisualizerId(
			visualizerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visualizer links where visualizerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param visualizerId the visualizer ID
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visualizer links
	 */
	@Override
	public List<VisualizerLink> findByVisualizerId(
		long visualizerId, int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVisualizerId;
				finderArgs = new Object[] {visualizerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVisualizerId;
			finderArgs = new Object[] {
				visualizerId, start, end, orderByComparator
			};
		}

		List<VisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<VisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (VisualizerLink visualizerLink : list) {
					if (visualizerId != visualizerLink.getVisualizerId()) {
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

			sb.append(_SQL_SELECT_VISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(visualizerId);

				list = (List<VisualizerLink>)QueryUtil.list(
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
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink findByVisualizerId_First(
			long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = fetchByVisualizerId_First(
			visualizerId, orderByComparator);

		if (visualizerLink != null) {
			return visualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerId=");
		sb.append(visualizerId);

		sb.append("}");

		throw new NoSuchVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the first visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink fetchByVisualizerId_First(
		long visualizerId,
		OrderByComparator<VisualizerLink> orderByComparator) {

		List<VisualizerLink> list = findByVisualizerId(
			visualizerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link
	 * @throws NoSuchVisualizerLinkException if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink findByVisualizerId_Last(
			long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = fetchByVisualizerId_Last(
			visualizerId, orderByComparator);

		if (visualizerLink != null) {
			return visualizerLink;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("visualizerId=");
		sb.append(visualizerId);

		sb.append("}");

		throw new NoSuchVisualizerLinkException(sb.toString());
	}

	/**
	 * Returns the last visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visualizer link, or <code>null</code> if a matching visualizer link could not be found
	 */
	@Override
	public VisualizerLink fetchByVisualizerId_Last(
		long visualizerId,
		OrderByComparator<VisualizerLink> orderByComparator) {

		int count = countByVisualizerId(visualizerId);

		if (count == 0) {
			return null;
		}

		List<VisualizerLink> list = findByVisualizerId(
			visualizerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visualizer links before and after the current visualizer link in the ordered set where visualizerId = &#63;.
	 *
	 * @param VisualizerLink the primary key of the current visualizer link
	 * @param visualizerId the visualizer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink[] findByVisualizerId_PrevAndNext(
			long VisualizerLink, long visualizerId,
			OrderByComparator<VisualizerLink> orderByComparator)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = findByPrimaryKey(VisualizerLink);

		Session session = null;

		try {
			session = openSession();

			VisualizerLink[] array = new VisualizerLinkImpl[3];

			array[0] = getByVisualizerId_PrevAndNext(
				session, visualizerLink, visualizerId, orderByComparator, true);

			array[1] = visualizerLink;

			array[2] = getByVisualizerId_PrevAndNext(
				session, visualizerLink, visualizerId, orderByComparator,
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

	protected VisualizerLink getByVisualizerId_PrevAndNext(
		Session session, VisualizerLink visualizerLink, long visualizerId,
		OrderByComparator<VisualizerLink> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISUALIZERLINK_WHERE);

		sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

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
			sb.append(VisualizerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(visualizerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						visualizerLink)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<VisualizerLink> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visualizer links where visualizerId = &#63; from the database.
	 *
	 * @param visualizerId the visualizer ID
	 */
	@Override
	public void removeByVisualizerId(long visualizerId) {
		for (VisualizerLink visualizerLink :
				findByVisualizerId(
					visualizerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visualizerLink);
		}
	}

	/**
	 * Returns the number of visualizer links where visualizerId = &#63;.
	 *
	 * @param visualizerId the visualizer ID
	 * @return the number of matching visualizer links
	 */
	@Override
	public int countByVisualizerId(long visualizerId) {
		FinderPath finderPath = _finderPathCountByVisualizerId;

		Object[] finderArgs = new Object[] {visualizerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISUALIZERLINK_WHERE);

			sb.append(_FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(visualizerId);

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

	private static final String _FINDER_COLUMN_VISUALIZERID_VISUALIZERID_2 =
		"visualizerLink.visualizerId = ?";

	public VisualizerLinkPersistenceImpl() {
		setModelClass(VisualizerLink.class);

		setModelImplClass(VisualizerLinkImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the visualizer link in the entity cache if it is enabled.
	 *
	 * @param visualizerLink the visualizer link
	 */
	@Override
	public void cacheResult(VisualizerLink visualizerLink) {
		entityCache.putResult(
			entityCacheEnabled, VisualizerLinkImpl.class,
			visualizerLink.getPrimaryKey(), visualizerLink);

		visualizerLink.resetOriginalValues();
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the visualizer links in the entity cache if it is enabled.
	 *
	 * @param visualizerLinks the visualizer links
	 */
	@Override
	public void cacheResult(List<VisualizerLink> visualizerLinks) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (visualizerLinks.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (VisualizerLink visualizerLink : visualizerLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, VisualizerLinkImpl.class,
					visualizerLink.getPrimaryKey()) == null) {

				cacheResult(visualizerLink);
			}
			else {
				visualizerLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all visualizer links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VisualizerLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the visualizer link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VisualizerLink visualizerLink) {
		entityCache.removeResult(
			entityCacheEnabled, VisualizerLinkImpl.class,
			visualizerLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VisualizerLink> visualizerLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VisualizerLink visualizerLink : visualizerLinks) {
			entityCache.removeResult(
				entityCacheEnabled, VisualizerLinkImpl.class,
				visualizerLink.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, VisualizerLinkImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new visualizer link with the primary key. Does not add the visualizer link to the database.
	 *
	 * @param VisualizerLink the primary key for the new visualizer link
	 * @return the new visualizer link
	 */
	@Override
	public VisualizerLink create(long VisualizerLink) {
		VisualizerLink visualizerLink = new VisualizerLinkImpl();

		visualizerLink.setNew(true);
		visualizerLink.setPrimaryKey(VisualizerLink);

		return visualizerLink;
	}

	/**
	 * Removes the visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link that was removed
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink remove(long VisualizerLink)
		throws NoSuchVisualizerLinkException {

		return remove((Serializable)VisualizerLink);
	}

	/**
	 * Removes the visualizer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visualizer link
	 * @return the visualizer link that was removed
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink remove(Serializable primaryKey)
		throws NoSuchVisualizerLinkException {

		Session session = null;

		try {
			session = openSession();

			VisualizerLink visualizerLink = (VisualizerLink)session.get(
				VisualizerLinkImpl.class, primaryKey);

			if (visualizerLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisualizerLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(visualizerLink);
		}
		catch (NoSuchVisualizerLinkException noSuchEntityException) {
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
	protected VisualizerLink removeImpl(VisualizerLink visualizerLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visualizerLink)) {
				visualizerLink = (VisualizerLink)session.get(
					VisualizerLinkImpl.class,
					visualizerLink.getPrimaryKeyObj());
			}

			if (visualizerLink != null) {
				session.delete(visualizerLink);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (visualizerLink != null) {
			clearCache(visualizerLink);
		}

		return visualizerLink;
	}

	@Override
	public VisualizerLink updateImpl(VisualizerLink visualizerLink) {
		boolean isNew = visualizerLink.isNew();

		if (!(visualizerLink instanceof VisualizerLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(visualizerLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					visualizerLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in visualizerLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom VisualizerLink implementation " +
					visualizerLink.getClass());
		}

		VisualizerLinkModelImpl visualizerLinkModelImpl =
			(VisualizerLinkModelImpl)visualizerLink;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(visualizerLink);

				visualizerLink.setNew(false);
			}
			else {
				visualizerLink = (VisualizerLink)session.merge(visualizerLink);
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
			Object[] args = new Object[] {
				visualizerLinkModelImpl.getDataTypeId()
			};

			finderCache.removeResult(_finderPathCountByDataTypeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByDataTypeId, args);

			args = new Object[] {visualizerLinkModelImpl.getVisualizerId()};

			finderCache.removeResult(_finderPathCountByVisualizerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVisualizerId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((visualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByDataTypeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					visualizerLinkModelImpl.getOriginalDataTypeId()
				};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);

				args = new Object[] {visualizerLinkModelImpl.getDataTypeId()};

				finderCache.removeResult(_finderPathCountByDataTypeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByDataTypeId, args);
			}

			if ((visualizerLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVisualizerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					visualizerLinkModelImpl.getOriginalVisualizerId()
				};

				finderCache.removeResult(_finderPathCountByVisualizerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerId, args);

				args = new Object[] {visualizerLinkModelImpl.getVisualizerId()};

				finderCache.removeResult(_finderPathCountByVisualizerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVisualizerId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, VisualizerLinkImpl.class,
			visualizerLink.getPrimaryKey(), visualizerLink, false);

		visualizerLink.resetOriginalValues();

		return visualizerLink;
	}

	/**
	 * Returns the visualizer link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visualizer link
	 * @return the visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisualizerLinkException {

		VisualizerLink visualizerLink = fetchByPrimaryKey(primaryKey);

		if (visualizerLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisualizerLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return visualizerLink;
	}

	/**
	 * Returns the visualizer link with the primary key or throws a <code>NoSuchVisualizerLinkException</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link
	 * @throws NoSuchVisualizerLinkException if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink findByPrimaryKey(long VisualizerLink)
		throws NoSuchVisualizerLinkException {

		return findByPrimaryKey((Serializable)VisualizerLink);
	}

	/**
	 * Returns the visualizer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param VisualizerLink the primary key of the visualizer link
	 * @return the visualizer link, or <code>null</code> if a visualizer link with the primary key could not be found
	 */
	@Override
	public VisualizerLink fetchByPrimaryKey(long VisualizerLink) {
		return fetchByPrimaryKey((Serializable)VisualizerLink);
	}

	/**
	 * Returns all the visualizer links.
	 *
	 * @return the visualizer links
	 */
	@Override
	public List<VisualizerLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @return the range of visualizer links
	 */
	@Override
	public List<VisualizerLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visualizer links
	 */
	@Override
	public List<VisualizerLink> findAll(
		int start, int end,
		OrderByComparator<VisualizerLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visualizer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisualizerLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visualizer links
	 * @param end the upper bound of the range of visualizer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visualizer links
	 */
	@Override
	public List<VisualizerLink> findAll(
		int start, int end, OrderByComparator<VisualizerLink> orderByComparator,
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

		List<VisualizerLink> list = null;

		if (useFinderCache) {
			list = (List<VisualizerLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VISUALIZERLINK);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VISUALIZERLINK;

				sql = sql.concat(VisualizerLinkModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<VisualizerLink>)QueryUtil.list(
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
	 * Removes all the visualizer links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (VisualizerLink visualizerLink : findAll()) {
			remove(visualizerLink);
		}
	}

	/**
	 * Returns the number of visualizer links.
	 *
	 * @return the number of visualizer links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VISUALIZERLINK);

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
		return "VisualizerLink";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VISUALIZERLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VisualizerLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the visualizer link persistence.
	 */
	@Activate
	public void activate() {
		VisualizerLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		VisualizerLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDataTypeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDataTypeId",
			new String[] {Long.class.getName()},
			VisualizerLinkModelImpl.DATATYPEID_COLUMN_BITMASK);

		_finderPathCountByDataTypeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDataTypeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVisualizerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, VisualizerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVisualizerId",
			new String[] {Long.class.getName()},
			VisualizerLinkModelImpl.VISUALIZERID_COLUMN_BITMASK);

		_finderPathCountByVisualizerId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVisualizerId",
			new String[] {Long.class.getName()});

		_setVisualizerLinkUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVisualizerLinkUtilPersistence(null);

		entityCache.removeCache(VisualizerLinkImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private void _setVisualizerLinkUtilPersistence(
		VisualizerLinkPersistence visualizerLinkPersistence) {

		try {
			Field field = VisualizerLinkUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, visualizerLinkPersistence);
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
				"value.object.column.bitmask.enabled.com.sx.icecap.model.VisualizerLink"),
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

	private static final String _SQL_SELECT_VISUALIZERLINK =
		"SELECT visualizerLink FROM VisualizerLink visualizerLink";

	private static final String _SQL_SELECT_VISUALIZERLINK_WHERE =
		"SELECT visualizerLink FROM VisualizerLink visualizerLink WHERE ";

	private static final String _SQL_COUNT_VISUALIZERLINK =
		"SELECT COUNT(visualizerLink) FROM VisualizerLink visualizerLink";

	private static final String _SQL_COUNT_VISUALIZERLINK_WHERE =
		"SELECT COUNT(visualizerLink) FROM VisualizerLink visualizerLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "visualizerLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No VisualizerLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No VisualizerLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VisualizerLinkPersistenceImpl.class);

}