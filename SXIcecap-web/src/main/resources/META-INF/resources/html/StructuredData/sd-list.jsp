
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
	StructuredDataManagementToolbarDisplayContext structuredDataManagementToolbarDisplayContext = 
		(StructuredDataManagementToolbarDisplayContext)renderRequest.getAttribute(
		StructuredDataManagementToolbarDisplayContext.class.getName());

	String viewStyle = ParamUtil.getString(
							renderRequest, 
							StationXWebKeys.DISPLAY_STYLE, 
							StationXConstants.VIEW_TYPE_TABLE);
%>

<portlet:renderURL var="editStructuredStructuredDataURL">
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
				 		id="<%= IcecapConstants.DATATYPE_SEARCH_CONTAINER_ID %>"
					    searchContainer="<%= structuredDataManagementToolbarDisplayContext.getSearchContainer() %>" >
		    
		        <liferay-ui:search-container-row
							className="com.sx.icecap.model.StructuredData" 
							keyProperty="structuredDataId" 
							modelVar="structuredData"
							escapedModel="<%=true%>">
							
					<%
						Map<String, Object> rowData = new HashMap<>();

								row.setData(rowData);

								PortletURL rowURL = renderResponse.createRenderURL();

								rowURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_FULL_CONTENT);
								rowURL.setParameter(StationXWebKeys.REDIRECT, currentURL);
								rowURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(structuredData.getStructuredDataId()));
					%>
					<c:choose>
						<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_CARDS) %>">
							<%
								row.setCssClass("lfr-asset-item col-md-3 col-sm-4 col-xs-6");
								RowChecker rowChecker = searchContainer.getRowChecker();
								rowChecker.setData( rowData );
								StructuredDataVerticalCard structuredDataVerticalCard = new StructuredDataVerticalCard(
										structuredData, 
										renderRequest, 
										renderResponse, 
										rowChecker, 
										rowURL.toString(),
										structuredDataManagementToolbarDisplayContext.getStructuredDataActionDropdownItems(structuredData.getStructuredDataId()));
							%>
							<liferay-ui:search-container-column-text>
								<clay:vertical-card
										verticalCard="<%= structuredDataVerticalCard %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_LIST) %>">
							<liferay-ui:search-container-column-text href="<%=rowURL.toString() %>" >
								<h5 class=“text-default”><%= structuredData.getDisplayName(locale) %></h5>
								<h5><%= structuredData.getStructuredDataVersion() %></h5>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text  colspan="3" >
	  							<h6 class=“text-default”>
	    							<%= structuredData.getStructuredDataName() %>
	  							</h6>
	  							<h6>
	  								<%= structuredData.getDescription(locale) %>
	  							</h6>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text>
								<clay:dropdown-actions
									dropdownItems="<%= structuredDataManagementToolbarDisplayContext.getStructuredDataActionDropdownItems(structuredData.getStructuredDataId()) %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<%
								row.setCssClass("col-md-12 "+row.getCssClass() );
							%>
							<liferay-ui:search-container-column-text
							 			name="display-name"
							 			href="<%=rowURL.toString() %>"
										value="<%=structuredData.getDisplayName(locale)%>"/>
							<liferay-ui:search-container-column-text 
										name="parameter-name" 
										property="structuredDataName" />
							<liferay-ui:search-container-column-text 
										name="version" 
										property="structuredDataVersion"/>
			
							<liferay-ui:search-container-column-text 
										name="description" 
										value="<%= structuredData.getDescription(locale)%>" />
							
							<liferay-ui:search-container-column-text 
										name="modified-date"
										value="<%= DateUtil.getDate(structuredData.getModifiedDate(), "yyyy-MM-dd", locale) %>"/>
							
							<liferay-ui:search-container-column-status 
										name="status" 
										property="status" />
			
							<liferay-ui:search-container-column-text name="actions">
								<clay:dropdown-actions
									dropdownItems="<%= structuredDataManagementToolbarDisplayContext.getStructuredDataActionDropdownItems(structuredData.getStructuredDataId()) %>"
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
Liferay.componentReady('structuredDataManagementToolbar').then(function(
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
