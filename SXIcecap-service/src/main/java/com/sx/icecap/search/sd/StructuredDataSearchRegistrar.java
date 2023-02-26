package com.sx.icecap.search.sd;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
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
		System.out.println("===== Begin StructuredDataSearchRegistrar activator() =====");
		System.out.println("_serviceRegistration: "+ Validator.isNotNull(_serviceRegistration));
		System.out.println("_modelSearchRegistrarHelper: "+ Validator.isNotNull(_modelSearchRegistrarHelper));
		System.out.println("_modelIndexWriterContributor: "+ Validator.isNotNull(_modelIndexWriterContributor));
		System.out.println("_modelSummaryContributor: "+ Validator.isNotNull(_modelSummaryContributor));
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					StructuredData.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("DataTypeSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.COMPANY_ID,
										Field.GROUP_ID,
										Field.UID,
										Field.USER_ID,
										Field.USER_NAME,
										Field.CREATE_DATE, 
										Field.MODIFIED_DATE, 
										Field.STATUS,
										IcecapSDSearchFields.DATASET_ID,
										IcecapSDSearchFields.DATATYPE_ID
										);
								
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										IcecapSDSearchFields.DATASET_TITLE,
										IcecapSDSearchFields.DATATYPE_TITLE );

								modelSearchDefinition.setModelIndexWriteContributor(
										_modelIndexWriterContributor);
								modelSearchDefinition.setModelSummaryContributor(
										_modelSummaryContributor);
								modelSearchDefinition.setSelectAllLocales(true);
					});

//			System.out.println("===== End of TermSearchRegistrar activator() =====");
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
