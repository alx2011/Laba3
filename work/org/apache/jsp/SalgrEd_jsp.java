package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import chikalov.model.*;
import chikalov.controller.*;

public final class SalgrEd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<h1> Edit ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dataobj.grade}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h1>\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"UpdateSalgrade\">\n");
      out.write("  <fieldset>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Min Salar(*):</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"minsal\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dataobj.minsal}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-item\">\n");
      out.write("      <label for=\"parameter-name\">Hi salary:</label>\n");
      out.write("      <input id=\"parameter-name\" name=\"hisal\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dataobj.hisal}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("    </div>  \n");
      out.write("    \n");
      out.write("    <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dataobj.grade}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"id\"/>\n");
      out.write("    <input type=\"hidden\" value=\"updatesalgrade\" name=\"action\"/>\n");
      out.write("    <input type=\"submit\" value=\"Save\"  />    \n");
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
