package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ClientDataRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
/**
/**
 * Portlet implementation class SendPortlet
 */
public class Liferay_Open extends MVCPortlet {
	static Category cata= new Category();
	static boolean isStatus=true;
	  //HttpClientDemo http=new HttpClientDemo();
	public void liferayactionofUrl(ActionRequest aReq, ActionResponse aResp) throws Exception{
		aReq.setCharacterEncoding("UTF-8");
		if(ParamUtil.getString(aReq,"name").equals("")){
			aResp.setRenderParameter("name", "Enter your username !");
		}
		else {
        cata.setName(ParamUtil.getString(aReq,"name"));
        cata.setDescription(ParamUtil.getString(aReq,"description"));
        HttpClientDemo client = new HttpClientDemo();
        client.sendPost();
        if(isStatus==true){
        client.sendGet();
      
        System.out.println("tu view :"+ cata.getDescription());
        aResp.setRenderParameter("name", cata.getName());
	    aResp.setRenderParameter("description", cata.getDescription());
	    aResp.setRenderParameter("id", String.valueOf(HttpClientDemo.cate.length));
	    for (int i=0;i<HttpClientDemo.cate.length;i++){
	    aResp.setRenderParameter("categoryId"+i,HttpClientDemo.cate[i].getCategoryId()+"");	
	    aResp.setRenderParameter("name"+i, HttpClientDemo.cate[i].getName());
	    aResp.setRenderParameter("description"+i, HttpClientDemo.cate[i].getDescription());
	    }
	    }
     else{
    	 aResp.setRenderParameter("name", "Username is already exist");
	    }
		}
	}
	public void getShowCategory(ActionRequest aReq, ActionResponse aResp) throws Exception{
		aReq.setCharacterEncoding("UTF-8");
		
        HttpClientDemo client = new HttpClientDemo();
       // client.sendPost();
        client.sendGet();
       
	    aResp.setRenderParameter("id", String.valueOf(HttpClientDemo.cate.length));
	    for (int i=0;i<HttpClientDemo.cate.length;i++){
	    aResp.setRenderParameter("categoryId"+i,HttpClientDemo.cate[i].getCategoryId()+"");	
	    aResp.setRenderParameter("name"+i, HttpClientDemo.cate[i].getName());
	    aResp.setRenderParameter("description"+i, HttpClientDemo.cate[i].getDescription());
	  
	    }
	   
	}
	public Category getCategoryById(ActionRequest aReq, ActionResponse aResp) throws Exception{
		return null;
	//	Category 
//		Category category = new Category();
//		category.setCategoryId(Integer.parseInt((ParamUtil.getString(aReq,"categoryId"))));
//		HttpClientDemo client = new HttpClientDemo();
//		client.getCategoryById(category.getCategoryId());
//		aResp.setRenderParameter("name", category.getDescription());
//		aResp.setRenderParameter("description", category.getName());
//		aResp.setRenderParameter("id", String.valueOf(category.getCategoryId()));
//		aResp.setRenderParameter("editCategory", "/liferay_open/edit.jsp");
	}

}
