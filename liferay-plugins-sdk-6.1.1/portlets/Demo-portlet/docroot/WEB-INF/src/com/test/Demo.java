package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Demo
 */
public class Demo extends MVCPortlet {

	public void display(ActionRequest aReq, ActionResponse aResp){


	    aReq.setAttribute("name","Test");

	    aResp.setRenderParameter("jspPage", "receive/view.jsp");
	    System.out.println("123");
	}

}
