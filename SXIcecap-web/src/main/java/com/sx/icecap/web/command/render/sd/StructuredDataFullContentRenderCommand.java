package com.sx.icecap.web.command.render.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.DataTypeStructure;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;
import com.sx.icecap.web.display.context.sd.StructuredDataManagementToolbarDisplayContext;
import com.sx.icecap.web.display.context.sd.StructuredDataSearchContainerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_FULL_CONTENT
	    },
	    service = MVCRenderCommand.class
	)
public class StructuredDataFullContentRenderCommand implements MVCRenderCommand {
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		Debug.printHeader("StructuredDataListRenderCommand.render");
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID );
		long structuredDataId = ParamUtil.getLong(renderRequest, IcecapWebKeys.STRUCTURED_DATA_ID, 0);
		
		System.out.println("datatype id: "+dataTypeId);
		String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL );
		System.out.println("backURL: "+backURL);
		
		try {
			DataType dataType = _dataTypeLocalService.getDataType(dataTypeId);
			String structuredData = _dataTypeLocalService.getStructuredData(structuredDataId);
			renderRequest.setAttribute(IcecapWebKeys.DATATYPE, dataType);
			renderRequest.setAttribute(IcecapWebKeys.STRUCTURED_DATA, structuredData);
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new PortletException( e.getMessage() );
		}
		
		return IcecapJsps.STRUCTURED_DATA_FULL_CONTENT_VIEW;
	}
}
