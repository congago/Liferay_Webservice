package com.test;

import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class StudentMVCPortletAction
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
public class StudentMVCPortletAction extends MVCPortlet {
       public void addStudent(ActionRequest actionRequest,
                     ActionResponse actionResponse) throws IOException, PortletException {
              try{
              String firstName = ParamUtil.getString(actionRequest, "firstName");
              String lastName = ParamUtil.getString(actionRequest, "lastName");
              double examFee = ParamUtil.getDouble(actionRequest, "examFee", 00.00);
              String sex = ParamUtil.getString(actionRequest, "sex");
              String[] subjects = ParamUtil.getParameterValues(actionRequest,
                           "subjects", null);
              String acadamicYear = ParamUtil
                           .getString(actionRequest, "acadamicYear");
              String address = ParamUtil.getString(actionRequest, "address");
              // Perepare Map object to send date to JSP Page to display
              Map<String, String> studentMapObject = new HashMap<String, String>();
              studentMapObject.put("firstName", firstName);
              studentMapObject.put("lastName", lastName);
              studentMapObject.put("examFee", String.valueOf(examFee));
              studentMapObject.put("sex", sex);
              studentMapObject.put("acadamicYear", acadamicYear);
              studentMapObject.put("address", address);
              // Send Map object to JSP page we wil use setAttribute(--) method on
              // request object
              actionRequest.setAttribute("studentMapObject", studentMapObject);
              // We have multiple subjects so we will send it seperate request
              // attribute
              List<String> subjectsList = new ArrayList<String>();
              // for flexible manipulation we will convert noram array i.e subject
              // array to List
              subjectsList = ListUtil.toList(subjects);
              actionRequest.setAttribute("subjectsList", subjectsList);
              // we will display all student information in display_student.jsp so we
              // will use setRenderParameter method on response object
              // addding success message
              SessionMessages.add((HttpServletRequest) actionRequest.getPortletSession(),
                           "student-form-success");
              actionResponse.setRenderParameter("mvcPath",
                           "/html/jsps/display_student.jsp");
              }catch(Exception e){
                     SessionErrors.add((HttpServletRequest) actionRequest.getPortletSession(),"student-form-error");
                     e.printStackTrace();
                    
              }
       }

}
