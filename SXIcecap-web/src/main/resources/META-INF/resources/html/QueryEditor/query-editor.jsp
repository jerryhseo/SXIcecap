<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="../init.jsp" %>

<%
	String query = ParamUtil.getString(renderRequest, "query" , "[]");
	System.out.println("<div>"+query+"</div>");
	
	String subquery = ParamUtil.getString(renderRequest, "subquery", "[]");
	System.out.println("<div>"+subquery+"</div>");
%>
<div class="container station-x">
		<div class="row" >
			<div class="col-md-6 show-border">
				<div class="container">
					<div class="row" id="<portlet:namespace/>goToBar" >
						<div class="col-md-6">
							<aui:select name="goToCategory" label="go-to-category" inlineLabel="left" inlineField="true">
								<aui:option label="term-name" value="termName"></aui:option>
								<aui:option label="display-name" value="displayName"></aui:option>
							</aui:select>
						</div>
						<div class="col-md-6" class="ui-widget">
							<aui:input name="goToSelector" label="go-to" inlineLabel="left" inlineField="true"></aui:input>
						</div>
					</div>
					<div class="row" >
						<div class="col-md-12" id="<portlet:namespace/>searchSection"></div>
					</div>
				</div>
			</div>
			<duv class="col-md-6 show-border">
				<aui:container id="resultSection">
					<aui:row>
						<aui:col md="12"><span id="<portlet:namespace/>resultPagination" style="display:inline;"></span><span  id="<portlet:namespace/>totalCount" style="float:right;padding-top:8px;padding-bottom:8px"></span></aui:col>
					</aui:row>
				</aui:container>
				
				<aui:container id="resultSection">
				</aui:container>
			</aui:col>
	</aui:row>
	<div class="row">
		<div class="col-md-12">
			<ul id="<portlet:namespace/>queryTree" class="ztree">
			</ul>
		</div>
	</div>
</div>

<script>
$(document).ready(function(){
	let query = JSON.parse( '<%= Validator.isNotNull(query) ? query : "[]" %>' );
	let subquery = JSON.parse( '<%= subquery %>' );
	
	console.log( 'Query: ', JSON.stringify( query, null, 4)  );
	console.log( 'sub-Query: ', JSON.stringify( subquery, null, 4)  );
	
	let setting = {
			data: {
				key: {
					name: 'title'
				},
				simpleData: {
					enable:true,
					idKey: 'id',
					pIdKey: 'pid',
					rootPId: null
				}
			},
			edit: {
				enable: true
			}
	};

	let zTreeObj = $.fn.zTree.init($("#<portlet:namespace/>queryTree"), setting, query);

	console.log( 'zTreeObje settings: ', zTreeObj.setting );
});

function <portlet:namespace/>getQuerySentence( query ){
	
}
</script>