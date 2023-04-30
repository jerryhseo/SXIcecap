package com.sx.icecap.web.command.action.datatype;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.constant.StationXPropertyKeys;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.util.portlet.SXPortletURLUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_DATATYPE_REDIRECT_TO_SD_LIST
		},
		service = MVCActionCommand.class
)
public class RedirectToSDListActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

//		String redirectURL = ParamUtil.getString(actionRequest, StationXWebKeys.REDIRECT);
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String dataTypeId = ParamUtil.getString(actionRequest, StationXWebKeys.DATATYPE_ID);
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL);
		
		Map<String, String[]> paramMap = new HashMap<>();
		paramMap.put( StationXWebKeys.DATATYPE_ID, new String[] { dataTypeId } );
		paramMap.put( StationXWebKeys.MVC_RENDER_COMMAND_NAME, 
									  new String[] { IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST} );
		paramMap.put( StationXWebKeys.BACK_URL, new String[] { backURL } );

		String redirectURL = SXPortletURLUtil.createURL(
				StationXPropertyKeys.STRUCTURED_DATA_LIST_PAGE_FRIENDLY_URL,
				false,
				actionRequest, 
				themeDisplay,
				IcecapWebPortletKeys.STRUCTURED_DATA,
				paramMap,
				PortletMode.VIEW,
				WindowState.NORMAL);
		
		actionResponse.sendRedirect(redirectURL.toString());
	}

}
