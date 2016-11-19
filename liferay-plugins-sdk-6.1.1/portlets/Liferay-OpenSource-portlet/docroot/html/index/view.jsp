
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<portlet:defineObjects /> 

<%@page import="javax.portlet.PortletContext"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:actionURL name="actionofUrl" var="actionofUrl"></portlet:actionURL>


<aui:layout>
<aui:form name="fm" action="<%=actionofUrl.toString() %>" method="post">
<aui:column>
<aui:input name="id" type="text"></aui:input>
<aui:input name="result" type="text"></aui:input>
<aui:button value="submit" type="submit"></aui:button>

</aui:column> 

</aui:form>
</aui:layout>
 