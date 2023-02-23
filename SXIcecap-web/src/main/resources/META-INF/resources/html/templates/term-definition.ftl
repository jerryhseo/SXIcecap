
<aui:fieldset-group markupView="lexicon">
	<aui:fieldset label="term-definition">
		<aui:row>
			<aui:col md="5">
						<aui:input 
										name="termName" 
										label="parameter-name"  
										required="true" 
										placeholder="ex) parameterName"
										helpMessage="parameter-name-help"
						</aui:input>
			</aui:col>
			<aui:col md="2">
						<aui:input 
										name="termVersion" 
										label="term-version" 
										required="true"
										helpMessage="parameter-version-help">
						</aui:input>
			</aui:col>
			<aui:col md="5">
				<aui:field-wrapper name="displayName" required="true" label="term-display-name" helpMessage="term-display-name-help">
						<liferay-ui:input-localized 
										name="displayName"
										xml="" >
						</liferay-ui:input-localized>
				</aui:field-wrapper>
			</aui:col>
		</aui:row>
	</aui:fieldset>
</aui:fieldset-group>