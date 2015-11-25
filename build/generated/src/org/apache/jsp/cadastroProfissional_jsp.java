package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastroProfissional_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <title>Cadastrar novo Profissional | Sistema</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <h1>Adicionar Pessoa</h1><br>\n");
      out.write("            <form action=\"FrontController\" method=\"POST\" name=\"profissionalCreate\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"profissional.create\">\n");
      out.write("                <input type=\"hidden\" name=\"idPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${idPessoa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                Formação: <br>\n");
      out.write("                <input type=\"text\" name=\"formacao\" placeholder=\"Formação\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\"required/><br>\n");
      out.write("                Especialidade: <br>\n");
      out.write("                <input type=\"text\" name=\"especialidade\" placeholder=\"Especialidade\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\" required/><br>\n");
      out.write("                Registro Profissional: <br>\n");
      out.write("                <input type=\"text\" name=\"registroProfissional\" placeholder=\"Registro do Profissional\" pattern=\"{6,}\" title=\"Letras, números e caracteres especiais são permitidos, no mínimo 6 caracteres\" required/><br>\n");
      out.write("                <input type=\"submit\" class=\"inputSubmit\" value=\"Adicionar\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!--        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profissionaisLista == null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <c:redirect url=\"FrontController?command=profissional.read\"></c:redirect>\n");
      out.write("         </c:if>\n");
      out.write("        <form>\n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"profissional.update\">\n");
      out.write("            <select name=\"profissionalSelecionado\">\n");
      out.write("                <c:forEach var=\"col\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profissionaisLista}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <option value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getIdProfissional()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getPessoa().getNome()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</option>\n");
      out.write("                </c:forEach>\n");
      out.write("            </select>-->\n");
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
