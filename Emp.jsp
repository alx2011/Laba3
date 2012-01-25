
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> IT'S Emp JSP</h1>

<form action= "ShowEmp" >
<input type="hidden" value="showemp" name="action"/>
<input type="text" name="search"/>
<input type="submit" value="Search" />
</form>
<table border="1">
<tr>
<td><a href="ShowEmp?sortfield=empno&orderby=asc" >empno</a></td>
<td><a href="ShowEmp?sortfield=ename&orderby=asc" >ename</a></td>
<td><a href="ShowEmp?sortfield=job&orderby=asc" >job</a></td>
<td><a href="ShowEmp?sortfield=mgr&orderby=asc" >mgr</a></td>
<td><a href="ShowEmp?sortfield=hiredate&orderby=asc" >hiredate</a></td>
<td><a href="ShowEmp?sortfield=sal&orderby=asc" >sal</a></td>
<td><a href="ShowEmp?sortfield=comm&orderby=asc" >comm</a></td>
<td><a href="ShowEmp?sortfield=deptno&orderby=asc" >deptno</a></td>
<td><a href="ShowEmp?sortfield=dname&orderby=asc" >dname</a></td>
<td><a href="ShowEmp?sortfield=loc&orderby=asc" >loc</a></td>
</tr>
<c:forEach var="e" items="${datalist}" > 
	<tr>
	<td>${e.empno}</td>
	<td>${e.ename}</td>	
	<td>${e.job}</td>
	<td>${e.mgr}</td>
	<td>${e.hiredate}</td>	
	<td>${e.sal}</td>
	<td>${e.comm}</td>
	<td>${e.deptno}</td>
	<td>${e.dept.dname}</td>
	<td>${e.dept.loc}</td>
	<td> <a href="EditEmp?id=${e.empno}" >Edit</a></td>
	<td> <a href="DeleteEmp?id=${e.empno}" >Delete</a></td>
	</tr>  
</c:forEach>

</table>
<a href="AddEmp" >Add new Employer</a></td>