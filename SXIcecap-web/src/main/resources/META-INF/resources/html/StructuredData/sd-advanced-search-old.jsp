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
									<aui:input type="radio" name="fieldOperator"  value="or" label="Or"></aui:input>
								</div>
								<div style="display:inline-block; width:20%;">
									<aui:input type="radio" name="fieldOperator"  value="and" label="And"  checked="true"></aui:input>
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

	
	let query = new Object();
	query.fieldOperator = $('input[name="<portlet:namespace/>fieldOperator"]:checked').val();
	query.inFieldOperator = $('input[name="<portlet:namespace/>inFieldOperator"]:checked').val();
	
	let clause = query.fieldOperator;
	query.clauses = new Object();
	
	$('input[name="<portlet:namespace/>fieldOperator"]').change(function(event){
		//dataStructure.fieldOperator = $(this).val();
		query.fieldOperator = $(this).val();;
	});
	
	$('input[name="<portlet:namespace/>inFieldOperator"]').change(function(event){
		//dataStructure.inFieldOperator = $(this).val();
		query.inFieldOperator = $(this).val();
	});
	
	$('#<portlet:namespace/>btnSearch').click(function(event){
		console.log('submit: ', dataStructure );
		
		console.log('searchQuery: ', JSON.stringify(query, null, 4) );
		$('#<portlet:namespace/>structuredDataQuery').val(  JSON.stringify(query) );
		
		$('#<portlet:namespace/>fm').submit();
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_KEYWORD_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_KEYWORD_CHANGED' , eventData );
		
		let term = eventData.term;

		if( term.hasOwnProperty('searchKeywords') ){
			let clause = new Object();
			clause.termType = term.termType;

			clause.keywords = term.searchKeywords;
			query.clauses[term.termName] = clause;
		}
		else{
			delete query.clauses[term.termName];
		}
		
		console.log( 'Changed term: ', term, query );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_FROM_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_FROM_NUMERIC_CHANGED ' , eventData );
		
		let term = eventData.term;
		let clause = null;
		if( query.clauses.hasOwnProperty(term.termName) ){
			clause = query.clauses[term.termName];	
		}
		else {
			clause = new Object();
			clause.termType = term.termType;
		}
		
		if( term.rangeSearch ){
			clause.rangeSearch = true;
			delete clause.searchValues;
			
			if( term.hasOwnProperty('fromSearchValue') ){
				clause.fromValue = term.fromSearchValue;
				query.clauses[term.termName] = clause;
			}
			else{
				if( clause.hasOwnProperty('toValue') ){
					delete clause.fromValue;
				}
				else{
					delete query.clauses[term.termName];
				}
			}
		}
		else{
			delete clause.rangeSearch;
			delete clause.fromValue;
			delete clause.toValue;
			
			if( term.hasOwnProperty('searchValues') ){
				clause.searchValues = term.searchValues;
				
				query.clauses[term.termName] = clause;
			}
			else{
				delete query.clauses[term.termName];
			}
		}
		
		console.log( 'Query: ', JSON.stringify(query, null, 4) );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_TO_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_TO_NUMERIC_CHANGED ' , eventData );
		
		let term = eventData.term;
		let clause = null;
		if( query.clauses.hasOwnProperty(term.termName) ){
			clause = query.clauses[term.termName];	
		}
		else {
			clause = new Object();
			clause.termType = term.termType;
		}
		
		if( term.hasOwnProperty('toSearchValue') ){
			clause.toValue = term.toSearchValue;
		}
		else{
			delete clause.toValue;
		}
		
		query.clauses[term.termName] = clause;
		
		console.log( 'Query: ', JSON.stringify(query.clauses, null, 4) );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		let clause = query.clauses[term.termName];
		if( !clause ){
			clause = new Object();
			clause.termType = term.termType;
			query.clauses[term.termName] = clause;
		}
		
		if( term.rangeSearch ){
			delete clause.searchValues;
			
			clause.rangeSearch = true;
			clause.fromValue = term.fromSearchValue;
		}
		else{
			delete clause.rangeSearch;
			delete clause.fromValue;
			clause.searchValues = term.searchValues;
		}
		
		console.log( JSON.stringify(query.clauses,null,4));
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_FROM_DATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_FROM_DATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		let clause = null;
		if( query.clauses.hasOwnProperty(term.termName) ){
			clause = query.clauses[term.termName];	
		}
		else {
			clause = new Object();
			clause.termType = term.termType;
		}
		
		if( term.rangeSearch ){
			clause.rangeSearch = true;
			delete clause.searchValues;
			
			if( term.hasOwnProperty('fromSearchDate') ){
				clause.fromDate = term.fromSearchDate;
				query.clauses[term.termName] = clause;
			}
			else{
				if( clause.hasOwnProperty('toDate') ){
					delete clause.fromDate;
				}
				else{
					delete query.clauses[term.termName];
				}
			}
		}
		else{
			delete clause.rangeSearch;
			delete clause.fromDate;
			delete clause.toDate;
			
			if( term.hasOwnProperty('searchDate') ){
				clause.searchDate = term.searchDate;
				
				query.clauses[term.termName] = clause;
			}
			else{
				delete query.clauses[term.termName];
			}
		}
		
		console.log( 'Query: ', JSON.stringify(query, null, 4) );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_TO_DATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_TO_DATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		let clause = null;
		if( query.clauses.hasOwnProperty(term.termName) ){
			clause = query.clauses[term.termName];	
		}
		else {
			clause = new Object();
			clause.termType = term.termType;
		}
		
		if( term.hasOwnProperty('toSearchDate') ){
			clause.toDate = term.toSearchDate;
		}
		else{
			delete clause.toDate;
		}
		
		query.clauses[term.termName] = clause;
		
		console.log( 'Query: ', JSON.stringify(query.clauses, null, 4) );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_DATE_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_DATE_RANGE_SEARCH_STATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		let clause = query.clauses[term.termName];
		if( !clause ){
			clause = new Object();
			clause.termType = term.termType;
			query.clauses[term.termName] = clause;
		}
		
		if( term.rangeSearch ){
			delete clause.searchDate;
			
			clause.rangeSearch = true;
			clause.fromDate = term.fromSearchDate;
		}
		else{
			delete clause.rangeSearch;
			delete clause.fromDate;
			delete clause.toDate;
			clause.searchDate = term.searchDate;
		}
		
		console.log( JSON.stringify(query.clauses,null,4));
	});
});
</script>