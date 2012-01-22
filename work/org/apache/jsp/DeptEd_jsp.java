package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import chikalov.model.*;
import chikalov.controller.*;

public final class DeptEd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
 Dept dept= (Dept) request.getAttribute("dataobj"); 
      out.write("\n");
      out.write("<h1> Edit ");
      out.print( dept.getDname() );
      out.write("</h1>\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"UpdateDept\">\n");
      out.write("  <fieldset>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Dept Name(*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"dname\" type=\"text\" value=\"");
      out.print(dept.getDname());
      out.write("\"/>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Location(*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"loc\" type=\"text\" value=\"");
      out.print(dept.getLoc());
      out.write("\"/>\n");
      out.write("    </div>  \n");
      out.write("    \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.print( dept.getDeptno() );
      out.write("\" name=\"id\"/>\n");
      out.write("    <input type=\"hidden\" value=\"updatedept\" name=\"action\"/>\n");
      out.write("    <input type=\"submit\" value=\"Save\" />    \n");
      out.write("  </fieldset>\n");
      out.write("</form>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
