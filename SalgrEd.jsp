
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Menu.jsp" flush="true"/>

<h1> Edit ${dataobj.grade}</h1>

<form method="post" action="UpdateSalgrade">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Min Salar(*):</label>
      <input id="parameter-name" name="minsal" type="text" value="${dataobj.minsal}"/>
    </div>
    <div class="form-item">
      <label for="parameter-name">Hi salary:</label>
      <input id="parameter-name" name="hisal" type="text" value="${dataobj.hisal}"/>
    </div>  
    
    <input type="hidden" value="${dataobj.grade}" name="id"/>
    <input type="hidden" value="updatesalgrade" name="action"/>
    <input type="submit" value="Save"  />    
  </fieldset>
</form>
