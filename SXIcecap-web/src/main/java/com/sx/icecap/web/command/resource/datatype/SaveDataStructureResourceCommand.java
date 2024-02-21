package com.sx.icecap.web.command.resource.datatype;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "mvc.command.name="+IcecapMVCCommands.RESOURCE_DATATYPE_SAVE_STRUCTURE
	    },
	    service = MVCResourceCommand.class
)
public class SaveDataStructureResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, "dataTypeId");
		String dataStructure = ParamUtil.getString(resourceRequest, "dataStructure");

/************************************************************************************************
 *	Block out for future use of  term management 
 *
//		System.out.println("dataStructure: " + dataStructure);
		
		JSONObject jsonDataStructure = JSONFactoryUtil.createJSONObject(dataStructure);
		if( jsonDataStructure.length() == 0 ) {
			return;
		}
		
		JSONArray terms = jsonDataStructure.getJSONArray("terms");
		
//		System.out.println(terms.toString());
//		System.out.println("Term Count: "+terms.length());
		
		ServiceContext sc = ServiceContextFactory.getInstance(Term.class.getName(), resourceRequest);
		Date now = new Date();
		sc.setCreateDate(now);
		sc.setModifiedDate(now);
		
		for( int i=0; i<terms.length(); i++ ) {
			JSONObject term = terms.getJSONObject(i);
			if( Validator.isNull(term) ) {
				System.out.println("What happen to the term? : " + i );
			}
			System.out.println( "Dirty: " + term.getBoolean("dirty") );
			if( ! term.getBoolean("dirty") ) {
				continue;
			}
			
			String termType = term.getString("termType");
			String termName = term.getString("termName");
			String termVersion = term.getString("termVersion");
			System.out.println("Term Version: " + termVersion);
			if( termVersion.isEmpty() ) {
				termVersion = "1.0.0";
			}
			
			Map<Locale, String> displayNameMap = _jsonObject2LocaleMap( term.getJSONObject("displayName") );
			JSONObject jsonDefinition = term.getJSONObject("definition");
			Map<Locale, String> definitionMap = Validator.isNotNull(jsonDefinition) ? _jsonObject2LocaleMap( jsonDefinition ) : null;
			JSONObject jsonTooltip = term.getJSONObject("tooltip");
			Map<Locale, String> tooltipMap = Validator.isNotNull(jsonDefinition) ? _jsonObject2LocaleMap( jsonTooltip) : null ;
			
			String synonyms = term.getString("synonyms");
			boolean mandatory = term.getBoolean("mandatory");
			boolean abstractKey = term.getBoolean("abstractKey");
			boolean disabled = term.getBoolean("disabled");
			boolean searchable = term.getBoolean("searchable");
			boolean downloadable = term.getBoolean("downloadable");
			String value = term.getString("value");
			int status = term.getInt("status", WorkflowConstants.STATUS_DRAFT);
			
			JSONObject jsonGroupTermId = term.getJSONObject("groupTermId");
			String groupTermId = "";
			if( jsonGroupTermId != null ) {
				groupTermId = jsonGroupTermId.toJSONString();
			}
			
			String typeAttributes = _extractTermTypeAttributes(term, termType);
			
			boolean standard = term.getBoolean(IcecapSSSTermAttributes.STANDARD);
			
			boolean dirty = term.getBoolean("dirty");
			
			_printOutTermAttributes(termType, termName, termVersion, displayNameMap, definitionMap, tooltipMap, synonyms, mandatory, searchable, downloadable, value, typeAttributes, groupTermId, status);
			
			Term existTerm = null;
			try{
				existTerm = _termLocalService.getTerm(termName, termVersion);
			} catch( NoSuchTermException e ) {
				System.out.println("There is no saved term  to be added in DB...");
			}

			if( Validator.isNotNull(existTerm) && dirty == true ) {
				_termLocalService.updateTerm(
						existTerm.getTermId(),
						termName, 
						termVersion, 
						termType, 
						displayNameMap, 
						definitionMap, 
						tooltipMap, 
						synonyms, 
						typeAttributes, 
						groupTermId, 
						status,
						standard,
						sc);
			}
			else if( Validator.isNull(existTerm) ){
				_termLocalService.addTerm(
						termName, 
						termVersion, 
						termType, 
						displayNameMap, 
						definitionMap, 
						tooltipMap, 
						synonyms, 
						typeAttributes, 
						groupTermId, 
						status,
						standard,
						sc);
			}
		}
 */
		
		_dataTypeLocalService.setDataTypeStructure(dataTypeId, dataStructure);
	}
	
	private void _printOutTermAttributes( 
							String termType, 
							String termName, 
							String termVersion, 
							Map<Locale, String> displayNameMap,
							Map<Locale, String> definitionMap,
							Map<Locale, String> tooltipMap,
							String synonyms,
							boolean mandatory,
							boolean searchable,
							boolean downloadable,
							String value,
							String attributes,
							String groupTermId,
							long status) {
		
		System.out.println("******** " + termName + " v. " + termVersion + " *******");
		System.out.println("Type: " + termType );
		System.out.println("DisplayName: " + displayNameMap.toString() );
		displayNameMap.forEach((locale, val)->{ System.out.println(locale.toString() + ", " +val); }) ;
		
		String defStr = Validator.isNotNull( definitionMap ) ? definitionMap.toString()  : "";
		System.out.println( "Definition: " + defStr ); 
		String tipStr = Validator.isNotNull( tooltipMap ) ? tooltipMap.toString()  : "";
		System.out.println("Tooltip: " + tipStr );
		System.out.println("Synonyms: " + synonyms );
		System.out.println("Mandatory: " + mandatory );
		System.out.println("Searchable: " + searchable );
		System.out.println("Downloadable: " + downloadable );
		System.out.println("Value: " + value );
		System.out.println("Attributes: " + attributes );
		System.out.println("GroupTermId: " + groupTermId );
		System.out.println("Status: " + status );
		System.out.println("***************************************************");
		
	}
	/**
	 * GroupTerm has no dedicated attributes.
	 * 
	 * @param jsonObj
	 * @param termType
	 * @return
	 */
	private String _extractTermTypeAttributes( JSONObject jsonObj, String termType ) {
		
		if( termType.equalsIgnoreCase(IcecapSSSTermTypes.STRING) ) {
			return _extractStringAttributes(jsonObj);
		}
		else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.NUMERIC) ) {
			return _extractNumericAttributes(jsonObj);
		}
		else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.LIST) || 
				   termType.equalsIgnoreCase(IcecapSSSTermTypes.BOOLEAN) ) {
			return _extractListAttributes(jsonObj);
		}
		else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.DATE)) {
			return _extractDateAttributes(jsonObj);
		}
		else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.FILE)) {
			return _extractFileAttributes(jsonObj);
		}
		else if( termType.equalsIgnoreCase(IcecapSSSTermTypes.GROUP)) {
			return _extractGroupAttributes(jsonObj);
		}
		else {
			return "";
		}
		
	}
	
	private String _extractStringAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( !jsonObj.isNull("placeHolder") ) {
			JSONObject jsonPlaceHolder = jsonObj.getJSONObject("placeHolder");
			System.out.println( "jsonPlaceHolder: " + jsonPlaceHolder.toJSONString() );
			json.put("placeHolder",  jsonPlaceHolder.toJSONString() );
		}
		
		if( !jsonObj.isNull("minLength") ) {
			json.put("minLength",  jsonObj.getInt("minLength"));
		}

		if( !jsonObj.isNull("maxLength") ) {
			json.put("maxLength",  jsonObj.getInt("maxLength"));
		}

		if( !jsonObj.isNull("multiLine") ) {
			json.put("multiLine",  jsonObj.getBoolean("multiLine"));
		}
		
		if( !jsonObj.isNull("validationRule") ) {
			json.put("validationRule",  jsonObj.getString("validationRule"));
		}
		return json.toJSONString();
	}
	
	private String _extractNumericAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( !jsonObj.has("minValue") ) {
			json.put("minValue",  jsonObj.getDouble("minValue"));
		}
		
		if( !jsonObj.has("minBoundary") ) {
			json.put("minBoundary",  jsonObj.getBoolean("minBoundary"));
		}

		if( !jsonObj.has("maxValue") ) {
			json.put("maxValue",  jsonObj.getDouble("maxValue"));
		}
		
		if( !jsonObj.has("maxBoundary") ) {
			json.put("maxBoundary",  jsonObj.getBoolean("maxBoundary"));
		}

		if( !jsonObj.has("unit") ) {
			json.put("unit",  jsonObj.getString("unit"));
		}

		if( !jsonObj.has("uncertainty") ) {
			json.put("uncertainty",  jsonObj.getBoolean("uncertainty"));
		}

		if( !jsonObj.has("sweepable") ) {
			json.put("sweepable",  jsonObj.getBoolean("sweepable"));
		}
		
		if( !jsonObj.has("placeHolder") ) {
			json.put("placeHolder",  jsonObj.getString("placeHolder"));
		}

		return json.toJSONString();
	}
	
	/**
	 * This function is shared by ListTerm and BooleanTerm 
	 * because BooleanTerm is a kind of special cases of the ListTerm. 
	 * 
	 * @param jsonObj
	 * @return
	 */
	private String _extractListAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( jsonObj.has("displayStyle") ) {
			json.put("displayStyle",  jsonObj.getString("displayStyle"));
		}
		
		if( jsonObj.has("options") ) {
			JSONArray jsonOptions = jsonObj.getJSONArray("options");
			
			if( jsonOptions != null ) {
				json.put("options",  jsonOptions);
			}
		}

		return json.toJSONString();
	}
	
	private String _extractDateAttributes( JSONObject jsonObj ) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if( jsonObj.has("enableTime") ) {
			json.put("enableTime",  jsonObj.getString("enableTime"));
		}
		
		System.out.println("Date Attrs: " + json.toString());
		return json.toJSONString();
	}
	
	private String _extractFileAttributes(JSONObject jsonObj) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		return json.toJSONString();
	}
	
	private String _extractGroupAttributes(JSONObject jsonObj) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		
		if(  jsonObj.has("extended") ) {
			json.put("extended",jsonObj.getBoolean("extended"));
		}
		
		return json.toJSONString();
	}
	
	private Map<Locale, String> _jsonObject2LocaleMap( JSONObject jsonObj ){
		Map<Locale, String> map = new HashMap<Locale, String>();
		if( Validator.isNull(jsonObj) ) {
			return map;
		}
		
		Iterator<String> keyIterator = jsonObj.keys();
		System.out.println("_jsonObject2Map: "+jsonObj.length());
		while( keyIterator.hasNext() ) {
			String key = keyIterator.next();
			map.put(LocaleUtil.fromLanguageId(key), jsonObj.getString(key));
		}

		return map;
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private TermLocalService _termLocalService;
}
