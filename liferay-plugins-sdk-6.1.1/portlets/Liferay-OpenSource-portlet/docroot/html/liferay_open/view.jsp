
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<portlet:defineObjects /> 
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="javax.portlet.PortletContext"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:actionURL name="liferayactionofUrl" var="liferayactionofUrl"></portlet:actionURL>


<aui:layout>
<aui:form name="fm" action="<%=liferayactionofUrl.toString() %>" method="post">
<aui:column>
<aui:input name="name" type="text"></aui:input>
<aui:input type="textarea" class="lfr-input-text" name="description"  value='<%= portletPreferences.getValue("addApp", "") %>' />


<aui:button value="submit" type="submit"></aui:button>


</aui:column> 

	
</aui:form>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

<table>
  <tr>
    <th>ID</th>
    <th>User Name</th>
    <th>Description</th>
  </tr>
  <% int m=0;
  if(renderRequest.getParameter("id")!=null)
   m=Integer.parseInt(renderRequest.getParameter("id"));
  for(int i=0; i<m; i++){
  %> 
  
  <tr>
    <td><%=renderRequest.getParameter("categoryId"+i) %></td>
    <td><%=renderRequest.getParameter("name"+i) %></td>
    <td><%=renderRequest.getParameter("description"+i) %></td>
  </tr>
  <% } %>
 
</table>
</aui:layout>
 