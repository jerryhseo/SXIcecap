/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the structuredDatas of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sx.icecap.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
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
import com.sx.constant.StationXConstants;
import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.base.StructuredDataLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.StructuredData",
	service = AopService.class
)
public class StructuredDataLocalServiceImpl
	extends StructuredDataLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public StructuredData addStructuredData( 
			long dataSetId, 
			long dataTypeId,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
	
		User user = super.userLocalService.getUser( sc.getUserId() );
		
		Date now = sc.getCreateDate();
		
		long structuredDataId = super.counterLocalService.increment();
		StructuredData structuredData = super.structuredDataPersistence.create(structuredDataId);
		
		structuredData.setCompanyId(sc.getCompanyId());
		structuredData.setGroupId(sc.getScopeGroupId());
		structuredData.setUserId(sc.getUserId());
		structuredData.setUserName(user.getFullName());
		structuredData.setCreateDate(now);
		structuredData.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			structuredData.setStatus(status);
		}
		else {
			structuredData.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		
		structuredData.setStatusByUserId(sc.getUserId());
		structuredData.setStatusByUserName(user.getFullName());
		structuredData.setStatusDate(sc.getModifiedDate(null));

		structuredData.setExpandoBridgeAttributes(sc);

		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		String dataTypeDisplayName = dataType.getDisplayName();
		structuredData.setDataTypeId(dataTypeId);
		structuredData.setDataTypeDisplayName(dataTypeDisplayName);
		
		/* Must implement data set display name save processes and replace the very next codes.
		DataSet dataSet = super.dataSetPersistence.findByPrimaryKey(dataSetId);
		String dataSetDisplayName = dataSet.getDisplayName();
		structuredData.setDataSetId(dataTypeId);
		structuredData.setDataSetDisplayName( dataSetDisplayname );
		 */
		structuredData.setDataSetId(dataTypeId);
		structuredData.setDataSetDisplayName(dataTypeDisplayName);
		
		structuredData.setStructuredData(data);
		
		super.structuredDataPersistence.update(structuredData);
		
		super.resourceLocalService.addResources(
				structuredData.getCompanyId(), 
				structuredData.getGroupId(), 
				structuredData.getUserId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				false, 
				true, 
				true);
		
		super.assetEntryLocalService.updateEntry(
				structuredData.getUserId(), 
				structuredData.getGroupId(), 
				structuredData.getCreateDate(), 
				structuredData.getModifiedDate(),
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				structuredData.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				structuredData.getUserName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				structuredData.getCompanyId(), 
				structuredData.getGroupId(), 
				structuredData.getUserId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData, 
				sc);
		
		return structuredData;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public StructuredData updateStructuredData(
			long structuredDataId, 
			long dataSetId, 
			long dataTypeId, 
			String data,
			int status,
			ServiceContext sc) throws PortalException {
		StructuredData structuredData = super.structuredDataPersistence.findByPrimaryKey(structuredDataId);
		
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		String dataTypeDisplayName = dataType.getDisplayName();
		structuredData.setDataTypeId(dataTypeId);
		structuredData.setDataTypeDisplayName(dataTypeDisplayName);
		
		/* Must implement data set display name save processes and replace the very next codes.
		DataSet dataSet = super.dataSetPersistence.findByPrimaryKey(dataSetId);
		String dataSetDisplayName = dataSet.getDisplayName();
		structuredData.setDataSetId(dataTypeId);
		structuredData.setDataSetDisplayName( dataSetDisplayname );
		 */
		structuredData.setDataSetId(dataTypeId);
		structuredData.setDataSetDisplayName(dataTypeDisplayName);
		
		structuredData.setStructuredData(data);
		
		super.structuredDataPersistence.update(structuredData);
		
		structuredData.setUserId(sc.getUserId());
		structuredData.setGroupId(sc.getScopeGroupId());
		structuredData.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != structuredData.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			structuredData.setStatus(status);
			structuredData.setStatusByUserId(user.getUserId());
			structuredData.setStatusByUserName(user.getFullName());
			structuredData.setStatusDate(new Date());
			statusChanged = true;
		}
		
		structuredData.setExpandoBridgeAttributes(sc);
		
		super.structuredDataPersistence.update(structuredData, sc);
		
		super.resourceLocalService.updateResources(
				structuredData.getCompanyId(),
				structuredData.getGroupId(), 
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				structuredData.getUserId(), 
				structuredData.getGroupId(), 
				structuredData.getCreateDate(), 
				structuredData.getModifiedDate(),
				StructuredData.class.getName(), 
				structuredData.getPrimaryKey(), 
				structuredData.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				structuredData.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				structuredData.getUserName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, true);
			} else {
				super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, false);
			}
		}
		
		return structuredData;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public StructuredData updateStatus(
			long userId, 
			long structuredDataId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		StructuredData structuredData = super.structuredDataPersistence.findByPrimaryKey(structuredDataId);

		structuredData.setStatus(status);
		structuredData.setStatusByUserId(userId);
		structuredData.setStatusByUserName(user.getFullName());
		structuredData.setStatusDate(new Date());

		super.structuredDataPersistence.update(structuredData, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, true);
		} else {
			super.assetEntryLocalService.updateVisible(StructuredData.class.getName(), structuredDataId, false);
		}

		return structuredData;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public StructuredData removeStructuredData( long structuredDataId ) throws PortalException {
		StructuredData structuredData = super.structuredDataPersistence.remove(structuredDataId);
		
		super.assetEntryLocalService.deleteEntry(StructuredData.class.getName(), structuredData.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				structuredData.getCompanyId(), 
				StructuredData.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				structuredData.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				structuredData.getCompanyId(), structuredData.getGroupId(),
			    StructuredData.class.getName(), structuredData.getPrimaryKey());
		
		return structuredData;
	}
	
	public void removeStructuredDatas( long[] structuredDataIds ) throws PortalException {
		for( long structuredDataId : structuredDataIds ) {
			this.removeStructuredData(structuredDataId);
		}
	}
	
	public List<StructuredData> getAllStructuredDatas(){
		return super.structuredDataPersistence.findAll();
	}
	public List<StructuredData> getAllStructuredDatas( int start, int end ){
		return super.structuredDataPersistence.findAll(start, end);
	}
	public List<StructuredData> getAllStructuredDatas( int start, int end, OrderByComparator<StructuredData> comparator){
		return super.structuredDataPersistence.findAll(start, end, comparator);
	}
	public int countAllStructuredDatas() {
		return super.structuredDataPersistence.countAll();
	}
	
	public List<StructuredData> getStructuredDatasByGroupId( long groupId ){
		return super.structuredDataPersistence.findByGroupId(groupId);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end ){
		return super.structuredDataPersistence.findByGroupId(groupId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByGroupId( long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countStructuredDatasByGroupId(long groupId) {
		return super.structuredDataPersistence.countByGroupId(groupId);
	}

	public List<StructuredData> getStructuredDatasByUserId( long userId ){
		return super.structuredDataPersistence.findByUserId(userId);
	}
	public List<StructuredData>  getStructuredDatasByUserId( long userId, int start, int end ){
		return super.structuredDataPersistence.findByUserId(userId, start, end);
	}
	public List<StructuredData>  getStructuredDatasByUserId( long userId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByUserId(userId, start, end, comparator);
	}
	public int countStructuredDatasByUserId(long userId) {
		return super.structuredDataPersistence.countByUserId(userId);
	}

	public List<StructuredData> getStructuredDatasByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll();
		else
			return super.structuredDataPersistence.findByStatus(status);
	}
	public List<StructuredData>  getStructuredDatasByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll(start, end);
		else
			return super.structuredDataPersistence.findByStatus(status, start, end);
	}
	public List<StructuredData>  getStructuredDatasByStatus( int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findAll(start, end, comparator);
		else
			return super.structuredDataPersistence.findByStatus(status, start, end, comparator);
	}
	public int countStructuredDatasByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countAll();
		else
			return super.structuredDataPersistence.countByStatus(status);
	}
	
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status);
	}
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByG_S( long groupId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countStructuredDatasByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByGroupId(groupId);
		else
			return super.structuredDataPersistence.countByG_S(groupId, status);
	}
	
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId);
		else
			return super.structuredDataPersistence.findByU_S(userId, status);
	}
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end);
		else
			return super.structuredDataPersistence.findByU_S(userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByU_S( long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByUserId(userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countStructuredDatasByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByUserId(userId);
		else
			return super.structuredDataPersistence.countByU_S(userId, status);
	}
	
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status);
	}
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId, start, end);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<StructuredData> getStructuredDatasByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<StructuredData> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.structuredDataPersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countStructuredDatasByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.structuredDataPersistence.countByG_U(groupId, userId);
		else
			return super.structuredDataPersistence.countByG_U_S(groupId, userId, status);
	}
	
	public List<StructuredData> getApprovedStructuredDatas( long groupId ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<StructuredData> getApprovedStructuredDatas( long groupId, int start, int end ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<StructuredData> getApprovedStructuredDatas( long groupId, int start, int end, OrderByComparator<StructuredData> comparator ){
		return super.structuredDataPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedStructuredDatas( long groupId ) {
		return super.structuredDataPersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<StructuredData> searchContainer)
		throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
			StructuredData.class.getName(), searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(searchContainer.getOrderByCol());
		assetEntryQuery.setOrderByType1(searchContainer.getOrderByType());
		
		System.out.println("StructuredDataLocalService.getSearchContainerResults Type: "+searchContainer.getOrderByType());
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(searchContainer.getEnd());
		assetEntryQuery.setStart(searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
			assetEntryQuery);

		return new SearchContainerResults<AssetEntry>(assetEntries, total);
	}
}