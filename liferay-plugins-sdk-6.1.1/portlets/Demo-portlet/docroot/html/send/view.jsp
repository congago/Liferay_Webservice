
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %> 
<portlet:defineObjects /> 

<portlet:actionURL name="sendAction" var="sendAction">

</portlet:actionURL>
 <form action="<%=sendAction.toString()%>" method="POST">
 <input type="submit" name="Submit" value="Submit"> 
 <h3><b>getParameter: <%=renderRequest.getParameter("name") %></b></h3>
 </form> 