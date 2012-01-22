package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import chikalov.model.*;
import chikalov.controller.*;
import java.util.*;

public final class EmpAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, true);
      out.write('\n');
 ArrayList<Emp> mgrlist = (ArrayList<Emp>) request.getAttribute("mgrlist");
      out.write('\n');
 ArrayList<Dept> deptlist = (ArrayList<Dept>) request.getAttribute("deptlist");
      out.write("\n");
      out.write("<h1> Create new Emp</h1>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"js/winscript.js\"></script>\n");
      out.write("<form method=\"post\" action=\"CreateEmp\">\n");
      out.write("  <fieldset>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Emp Name(*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"ename\" type=\"text\" />\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Job (*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"job\" type=\"text\" />\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Mgr():</label>\n");
      out.write("      <select name=\"mgr\" size=\"1\">\n");
      out.write("    ");
  for(Emp mgr : mgrlist) { 
      out.write("\n");
      out.write("    \t<option value=\"");
      out.print( mgr.getEmpno() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( mgr.getEname() );
      out.write("</option>\t\t\t\n");
      out.write("\t");
	} 
      out.write("\t\t\n");
      out.write("\t  </select>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Hiredate dd-mm-yy: (*)</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"hiredate\" type=\"text\" />\n");
      out.write("    </div>   \n");
      out.write("        <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Salary (*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"sal\" type=\"text\" />\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Comm :</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"comm\" type=\"text\" />\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Dept</label>\n");
      out.write("      <select name=\"deptno\" size=\"1\">\n");
      out.write("    ");
  for(Dept dept : deptlist) { 
      out.write("\n");
      out.write("    \t<option value=\"");
      out.print( dept.getDeptno() );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( dept.getDname() );
      out.write("</option>\t\t\t\n");
      out.write("\t");
	} 
      out.write("\t\t\n");
      out.write("\t  </select>\n");
      out.write("    </div>    \n");
      out.write("    <input type=\"hidden\" value=\"createemp\" name=\"action\"/>\n");
      out.write("    <input method=\"post\" type=\"submit\" value=\"Save\"  />    \n");
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
