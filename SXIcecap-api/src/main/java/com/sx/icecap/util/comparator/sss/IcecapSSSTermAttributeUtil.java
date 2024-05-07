package com.sx.icecap.util.comparator.sss;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletRequest;

public class IcecapSSSTermAttributeUtil {
	public static final int DEFAULT_STRING_MIN_LENGTH = 1;
	public static final int DEFAULT_STRING_MAX_LENGTH = 72;
	public static final boolean DEFAULT_STRING_NEW_LINE = false;
	
	public static String getTypeDedicatedAttributes( PortletRequest portletRequest, String termType ) throws Exception {
		
		if( termType.equals(IcecapSSSTermTypes.STRING) ){
			return getStringAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.NUMERIC) ){
			return getNumericAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.BOOLEAN) ){
			return getBooleanAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.DATE) ){
			return getDateAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.EMAIL) ){
			return getEMailAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.FILE) ){
			return getFileAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.LIST) ){
			return getListAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.MATRIX) ){
			return getMatrixAttributesToJson(portletRequest);
		}
		else if( termType.equals(IcecapSSSTermTypes.PHONE) ){
			return getPhoneAttributesToJson(portletRequest);
		}
		else {
			System.out.println("Un-recognized term type: "+termType);
			throw new Exception("Un-recognized term type: "+termType);
		}
	}
	
	
	public static String getObjectArrayAttributesToJson( PortletRequest portletRequest ) {
		int minLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MIN_LENGTH);
		int maxLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MAX_LENGTH);
		String refDataTypes = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.REF_DATATYPES);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.MIN_LENGTH, minLength);
		jsonAttr.put(IcecapSSSTermAttributes.MAX_LENGTH, maxLength);
		jsonAttr.put(IcecapSSSTermAttributes.REF_DATATYPES, refDataTypes);
		
		return jsonAttr.toJSONString();
	}
	
	public static JSONObject toJsonObject( String strAttr ) {
		
		JSONObject json = null;
		try {
			json = JSONFactoryUtil.createJSONObject(strAttr);
		} catch (JSONException e) {
		}
		
		return json;
	}
	
	public static String getObjectAttributesToJson( PortletRequest portletRequest ) {
		String refDataTypes = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.REF_DATATYPES);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.REF_DATATYPES, refDataTypes);
		
		return jsonAttr.toJSONString();
	}

	public static String getFileArrayAttributesToJson( PortletRequest portletRequest ) {
		String urlType = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.URL_TYPE);
		int minLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MIN_LENGTH);
		int maxLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MAX_LENGTH);
		String refDataTypes = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.REF_DATATYPES);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.URL_TYPE, urlType);
		jsonAttr.put(IcecapSSSTermAttributes.MIN_LENGTH, minLength);
		jsonAttr.put(IcecapSSSTermAttributes.MAX_LENGTH, maxLength);
		jsonAttr.put(IcecapSSSTermAttributes.REF_DATATYPES, refDataTypes);
		
		return jsonAttr.toJSONString();
	}

	public static String getFileAttributesToJson( PortletRequest portletRequest ) {
		String urlType = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.URL_TYPE);
		String dataTypeName = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.DATA_TYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.DATA_TYPE_VERSION);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.URL_TYPE, urlType);
		jsonAttr.put(IcecapSSSTermAttributes.DATA_TYPE_NAME, dataTypeName);
		jsonAttr.put(IcecapSSSTermAttributes.DATA_TYPE_VERSION, dataTypeVersion);
		
		return jsonAttr.toJSONString();
	}

	public static String getMatrixAttributesToJson( PortletRequest portletRequest ) {
		int dimensionX = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.DIMENSION_X);
		int dimensionY = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.DIMENSION_Y);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.DIMENSION_X, dimensionX);
		jsonAttr.put(IcecapSSSTermAttributes.DIMENSION_Y, dimensionY);
		
		return jsonAttr.toJSONString();
	}

	public static String getEMailAttributesToJson( PortletRequest portletRequest ) {
		return null;
	}
	
	public static String getPhoneAttributesToJson( PortletRequest portletRequest ) {
		String countryCode = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.COUNTRY_CODE);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.COUNTRY_CODE, countryCode);
		
		return jsonAttr.toJSONString();
	}

	public static String getDateAttributesToJson( PortletRequest portletRequest ) {
		String displayFormat = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.DISPLAY_FORMAT);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.DISPLAY_FORMAT, displayFormat);
		
		return jsonAttr.toJSONString();
	}

	public static String getArrayAttributesToJson( PortletRequest portletRequest ) {
		int minLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MIN_LENGTH);
		int maxLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MAX_LENGTH);
		String elementType = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.ELEMENT_TYPE);
		String elementUnit = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.UNIT);
		boolean allowUncertainty = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.UNCERTAINTY);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.MIN_LENGTH, minLength);
		jsonAttr.put(IcecapSSSTermAttributes.MAX_LENGTH, maxLength);
		jsonAttr.put(IcecapSSSTermAttributes.ELEMENT_TYPE, elementType);
		jsonAttr.put(IcecapSSSTermAttributes.UNIT, elementUnit);
		jsonAttr.put(IcecapSSSTermAttributes.UNCERTAINTY, allowUncertainty);
		
		return jsonAttr.toJSONString();
	}

	
	public static String getListAttributesToJson( PortletRequest portletRequest ) {
		String displayStyle = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.DISPLAY_STYLE);
		String listItems = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.OPTIONS);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.DISPLAY_STYLE, displayStyle);
		jsonAttr.put(IcecapSSSTermAttributes.OPTIONS, listItems);
		
		return jsonAttr.toJSONString();
	}

	public static String getDataLinkAttributesToJson( PortletRequest portletRequest ) {
		
		String refDatabases = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.REF_DATABASES);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.REF_DATABASES, refDatabases);
		
		return jsonAttr.toJSONString();
	}

	public static String getDataLinkArrayAttributesToJson( PortletRequest portletRequest ) {
		
		int minLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MIN_LENGTH);
		int maxLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MAX_LENGTH);
		String refDatabases = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.REF_DATABASES);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.MIN_LENGTH, minLength);
		jsonAttr.put(IcecapSSSTermAttributes.MAX_LENGTH, maxLength);
		jsonAttr.put(IcecapSSSTermAttributes.REF_DATABASES, refDatabases);
		
		return jsonAttr.toJSONString();
	}

	public static String getBooleanAttributesToJson( PortletRequest portletRequest ) {
		
		String displayStyle = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.DISPLAY_STYLE);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		jsonAttr.put(IcecapSSSTermAttributes.DISPLAY_STYLE, displayStyle);
		
		return jsonAttr.toJSONString();
	}

	public static String getNumericAttributesToJson( PortletRequest portletRequest ) {
		
		String minValue = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.MIN_VALUE);
		String maxValue = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.MAX_VALUE);
		boolean lowerBoundary = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.MIN_BOUNDARY);
		boolean upperBoundary = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.MAX_BOUNDARY);
		String unit = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.UNIT);
		boolean uncertainty = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.UNCERTAINTY);
		boolean sweepable = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.SWEEPABLE);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		if( !minValue.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.MIN_VALUE, minValue);
		if( !maxValue.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.MAX_VALUE, maxValue);
		if( !minValue.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.MIN_BOUNDARY, lowerBoundary);
		if( !maxValue.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.MAX_BOUNDARY, upperBoundary);
		if( !unit.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.UNIT, unit);
		jsonAttr.put(IcecapSSSTermAttributes.UNCERTAINTY, uncertainty);
		jsonAttr.put(IcecapSSSTermAttributes.SWEEPABLE, sweepable);
		
		return jsonAttr.toJSONString();
	}

	public static String getStringAttributesToJson( PortletRequest portletRequest ) {
		
		int minLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MIN_LENGTH);
		int maxLength = ParamUtil.getInteger(portletRequest, IcecapSSSTermAttributes.MAX_LENGTH);
		boolean multiLine = ParamUtil.getBoolean(portletRequest, IcecapSSSTermAttributes.MULTI_LINE);
		String validationRule = ParamUtil.getString(portletRequest, IcecapSSSTermAttributes.VALIDATION_RULE);
		
		JSONObject jsonAttr = JSONFactoryUtil.createJSONObject();
		if( minLength > 1)
			jsonAttr.put(IcecapSSSTermAttributes.MIN_LENGTH, minLength);
		if( maxLength > minLength &&  maxLength != DEFAULT_STRING_MAX_LENGTH )
			jsonAttr.put(IcecapSSSTermAttributes.MAX_LENGTH, maxLength);
		if( multiLine != DEFAULT_STRING_NEW_LINE )
			jsonAttr.put(IcecapSSSTermAttributes.MULTI_LINE, multiLine);
		if( !validationRule.isEmpty() )
			jsonAttr.put(IcecapSSSTermAttributes.VALIDATION_RULE, validationRule);
		
		return jsonAttr.toJSONString();
	}
	
	public static String convertLocalizedMapToJson( Map<Locale, String> map ) {
		Set<Locale> keySet = map.keySet();
		JSONObject jsonMap = JSONFactoryUtil.createJSONObject();
		for( Locale locale : keySet ) {
			jsonMap.put(locale.toString(), map.get(locale));
		}
		
		return jsonMap.toJSONString();
	}
}
