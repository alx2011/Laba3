
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import  ="java.util.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<% ArrayList<Emp> mgrlist = (ArrayList<Emp>) request.getAttribute("mgrlist");%>
<% ArrayList<Dept> deptlist = (ArrayList<Dept>) request.getAttribute("deptlist");%>
<h1> Create new Emp</h1>

<script type="text/javascript" src="js/winscript.js"></script>
<form method="post" action="CreateEmp">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Emp Name(*):</label>
      <input id="parameter-name" name="ename" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Job (*):</label>
      <input id="parameter-name" name="job" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Mgr():</label>
      <select name="mgr" size="1">
    <%  for(Emp mgr : mgrlist) { %>
    	<option value="<%= mgr.getEmpno() %>"> <%= mgr.getEname() %></option>			
	<%	} %>		
	  </select>
    </div>
    <div class="form-item">
      <label for="parameter-name">Hiredate dd-mm-yy: (*)</label>
      <input id="parameter-name" name="hiredate" type="text" />
    </div>   
        <div class="form-item">
      <label for="parameter-name">Salary (*):</label>
      <input id="parameter-name" name="sal" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Comm :</label>
      <input id="parameter-name" name="comm" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Dept</label>
      <select name="deptno" size="1">
    <%  for(Dept dept : deptlist) { %>
    	<option value="<%= dept.getDeptno() %>"> <%= dept.getDname() %></option>			
	<%	} %>		
	  </select>
    </div>    
    <input type="hidden" value="createemp" name="action"/>
    <input method="post" type="submit" value="Save"  />    
  </fieldset>
</form>
