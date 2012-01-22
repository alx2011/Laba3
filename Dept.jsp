<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> IT'S DEPT JSP</h1>

<% ArrayList<Dept> list = (ArrayList<Dept>) request.getAttribute("datalist");%><br>
<form >
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
<%  for(Dept dept : list) {%>
	<tr>
	<td><%= dept.getDeptno() %></td>
	<td><%= dept.getDname() %></td>	
	<td><%= dept.getLoc() %></td>
	<td> <a href="EditDept?id=<%= dept.getDeptno() %>"  >Edit</a></td>
	<td> <a href="DeleteDept?id=<%= dept.getDeptno() %>" >Delete</a></td>
	</tr>  
<%  }
%>
</table>
<a href="AddDept"  >Add new dept type</a></td>