package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SendPortlet
 */
public class SendPortlet extends MVCPortlet {
	public void sendAction(ActionRequest aReq, ActionResponse aResp){

    
	    aReq.setAttribute("name","Test");

	    aResp.setRenderParameter("name", "khong biet cung dc day chu");
	    System.out.println("123");
	}
}
