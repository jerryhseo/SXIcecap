package com.sx.icecap.web.command.action.sd;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
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

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.MimeResponse.Copy;

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
	
	private static long DEFAULT_PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	@Reference
	private DLAppService _dlAppService;

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		System.out.println("SaveStructuredDataActionCommand");
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		System.out.println("cmd: " + cmd);
		
		long dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(actionRequest, IcecapWebKeys.STRUCTURED_DATA_ID,  0);
		
		String dataTypeName = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_VERSION);
		boolean hasFile = ParamUtil.getBoolean(actionRequest, StationXWebKeys.HAS_FILE, false);
		String structuredData = ParamUtil.getString(actionRequest, IcecapWebKeys.STRUCTURED_DATA, "");
		System.out.println("hasFile: " + hasFile);
		System.out.println("Structured Data:  " + structuredData);
		
		JSONObject jsonStructuredData = JSONFactoryUtil.createJSONObject(structuredData);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		/*
		Folder folder = null;
		try {
			folder =_dlAppService.getFolder(themeDisplay.getScopeGroupId(), DEFAULT_PARENT_FOLDER_ID, themeDisplay.getSiteGroupName());
			System.out.println("Folder: " + folder.getFolderId() + ", "+folder.getName());
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		
		if( Validator.isNull(folder) ) {
			System.out.println("Folder for "+themeDisplay.getSiteGroupName()+" does not exist.");
		}
		*/
		
		ServiceContext sc = ServiceContextFactory.getInstance(Folder.class.getName(), actionRequest);
		
		
		List<Folder> folders = _dlAppService.getFolders(themeDisplay.getSiteGroupId(), DEFAULT_PARENT_FOLDER_ID);
		if( Validator.isNull( folders )) {
			System.out.println("No folders");
		}
		else {
			System.out.println("Folders count: " + folders.size());
			folders.forEach(folder ->{
				System.out.println("CompanyID of the folder: " + folder.getCompanyId());
				System.out.println("RepositoryID of the folder: " + folder.getRepositoryId());
				System.out.println("GroupID of the folder: " + folder.getGroupId());
				System.out.println("ID of the folder: " + folder.getFolderId());
				System.out.println("Name of the folder: " + folder.getName());
				System.out.println("Site ID: " + themeDisplay.getScopeGroupId());
				System.out.println("User ID: " + themeDisplay.getUserId());
				try {
					System.out.println("Site Name: " + themeDisplay.getScopeGroupName());
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		
		
		
		if( hasFile ) {
			System.out.println("Need uploading file");
			String termName = ParamUtil.getString(actionRequest, "uploadParamName");
			System.out.println("Term name to be uploaded: " + termName);
			UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			System.out.println("File size to be uploaded: " + uploadRequest.getSize(termName));
			File uploadFile = uploadRequest.getFile(termName);
			System.out.println("File size to be uploaded: " + uploadFile.length());
			String srcFileName = uploadRequest.getFileName(termName);
			
			JSONObject jsonFile = JSONFactoryUtil.createJSONObject();
			jsonFile.put("id",12345);
			jsonFile.put("name", srcFileName);
			System.out.println("File name to be uploaded: " + jsonFile.toString());
			
			jsonStructuredData.put(termName, jsonFile);
			
			System.out.println(jsonStructuredData.toString(4));
		}
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(StructuredData.class.getName(), actionRequest);
		if( cmd.equalsIgnoreCase(StationXConstants.CMD_ADD) ) {
			_dataTypeLocalService.addStructuredData(0, dataTypeId, structuredData, WorkflowConstants.STATUS_APPROVED, serviceContext);
		}
		else {
			try {
				_dataTypeLocalService.updateStructuredData(structuredDataId, 0, dataTypeId, structuredData, WorkflowConstants.STATUS_APPROVED, serviceContext);
			} catch( Exception e ) {
				e.printStackTrace();
			}
		}
		
		
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		PortletURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(StationXWebKeys.BACK_URL, backURL );
		
		actionResponse.sendRedirect(renderURL.toString());
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
