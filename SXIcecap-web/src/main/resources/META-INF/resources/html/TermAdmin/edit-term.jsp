<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.sx.debug.Debug"%>
<%@page import="com.sx.icecap.util.comparator.sss.IcecapSSSTermAttributeUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.sx.icecap.constant.IcecapMVCCommands"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sx.icecap.constant.IcecapActionKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Set"%>
<%@page import="com.sx.icecap.constant.IcecapClassNames"%>
<%@page import="com.sx.icecap.constant.IcecapSSSTermTypes"%>
<%@page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.SelectOption"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.sx.constant.StationXWebKeys"%>
<%@page import="com.sx.icecap.model.Term"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>

<%
	Term term = (Term)renderRequest.getAttribute(StationXWebKeys.TERM);

	Locale defaultLocale = PortalUtil.getSiteDefaultLocale(themeDisplay.getScopeGroupId());
	
	Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();
	
	JSONArray jsonLocales = JSONFactoryUtil.createJSONArray();
	availableLocales.forEach( jsonLocales::put );

	String cmd = Constants.ADD;
	if( Validator.isNotNull(term) ){
		cmd = Constants.UPDATE;
		System.out.println("Constants.UPDATE: " + Constants.UPDATE );
		System.out.println( term.toJSONString(availableLocales) );
	}
	
	String defaultTermType = ParamUtil.getString(renderRequest, StationXWebKeys.TERM_TYPE, IcecapSSSTermTypes.STRING);

	String submitButtonLabel = "";
	String termJsonString = "";
	
//	System.out.println("CMD: "+cmd);
	if( cmd.equals(Constants.ADD) ){
		submitButtonLabel = LanguageUtil.get(locale, "add-term", "Add Term");
	}
	else{
		submitButtonLabel = LanguageUtil.get(locale, "update-term", "Update Term");
		defaultTermType = term.getTermType();
		termJsonString = term.toJSONString(availableLocales);
	}
%>

<liferay-portlet:actionURL name="<%=IcecapMVCCommands.ACTION_ADMIN_TERM_ADD%>" var="addTermURL">
</liferay-portlet:actionURL>

<portlet:renderURL var="termListURL">
	<portlet:param
			name="<%=StationXWebKeys.MVC_RENDER_COMMAND_NAME%>" 
    		value="<%=IcecapMVCCommands.RENDER_ADMIN_TERM_LIST%>" />
    <portlet:param
    		name="<%=StationXWebKeys.NAVIGATION%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.NAVIGATION)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.DISPLAY_STYLE%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.DISPLAY_STYLE)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.KEYWORDS%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.KEYWORDS)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.ORDER_BY_COL%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.ORDER_BY_COL)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.ORDER_BY_TYPE%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.ORDER_BY_TYPE)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.SHOW_SCHEDULED%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.SHOW_SCHEDULED)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.MULTIPLE_SELECTION%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.MULTIPLE_SELECTION)%>" />
    <portlet:param
    		name="<%=StationXWebKeys.STATUS%>"
    		value="<%=ParamUtil.getString(renderRequest, StationXWebKeys.STATUS, String.valueOf(WorkflowConstants.STATUS_ANY))%>" />
</portlet:renderURL>

<portlet:actionURL 
			name="<%=IcecapMVCCommands.ACTION_ADMIN_TERM_UPDATE %>" 
			var="updateTermURL">
</portlet:actionURL>

<portlet:actionURL 
			name="<%=IcecapMVCCommands.ACTION_ADMIN_LOAD_TERM_ATTRIBURES%>" 
			var="loadTermAttributesURL"/>

<portlet:resourceURL 
			id="<%= IcecapMVCCommands.RESOURCE_ADMIN_RENDER_TERM %>"
			 var="renderTermURL">
</portlet:resourceURL>


<liferay-asset:asset-categories-error />
<liferay-asset:asset-tags-error />

<%
	String formSubmitURL;
	
	if( cmd.equals(Constants.ADD) ){
		formSubmitURL = addTermURL.toString();
	}
	else{
		formSubmitURL = updateTermURL.toString();
	}
	
	System.out.println("Command: "+cmd );
%>

<div class="SXIcecap-web">
<aui:container>
	<aui:form name="termDefForm" method="POST" action="<%= formSubmitURL %>">
		<aui:row>
			<aui:col>
				<aui:input type="hidden" name="termId" value="<%= Validator.isNotNull(term)?term.getTermId():StringPool.BLANK %>"></aui:input>
				
				<%@include file="jspf/term-definition.jspf" %>
				
				<hr class="content-horizontal-line">
			
				<%@include file="jspf/type-specific-attributes.jspf" %>
				
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset collapsed="<%= false %>" collapsible="<%= true %>" label="categorization" helpMessage="term-categories-help">
						<liferay-asset:asset-categories-selector 
									className="<%=Term.class.getName()%>" 
									classPK="<%= Validator.isNotNull(term)?term.getTermId():0 %>"/>
					</aui:fieldset>
				</aui:fieldset-group>
				
				<aui:button-row>
					<aui:button type="submit" value="<%= submitButtonLabel %>" ></aui:button>
					<aui:button name="clear" type="reset" value="clear"></aui:button>
					<c:if test="<%= Validator.isNotNull(term) %>">
						<portlet:actionURL name="<%=IcecapMVCCommands.ACTION_ADMIN_TERM_DELETE%>" var="deleteTermURL">
							<portlet:param name="termId" value="<%= String.valueOf(term.getTermId()) %>"/>
						</portlet:actionURL>
						<aui:button name="delete" type="delete" value="delete" href="<%= deleteTermURL.toString() %>"></aui:button>
					</c:if>
					<aui:button name="cancel" value="cancel" href="<%= termListURL %>"></aui:button>
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
</aui:container>

<script>
$(document).ready(function(){
	let SX = StationX(  '<portlet:namespace/>', 
								'<%= defaultLocale.toString() %>',
								'<%= locale.toString() %>',
								<%= jsonLocales.toJSONString() %> );

	let termType =  '<%= defaultTermType %>';
	SX.FormUIUtil.replaceVisibleTypeSpecificSection(termType);
	
	let currentTerm = new SX.newTerm(termType);
	
	let termJsonString = '<%= termJsonString %>';
	if( termJsonString )
		currentTerm.parse( JSON.parse(termJsonString) );

	currentTerm.setAllFormValues();
	
	SX.Term.$TERM_TYPE_FORM_CTRL.change(function(eventObj){
		let selectedTermType = currentTerm.getTermTypeFormValue();
		
		if( selectedTermType === currentTerm.termType ){
			// Do nothing
			return;
		}
		
		if( currentTerm.isRendered() ){
			$.alert({
				title: '<liferay-ui:message key="term-type-change-alert"/>',
				content: 'how-to-term-type-change'
			});
			
			setCurrentTerm( currentTerm );
		}
		else{
			setCurrentTerm( dataStructure.createTerm( selectedTermType ) );
		}
	});
	
	SX.Term.$TERM_NAME_FORM_CTRL.change(function(eventObj){
		if( currentTerm.$rendered ){
			// It means the current term is one of the data structure and previewed on the preview panel.
			// Therefore, we must confirm that the term's name be changed before the preview changed.
			$.confirm({
				title: '<liferay-ui:message key="select-term-type" />',
				content: '<liferay-ui:message key="this-term-is-previewed-are-you-sure-to-change-the-name-of-the-term" />',
				type: 'orange',
				typeAnimated: true,
				buttons:{
					ok: {
						text: 'OK',
						btnClass: 'btn-blue',
						action: function(){
							let changedName = currentTerm.getTermNameFormValue();
							if( dataStructure.exist( changedName ) ){
								$.alert( changedName + 'already exist. Should be changed another name.' );
								currentTerm.setTermNameFormValue();
							}
							else{
								if( currentTerm.validateNameExpression( changedName ) === true ){
									currentTerm.termName = changedName;
									
									dataStructure.refreshTerm( currentTerm );
								}
								else{
									$.alert( 'Term Name[' + changedName +'] is unvalid. Try another one.');
									currentTerm.setTermNameFormValue();
								}
							} 
						}
					},
					cancel: function(){
						currentTerm.setTermNameFormValue();
					}
				},
				draggable: true
			}); 
		}
		else{
			currentTerm.getTermNameFormValue( true );
		}
	});

	SX.Term.$TERM_VERSION_FORM_CTRL.change(function(eventObj){
		const changedVersion = currentTerm.getTermVersionFormValue();
		
		let validated;
		if( currentTerm.$rendered ){
			validated = SX.Term.validateTermVersion( changedVersion, currentTerm.termVersion );
		}
		else{
			validated = SX.Term.validateTermVersion( changedVersion );
		}
		
		if( validated === true ){
			currentTerm.termVersion = changedVersion;
		}
		else{
			$.alert( changedVersion + ' ' + validated );
			currentTerm.setTermVersionFormValue();
		} 
	});

	SX.Term.$TERM_DISPLAY_NAME_FORM_CTRL.change(function(eventObj){
		currentTerm.getDisplayNameFormValue(true);
	
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>termDefinition').change(function(eventObj){
		currentTerm.getDefinitionFormValue(true);
	});

	$('#<portlet:namespace/>termTooltip').change(function(eventObj){
		currentTerm.getTooltipFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>placeHolder').change(function(eventObj){
		currentTerm.getPlaceHolderFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>synonyms').change(function(eventObj){
		currentTerm.getSynonymsFormValue(true);
	});
	
	$('#<portlet:namespace/>mandatory').change(function(eventObj){
		currentTerm.getMandatoryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>value').change(function(eventObj){
		currentTerm.getValueFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>minLength').change(function(eventObj){
		const changedValue = Number( currentTerm.getMinLengthFormValue() );
		console.log( 'Changed number: '+changedValue );
		if( isNaN( changedValue ) || changedValue <= 0){
			$.alert('Minimum length should be an interger larger than 0.');
			currentTerm.setMinLengthFormValue()
		}
		else{
			currentTerm.minLength = changedValue;
			dataStructure.refreshTerm( currentTerm );
		}
	});
	
	$('#<portlet:namespace/>maxLength').change(function(eventObj){
		const minLength = currentTerm.getMinLengthFormValue();
		const maxLength = currentTerm.getMaxLengthFormValue();
		if( maxLength < minLength ){
			$.alert('Maximum length should be larger than minimum length.');
			currentTerm.setMaxLengthFormValue();
		}
		else{
			currentTerm.getMaxLengthFormValue(true);
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>multipleLine').change(function(eventObj){
		currentTerm.getMultipleLineFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>validationRule').change(function(eventObj){
		currentTerm.getValidationRuleFormValue(true);
	});
	
	$('#<portlet:namespace/>minValue').change(function(eventObj){
		const preValue = currentTerm.minValue;
	
		currentTerm.getMinValueFormValue(true);
		
		if( !currentTerm.minValue ){
			currentTerm.setMinBoundaryFormValue();
			dataStructure.disable(['minBoundary'], true);
			//$('#<portlet:namespace/>minBoundary').prop('disabled', true);
		}
		else{
			dataStructure.disable(['minBoundary'], false);
			//$('#<portlet:namespace/>minBoundary').prop('disabled', false);
		}
		
		if( preValue !== currentTerm.minValue ){
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>minBoundary').change(function(eventObj){
		currentTerm.getMinBoundaryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>maxValue').change(function(eventObj){
		const preValue = currentTerm.maxValue;
		
		currentTerm.getMaxValueFormValue(true);
		
		if( !currentTerm.maxValue ){
			currentTerm.setMaxBoundaryFormValue();
			dataStructure.disable(['maxBoundary'], true);
//			$('#<portlet:namespace/>maxBoundary').prop('disabled', true);
		}
		else{
			dataStructure.disable(['maxBoundary'], false);
//			$('#<portlet:namespace/>maxBoundary').prop('disabled', false);
		}
		
		if( preValue !== currentTerm.maxValue ){
			dataStructure.refreshTerm( currentTerm );
		}
	});

	$('#<portlet:namespace/>maxBoundary').change(function(eventObj){
		currentTerm.getMaxBoundaryFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>unit').change(function(eventObj){
		currentTerm.getUnitFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>uncertainty').change(function(eventObj){
		currentTerm.getUncertaintyFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});

	$('#<portlet:namespace/>sweepable').change(function(eventObj){
		currentTerm.getSweepableFormValue(true);
	});
	
	$('input[name="<portlet:namespace/>listDisplayStyle"]').change(function(eventObj){
		currentTerm.getDisplayStyleFormValue(true);
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_LABEL.change(function(event){
		let labelMap = currentTerm.getOptionLabelFormValue();
		if( Object.keys(labelMap).length === 0 ){
			$.alert('<liferay-ui:message key="option-label-required"/>');
			currentTerm.setOptionLabelFormValue();
			SX.ListTerm.$OPTION_LABEL.focus();
			
			return;
		}
		
		currentTerm.setOptionLabelMap( labelMap );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_VALUE.change(function(event){
		let value = currentTerm.getOptionValueFormValue();
		if( !value ){
			$.alert('<liferay-ui:message key="option-label-required"/>');
			currentTerm.setOptionValueFormValue();
			SX.ListTerm.$OPTION_VALUE.focus();
			
			return;
		}
		
		currentTerm.setOptionValue( value );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_SELECTED.change(function(event){
		let value = currentTerm.getOptionSelectedFormValue();
		
		currentTerm.setOptionSelected( value );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.ListTerm.$OPTION_ACTIVE_TERMS.change(function(event){
		let activeTermNames = currentTerm.getActiveTermsFormValue();
		
		currentTerm.setActiveTerms( activeTermNames );
		
		console.log('active terms: ', activeTermNames);
	});
	
	$('input[name="<portlet:namespace/>booleanDisplayStyle"]').change(function(event){
		console.log( 'Boolean display style changed: ', currentTerm.getDisplayStyleFormValue( true ) );
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	/**************************************************************
	* Custom Liferay event handlers
	**************************************************************/
	
	Liferay.on( SX.SXIcecapEvents.LIST_OPTION_PREVIEW_REMOVED, function( event ){
		let eventData = event.sxeventData;
				
		if( eventData.targetPortlet !== '<portlet:namespace/>' ){
			return;
		}

		let removedOption = eventData.option;

		currentTerm.removeOption( removedOption.value );
		
		dataStructure.render( SX.SXConstants.FOR_PREVIEW );
	});

	Liferay.on( SX.SXIcecapEvents.LIST_OPTION_PREVIEW_SELECTED, function( event ){
		let eventData = event.sxeventData;
		if( eventData.targetPortlet !== '<portlet:namespace/>' ){
			return;
		}

		currentTerm.initOptionFormValues( eventData.option );
		currentTerm.highlightOptionPreview(); 
	});

	/*******************************************************************************
	* Event handlers for buttons
	*******************************************************************************/
	$('#<portlet:namespace/>btnNewTerm').click(function(){
		// dataStructure.disable(['termType'], false);
		
		setCurrentTerm( dataStructure.createTerm( $('#<portlet:namespace/>dlgTermType').val() ) );
		
	});

	$('#<portlet:namespace/>btnCopyTerm').click(function(){
		// setCurrentTerm( dataStructure.copyTerm( currentTerm ) );
		dataStructure.addTestSet( SX.SXConstants.FOR_PREVIEW );
	});
	
	$('#<portlet:namespace/>btnClear').click(function(){
		currentTerm.initAllFormValues();
	});

	$('#<portlet:namespace/>btnImportTerm').click(function(){
		
	});
	
	SX.ListTerm.$BTN_NEW_OPTION.click(function(){
		
		console.log( 'click new button' );
		
		currentTerm.initOptionFormValues();
		dataStructure.disable(['btnAddOption'], false);
	});
	
	SX.ListTerm.$BTN_CHOOSE_ACTIVE_TERMS.click(function(event){
		let option = currentTerm.getHighlightedOption();
		if( !option ){
			option = currentTerm.addOption();
			if( !option ){
				return;
			}
		}
		
		dataStructure.disable(['btnAddOption'], true);

		dataStructure.chooseActiveTerms( currentTerm, option );		
		dataStructure.refreshTerm( currentTerm );
	});
	
	SX.BooleanTerm.$TRUE_ACTIVE_TERMS_BUTTON.click(function(event){
		dataStructure.chooseActiveTerms( currentTerm, currentTerm.getTrueOption() );
	});
	
	SX.BooleanTerm.$FALSE_ACTIVE_TERMS_BUTTON.click(function(event){
		dataStructure.chooseActiveTerms( currentTerm, currentTerm.getFalseOption() );
	});
	
	SX.GroupTerm.$BTN_CHOOSE_GROUP_TERMS.click(function(event){
		console.log( 'Current Term before group: ', currentTerm );
		dataStructure.chooseGroupTerms( currentTerm );
	});
	
	$('#<portlet:namespace/>btnAddOption').click(function(event){
		currentTerm.addOption();
		dataStructure.disable(['btnAddOption'], true);
		
		dataStructure.refreshTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>btnAdd').click(function(){
		if( dataStructure.addTerm( currentTerm,  SX.SXConstants.FOR_PREVIEW, true ) ){
			dataStructure.disable(['add', 'btnClear', 'termType'], true);
			/*
			$('#<portlet:namespace/>add').prop('disabled', true);
			$('#<portlet:namespace/>btnClear').prop('disabled', true); 
			*/
		}
		
		console.log('currentTerm: ' + JSON.stringify( currentTerm, null, 4 ), currentTerm );
	});
	
	$('#<portlet:namespace/>btnRefresh').click(function(event){
		dataStructure.render(SX.SXConstants.FOR_PREVIEW);
	});
	
	$('#<portlet:namespace/>btnUp').click(function(event){
		if( !currentTerm.isRendered() ){
			return;
		}
		
		dataStructure.moveUpTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>btnDown').click(function(event){
		if( !currentTerm.isRendered() ){
			return;
		}
		
		dataStructure.moveDownTerm( currentTerm );
	});
	
	$('#<portlet:namespace/>btnSave').click(function(event){
		if( currentTerm.validate() === false ){
			return;
		}
		
		$.ajax({
			url: '',
			method: 'post',
			dataType: 'text',
			data: {
				<portlet:namespace/>dataTypeId: '',
				<portlet:namespace/>dataStructure: JSON.stringify(dataStructure)
			},
			success: function( result ){
				console.log( result );
			},
			error: function(){
				console.log('error');
			}
		});
		
		console.log('Data Structure: ', JSON.stringify(dataStructure, null, 4));
	});	
});



</script>
