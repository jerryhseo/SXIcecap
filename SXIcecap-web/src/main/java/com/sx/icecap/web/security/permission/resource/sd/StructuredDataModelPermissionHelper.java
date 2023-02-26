package com.sx.icecap.web.security.permission.resource.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.sx.icecap.constant.IcecapClassNames;
import com.sx.icecap.model.StructuredData;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class StructuredDataModelPermissionHelper{
	
	@Reference(
			target = "(model.class.name="+ IcecapClassNames.STRUCTURED_DATA+")",
			unbind = "-"
			)
	protected void setStructuredDataModelResourcePermission(
			ModelResourcePermission<StructuredData> modelResourcePermission) {
		System.out.println("Model Resource Permission Injected: "+modelResourcePermission.getModelName());
		_structuredDataModelResourcePermission = modelResourcePermission;
	}
	private static ModelResourcePermission<StructuredData> _structuredDataModelResourcePermission;
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			StructuredData structuredData,
			String actionId) throws PortalException{

		return _structuredDataModelResourcePermission.contains(
				permissionChecker, 
				structuredData, 
				actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, 
			long structuredDataId, 
			String actionId) throws PortalException{
		
		return _structuredDataModelResourcePermission.contains(
				permissionChecker, 
				structuredDataId, 
				actionId);
	}

}
