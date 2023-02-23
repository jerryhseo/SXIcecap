package com.sx.icecap.search.sss;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.sx.debug.Debug;
import com.sx.icecap.constant.IcecapSSSTermAttributes;
import com.sx.icecap.model.Term;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class TermSearchRegistrar {
	@Activate
	protected void activate(BundleContext bundleContext) {
		Debug.printHeader("TermSearchRegistrar activator()");
		System.out.println("_serviceRegistration: "+ Validator.isNotNull(_serviceRegistration));
		System.out.println("_modelSearchRegistrarHelper: "+ Validator.isNotNull(_modelSearchRegistrarHelper));
		System.out.println("_modelIndexWriterContributor: "+ Validator.isNotNull(_modelIndexWriterContributor));
		System.out.println("_modelSummaryContributor: "+ Validator.isNotNull(_modelSummaryContributor));
		
			_serviceRegistration = _modelSearchRegistrarHelper.register(
					Term.class, 
					bundleContext, 
					modelSearchDefinition -> {
//								System.out.println("TermSearchRegister activator: modelSearchDefinition");
								modelSearchDefinition.setDefaultSelectedFieldNames(
										Field.COMPANY_ID,
										Field.GROUP_ID, 
										Field.ENTRY_CLASS_NAME, 
										Field.UID,
										Field.ENTRY_CLASS_PK,
										Field.MODIFIED_DATE, 
										Field.ASSET_TAG_NAMES, 
										Field.ASSET_CATEGORY_TITLES,
										Field.SCOPE_GROUP_ID,
										Field.TITLE,
										IcecapSSSTermAttributes.TERM_NAME, 
										IcecapSSSTermAttributes.DEFINITION,
										IcecapSSSTermAttributes.TOOLTIP, 
										IcecapSSSTermAttributes.SYNONYMS,
										IcecapSSSTermAttributes.DISPLAY_NAME, 
										IcecapSSSTermAttributes.TERM_TYPE,
										IcecapSSSTermAttributes.STANDARD,
										IcecapSSSTermAttributes.STATUS);
								modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
										Field.TITLE, Field.CONTENT);

								modelSearchDefinition.setModelIndexWriteContributor(
										_modelIndexWriterContributor);
								modelSearchDefinition.setModelSummaryContributor(
										_modelSummaryContributor);
								modelSearchDefinition.setSelectAllLocales(true);
					});

			Debug.printFooter("TermSearchRegistrar activator()");
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference(
			target = "(indexer.class.name=com.sx.icecap.sss.model.Term)"
	)
	protected ModelIndexerWriterContributor<Term> _modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(
			target = "(indexer.class.name=com.sx.icecap.sss.model.Term)"
	)
	protected ModelSummaryContributor _modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;
}
