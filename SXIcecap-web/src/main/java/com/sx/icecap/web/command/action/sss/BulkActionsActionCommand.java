package com.sx.icecap.web.command.action.sss;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sx.constant.StationXWebKeys;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapActionKeys;
import com.sx.icecap.constant.IcecapSSSMVCCommands;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.service.TermLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN,
				"mvc.command.name=" + IcecapSSSMVCCommands.ACTION_ADMIN_BULK_ACTIONS
		},
		service = MVCActionCommand.class
)
public class BulkActionsActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Debug.printHeader("BulkActionsActionCommand");
		
		long[] rowIds = ParamUtil.getLongValues(actionRequest, StationXWebKeys.ROW_IDS);
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String redirect = ParamUtil.getString(actionRequest, StationXWebKeys.REDIRECT);
		
		if( rowIds != null ) {
			System.out.println("rowIds count: (" + rowIds.length+")" );
			for( int i=0; i<rowIds.length; i++) {
				System.out.println("["+i+"] "+rowIds[i] );
			}
		}
		else {
			System.out.println( " rowIds is null.");
		}
		
		System.out.println("cmd: "+ cmd);

		if( cmd.equals(IcecapActionKeys.DELETE_TERMS) ) {
			_termLocalService.removeTerms(rowIds);
		}
		
//		actionResponse.sendRedirect(redirect);
		
		Debug.printFooter("BulkActionsActionCommand");
	}

	@Reference
	private TermLocalService _termLocalService;
}
