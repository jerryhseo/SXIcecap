<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.icecap.constant.IcecapConstants"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="../init.jsp" %>

<%
	long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID, 0);
	DataType dataType = null;
	
	boolean isAdd = true;
	if( dataTypeId > 0 ){
		isAdd = false;
		dataType = (DataType)renderRequest.getAttribute(StationXWebKeys.DATATYPE);
	}
	boolean isUpdate = !isAdd;
	
%>

<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATATYPE_ADD %>" var="addActionURL">
</portlet:actionURL>
<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATATYPE_CREATE_AND_DEFINE_STRUCTURE %>" var="addToDefineStructureActionURL">
	<portlet:param name="<%= StationXWebKeys.CMD %>" value="<%= IcecapConstants.CMD_REDIRECT_TO_DEFINE_STRUCTURE %>"/>
	<portlet:param name="<%= StationXWebKeys.BACK_URL %>" value="<%= currentURL %>"/>
</portlet:actionURL>
<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATATYPE_UPDATE %>" var="updateActionURL">
</portlet:actionURL>
<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATATYPE_UPDATE_AND_DEFINE_STRUCTURE %>" var="updateToDefineStructureActionURL">
	<portlet:param name="<%= StationXWebKeys.CMD %>" value="<%= IcecapConstants.CMD_REDIRECT_TO_DEFINE_STRUCTURE %>"/>
	<portlet:param name="<%= StationXWebKeys.BACK_URL %>" value="<%= currentURL %>"/>
</portlet:actionURL>
<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATATYPE_DELETE %>" var="deleteActionURL">
	<portlet:param name="<%= StationXWebKeys.DATATYPE_ID %>" value="<%= String.valueOf(dataTypeId) %>"/>
</portlet:actionURL>

<portlet:renderURL var="defineStructureRenderURL">
	<portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" value="<%= IcecapMVCCommands.RENDER_DEFINE_DATA_STRUCTURE %>"/>
	<portlet:param name="<%= StationXWebKeys.DATATYPE_ID %>" value="<%= String.valueOf(dataTypeId) %>"/>
	<portlet:param name="<%= StationXWebKeys.BACK_URL %>" value="<%= currentURL %>"/>
</portlet:renderURL>

<portlet:renderURL var="dataTypeListURL">
	<portlet:param name="<%= StationXWebKeys.MVC_RENDER_COMMAND_NAME %>" value="<%= IcecapMVCCommands.RENDER_DATATYPE_LIST %>"></portlet:param>
</portlet:renderURL>

<portlet:resourceURL 
		id="<%= IcecapMVCCommands.RESOURCE_DATATYPE_RENDER_TERM %>" 
		var="renderTermAttributes">
</portlet:resourceURL>

<aui:container cssClass="SXIcecap-web">
	<aui:row>
		<aui:col md="2">
			<a href="<%=dataTypeListURL%>"><clay:icon symbol="caret-left"/>&nbsp;<liferay-ui:message key="back-to-list" /></a>
		</aui:col>
	</aui:row>
	<aui:row>
		<%
			String pageTitleKey = "edit-datatype"; 
			if( isAdd ){
				pageTitleKey = "create-datatype";
			}
		%>
		<aui:col md="6" >
			<h3  class="height-full"><span class="vertical-align-bottom"><liferay-ui:message key="<%= pageTitleKey %>" /></span></h3>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col>
			<hr class="title-horizontal-line">
		</aui:col>
	</aui:row>
	<aui:form action="" method="post" name="dataTypeForm" id="dataTypeForm">
		<c:if test="<%= isUpdate %>">
		<aui:row>
			<aui:col>
			<aui:input type="hidden" name="dataTypeId" value="<%= dataTypeId %>"></aui:input>
			<aui:input type="hidden" name="status" value="<%= dataType.getStatus() %>"></aui:input>
			<aui:input type="hidden" name="backURL" value="<%= currentURL %>"></aui:input>
			</aui:col>
		</aui:row>
		</c:if>
		<aui:row>
			<aui:col md="6">
				<aui:input
						name="dataTypeName" 
						label="datatype-name"  
						required="true" 
						placeholder="dataTypeName"
						value="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getDataTypeName() %>"
						helpMessage="datatype-name-help">
				</aui:input>
			</aui:col>
			<aui:col md="2">
				<aui:input
						name="dataTypeVersion" 
						label="version"  
						required="true" 
						placeholder="1.0.0"
						value="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getDataTypeVersion() %>"
						helpMessage="datatype-version-help">
				</aui:input>
			</aui:col>
			<aui:col md="2">
				<aui:input
						name="extension" 
						label="extension"  
						required="true" 
						placeholder="docx"
						value="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getExtension() %>"
						helpMessage="datatype-extension-help">
				</aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<aui:field-wrapper
						name="description"
						label="description"
						helpMessage="datatype-description-help">
					<liferay-ui:input-localized 
							type="textarea" 
							xml="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getDescription() %>" 
							name="description">
					</liferay-ui:input-localized>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<aui:field-wrapper
						name="displayName"
						label="display-name"
						required="true"
						helpMessage="display-name-help">
					<liferay-ui:input-localized 
							xml="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getDisplayName() %>" 
							name="displayName">
					</liferay-ui:input-localized>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col>
				<aui:field-wrapper
						name="tooltip"
						label="tooltip"
						helpMessage="datatype-tooltip-help">
					<liferay-ui:input-localized 
							type="textarea" 
							xml="<%= Validator.isNull(dataType)?StringPool.BLANK:dataType.getTooltip() %>" 
							name="tooltip">
					</liferay-ui:input-localized>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
		<aui:button-row>
			<%
				String submitButtonTitle = "create-and-view-list";
				String defineStructureButtonTitle = "create-and-define-structure";
				if( isUpdate ){
					submitButtonTitle = "update-and-view-list";
					defineStructureButtonTitle = "update-and-define-structure";
				}
			%>
			<aui:button type="submit" name="btnSaveToList" value="<%= submitButtonTitle %>"></aui:button>
			<aui:button type="submit" name="btnSaveToDefineStructure"  value="<%= defineStructureButtonTitle %>"></aui:button>
			<c:if test="<%= isUpdate %>">
				<%
					boolean hasDataStructure = dataType.getHasDataStructure();
					String defineDataStructureBtnLabel = LanguageUtil.get(locale, "define-data-structure");
					if( hasDataStructure ){
						defineDataStructureBtnLabel = LanguageUtil.get(locale, "edit-data-structure");
					}
				%>
				<aui:button 
						id="btnDefineStructure"  
						value="<%= defineDataStructureBtnLabel %>" 
						href="<%= defineStructureRenderURL.toString() %>">
				</aui:button>
				<aui:button id="btnDelete" value="delete"></aui:button>
			</c:if>
			<aui:button id="btnCancel" value="cancel" href="<%= backURL %>"></aui:button>
		</aui:button-row>
		
	</aui:form>	
</aui:container>


<aui:script>

$(document).ready(function(){
	const isUpdate = <%= isUpdate %>;
	
	$('#<portlet:namespace/>dataTypeName').change( function( event ){
		let name = $('#<portlet:namespace/>dataTypeName').val();
		
		if( !/^[_a-zA-Z]([_a-zA-Z0-9])*$/.test(name) ){
			$.alert( 'DataType Name[' + name +'] is unvalid for a datatype. Try another one.');
			$('#<portlet:namespace/>dataTypeName').val('');
		}
	});

	$('#<portlet:namespace/>btnSaveToList').click( function(){
		let actionURL = isUpdate ? '<%= updateActionURL.toString() %>' : '<%= addActionURL.toString() %>';
		
		
		$('#<portlet:namespace/>dataTypeForm').prop('action', actionURL);
		
	});
	
	$('#<portlet:namespace/>btnSaveToDefineStructure').click( function(){
		let actionURL = isUpdate ? '<%= updateToDefineStructureActionURL.toString() %>' : '<%= addToDefineStructureActionURL.toString() %>';
		
		$('#<portlet:namespace/>dataTypeForm').prop('action', actionURL);
	});
	
	$('#<portlet:namespace/>btnDelete').click( function(){
		$.confirm({
			title: '<liferay-ui:message key="confirm-delete-datatype" />',
			content: '<p><liferay-ui:message key="are-you-sure-to-delete-this-datatype-if-you-click-delete-then-it-is-impossible-to-get-back"/></p>',
			type: 'orange',
			typeAnimated: true,
			columnClass: 'medium',
			buttons:{
				ok: {
					text: '<liferay-ui:message key="delete"/>',
					btnClass: 'btn-blue',
					action: function(){
						$('#<portlet:namespace/>dataTypeForm').prop('action', '<%= deleteActionURL.toString() %>');
						$('#<portlet:namespace/>dataTypeForm').trigger('submit');
					}
				},
				cancel:{
					text: '<liferay-ui:message key="cancel"/>',
					btnClass: 'btn-default'
				}
			},
			draggable: true
		});
	});
	
});


</aui:script>