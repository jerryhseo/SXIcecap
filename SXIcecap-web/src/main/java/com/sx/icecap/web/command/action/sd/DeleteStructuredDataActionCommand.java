package com.sx.icecap.web.command.action.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_STRUCTURED_DATA_DELETE
		},
		service = MVCActionCommand.class
)
public class DeleteStructuredDataActionCommand implements MVCActionCommand {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long structuredDataId = ParamUtil.getLong(actionRequest, StationXWebKeys.STRUCTURED_DATA_ID, 0);
		
		try {
			_dataTypeLocalService.removeStructuredData(structuredDataId);
		} catch (PortalException e) {
			throw new PortletException(e.getMessage());
		}
		
		return false;
	}

}
