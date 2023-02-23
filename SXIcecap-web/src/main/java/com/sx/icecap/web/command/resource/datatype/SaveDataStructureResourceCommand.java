package com.sx.icecap.web.command.resource.datatype;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.constant.IcecapDataTypeMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.search.datatype.DataTypeSearchRegistrar;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "mvc.command.name="+IcecapDataTypeMVCCommands.RESOURCE_DATATYPE_SAVE_STRUCTURE
	    },
	    service = MVCResourceCommand.class
)
public class SaveDataStructureResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long dataTypeId = ParamUtil.getLong(resourceRequest, "dataTypeId");
		String dataStructure = ParamUtil.getString(resourceRequest, "dataStructure");
		
//		System.out.println("dataTypeId: " + dataTypeId);
		System.out.println( "+++++ Data Structure Length: " + dataStructure.length() );
		
		JSONObject jsonDataStructure = JSONFactoryUtil.createJSONObject(dataStructure);

//		System.out.println(jsonDataStructure.toString(4));
		
		JSONArray terms = jsonDataStructure.getJSONArray("terms");
//		System.out.println(terms.toString(4));
//		System.out.println("Term Count: "+terms.length());
		
		ServiceContext sc = ServiceContextFactory.getInstance(Term.class.getName(), resourceRequest);
		Date now = new Date();
		sc.setCreateDate(now);
		sc.setModifiedDate(now);
		
		for( int i=0; i<terms.length(); i++ ) {
			JSONObject term = terms.getJSONObject(i);
			
			String termType = term.getString("termType");
			String termName = term.getString("termName");
			String termVersion = term.getString("termVersion");
			if( termVersion.isEmpty() ) {
				termVersion = "1.0.0";
			}
			
			Set<Locale> availableLocales = LanguageUtil.getAvailableLocales();
			
			Map<Locale, String> displayNameMap = _jsonObject2Map( term.getJSONObject("displayName") );
			Map<Locale, String> definitionMap = _jsonObject2Map( term.getJSONObject("definition") );
			Map<Locale, String> tooltipMap = _jsonObject2Map( term.getJSONObject("tooltip") );
			
			String synonyms = term.getString("synonyms");
			boolean mandatory = term.getBoolean("mandatory");
			String value = term.getString("value");
			int status = term.getInt("status", WorkflowConstants.STATUS_DRAFT);
			
			JSONObject jsonGroupTermId = term.getJSONObject("groupTermId");
			String groupTermId = "";
			if( jsonGroupTermId != null ) {
				groupTermId = jsonGroupTermId.toJSONString();
			}
			
			String typeAttributes = _extractTermTypeAttributes(term, termType);
			
			boolean standard = term.getBoolean(IcecapSSSTermAttributes.STANDARD);
			
			_printOutTermAttributes(termType, termName, termVersion, displayNameMap, definitionMap, tooltipMap, synonyms, mandatory, value, typeAttributes, groupTermId, status);
			
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
							String value,
							String attributes,
							String groupTermId,
							long status) {
		
		System.out.println("******** " + termName + " v. " + termVersion + " *******");
		System.out.println("Type: " + termType );
		System.out.println("DisplayName: " + displayNameMap.toString() );
		System.out.println("Definition: " + definitionMap.toString() );
		System.out.println("Tooltip: " + tooltipMap.toString() );
		System.out.println("Synonyms: " + synonyms );
		System.out.println("Mandatory: " + mandatory );
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
		
		if( !jsonObj.isNull("minValue") ) {
			json.put("minValue",  jsonObj.getDouble("minValue"));
		}
		
		if( !jsonObj.isNull("minBoundary") ) {
			json.put("minBoundary",  jsonObj.getBoolean("minBoundary"));
		}

		if( !jsonObj.isNull("maxValue") ) {
			json.put("maxValue",  jsonObj.getDouble("maxValue"));
		}
		
		if( !jsonObj.isNull("maxBoundary") ) {
			json.put("maxBoundary",  jsonObj.getBoolean("maxBoundary"));
		}

		if( !jsonObj.isNull("unit") ) {
			json.put("unit",  jsonObj.getString("unit"));
		}

		if( !jsonObj.isNull("uncertainty") ) {
			json.put("uncertainty",  jsonObj.getBoolean("uncertainty"));
		}

		if( !jsonObj.isNull("sweepable") ) {
			json.put("sweepable",  jsonObj.getBoolean("sweepable"));
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
		
		if( !jsonObj.isNull("displayStyle") ) {
			json.put("displayStyle",  jsonObj.getString("displayStyle"));
		}
		
		if( !jsonObj.isNull("options") ) {
			JSONArray jsonOptions = jsonObj.getJSONArray("options");
			
			if( jsonOptions != null ) {
				json.put("options",  jsonOptions);
			}
		}

		return json.toJSONString();
	}
	
	private Map<Locale, String> _jsonObject2Map( JSONObject jsonObj ){
		Map<Locale, String> map = new HashMap<Locale, String>();
		Iterator<String> keyIterator = jsonObj.keys();
		System.out.println("_jsonObject2Map: "+jsonObj.length());
		while( keyIterator.hasNext() ) {
			String key = keyIterator.next();
			String[] langCode = key.split("_");
			map.put(new Locale(langCode[0], langCode[1]), jsonObj.getString(key));
		}

		return map;
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;
	
	@Reference
	private TermLocalService _termLocalService;
}
