
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Date"%>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> IT'S Emp JSP</h1>

<% ArrayList<Emp> list = (ArrayList<Emp>) request.getAttribute("datalist");%><br>
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
<%  for(Emp emp : list) {%>
	<tr>
	<td><%= emp.getEmpno() %></td>
	<td><%= emp.getEname() %></td>	
	<td><%= emp.getJob() %></td>
	<td><%= emp.getMgr() %></td>
	<td><%= emp.getHiredate() %></td>	
	<td><%= emp.getSal() %></td>
	<td><%= emp.getComm() %></td>
	<td><%= emp.getDeptno() %></td>
	<td><%= emp.getDept().getDname() %></td>
	<td><%= emp.getDept().getLoc() %></td>
	<td> <a href="EditEmp?id=<%= emp.getEmpno() %>" >Edit</a></td>
	<td> <a href="DeleteEmp?id=<%= emp.getEmpno() %>" >Delete</a></td>
	</tr>  
<%  }
%>
</table>
<a href="AddEmp" >Add new Employer</a></td>