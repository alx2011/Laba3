
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<% Dept dept= (Dept) request.getAttribute("dataobj"); %>
<h1> Edit <%= dept.getDname() %></h1>

<form method="post" action="UpdateDept">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Dept Name(*):</label>
      <input id="parameter-name" name="dname" type="text" value="<%=dept.getDname()%>"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Location(*):</label>
      <input id="parameter-name" name="loc" type="text" value="<%=dept.getLoc()%>"/>
    </div>  
    
    <input type="hidden" value="<%= dept.getDeptno() %>" name="id"/>
    <input type="hidden" value="updatedept" name="action"/>
    <input type="submit" value="Save" />    
  </fieldset>
</form>
