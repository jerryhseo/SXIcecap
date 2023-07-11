package com.sx.icecap.web.command.action.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_STRUCTURED_DATA_DELETE
		},
		service = MVCActionCommand.class
)
public class DeleteStructuredDataActionCommand extends BaseMVCActionCommand  {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long structuredDataId = ParamUtil.getLong(actionRequest, StationXWebKeys.STRUCTURED_DATA_ID, 0);
		
		StructuredData structuredData = null;
		try {
			structuredData = _dataTypeLocalService.removeStructuredData(structuredDataId);
		} catch (PortalException e) {
			throw new PortletException(e.getMessage());
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(structuredData.getDataTypeId()) );
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST);
		
		actionResponse.sendRedirect(renderURL.toString());
	}

}
