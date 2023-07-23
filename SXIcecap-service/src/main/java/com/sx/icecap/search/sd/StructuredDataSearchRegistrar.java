package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.model.StructuredData;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class StructuredDataSearchRegistrar {
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		Debug.printHeader("Begin StructuredDataSearchRegistrar activator");
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					StructuredData.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("DataTypeSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.USER_ID,
										IcecapSDSearchFields.DATASET_ID,
										IcecapSDSearchFields.DATATYPE_ID
								);
								
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										IcecapSDSearchFields.DATASET_NAME,
										IcecapSDSearchFields.DATATYPE_NAME );

								modelSearchDefinition.setModelIndexWriteContributor(
										_modelIndexWriterContributor);
								modelSearchDefinition.setModelSummaryContributor(
										_modelSummaryContributor);
								modelSearchDefinition.setSelectAllLocales(true);
								modelSearchDefinition.setSelectAllLocales(true);
					});

		Debug.printFooter("End of TermSearchRegistrar activator");
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.StructuredData)"
	)
	protected ModelIndexerWriterContributor<StructuredData> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.model.StructuredData)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
