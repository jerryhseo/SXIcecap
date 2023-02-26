package com.sx.icecap.security.permission.resource.sd;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component (
		immediate=true
)
public class StructuredDataModelResourcePermissionRegistrar {

	@Reference
	private StructuredDataLocalService _structuredDataLocalService;

	@Reference(
			target = "(resource.name=" + IcecapConstants.STRUCTURED_DATA_RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;
	
	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;

	@Reference
	private GroupLocalService _groupLocalService;

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", StructuredData.class.getName());
		
		_serviceRegistration = bundleContext.registerService(
				ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(
						StructuredData.class,
						StructuredData::getStructuredDataId,
						_structuredDataLocalService::fetchStructuredData,
						_portletResourcePermission,
						(modelResourcePermission, consumer) -> {
							consumer.accept(
									new StagedModelPermissionLogic<>(
											_stagingPermission, 
											IcecapWebPortletKeys.STRUCTURED_DATA,
											StructuredData::getStructuredDataId)
							);
							consumer.accept(
									new WorkflowedModelPermissionLogic<>(
											_workflowPermission, 
											modelResourcePermission,
											_groupLocalService, 
											StructuredData::getPrimaryKey)
							);
						}
				),
				properties);
	}
	
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
}
