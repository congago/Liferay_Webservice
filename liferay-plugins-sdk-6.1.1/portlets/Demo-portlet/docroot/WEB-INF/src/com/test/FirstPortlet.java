package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.bridges.mvc.MVCPortlet;
/**
 * Portlet implementation class FirstPortlet
 */
public class FirstPortlet extends MVCPortlet {
	public void actionofUrl(ActionRequest request,ActionResponse response)
	{

	long id =ParamUtil.getLong(request,"id");
	String ename=ParamUtil.getString(request,"name");
	long phoneno =ParamUtil.getLong(request,"phone");
	System.out.println(id);
	System.out.println(ename);
	System.out.println(phoneno);
	//sendAction(request, response);
	try {
	//Table1LocalServiceUtil.add(id,ename, phoneno);
	} catch (SystemException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	
}
