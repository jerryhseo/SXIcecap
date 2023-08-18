<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sx.icecap.constant.IcecapWebKeys"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@ include file="../init.jsp" %>

<%
	DataType dataType = (DataType)renderRequest.getAttribute(IcecapWebKeys.DATATYPE);
	JSONObject dataStructure = (JSONObject)renderRequest.getAttribute(IcecapWebKeys.DATA_STRUCTURE);
	
%>

<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_STRUCTURED_DATA_ADVANCED_SEARCH  %>" var="searchActionURL">
	<portlet:param name="<%= IcecapWebKeys.DATATYPE_ID %>" value="<%= String.valueOf(dataType.getPrimaryKey()) %>" />
	<portlet:param name="<%= StationXWebKeys.BACK_URL %>" value="<%= currentURL %>" />
</portlet:actionURL>

<aui:form action="<%= searchActionURL %>" method="POST" name="fm" >
	<input type="hidden" id="<portlet:namespace/>structuredDataQuery" name="<portlet:namespace/>structuredDataQuery" value="Query">
</aui:form>
	
	<aui:container cssClass="SXIcecap-web">
		<aui:row cssClass="form-section">
			<aui:col md="12">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset label="datatype">
							<span style="display:table-cell; width:40%;">
								<aui:input name="datatype-name" disabled="true" value="<%= dataType.getDataTypeName() %>"></aui:input>
							</span>
							<span style="display:table-cell; width:10%;">
								<aui:input name="datatype-version" disabled="true" value="<%= dataType.getDataTypeVersion() %>"></aui:input>
							</span>
							<span style="display:table-cell; width:10%;">
								<aui:input name="datatype-extension" disabled="true" value="<%= dataType.getExtension() %>"></aui:input>
							</span>
						</aui:fieldset>
					</aui:fieldset-group>
					<aui:fieldset-group markupView="lexicon">
						<div style="display:inline-block; width:40%;">
							<aui:fieldset label="operator-between-fields">
								<div style="display:inline-block; width:20%;">
									<aui:input type="radio" name="fieldOperator"  value="or" label="Or" checked="true"></aui:input>
								</div>
								<div style="display:inline-block; width:20%;">
									<aui:input type="radio" name="fieldOperator"  value="and" label="And"></aui:input>
								</div>
							</aui:fieldset>
						</div>
						<div style="display:inline-block; width:40%;">
							<aui:fieldset label="operator-in-field">
								<div style="display:inline-block; width:20%;">
									<aui:input type="radio" name="inFieldOperator"  value="or" label="Or" checked="true"></aui:input>
								</div>
								<div style="display:inline-block; width:20%;">
									<aui:input type="radio" name="inFieldOperator"  value="and" label="And"></aui:input>
								</div>
							</aui:fieldset>
						</div>
					</aui:fieldset-group>
					<div class="container-fluid">
						<div class="row"  id="<portlet:namespace/>searchCanvas">
						</div>
					</div>
			</aui:col>
		</aui:row>
		<aui:button-row>
			<aui:button type="submit" id="btnSearch" value="search"></aui:button>
			<aui:button type="reset" id="btnClear" value="clear"></aui:button>
			<aui:button type="button" id="btnViewDataList" value="data-list"></aui:button>
		</aui:button-row>
	</aui:container>

<script>
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
			'<%= defaultLocale.toString() %>',
			'<%= locale.toString() %>',
			<%= jsonLocales.toJSONString() %> );
	
	let dataStructure = SX.newDataStructure(  <%= dataStructure.toString() %> );
	console.log('Search View: ', dataStructure );
	
	dataStructure.render( SX.SXConstants.FOR_SEARCH, $('#<portlet:namespace/>searchCanvas') );
	
	$('input[name="<portlet:namespace/>fieldOperator"]').change(function(event){
		dataStructure.fieldOperator = $(this).val();
	});
	
	$('input[name="<portlet:namespace/>inFieldOperator"]').change(function(event){
		dataStructure.infieldOperator = $(this).val();
	});
	
	$('#<portlet:namespace/>btnSearch').click(function(event){
		console.log('submit: ', dataStructure );
		let query = dataStructure.getSearchQuery();
		
		$('#<portlet:namespace/>structuredDataQuery').val( JSON.stringify( query) );
		
		//$('#<portlet:namespace/>fm').submit();
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_KEYWORD_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_KEYWORD_CHANGED' , eventData );
		
		
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_FROM_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_FROM_NUMERIC_CHANGED ' , eventData );
		
		
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_TO_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_TO_NUMERIC_CHANGED ' , eventData );
		
		
	});
});
</script>