package com.sx.icecap.web.command.action.sss;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;
import com.sx.icecap.util.comparator.sss.IcecapSSSTermAttributeUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_ADMIN_TERM_ADD
		},
		service = MVCActionCommand.class
)
public class AddTermActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String termType = ParamUtil.getString(actionRequest, StationXWebKeys.SELECTED_TERM_TYPE);
		
		
		String name = ParamUtil.getString(actionRequest, IcecapSSSTermAttributes.TERM_NAME);
		String version = ParamUtil.getString(actionRequest, IcecapSSSTermAttributes.TERM_VERSION);
		Map<Locale, String> displayNameMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapSSSTermAttributes.DISPLAY_NAME);
		Map<Locale, String> definitionMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapSSSTermAttributes.DEFINITION);
		String synonyms = ParamUtil.getString(actionRequest, IcecapSSSTermAttributes.SYNONYMS);
		Map<Locale, String> tooltipMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapSSSTermAttributes.TOOLTIP);
		int status = ParamUtil.getInteger(actionRequest, IcecapSSSTermAttributes.STATUS, WorkflowConstants.STATUS_ANY);
		String dedicatedAttributes = IcecapSSSTermAttributeUtil.getTypeDedicatedAttributes(actionRequest, termType);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext sc = ServiceContextFactory.getInstance(Term.class.getName(), actionRequest);
		long[] categoryIds = sc.getAssetCategoryIds();
		for( long categoryId : categoryIds ) {
			AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(categoryId);
			System.out.println("Category["+categoryId+"]: "+category.getTitle(themeDisplay.getLocale()));
		}
		System.out.println("=== Term Attributes ===");
		System.out.println(IcecapSSSTermAttributes.TERM_TYPE+": "+termType);
		System.out.println(IcecapSSSTermAttributes.TERM_NAME+": "+name);
		System.out.println(IcecapSSSTermAttributes.TERM_VERSION+": "+version);
		System.out.println(IcecapSSSTermAttributes.DISPLAY_NAME+": "+IcecapSSSTermAttributeUtil.convertLocalizedMapToJson(displayNameMap));
		System.out.println(IcecapSSSTermAttributes.DEFINITION+": "+IcecapSSSTermAttributeUtil.convertLocalizedMapToJson(definitionMap));
		System.out.println(IcecapSSSTermAttributes.SYNONYMS+": "+synonyms);
		System.out.println(IcecapSSSTermAttributes.TOOLTIP+": "+IcecapSSSTermAttributeUtil.convertLocalizedMapToJson(tooltipMap));
		System.out.println("Dedicated Attributes: "+dedicatedAttributes);
		System.out.println("Category Count: "+categoryIds.length);
		
		System.out.println("=== END Term Attributes ===");
		
		_termLocalService.addTerm(name, version, termType, displayNameMap, definitionMap, tooltipMap, synonyms, dedicatedAttributes, "", status, true, sc);
	}
	
	@Reference
	private TermLocalService _termLocalService;
}
