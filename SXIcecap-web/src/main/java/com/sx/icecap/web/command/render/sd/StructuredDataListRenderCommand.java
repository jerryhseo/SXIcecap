package com.sx.icecap.web.command.render.sd;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.cache.thread.local.Lifecycle;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchResult;
import com.liferay.portal.kernel.search.SearchResultUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.TrashHelper;
import com.sx.icecap.constant.IcecapMVCCommands;
import com.sx.icecap.constant.IcecapSDSearchFields;
import com.sx.icecap.constant.IcecapConstants;
import com.sx.icecap.constant.IcecapJsps;
import com.sx.constant.StationXConstants;
import com.sx.constant.StationXWebKeys;
import com.sx.icecap.constant.IcecapWebPortletKeys;
import com.sx.icecap.model.DataType;
import com.sx.icecap.model.StructuredData;
import com.sx.icecap.service.DataTypeLocalService;
import com.sx.icecap.service.StructuredDataLocalService;
import com.sx.icecap.web.display.context.sd.StructuredDataManagementToolbarDisplayContext;
import com.sx.icecap.web.display.context.sd.StructuredDataSearchContainerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.portlet.MimeResponse.Copy;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + IcecapWebPortletKeys.STRUCTURED_DATA,
	        "mvc.command.name="+IcecapMVCCommands.RENDER_STRUCTURED_DATA_LIST
	    },
	    service = MVCRenderCommand.class
	)
public class StructuredDataListRenderCommand implements MVCRenderCommand {
	
	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		  this._portal = portal;
	}
	protected Portal _portal;
	
	@Reference(unbind = "-")
	protected void setTrashHelper(TrashHelper trashHelper) {
	  _trashHelper = trashHelper;
	}
	protected TrashHelper _trashHelper;
	
	@Reference
	private StructuredDataLocalService _structuredDataLocalService;

	@Reference
	private DataTypeLocalService _dataTypeLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		System.out.println("StructuredDataListRenderCommand.render()");
		
		long dataTypeId = ParamUtil.getLong(renderRequest, StationXWebKeys.DATATYPE_ID );
		System.out.println("datatype id: "+dataTypeId);
		String backURL = ParamUtil.getString(renderRequest, StationXWebKeys.BACK_URL );
		System.out.println("backURL: "+backURL);
		
		DataType dataType = null; 
		
		try {
			dataType = _dataTypeLocalService.getDataType(dataTypeId);
		}
		catch( PortalException pe) {
			throw new PortletException(pe.getMessage());
		}
		
		StructuredDataSearchContainerProvider sdSearchContainerProvider= new StructuredDataSearchContainerProvider(
							dataType,
							renderRequest,
							renderResponse,
							IcecapConstants.STRUCTURED_DATA_SEARCH_CONTAINER_ID,
							_structuredDataLocalService	);
		
		StructuredDataManagementToolbarDisplayContext structuredDataManagementToolbarDisplayContext = null;
		try {
			structuredDataManagementToolbarDisplayContext = new StructuredDataManagementToolbarDisplayContext(
					PortalUtil.getLiferayPortletRequest(renderRequest),
					PortalUtil.getLiferayPortletResponse(renderResponse),
					PortalUtil.getHttpServletRequest(renderRequest),
					sdSearchContainerProvider._createSearchContainer(),
					_trashHelper);
		} catch (PortalException e) {
			e.printStackTrace();
			throw new PortletException(e.getMessage());
		}
		
		renderRequest.setAttribute(
				StationXWebKeys.MANAGEMENT_TOOLBAR_DISPLAY_CONTEXT, 
				structuredDataManagementToolbarDisplayContext );
		renderRequest.setAttribute(
				StationXWebKeys.DATATYPE, 
				dataType );
		
		return IcecapJsps.STRUCTURED_DATA_LIST_VIEW;
	}
}
