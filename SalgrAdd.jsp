
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> Create new Salgrade</h1>
<script type="text/javascript" src="js/winscript.js"></script>
<form method="post" action="CreateSalgrade">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Min Salary(*):</label>
      <input id="parameter-name" name="minsal" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Hi Salary(*):</label>
      <input id="parameter-name" name="hisal" type="text" />
    </div>   
    <input type="hidden" value="createsalgrade" name="action"/>
    <input method="post" type="submit" value="Save"  />    
  </fieldset>
</form>
