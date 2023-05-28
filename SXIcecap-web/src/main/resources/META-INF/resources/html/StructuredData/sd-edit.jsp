<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.petra.string.StringUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntryConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.model.TicketConstants"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.TicketLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Ticket"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.sx.icecap.constant.IcecapDataTypeAttributes"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sx.icecap.constant.IcecapWebKeys"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@ include file="../init.jsp" %>

<%
	DataType dataType = (DataType)renderRequest.getAttribute(DataType.class.getName());
	JSONObject structuredData = (JSONObject)renderRequest.getAttribute(IcecapWebKeys.STRUCTURED_DATA_JSON_OBJECT);
	
	String cmd = (String)renderRequest.getAttribute(StationXWebKeys.CMD);
	out.println( "CMD: "+cmd ) ;
	String structuredDataId = (String)renderRequest.getAttribute(IcecapWebKeys.STRUCTURED_DATA_ID);
	if( Validator.isNull(structuredDataId) ){
		structuredDataId = "0";
	}
	
	Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, null, new ServiceContext());
	
	Calendar today = Calendar.getInstance(locale);
%>

<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_STRUCTURED_DATA_ADD %>" var="saveActionURL">
	<portlet:param name="<%= StationXWebKeys.CMD %>" value="<%= cmd %>"/>
	<portlet:param name="<%= StationXWebKeys.DATATYPE_ID %>" value="<%=String.valueOf(dataType.getDataTypeId()) %>"/>
	<portlet:param name="<%= IcecapWebKeys.STRUCTURED_DATA_ID %>" value="<%= structuredDataId %>"/>
</portlet:actionURL>

<aui:container cssClass="SXIcecap-web">
	<aui:row cssClass="form-section">
		<aui:col md="12" >
			<aui:form action="<%= saveActionURL %>" enctype="multipart/form-data" escapeXml="true" method="POST" name="fm" inlineLabels="true" >
				<aui:field-wrapper name="testDate" label="today">
					<liferay-ui:input-date name="testDate"
									showDisableCheckbox="true"
									dateTogglerCheckboxLabel="Toggle"
									yearValue="<%=  today.get(Calendar.YEAR) %>" yearParam="year"
									monthValue= "<%= today.get(Calendar.MONTH) %>" monthParam="month"
									dayValue="<%= today.get(Calendar.DAY_OF_MONTH) %>"  dayParam="day"></liferay-ui:input-date>
				</aui:field-wrapper>
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="datatype">
						<span style="display:table-cell; width:40%;">
						<aui:input name="datatype-name" disabled="true" value="<%= dataType.getDataTypeName() %>"></aui:input>
						</span>
						<span style="display:table-cell; width:10%;">
						<aui:input name="datatype-version" disabled="true" value="<%= dataType.getDataTypeVersion() %>"></aui:input>
						</span>
						<span style="display:table-cell; width:20%;">
						<aui:input name="datatype-extention" disabled="true" value="<%= dataType.getExtension() %>"></aui:input>
						</span>
					</aui:fieldset>
				</aui:fieldset-group>
				<div>
					<span><%= dataType.getTooltip(locale) %></span>
				</div>
				<hr class=""></hr>
				
				<input id="<portlet:namespace/>structuredData" name="<portlet:namespace/>structuredData"/>
				<input type="radio" id="<portlet:namespace/>hasFile" name="<portlet:namespace/>hasFile"/>
				<input type="text" id="<portlet:namespace/>uploadParamName" name="<portlet:namespace/>uploadParamName"/>
				<table class="table table-striped">
					<tbody id="<portlet:namespace/>canvasPanel">
					</tbody>
				</table>
				
				<aui:button-row>
					<c:choose>
						<c:when test="<%= cmd.equalsIgnoreCase(StationXConstants.CMD_ADD) %>">
							<aui:button type="submit" name="add"></aui:button>
						</c:when>
						<c:otherwise>
							<aui:button type="submit" name="update"></aui:button>
						</c:otherwise>
					</c:choose>
					<aui:button name="delete" value="delete"></aui:button>
				</aui:button-row>
			</aui:form>
		</aui:col>
	</aui:row>
</aui:container>

<script>
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
			'<%= defaultLocale.toString() %>',
			'<%= locale.toString() %>',
			<%= jsonLocales.toJSONString() %> );
	
	let jsonDataStructure = JSON.parse('<%= structuredData.toString() %>');
	
	let dataStructure = SX.newDataStructure(  jsonDataStructure, 0, SX.SXConstants.FOR_EDITOR );
	
	dataStructure.render( SX.SXConstants.FOR_EDITOR, $('#<portlet:namespace/>canvasPanel') );
	
	Liferay.on( SX.SXIcecapEvents.DATATYPE_SDE_VALUE_CHANGED, function( event ){
		let eventData = event.sxeventData;
		
		if( eventData.targetPortlet !== '<portlet:namespace/>' ){
			return;
		}
		
		let term = eventData.term;
		if( term.termType === SX.TermTypes.FILE){
			$('#<portlet:namespace/>hasFile').prop('checked', true);
			$('#<portlet:namespace/>uploadParamName').val( 
						term.termName );
		}
		
		$("#<portlet:namespace/>structuredData").val( dataStructure.toFileContent() );
		console.log( 'Changed Term Value: ', eventData.term);
		console.log("Data Structure after value changed... ", dataStructure.terms);
	});
});
</script>
