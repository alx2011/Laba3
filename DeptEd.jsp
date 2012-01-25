
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> Edit ${dataobj.dname}</h1>

<form method="post" action="UpdateDept">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Dept Name(*):</label>
      <input id="parameter-name" name="dname" type="text" value="${dataobj.dname}"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Location(*):</label>
      <input id="parameter-name" name="loc" type="text" value="${dataobj.loc}"/>
    </div>  
    
    <input type="hidden" value="${dataobj.deptno}" name="id"/>
    <input type="hidden" value="updatedept" name="action"/>
    <input type="submit" value="Save" />    
  </fieldset>
</form>
