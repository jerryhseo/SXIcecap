package com.sx.icecap.web.taglib.clay.sss;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseVerticalCard;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sx.icecap.model.Term;

import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class TermVerticalCard extends BaseVerticalCard {

	private Term _term;
	private String _termViewURL;
	private Locale _locale;
	private List<DropdownItem> _actionItems;

	public TermVerticalCard(
			Term term, 
			RenderRequest renderRequest,
			RenderResponse renderResponse,
			RowChecker rowChecker,
			String termViewURL,
			List<DropdownItem> actionItems) {

			super(term, renderRequest, rowChecker);

			_term = term;
			_locale = renderRequest.getLocale();
			_termViewURL = termViewURL;
			_actionItems = actionItems;
	}

	@Override
	public List<DropdownItem> getActionDropdownItems() {
		return _actionItems;
	}

	@Override
	public String getDefaultEventHandler() {
		System.out.println("TermVerticalCard.getDefaultEventHandler(): ");
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
		System.out.println("TermVerticalCard.getHref() called.....");
		
		return _termViewURL;
	}

	@Override
	public String getIcon() {
		System.out.println("TermVerticalCard.getIcon() called.....");
		return "page-template";
	}

	@Override
	public String getImageSrc() {
		System.out.println("TermVerticalCard.getImageSrc() called.....");
		return null;
	}

	@Override
	public String getSubtitle() {
		System.out.println("TermVerticalCard.getSubtitle() called.....");
		return _term.getDefinition(_locale);
	}

	@Override
	public String getTitle() {
		return HtmlUtil.escape( _term.getDisplayTitle(_locale) );
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
