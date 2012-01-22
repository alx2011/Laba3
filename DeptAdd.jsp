
<%@ page import ="chikalov.model.*"%>
<%@ page import ="chikalov.controller.*"%>
<jsp:include page="Menu.jsp" flush="true"/>
<h1> Create new dept</h1>
<script type="text/javascript" src="js/winscript.js"></script>
<form method="post" action="CreateDept">
  <fieldset>
    <div class="form-item">
      <label for="parameter-name">Dept name(*):</label>
      <input id="parameter-name" name="dname" type="text" />
    </div>
    <div class="form-item">
      <label for="parameter-name">Location(*):</label>
      <input id="parameter-name" name="loc" type="text" />
    </div>   
    <input type="hidden" value="createdept" name="action"/>
    <input method="post" type="submit" value="Save" />    
  </fieldset>
</form>
