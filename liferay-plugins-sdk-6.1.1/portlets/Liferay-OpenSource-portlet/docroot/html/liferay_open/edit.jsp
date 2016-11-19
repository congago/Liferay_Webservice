<%@page import="com.test.Category"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="/html/liferay_open/init.jsp"%>


<portlet:actionURL var="getShowCategory" name="getShowCategory">
</portlet:actionURL>
<portlet:actionURL name="liferayactionofUrl" var="liferayactionofUrl"></portlet:actionURL>

<aui:form name="fm" action="<%=liferayactionofUrl.toString() %>" method="post">
<aui:column>

<%
	long studentId = ParamUtil.getLong(renderRequest, "categoryId");
	Category category =  null;
	if( studentId > 0) {
		
		category = StudentLocalServiceUtil.fetchStudent(studentId);
	}
	
%>

<aui:input name="name" type="text"></aui:input>
<aui:input type="textarea" class="lfr-input-text" name="description"  value='<%= portletPreferences.getValue("addApp", "") %>' />

<aui:button value="submit" type="submit"></aui:button>
 <a href="<%=getShowCategory%>">Show Catelory</a>

</aui:column> 

	
</aui:form>