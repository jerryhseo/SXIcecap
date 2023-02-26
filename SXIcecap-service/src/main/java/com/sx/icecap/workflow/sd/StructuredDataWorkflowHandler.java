package com.sx.icecap.workflow.sd;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.StructuredDataLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true, 
		service = WorkflowHandler.class
)
public class StructuredDataWorkflowHandler extends BaseWorkflowHandler<StructuredData> {

	@Override
	public String getClassName() {
		return StructuredData.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public StructuredData updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		long userId = GetterUtil.getLong(
				(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil.getLong(
				(String)workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext)workflowContext.get("serviceContext");

		return _structuredDataLocalService.updateStatus(userId, resourcePrimKey, status, serviceContext);
	}
	
	@Reference(unbind = "-")
	protected void setResourceActions(ResourceActions resourceActions) {
		_resourceActions = resourceActions;
	}
	private ResourceActions _resourceActions;
	
	@Reference(unbind = "-")
	protected void setStructuredDataLocalService(StructuredDataLocalService structuredDataLocalService) {
		_structuredDataLocalService = structuredDataLocalService;
	}
	private StructuredDataLocalService _structuredDataLocalService;

}
