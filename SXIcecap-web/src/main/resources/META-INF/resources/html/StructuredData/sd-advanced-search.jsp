
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
		<aui:col md="5"   cssClass="show-border" id="searchSection">
		</aui:col>
		<aui:col md="7"   cssClass="show-border">
			<aui:container>
				<aui:row>
					<aui:col md="9"><span id="<portlet:namespace/>mainPagination" style="display:inline;"></span><span  id="<portlet:namespace/>totalCount" style="float:right;padding-top:8px;padding-bottom:8px"></span></aui:col>
					<aui:col md="3">
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
		
		let $col_3 = $('<div class="col-md-1 action-col">');
		$col_3.append( SX.FormUIUtil.$getActionButton() );
		$row.append( $col_3 );
		
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
	
	let addSearchField = function( fieldName, keywords, searchResults ){
		if( !resultRows.searchFields ){
			resultRows.searchFields = new Object();
		}
		
		if( typeof keywords === 'undefined' ){
			delete resultRows.searchFields[ fieldName ];
		}
		else{
			let searchObject = {
							keywords: keywords,
							results: searchResults
			};
			
			resultRows.searchFields[ fieldName ] = {
							keywords: keywords,
							results: searchResults
			}
		};
	};
	
	let removeSearchField = function( fieldName ){
		delete resultRows.searchFields[fieldName];
		if( Object.keys(resultRows.searchFields).length === 0 ){
			delete resultRows.searchFields;
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
		if( fields.length === 1 )	return searchFields[fields[0]].results;
		
		let results = andOperation( searchFields[fields[0]].results, searchFields[fields[1]].results);
		
		for( let i=2; i<fields.length; i++ ){
			results = andOperation( results, searchFields[fields[i]].results);
		}
		
		return results;
	};
	
	let displayHittedRows = function( ){
		let rows = resultRows.finalResults;
		
		let i = 1;
		
		resultRows.rows.forEach( row => row.$rendered.hide() );
		
		/*
		let resultData = new Object();
		rows.forEach( (row, index) => {
				row.$rendered.find( '.index-col' ).text( index+1 );
				if( index % 2 ){
					row.$rendered.css('background', '#fff');
				}
				else{
					row.$rendered.css('background', '#eee');
				}
				
				row.$rendered.show();
				resultData[row.id] = row.data;
		});

		$('#<portlet:namespace/>searchResults').val( JSON.stringify(resultData) );
		*/
		
		$('#<portlet:namespace/>mainPagination').pagination({
			items: rows.length,
			itemsOnPage: 20,
			displayedPages: 3,
			onPageClick: function( pageNumber, event){
				let delta = this.itemsOnPage;	
				
				rows.forEach( (row, index) => {
					if( index >= delta * (pageNumber-1) && index < delta*pageNumber ){
						row.$rendered.show();
					}
					else{
						row.$rendered.hide();
					}
				});
			},
			onInit: function(){
				let resultData = new Object();
				
				rows.forEach( (row, index) => {
					let delta = this.itemsOnPage;	
					row.$rendered.find( '.index-col' ).text( index+1 );
					
					if( index % 2 ){
						row.$rendered.css('background', '#fff');
					}
					else{
						row.$rendered.css('background', '#eee');
					}
					
					if( index < delta ){
						row.$rendered.show();
					}
					
					resultData[row.id] = row.data;
				});	
				
				$('#<portlet:namespace/>searchResults').val( JSON.stringify(resultData) );	
			}
		});
		
	};
	
	let setResults = function( results ){
		resultRows.finalResults = results;
	}
	
	let doKeywordSearch = function( dataList, fieldName, keywords ){
		let orResults = orSearchWithinField( dataList, fieldName, keywords );
		
		addSearchField( fieldName, keywords, orResults );
		
		setResults( andSearchBetweenFields( resultRows.searchFields ) );
		
		displayHittedRows();
		
		$('#<portlet:namespace/>totalCount').text( resultRows.finalResults.length + ' ' + Liferay.Language.get('found') );
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
		if( typeof fromValue === 'undefined' && typeof toValue === 'undefined' ){
			return;
		}
		
		let rangeSearchResults = rangeSearch( dataList, fieldName, fromValue, toValue );
		
		addSearchField( fieldName, { from: fromValue, to:toValue}, rangeSearchResults );
		
		setResults( andSearchBetweenFields( resultRows.searchFields ) );
		
		displayHittedRows();
		
		$('#<portlet:namespace/>totalCount').text( resultRows.finalResults.length + ' ' + Liferay.Language.get('found') );
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
	
	$('#<portlet:namespace/>queryHistory').click(function(event){
		let queries = resultRows.searchFields;
		if( !queries )	{
			alert( 'No queries exist!' );
			return;
		}
		
		let $dialog = $('#<portlet:namespace/>historyDialog').empty();
		
		let $table = $('<table style="width:100%;">').appendTo( $dialog );
		$table.append( $('<thead style="background:#c5c5c5">'+'<tr>'+'<th style="text-align:center;">'+'<liferay-ui:message key="item"/>'+'</th>'+
														'<th style="text-align:center;">'+'<liferay-ui:message key="keywords"/>'+'</th>' +
														'<th style="text-align:center;">'+'<liferay-ui:message key="results"/>'+'</th>' +
														'</tr>'+'</thead>'));
		
		let $tbody = $('<tbody>').appendTo($table);
		
		let queryFields = Object.keys( queries );
		queryFields.forEach( (queryField, index) => {
			let query = queries[queryField];
			
			let $row = $('<tr>').appendTo($tbody);
			
			if( query.keywords instanceof Array ){
				$row.append( $('<td style="text-align:center;">'+queryField+'</td>'+'<td style="text-align:center;">'+query.keywords+'</td>'+'<td style="text-align:center;">'+query.results.length+'</td>'))
			}
			else{
				$row.append( $('<td style="text-align:center;">'+queryField+'</td>'+'<td style="text-align:center;">'+(query.keywords.from ? query.keywords.from:'') + ' ~ ' + (query.keywords.to ? query.keywords.to:'') +'</td>'+'<td style="text-align:center;">'+query.results.length+'</td>'))
			}
			
			$row.click( function(event){
				event.stopPropagation();
				
				let $itemResultDlg = $('#<portlet:namespace/>itemResultDialog');

				let delta = 10;
				let page = (query.results.length % delta) + 1;			
				
				$('#<portlet:namespace/>itemPagination').pagination({
					items: query.results.length,
					itemsOnPage: 10,
					onPageClick: function( pageNumber, event){
						let delta = this.itemsOnPage;	
						let $items = $('#<portlet:namespace/>itemTable').children();
						
						$items.each( (index, item) => {
							if( index >= delta * (pageNumber-1) && index < delta*pageNumber ){
								$(item).show();
							}
							else{
								$(item).hide();
							}
						});							
					},
					onInit: function(){
						let $itemTable = $('#<portlet:namespace/>itemTable').empty();
						let delta = this.itemsOnPage;
						query.results.forEach( (result, index) => {
							let clone = result.$rendered.clone();
							clone.find('.index-col').text( index+1);
							clone.css('width', '100%');
							if( delta > index )	clone.show();
							else								clone.hide();
							$itemTable.append( clone );
						});
					}
				});
					
				$itemResultDlg.dialog({
					title: queryField,
					width:800,
					buttons:[{
						text: '<liferay-ui:message key="ok"/>',
						click: function(){
							$(this).dialog('destroy');
						}
					}]
				});
				
			});
		});
		
		$tbody.find("tr").filter(":even").css('background', 'rgb(238,238,238)');
		
		$('#<portlet:namespace/>historyDialog').dialog({
			width:600,
			modal: true,
			buttons:[{
				text: '<liferay-ui:message key="ok"/>',
				click: function(){
					$(this).dialog('destroy');
				}
			}]
		});
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
