



<%@include file="/html/liferay_open/init.jsp"%>

<portlet:actionURL var="getShowCategory" name="getShowCategory">

</portlet:actionURL>

<portlet:actionURL name="liferayactionofUrl" var="liferayactionofUrl"></portlet:actionURL>
<portlet:actionURL name="getCategoryByIdAndDisplay" var="getCategoryByIdAndDisplay"></portlet:actionURL>


<aui:layout>
<aui:form name="fm" action="<%=liferayactionofUrl.toString() %>" method="post">
<aui:column>
<aui:input name="name" type="text"></aui:input>
<aui:input type="textarea" class="lfr-input-text" name="description"  value='<%= portletPreferences.getValue("addApp", "") %>' />

<aui:button value="submit" type="submit"></aui:button>
 <a href="<%=getShowCategory%>">Show Catelory</a>

</aui:column> 

	
</aui:form>

</head>
<body>

<table>
  <tr>
    <th>ID</th>
    <th>User Name</th>
    <th>Description</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
  <% int m=0;
  if(renderRequest.getParameter("id")!=null)
   m=Integer.parseInt(renderRequest.getParameter("id"));
  for(int i=0; i<m; i++){
  %> 
  <portlet:renderURL var="sendToEditPage">
<%--	<portlet:param name="idCategory" value="<%=renderRequest.getParameter("categoryId"+i) %>" />
    <portlet:param name="mvcPath" value="/html/liferay_open/edit.jsp" />  --%>
	</portlet:renderURL>
  <tr>
    <td><%=renderRequest.getParameter("categoryId"+i) %></td>
    <td><%=renderRequest.getParameter("name"+i) %></td>
    <td><%=renderRequest.getParameter("description"+i) %></td>
    <td><a href="<%=sendToEditPage%>">Edit</a></td>
    <td><a href="<%=getShowCategory%>">Delete</a></td>
  </tr>
  <% } %>
 
 
 
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
</table>
</aui:layout>
 