package com.sx.icecap.web.taglib.clay.datatype;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseVerticalCard;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.model.DataType;

import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class DataTypeVerticalCard extends BaseVerticalCard {

	private DataType _dataType;
	private String _dataTypeViewURL;
	private Locale _locale;
	private List<DropdownItem> _actionItems;

	public DataTypeVerticalCard(
			DataType dataType, 
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			RowChecker rowChecker,
			String dataTypeViewURL,
			List<DropdownItem> actionItems) {

			super(dataType, renderRequest, rowChecker);

			_dataType = dataType;
			_locale = renderRequest.getLocale();
			_dataTypeViewURL = dataTypeViewURL;
			_actionItems = actionItems;
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return _actionItems;
	}

	@Override
	public String getDefaultEventHandler() {
		System.out.println("DataTypeVerticalCard.getDefaultEventHandler(): ");
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
		System.out.println("DataTypeVerticalCard.getHref() called.....");
		
		return _dataTypeViewURL;
	}

	@Override
	public String getIcon() {
		System.out.println("DataTypeVerticalCard.getIcon() called.....");
		return "page-template";
	}

	@Override
	public String getImageSrc() {
		System.out.println("DataTypeVerticalCard.getImageSrc() called.....");
		return null;
	}

	@Override
	public String getSubtitle() {
		System.out.println("DataTypeVerticalCard.getSubtitle() called.....");
		return _dataType.getDescription(_locale);
	}

	@Override
	public String getTitle() {
		return HtmlUtil.escape( _dataType.getDisplayName(_locale) + " v. "+ _dataType.getDataTypeVersion());
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
