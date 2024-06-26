/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the dataTypes of the GNU Lesser General Public License as published by the Free
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
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.constant.StationXConstants;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.exception.DuplicatedDataTypeNameException;
import com.sx.icecap.exception.InvalidDataTypeNameException;
import com.sx.icecap.exception.NoSuchDataTypeException;
import com.sx.icecap.exception.NoSuchDataTypeStructureException;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.DataTypeStructure;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalServiceUtil;
import com.sx.icecap.service.base.DataTypeLocalServiceBaseImpl;
import com.sx.icecap.util.comparator.datatype.DataTypeModifiedDateComparator;
import com.sx.icecap.util.comparator.datatype.DataTypeNameComparator;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataType",
	service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {
	
	@Reference
	private DLAppService _dlAppService;
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType addDataType(
			String dataTypeName,
			String dataTypeVersion,
			String extension,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			Map<Locale, String> tooltipMap,
			int status,
			ServiceContext sc) throws PortalException {
		
		if( !_verifyDataTypeName(dataTypeName) ) {
			throw new InvalidDataTypeNameException(dataTypeName+" "+dataTypeVersion+" Invalid"); 
		}
		
		long dataTypeId = super.counterLocalService.increment();
		DataType dataType = super.dataTypeLocalService.createDataType(dataTypeId);
		
		dataType.setDataTypeName(dataTypeName);
		dataType.setDataTypeVersion(dataTypeVersion);
		dataType.setExtension(extension);
		dataType.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataType.setDescriptionMap(descriptionMap, sc.getLocale());
		dataType.setTooltipMap(tooltipMap, sc.getLocale());
		dataType.setHasDataStructure(false);
		
		Date now = new Date();
		User user = super.userLocalService.getUser(sc.getUserId());
		dataType.setCompanyId(sc.getCompanyId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setUserId(user.getUserId());
		dataType.setUserName(user.getFullName());
		dataType.setCreateDate(now);
		dataType.setModifiedDate(now);
		
		if( status > WorkflowConstants.STATUS_ANY ) {
			dataType.setStatus(status);
		}
		else {
			dataType.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		dataType.setStatusByUserId(sc.getUserId());
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(sc.getModifiedDate(null));
		
		dataType.setExpandoBridgeAttributes(sc);
		
		super.dataTypePersistence.update(dataType, sc);
//			System.out.println("Add Finished....");
		
		super.resourceLocalService.addResources(
				dataType.getCompanyId(), 
				dataType.getGroupId(), 
				dataType.getUserId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				false, 
				true, 
				true);
//			System.out.println("Resource Finished....");
		
		super.assetEntryLocalService.updateEntry(
			dataType.getUserId(), 
			dataType.getGroupId(), 
			dataType.getCreateDate(), 
			dataType.getModifiedDate(),
			DataType.class.getName(), 
			dataType.getPrimaryKey(), 
			dataType.getUuid(), 
			0,
			sc.getAssetCategoryIds(), 
			sc.getAssetTagNames(), 
			true,
			true, 
			null, 
			null, 
			dataType.getCreateDate(),
			null, 
			ContentTypes.TEXT_HTML_UTF8, 
			dataType.getDataTypeName(),
			null, 
			null, 
			null, 
			null,
			0, 0, null);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
				dataType.getCompanyId(), 
				dataType.getGroupId(), 
				dataType.getUserId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				dataType, 
				sc);
		
		return dataType;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateDataType(
			long dataTypeId, 
			String dataTypeName, 
			String dataTypeVersion,
			String extension,
			Map<Locale, String> displayNameMap,
			Map<Locale, String> descriptionMap,
			Map<Locale, String> tooltipMap,
			int status,
			ServiceContext sc) throws PortalException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		
		dataType.setDataTypeName(dataTypeName);
		dataType.setDataTypeVersion(dataTypeVersion);
		dataType.setExtension(extension);
		dataType.setDisplayNameMap(displayNameMap, sc.getLocale());
		dataType.setDescriptionMap(descriptionMap, sc.getLocale());
		dataType.setTooltipMap(tooltipMap, sc.getLocale());
		
		dataType.setUserId(sc.getUserId());
		dataType.setGroupId(sc.getScopeGroupId());
		dataType.setModifiedDate(new Date() );

		boolean statusChanged = false;
		if( status > WorkflowConstants.STATUS_ANY && status != dataType.getStatus()) {
			User user = super.userLocalService.getUser(sc.getUserId());
			dataType.setStatus(status);
			dataType.setStatusByUserId(user.getUserId());
			dataType.setStatusByUserName(user.getFullName());
			dataType.setStatusDate(new Date());
			statusChanged = true;
		}
		
		dataType.setExpandoBridgeAttributes(sc);
		
		super.dataTypePersistence.update(dataType, sc);
		
		super.resourceLocalService.updateResources(
				dataType.getCompanyId(),
				dataType.getGroupId(), 
				DataType.class.getName(), 
				dataType.getPrimaryKey(),
				sc.getModelPermissions());
		
		super.assetEntryLocalService.updateEntry(
				dataType.getUserId(), 
				dataType.getGroupId(), 
				dataType.getCreateDate(), 
				dataType.getModifiedDate(),
				DataType.class.getName(), 
				dataType.getPrimaryKey(), 
				dataType.getUuid(), 
				0,
				sc.getAssetCategoryIds(), 
				sc.getAssetTagNames(), 
				true,
				true, 
				null, 
				null, 
				dataType.getCreateDate(),
				null, 
				ContentTypes.TEXT_HTML_UTF8, 
				dataType.getDataTypeName(),
				null, 
				null, 
				null, 
				null,
				0, 0, null);
		
		if( statusChanged ) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, true);
			} else {
				super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, false);
			}
		}
		
		return dataType;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public DataType updateStatus(
			long userId, 
			long dataTypeId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);

		dataType.setStatus(status);
		dataType.setStatusByUserId(userId);
		dataType.setStatusByUserName(user.getFullName());
		dataType.setStatusDate(new Date());

		super.dataTypePersistence.update(dataType, sc);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, true);
		} else {
			super.assetEntryLocalService.updateVisible(DataType.class.getName(), dataTypeId, false);
		}

		return dataType;
	}
	
	@Indexable(type = IndexableType.DELETE)
	public DataType removeDataType( long dataTypeId ) throws PortalException {
		DataType dataType = super.dataTypePersistence.remove(dataTypeId);
		
		try {
			super.dataTypeStructurePersistence.remove(dataTypeId);
		}
		catch( NoSuchDataTypeStructureException e) {
		}
		
		super.assetEntryLocalService.deleteEntry(DataType.class.getName(), dataType.getPrimaryKey());

		super.resourceLocalService.deleteResource(
				dataType.getCompanyId(), 
				DataType.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, 
				dataType.getPrimaryKey());
		
		super.workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
			    dataType.getCompanyId(), dataType.getGroupId(),
			    DataType.class.getName(), dataType.getDataTypeId());
		
		return dataType;
	}
	
	public void removeDataTypes( long[] dataTypeIds ) throws PortalException {
		for( long dataTypeId : dataTypeIds ) {
			this.removeDataType(dataTypeId);
		}
	}
	
	public DataType copyDataType( long dataTypeId, ServiceContext sc ) throws PortalException {
		DataType dataType = super.dataTypePersistence.fetchByPrimaryKey(dataTypeId);
		if( Validator.isNull(dataType) ) {
			throw new PortalException( "Cannot find data type to be copied: " + dataTypeId );
		}
		
		DataType copiedDataType = this.addDataType(
																				dataType.getDataTypeName() + "_copied", 
																				"1.0.0", 
																				dataType.getExtension(), 
																				dataType.getDisplayNameMap(), 
																				dataType.getDescriptionMap(), 
																				dataType.getTooltipMap(), 
																				WorkflowConstants.STATUS_DRAFT, 
																				sc);
		
		if( dataType.isHasDataStructure() ) {
			DataTypeStructure structure = super.dataTypeStructurePersistence.fetchByPrimaryKey(dataTypeId);
			this.setDataTypeStructure( copiedDataType.getPrimaryKey(), structure.getStructure() );
		}
		
		return copiedDataType;
	}
	
	/**
	 *  Set the data structure for the dataType specified by dataTypeId.
	 *  
	 *  @since 1.0
	 *  @see com.sx.icecap.datatype.service
	 *  @author Jerry H. Seo
	 *  @param
	 *  	long Datatype ID
	 *  	String Data Structure
	 *  @throws
	 *  	void
	 *  @return
	 *  	void
	 */
	public void setDataTypeStructure( long dataTypeId, String dataStructure ) {
		
		// Set data structure and update the table
		_setDataTypeStructure(dataTypeId, dataStructure);
		
		// Update the property, hasDataStructure,  of the data type as true
		_updateHasDataStructure( dataTypeId, true );
	}
	
	public void removeDataTypeStructure( long dataTypeId ) {
		try {
			super.dataTypeStructurePersistence.remove(dataTypeId);
		} catch (NoSuchDataTypeStructureException e) {
			System.out.println("Cannot find datatype structure of the datatype, [" + dataTypeId + "], while removing");
		}
		
		_updateHasDataStructure( dataTypeId, false );
	}
	
	public List<DataType> getAllDataTypes(){
		return super.dataTypePersistence.findAll();
	}
	public List<DataType> getAllDataTypes( int start, int end ){
		return super.dataTypePersistence.findAll(start, end);
	}
	public List<DataType> getAllDataTypes( int start, int end, OrderByComparator<DataType> comparator){
		return super.dataTypePersistence.findAll(start, end, comparator);
	}
	public int countAllDataTypes() {
		return super.dataTypePersistence.countAll();
	}
	
	public List<DataType> getDataTypesByGroupId( long groupId ){
		return super.dataTypePersistence.findByGroupId(groupId);
	}
	public List<DataType>  getDataTypesByGroupId( long groupId, int start, int end ){
		return super.dataTypePersistence.findByGroupId(groupId, start, end);
	}
	public List<DataType>  getDataTypesByGroupId( long groupId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByGroupId(groupId, start, end, comparator);
	}
	public int countDataTypesByGroupId(long groupId) {
		return super.dataTypePersistence.countByGroupId(groupId);
	}

	public List<DataType> getDataTypesByUserId( long userId ){
		return super.dataTypePersistence.findByUserId(userId);
	}
	public List<DataType>  getDataTypesByUserId( long userId, int start, int end ){
		return super.dataTypePersistence.findByUserId(userId, start, end);
	}
	public List<DataType>  getDataTypesByUserId( long userId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByUserId(userId, start, end, comparator);
	}
	public int countDataTypesByUserId(long userId) {
		return super.dataTypePersistence.countByUserId(userId);
	}

	public List<DataType> getDataTypesByStatus( int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll();
		else
			return super.dataTypePersistence.findByStatus(status);
	}
	public List<DataType>  getDataTypesByStatus( int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll(start, end);
		else
			return super.dataTypePersistence.findByStatus(status, start, end);
	}
	public List<DataType>  getDataTypesByStatus( int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findAll(start, end, comparator);
		else
			return super.dataTypePersistence.findByStatus(status, start, end, comparator);
	}
	public int countDataTypesByStatus(int status) {
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countAll();
		else
			return super.dataTypePersistence.countByStatus(status);
	}

	public List<DataType> getDataTypesByName( String dataTypeName ){
		return super.dataTypePersistence.findByName(dataTypeName);
	}
	
	public List<DataType> getDataTypesByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId);
		else
			return super.dataTypePersistence.findByG_S(groupId, status);
	}
	public List<DataType> getDataTypesByG_S( long groupId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId, start, end);
		else
			return super.dataTypePersistence.findByG_S(groupId, status, start, end);
	}
	public List<DataType> getDataTypesByG_S( long groupId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByGroupId(groupId, start, end, comparator);
		else
			return super.dataTypePersistence.findByG_S(groupId, status, start, end, comparator);
	}
	public int countDataTypesByG_S( long groupId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByGroupId(groupId);
		else
			return super.dataTypePersistence.countByG_S(groupId, status);
	}
	
	public List<DataType> getDataTypesByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId);
		else
			return super.dataTypePersistence.findByU_S(userId, status);
	}
	public List<DataType> getDataTypesByU_S( long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId, start, end);
		else
			return super.dataTypePersistence.findByU_S(userId, status, start, end);
	}
	public List<DataType> getDataTypesByU_S( long userId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByUserId(userId, start, end, comparator);
		else
			return super.dataTypePersistence.findByU_S(userId, status, start, end, comparator);
	}
	public int countDataTypesByU_S( long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByUserId(userId);
		else
			return super.dataTypePersistence.countByU_S(userId, status);
	}
	
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status);
	}
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status, int start, int end ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId, start, end);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status, start, end);
	}
	public List<DataType> getDataTypesByG_U_S( long groupId, long userId, int status, int start, int end, OrderByComparator<DataType> comparator ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.findByG_U(groupId, userId, start, end, comparator);
		else
			return super.dataTypePersistence.findByG_U_S(groupId, userId, status, start, end, comparator);
	}
	public int countDataTypesByG_U_S( long groupId, long userId, int status ){
		if( status == WorkflowConstants.STATUS_ANY )
			return super.dataTypePersistence.countByG_U(groupId, userId);
		else
			return super.dataTypePersistence.countByG_U_S(groupId, userId, status);
	}
	
	public List<DataType> getApprovedDataTypes( long groupId ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	public List<DataType> getApprovedDataTypes( long groupId, int start, int end ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
	}
	public List<DataType> getApprovedDataTypes( long groupId, int start, int end, OrderByComparator<DataType> comparator ){
		return super.dataTypePersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end, comparator);
	}
	public int countApprovedDataTypes( long groupId ) {
		return super.dataTypePersistence.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
	}
	
	public String getName( long dataTypeId, Locale locale ) throws NoSuchDataTypeException {
		DataType dataType = super.dataTypePersistence.findByPrimaryKey(dataTypeId);
		
		return dataType.getDisplayName(locale);
	}
	
	public OrderByComparator<DataType> getOrderByNameComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = true;

		if (orderByType.equals(StationXConstants.DSC)) {
			orderByAsc = false;
		}

		OrderByComparator<DataType> orderByComparator = null;

		if (orderByCol.equals(IcecapDataTypeAttributes.DATATYPE_NAME)) {
			orderByComparator = new DataTypeNameComparator(orderByAsc);
		}
		else {
			orderByComparator = new DataTypeModifiedDateComparator(orderByAsc);
		}

		return orderByComparator;
	}
	
	public String getDataTypeStructure( long dataTypeId ) throws NoSuchDataTypeStructureException{
			return super.dataTypeStructurePersistence.findByPrimaryKey(dataTypeId).getStructure();
	}
	
	/**
	 * Get data structure as a JSON object.
	 * 
	 *  @return
	 *  	null,	if the data type has no structure
	 *  	JSONObject, if has a proper structure.
	 */
	
	public JSONObject getDataTypeStructureJSONObject( long dataTypeId ) throws JSONException{
		String dataStructureString = "";
		
		try {
			dataStructureString = getDataTypeStructure( dataTypeId );
		} catch (NoSuchDataTypeStructureException e) {
			dataStructureString = "";
		}
		
		JSONObject jsonObject = null;
		if( !dataStructureString.isEmpty() ) {
				jsonObject = JSONFactoryUtil.createJSONObject( dataStructureString );
		}
		
		return jsonObject;
	}
	
	public JSONObject getTermByName( long dataTypeId, String termName ) throws JSONException {
		JSONObject term = null;
		
		JSONObject structure = getDataTypeStructureJSONObject(dataTypeId);
		
		JSONArray terms = structure.getJSONArray("terms");
		
		for( int i=0; i<terms.length(); i++ ) {
			term = terms.getJSONObject(i);
			
			if( termName.equalsIgnoreCase( term.getString("termName")) ) {
				break;
			}
		}
		
		return term;
	}
	
	public StructuredData addStructuredData(
			long dataSetId, 
			long dataTypeId,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
		return StructuredDataLocalServiceUtil.addStructuredData(dataSetId, dataTypeId, data, status, sc);
	}

	public StructuredData updateStructuredData(
			long structuredDataId,
			long dataSetId, 
			long dataTypeId,
			String data,
			int status,
			ServiceContext sc) throws PortalException  {
		return StructuredDataLocalServiceUtil.updateStructuredData(structuredDataId, dataSetId, dataTypeId, data, status, sc);
	}
	
	public StructuredData updateStructuredDataStatus(
			long userId, 
			long structuredDataId, 
			Integer status,
			ServiceContext sc) throws PortalException, SystemException {
		return StructuredDataLocalServiceUtil.updateStatus(userId, structuredDataId, status, sc);
	}
	
	public StructuredData removeStructuredData( long structuredDataId, long dataFileFolderId ) throws PortalException {
		return StructuredDataLocalServiceUtil.removeStructuredData( 
				structuredDataId, dataFileFolderId);
	}
	
	/*
	public void removeStructuredDatas( long[] structuredDataIds ) throws PortalException {
		StructuredDataLocalServiceUtil.removeStructuredDatas(structuredDataIds);
	}
	*/

	public String getStructuredData( long structuredDataId ){
		StructuredData data = super.structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
		return data.getStructuredData();
	}
	
	public List<StructuredData> getStructuredDatas( long dataTypeId ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId);
	}
	public List<StructuredData> getStructuredDatas( long dataTypeId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
	}
	
	public JSONArray getStructuredDatasJSON( long dataTypeId ) {
		List<StructuredData> listDatas = this.getStructuredDatas(dataTypeId);
		
		JSONArray datas = JSONFactoryUtil.createJSONArray( listDatas );
		
		return datas;
	}
	
	public List<StructuredData> performAdvancedSearchOnStructuredData( long dataTypeId, String advancedQuery, int start, int end ) throws JSONException{
		
		JSONObject dataStructure = this.getDataTypeStructureJSONObject(dataTypeId);
		if( Validator.isNull(dataStructure) ) {
			return null;
		}
		
		List<StructuredData> results = new ArrayList<>();
		
		List<StructuredData> allData = getStructuredDatas(dataTypeId);
		JSONObject jsonQuery = JSONFactoryUtil.createJSONObject(advancedQuery);
		String fieldOperator = jsonQuery.getString("fieldOperator");
		JSONObject jsonClauses = jsonQuery.getJSONObject("clauses");
		
		for( int i=0; i<allData.size(); i++ ) {
			StructuredData data = allData.get(i);
			String structuredData = data.getStructuredData();
			JSONObject dataJson = JSONFactoryUtil.createJSONObject( structuredData );
			
			Iterator<String> fieldIter = jsonClauses.keys();
			while( fieldIter.hasNext() ) {
				String field = fieldIter.next();
				
				JSONObject clause = jsonClauses.getJSONObject(field);
				
				String inFieldOperator = clause.getString("operator");
				boolean rangeSearch = clause.getBoolean("searchType");
				
				if( rangeSearch == true ) {
					
				}
				else {
					JSONArray keywords;
				}
			}
		}
		
		try {
			JSONObject query = JSONFactoryUtil.createJSONObject(advancedQuery);
			
			JSONObject andQuery = null;
			if( query.has("and") ) {
				andQuery = query.getJSONObject("and");
				_processAndQuery( allData, dataStructure, andQuery, start, end );
			}
			
			JSONObject orQuery = null;
			if( query.has("or") ) {
				orQuery = query.getJSONObject("or");
				_processOrQuery( allData, dataStructure, orQuery, start, end );
			}
			
			boolean hit = false;
			
			Iterator<String> queryIter = query.keys();
			while( queryIter.hasNext() ) {
				String key = queryIter.next();
				
				String queryVal = query.getString(key);
				
				for( int i=0; i<allData.size(); i++ ) {
					StructuredData structuredData = allData.get(i);
					JSONObject data = JSONFactoryUtil.createJSONObject(structuredData.getStructuredData());
					
				}
				
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	private List<StructuredData> _processAndQuery( List<StructuredData> dataList, JSONObject dataStructure, JSONObject query, int start, int end ) {
		List<StructuredData> results = new ArrayList<>();
		
		int delta =end - start + 1;
		int resultCount = 0;
		
		Iterator<String> queryIter = query.keys();
		
		List<StructuredData> qualifiedDataList = dataList;
		
		while( queryIter.hasNext() ) {
			String field = queryIter.next();
			
			JSONObject fieldQuery = query.getJSONObject(field);
			String operator = fieldQuery.getString("operator");
			
			if( operator.equalsIgnoreCase("and") ) {
				
			}
			else {
				
			}
		}
		
		return results;
	}
	
	private List<StructuredData> _processOrQuery( List<StructuredData> dataList, 	JSONObject dataStructure, JSONObject andQuery, int start, int end ) {
		List<StructuredData> results = new ArrayList<>();
		
		return results;
	}
	
	public List<String> getAbstractFields( long dataTypeId, boolean abstractKey ) throws JSONException{
		List<String> abstractFieldList = new ArrayList<String>();
		
		JSONObject dataStructure = getDataTypeStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray terms = dataStructure.getJSONArray("terms");
			
			for( int i=0; i<terms.length(); i++ ) {
				JSONObject term = terms.getJSONObject(i);
				
				boolean definedValue = (term.has("abstractKey") && term.getBoolean("abstractKey") == true) ? true : false;
				if( definedValue == abstractKey ) {
					abstractFieldList.add(term.getString("termName"));
				}
			}
		}
		
		return abstractFieldList;
	}
	
	public List<String> getSearchableFields( long dataTypeId, boolean searchable ) throws JSONException{
		List<String> searchableFieldList = new ArrayList<String>();
		
		JSONObject dataStructure = getDataTypeStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray terms = dataStructure.getJSONArray("terms");
	
			for( int i=0; i<terms.length(); i++ ) {
				JSONObject term = terms.getJSONObject(i);
				if( term.getString(IcecapSSSTermAttributes.TERM_TYPE).equalsIgnoreCase(IcecapSSSTermTypes.GROUP)) {
					continue;
				}
	
				boolean definedValue = (term.has("searchable") && term.getBoolean("searchable") == false) ? false : true;
				if( definedValue == searchable ) {
					searchableFieldList.add(term.getString("termName"));
				}
			}
		}
		
		return searchableFieldList;
	}
	
	public List<String> getDownloadableFields( long dataTypeId, boolean downloadable ) throws JSONException{
		List<String> downloadableFieldList = new ArrayList<String>();
		
		JSONObject dataStructure = getDataTypeStructureJSONObject(dataTypeId);
		
		if( Validator.isNotNull(dataStructure) ) {
			JSONArray terms = dataStructure.getJSONArray("terms");
	
			for( int i=0; i<terms.length(); i++ ) {
				JSONObject term = terms.getJSONObject(i);
	
				boolean definedValue = (term.has("downloadable") && term.getBoolean("downloadable") == false) ? false : true;
				if(  definedValue == downloadable ) {
					downloadableFieldList.add(term.getString("termName"));
					System.out.println("A Key is added for download: " + term.getString("termName"));
				}
			}
		}
		
		return downloadableFieldList;
	}

	/*
	public JSONObject getStructuredDataWithValues( 
			long dataTypeId, long structuredDataId ) throws PortalException {
		String dataStructure = "";
		try {
			dataStructure = getDataTypeStructure( dataTypeId );
		} catch (NoSuchDataTypeStructureException e) {
			return null;
		} 
		
		if( structuredDataId == 0 ) {
			return JSONFactoryUtil.createJSONObject( dataStructure );
		}
		
		StructuredData structuredData = super.structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
		
		JSONObject jsonStructure = JSONFactoryUtil.createJSONObject( dataStructure );
		JSONObject jsonData = JSONFactoryUtil.createJSONObject(structuredData.getStructuredData());

		Set<String> dataKeys = jsonData.keySet();
		
		JSONArray terms = jsonStructure.getJSONArray(IcecapDataTypeAttributes.TERMS);
		
		for( int i=0; i< terms.length(); i++ ){
			JSONObject jsonTerm = terms.getJSONObject(i);
			
			String termType = jsonTerm.getString( IcecapSSSTermAttributes.TERM_TYPE );
			String termName = jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME);
			String termVersion = jsonTerm.getString(IcecapSSSTermAttributes.TERM_VERSION);
			
			if( dataKeys.contains( jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME) ) ){
				switch( termType ) {
					case IcecapSSSTermTypes.FILE:{
						DataType dataType = getDataType(dataTypeId);
						long dataFileFolderId = getDataFileFolderId(
																	dataType.getGroupId(),
																	DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
																	dataType.getDataTypeName(),
																	dataType.getDataTypeVersion(),
																	structuredDataId,
																	termName,
																	termVersion,
																	null, false );
						
						JSONArray dlFolderFiles = getDLFolderFiles(
										dataType.getGroupId(),
										dataFileFolderId );
						
						JSONObject jsonFiles = jsonData.getJSONObject(termName);
						
						if( Validator.isNotNull(dlFolderFiles) ) {
							for( int j=0; j<dlFolderFiles.length(); j++ ) {
								JSONObject dlFile =dlFolderFiles.getJSONObject(j);
								if( Validator.isNull(jsonFiles) ) {
									jsonFiles = JSONFactoryUtil.createJSONObject();
									jsonData.put(termName, jsonFiles);
								}
								
								jsonFiles.put(dlFile.getString("name"), dlFile);
							}
						}
						
						jsonTerm.put("value", jsonFiles );
						break;
					}
					case IcecapSSSTermTypes.EMAIL:{
						String data = jsonData.getString(termName);
						String[] parts = data.split("@");
						JSONArray email = JSONFactoryUtil.createJSONArray();
						email.put(parts[0]);
						email.put(parts[1]);
						
						jsonTerm.put("value", email );
						break;
					}
					case IcecapSSSTermTypes.PHONE:{
						String data = jsonData.getString(termName);
						String[] parts = data.split("-");
						JSONArray phone = JSONFactoryUtil.createJSONArray();
						phone.put(parts[0]);
						phone.put(parts[1]);
						phone.put(parts[2]);
						
						jsonTerm.put("value", phone );
						break;
					}
					case IcecapSSSTermTypes.ADDRESS:{
						String data = jsonData.getString(termName);
						String[] parts = data.split(", ");
						JSONArray address = JSONFactoryUtil.createJSONArray();
						address.put(parts[0]);
						address.put(parts[1]);
						address.put(parts[2]);
						
						jsonTerm.put("value", address );
						break;
					}
					case IcecapSSSTermTypes.MATRIX:
					case IcecapSSSTermTypes.LIST:{
						jsonTerm.put("value", jsonData.getJSONArray( termName ) );
						break;
					}
					case IcecapSSSTermTypes.NUMERIC:{
						jsonTerm.put( IcecapSSSTermAttributes.VALUE,  jsonData.getDouble(termName) );
						break;
					}
					case IcecapSSSTermTypes.DATE:{
						jsonTerm.put( IcecapSSSTermAttributes.VALUE, jsonData.getLong(termName) );
						break;
					}
					case IcecapSSSTermTypes.BOOLEAN:{
						jsonTerm.put( IcecapSSSTermAttributes.VALUE, jsonData.getBoolean(termName) );
						break;
					}
					case IcecapSSSTermTypes.GRID:{
						break;
					}
				}
			}
		}
		
		return jsonStructure;
	}
	*/
	
	public final long getDataFileFolderId(
			long repositoryId,
			long parentFoderId,
			String dataTypeName,
			String dataTypeVersion,
			long dataId,
			String termName,
			String termVersion,
			ServiceContext sc,
			boolean createWhenNoExist ) throws PortalException {
	
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String rootDataFolderName = "Data Files";
		
		long rootFolderId = _getFolderId( repositoryId, parentFolderId, rootDataFolderName, sc, createWhenNoExist);
		long dataTypeFolderId = _getFolderId( repositoryId, rootFolderId, dataTypeName, sc, createWhenNoExist);
		long dataTypeVersionFolderId = _getFolderId( repositoryId, dataTypeFolderId, dataTypeVersion, sc, createWhenNoExist);
		long dataFolderId = _getFolderId( repositoryId, dataTypeVersionFolderId, String.valueOf(dataId), sc, createWhenNoExist );
		
		if( termName.isEmpty() ) {
			return dataFolderId;
		}
		
		long termNameFolderId = _getFolderId( repositoryId, dataFolderId, termName, sc, createWhenNoExist);
		long termVersionFolderId = _getFolderId( repositoryId, termNameFolderId, termVersion, sc, createWhenNoExist);
		
		return termVersionFolderId;
	}
	
	private final long _getFolderId( long repositoryId, long parentFolderId, String folderName, ServiceContext sc, boolean createWhenNoExist ) throws PortalException{
		Folder folder = null;
		try {
			folder = _dlAppService.getFolder(repositoryId, parentFolderId, folderName);
		} catch (PortalException e) {
			if( createWhenNoExist ) {
				folder = _dlAppService.addFolder(repositoryId, parentFolderId, folderName, "", sc);
			}
		}
		
		return Validator.isNull(folder) ? 0 : folder.getFolderId();
	}
	
	@Deprecated
	public JSONObject getStructuredDataWithValues( 
			long dataTypeId, String structuredData ) throws JSONException {
		String dataStructure = "";
		try {
			dataStructure = getDataTypeStructure( dataTypeId );
		} catch (NoSuchDataTypeStructureException e) {
			return null;
		} 
		
		return _fillDataStructureWithValues( dataStructure, structuredData, null );
	}
	
	public JSONArray getDLFolderFiles( long repositoryId, long folderId ) {
		if( folderId == 0 ) {
			return null;
		}
		
		List<FileEntry> fileEntries = null;
		
		try {
			fileEntries = _dlAppService.getFileEntries( repositoryId, folderId );
		} catch (Exception e) {
			return null;
		}
		
		JSONArray files = JSONFactoryUtil.createJSONArray(); 
		for( FileEntry fileEntry : fileEntries ) {
			JSONObject fileInfo = JSONFactoryUtil.createJSONObject();
			fileInfo.put("parentFolderId", fileEntry.getFolderId() );
			fileInfo.put("fileId", fileEntry.getFileEntryId() );
			fileInfo.put("name", fileEntry.getFileName() );
			fileInfo.put("size", fileEntry.getSize() );
			fileInfo.put("type", fileEntry.getMimeType() );
			fileInfo.put("downloadURL", "/documents/" + fileEntry.getGroupId() + StringPool.BACK_SLASH + fileEntry.getFolderId() + StringPool.BACK_SLASH + fileEntry.getFileName() + StringPool.BACK_SLASH + fileEntry.getUuid() );
			
			files.put(fileInfo);
		}
		
		return files;
	}
	
	@Deprecated
	private JSONObject _fillDataStructureWithValues( 
			String dataStructure, 
			String values, 
			JSONArray dlFolderFiles ) throws JSONException {
		
		JSONObject jsonStructure = JSONFactoryUtil.createJSONObject( dataStructure );
		JSONObject jsonValues = JSONFactoryUtil.createJSONObject(values);

		Set<String> valueKeys = jsonValues.keySet();
		
		JSONArray terms = jsonStructure.getJSONArray(IcecapDataTypeAttributes.TERMS);
		
		for( int i=0; i< terms.length(); i++ ){
			JSONObject jsonTerm = terms.getJSONObject(i);
			
			String termType = jsonTerm.getString( IcecapSSSTermAttributes.TERM_TYPE );
			String termName = jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME);
			
			if( valueKeys.contains( jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME) ) ){
				if( IcecapSSSTermTypes.LIST.equalsIgnoreCase( termType ) ){
					jsonTerm.put( IcecapSSSTermAttributes.VALUE, 
							jsonValues.getJSONArray(termName) );
				}
				else if(  IcecapSSSTermTypes.FILE.equalsIgnoreCase(  termType ) ) {
					JSONObject jsonFiles = jsonValues.getJSONObject(termName);
					
					System.out.println("jsonFiles: " + jsonFiles.toString() );
					if( Validator.isNull(jsonFiles) || jsonFiles.length() == 0 ) {
						System.out.println("Term "+termName+" has no folder information");
						System.out.println("jsonValues: " + jsonValues.toString() );
						continue;
					}
					else{
						/*
						for( FileEntry entry : fileEntries) {
							JSONObject jsonFile =jsonFiles.getJSONObject(entry.getFileName());
							if( Validator.isNull(jsonFile) ) {
								jsonFile = JSONFactoryUtil.createJSONObject();
							}
							
							jsonFile.put("parentFolderId", entry.getFolderId());
							jsonFile.put("fileId", entry.getFileEntryId());
							jsonFile.put("name", entry.getFileName());
							jsonFile.put("type", entry.getMimeType());
							jsonFile.put("size", entry.getSize());
							jsonFile.put("downloadURL", entry.getSize());
						}
						*/
						Iterator<String> iter = jsonFiles.keys();
						while( iter.hasNext() ) {
							String fileName = iter.next();
							
							JSONObject jsonFile = jsonFiles.getJSONObject(fileName);
							if( !jsonFile.has("fileId") ) {
								jsonFiles.remove(fileName);
							}
						}
					}
				}
				else if(  IcecapSSSTermTypes.EMAIL.equalsIgnoreCase( jsonTerm.getString(termType)) ) {
					String email = jsonValues.getString( termName );
					
					String[] parts = email.split("@");
					
					JSONArray value = JSONFactoryUtil.createJSONArray();
					
					value.put( parts[0] );
					value.put( parts[1] );
					
					jsonTerm.put("value", value );
				}
				else if(  IcecapSSSTermTypes.PHONE.equalsIgnoreCase( jsonTerm.getString(termType)) ) {
					String phone = jsonValues.getString( termName );
					
					String[] parts = phone.split("-");
					
					JSONArray value = JSONFactoryUtil.createJSONArray();
					
					value.put( parts[0] );
					value.put( parts[1] );
					value.put( parts[2] );
					
					jsonTerm.put("value", value );
				}
				else if(  IcecapSSSTermTypes.ADDRESS.equalsIgnoreCase( jsonTerm.getString(termType)) ) {
					String address = jsonValues.getString( termName );
					
					String[] parts = address.split(", ");
					
					JSONArray value = JSONFactoryUtil.createJSONArray();
					
					value.put( parts[0] );
					value.put( parts[1] );
					value.put( parts[2] );
					
					jsonTerm.put("value", value );
				}
				else {
					jsonTerm.put( IcecapSSSTermAttributes.VALUE, 
											jsonValues.getString(jsonTerm.getString(termName)));
				}
			}
		}
		
		return jsonStructure;
	}

	public Map<String, Object> parseStructuredData( 
			String termDelimiter, String valueDelimiter, String structuredData ){
		
		Map<String, Object> valueMap = new HashMap<String, Object>();
		
		String[] lines = structuredData.split(termDelimiter);
		for( int i=0; i<lines.length; i++ ) {
			String line = lines[i].trim();
			
			if(! line.isEmpty() ) {
				String[] tokens = line.split(valueDelimiter);
				List<String> tokenList = Arrays.asList( tokens );
				tokens = Arrays.stream(tokens).filter(token -> token.isEmpty() ).toArray(String[]::new);
				System.out.println();
				valueMap.put( tokens[0].trim(), tokens[2].trim() );
			}
		}
		
		return valueMap;
	}
	
	public SearchContainerResults<AssetEntry> getSearchContainerResults(
			SearchContainer<DataType> searchContainer)
		throws PortalException {

		AssetEntryQuery assetEntryQuery = new AssetEntryQuery(
			DataType.class.getName(), searchContainer);

		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setOrderByCol1(searchContainer.getOrderByCol());
		assetEntryQuery.setOrderByType1(searchContainer.getOrderByType());
		
		System.out.println("DataTypeLocalService.getSearchContainerResults Type: "+searchContainer.getOrderByType());
		assetEntryQuery.setVisible(Boolean.TRUE);

		int total = AssetEntryServiceUtil.getEntriesCount(assetEntryQuery);

		assetEntryQuery.setEnd(searchContainer.getEnd());
		assetEntryQuery.setStart(searchContainer.getStart());

		List<AssetEntry> assetEntries = AssetEntryServiceUtil.getEntries(
			assetEntryQuery);

		return new SearchContainerResults<AssetEntry>(assetEntries, total);
	}
	
	/**
	 * 
	 * @param dataTypeName
	 * @param dataTypeVersion
	 * @return true if the dataType is verified.
	 * @throws DuplicatedDataTypeNameException 
	 */
	private boolean _verifyDataTypeName( String dataTypeName ) throws DuplicatedDataTypeNameException {
		// Check uniqueness of the dataTypeName
		if( super.dataTypePersistence.countByName(dataTypeName) > 0 ) {
			throw new DuplicatedDataTypeNameException( dataTypeName + " exists already." );
		}
		
		// Check if the naming convention of the dataType name is followed
		String pattern = "[a-zA-Z]([a-zA-Z0-9_]*)";
		return dataTypeName.matches(pattern);
	}
	
	private boolean _isNotEmpty( String str ) {
		return Validator.isNotNull(str) && !str.isEmpty();
	}
	
	private DataTypeStructure _setDataTypeStructure( long dataTypeId, String dataStructure ) {
		
		DataTypeStructure dataTypeStructure = null;
		
		try {
			dataTypeStructure = super.dataTypeStructurePersistence.findByPrimaryKey(dataTypeId);
		} catch (NoSuchDataTypeStructureException e) {
			dataTypeStructure = super.dataTypeStructurePersistence.create(dataTypeId);
		}
		
		dataTypeStructure.setStructure(dataStructure);
		
		return super.dataTypeStructurePersistence.update(dataTypeStructure);
	}
	
	private DataType _updateHasDataStructure( long dataTypeId, boolean has ) {
		DataType dataType = super.dataTypeLocalService.fetchDataType(dataTypeId);
		dataType.setHasDataStructure(has);
		super.dataTypePersistence.update(dataType);
		
		return dataType;
	}

}