package com.sx.icecap.util.comparator.sss;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class IcecapSSSUtil {
	public static String mapToJson( Map<Locale, String> map ) {
		Set<Locale> keySet = map.keySet();
		JSONObject jsonMap = JSONFactoryUtil.createJSONObject();
		for( Locale locale : keySet ) {
			jsonMap.put(locale.toString(), map.get(locale));
		}
		
		return jsonMap.toJSONString();
	}
}
