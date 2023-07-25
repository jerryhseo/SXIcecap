package com.sx.icecap.search.datatype;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapDataTypeAttributes;
import com.sx.icecap.model.DataType;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DataTypeSearchRegistrar {
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		Debug.printHeader("DataTypeSearchRegistrar activator");
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					DataType.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("DataTypeSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.COMPANY_ID,
										Field.GROUP_ID, 
										Field.ENTRY_CLASS_NAME, 
										Field.ENTRY_CLASS_PK,
										Field.UID,
										Field.SCOPE_GROUP_ID,
										IcecapDataTypeAttributes.DATATYPE_NAME,
										"terms"); 
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										IcecapDataTypeAttributes.DESCRIPTION,
										IcecapDataTypeAttributes.DISPLAY_NAME);

								modelSearchDefinition.setModelIndexWriteContributor(
										_modelIndexWriterContributor);
								modelSearchDefinition.setModelSummaryContributor(
										_modelSummaryContributor);
								modelSearchDefinition.setSelectAllLocales(true);
					});

		Debug.printFooter("TermSearchRegistrar");
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataType)"
	)
	protected ModelIndexerWriterContributor<DataType> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.DataType)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
