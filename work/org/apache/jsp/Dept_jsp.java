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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
