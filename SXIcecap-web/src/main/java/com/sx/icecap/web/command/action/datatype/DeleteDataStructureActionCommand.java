package com.sx.icecap.web.command.action.datatype;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
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
				"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_DATA_STRUCTURE_DELETE
		},
		service = MVCActionCommand.class
)
public class DeleteDataStructureActionCommand implements MVCActionCommand {
	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		
		_dataTypeLocalService.removeDataTypeStructure(dataTypeId);
		
		return false;
	}

}
