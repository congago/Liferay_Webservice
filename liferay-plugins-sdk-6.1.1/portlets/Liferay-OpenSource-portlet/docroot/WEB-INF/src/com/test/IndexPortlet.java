package com.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

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
/**
 * Portlet implementation class SendPortlet
 */
public class IndexPortlet extends MVCPortlet {
	public void actionofUrl(ActionRequest aReq, ActionResponse aResp){

       // String b=ParamUtil.getString(aReq,"demo");
      //  String c=aReq.getParameter("demo");
        String Cacular =ParamUtil.getString(aReq,"id");
    	////String ename=ParamUtil.getString(aReq,"name");
    	//String phoneno =ParamUtil.getString(aReq,"phone");
    	//String demo=ParamUtil.getString(aReq,"demo");
       // System.out.println(b);
      //  System.out.println(ename);
	  //  aReq.setAttribute("demo","Test");
	   // aResp.setRenderParameter("id", ename.toString());
	  //  aResp.setRenderParameter("name", phoneno);
	  //  aResp.setRenderParameter("phone", demo.toString());
        float gtri=new Bieuthuc(Cacular).giatriBieuthuc();
        aResp.setRenderParameter("id", Cacular);
	    aResp.setRenderParameter("result", String.valueOf(gtri));
	}
}
class Bieuthuc {
	private String bieuthuc;
	public Bieuthuc(String bt) {
		this.bieuthuc = bt;
	}
	public int thuTuToanTu(char c){
		if(c == '*' || c== '/') return 2;
		if(c== '+' || c=='-') return 1;
		return 0;
	}
	public boolean isToanTu(char c){
		char tt[] = {'+', '-', '*', '/', '(', ')'}; 
		Arrays.sort(tt);
		if(Arrays.binarySearch(tt, c)>-1) return true;
		return false;
	}
	public String chuanHoaBieuThuc(String bt){
		String btRutgon = bt.replaceAll("\\s+", " ");
		String btChuan = "";
		for(int i=0; i<btRutgon.length(); i++ ){
			if(!isToanTu(btRutgon.charAt(i))) btChuan += btRutgon.charAt(i);
			else btChuan += " " + btRutgon.charAt(i) + " ";
		}
		btChuan = btChuan.trim();
		btChuan = btChuan.replaceAll("\\s+", " ");
		return btChuan;
	}
	public String chuyenHauTo(String st){
		String arrtt[] = chuanHoaBieuThuc(st).split(" ");
		String btht = "";
		Stack<String> stack = new Stack<String>();
		for(int i=0; i<arrtt.length; i++){
			char c = arrtt[i].charAt(0);
			if(!isToanTu(c)) btht+=" " + arrtt[i];
			else {
				if(c == '(') stack.push(arrtt[i]);
				else {
					if(c == ')') {
						char c1;
						do{
							c1 = stack.peek().charAt(0);
							if(c1 != '(') btht += " " + stack.peek();
							stack.pop();
						}while (c1 != '(');
					}
					else{
						while(!stack.isEmpty() && thuTuToanTu(stack.peek().charAt(0)) >= thuTuToanTu(c) ){
							btht += " " + stack.peek();
							stack.pop();
						}
						stack.push(arrtt[i]);
					   }
				   }
			}
		}
		while(!stack.isEmpty()) {
			btht+= " " + stack.peek();
			stack.pop();
		}
		
		return btht.trim();
	}
	public float tinhbtHauTo(String bt){
		String arrht[] = bt.split(" ");
		Stack<String> stack = new Stack<>();
		for(int i=0; i<arrht.length; i++){
			char c = arrht[i].charAt(0);
			if(!isToanTu(c)) stack.push(arrht[i]);
			else {
					float kq = 0f;
					float a = Float.parseFloat(stack.pop());
					float b = Float.parseFloat(stack.pop());
					switch(c){
					case '+': kq = b+a; break;
					case '-': kq = b-a; break;
					case '*': kq = b*a; break;
					case '/': kq = b/a; break;
					case '%': kq = b%a; break;
					}
					stack.push(String.valueOf(kq));
				}
			}
		return Float.parseFloat(stack.pop());
	}
	public float giatriBieuthuc(){
		return tinhbtHauTo(chuyenHauTo(bieuthuc));
	}
}

