
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> Edit ${dataobj.ename}</h1>

<form method="post" action="UpdateEmp">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Emp name(*):</label>
      <input id="parameter-name" name="ename" type="text" value="${dataobj.ename}"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Job (*)</label>
      <input id="parameter-name" name="job" type="text" value="${dataobj.job}"/>
    </div>  
    <div class="form-item">
      <label for="parameter-name">Mgr:</label>
      <select name="mgr" size="1">
   <c:forEach var="m" items="${mgrlist}" > 
   		 <c:if test="${dataobj.mgr != m.empno}">    		      
			<option value="${m.empno}"> ${m.ename}</option>
		 </c:if>
		 <c:if test="${dataobj.mgr == m.empno}">    		      
			<option selected="selected" value="${m.empno}"> ${m.ename} </option>
		 </c:if>
	</c:forEach>
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
    <c:forEach var="d" items="${deptlist}" >
    	<c:if test="${d.deptno != dataobj.deptno}">    	    
				<option value="${d.deptno}"> ${d.dname}</option>
		</c:if>
		<c:if test="${d.deptno == dataobj.deptno}">  
				<option selected="selected" value="${d.deptno}"> ${d.dname} </option>
		</c:if>
	</c:forEach>		
	  </select>
    </div>    
    <input type="hidden" value="${dataobj.empno}" name="id"/>
    <input type="hidden" value="updateemp" name="action"/>
    <input type="submit" value="Save"  />    
  </fieldset>
</form>
