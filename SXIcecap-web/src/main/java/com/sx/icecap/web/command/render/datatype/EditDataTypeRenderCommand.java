package com.sx.icecap.web.command.render.datatype;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_DATATYPE_EDIT
	    },
	    service = MVCRenderCommand.class
)
public class EditDataTypeRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID, 0);
		
		DataType dataType = null;
		if( dataTypeId > 0 ) {
			try {
				dataType = _dataTypeLocalService.getDataType(dataTypeId);
			} catch (Exception e) {
				throw new PortletException( "Cannot find data type: " + dataTypeId );
			}
			
			renderRequest.setAttribute(StationXWebKeys.DATATYPE, dataType);
		}
		
		return IcecapConstants.JSP_DATATYPE_EDIT;
	}

	
	@Reference
	DataTypeLocalService _dataTypeLocalService;
}
