package com.sx.icecap.web.command.render.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;
import com.sx.icecap.web.display.context.sd.StructuredDataManagementToolbarDisplayContext;
import com.sx.icecap.web.display.context.sd.StructuredDataSearchContainerProvider;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_ROOT,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST
	    },
	    service = MVCRenderCommand.class
	)
public class StructuredDataListRenderCommand implements MVCRenderCommand {
	
	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		  this._portal = portal;
	}
	protected Portal _portal;
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
	
	@Reference
	private StructuredDataLocalService _structuredDataLocalService;

	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("StructuredDataListRenderCommand.render()");
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID );
		System.out.println("datatype id: "+dataTypeId);
		String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL );
		System.out.println("backURL: "+backURL);
		
		DataType dataType = null; 
		
		try {
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
		}
		catch( PortalException pe) {
			throw new PortletException(pe.getMessage());
		}
		
		StructuredDataSearchContainerProvider sdSearchContainerProvider= new StructuredDataSearchContainerProvider(
							dataType,
							renderRequest,
							renderResponse,
							IcecapConstants.STRUCTURED_DATA_SEARCH_CONTAINER_ID,
							_structuredDataLocalService	);
		
		StructuredDataManagementToolbarDisplayContext structuredDataManagementToolbarDisplayContext = null;
		try {
			structuredDataManagementToolbarDisplayContext = new StructuredDataManagementToolbarDisplayContext(
					PortalUtil.getLiferayPortletRequest(renderRequest),
					PortalUtil.getLiferayPortletResponse(renderResponse),
					PortalUtil.getHttpServletRequest(renderRequest),
					sdSearchContainerProvider._createSearchContainer(),
					_trashHelper);
		} catch (PortalException e) {
			e.printStackTrace();
			throw new PortletException(e.getMessage());
		}
		
		renderRequest.setAttribute(
				StationXWebKeys.MANAGEMENT_TOOLBAR_DISPLAY_CONTEXT, 
				structuredDataManagementToolbarDisplayContext );
		renderRequest.setAttribute(
				StationXWebKeys.DATATYPE, 
				dataType );
		
		return IcecapJsps.STRUCTURED_DATA_LIST_VIEW;
	}
}
