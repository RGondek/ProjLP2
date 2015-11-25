package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastroPessoa_005f02_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Adicionar Perfil | Sistema</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <h1>Adicionar Perfil</h1><br>\n");
      out.write("            <form action=\"FrontController\" method=\"POST\" name=\"pessoaCreate\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"pessoa.create_02\">\n");
      out.write("                <input type=\"hidden\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"rg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"cpf\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cpf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <h4>Informações pessoais</h4>\n");
      out.write("                Sexo:<br>\n");
      out.write("                <select class=\"inputSelect\" required name=\"sexo\" >\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"feminino\">Feminino</option>\n");
      out.write("                    <option value=\"masculino\">Masculino</option>\n");
      out.write("                </select><br>\n");
      out.write("                Data de Nascimento:<br>\n");
      out.write("                <input type=\"date\" name=\"dataNascimento\" placeholder=\"Data de Nascimento\" required/><br>\n");
      out.write("                Nacionalidade:<br>\n");
      out.write("                <input type=\"text\" name=\"nacionalidade\" placeholder=\"Nacionalidade\" pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/><br>\n");
      out.write("                Estado Civil:<br>\n");
      out.write("                <select class=\"inputSelect\" required name=\"estadoCivil\">\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"solteiro\">Solteiro(a)</option>\n");
      out.write("                    <option value=\"casado\">Casado(a)</option>\n");
      out.write("                    <option value=\"divorciado\">Divorciado(a)</option>\n");
      out.write("                    <option value=\"viuvo\">Viúvo(a)</option>\n");
      out.write("                </select><br>\n");
      out.write("                <br><h4>Endereço</h4>                \n");
      out.write("                Rua:<br>\n");
      out.write("                <input type=\"text\" name=\"rua\" placeholder=\"Rua\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                Bairro:<br>\n");
      out.write("                <input type=\"text\" name=\"bairro\" placeholder=\"Bairro\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                Complemento:<br>\n");
      out.write("                <input type=\"text\" name=\"complemento\" placeholder=\"Complemento\" pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                Número:<br>\n");
      out.write("                <input type=\"text\" name=\"numero\" placeholder=\"Numero\" required /><br>\n");
      out.write("                Cidade:<br>\n");
      out.write("                <input type=\"text\" name=\"cidade\" placeholder=\"Cidade\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                CEP:<br>\n");
      out.write("                <input type=\"text\" name=\"cep\" placeholder=\"CEP\" required/><br>\n");
      out.write("                Estado:<br>\n");
      out.write("                <input type=\"text\" name=\"estado\" placeholder=\"Estado\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                País:<br>\n");
      out.write("                <input type=\"text\" name=\"pais\" placeholder=\"País\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                <br><h4>Contato</h4> \n");
      out.write("                Telefone:<br>\n");
      out.write("                <input type=\"text\" name=\"telefone\" placeholder=\"Ex: 1144536651\"  required pattern=\"[0-9]{10}\" title=\"Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos\" /><br>\n");
      out.write("                Celular:<br>\n");
      out.write("                <input type=\"text\" name=\"celular\" placeholder=\"Ex: 11982785986\" pattern=\"[0-9]{10,}\" required title=\"Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos\" /><br>\n");
      out.write("                <input type=\"submit\" class=\"inputSubmit\" value=\"Próximo\">\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
