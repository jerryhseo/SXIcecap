package com.sx.icecap.web.security.permission.resource.datatype;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.sx.icecap.constant.IcecapClassNames;
import com.sx.icecap.model.DataType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true
)
public class DataTypeModelPermissionHelper{
	
	@Reference(
			target = "(model.class.name="+ IcecapClassNames.DATATYPE+")",
			unbind = "-"
			)
	protected void setDataTypeModelResourcePermission(
			ModelResourcePermission<DataType> modelResourcePermission) {
		System.out.println("Model Resource Permission Injected: "+modelResourcePermission.getModelName());
		_dataTypeModelResourcePermission = modelResourcePermission;
	}
	private static ModelResourcePermission<DataType> _dataTypeModelResourcePermission;
	
	public static boolean contains(
			PermissionChecker permissionChecker, 
			DataType dataType,
			String actionId) throws PortalException{

		return _dataTypeModelResourcePermission.contains(
				permissionChecker, 
				dataType, 
				actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, 
			long dataTypeId, 
			String actionId) throws PortalException{
		
		return _dataTypeModelResourcePermission.contains(
				permissionChecker, 
				dataTypeId, 
				actionId);
	}

}
