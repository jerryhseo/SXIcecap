<%@page import="com.liferay.portal.kernel.json.JSONException"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryServiceUtil"%>
<%@page import="com.liferay.asset.kernel.service.persistence.AssetCategoryFinderUtil"%>
<%@page import="com.sx.icecap.constant.IcecapSSSMVCCommands"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFunction"%>
<%@page import="com.liferay.portal.kernel.comment.CommentManagerUtil"%>
<%@page import="com.liferay.portal.kernel.comment.Discussion"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetTagLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetTag"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.sx.icecap.service.TermLocalServiceUtil"%>
<%@page import="com.sx.icecap.model.Term"%>
<%@ include file="../../init.jsp"%>

<%
	Term term = (Term)renderRequest.getAttribute("term");
	List<Term> history = (List<Term>)renderRequest.getAttribute("termHistory");

	term = term.toEscapedModel();

	AssetEntry assetEntry = 
		AssetEntryLocalServiceUtil.getEntry(Term.class.getName(), term.getTermId());

	PortalUtil.addPortletBreadcrumbEntry(request, term.getDisplayTitle(locale), currentURL);
	
	PortalUtil.setPageSubtitle(term.getDisplayTitle(locale), request);
	PortalUtil.setPageDescription(term.getDisplayTitle(locale), request);

	List<AssetTag> assetTags = 
	AssetTagLocalServiceUtil.getTags(Term.class.getName(), term.getTermId());
	PortalUtil.setPageKeywords(ListUtil.toString(assetTags, "name"), request);
	
	Set<Locale> locales = new HashSet<Locale>();
	locales.add( locale );
	JSONObject jsonTerm = term.toJSONObject(locales);
	
	System.out.println(jsonTerm.toString(4));
%>

<liferay-portlet:renderURL varImpl="viewTermListURL">
	<portlet:param name="mvcRenderCommandName" value="<%=IcecapSSSMVCCommands.RENDER_ADMIN_TERM_LIST%>" />
</liferay-portlet:renderURL>

<div class="sss-term-asset-template">
<aui:container>
<aui:row cssClass="wide-top-margin-row">
	<aui:col span="3" >
		<h2>
		<aui:a
				href="<%=redirect%>"
				label="&lt; view-term-list" 
				
		></aui:a>
		</h2>
	</aui:col>
	<aui:col span="4" offset="5">
		<aui:button
			name="defineAsStandard"
			href="#"
			value="define-as-standard" 
		></aui:button>
	</aui:col>
</aui:row>
<hr style="border-top:3px solid;"/>

<aui:row cssClass="wide-top-margin-row">
	<aui:col>
		<h2>
			<%= term.getDisplayTitle(locale) %>
		</h2>
	</aui:col>
</aui:row>
<hr/>
<aui:row cssClass="wide-top-margin-row">
	<aui:col md="3">
		<dt>
			<liferay-ui:message key="term-name"/>
		</dt>
		<dd>
			<%= term.getTermName() %>
		</dd>
	</aui:col>
	<aui:col md="3">
		<dt>
			<liferay-ui:message key="term-type"/>
		</dt>
		<dd>
			<%= term.getTermType() %>
		</dd>
	</aui:col>
	<aui:col md="2">
		<dt>
			<liferay-ui:message key="status"/>
		</dt>
		<dd>
			<div class="lfr-status-column">
				<span class="taglib-workflow-status">
					<span class="workflow-status">
						<strong class="label status text-uppercase workflow-status-pending pending workflow-value">Pending</strong>
					</span>
				</span>
			</div>
		</dd>
	</aui:col>
</aui:row>
<aui:row cssClass="wide-top-margin-row">
	<aui:col md="12">
		<dt>
			<liferay-ui:message key="definition"/>
		</dt>
		<dd>
			<%= term.getDefinition(locale) %>
		</dd>
	</aui:col>
</aui:row>
<aui:row cssClass="wide-top-margin-row">
	<aui:col>
		<dt>
			<liferay-ui:message key="tooltip"/>
		</dt>
		<dd>
			<%= term.getTooltip(locale) %>
		</dd>
	</aui:col>
</aui:row>

<aui:row cssClass="wide-top-margin-row">
	<aui:col>
		<dt>
			<liferay-ui:message key="synonyms"/>
		</dt>
		<dd>
			<%= term.getSynonyms() %>
		</dd>
	</aui:col>
</aui:row>


<aui:row cssClass="wide-top-margin-row">
	<aui:col>
		<dt>
			<liferay-ui:message key="categories"/>
		</dt>
		<dd>
			<%
				List<AssetCategory> categories = AssetCategoryServiceUtil.getCategories(Term.class.getName(), term.getPrimaryKey());
			%>
			<c:set var="categoriesCount" value="<%= categories.size() %>" />
			<c:choose>
				<c:when test="${ categoriesCount eq '0' }" > 
					<liferay-ui:message key="the-term-has-no-category"/>
				</c:when>
				<c:otherwise>
					<c:forEach var="category" items="${categories }">
						<c:out value="${  category.getTitle(locale) }" />
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</dd>
	</aui:col>
</aui:row>

<c:set var = "termType" value="<%= term.getTermType() %>" />
<c:choose>
	<c:when test="${termType eq 'String' }">
		<%@ include file="../jspf/string-attributes.jspf"%>
	</c:when>
	<c:when test="${termType eq 'Numeric' }">
		<%@ include file="../jspf/numeric-attributes.jspf"%>
		<aui:row cssClass="wide-top-margin-row">
			<c:if test="">
			<aui:col md="3">
						<dt>
							<liferay-ui:message key="min-value"/>
						</dt>
						<dd>
							<%
								if( jsonTerm.has(IcecapSSSTermAttributes.MIN_VALUE) )
									out.println( jsonTerm.getString(IcecapSSSTermAttributes.MIN_VALUE)) );
							%>
						</dd>
			</aui:col>
			<aui:col md="3">
						<dt>
							<liferay-ui:message key="min-value"/>
						</dt>
						<dd>
							<%
								if( jsonTerm.has(IcecapSSSTermAttributes.MIN_VALUE) )
									out.println( jsonTerm.getString(IcecapSSSTermAttributes.MIN_VALUE)) );
							%>
						</dd>
			</aui:col>

		</aui:row>
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<hr style="border-top:3px solid;"/>

<aui:row cssClass="wide-top-margin-row">
	<aui:col>
	<dt>
		<liferay-ui:ratings 
				className="<%=Term.class.getName()%>"
				classPK="<%=term.getTermId()%>" type="stars" />
		</dt>
	</aui:col>
</aui:row>

<hr/>

<aui:row cssClass="wide-top-margin-row">
	<aui:col>
	<% 
		Discussion discussion = 
		CommentManagerUtil.getDiscussion(
				user.getUserId(), 
				scopeGroupId, 
				Term.class.getName(), 
				term.getTermId(), 
				new ServiceContextFunction(request));
	%>
	
	<c:if test="<%= discussion != null %>">
		<dt>
				<liferay-ui:message 
						arguments="<%= discussion.getDiscussionCommentsCount() %>" 
						key='<%= (discussion.getDiscussionCommentsCount() == 1) ? "x-comment" : "x-comments" %>' />
		</dt>
	</c:if>
	<c:if test="<%= themeDisplay.isSignedIn() %>">
		<liferay-comment:discussion
				className="<%= Term.class.getName() %>"
				classPK="<%= term.getTermId() %>"
				discussion="<%= discussion %>"
				formName="fm2"
				ratingsEnabled="true"
				redirect="<%= currentURL %>"
				userId="<%= term.getUserId() %>"
		/>
	</c:if>
	</aui:col>
</aui:row>
</aui:container>
</div>

