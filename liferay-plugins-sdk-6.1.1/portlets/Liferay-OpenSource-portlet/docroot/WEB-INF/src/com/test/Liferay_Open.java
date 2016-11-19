package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
/**
/**
 * Portlet implementation class SendPortlet
 */
public class Liferay_Open extends MVCPortlet {
	static Category cata= new Category();
	  //HttpClientDemo http=new HttpClientDemo();
	public void liferayactionofUrl(ActionRequest aReq, ActionResponse aResp) throws Exception{
        cata.setName(ParamUtil.getString(aReq,"name"));
        cata.setDescription(ParamUtil.getString(aReq,"description"));
        new HttpClientDemo();
        System.out.println("tu view"+ cata.getDescription());
        aResp.setRenderParameter("name", cata.getDescription());
	    aResp.setRenderParameter("description", cata.getName());
	    aResp.setRenderParameter("id", String.valueOf(HttpClientDemo.cate.length));
	    for (int i=0;i<HttpClientDemo.cate.length;i++){
	    aResp.setRenderParameter("categoryId"+i,HttpClientDemo.cate[i].getCategoryId()+"");	
	    aResp.setRenderParameter("name"+i, HttpClientDemo.cate[i].getName());
	    aResp.setRenderParameter("description"+i, HttpClientDemo.cate[i].getDescription());
	    }
	   
	}
}
