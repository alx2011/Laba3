
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<% Salgrade salgr= (Salgrade) request.getAttribute("dataobj"); %>
<h1> Edit <%= salgr.getGrade() %></h1>

<form method="post" action="UpdateSalgrade">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Min Salar(*):</label>
      <input id="parameter-name" name="minsal" type="text" value="<%=salgr.getMinsal()%>"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Hi salary:</label>
      <input id="parameter-name" name="hisal" type="text" value="<%=salgr.getHisal()%>"/>
    </div>  
    
    <input type="hidden" value="<%= salgr.getGrade() %>" name="id"/>
    <input type="hidden" value="updatesalgrade" name="action"/>
    <input type="submit" value="Save"  />    
  </fieldset>
</form>
