<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.sx.icecap.constant.IcecapWebKeys"%>
<%@page import="com.sx.icecap.model.DataType"%>
<%@ include file="../init.jsp" %>

<%
	DataType dataType = (DataType)renderRequest.getAttribute(IcecapWebKeys.DATATYPE);
	JSONObject dataStructure = (JSONObject)renderRequest.getAttribute(IcecapWebKeys.DATA_STRUCTURE);
%>

<aui:container cssClass="SXIcecap-web">
	<aui:row cssClass="form-section">
		<aui:col md="12">
			<aui:form action="" enctype="multipart/form-data" escapeXml="true" method="POST" name="fm" inlineLabels="true" >
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="datatype">
						<span style="display:table-cell; width:40%;">
						<aui:input name="datatype-name" disabled="true" value="<%= dataType.getDataTypeName() %>"></aui:input>
						</span>
						<span style="display:table-cell; width:10%;">
						<aui:input name="datatype-version" disabled="true" value="<%= dataType.getDataTypeVersion() %>"></aui:input>
						</span>
						<span style="display:table-cell; width:10%;">
						<aui:input name="datatype-extention" disabled="true" value="<%= dataType.getExtension() %>"></aui:input>
						</span>
					</aui:fieldset>
				</aui:fieldset-group>
				<div class="container-fluid">
					<div class="row"  id="<portlet:namespace/>searchCanvas">
					</div>
				</div>
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
	
	let dataStructure = SX.newDataStructure(  <%= dataStructure.toString() %> );
	console.log('Search View: ', dataStructure );
	
	dataStructure.render( SX.SXConstants.FOR_SEARCH, $('#<portlet:namespace/>searchCanvas') );
});
</script>