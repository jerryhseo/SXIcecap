
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
    		name="<%= StationXWebKeys.REDIRECT %>" 
    		value="<%= currentURL %>"/>
</portlet:renderURL>

<portlet:renderURL var="searchStructuredDataViewURL">
    <portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    value="<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_VIEW %>" />
</portlet:renderURL>

<portlet:renderURL var="searchStructuredDataURL">
    <portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    value="<%= IcecapMVCCommands.RENDER_SEARCH_STRUCTURED_DATA %>" />
</portlet:renderURL>

<clay:management-toolbar
	displayContext="<%= structuredDataManagementToolbarDisplayContext %>"
/>
	
<div class="closed container-fluid container-fluid-max-xl sidenav-container sidenav-right" id="<portlet:namespace />structuredDataInfoPanelId">
	<liferay-frontend:sidebar-panel
		searchContainerId="<%= IcecapConstants.STRUCTURED_DATA_SEARCH_CONTAINER_ID %>"
	>	</liferay-frontend:sidebar-panel>
	
	<div class="sidenav-content">
		<aui:form 
					action="" 
					method="<%= structuredDataManagementToolbarDisplayContext.getSearchFormMethod() %>" 
					name="<%= structuredDataManagementToolbarDisplayContext.getSearchFormName() %>">
			<aui:input name="cmd" type="hidden"></aui:input>
			<aui:input name="redirect" type="hidden"></aui:input>
		
			<liferay-ui:search-container 
				 		id="<%= IcecapConstants.STRUCTURED_DATA_SEARCH_CONTAINER_ID %>"
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
						abstractFieldList.forEach(field->{System.out.println("abastract field: " + field);});
						
						while( keys.hasNext() ){
							String key = keys.next();
							System.out.println("----key: " + key );
							if( abstractFieldList.contains(key) ){
								 System.out.println(  "Value:" + jsonData.getString(key));
								abstractData +=  key + ":" + jsonData.getString(key) + ", ";
							}
						}
						
						System.out.println("Abstract Data: " + abstractData );
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
								<h5 class="€œtext-default"€><%= structuredData.getStructuredDataId() %></h5>
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
										value="<%= String.valueOf(structuredData.getStructuredDataId()) %>"/>
							<liferay-ui:search-container-column-text
							 			name="abstract"
							 			href="<%=rowURL.toString() %>"
										value="<%= abstractData %>"/>
			
							<liferay-ui:search-container-column-text name="actions">
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
			
		</aui:form>
	</div>
</div>

<script type="text/javascript">
Liferay.componentReady('<%= IcecapConstants.STRUCTURED_DATA_MANAGEMENT_TOOLBAR_COMPONENT_ID %>').then(function(
		managementToolbar
	) {

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
