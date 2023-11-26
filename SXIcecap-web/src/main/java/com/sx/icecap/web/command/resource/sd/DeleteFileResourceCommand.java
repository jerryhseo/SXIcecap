package com.sx.icecap.web.command.resource.sd;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.constant.IcecapSSSTermTypes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.model.Term;
import com.sx.icecap.service.TermLocalService;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RESOURCE_STRUCTURED_DATA_DELETE_FILE
	    },
	    service = MVCResourceCommand.class
)
public class DeleteFileResourceCommand extends BaseMVCResourceCommand {
	@Reference
	DLAppService _dlAppService;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long fileId = ParamUtil.getLong(resourceRequest, "fileId");
		
		
		PrintWriter pw = resourceResponse.getWriter();
		try {
			_dlAppService.deleteFileEntry(fileId);
			pw.write("file deleted successfully....");
		} catch( PortalException e ) {
			pw.write("Failed to delete file:" + fileId);
		} finally {
			pw.flush();
			pw.close();
		}
		
	}
}
