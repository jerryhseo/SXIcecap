package com.sx.icecap.web.command.action.sd;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.document.library.kernel.service.DLFolderServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.RepositoryLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	private DLAppService  _dlAppService;
	
	@Reference
	private DLFileEntryLocalService  _dlFileEntryLocalService;

	private Folder _getFolder( ThemeDisplay themeDisplay, long parentFolderId ) {
		Folder folder = null;
		
		try {
			folder = _dlAppService.getFolder(themeDisplay.getScopeGroupId(), DEFAULT_PARENT_FOLDER_ID, themeDisplay.getSiteGroupName());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return folder;
	}
	
	private long _getRootDataFolderId( PortletRequest portletRequest, ThemeDisplay themeDisplay ) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		String rootDataFolderName = "Data Files";
		String description = "Folder to save uploaded files of structured data";
		
		try {
			folder = _dlAppService.getFolder(repositoryId, parentFolderId, rootDataFolderName);
		} catch (PortalException e1) {
			ServiceContext sc = null;
			try {
				sc = ServiceContextFactory.getInstance(DLFolder.class.getName(), portletRequest );
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				folder = _dlAppService.addFolder(repositoryId, parentFolderId, rootDataFolderName, description, sc);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if( Validator.isNotNull( folder )) {
			System.out.println("CompanyID of the folder: " + folder.getCompanyId());
			System.out.println("RepositoryID of the folder: " + folder.getRepositoryId());
			System.out.println("GroupID of the folder: " + folder.getGroupId());
			System.out.println("ID of the folder: " + folder.getFolderId());
			System.out.println("Name of the folder: " + folder.getName());
			System.out.println("Site ID: " + themeDisplay.getScopeGroupId());
			System.out.println("User ID: " + themeDisplay.getUserId());
		}

		return folder.getFolderId();
	}
	
	private long _getFolderId( PortletRequest portletRequest, ThemeDisplay themeDisplay, long parentFolderId, String folderName ) {
		Folder folder = null;
		long repositoryId = themeDisplay.getScopeGroupId();
		
		try {
			folder = _dlAppService.getFolder(repositoryId, parentFolderId, folderName);
		} catch (PortalException e) {
			ServiceContext sc = null;
			try {
				sc = ServiceContextFactory.getInstance(DLFolder.class.getName(), portletRequest );
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				folder = _dlAppService.addFolder(repositoryId, parentFolderId, folderName, "", sc);
			} catch (PortalException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return folder.getFolderId();
	}
	
	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Debug.printHeader("SaveStructuredDataActionCommand");
		
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		long structuredDataId = ParamUtil.getLong(actionRequest, IcecapWebKeys.STRUCTURED_DATA_ID,  0);
		
		String dataTypeName = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_NAME);
		String dataTypeVersion = ParamUtil.getString(actionRequest, IcecapDataTypeAttributes.DATATYPE_VERSION);
		boolean hasFile = ParamUtil.getBoolean(actionRequest, StationXWebKeys.HAS_FILE, false);
		String structuredData = ParamUtil.getString(actionRequest, IcecapWebKeys.STRUCTURED_DATA, "");
		
		JSONObject jsonStructuredData = JSONFactoryUtil.createJSONObject(structuredData);
		System.out.println("SD Data: " + jsonStructuredData.toString(4));
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(StructuredData.class.getName(), actionRequest);
		if( cmd.equalsIgnoreCase(StationXConstants.CMD_ADD) ) {
			StructuredData  storedData = _dataTypeLocalService.addStructuredData(0, dataTypeId, structuredData, WorkflowConstants.STATUS_DRAFT, serviceContext);
			structuredDataId = storedData.getStructuredDataId();
		}
		
		UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		long dataFileFolderId = _getRootDataFolderId(actionRequest, themeDisplay);
		long dataTypeFolderId = _getFolderId(actionRequest, themeDisplay, dataFileFolderId, dataTypeName);
		long dataTypeVersionFolderId = _getFolderId(actionRequest, themeDisplay, dataTypeFolderId, dataTypeVersion);
		
		Map<String, FileItem[]> uploadFileMap= uploadRequest.getMultipartParameterMap();

		Set<Entry<String, FileItem[]>> entrySet = uploadFileMap.entrySet();
		
		for( Entry<String, FileItem[]> fileEntry : entrySet ){
			FileItem item[] = fileEntry.getValue();
			
			String termName = fileEntry.getKey();
			JSONObject term = _dataTypeLocalService.getTermByName(dataTypeId, termName );
			
			JSONObject termData = jsonStructuredData.getJSONObject(termName);
			if( Validator.isNull(termData) ) {
				continue;
			}
			
			termData = JSONFactoryUtil.createJSONObject();
			
			System.out.println("Term Data: " + termData.toString(4));
			String termVersion = term.getString("termVersion");
			if( termVersion.isEmpty() ) {
				termVersion = "1.0.0";
			}
			
			long termFolderId = _getFolderId(actionRequest, themeDisplay, dataTypeVersionFolderId, termName);
			long termVersionFolderId = _getFolderId(actionRequest, themeDisplay, termFolderId, termVersion);
			long dataFolderId = _getFolderId(actionRequest, themeDisplay, termVersionFolderId, String.valueOf(structuredDataId) );
			
			termData.put("repositoryId", themeDisplay.getScopeGroupId() );
			termData.put("folderId", dataFolderId );
			jsonStructuredData.put( termName, termData );
			
			FileItem[] fileItems = fileEntry.getValue();
			System.out.println("File Items to Be uploaded: " + termName + ":" + termVersion + ":" + fileItems.length);
			for( FileItem fileItem : fileItems ) {
				if( fileItem.getSize() == 0 ) {
					continue;
				}
				
				String title = fileItem.getFileName();
				//JSONObject fileInfo = termData.getJSONObject( fileItem.getFileName() );
				//fileInfo.put( "parentFolderId", dataFolderId );
				
				InputStream inputStream = fileItem.getInputStream();
				String description = "";
				long repositoryId = themeDisplay.getScopeGroupId();
				String mimeType = fileItem.getContentType();
				
				System.out.println( "File size: " + fileItem.getSize() );
				try {
					ServiceContext fileServiceContext = ServiceContextFactory.getInstance( DLFileEntry.class.getName(), actionRequest );
					FileEntry addedFile = _dlAppService.addFileEntry(repositoryId, dataFolderId, title, mimeType, title, description, "", inputStream, fileItem.getSize(), fileServiceContext);
					//fileInfo.put( "fileId", addedFile.getFileEntryId() );
				} catch( PortalException e ) {
					e.printStackTrace();
				} catch( SystemException e ) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("jsonStructuredData after file upload: " + jsonStructuredData.toString(4) );
		
		try {
			_dataTypeLocalService.updateStructuredData(structuredDataId, 0, dataTypeId, jsonStructuredData.toString(), WorkflowConstants.STATUS_APPROVED, serviceContext);
		} catch( Exception e ) {
			e.printStackTrace();
		}

		
//		System.out.println(jsonStructuredData.toString(4));
		
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "");
		
		PortletURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(StationXWebKeys.BACK_URL, backURL );
		
		actionResponse.sendRedirect(renderURL.toString());
		
		Debug.printFooter("SaveStructuredDataActionCommand");
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
