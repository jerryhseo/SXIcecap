<%@page import="com.sx.icecap.constant.IcecapSSSMVCCommands"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sx.icecap.service.TermLocalServiceUtil"%>
<%@page import="com.sx.icecap.model.Term"%>
<%@ include file="../../init.jsp" %>

<%
	Term term = (Term)renderRequest.getAttribute("term");
%>

<liferay-portlet:renderURL varImpl="viewTermURL">
	<portlet:param name="mvcRenderCommandName" value="<%=IcecapSSSMVCCommands.RENDER_ADMIN_TERM_VIEW%>" />
	<portlet:param name="termId" value="<%=String.valueOf(term.getTermId())%>" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="viewURL">
	<portlet:param name="mvcRenderCommandName" value="<%=IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST%>" />
</liferay-portlet:renderURL>

<dl>
	<aui:row>
		<aui:col md="4">
			<dt>Type</dt>
			<dd><%=term.getTermType()%></dd>
		</aui:col>
		<aui:col md="4" >
			<dt>Term Name</dt>
			<dd><%=term.getTermName()%></dd>
		</aui:col>
	</aui:row>
	<aui:row>
		<aui:col>
			<dt>Definition</dt>
			<dd><%=term.getDefinition(locale, true) %></dd>
		</aui:col>
	</aui:row>
</dl>