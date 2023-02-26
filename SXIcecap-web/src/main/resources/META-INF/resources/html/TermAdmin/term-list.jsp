
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.sx.debug.Debug"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.sx.icecap.web.taglib.clay.sss.TermVerticalCard"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.sx.icecap.constant.IcecapConstants"%>
<%@page import="com.sx.icecap.web.display.context.sss.TermAdminManagementToolbarDisplayContext"%>
<%@page import="com.sx.icecap.constant.IcecapJsps"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@ include file="../init.jsp" %>

<%
	TermAdminManagementToolbarDisplayContext termAdminManagementToolbarDisplayContext = 
		(TermAdminManagementToolbarDisplayContext)renderRequest.getAttribute(
		TermAdminManagementToolbarDisplayContext.class.getName());

	String viewStyle = ParamUtil.getString(
			renderRequest, 
			StationXWebKeys.DISPLAY_STYLE, 
			StationXConstants.VIEW_TYPE_TABLE);
	
	Debug.printHeader("term-list");
	Debug.printAllParameters(renderRequest);
	
	System.out.println( request.getContextPath());
	Debug.printFooter("term-list");
%>

<portlet:renderURL var="addTermURL">
    <portlet:param 
    		name="<%=StationXWebKeys.MVC_RENDER_COMMAND_NAME%>" 
    		value="<%=IcecapMVCCommands.RENDER_ADMIN_TERM_EDIT%>"/>
    <portlet:param 
    		name="<%=StationXWebKeys.BACK_URL%>" 
    		value="<%=currentURL%>"/>
</portlet:renderURL>

<portlet:renderURL var="searchViewURL">
    <portlet:param name="mvcPath" 
    value="<%=IcecapJsps.ADMIN_VIEW_SEARCH_TERMS_JSP%>" />
</portlet:renderURL>

<portlet:renderURL var="searchTermsURL">
    <portlet:param name="<%=StationXWebKeys.MVC_RENDER_COMMAND_NAME%>" 
    value="<%=IcecapMVCCommands.RENDER_ADMIN_SEARCH_TERMS%>" />
</portlet:renderURL>

<portlet:actionURL name="<%=IcecapMVCCommands.ACTION_ADMIN_SEARCH_TERMS%>"  var="searchActionURL">
</portlet:actionURL>

<portlet:actionURL name="<%=IcecapMVCCommands.ACTION_ADMIN_BULK_ACTIONS%>"  var="bulkActionURL">
</portlet:actionURL>


<clay:management-toolbar
	displayContext="<%=termAdminManagementToolbarDisplayContext%>"
/>
	
<div class="closed container-fluid container-fluid-max-xl sidenav-container sidenav-right" id="<portlet:namespace />infoPanelId">
	<liferay-frontend:sidebar-panel
		searchContainerId="<%=IcecapConstants.TERM_SEARCH_CONTAINER_ID%>"
	>	</liferay-frontend:sidebar-panel>
	
	<div class="sidenav-content">
		<aui:form action="<%=bulkActionURL.toString()%>" 
				method="<%=termAdminManagementToolbarDisplayContext.getSearchFormMethod()%>" 
				name="<%=termAdminManagementToolbarDisplayContext.getSearchFormName()%>">
			<aui:input name="cmd" id="cmd" type="hidden"></aui:input>
			<aui:input name="redirect" type="hidden"></aui:input>
		
	 	<liferay-ui:search-container 
	 		id="<%=IcecapConstants.TERM_SEARCH_CONTAINER_ID%>"
		    searchContainer="<%=termAdminManagementToolbarDisplayContext.getSearchContainer()%>" >
		    
		        <liferay-ui:search-container-row
							className="com.sx.icecap.model.Term" 
							keyProperty="termId" 
							modelVar="term"
							escapedModel="<%=true%>">
							
					<%
													Map<String, Object> rowData = new HashMap<>();

																												// rowData.put("actions", StringUtil.merge(termAdminManagementToolbarDisplayContext.getAvailableActions(term)));

																												row.setData(rowData);
																												//row.setCssClass("col-md-12");

																												PortletURL rowURL = renderResponse.createRenderURL();

																												rowURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_ADMIN_TERM_VIEW);
																												rowURL.setParameter(StationXWebKeys.REDIRECT, currentURL);
																												rowURL.setParameter(StationXWebKeys.TERM_ID, String.valueOf(term.getTermId()));
												%>
					<c:choose>
						<c:when test="<%=viewStyle.equals(StationXConstants.VIEW_TYPE_CARDS)%>">
							<%
								row.setCssClass("lfr-asset-item col-md-3 col-sm-4 col-xs-6");
													RowChecker rowChecker = searchContainer.getRowChecker();
													rowChecker.setData( rowData );
													TermVerticalCard termVerticalCard = new TermVerticalCard(
															term, 
															renderRequest, 
															renderResponse, 
															rowChecker, 
															rowURL.toString(),
															termAdminManagementToolbarDisplayContext.getTermActionDropdownItems(term.getTermId()));
							%>
							<liferay-ui:search-container-column-text>
								<clay:vertical-card
										verticalCard="<%=termVerticalCard%>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:when test="<%=viewStyle.equals(StationXConstants.VIEW_TYPE_LIST)%>">
							<liferay-ui:search-container-column-text href="<%=rowURL.toString()%>" >
								<h5 class=“text-default”><%=term.getDisplayName(locale)%></h5>
								<h5><%=term.getTermVersion()%></h5>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text  colspan="3" >
	  							<h6 class=“text-default”>
	    							<%=term.getTermName()%>
	  							</h6>
	  							<h6>
	  								<%=term.getDefinition(locale)%>
	  							</h6>
							</liferay-ui:search-container-column-text>
							<liferay-ui:search-container-column-text>
								<clay:dropdown-actions
									dropdownItems="<%=termAdminManagementToolbarDisplayContext.getTermActionDropdownItems(term.getTermId())%>"
								/>
							</liferay-ui:search-container-column-text>
						</c:when>
						<c:otherwise>
							<%
								row.setCssClass("col-md-12 "+row.getCssClass() );
							%>
							<liferay-ui:search-container-column-text
							 			name="display-name"
							 			href="<%=rowURL.toString()%>"
										value="<%=term.getDisplayName(locale)%>"/>
							<liferay-ui:search-container-column-text 
										name="parameter-name" 
										property="termName" />
							<liferay-ui:search-container-column-text 
										name="version" 
										property="termVersion"/>
							<liferay-ui:search-container-column-text 
										name="type" 
										property="termType" />
			
							<liferay-ui:search-container-column-text 
										name="definition" 
										value="<%=term.getDefinition(locale)%>" />
							
							<liferay-ui:search-container-column-text 
										name="modified-date"
										value="<%=DateUtil.getDate(term.getModifiedDate(), "yyyy-MM-dd", locale)%>"/>
							
							<liferay-ui:search-container-column-status 
										name="status" 
										property="status" />
			
							<liferay-ui:search-container-column-text name="actions">
								<clay:dropdown-actions
									dropdownItems="<%=termAdminManagementToolbarDisplayContext.getTermActionDropdownItems(term.getTermId())%>"
								/>
							</liferay-ui:search-container-column-text>
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-row>
				
				<c:choose>
					<c:when test="<%=viewStyle.equals(StationXConstants.VIEW_TYPE_TABLE)%>">
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
Liferay.componentReady('termAdminManagementToolbar').then(function(
		managementToolbar
	) {

		managementToolbar.on('actionItemClicked', function(event) {
			console.log('Data CMD: ', event.data.item.data.cmd );
			let cmd = event.data.item.data.cmd;
			
			if( cmd === 'DELETE_TERMS' ){
				$.confirm({
					title: '<liferay-ui:message key="confirm-delete-selected-terms" />',
					content: 'Are you sure delete selected terms?<br>The deleted terms cannot be restored ever!',
					type: 'orange',
					typeAnimated: true,
					buttons:{
						ok: {
							text: 'OK',
							btnClass: 'btn-blue',
							action: function(){
								let selectedTerms = $('#<portlet:namespace/>'+'searchedTermsContainer').find('input:checked');
								let termIds = selectedTerms.toArray().map( term=>$(term).val() );
								console.log( 'Term IDs: ', termIds.toString() );
								let form = document.getElementById('<portlet:namespace />searchForm');
								
								$('#<portlet:namespace/>cmd').val( cmd );
					
								Liferay.Util.postForm(form);
							}
						},
						cancel: function(){
							
						}
					},
					draggable: true
				});
			}
			
		});
	});
</script>
