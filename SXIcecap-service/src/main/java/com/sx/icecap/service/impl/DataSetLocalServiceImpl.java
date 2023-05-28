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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.icecap.exception.InvalidDataSetNameException;
import com.sx.icecap.exception.NoSuchDataSetException;
import com.sx.icecap.model.DataSet;
import com.sx.icecap.service.base.DataSetLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataSet",
	service = AopService.class
)
public class DataSetLocalServiceImpl extends DataSetLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public DataSet addDataSet(
		String dataSetName,
		String dataSetVersion,
		Map<Locale, String> displayNameMap,
		Map<Locale, String> descriptionMap,
		int status,
		ServiceContext sc ) throws PortalException {
	
		if( !_verifyDataSetName(dataSetName) ) {
			throw new InvalidDataSetNameException(dataSetName+" "+dataSetVersion+" Invalid"); 
		}
		
		long dataSetId = super.counterLocalService.increment();
		DataSet dataSet = super.dataSetLocalService.createDataSet(dataSetId);
		
		dataSet.setDataSetName(dataSetName);
		dataSet.setDataSetVersion(dataSetVersion);
		dataSet.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataSet.setDescriptionMap(descriptionMap, sc.getLocale());
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		dataSet.setCompanyId(sc.getCompanyId());
		dataSet.setGroupId(sc.getScopeGroupId());
		dataSet.setUserId(user.getUserId());
		dataSet.setUserName(user.getFullName());
		dataSet.setCreateDate(now);
		dataSet.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataSet.setStatus(status);
		}
		else {
			dataSet.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataSet.setStatusByUserId(sc.getUserId());
		dataSet.setStatusByUserName(user.getFullName());
		dataSet.setStatusDate(sc.getModifiedDate(null));
		
		dataSet.setExpandoBridgeAttributes(sc);
		
		super.dataSetPersistence.update(dataSet, sc);
	//		System.out.println("Add Finished....");
		
		super.resourceLocalService.addResources(
				dataSet.getCompanyId(), 
				dataSet.getGroupId(), 
				dataSet.getUserId(), 
				DataSet.class.getName(), 
				dataSet.getPrimaryKey(), 
				false, 
				true, 
				true);
	//		System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataSet.getUserId(), 
			dataSet.getGroupId(), 
			dataSet.getCreateDate(), 
			dataSet.getModifiedDate(),
			DataSet.class.getName(), 
			dataSet.getPrimaryKey(), 
			dataSet.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataSet.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataSet.getDataSetName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataSet.getCompanyId(), 
				dataSet.getGroupId(), 
				dataSet.getUserId(), 
				DataSet.class.getName(), 
				dataSet.getPrimaryKey(), 
				dataSet, 
				sc);
		
		return dataSet;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataSet updateDataSet(
			long dataSetId, 
			String dataSetName, 
			String dataSetVersion,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			int status,
			ServiceContext sc) throws PortalException {
		DataSet dataSet = super.dataSetPersistence.findByPrimaryKey(dataSetId);
		
		dataSet.setDataSetName(dataSetName);
		dataSet.setDataSetVersion(dataSetVersion);
		dataSet.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataSet.setDescriptionMap(descriptionMap, sc.getLocale());
		
		dataSet.setUserId(sc.getUserId());
		dataSet.setGroupId(sc.getScopeGroupId());
		dataSet.setModifiedDate(new Date() );
	
		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataSet.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			dataSet.setStatus(status);
			dataSet.setStatusByUserId(user.getUserId());
			dataSet.setStatusByUserName(user.getFullName());
			dataSet.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataSet.setExpandoBridgeAttributes(sc);
		
		super.dataSetPersistence.update(dataSet, sc);
		
		super.resourceLocalService.updateResources(
				dataSet.getCompanyId(),
				dataSet.getGroupId(), 
				DataSet.class.getName(), 
				dataSet.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataSet.getUserId(), 
				dataSet.getGroupId(), 
				dataSet.getCreateDate(), 
				dataSet.getModifiedDate(),
				DataSet.class.getName(), 
				dataSet.getPrimaryKey(), 
				dataSet.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataSet.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataSet.getDataSetName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataSet.class.getName(), dataSetId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataSet.class.getName(), dataSetId, false);
			}
		}
		
		return dataSet;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataSet updateStatus(
			long userId, 
			long dataSetId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {
	
		User user = userLocalService.getUser(userId);
		DataSet dataSet = super.dataSetPersistence.findByPrimaryKey(dataSetId);
	
		dataSet.setStatus(status);
		dataSet.setStatusByUserId(userId);
		dataSet.setStatusByUserName(user.getFullName());
		dataSet.setStatusDate(new Date());
	
		super.dataSetPersistence.update(dataSet, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(DataSet.class.getName(), dataSetId, true);
		} else {
			super.assetEntryLocalService.updateVisible(DataSet.class.getName(), dataSetId, false);
		}
	
		return dataSet;
	}

	@Indexable(type = IndexableType.DELETE)
	public DataSet removeDataSet( long dataSetId ) throws PortalException {
		DataSet dataSet = super.dataSetPersistence.remove(dataSetId);
		
		try {
			super.dataSetPersistence.remove(dataSetId);
		}
		catch( NoSuchDataSetException e) {
		}
		
		super.assetEntryLocalService.deleteEntry(DataSet.class.getName(), dataSet.getPrimaryKey());
	
		super.resourceLocalService.deleteResource(
				dataSet.getCompanyId(), 
				DataSet.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataSet.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataSet.getCompanyId(), dataSet.getGroupId(),
			    DataSet.class.getName(), dataSet.getDataSetId());
		
		return dataSet;
	}
	
	public void removeDataSets( long[] dataSetIds ) throws PortalException {
		for( long dataSetId : dataSetIds ) {
			this.removeDataSet(dataSetId);
		}
	}
	
	public List<DataSet> getAllDataSets(){
		return super.dataSetPersistence.findAll();
	}
	public List<DataSet> getAllDataSets( int start, int end ){
		return super.dataSetPersistence.findAll(start, end);
	}
	public List<DataSet> getAllDataSets( int start, int end, OrderByComparator<DataSet> comparator){
		return super.dataSetPersistence.findAll(start, end, comparator);
	}
	public int countAllDataSets() {
		return super.dataSetPersistence.countAll();
	}

	public List<DataSet> getDataSetsByGroupId( long groupId ){
		return super.dataSetPersistence.findByGroupId(groupId);
	}
	public List<DataSet>  getDataSetsByGroupId( long groupId, int start, int end ){
		return super.dataSetPersistence.findByGroupId(groupId, start, end);
	}
	public List<DataSet>  getDataSetsByGroupId( long groupId, int start, int end, OrderByComparator<DataSet> comparator ){
		return super.dataSetPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countDataSetsByGroupId(long groupId) {
		return super.dataSetPersistence.countByGroupId(groupId);
	}

	public List<DataSet> getDataSetsByUserId( long userId ){
		return super.dataSetPersistence.findByUserId(userId);
	}
	public List<DataSet>  getDataSetsByUserId( long userId, int start, int end ){
		return super.dataSetPersistence.findByUserId(userId, start, end);
	}
	public List<DataSet>  getDataSetsByUserId( long userId, int start, int end, OrderByComparator<DataSet> comparator ){
		return super.dataSetPersistence.findByUserId(userId, start, end, comparator);
	}
	public int countDataSetsByUserId(long userId) {
		return super.dataSetPersistence.countByUserId(userId);
	}

	public List<DataSet> getDataSetsByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findAll();
		else
			return super.dataSetPersistence.findByStatus(status);
	}
	public List<DataSet>  getDataSetsByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findAll(start, end);
		else
			return super.dataSetPersistence.findByStatus(status, start, end);
	}
	public List<DataSet>  getDataSetsByStatus( int status, int start, int end, OrderByComparator<DataSet> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findAll(start, end, comparator);
		else
			return super.dataSetPersistence.findByStatus(status, start, end, comparator);
	}
	public int countDataSetsByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.countAll();
		else
			return super.dataSetPersistence.countByStatus(status);
	}

	public List<DataSet> getDataSetsByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByGroupId(groupId);
		else
			return super.dataSetPersistence.findByG_S(groupId, status);
	}
	public List<DataSet> getDataSetsByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByGroupId(groupId, start, end);
		else
			return super.dataSetPersistence.findByG_S(groupId, status, start, end);
	}
	public List<DataSet> getDataSetsByG_S( long groupId, int status, int start, int end, OrderByComparator<DataSet> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.dataSetPersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countDataSetsByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.countByGroupId(groupId);
		else
			return super.dataSetPersistence.countByG_S(groupId, status);
	}
	
	public List<DataSet> getDataSetsByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByUserId(userId);
		else
			return super.dataSetPersistence.findByU_S(userId, status);
	}
	public List<DataSet> getDataSetsByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByUserId(userId, start, end);
		else
			return super.dataSetPersistence.findByU_S(userId, status, start, end);
	}
	public List<DataSet> getDataSetsByU_S( long userId, int status, int start, int end, OrderByComparator<DataSet> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByUserId(userId, start, end, comparator);
		else
			return super.dataSetPersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countDataSetsByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.countByUserId(userId);
		else
			return super.dataSetPersistence.countByU_S(userId, status);
	}
	
	public List<DataSet> getDataSetsByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByG_U(groupId, userId);
		else
			return super.dataSetPersistence.findByG_U_S(groupId, userId, status);
	}
	public List<DataSet> getDataSetsByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByG_U(groupId, userId, start, end);
		else
			return super.dataSetPersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<DataSet> getDataSetsByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<DataSet> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.dataSetPersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countDataSetsByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataSetPersistence.countByG_U(groupId, userId);
		else
			return super.dataSetPersistence.countByG_U_S(groupId, userId, status);
	}
	
	public List<DataSet> getApprovedDataSets( long groupId ){
		return super.dataSetPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<DataSet> getApprovedDataSets( long groupId, int start, int end ){
		return super.dataSetPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<DataSet> getApprovedDataSets( long groupId, int start, int end, OrderByComparator<DataSet> comparator ){
		return super.dataSetPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedDataSets( long groupId ) {
		return super.dataSetPersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public DataSet getDataSet( String dataSetName, String dataSetVersion ) throws NoSuchDataSetException {
		return super.dataSetPersistence.findByNameVersion(dataSetName, dataSetVersion);
	}
	
	public List<DataSet> getDataSetsByName( String dataSetName ){
		return super.dataSetPersistence.findByName(dataSetName);
	}
	public List<DataSet> getDataSetsByName( String dataSetName, int start, int end ){
		return super.dataSetPersistence.findByName(dataSetName, start, end);
	}
	public List<DataSet> getDataSetsByName( String dataSetName, int start, int end, OrderByComparator<DataSet> comparator ){
		return super.dataSetPersistence.findByName(dataSetName, start, end, comparator);
	}
	public int countDataSetsByName( String dataSetName ){
		return super.dataSetPersistence.countByName(dataSetName);
	}
	
	private boolean _verifyDataSetName( String dataSetName ) {
		
		return true;
	}
}