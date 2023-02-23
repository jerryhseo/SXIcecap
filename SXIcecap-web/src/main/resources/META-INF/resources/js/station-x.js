(function (w, factory) {
	if( w.StationX ) return;
        
	w.StationX = factory();
}(this, function () {
	let namespace;

	class TermTypes{
		static STRING = 'String';
		static NUMERIC = 'Numeric';
		static BOOLEAN = 'Boolean';
		static LIST = 'List';
		static LIST_ARRAY = 'ListArray';
		static MATRIX = 'Matrix';
		static FILE = 'File';
		static FILE_ARRAY = 'FileArray';
		static OBJECT = 'Object';
		static OBJECT_ARRAY = 'ObjectArray';
		static ARRAY = 'Array';
		static DATA_LINK = 'DataLink';
		static DATA_LINK_ARRAY = 'DataLinkArray';
		static DATE = 'Date';
		static PHONE = 'Phone';
		static EMAIL = 'EMail';
		static GROUP = 'Group';
		static COMMENT = 'Comment';
		
		constructor(){
		}
		

		static TERM_TYPES(){
			return [ 
				SXIceacpSSSTermTypes.STRING,
				SXIceacpSSSTermTypes.NUMERIC,
				SXIceacpSSSTermTypes.BOOLEAN,
				SXIceacpSSSTermTypes.LIST,
				SXIceacpSSSTermTypes.LIST_ARRAY,
				SXIceacpSSSTermTypes.MATRIX,
				SXIceacpSSSTermTypes.FILE,
				SXIceacpSSSTermTypes.FILE_ARRAY,
				SXIceacpSSSTermTypes.OBJECT,
				SXIceacpSSSTermTypes.OBJECT_ARRAY,
				SXIceacpSSSTermTypes.ARRAY,
				SXIceacpSSSTermTypes.DATA_LINK,
				SXIceacpSSSTermTypes.DATA_LINK_ARRAY,
				SXIceacpSSSTermTypes.DATE,
				SXIceacpSSSTermTypes.PHONE,
				SXIceacpSSSTermTypes.EMAIL,
				SXIceacpSSSTermTypes.GROUP,
				SXIceacpSSSTermTypes.COMMENT
			]
		}

	}
	
	class TermAttributes{
		constructor(){
		}
		
		static ACTIVE = 'active';
		static AVAILABLE_LANGUAGE_IDS = 'availableLanguageIds';
		static COUNTRY_CODE = 'countryCode';
		static DATATYPE_NAME = 'dataTypeName';
		static DATATYPE_VERSION = 'dataTypeVersion';
		static DEFINITION = 'definition';
		static DEFAULT_LANGUAGE_ID = 'defaultLanguageId';
		static DEFAULT_LOCALE = 'defaultLocale';
		static DEPENDENT_TERMS = 'dependentTerms';
		static DIMENSION_X = 'dimensionX';
		static DIMENSION_Y = 'dimensionY';
		static DISABLED = 'disabled';
		static DISPLAY_NAME = 'displayName';
		static DISPLAY_STYLE = 'displayStyle';
		static ELEMENT_TYPE = 'elementType';
		static FILE_ID = 'fileId';
		static FORMAT = 'format';
		static ID = 'id';
		static LIST_ITEM = 'listItem';
		static LIST_ITEM_VALUE = 'listItemValue';
		static LIST_ITEMS = 'listItems';
		static LOWER_BOUNDARY = 'lowerBoundary';
		static LOWER_OPERAND = 'lowerOperand';
		static MANDATORY = 'mandatory';
		static NAME = 'name';
		static MAX_LENGTH ="maxLength_";
		static MAX_VALUE ="maxValue_";
		static MIN_LENGTH ="minLength_";
		static MIN_VALUE ="minValue_";
		static NAME_TEXT = 'nameText';
		static NEW_LINE ="newLine_";
		static OPERAND = 'operand';
		static ORDER = 'order';
		static PATH = 'path';
		static PATH_TYPE = 'pathType';
		static RANGE = 'range';
		static REF_DATATYPES = 'refDataTypes';
		static REF_DATABASES = 'refDatabases';
		static SWEEPABLE = 'sweepable';
		static SYNONYMS = 'synonyms';
		static TERM_NAME = 'termName';
		static TERM_TYPE = 'termType';
		static TERM_VERSION = 'termVersion';
		static TEXT = 'text';
		static TOOLTIP = 'tooltip';
		static UNCERTAINTY = 'uncertainty';
		static UNCERTAINTY_VALUE = 'uncertaintyValue';
		static UNIT = 'unit';
		static UPPER_BOUNDARY = 'upperBoundary';
		static UPPER_OPERAND = 'upperOperand';
		static URI = 'uri';
		static URI_TYPE = 'uriType';
		static URL = 'url';
		static VALIDATION_RULE  = 'validationRule';
		static VALUE = 'value';
		static VALUE_DELIMITER = 'valueDelimiter';
		static VERSION = 'version';

	}
	
	class LocalizedObject {
		constructor( defaultLanId, jsonContent  ){
			this.defaultLanguigeId = defaultLanId;
			
			if( jsonContent ){
				parseJSON( jsonContent );
			}
		}
		
		getText( locale ){
			return this[locale];
		}
		
		addText( locale, text, force ){
			this[locale] = text;
		}
		
		updateText( locale, text ){
			this[locale] = text;
		}
		
		removeText( locale ){
			delete this[locale];
		}
		
		toXML(){
			
		}
		
		toJSON( withDefualt ){
			
		}
		
		parseXML( xml ){
			
		}
		
		parseJSON( jsonContent ){
			let content = jsonContent;
			if( typeof jsonContent === 'string' ){
				content = JSON.parse( jsonContent );
			}
			
			for( key in content ){
				this[key] = content[key];
			}
		}
	}
	
	class Term {
		
		constructor( termType, defaultLanguageId ){
			this.namespace = namespace;
			this.termId = 0;
			this.companyId = 0;
			this.groupId = 0;
			this.userId = 0;
			this.userName = 0;
			this.createDate = null;
			this.modifiedDate = null;
			this.status ='';
			this.termType = termType;
			this.termName = '';
			this.termVersion = '';
			this.displayName = new LocalizedObject(defaultLanguageId);
			this.definition = new LocalizedObject(defaultLanguageId);
			this.tooltip = new LocalizedObject(defaultLanguageId);
			this.synonyms = new Array();
		}
		
		toJSON(){
			
		}
		
		parse( json ){
			
		}
		
		getRenderParams(){
			return {
					namespaece + 'termId': this.termId,
					namespaece + 'termType': this.termType,
					namespaece + 'termName': this.termName,
					namespaece + 'termVersion': this.termVersion,
			};

		}
		
		render( url, cssClasses ){
			
			$.ajax({
					url: url,
					data:getRenderParams(),
					dataType: 'json',
					success: function( result, status, xhr){
						console.log( 'Success: ', result);
					},
					error: function(xhr, status, error){
						onsole.log( error );
					}
			});
			 
		}
	}
	
	class StringTerm extends Term {
		
		constructor( defaultLanguageId ){
			super( 'String', defaultLanguageId );
		}
		
		toJSON(){
			
		}
		
		parse( json ){
			super.parse( json );
			
			
		}
		
		render( events, cssClasses ){
			super.render( cssClasses );
			
		}
	}
	
	class DataType {
		constructor(){
			
		}
		
		static numOfTerms = 0;
	}
	
    return {
    	setNamespace: function( ns ){
    		namespace = ns;
    	},
    	
    	getNamespace: () => { return namespace; },
    	
    	Term: (termType) => { return new Term( 'String ' ); },
    	StringTerm: () => { return new StringTerm(); }
    };
}
));


