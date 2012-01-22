
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> IT'S Salgrade JSP</h1>

<% ArrayList<Salgrade> list = (ArrayList<Salgrade>) request.getAttribute("datalist");%><br>
<form action="showsalgrade">
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
<%  for(Salgrade salgr : list) {%>
	<tr>
	<td><%= salgr.getGrade() %></td>
	<td><%= salgr.getMinsal() %></td>	
	<td><%= salgr.getHisal() %></td>
	<td> <a href="EditSalgrade?id=<%= salgr.getGrade() %>" >Edit</a></td>
	<td> <a href="DeleteSalgrade?id=<%= salgr.getGrade() %>" >Delete</a></td>
	</tr>  
<%  }
%>
</table>
<a href="AddSalgrade" >Add new salgrade</a></td>