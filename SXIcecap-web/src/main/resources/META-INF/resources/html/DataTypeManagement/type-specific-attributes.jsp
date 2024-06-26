<%@ include file="../init.jsp" %>

<%
	String termType = ParamUtil.getString(renderRequest, "termType");
%>


	<c:choose>
		<c:when test="<%= termType.equalsIgnoreCase("String") %>" >
			<aui:container>
				<aui:row>
					<aui:col>
						<aui:field-wrapper name="placeHolder" label="place-holder" helpMessage="place-holder-help">
							<liferay-ui:input-localized 
											name="placeHolder"
											xml="">
							</liferay-ui:input-localized>
						</aui:field-wrapper>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:input 
								type="number"
								id="minLength" 
								name="minLength" 
								label="min-length"
								value="1"
								helpMessage="min-length-help">
						</aui:input>
					</aui:col>
					<aui:col md="6">
						<aui:input 
								type="number"
								id="maxLength" 
								name="maxLength" 
								label="max-length" 
								value="72"
								helpMessage="string-max-length-help">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<aui:input 
								type="checkbox"
								id="multipleLine" 
								name="multipleLine" 
								label="multiple-line" 
								helpMessage="string-multiple-line-help">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<aui:input 
								type="text"
								id="validationRule" 
								name="validationRule" 
								label="validation-rule"
								value="^[\w\s!@#\$%\^\&*\)\(+=._-]*$" 
								helpMessage="string-validation-rule-help">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="12">
						<aui:input 
								type="text"
								id="inputSize" 
								name="inputSize" 
								label="input-size"
								value="5" 
								inlineField="true"
								inlineLabel="left"
								helpMessage="input-size-help">
						</aui:input>
						<aui:input 
								type="checkbox"
								id="lineBreak" 
								name="lineBreak" 
								label="line-break"
								inlineField="true"
								helpMessage="line-break-help">
						</aui:input>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Numeric") %>" >
			<aui:container>
				<aui:row>
					<aui:col md="6">
						<aui:input name="minValue" label="min-value" type="number" helpMessage="min-value-help"></aui:input>
					</aui:col>
					<aui:col md="6">
						<div class="vertical-align-bottom">
							<aui:input name="minBoundary" label="include-boundary" type="checkbox" disabled="true"></aui:input>
						</div>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:input name="maxValue" label="max-value" type="number" helpMessage="max-value-help"></aui:input>
					</aui:col>
					<aui:col md="6">
						<div class="vertical-align-bottom">
							<aui:input name="maxBoundary" label="include-boundary" type="checkbox" disabled="true"></aui:input>
						</div>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="8">
						<aui:input name="unit" label="unit" helpMessage="numeric-unit-help"></aui:input>
					</aui:col>
					<aui:col md="4">
						<aui:input name="unitPreview"disabled="true"></aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:input name="uncertainty" label="allow-uncertainty" type="checkbox" helpMessage="numeric-allow-uncertainty-help"></aui:input>
					</aui:col>
					<aui:col md="6">
						<aui:input name="sweepable" label="sweepable" type="checkbox" helpMessage="numeric-sweepable-help"></aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<aui:field-wrapper name="placeHolder" label="place-holder" helpMessage="place-holder-help">
							<liferay-ui:input-localized 
											name="placeHolder"
											xml="">
							</liferay-ui:input-localized>
						</aui:field-wrapper>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="12">
						<aui:input 
								type="text"
								id="inputSize" 
								name="inputSize" 
								label="input-size"
								value="5" 
								inlineField="true"
								inlineLabel="left"
								helpMessage="input-size-help">
						</aui:input>
						<aui:input 
								type="checkbox"
								id="lineBreak" 
								name="lineBreak" 
								label="line-break"
								inlineField="true"
								helpMessage="line-break-help">
						</aui:input>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("List") %>" >
			<aui:container>
				<aui:row>
					<aui:col>
						<aui:fieldset-group markupView="lexicon" >
							<aui:fieldset label="display-style"  helpMessage="list-display-style-help">
								<div style="display:inline-block; margin-left:10px; margin-right:10px;">
									<aui:input type="radio" name="displayStyle" label="select-box" value="select" checked="true"></aui:input>
								</div>
								<div style="display:inline-block; margin-left:10px; margin-right:10px;">
									<aui:input type="radio" name="displayStyle" label="radio" value="radio"></aui:input>
								</div>
								<div style="display:inline-block; margin-left:10px; margin-right:10px;">
									<aui:input type="radio" name="displayStyle" label="check-box" value="check"></aui:input>
								</div>
							</aui:fieldset>
						</aui:fieldset-group>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<aui:input 
								type="checkbox"
								id="multiple" 
								name="multiple" 
								label="multiple" 
								style="margin-top:15px;"
								helpMessage="multiple-select-help">
						</aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<aui:field-wrapper name="placeHolder" label="place-holder" helpMessage="place-holder-help">
							<liferay-ui:input-localized 
											name="placeHolder"
											xml="">
							</liferay-ui:input-localized>
						</aui:field-wrapper>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col>
						<div class="form-group input-text-wrapper" style="margin-top:10px;">
							<label class="control-label" for="" style="width:100%;"><liferay-ui:message key="options">:</liferay-ui:message>
								<span class="reference-mark text-warning">
									<svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="presentation" viewBox="0 0 512 512">
										<path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
									</svg>
								</span>
								<span class="hide-accessible">Required</span>
								<span class="taglib-icon-help lfr-portal-tooltip" title="<liferay-ui:message key="list-options-help"/>">
									<span>
										<svg class="lexicon-icon lexicon-icon-question-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
											<path class="lexicon-icon-outline" d="M256 0c-141.37 0-256 114.6-256 256 0 141.37 114.629 256 256 256s256-114.63 256-256c0-141.4-114.63-256-256-256zM269.605 360.769c-4.974 4.827-10.913 7.226-17.876 7.226s-12.873-2.428-17.73-7.226c-4.857-4.827-7.285-10.708-7.285-17.613 0-6.933 2.428-12.844 7.285-17.788 4.857-4.915 10.767-7.402 17.73-7.402s12.932 2.457 17.876 7.402c4.945 4.945 7.431 10.854 7.431 17.788 0 6.905-2.457 12.786-7.431 17.613zM321.038 232.506c-5.705 8.923-13.283 16.735-22.791 23.464l-12.99 9.128c-5.5 3.979-9.714 8.455-12.668 13.37-2.955 4.945-4.447 10.649-4.447 17.145v1.901h-34.202c-0.439-2.106-0.731-4.184-0.936-6.291s-0.321-4.301-0.321-6.612c0-8.397 1.901-16.413 5.705-24.079s10.24-14.834 19.309-21.563l15.185-11.322c9.070-6.7 13.605-15.009 13.605-24.869 0-3.57-0.644-7.080-1.901-10.533s-3.219-6.495-5.851-9.128c-2.633-2.633-5.969-4.71-9.977-6.291s-8.66-2.369-13.927-2.369c-5.705 0-10.561 1.054-14.571 3.16s-7.343 4.769-9.977 8.017c-2.633 3.247-4.594 7.022-5.851 11.322s-1.901 8.66-1.901 13.049c0 4.213 0.41 7.548 1.258 10.065l-39.877-1.58c-0.644-2.311-1.054-4.652-1.258-7.080-0.205-2.399-0.321-4.769-0.321-7.080 0-8.397 1.58-16.619 4.74-24.693s7.812-15.214 13.927-21.416c6.114-6.173 13.663-11.176 22.645-14.951s19.368-5.676 31.188-5.676c12.229 0 22.996 1.785 32.3 5.355 9.274 3.57 17.087 8.25 23.435 14.014 6.319 5.764 11.089 12.434 14.248 19.982s4.74 15.331 4.74 23.289c0.058 12.581-2.809 23.347-8.514 32.27z"></path>
										</svg>
									</span>
									<span class="taglib-text hide-accessible"><liferay-ui:message key="list-options-help"></liferay-ui:message></span>
								</span>
								<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
								<span id="<portlet:namespace/>btnNewOption" class="right" style="margin-top:3px; padding-right:20px;">
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
							</label>
							<div style=""max-height:400px; overflow:auto;">
								<table class="table table-striped" style="border:solid 2px grey; borderStyle:inset; width:100%; font-size:small; margin-bottom:20px">
									<tbody id="<portlet:namespace/>options">
									</tbody>
								</table>
							</div>
							<div id="<portlet:namespace/>manageListOptions">
								<aui:fieldset-group markupView="lexicon" >
										<aui:fieldset label="edit-list-optione"  helpMessage="edit-list-option-help">
										<aui:field-wrapper name="optionLabel" label="option-label" required="true" helpMessage="option-label-help">
											<liferay-ui:input-localized name="optionLabel" xml=""></liferay-ui:input-localized>
										</aui:field-wrapper> 
										<aui:input id="optionValue" name="optionValue" label="option-value" required="true" helpMessage="option-value-help"></aui:input> 
										<hr class="content-horizontal-line">
										<aui:button-row>
											<aui:button id="btnListChooseSlaveTerms" value="choose-slave-terms"/>
											<aui:button id="btnAddOption" value="add-option" cssClass="right"/>
										</aui:button-row>
									</aui:fieldset>
								</aui:fieldset-group>
							</div>
						</div>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Boolean") %>" >
			<aui:container>
				<aui:row>
					<aui:col>
						<aui:fieldset-group markupView="lexicon" >
							<aui:fieldset label="display-style"  helpMessage="boolean-display-style-help">
								<div style="display:inline-block; margin-left:10px; margin-right:10px;">
									<aui:input type="radio" name="displayStyle" label="select-box" value="select" checked="true"></aui:input>
								</div>
								<div style="display:inline-block; margin-left:10px; margin-right:10px;">
									<aui:input type="radio" name="displayStyle" label="radio" value="radio"></aui:input>
								</div>
							</aui:fieldset>
							<aui:field-wrapper name="placeHolder" label="place-holder" helpMessage="place-holder-help">
								<liferay-ui:input-localized 
												name="placeHolder"
												xml="">
								</liferay-ui:input-localized>
							</aui:field-wrapper>
							<aui:fieldset label="display-labels" helpMessage="boolean-display-labels-help">
								<div style="display:flex;">
									<div style="display:inline-block; margin-left:10px; margin-right:10px;">
										<aui:field-wrapper name="trueLabel" label="true-label">
											<%
												String xml = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"en_US,ko_KR\" default-locale=\"en_US\"><TrueLabel language-id=\"en_US\">Yes</TrueLabel><TrueLabel language-id=\"ko_KR\">예</TrueLabel></root>";
											%>
											<liferay-ui:input-localized name="trueLabel" xml="<%= xml %>"></liferay-ui:input-localized>
										</aui:field-wrapper>
									</div>
									 <div style="display:inline-block;margin:1.7rem 10px 0 10px;height:1.2rem;flex-grow:1;">
									 	<span class="btn btn-default" id="<portlet:namespace/>btnTrueSlaveTerms" style="font-size:0.8rem;padding:0 5px 0 5px;"><liferay-ui:message key='active-terms'/></span>
									 </div>
								</div>
								<div style="display:flex;">
									<div style="display:inline-block; margin-left:10px; margin-right:10px;">
										<aui:field-wrapper name="falseLabel" label="false-label">
											<%
												String xml = "<?xml version='1.0' encoding='UTF-8'?><root available-locales=\"en_US,ko_KR\" default-locale=\"en_US\"><FalseLabel language-id=\"en_US\">No</FalseLabel><FalseLabel language-id=\"ko_KR\">아니오</FalseLabel></root>";
											%>
											<liferay-ui:input-localized name="falseLabel" xml="<%= xml %>"></liferay-ui:input-localized>
										</aui:field-wrapper> 
									</div> 
									 <div style="display:inline-block;margin:1.7rem 10px 0 10px;height:1.2rem;flex-grow:1;">
									 	<span class="btn btn-default" id="<portlet:namespace/>btnFalseSlaveTerms" style="font-size:0.8rem;padding:0 5px 0 5px;"><liferay-ui:message key='active-terms'/></span>
									 </div>
								</div>
							</aui:fieldset>
						</aui:fieldset-group> 
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("File") %>" >
			<aui:container>
				<aui:row>
					<aui:col>
						<aui:input type="text" name="allowedExtensions"></aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:button id="chooseDataType" 	value="datatype"></aui:button>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Date") %>" >
			<aui:container>
				<aui:row>
					<aui:col md="6">
						<aui:input type="checkbox" id="enableTime" name="enableTime" helpMessage="date-term-enable-time-help"></aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:input type="text" id="startYear" name="startYear" helpMessage="date-term-start-year-help"></aui:input>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6">
						<aui:input type="text" id="endYear" name="endYear" helpMessage="date-term-end-year-help"></aui:input>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Matrix") %>" >
			<aui:container>
				<aui:row>
					<aui:col md="4">
						<aui:input type="text" name="rows" helpMessage="matrix-rows-help"></aui:input>
					</aui:col>
					<aui:col md="4">
						<aui:input type="text" name="columns" helpMessage="matrix-columns-help"></aui:input>
					</aui:col>
					<aui:col md="4">
						<aui:input type="text" name="columnWidth" helpMessage="matrix-columns-width-help"></aui:input>
					</aui:col>
				</aui:row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Group") %>" >
			<aui:container>
				<aui:row>
					<aui:col>
						<aui:input 
									type="checkbox"
									name="expanded" 
									label="expanded"
									helpMessage="expanded-help">
						</aui:input>
					</aui:col>
				</aui:row>
					<aui:button-row>
						<aui:button id="btnChooseGroupTerms" value="choose-group-terms"/>
					</aui:button-row>
			</aui:container>
		</c:when>
		<c:when test="<%= termType.equalsIgnoreCase("Grid") %>" >
			<aui:container>
				<aui:button-row>
						<aui:button id="btnSelectColumns" value="select-columns"/>
				</aui:button-row>
			</aui:container>
		</c:when>
	</c:choose>
</div>

