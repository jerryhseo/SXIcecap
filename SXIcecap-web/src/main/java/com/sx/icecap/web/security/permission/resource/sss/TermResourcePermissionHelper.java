package com.sx.icecap.web.security.permission.resource.sss;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.sx.icecap.constant.IcecapConstants;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class TermResourcePermissionHelper {
	
	@Reference(
			target = "(resource.name="+IcecapConstants.TERM_RESOURCE_NAME+")", 
			unbind = "-"
	)
	protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
		System.out.println("setPortletResourcePermission() to init _portletResourcePermission....");
		_portletResourcePermission = portletResourcePermission;
	}
	private static PortletResourcePermission _portletResourcePermission;
	
	public static void check(
			PermissionChecker permissionChecker, long classPK, String actionId) throws PrincipalException {
		_portletResourcePermission.check(permissionChecker, classPK, actionId);
	}
	
	public static void check(
			PermissionChecker permissionChecker, Group group, String actionId)
		throws PortalException {
		_portletResourcePermission.check(permissionChecker, group, actionId);
	}
	
	public static boolean contains(
			PermissionChecker permissionChecker, Group group, String actionId) {

			return _portletResourcePermission.contains(
				permissionChecker, group, actionId);
	}
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			long groupId, 
			String actionId){
		
		return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
	}

}
