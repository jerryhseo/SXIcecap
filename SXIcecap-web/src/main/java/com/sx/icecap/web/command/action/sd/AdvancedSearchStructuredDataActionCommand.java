package com.sx.icecap.web.command.action.sd;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.DataTypeLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.MimeResponse.Copy;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
				"mvc.command.name=" + IcecapMVCCommands.ACTION_STRUCTURED_DATA_ADVANCED_SEARCH
		},
		service = MVCActionCommand.class
)
public class AdvancedSearchStructuredDataActionCommand extends BaseMVCActionCommand {
	
	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String strQuery = ParamUtil.getString(actionRequest, IcecapWebKeys.STRUCTURED_DATA_QUERY, "");
		long dataTypeId = ParamUtil.getLong(actionRequest, IcecapWebKeys.DATATYPE_ID, 0);
		String backURL = ParamUtil.getString(actionRequest, StationXWebKeys.BACK_URL, "/");
		
		System.out.println("Search Query: " + strQuery );
		System.out.println("Data type ID: " + dataTypeId );
		System.out.println("backURL: " + backURL );
		
		PortletURL renderURL = actionResponse.createRedirectURL(Copy.ALL);
		
		renderURL.setParameter(StationXWebKeys.MVC_RENDER_COMMAND_NAME, IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST);
		renderURL.setParameter(StationXWebKeys.DATATYPE_ID, String.valueOf(dataTypeId) );
		renderURL.setParameter(IcecapWebKeys.STRUCTURED_DATA_QUERY, strQuery );
		renderURL.setParameter(StationXWebKeys.BACK_URL, backURL);
		
		actionResponse.sendRedirect(renderURL.toString());
	}
	
	@Reference
	private DataTypeLocalService _dataTypeLocalService;

}
