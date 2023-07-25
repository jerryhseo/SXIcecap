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
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.sx.constant.StationXConstants;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.sx.icecap.model.DataType",
	service = AopService.class
)
public class DataTypeLocalServiceImpl extends DataTypeLocalServiceBaseImpl {
	
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
	
	public String getDataTypeStructure( long dataTypeId ){
		try {
			return super.dataTypeStructurePersistence.findByPrimaryKey(dataTypeId).getStructure();
		} catch (NoSuchDataTypeStructureException e) {
			return "";
		}
	}
	
	public JSONObject getDataTypeStructureJSONObject( long dataTypeId ) throws JSONException{
		String dataStructureString = getDataTypeStructure( dataTypeId );
		
		JSONObject jsonObject = null;
		if( !dataStructureString.isEmpty() ) {
				jsonObject = JSONFactoryUtil.createJSONObject(
						getDataTypeStructure( dataTypeId ) );
		}
		
		return jsonObject;
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
	
	public StructuredData removeStructuredData( long structuredDataId ) throws PortalException {
		return StructuredDataLocalServiceUtil.removeStructuredData(structuredDataId);
	}
	
	public void removeStructuredDatas( long[] structuredDataIds ) throws PortalException {
		StructuredDataLocalServiceUtil.removeStructuredDatas(structuredDataIds);
	}

	public StructuredData getStructuredData( long structuredDataId ){
		return super.structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
	}
	
	public List<StructuredData> getStructuredDatas( long dataTypeId ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId);
	}
	public List<StructuredData> getStructuredDatas( long dataTypeId, int start, int end ){
		return super.structuredDataPersistence.findByDataTypeId(dataTypeId, start, end);
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
	
				boolean definedValue = (term.has("searchable") && term.getBoolean("searchable") == true) ? true : false;
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

	public JSONObject getStructuredDataWithValues( 
			long dataTypeId, long structuredDataId ) throws JSONException {
		String dataStructure = getDataTypeStructure( dataTypeId ); 
		
		StructuredData structuredData = 
				super.structuredDataPersistence.fetchByPrimaryKey(structuredDataId);
		
		return _fillDataStructureWithValues( dataStructure, structuredData.getStructuredData() );
	}
	
	public JSONObject getStructuredDataWithValues( 
			long dataTypeId, String structuredData ) throws JSONException {
		String dataStructure = getDataTypeStructure( dataTypeId ); 
		
		return _fillDataStructureWithValues( dataStructure, structuredData );
	}
	
	private JSONObject _fillDataStructureWithValues( String dataStructure, String values ) throws JSONException {
		JSONObject jsonStructure = JSONFactoryUtil.createJSONObject( dataStructure );
		JSONObject jsonValues = JSONFactoryUtil.createJSONObject(values);

		Set<String> valueKeys = jsonValues.keySet();
		
		JSONArray terms = jsonStructure.getJSONArray(IcecapDataTypeAttributes.TERMS);
		
		terms.forEach( term -> {
			JSONObject jsonTerm = (JSONObject)term;
			if( valueKeys.contains( jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME) ) ){
				jsonTerm.put( IcecapSSSTermAttributes.VALUE, 
											jsonValues.getString(jsonTerm.getString(IcecapSSSTermAttributes.TERM_NAME)));
			}
		});
		
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