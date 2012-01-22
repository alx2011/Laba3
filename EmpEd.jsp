
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Date"%>
<jsp:include page="Menu.jsp" flush="true"/>
<% Emp emp= (Emp) request.getAttribute("dataobj"); %>
<% ArrayList<Emp> mgrlist = (ArrayList<Emp>) request.getAttribute("mgrlist");%>
<% ArrayList<Dept> deptlist = (ArrayList<Dept>) request.getAttribute("deptlist");%>
<h1> Edit <%= emp.getEname() %></h1>

<form method="post" action="UpdateEmp">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Emp name(*):</label>
      <input id="parameter-name" name="ename" type="text" value="<%=emp.getEname()%>"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Job (*)</label>
      <input id="parameter-name" name="job" type="text" value="<%=emp.getJob()%>"/>
    </div>  
    <div class="form-item">
      <label for="parameter-name">Mgr:</label>
      <select name="mgr" size="1">
    <%  for(Emp mgr : mgrlist) {
    		if (mgr.getEmpno()!= emp.getMgr()) { %>      
				<option value="<%= mgr.getEmpno() %>"> <%= mgr.getEname() %></option>
			<%} else {  %>
				<option selected="selected" value="<%= mgr.getEmpno() %>"> <%= mgr.getEname() %> </option>
	<% 		}
		} %>
		
	  </select>
    </div>
    <div class="form-item">
      <label for="parameter-name">Hiredate dd-mm-yy(*)</label>
      <input id="parameter-name" name="hiredate" type="text" value="<%=emp.getHiredate()%>"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Salary (*):</label>
      <input id="parameter-name" name="sal" type="text" value="<%=emp.getSal()%>"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Comm</label>
      <input id="parameter-name" name="comm" type="text" value="<%=emp.getComm()%>"/>
    </div>  
    <div class="form-item">
      <label for="parameter-name">Dept:</label>
      <select name="deptno" size="1">
    <%  for(Dept dept : deptlist) {
    		if (dept.getDeptno()!= emp.getDeptno()) { %>      
				<option value="<%= dept.getDeptno() %>"> <%= dept.getDname() %></option>
			<%} else {  %>
				<option selected="selected" value="<%= dept.getDeptno() %>"> <%= dept.getDname() %> </option>
	<% 		}
		} %>
		
	  </select>
    </div>
    
    
    <input type="hidden" value="<%= emp.getEmpno() %>" name="id"/>
    <input type="hidden" value="updateemp" name="action"/>
    <input type="submit" value="Save"  />    
  </fieldset>
</form>
