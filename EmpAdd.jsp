
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import  ="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> Create new Emp</h1>

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
    <c:forEach var="m" items="${mgrlist}" > 
    	<option value="${m.empno}"> ${m.ename}</option>			
	</c:forEach>		
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
    <c:forEach var="d" items="${deptlist}" >    
    	<option value="${d.deptno}"> ${d.dname} </option>			
	</c:forEach>		
	  </select>
    </div>    
    <input type="hidden" value="createemp" name="action"/>
    <input method="post" type="submit" value="Save"  />    
  </fieldset>
</form>
