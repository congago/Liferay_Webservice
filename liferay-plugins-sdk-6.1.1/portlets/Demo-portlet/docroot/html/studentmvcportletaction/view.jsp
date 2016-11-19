<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:actionURL var="addStudentActionURL" windowState="normal" name="addStudent">
</portlet:actionURL>
<h2>Student Form</h2>
<form action="<%=addStudentActionURL%>" name="studentForm"  method="POST">
<b>First Name</b><br/>
<input  type="text" name="<portlet:namespace/>firstName" id="<portlet:namespace/>firstName"/><br/>
<b>Last Name</b><br/>
<input type="text" name="<portlet:namespace/>lastName" id="<portlet:namespace/>lastName"/><br/>
<b>Exam Fee</b><br/>
<input type="text" name="<portlet:namespace/>examFee" id="<portlet:namespace/>examFee"/><br/>
<b>Gender</b><br/>
<input type="radio" name="<portlet:namespace/>sex" value="male">Male<br>
<input type="radio" name="<portlet:namespace/>sex" value="female">Female<br/>
<b>Subjects Obtained</b><br/>
<input type="checkbox" name="<portlet:namespace/>subjects" value="Maths">Maths<br>
<input type="checkbox" name="<portlet:namespace/>subjects" value="Physics">Physics<br>
<input type="checkbox" name="<portlet:namespace/>subjects" value="Chemistry">Chemistry<br>
<input type="checkbox" name="<portlet:namespace/>subjects" value="Bio Technology">Biotechnology<br>
<input type="checkbox" name="<portlet:namespace/>subjects" value="Computer Science">Computer Science<br>
<b>Academic Year</b><br>
<select name="<portlet:namespace/>acadamicYear">
  <option value="I Year">I Year</option>
  <option value="II Year">II Year</option>
  <option value="III Year">III Year</option>
  <option value="IV Year">IV Year</option>
</select><br>
<b>Address</b><br/>
<textarea rows="4" cols="50" name="<portlet:namespace/>address">
</textarea><br/>
<input type="submit" name="addStudent" id="addStudent" value="Add Student"/>
</form>
