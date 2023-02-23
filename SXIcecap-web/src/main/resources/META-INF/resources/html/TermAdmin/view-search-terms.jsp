<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.sx.icecap.service.TermLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.sx.icecap.model.Term"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.sx.icecap.constant.IcecapJsps"%>
<%@include file="../init.jsp"%>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<%
		String keywords = ParamUtil.getString(request, "keywords");
	%>
	
	<portlet:renderURL var="searchRenderURL">
	        <portlet:param name="mvcPath" 
	        value="<%=IcecapJsps.ADMIN_VIEW_SEARCH_TERMS_JSP%>" />
	</portlet:renderURL>
	
	<portlet:renderURL var="viewTermURL">
	    <portlet:param 
	        name="mvcPath" 
	        value="<%=IcecapJsps.ADMIN_VIEW_TERM_JSP%>" 
	    />
	</portlet:renderURL>
	
	<aui:form action="${searchRenderURL}" name="fm">
	
	    <liferay-ui:header backURL="${viewTermURL}" title="back" />
	
	    <div class="row">
	        <div class="col-md-8">
	            <aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
	        </div>
	
	        <div class="col-md-4">
	            <aui:button type="submit" value="search" />
	        </div>
	    </div>
	</aui:form>
	
	<%
			SearchContext searchContext = SearchContextFactory.getInstance(request);
			
			    searchContext.setKeywords(keywords);
			    searchContext.setAttribute("paginationType", "more");
			    searchContext.setStart(0);
			    searchContext.setEnd(10);
			    
			    Indexer<Term> indexer = IndexerRegistryUtil.getIndexer(Term.class);
			    
			    Hits hits = indexer.search(searchContext);

			    System.out.println( "No of hits: "+ hits.getLength() );
			    List<Term> terms = new ArrayList<Term>();
			
			    for (int i = 0; i < hits.getDocs().length; i++) {
			            Document doc = hits.doc(i);
			
			            long termId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			            
			            System.out.println("Hited term ID: "+termId);
			
			            Term term = null;
			
			            try {
			                    term = TermLocalServiceUtil.getTerm(termId);
			                    System.out.println( "Retrieved Term Display Name: "+term.getDisplayName(locale) );
			            } catch (PortalException pe) {
			                    _log.error(pe.getLocalizedMessage());
			            } catch (SystemException se) {
			                    _log.error(se.getLocalizedMessage());
			            }
			
			            terms.add(term);
			    }
		%>
	
	<liferay-ui:search-container delta="10" 
	    emptyResultsMessage="no-entries-were-found" 
	    total="<%=terms.size()%>">
	        <liferay-ui:search-container-results
	                results="<%=terms%>" />
	        <liferay-ui:search-container-row
						className="com.sx.icecap.sss.model.Term"
						keyProperty="termId" modelVar="term" escapedModel="<%=true%>">
				<liferay-ui:search-container-column-text 
				 			name="displayName"
							value="<%=term.getDisplayName(locale)%>" />
				<liferay-ui:search-container-column-text property="termName" />
				<liferay-ui:search-container-column-text property="termVersion" />
				<liferay-ui:search-container-column-text property="termType" />

				<liferay-ui:search-container-column-text name="definition" value="<%=term.getDefinition(locale)%>" />
				
				<liferay-ui:search-container-column-text property="modifiedDate" />

				<liferay-ui:search-container-column-jsp
							path="<%=IcecapJsps.ADMIN_TERM_ACTIONS_JSP%>"
							align="right" />
			</liferay-ui:search-container-row>
			
			<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	
</div>

<%!private static Log _log = LogFactoryUtil.getLog("html.view_search_terms_jsp");%>