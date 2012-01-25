
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> IT'S DEPT JSP</h1>


<form  action="ShowDept">
<input type="hidden" value="ShowDept" name="action"/>
<input type="text" name="search"/>
<input type="submit" value="Search" />
</form>
<table border="1">
<tr>
<td><a href="ShowDept?sortfield=deptno&orderby=asc" >deptno</a></td>
<td><a href="ShowDept?sortfield=dname&orderby=asc" >dname</a></td>
<td><a href="ShowDept?sortfield=loc&orderby=asc" >loc</a></td>
</tr>
<c:forEach var="d" items="${datalist}" > 

	<tr>
	<td>${d.deptno}</td>
	<td>${d.dname}</td>	
	<td>${d.loc}</td>
	<td> <a href="EditDept?id=${d.deptno}"  >Edit</a></td>
	<td> <a href="DeleteDept?id=${d.deptno}" >Delete</a></td>
	</tr>  
</c:forEach>
</table>
<a href="AddDept"  >Add new dept type</a></td>