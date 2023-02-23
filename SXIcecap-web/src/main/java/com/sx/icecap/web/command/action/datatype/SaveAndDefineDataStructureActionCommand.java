package com.sx.icecap.web.command.action.datatype;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapDataTypeMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
				"mvc.command.name=" + IcecapDataTypeMVCCommands.ACTION_DATATYPE_CREATE_AND_DEFINE_STRUCTURE,
				"mvc.command.name=" + IcecapDataTypeMVCCommands.ACTION_DATATYPE_UPDATE_AND_DEFINE_STRUCTURE
		},
		service = MVCActionCommand.class
)
public class SaveAndDefineDataStructureActionCommand extends BaseMVCActionCommand {
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		
		String dataTypeName = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_VERSION);
		String extension = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.EXTENSION);
		Map<Locale, String> displayNameMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.DISPLAY_NAME);
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.DESCRIPTION);
		Map<Locale, String> tooltipMap = LocalizationUtil.getLocalizationMap(actionRequest, IcecapDataTypeAttributes.TOOLTIP);
		int status = ParamUtil.getInteger(actionRequest, IcecapDataTypeAttributes.STATUS, WorkflowConstants.STATUS_DRAFT);
		
		DataType savedDataType = null;
		ServiceContext sc = ServiceContextFactory.getInstance(DataType.class.getName(), actionRequest);
		if( dataTypeId == 0 ) {
			savedDataType = _dataTypeLocalService.addDataType (
					dataTypeName, 
					dataTypeVersion,
					extension,
					displayNameMap, 
					descriptionMap, 
					tooltipMap,
					status, 
					sc );
		}
		else {
			savedDataType = _dataTypeLocalService.updateDataType(
					dataTypeId, 
					dataTypeName, 
					dataTypeVersion, 
					extension, 
					displayNameMap, 
					descriptionMap, 
					tooltipMap, 
					status, 
					sc);
		}
		
		String renderCommand = IcecapDataTypeMVCCommands.RENDER_DATATYPE_LIST;
		if( IcecapConstants.CMD_REDIRECT_TO_DEFINE_STRUCTURE.equals(cmd) ) {
			renderCommand = IcecapDataTypeMVCCommands.RENDER_DEFINE_DATA_STRUCTURE;
		}
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		renderURL.setParameter(IcecapDataTypeAttributes.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand);
		
		System.out.println("Render URL: "+renderURL.toString());
		
		actionResponse.sendRedirect(renderURL.toString());
		
	}

}
