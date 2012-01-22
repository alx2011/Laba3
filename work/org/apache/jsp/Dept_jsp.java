package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import chikalov.model.*;
import chikalov.controller.*;
import java.util.*;

public final class Dept_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<h1> IT'S DEPT JSP</h1>\n");
      out.write("\n");
 ArrayList<Dept> list = (ArrayList<Dept>) request.getAttribute("datalist");
      out.write("<br>\n");
      out.write("<form >\n");
      out.write("<input type=\"hidden\" value=\"ShowDept\" name=\"action\"/>\n");
      out.write("<input type=\"text\" name=\"search\"/>\n");
      out.write("<input type=\"submit\" value=\"Search\" />\n");
      out.write("</form>\n");
      out.write("<table border=\"1\">\n");
      out.write("<tr>\n");
      out.write("<td><a href=\"ShowDept?sortfield=deptno&orderby=asc\" >deptno</a></td>\n");
      out.write("<td><a href=\"ShowDept?sortfield=dname&orderby=asc\" >dname</a></td>\n");
      out.write("<td><a href=\"ShowDept?sortfield=loc&orderby=asc\" >loc</a></td>\n");
      out.write("</tr>\n");
  for(Dept dept : list) {
      out.write("\n");
      out.write("\t<tr>\n");
      out.write("\t<td>");
      out.print( dept.getDeptno() );
      out.write("</td>\n");
      out.write("\t<td>");
      out.print( dept.getDname() );
      out.write("</td>\t\n");
      out.write("\t<td>");
      out.print( dept.getLoc() );
      out.write("</td>\n");
      out.write("\t<td> <a href=\"EditDept?id=");
      out.print( dept.getDeptno() );
      out.write("\"  >Edit</a></td>\n");
      out.write("\t<td> <a href=\"DeleteDept?id=");
      out.print( dept.getDeptno() );
      out.write("\" >Delete</a></td>\n");
      out.write("\t</tr>  \n");
  }

      out.write("\n");
      out.write("</table>\n");
      out.write("<a href=\"AddDept\"  >Add new dept type</a></td>");
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
