<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.sx.constant.StationXConstants"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.sx.icecap.constant.IcecapConstants"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@page import="com.sx.icecap.model.DataTypeStructure"%>
<%@ include file="../init.jsp" %>

<%
	long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID, 0);

	DataType dataType = (DataType)renderRequest.getAttribute(StationXWebKeys.DATATYPE);
	JSONObject dataStructure = null;
	boolean hasDataStructure = dataType.getHasDataStructure();
	
	if( hasDataStructure ){
		System.out.println("Dropped here...");
		dataStructure = (JSONObject)renderRequest.getAttribute(StationXWebKeys.DATA_STRUCTURE);
	}
%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/main.css">

<portlet:resourceURL var="loadDataStructureResourceCommandURL">
	<portlet:param name="dataTypeId" value="<%= String.valueOf(dataType.getDataTypeId()) %>"/>
</portlet:resourceURL>

<portlet:resourceURL id="<%= IcecapMVCCommands.RESOURCE_DATATYPE_RENDER_TERM %>" var="renderTermResourceCommandURL">
	<portlet:param name="cmd" value="<%= IcecapConstants.RENDER_TERM %>"/>
</portlet:resourceURL>

<portlet:resourceURL id="<%= IcecapMVCCommands.RESOURCE_DATATYPE_RENDER_DATATYPE %>" var="renderDataTypeResourceCommandURL">
	<portlet:param name="cmd" value="<%= IcecapConstants.RENDER_DATATYPE %>"/>
</portlet:resourceURL>

<portlet:resourceURL id="<%= IcecapMVCCommands.RESOURCE_DATATYPE_SAVE_STRUCTURE %>" var="saveDataStructureResourceCommandURL">
	<portlet:param name="cmd" value="<%= hasDataStructure?StationXConstants.CMD_UPDATE:StationXConstants.CMD_ADD %>"/>
</portlet:resourceURL>

<portlet:actionURL name="<%= IcecapMVCCommands.ACTION_DATA_STRUCTURE_DELETE %>" var="removeDataStructureURL">
	<portlet:param name="dataTypeId" value="<%= String.valueOf(dataType.getDataTypeId()) %>"/>
</portlet:actionURL>


<portlet:renderURL var="templateEditListOptionDlg">
	<portlet:param name="jspPath" value="/html/templates/edit-list-option.jsp"></portlet:param>
</portlet:renderURL>

<aui:form action="" name="defineFm">
<aui:container cssClass="SXIcecap-web" id="dataTypeDefiner">

	<aui:row id="infoSection">
		<aui:col md="3" id="nameCol">
			<aui:input 
						type="text" 
						name="dataTypeName" 
						label="datatype-name"
						value="<%= dataType.getDataTypeName() %>" 
						disabled="true">
			</aui:input>
		</aui:col>
		<aui:col md="2" id="versionCol">
			<aui:input 
						type="text" 
						name="dataTypeVersion"
						label="datatype-version" 
						value="<%= dataType.getDataTypeVersion() %>" 
						disabled="true">
			</aui:input>
		</aui:col>
		<aui:col md="2" id="extensionCol">
			<aui:input 
						type="text" 
						name="dataTypeExtension"
						label="datatype-extension" 
						value="<%= dataType.getExtension() %>" 
						disabled="true">
			</aui:input>
		</aui:col>
		<aui:col md="5" id="naviCol">
			<div class="right">
			<liferay-ui:icon image="back" />
			<aui:a href="#" label="back-to-list"></aui:a>
			</div>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col>
			<hr class="title-horizontal-line">
		</aui:col>
	</aui:row>
	<aui:row id="headerSection">
		<aui:col md="4">
			<aui:input 
						type="text" 
						name="termDelimiter" 
						helpMessage="term-delimiter-help"
						value="<%= hasDataStructure ? dataStructure.get("termDelimiter") : ";" %>">
			</aui:input>
		</aui:col>
		<aui:col md="4">
			<aui:select 
						name="termDelimiterPosition"
						helpMessage="term-delimiter-position-help">
				<aui:option label="start" value="false"></aui:option>
				<aui:option label="end" value="true" selected="true"></aui:option>
			</aui:select>
		</aui:col>
		<aui:col md="4">
			<aui:select 
						name="termValueDelimiter"
						helpMessage="term-value-delimiter-help">
				<aui:option label="Equal" value="equal"  selected="true"></aui:option>
				<aui:option label="Space" value="space"></aui:option>
				<aui:option label="Colon" value="colon"></aui:option>
			</aui:select>
		</aui:col>
		<aui:col md="4">
			<aui:select 
						name="matrixBracketType"
						helpMessage="matrix-bracket-type-help">
				<aui:option label="parenthesis-()" value="()"  selected="true"></aui:option>
				<aui:option label="curly-bracket-{}" value="{}"></aui:option>
				<aui:option label="square-bracket-[]" value="[]"></aui:option>
			</aui:select>
		</aui:col>
		<aui:col md="4">
			<aui:select 
						name="matrixElementDelimiter"
						helpMessage="matrix-element-delimiter-help">
				<aui:option label="Space" value="space"  selected="true"></aui:option>
				<aui:option label="Comma" value="comma"></aui:option>
			</aui:select>
		</aui:col>
		<aui:col md="4">
			<aui:input 
						type="text" 
						name="commentChar" 
						helpMessage="comment-character-help"
						value="#">
			</aui:input>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col>
			<hr class="title-horizontal-line">
		</aui:col>
	</aui:row>
	<aui:row id="editSection" cssClass="border">
		<aui:col md="5" id="termProperties" cssClass="bottom-margin">
			<aui:container>
				<aui:button-row>
					<aui:button name="btnNewTerm" value="new-term" cssClass="left"></aui:button>
					<aui:button name="btnCopyTerm" value="copy-term" cssClass="left"></aui:button>
					<aui:button name="btnClear" value="clear" cssClass="left"></aui:button>
					<aui:button name="btnImportTerm" value="import-term" cssClass="right"></aui:button>
				</aui:button-row>
				<aui:row>
				<aui:col>
				<div id="<portlet:namespace/>termTypeSelector">
					<aui:select name="termType" label="term-type" helpMessage="term-type-select-help">
						<aui:option label="String" value="String"/>
						<aui:option label="Numeric" value="Numeric"/>
						<aui:option label="Integer" value="Integer"/>
						<aui:option label="List" value="List"/>
						<aui:option label="Matrix" value="Matrix"/>
						<aui:option label="Boolean" value="Boolean" selected="true"/>
						<aui:option label="Array" value="Array"/>
						<aui:option label="Address" value="Address"/>
						<aui:option label="Phone" value="Phone"/>
						<aui:option label="EMail" value="EMail"/>
						<aui:option label="Date" value="Date"/>
						<aui:option label="Comment" value="Comment"/>
						<aui:option label="Group" value="Group"/>
						<aui:option label="File" value="File"/>
						<aui:option label="FileArray" value="FileArray"/>
						<aui:option label="Object" value="Object"/>
						<aui:option label="ObjectArray" value="ObjectArray"/>
						<aui:option label="DataLink" value="DataLink"/>
						<aui:option label="DataLinkArray" value="DataLinkArray"/>
					</aui:select>
				</div>
				
				<aui:input  
								name="termName" 
								label="term-name"  
								required="true" 
								placeholder="ex) termName"
								helpMessage="term-name-help">
				</aui:input>
				<aui:input  
								name="termVersion" 
								label="term-version" 
								required="true"
								helpMessage="term-version-help">
				</aui:input>
				<aui:field-wrapper name="termDisplayName" required="true" label="term-display-name" helpMessage="term-display-name-help">
						<liferay-ui:input-localized 
										name="termDisplayName"
										xml="">
						</liferay-ui:input-localized>
				</aui:field-wrapper>
				<aui:field-wrapper name="termDefinition" label="definition" helpMessage="definition-help">
						<liferay-ui:input-localized 
										type="textarea"
										name="termDefinition"
										xml="">
						</liferay-ui:input-localized>
				</aui:field-wrapper>
								<aui:input 
							type="checkbox"
							name="abstractKey" 
							label="abatract-key" 
							helpMessage="abstract-key-help">
				</aui:input>
				<aui:field-wrapper name="termTooltip" label="tooltip" helpMessage="term-tooltip-help">
						<liferay-ui:input-localized 
										name="termTooltip"
										xml="">
						</liferay-ui:input-localized>
				</aui:field-wrapper>
				<aui:input 
							type="text"
							name="synonyms" 
							label="synonyms" 
							helpMessage="term-synonyms-help">
				</aui:input>
				<aui:input 
							type="checkbox"
							name="mandatory" 
							label="mandatory" 
							helpMessage="term-mandatory-help">
				</aui:input>
				<aui:input 
							type="text"
							name="value" 
							label="default-value" 
							helpMessage="default-value-help">
				</aui:input>
	
				<hr class="content-horizontal-line">
				
				<%@include file="../templates/type-specific-attributes.jspf" %>
				</aui:col>
				</aui:row>
			</aui:container>
		</aui:col>
		<aui:col md="1" id="buttonSection" cssClass="vertical-center-side-border">
			<div style="width:100%;">
				<aui:button id="btnUp" value="up" icon="icon-arrow-up" iconAlign="left" cssClass="center-button"></aui:button>
				<aui:button id="btnAdd" value="add" icon="icon-double-angle-right" iconAlign="right" cssClass="center-button"></aui:button>
				<aui:button id="btnDown" value="down" icon="icon-arrow-down" iconAlign="right" cssClass="center-button"></aui:button>
			</div>
		</aui:col>
		<aui:col md="6" id="previewSection">
				<!-- div id="templateString" cssClass="hide" -->
				<aui:button-row>
					<aui:button id="btnRefresh" value="refresh"></aui:button>
					<aui:button id="btnShowSDE" value="structured-datatype-editor"></aui:button>
				</aui:button-row>
				<hr class="content-horizontal-line">
				
				<table class="table table-striped">
					<tbody id="<portlet:namespace/>previewPanel">
					</tbody>
				</table>
		</aui:col>
	</aui:row>
	<aui:button-row>
		<aui:button id="btnSave" value="save"></aui:button>
		<aui:button id="btnSaveAndViewDataTypeList" value="save-and-view-datatype-list"></aui:button>
		<aui:button id="btnRemoveDataStructure" value="remove-data-structure" href="<%= removeDataStructureURL %>"></aui:button>
	</aui:button-row>

</aui:container>
</aui:form>

<%@include file="script-bottom.jspf" %>


