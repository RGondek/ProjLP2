package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class painelSecretaria_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/mainStyle.css\">\n");
      out.write("        <title>Home | Sistema</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!--<link rel=\"stylesheet\" type=\"text/css\" href=\"style/mainStyle.css\">-->\n");
      out.write("<div id=\"content\">\n");
      out.write("    <div class=\"headerLeft\">\n");
      out.write("        <h1>Nome do sistema</h1>\n");
      out.write("    </div>\n");
      out.write("    <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <div class=\"headerRight\">\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            <form name=\"logout\" method=\"post\" action=\"FrontController\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"user.logout\"/>\n");
      out.write("                <input type=\"submit\" name=\"Sair\" value=\"Sair\"/> \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </c:if>\n");
      out.write("</div>\n");
      out.write("<br />\n");
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <h1>Seja bem vindo ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("            \n");
      out.write("\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <a class=\"inputButton\" href=\"cadastroPessoa_01.jsp\"><li>Adicionar Cadastro</li></a>\n");
      out.write("                    <a class=\"inputButton\" href=\"cadastroConsulta.jsp\"><li>Adicionar Consulta</li></a>\n");
      out.write("                    <a class=\"inputButton\" ><li>Adicionar Procedimento</li></a>\n");
      out.write("                    <a class=\"inputButton\" ><li>Editar Paciente</li></a>\n");
      out.write("                    <a class=\"inputButton\" ><li>Editar Profissional</li></a>\n");
      out.write("                    <a class=\"inputButton\" ><li>Editar Pessoa</li></a>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
