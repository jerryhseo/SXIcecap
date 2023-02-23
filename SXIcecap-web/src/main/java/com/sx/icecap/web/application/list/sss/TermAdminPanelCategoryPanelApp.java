package com.sx.icecap.web.application.list.sss;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.panel.category.constants.StationXPanelCategoryKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + StationXPanelCategoryKeys.ICECAP_SSS
	},
	service = PanelApp.class
)
public class TermAdminPanelCategoryPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return IcecapWebPortletKeys.TERM_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + IcecapWebPortletKeys.TERM_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}