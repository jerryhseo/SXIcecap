package com.sx.icecap.web.taglib.clay.sd;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseVerticalCard;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.model.StructuredData;

import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class StructuredDataVerticalCard extends BaseVerticalCard {

	private StructuredData _structuredData;
	private String _structuredDataViewURL;
	private Locale _locale;
	private List<DropdownItem> _actionItems;

	public StructuredDataVerticalCard(
			StructuredData structuredData, 
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			RowChecker rowChecker,
			String structuredDataViewURL,
			List<DropdownItem> actionItems) {

			super(structuredData, renderRequest, rowChecker);

			_structuredData = structuredData;
			_locale = renderRequest.getLocale();
			_structuredDataViewURL = structuredDataViewURL;
			_actionItems = actionItems;
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return _actionItems;
	}

	@Override
	public String getDefaultEventHandler() {
		System.out.println("StructuredDataVerticalCard.getDefaultEventHandler(): ");
		if( Validator.isNull(super.getDefaultEventHandler())) {
			System.out.println("Default Event Handler is null.");
			return null;
		}
		else {
			System.out.println("Default Event Handler: "+super.getDefaultEventHandler());
		}
		return super.getDefaultEventHandler();
	}

	@Override
	public String getHref() {
		System.out.println("StructuredDataVerticalCard.getHref() called.....");
		
		return _structuredDataViewURL;
	}

	@Override
	public String getIcon() {
		System.out.println("StructuredDataVerticalCard.getIcon() called.....");
		return "page-template";
	}

	@Override
	public String getImageSrc() {
		System.out.println("StructuredDataVerticalCard.getImageSrc() called.....");
		return null;
	}

	@Override
	public String getSubtitle() {
		System.out.println("StructuredDataVerticalCard.getSubtitle() called.....");
		return _structuredData.getDataTypeDisplayName(_locale);
	}

	@Override
	public String getTitle() {
		return HtmlUtil.escape( _structuredData.getDataSetDisplayName(_locale));
	}
	
	@Override
	public String getAspectRatioCssClasses() {
		return "aspect-ratio-item-center-middle " + "aspect-ratio-item-vertical-fluid";
	}

//	@Override
//	public String getElementClasses() {
//		return "col-md-2 col-sm-4 col-xs-6";
//	}
}
