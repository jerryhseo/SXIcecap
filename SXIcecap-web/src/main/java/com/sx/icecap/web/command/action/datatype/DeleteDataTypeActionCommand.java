package com.sx.icecap.web.command.action.datatype;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.DATATYPE_MANAGEMENT,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_DATATYPE_DELETE
		},
		service = MVCActionCommand.class
)
public class DeleteDataTypeActionCommand implements MVCActionCommand {

	@Reference
	DataTypeLocalService _dataTypeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String cmd = ParamUtil.getString(actionRequest, StationXWebKeys.CMD);
		
		long dataTypeId = dataTypeId = ParamUtil.getLong(actionRequest, IcecapDataTypeAttributes.DATATYPE_ID, 0);
		
		try {
			_dataTypeLocalService.removeDataType(dataTypeId);
		} catch (Exception e) {
			throw new PortletException( e.getMessage() );
		}
		
		return false;
	}

}
