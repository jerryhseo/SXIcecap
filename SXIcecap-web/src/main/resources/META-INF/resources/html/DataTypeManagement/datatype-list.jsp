
<%@page import="com.sx.constant.StationXPropertyKeys"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthTokenUtil"%>
<%@page import="com.sx.util.SXPortalUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.sx.icecap.constant.IcecapWebPortletKeys"%>
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.sx.icecap.web.taglib.clay.datatype.DataTypeVerticalCard"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.icecap.constant.IcecapConstants"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.sx.icecap.web.display.context.datatype.DataTypeManagementToolbarDisplayContext"%>
<%@ include file="../init.jsp" %>

<%
	DataTypeManagementToolbarDisplayContext dataTypeManagementToolbarDisplayContext = 
		(DataTypeManagementToolbarDisplayContext)renderRequest.getAttribute(
		DataTypeManagementToolbarDisplayContext.class.getName());

	String viewStyle = ParamUtil.getString(
							renderRequest, 
							StationXWebKeys.DISPLAY_STYLE, 
							StationXConstants.VIEW_TYPE_TABLE);
	
	Layout layoutStructuredDataListView = LayoutLocalServiceUtil.getFriendlyURLLayout(
							themeDisplay.getSiteGroupId(), false, "/structured-data");
	
	PortletRequest portletRequest = (PortletRequest)renderRequest.getAttribute("javax.portlet.request");
	
%>


<portlet:renderURL var="createDataTypeURL">
    <portlet:param 
    		name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    		value="<%= IcecapMVCCommands.RENDER_DATATYPE_EDIT %>"/>
    <portlet:param 
    		name="<%= StationXWebKeys.REDIRECT %>" 
    		value="<%= currentURL %>"/>
</portlet:renderURL>

<portlet:renderURL var="searchViewURL">
    <portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    value="<%= IcecapMVCCommands.RENDER_DATATYPE_VIEW %>" />
</portlet:renderURL>

<portlet:renderURL var="searchTermsURL">
    <portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" 
    value="<%= IcecapMVCCommands.RENDER_SEARCH_DATATYPES %>" />
</portlet:renderURL>

<clay:management-toolbar
	displayContext="<%= dataTypeManagementToolbarDisplayContext %>"
/>
	
<div class="closed container-fluid container-fluid-max-xl sidenav-container sidenav-right" id="<portlet:namespace />dataTypeInfoPanelId">
	<liferay-frontend:sidebar-panel
		searchContainerId="<%= IcecapConstants.DATATYPE_SEARCH_CONTAINER_ID %>"
	>	</liferay-frontend:sidebar-panel>
	
	<div class="sidenav-content">
		<aui:form 
					action="" 
					method="<%= dataTypeManagementToolbarDisplayContext.getSearchFormMethod() %>" 
					name="<%= dataTypeManagementToolbarDisplayContext.getSearchFormName() %>">
			<aui:input name="cmd" type="hidden"></aui:input>
			<aui:input name="redirect" type="hidden"></aui:input>
		
		 	<liferay-ui:search-container 
				 		id="<%= IcecapConstants.DATATYPE_SEARCH_CONTAINER_ID %>"
					    searchContainer="<%= dataTypeManagementToolbarDisplayContext.getSearchContainer() %>" >
		    
		        <liferay-ui:search-container-row
							className="com.sx.icecap.model.DataType" 
							keyProperty="dataTypeId" 
							modelVar="dataType"
							escapedModel="<%=true%>">
							
					<%
						Map<String, Object> rowData = new HashMap<>();

						row.setData(rowData);

						PortletURL rowURL = renderResponse.createRenderURL();

						rowURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_DATATYPE_FULL_CONTENT);
						rowURL.setParameter(StationXWebKeys.REDIRECT, currentURL);
						rowURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataType.getDataTypeId()));
								
					%>
					
					<liferay-portlet:renderURL 
									plid="<%= layoutStructuredDataListView.getPlid() %>"
									portletName="<%= IcecapWebPortletKeys.STRUCTURED_DATA %>"
									varImpl="sdlViewURL">
						<portlet:param name="dataTypeId" value="<%= String.valueOf(dataType.getDataTypeId()) %>" />
						<portlet:param name="mvcRenderCommandName" value="<%= IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST %>" />
					</liferay-portlet:renderURL>
					
					<c:choose>
						<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_CARDS) %>">
							<%
								row.setCssClass("lfr-asset-item col-md-3 col-sm-4 col-xs-6");
								RowChecker rowChecker = searchContainer.getRowChecker();
								rowChecker.setData( rowData );
								DataTypeVerticalCard dataTypeVerticalCard = new DataTypeVerticalCard(
										dataType, 
										renderRequest, 
										renderResponse, 
										rowChecker, 
										rowURL.toString(),
										dataTypeManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, dataType.getDataTypeId(), sdlViewURL.toString()));
							%>
							<liferay-ui:search-container-column-text>
								<clay:vertical-card
										verticalCard="<%= dataTypeVerticalCard %>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test="<%= viewStyle.equals(StationXConstants.VIEW_TYPE_LIST) %>">
							<liferay-ui:search-container-column-text href="<%=rowURL.toString() %>" >
								<h5 class="text-default"€><%= dataType.getDisplayName(locale) %></h5>
								<h5><%= dataType.getDataTypeVersion() %></h5>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text  colspan="3" >
	  							<h6 class="text-default"€>
	    							<%= dataType.getDataTypeName() %>
	  							</h6>
	  							<h6>
	  								<%= dataType.getDescription(locale) %>
	  							</h6>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text>
								
								<clay:dropdown-actions
									dropdownItems="<%= dataTypeManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, dataType.getDataTypeId(), sdlViewURL.toString()) %>"
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
										value="<%=dataType.getDisplayName(locale)%>"/>
							<liferay-ui:search-container-column-text 
										name="parameter-name" 
										property="dataTypeName" />
							<liferay-ui:search-container-column-text 
										name="version" 
										property="dataTypeVersion"/>
			
							<liferay-ui:search-container-column-text 
										name="description" 
										value="<%= dataType.getDescription(locale)%>" />
							
							<liferay-ui:search-container-column-text 
										name="modified-date"
										value="<%= DateUtil.getDate(dataType.getModifiedDate(), "yyyy-MM-dd", locale) %>"/>
							
							<liferay-ui:search-container-column-status 
										name="status" 
										property="status" />
			
							<liferay-ui:search-container-column-text name="actions">
								<clay:dropdown-actions
									dropdownItems="<%= dataTypeManagementToolbarDisplayContext.getItemActionDropdownItems(portletRequest, dataType.getDataTypeId(), sdlViewURL.toString()) %>"
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
Liferay.componentReady('<%= IcecapConstants.DATATYPE_MANAGEMENT_TOOLBAR_COMPONENT_ID %>').then(function(
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
