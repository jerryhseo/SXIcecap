
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
</portlet:renderURL>



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
		<aui:col md="5"   cssClass="show-border" id="searchSection">
		aaaaa
		</aui:col>
		<aui:col md="7"   cssClass="show-border" id="resultSection">
			<aui:container>
				<aui:row>
					<aui:col></aui:col>
				</aui:row>
			</aui:container>
		</aui:col>
	</aui:row>
</aui:container>
<aui:script use="liferay-util-window, liferay-portlet-url">
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
			'<%= defaultLocale.toString() %>',
			'<%= locale.toString() %>',
			<%= jsonLocales.toJSONString() %> );
	
	let dataStructure = SX.newDataStructure(  <%= dataStructure.toString() %> );
	let abstractFields = <%= abstractFields.toJSONString() %>;
	dataStructure.render( SX.SXConstants.FOR_SEARCH, $('#<portlet:namespace/>searchSection') );
	
	
	let structuredDataList = <%= structuredDataList.toJSONString() %>;
	//console.log( structuredDataList );
	
	let $resultSection = $('#<portlet:namespace/>resultSection');
	
	let renderResult = function( structuredData, abstractFields ){
		let data = structuredData.data;
		let id = structuredData.id;
		
		let $row = $('<div class="row" style="padding-top:3px; padding-bottom:3px;">');
		
		let $col_1 = $('<div class="col-md-1 index-col" style:"text-align:right;">');
		//$col_1.text( index );
		$row.append( $col_1 );
		
		let $col_2 = $('<div class="col-md-10 abstract-col">');
		let $href = $('<a>');
		
		
		let renderUrl = Liferay.PortletURL.createURL('<%= editStructuredDataURL.toString() %>');
		renderUrl.setParameter("structuredDataId", id);
		renderUrl.setParameter("dataTypeId", "<%= dataType.getDataTypeId() %>");
		
		$href.prop('href', renderUrl.toString() );
		$col_2.append( $href );
		
		let abstractContent = '';
		
		abstractFields.forEach( field => {
			if( data.hasOwnProperty( field ) ){
				let term = dataStructure.getTermByName( field );
				if( term.termType === 'Date' ){
					if( term.enableTime ){
						abstractContent += field + ':' + SX.Util.toDateTimeString( data[field] ) + ' ';
					}
					else{
						abstractContent += field + ':' + SX.Util.toDateString( data[field] ) + ' ';
					}
				}
				else{
					abstractContent += field + ':' + data[field] + ' ';
				}
			}
		})
		$href.text( abstractContent );
		$row.append( $col_2 );
		
		/*
		let $col_3 = $('<div class="col-md-1 action-col">');
		$col_3.html( '<div class="dropdown dropdown-action" id="mazj">' + 
									'<button aria-expanded="false" aria-haspopup="true" class="dropdown-toggle btn btn-unstyled" data-onclick="toggle" data-onkeydown="null" ref="triggerButton" title="Actions" type="button">' +
										'<svg class="lexicon-icon lexicon-icon-ellipsis-v" focusable="false" role="presentation" viewBox="0 0 512 512">'+
											'<path class="lexicon-icon-outline ellipsis-v-dot-2" d="M319 255.5c0 35.346-28.654 64-64 64s-64-28.654-64-64c0-35.346 28.654-64 64-64s64 28.654 64 64z"></path>' +
											'<path class="lexicon-icon-outline ellipsis-v-dot-3" d="M319 448c0 35.346-28.654 64-64 64s-64-28.654-64-64c0-35.346 28.654-64 64-64s64 28.654 64 64z"></path>' +
											'<path class="lexicon-icon-outline ellipsis-v-dot-1" d="M319 64c0 35.346-28.654 64-64 64s-64-28.654-64-64c0-35.346 28.654-64 64-64s64 28.654 64 64z"></path>' +
										'</svg></button></div>' );
		$row.append( $col_3 );
		*/
		
		return $row;
	};
	
	let resultRows = new Object();
	resultRows.rows = new Array();
	let index = 1;
	structuredDataList.forEach( structuredData => {
		let $row = renderResult( structuredData, abstractFields );
		$row.hide();
		$resultSection.append( $row );
		
		let row = new Object();
		row.id = structuredData.id;
		row.$rendered = $row;
		row.data = structuredData.data;
		
		resultRows.rows.push( row );
	});
	
	let addSearchField = function( fieldName, searchResults ){
		if( !resultRows.searchFields ){
			resultRows.searchFields = new Object();
		}
		
		if( searchResults.length === 0 ){
			delete resultRows.searchFields[fieldName];
			if( Object.keys(resultRows.searchFields).length === 0 ){
				delete resultRows.searchFields;
			}
		}
		else{
			resultRows.searchFields[ fieldName ] = searchResults;
		}
		
	};
	
	let orSearchWithinField = function( rowList, fieldName, keywords ){
		let results = rowList.filter( row => {
			if( keywords ){
				for( keyword of keywords ){
					if( row.data[fieldName] instanceof Array ){
						let found = row.data[fieldName].find( element => element === keyword );
						
						if( found ){
							return true;
						}
					}
					else{
						return row.data[fieldName] === keyword;
					}
				};
			}
			else{
				return false;
			}
			
			return false;
		});
		
		return results;
	};
	
	let andOperation = function( list_1, list_2 ){
		let resultList = list_1.filter( mem_1 => {
			return list_2.find( mem_2 => {
				return mem_1 === mem_2;
			});
		});
		
		return resultList;
	}
	
	let andSearchBetweenFields = function( searchFields ){
		if( !searchFields ){
			return [];	
		}
		
		let fields = Object.keys( searchFields );
		
		if( fields.length === 0 )	return [];
		if( fields.length === 1 )	return searchFields[fields[0]];
		
		let results = andOperation( searchFields[fields[0]], searchFields[fields[1]]);
		
		for( let i=2; i<fields.length; i++ ){
			results = andOperation( results, searchFields[fields[i]]);
		}
		
		return results;
	};
	
	let displayHittedRows = function( rows ){
		let i = 1;
		
		resultRows.rows.forEach( row => {
			if( rows.find( hittedRow => row === hittedRow ) ){
				row.$rendered.find( '.index-col' ).text( i++ );
				if( i % 2 ){
					row.$rendered.css('background', '#fff');
				}
				else{
					row.$rendered.css('background', '#eee');
				}
				
				row.$rendered.show();
			}
			else{
				row.$rendered.hide();
			}
		});
	};
	
	let doKeywordSearch = function( dataList, fieldName, keywords ){
		let orResults = orSearchWithinField( dataList, fieldName, keywords );
		
		addSearchField( fieldName, orResults );
		
		let results = andSearchBetweenFields( resultRows.searchFields );
		
		displayHittedRows( results );
	};
	
	let rangeSearch = function( dataList, fieldName, fromValue, toValue ){
		let results = dataList.filter( row => {
			if(  ( typeof(fromValue) !== "undefined" && fromValue !== null )  &&
				  ( typeof(toValue) !== "undefined" && toValue !== null ) ){
					return row.data[fieldName] >= fromValue && row.data[fieldName] <= toValue ;
			}
			else if(  ( typeof(fromValue) === "undefined" || fromValue === null )  &&
						  ( typeof(toValue) !== "undefined" && toValue !== null ) ){
					return row.data[fieldName] <= toValue ;
			}
			else if(  ( typeof(fromValue) !== "undefined" && fromValue !== null )  &&
						  ( typeof(toValue) === "undefined" || toValue === null ) ){
						return row.data[fieldName] >= fromValue ;
			}
						  
			return false;
		});
		
		return results;
	};
	
	let doRangeSearch = function( dataList, fieldName, fromValue, toValue ){
		
		let rangeSearchResults = rangeSearch( dataList, fieldName, fromValue, toValue );
		
		addSearchField( fieldName, rangeSearchResults );
		
		let results = andSearchBetweenFields( resultRows.searchFields );
		
		displayHittedRows( results );
	};
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_KEYWORD_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_KEYWORD_CHANGED' , eventData );
		
		let term = eventData.term;

		doKeywordSearch( resultRows.rows, term.termName, term.searchKeywords );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_FROM_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_FROM_NUMERIC_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		if( term.rangeSearch ){
			doRangeSearch( resultRows.rows, term.termName, term.fromSearchValue, term.toSearchValue );
		}
		else{
			doKeywordSearch( resultRows.rows, term.termName, term.searchValues );
		}
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_TO_NUMERIC_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_TO_NUMERIC_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		doRangeSearch( resultRows.rows, term.termName, term.fromSearchValue, term.toSearchValue );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_NUMERIC_RANGE_SEARCH_STATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		if( term.rangeSearch ){
			doRangeSearch( resultRows.rows, term.termName, term.fromSearchValue, term.toSearchValue );
		}
		else{
			doKeywordSearch( resultRows.rows, term.termName, term.searchValues );
		}
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_FROM_DATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_FROM_DATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		if( term.rangeSearch ){
			doRangeSearch( resultRows.rows, term.termName, term.fromSearchDate, term.toSearchDate );
		}
		else{
			doKeywordSearch( resultRows.rows, term.termName, term.searchDates );
		}
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_SEARCH_TO_DATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_SEARCH_TO_DATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		doRangeSearch( resultRows.rows, term.termName, term.fromSearchDate, term.toSearchDate );
	});
	
	Liferay.on(SX.SXIcecapEvents.SD_DATE_RANGE_SEARCH_STATE_CHANGED, function(evt){
		let eventData = evt.sxeventData;
		console.log( 'SD_DATE_RANGE_SEARCH_STATE_CHANGED ' , eventData );
		
		let term = eventData.term;
		
		if( term.rangeSearch ){
			doRangeSearch( resultRows.rows, term.termName, term.fromSearchDate, term.toSearchDate );
		}
		else{
			doKeywordSearch( resultRows.rows, term.termName, term.searchDates );
		}
	});
});

Liferay.componentReady('<%= IcecapConstants.STRUCTURED_DATA_MANAGEMENT_TOOLBAR_COMPONENT_ID %>').then(function(
		managementToolbar
	) {
		
		$('.input-group .input-group-item .input-group-inset-item .dropdown').on('click', function(e){
			e.stopPropagation();
			
			let advancedSearchRenderURL = Liferay.PortletURL.createRenderURL();
			
			advancedSearchRenderURL.setPortletId('<%=IcecapWebPortletKeys.STRUCTURED_DATA %>');
			advancedSearchRenderURL.setPlid('<%= themeDisplay.getPlid() %>');
			advancedSearchRenderURL.setParameter('<%=IcecapWebKeys.DATATYPE_ID %>', '<%= dataType.getDataTypeId() %>');
			advancedSearchRenderURL.setParameter('<%=StationXWebKeys.MVC_RENDER_COMMAND_NAME %>', '<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_ADVANCED_SEARCH %>');
			console.log( 'Created advenced Search URL: ', advancedSearchRenderURL);
			window.location.href = advancedSearchRenderURL;
		});
		
		managementToolbar.on('actionItemClicked', function(event) {
			confirm('confirm...');
			console.log('Data CMD: ', event.data.item.data.cmd );
			let form = document.getElementById('<portlet:namespace />fm');

			Liferay.Util.postForm(form, {
				data:{
					cmd: event.data.item.data.cmd,
					redirect: '<%= currentURL %>'
				},
				url: '<portlet:actionURL name="<%=IcecapMVCCommands.ACTION_BULK %>" />'
			});
		});
	});
</aui:script>
