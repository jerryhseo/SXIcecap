
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

<script src="<%=request.getContextPath() %>/js/NanumGothicLight-normal.js" defer></script>

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
	List<String> abstractFieldList  = (List<String>)renderRequest.getAttribute(StationXWebKeys.ABSTRACT_FIELDS);

	StructuredDataManagementToolbarDisplayContext structuredDataManagementToolbarDisplayContext = 
		(StructuredDataManagementToolbarDisplayContext)renderRequest.getAttribute(
									StationXWebKeys.MANAGEMENT_TOOLBAR_DISPLAY_CONTEXT);

	String viewStyle = ParamUtil.getString(
							renderRequest, 
							StationXWebKeys.DISPLAY_STYLE, 
							StationXConstants.VIEW_TYPE_TABLE);
	
	PortletRequest portletRequest = (PortletRequest)renderRequest.getAttribute("javax.portlet.request");
	
%>

<portlet:renderURL var="editStructuredDataURL">
    <portlet:param 
    		name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    		value="<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_EDIT %>"/>
    <portlet:param 
    		name="<%= StationXWebKeys.BACK_URL %>" 
    		value="<%= currentURL %>"/>
	<portlet:param name="dataTypeId" value="<%= String.valueOf(dataType.getDataTypeId()) %>"/>
</portlet:renderURL>

<portlet:renderURL var="advancedSearchURL">
	<portlet:param 
    		name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    		value="<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_ADVANCED_SEARCH %>"/>
    <portlet:param 
    		name="<%= StationXWebKeys.BACK_URL %>" 
    		value="<%= currentURL %>"/>
	<portlet:param name="dataTypeId" value="<%= String.valueOf(dataType.getDataTypeId()) %>"/>
</portlet:renderURL>

<portlet:resourceURL id="<%= IcecapMVCCommands.RESOURCE_DATATYPE_LOAD_STRUCTURE  %>"  var="getDataStructureURL">
	<portlet:param
			name="<%= IcecapWebKeys.DATATYPE_ID %>"
			value="<%= String.valueOf(dataType.getDataTypeId()) %>" />
</portlet:resourceURL>

<aui:container cssClass="station-x">
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
								<aui:input name="datatype-name" disabled="true" value="<%= dataType.getDisplayName(locale) %>"></aui:input>
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

<aui:container>
	<aui:row>
		<aui:col>
			<a class="btn btn-primary sxtooltip" href="<%=editStructuredDataURL.toString() %>" style="width:50px; float:left;margin-left:50px;" title="<%= LanguageUtil.get(locale, "add")%>">
				<svg class="lexicon-icon lexicon-icon-plus" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M479.82 224.002h-192.41v-191.91c0-17.6-14.4-32-32-32v0c-17.6 0-32 14.4-32 32v191.91h-191.41c-17.6 0-32 14.4-32 32v0c0 17.6 14.4 32 32 32h191.41v191.91c0 17.6 14.4 32 32 32v0c17.6 0 32-14.4 32-32v-191.909h192.41c17.6 0 32-14.4 32-32v0c0-17.6-14.4-32-32-32z"></path>
				</svg>
			</a>
			<input type="image" 
						id="<portlet:namespace/>pdf" name="<portlet:namespace/>pdf" 
						src="<%= request.getContextPath() %>/svg/pdf-svgrepo-com.svg"
						class="btn btn-default sxtooltip"
						style="width:50px;height:40px;float:right;margin-left:5px;margin-right:50px;padding:5px 0px;"
						title="<%= LanguageUtil.get(locale, "pdf")%>">
			<input type="image" 
						id="<portlet:namespace/>search" name="<portlet:namespace/>search" 
						src="<%= request.getContextPath() %>/svg/search-svgrepo-com.svg" 
						class="btn btn-default sxtooltip"
						style="width:50px;height:40px;float:right;margin-left:5px;padding: 0px;"
						title="<%= LanguageUtil.get(locale, "search")%>">
		</aui:col>
	</aui:row>
</aui:container>

<div class="closed container-fluid container-fluid-max-xl sidenav-container sidenav-right" id="<portlet:namespace />structuredDataInfoPanelId" style="margin-top:10px;">
	<liferay-frontend:sidebar-panel
		searchContainerId="<%= structuredDataManagementToolbarDisplayContext.getSearchContainerId() %>"
	>	</liferay-frontend:sidebar-panel>
	
	<div class="sidenav-content">
		<aui:form 
					action=""
					method="post" 
					name="<%= structuredDataManagementToolbarDisplayContext.getSearchFormName() %>">
			<aui:input name="cmd" type="hidden"></aui:input>
			<aui:input name="redirect" type="hidden"></aui:input>
		</aui:form>
		
		<liferay-ui:search-container 
			 		id="<%= structuredDataManagementToolbarDisplayContext.getSearchContainerId() %>"
				    searchContainer="<%= structuredDataManagementToolbarDisplayContext.getSearchContainer() %>" >
	    
	        <liferay-ui:search-container-row
						className="com.sx.icecap.model.StructuredData" 
						keyProperty="structuredDataId" 
						modelVar="structuredData">
				<%
					Map<String, Object> rowData = new HashMap<>();

					row.setData(rowData);

					PortletURL rowURL = renderResponse.createRenderURL();

					rowURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_FULL_CONTENT);
					rowURL.setParameter(StationXWebKeys.REDIRECT, currentURL);
					rowURL.setParameter(StationXWebKeys.STRUCTURED_DATA_ID, String.valueOf(structuredData.getPrimaryKey()));
					
					JSONObject jsonData = JSONFactoryUtil.createJSONObject( structuredData.getStructuredData() );
					
					String abstractData = "";
					Iterator<String> keys = jsonData.keys();
					for( String field : abstractFieldList ){ 
						if( jsonData.has(field) ){
							abstractData +=  field + ":" + jsonData.getString(field) ;
							if(  abstractFieldList.indexOf(field) < (abstractFieldList.size() - 1) ){
								abstractData += ", ";
							}
						}
					}
				%>
				
				<c:choose>
					<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_CARDS) %>">
						<%
							row.setCssClass("lfr-asset-item col-md-3 col-sm-4 col-xs-6");
							RowChecker rowChecker = searchContainer.getRowChecker();
							if( Validator.isNull(rowChecker) ){
								out.println("<h1>rowChecker is null...</h1>" );
							}
							/*
							rowChecker.setData( rowData );
							*/
							StructuredDataVerticalCard dataTypeVerticalCard = new StructuredDataVerticalCard(
									structuredData, 
									renderRequest, 
									renderResponse, 
									rowChecker, 
									rowURL.toString(),
									structuredDataManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, structuredData.getPrimaryKey()));
						%>
					</c:when>
					<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_LIST) %>">
						<liferay-ui:search-container-column-text href="<%=rowURL.toString() %>" >
							<h5 class="text-default"><%= structuredData.getStructuredDataId() %></h5>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text >
  								<%= abstractData %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text>
							<clay:dropdown-actions
								dropdownItems="<%= structuredDataManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, structuredData.getPrimaryKey()) %>"
							/>
						</liferay-ui:search-container-column-text>
					</c:when>
					<c:otherwise>
						<%
							row.setCssClass("col-md-12 "+row.getCssClass() );
						%>
						<liferay-ui:search-container-column-text
						 			name="id"
						 			href="<%=rowURL.toString() %>"
						 			cssClass="id-width"
									value="<%= String.valueOf(structuredData.getStructuredDataId()) %>"/>
						<liferay-ui:search-container-column-text
						 			name="abstract"
						 			href="<%=rowURL.toString() %>"
						 			cssClass="abstract-width"
									value="<%= abstractData %>"/>
									
						<liferay-ui:search-container-column-status 
									name="status"
									cssClass="status-width"
									property="status" />
		
						<liferay-ui:search-container-column-text 
									name="actions"
									cssClass="actions-width">
							<clay:dropdown-actions
								dropdownItems="<%= structuredDataManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, structuredData.getPrimaryKey()) %>"
							/>
						</liferay-ui:search-container-column-text>
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-row>
			
			<c:choose>
				<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_TABLE) %>">
					<liferay-ui:search-iterator
							markupView="lexicon" />
				</c:when>
				<c:otherwise>
					<liferay-ui:search-iterator
							displayStyle = "<%= viewStyle %>"
							markupView="lexicon" />
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container>
	</div>
</div>

<div id="<portlet:namespace/>printPDF" style="display:none;">
</div>

<script type="text/javascript">
$('.sxtooltip').tooltip();	

$('#<portlet:namespace/>pdf').on('click', function(event){
	$.ajax({
		url: '<%= getDataStructureURL.toString() %>',
		method: 'post',
		dataType: 'json',
		success: function( result ){
			console.log( 'getDataStructure: ', result );
			
			let SX = new StationX('<portlet:namespace/>', 
					'<%= defaultLocale.toString() %>',
					'<%= locale.toString() %>',
					<%= jsonLocales.toJSONString() %> );
			
			let $canvas = $('<div class="container"></div>');
			let dataStructure = SX.newDataStructure(
						result.dataStructure,
						{},
						SX.Constants.FOR_PDF_DATA,
						$canvas );
						
			console.log( 'dataStructure: ', dataStructure );
			
			let $pdf = dataStructure.renderDataToPDF( 'Data List of '+'<%= dataType.getDisplayName(locale) %>', result.data );
			$('#<portlet:namespace/>printPDF' ).empty();
			$('#<portlet:namespace/>printPDF' ).append( $pdf );
			
			$('#<portlet:namespace/>printPDF' ).show();
			
			const pdf = new jsPDF('p', 'pt', 'a4');
			pdf.setProperties({
				title: '<%= dataType.getDisplayName(locale) %>'
			});
	
			const image = { type: 'png', quality: 0.98 };
			const paperWidth = 595;
			const paperHeight = 842;
			const margins = {
					top: 50,
					right: 20,
					bottom: 40,
					left: 30
			};
					
			html2canvas($pdf[0], {scrollY: 0}).then( canvas => {
				const innerPageWidth = paperWidth - (margins.left + margins.right);
				const innerPageHeight = paperHeight - (margins.top + margins.bottom);

				// Calculate the number of pages.
				const pxFullHeight = canvas.height;
				const pxPageHeight = Math.floor(canvas.width * (paperHeight / paperWidth));
				const nPages = Math.ceil(pxFullHeight / pxPageHeight);

				// Define pageHeight separately so it can be trimmed on the final page.
				let pageHeight = innerPageHeight;

				// Create a one-page canvas to split up the full image.
				const pageCanvas = document.createElement('canvas');
				const pageCtx = pageCanvas.getContext('2d');
				pageCanvas.width = canvas.width;
				pageCanvas.height = pxPageHeight;

				for( let page = 0; page < nPages; page++ ) {
					if (page === nPages - 1 && pxFullHeight % pxPageHeight !== 0) {
						pageCanvas.height = pxFullHeight % pxPageHeight;
						pageHeight = (pageCanvas.height * innerPageWidth) / pageCanvas.width;
					}

					const width = pageCanvas.width;
					const height = pageCanvas.height;
					pageCtx.fillStyle = 'white';
					pageCtx.fillRect( 0, 0, width, height);
					pageCtx.drawImage( canvas, 0, page * pxPageHeight, width, height, 0, 0, width, height );

					if( page > 0 ){
						pdf.addPage();
					}
					
					const imgData = pageCanvas.toDataURL( 'image/' + image.type, image.quality );
					pdf.addImage( imgData, image.type, margins.left, margins.top, innerPageWidth, pageHeight );

					const pageText = '- '+(page+1)+' -'; 
					pdf.setFontSize(10);
					pdf.text( pageText, (paperWidth+$('<span>'+pageText+'</span>').width())/2, 820 );
				}

				window.open(pdf.output('bloburl'));
				$pdf.remove();
			});
		},
		error: function( error ){
			console.log('AJAX error: ', error);
		}
	});
	
});
$('#<portlet:namespace/>search').on('click', function(event){
	window.location = '<%= advancedSearchURL %>';
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
</script>
