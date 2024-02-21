
<%@page import="com.liferay.portal.util.Constants"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList"%>
<%@page import="com.sx.icecap.web.command.render.sd.EditStructuredDataRenderCommand"%>
<%@page import="com.sx.icecap.constant.IcecapWebPortletKeys"%>
<%@page import="com.sx.icecap.constant.IcecapWebKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sx.icecap.model.StructuredData"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.sx.icecap.web.taglib.clay.sd.StructuredDataVerticalCard"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.icecap.constant.IcecapConstants"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.sx.icecap.web.display.context.sd.StructuredDataManagementToolbarDisplayContext"%>
<%@ include file="../init.jsp" %>

<style type="text/css">
	.id-width {
		width: 10% !important;
		text-align:center;
	}
	.abstract-width {
		width: 60% !important;
	}
	.status-width {
		width: 10% !important;
		text-align:center;
	}
	.actions-width {
		width: 10% !important;
		text-align:center;
	}
	
	.form-section {
		background-color: rgba(230, 230, 230, 0.777) !important;
	}
	
</style>

<%

	DataType dataType = (DataType)renderRequest.getAttribute(StationXWebKeys.DATATYPE);
	JSONArray abstractFields  = (JSONArray)renderRequest.getAttribute(StationXWebKeys.ABSTRACT_FIELDS);
	JSONObject dataStructure = (JSONObject)renderRequest.getAttribute(IcecapWebKeys.DATA_STRUCTURE);
	JSONArray structuredDataList =(JSONArray)renderRequest.getAttribute("structuredDataList");
	
%>

<portlet:renderURL var="editStructuredDataURL">
    <portlet:param 
    		name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    		value="<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT %>"/>
    <portlet:param 
    		name="<%= StationXWebKeys.BACK_URL %>" 
    		value="<%= currentURL %>"/>
    <portlet:param 
    		name="<%= StationXWebKeys.DATATYPE_ID %>" 
    		value="<%= String.valueOf(dataType.getDataTypeId()) %>"/>
</portlet:renderURL>

<input type="hidden" id="<portlet:namespace/>searchResults" id="<portlet:namespace/>searchResults"/> 

<aui:container cssClass="SXIcecap-web">
		<aui:row>
			<aui:col md="12">
				<aui:a href="<%= backURL %>" label="previous-page" style="width:20%;"></aui:a>
				<hr style="height:1px;background-color:#ddd;border-top: solid #aaa 2px;border-bottom:solid #eee;margin-top:5px;">
			</aui:col>
		</aui:row>
		<aui:row cssClass="form-section datatype-section">
			<aui:col md="12">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset label="datatype">
							<span style="display:inline-block; width:10%;">
								<aui:input name="datatype-id" disabled="true" value="<%= dataType.getPrimaryKey() %>"></aui:input>
							</span>
							<span style="display:inline-block; width:40%;">
								<aui:input name="datatype-name" disabled="true" value="<%= dataType.getDataTypeName() %>"></aui:input>
							</span>
							<span style="display:inline-block; width:10%;">
								<aui:input name="datatype-version" disabled="true" value="<%= dataType.getDataTypeVersion() %>"></aui:input>
							</span>
							<span style="display:inline-block; width:10%;">
								<aui:input name="datatype-extension" disabled="true" value="<%= dataType.getExtension() %>"></aui:input>
							</span>
							<span style="display: inline-block;width:20%;float:right;">
								<a class="btn" href="<%= backURL %>" style="float:right;"><liferay-ui:message key="view-datatype-list"/></a>
							</span>
						</aui:fieldset>
					</aui:fieldset-group>
			</aui:col>
		</aui:row>
</aui:container>

<aui:container  cssClass="SXIcecap-web">
	<aui:row >
		<aui:col md="6"   cssClass="show-border" id="searchSection">
		</aui:col>
		<aui:col md="6"   cssClass="show-border">
			<aui:container>
				<aui:row>
					<aui:col md="8"><span id="<portlet:namespace/>resultPagination" style="display:inline;"></span><span  id="<portlet:namespace/>totalCount" style="float:right;padding-top:8px;padding-bottom:8px"></span></aui:col>
					<aui:col md="4" style="text-align:right;">
						<aui:button name="queryHistory" value="query-history" cssClass="btn-info"></aui:button>
					</aui:col>
				</aui:row>
			</aui:container>
			<aui:container id="resultSection">
			</aui:container>
		</aui:col>
	</aui:row>
</aui:container>

<div id="<portlet:namespace/>historyDialog" class="pagination" style="width:100%; display:none;" ></div>
<div id="<portlet:namespace/>itemResultDialog" class="container" style="width:100%; display:none;" >
	<div id="<portlet:namespace/>itemTable" class="container" style="width:100%;"></div>
	<div id="<portlet:namespace/>itemPagination" class="pagination" style="margin-top:30px; width:100%; display:flex; justify-content:center;"></div>
</div>

<aui:script use="liferay-util-window, liferay-portlet-url">
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
			'<%= defaultLocale.toString() %>',
			'<%= locale.toString() %>',
			<%= jsonLocales.toJSONString() %> );
	
	let advancedSearch = new SX.AdvancedSearch(
						<%= dataStructure.toString() %>,
						<%= abstractFields.toJSONString() %>,
						<%= structuredDataList.toJSONString() %>,
						$('#<portlet:namespace/>searchSection'),
						$('#<portlet:namespace/>resultSection'),
						$('#<portlet:namespace/>resultPagination'),
						'<%= editStructuredDataURL.toString() %>' );
						
	$('#<portlet:namespace/>queryHistory').click(function(event){
		advancedSearch.showSearchHistories( $('#<portlet:namespace/>mainPagination' ) );
	});
	
	
	Liferay.on(SX.Events.SD_SEARCH_KEYWORD_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_SEARCH_KEYWORD_CHANGED' , dataPacket );
		
		let term = dataPacket.term;

		let hitCount = advancedSearch.doKeywordSearch(  term.termName, term.searchKeywords, term.termType );
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
		
		//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
	});
	
	Liferay.on(SX.Events.SD_SEARCH_FROM_NUMERIC_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_SEARCH_FROM_NUMERIC_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		
		let hitCount;
		if( term.rangeSearch ){
			hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchValue, term.toSearchValue, term.termType );
		}
		else{
			hitCount = advancedSearch.doKeywordSearch( term.termName, term.searchValues, term.termType );
		}
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
	});
	
	Liferay.on(SX.Events.SD_SEARCH_TO_NUMERIC_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_SEARCH_TO_NUMERIC_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		
		let hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchValue, term.toSearchValue, term.termType );
		console.log('hitCount: ' + hitCount );
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
	});
	
	Liferay.on(SX.Events.SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		
		let hitCount;
		if( term.rangeSearch ){
			hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchValue, term.toSearchValue, term.termType );
		}
		else{
			hitCount = advancedSearch.doKeywordSearch( term.termName, term.searchValues, term.termType );
		}
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
	});
	
	Liferay.on(SX.Events.SD_SEARCH_FROM_DATE_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_SEARCH_FROM_DATE_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		
		let hitCount;
		if( term.rangeSearch ){
			hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchDate, term.toSearchDate, term.termType );
		}
		else{
			hitCount = advancedSearch.doKeywordSearch( term.termName, term.searchDate, term.termType  );
		}
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
	});
	
	Liferay.on(SX.Events.SD_SEARCH_TO_DATE_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_SEARCH_TO_DATE_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		let hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchDate, term.toSearchDate, term.termType );
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
	});
	
	Liferay.on(SX.Events.SD_DATE_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let dataPacket = evt.dataPacket;
		console.log( 'SD_DATE_RANGE_SEARCH_STATE_CHANGED ' , dataPacket );
		
		let term = dataPacket.term;
		
		let hitCount;
		if( term.rangeSearch ){
			hitCount = advancedSearch.doRangeSearch( term.termName, term.fromSearchDate, term.toSearchDate, term.termType );
		}
		else{
			hitCount = advancedSearch.doKeywordSearch( term.termName, term.searchDate, term.termType );
		}
		
		if( hitCount !== null ){
			$('#<portlet:namespace/>totalCount').text( hitCount + ' ' + Liferay.Language.get('found') );
			//$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
		}
		else{
			$('#<portlet:namespace/>totalCount').empty();
		}
		
	});
	
	Liferay.on(SX.Events.SD_SEARCH_HISTORY_CHANGED, function(evt){
	
		console.log('SD_SEARCH_HISTORY_CHANGED: ', advancedSearch.getSearchHistories() );
		$('#<portlet:namespace/>searchResults').val( JSON.stringify( advancedSearch.getSearchHistories() ) );
	});
});
</aui:script>
