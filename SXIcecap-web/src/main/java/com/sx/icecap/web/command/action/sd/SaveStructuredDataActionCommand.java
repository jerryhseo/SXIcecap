package com.sx.icecap.web.command.action.sd;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
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
				"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_STRUCTURED_DATA_ADD,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_STRUCTURED_DATA_UPDATE
		},
		service = MVCActionCommand.class
)
public class SaveStructuredDataActionCommand extends BaseMVCActionCommand {
	
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		System.out.println("SaveStructuredDataActionCommand");
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		
		String dataTypeName = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_VERSION);
		boolean hasFile = ParamUtil.getBoolean(actionRequest, StationXWebKeys.HAS_FILE, false);
		String structuredData = ParamUtil.getString(actionRequest, IcecapWebKeys.STRUCTURED_DATA, "");
		
		System.out.println("Do file upload!!!");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DLFolder folder = null;
		try {
			folder =DLFolderServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, "");
			System.out.println("Folder: " + folder.getFolderId() + ", "+folder.getName());
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		
		if( hasFile ) {
			System.out.println("Need uploading file");
		}
		
		ServiceContext sc = ServiceContextFactory.getInstance(StructuredData.class.getName(), actionRequest);
		if( cmd.equalsIgnoreCase(StationXConstants.CMD_ADD) ) {
			_dataTypeLocalService.addStructuredData(0, dataTypeId, structuredData, WorkflowConstants.STATUS_APPROVED, sc);
		}
		else {
			_dataTypeLocalService.updateStructuredData(structuredDataId, 0, dataTypeId, structuredData, WorkflowConstants.STATUS_APPROVED, sc);
		}
		
		
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		PortletURL renderURL = PortletURLFactoryUtil.create(
				actionRequest, 
				themeDisplay.getPortletDisplay().getId(), 
				themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		
		String renderCommand = IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST; 
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, renderCommand);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		
		actionResponse.sendRedirect(renderURL.toString());
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
