package com.sx.icecap.search.datatype;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
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
		System.out.println("===== Begin DataTypeSearchRegistrar activator() =====");
		System.out.println("_serviceRegistration: "+ Validator.isNotNull(_serviceRegistration));
		System.out.println("_modelSearchRegistrarHelper: "+ Validator.isNotNull(_modelSearchRegistrarHelper));
		System.out.println("_modelIndexWriterContributor: "+ Validator.isNotNull(_modelIndexWriterContributor));
		System.out.println("_modelSummaryContributor: "+ Validator.isNotNull(_modelSummaryContributor));
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					DataType.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("DataTypeSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.COMPANY_ID,
										Field.GROUP_ID, 
										Field.ENTRY_CLASS_NAME, 
										Field.UID,
										Field.ENTRY_CLASS_PK,
										Field.MODIFIED_DATE, 
										Field.ASSET_TAG_NAMES, 
										Field.SCOPE_GROUP_ID,
										Field.STATUS,
										IcecapDataTypeAttributes.DATATYPE_NAME); 
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										IcecapDataTypeAttributes.DESCRIPTION,
										IcecapDataTypeAttributes.DISPLAY_NAME,
										Field.ASSET_CATEGORY_TITLES,
										Field.TITLE, 
										Field.CONTENT);

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
			target = "(indexer.class.name=com.sx.icecap.datatype.model.DataType)"
	)
	protected ModelIndexerWriterContributor<DataType> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.datatype.model.DataType)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
