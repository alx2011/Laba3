<jsp:include page="Menu.jsp" flush="true"/>
<% String errorMsg = (String)request.getAttribute("error"); %>
<h1><%= errorMsg %></h1>
