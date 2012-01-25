
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> IT'S Salgrade JSP</h1>


<form action="ShowSalgrade">
<input type="hidden" value="ShowSalgrade" name="action"/>
<input type="text" name="search"/>
<input type="submit" value="Search" />
</form>
<table border="1">
<tr>
<td><a href="ShowSalgrade?sortfield=grade&orderby=asc" >grade</a></td>
<td><a href="ShowSalgrade?sortfield=minsal&orderby=asc" >minsal</a></td>
<td><a href="ShowSalgrade?sortfield=hisal&orderby=asc" >hisal</a></td>
</tr>
<c:forEach var="y" items="${datalist}" > 
	<tr>
	<td>${y.grade}</td>
	<td>${y.minsal}</td>	
	<td>${y.hisal}</td>	
	<td> <a href="EditSalgrade?id=${y.grade}" >Edit</a></td>
	<td> <a href="DeleteSalgrade?id=${y.grade}" >Delete</a></td>
	</tr>  
</c:forEach>
	

</table>
<a href="AddSalgrade" >Add new salgrade</a></td>