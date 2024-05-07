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

<aui:container cssClass="station-x">
	<aui:row>
		<%
			String pageTitleKey = "edit-datatype"; 
			if( isAdd ){
				pageTitleKey = "create-datatype";
			}
		%>
		<aui:col md="8" >
			<h3  class="height-full"><span class="vertical-align-bottom"><liferay-ui:message key="<%= pageTitleKey %>" /></span></h3>
		</aui:col>
		<aui:col md="4">
			<a href="<%=dataTypeListURL%>" style="float:right;"><clay:icon symbol="caret-left"/>&nbsp;<liferay-ui:message key="back-to-list" /></a>
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
			<aui:col md="6">
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
			<aui:col md="6">
				<fieldset style="box-shadow:0 1px 3px -1px rgba(0,0,0,0.6);width:100%;margin-bottom:1.0rem;">
					<legend  class="control-label" ><liferay-ui:message key="assigning-editors"/>
						<span class="taglib-icon-help lfr-portal-tooltip" title="<liferay-ui:message key="assigning-editors-help"/>">
							<span>
								<svg class="lexicon-icon lexicon-icon-question-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
									<path class="lexicon-icon-outline" d="M256 0c-141.37 0-256 114.6-256 256 0 141.37 114.629 256 256 256s256-114.63 256-256c0-141.4-114.63-256-256-256zM269.605 360.769c-4.974 4.827-10.913 7.226-17.876 7.226s-12.873-2.428-17.73-7.226c-4.857-4.827-7.285-10.708-7.285-17.613 0-6.933 2.428-12.844 7.285-17.788 4.857-4.915 10.767-7.402 17.73-7.402s12.932 2.457 17.876 7.402c4.945 4.945 7.431 10.854 7.431 17.788 0 6.905-2.457 12.786-7.431 17.613zM321.038 232.506c-5.705 8.923-13.283 16.735-22.791 23.464l-12.99 9.128c-5.5 3.979-9.714 8.455-12.668 13.37-2.955 4.945-4.447 10.649-4.447 17.145v1.901h-34.202c-0.439-2.106-0.731-4.184-0.936-6.291s-0.321-4.301-0.321-6.612c0-8.397 1.901-16.413 5.705-24.079s10.24-14.834 19.309-21.563l15.185-11.322c9.070-6.7 13.605-15.009 13.605-24.869 0-3.57-0.644-7.080-1.901-10.533s-3.219-6.495-5.851-9.128c-2.633-2.633-5.969-4.71-9.977-6.291s-8.66-2.369-13.927-2.369c-5.705 0-10.561 1.054-14.571 3.16s-7.343 4.769-9.977 8.017c-2.633 3.247-4.594 7.022-5.851 11.322s-1.901 8.66-1.901 13.049c0 4.213 0.41 7.548 1.258 10.065l-39.877-1.58c-0.644-2.311-1.054-4.652-1.258-7.080-0.205-2.399-0.321-4.769-0.321-7.080 0-8.397 1.58-16.619 4.74-24.693s7.812-15.214 13.927-21.416c6.114-6.173 13.663-11.176 22.645-14.951s19.368-5.676 31.188-5.676c12.229 0 22.996 1.785 32.3 5.355 9.274 3.57 17.087 8.25 23.435 14.014 6.319 5.764 11.089 12.434 14.248 19.982s4.74 15.331 4.74 23.289c0.058 12.581-2.809 23.347-8.514 32.27z"></path>
								</svg>
							</span>
							<span class="taglib-text hide-accessible"><liferay-ui:message key="list-options-help"></liferay-ui:message></span>
						</span>
						<span id="<portlet:namespace/>btnAssignEditors" class="right" style="margin-top:3px; margin-right:20px;">
								<svg class="lexicon-icon" x="0px" y="0px" focusable="false" role="button" viewBox="0 0 296 296">
									<g>
										<g>
											<g>
												<g>
													<circle style="fill:#16A085;" cx="148.5" cy="148.5" r="148.5"/>
												</g>
											</g>
										</g>
										<path style="fill:#0E7763;" d="M245.337,127.5l-193.674,42l124.85,124.85c59.546-11.369,106.468-58.291,117.837-117.837
											L245.337,127.5z"/>
										<polygon style="fill:#ECF0F1;" points="245.337,127.5 169.5,127.5 169.5,51.663 127.5,51.663 127.5,127.5 51.663,127.5 
											51.663,169.5 127.5,169.5 127.5,245.337 169.5,245.337 169.5,169.5 245.337,169.5 	"/>
									</g>
								</svg>
						</span>
					</legend>
					<div></div>
				</fieldset>
			</aui:col>
			<aui:col md="6">
				<fieldset style="box-shadow:0 1px 3px -1px rgba(0,0,0,0.6);width:100%;margin-bottom:1.0rem;">
					<legend  class="control-label" ><liferay-ui:message key="assigning-viewers"/>
						<span class="taglib-icon-help lfr-portal-tooltip" title="<liferay-ui:message key="assign-viewers-help"/>">
							<span>
								<svg class="lexicon-icon lexicon-icon-question-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
									<path class="lexicon-icon-outline" d="M256 0c-141.37 0-256 114.6-256 256 0 141.37 114.629 256 256 256s256-114.63 256-256c0-141.4-114.63-256-256-256zM269.605 360.769c-4.974 4.827-10.913 7.226-17.876 7.226s-12.873-2.428-17.73-7.226c-4.857-4.827-7.285-10.708-7.285-17.613 0-6.933 2.428-12.844 7.285-17.788 4.857-4.915 10.767-7.402 17.73-7.402s12.932 2.457 17.876 7.402c4.945 4.945 7.431 10.854 7.431 17.788 0 6.905-2.457 12.786-7.431 17.613zM321.038 232.506c-5.705 8.923-13.283 16.735-22.791 23.464l-12.99 9.128c-5.5 3.979-9.714 8.455-12.668 13.37-2.955 4.945-4.447 10.649-4.447 17.145v1.901h-34.202c-0.439-2.106-0.731-4.184-0.936-6.291s-0.321-4.301-0.321-6.612c0-8.397 1.901-16.413 5.705-24.079s10.24-14.834 19.309-21.563l15.185-11.322c9.070-6.7 13.605-15.009 13.605-24.869 0-3.57-0.644-7.080-1.901-10.533s-3.219-6.495-5.851-9.128c-2.633-2.633-5.969-4.71-9.977-6.291s-8.66-2.369-13.927-2.369c-5.705 0-10.561 1.054-14.571 3.16s-7.343 4.769-9.977 8.017c-2.633 3.247-4.594 7.022-5.851 11.322s-1.901 8.66-1.901 13.049c0 4.213 0.41 7.548 1.258 10.065l-39.877-1.58c-0.644-2.311-1.054-4.652-1.258-7.080-0.205-2.399-0.321-4.769-0.321-7.080 0-8.397 1.58-16.619 4.74-24.693s7.812-15.214 13.927-21.416c6.114-6.173 13.663-11.176 22.645-14.951s19.368-5.676 31.188-5.676c12.229 0 22.996 1.785 32.3 5.355 9.274 3.57 17.087 8.25 23.435 14.014 6.319 5.764 11.089 12.434 14.248 19.982s4.74 15.331 4.74 23.289c0.058 12.581-2.809 23.347-8.514 32.27z"></path>
								</svg>
							</span>
							<span class="taglib-text hide-accessible"><liferay-ui:message key="list-options-help"></liferay-ui:message></span>
						</span>
						<span id="<portlet:namespace/>btnAssignViewers" class="right" style="margin-top:3px; margin-right:20px;">
								<svg class="lexicon-icon" x="0px" y="0px" focusable="false" role="button" viewBox="0 0 296 296">
									<g>
										<g>
											<g>
												<g>
													<circle style="fill:#16A085;" cx="148.5" cy="148.5" r="148.5"/>
												</g>
											</g>
										</g>
										<path style="fill:#0E7763;" d="M245.337,127.5l-193.674,42l124.85,124.85c59.546-11.369,106.468-58.291,117.837-117.837
											L245.337,127.5z"/>
										<polygon style="fill:#ECF0F1;" points="245.337,127.5 169.5,127.5 169.5,51.663 127.5,51.663 127.5,127.5 51.663,127.5 
											51.663,169.5 127.5,169.5 127.5,245.337 169.5,245.337 169.5,169.5 245.337,169.5 	"/>
									</g>
								</svg>
						</span>
					</legend>
					<div></div>
				</fieldset>
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