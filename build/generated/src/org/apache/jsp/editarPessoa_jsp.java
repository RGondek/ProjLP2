package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editarPessoa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style/mainStyle.css\">\n");
      out.write("        <title>Editar Perfil | Sistema</title>\n");
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
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</div>\n");
      out.write("<br />\n");
      out.write("\n");
      out.write("        <div id=\"content\">\n");
      out.write("            <h1>Editar Perfil</h1><br>\n");
      out.write("            <form action=\"FrontController\" method=\"POST\" name=\"pessoaEditar\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"pessoa.editar\">\n");
      out.write("                <input type=\"hidden\" name=\"idPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getIdPessoa()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                Nome Completo:<br>\n");
      out.write("                <input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getNome()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[A-Za-z\\s]{2,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres\"/><br>\n");
      out.write("                RG:<br>\n");
      out.write("                <input type=\"text\" name=\"rg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getRg()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" pattern=\"[0-9]{6,}\" title=\"Somente números permitidos, no mínimo 6 dígitos\"required/><br>\n");
      out.write("                CPF:<br>\n");
      out.write("                <input type=\"text\" name=\"cpf\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCpf()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" pattern=\"[0-9]{11}\" title=\"Somente números são permitidos, exatamente 11 caracteres.\" required/><br>\n");
      out.write("                <h4>Informações pessoais</h4>\n");
      out.write("                Sexo (Atual: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getSexo()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("):<br>\n");
      out.write("                <select class=\"inputSelect\" name=\"sexo\" >\n");
      out.write("                    <option value=\"Nulo\">Selecione</option>\n");
      out.write("                    <option value=\"feminino\">Feminino</option>\n");
      out.write("                    <option value=\"masculino\">Masculino</option>\n");
      out.write("                </select><br>\n");
      out.write("                Data de Nascimento:<br>\n");
      out.write("                <input type=\"date\" name=\"dataNascimento\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getDataNascimento()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required/><br>\n");
      out.write("                Nacionalidade:<br>\n");
      out.write("                <input type=\"text\" name=\"nacionalidade\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getNacionalidade()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/><br>\n");
      out.write("                Estado Civil (Atual: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getEstadoCivil()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("):</br>\n");
      out.write("                <select class=\"inputSelect\" name=\"estadoCivil\">\n");
      out.write("                    <option value=\"Nulo\">Selecione</option>\n");
      out.write("                    <option value=\"solteiro\">Solteiro(a)</option>\n");
      out.write("                    <option value=\"casado\">Casado(a)</option>\n");
      out.write("                    <option value=\"divorciado\">Divorciado(a)</option>\n");
      out.write("                    <option value=\"viuvo\">Viúvo(a)</option>\n");
      out.write("                </select><br>\n");
      out.write("                <br><h4>Endereço</h4>                \n");
      out.write("                Rua:<br>\n");
      out.write("                <input type=\"text\" name=\"rua\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getRua()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                Bairro:<br>\n");
      out.write("                <input type=\"text\" name=\"bairro\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getBairro()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                Complemento:<br>\n");
      out.write("                <input type=\"text\" name=\"complemento\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getComplemento()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  /><br>\n");
      out.write("                Número:<br>\n");
      out.write("                <input type=\"text\" name=\"numero\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getNumero()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required /><br>\n");
      out.write("                Cidade:<br>\n");
      out.write("                <input type=\"text\" name=\"cidade\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCidade()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                CEP:<br>\n");
      out.write("                <input type=\"text\" name=\"cep\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCep()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required/><br>\n");
      out.write("                Estado (Atual: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getEstado()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("):<br> \n");
      out.write("                <select class=\"inputSelect\" name=\"estado\">\n");
      out.write("                    <option value=\"Nulo\">Selecione</option>\n");
      out.write("                    <option value=\"AC\">Acre</option>\n");
      out.write("                    <option value=\"AL\">Alagoas</option>\n");
      out.write("                    <option value=\"AP\">Amapá</option>\n");
      out.write("                    <option value=\"AM\">Amazonas</option>\n");
      out.write("                    <option value=\"BA\">Bahia</option>\n");
      out.write("                    <option value=\"CE\">Ceará</option>\n");
      out.write("                    <option value=\"DF\">Distrito Federal</option>\n");
      out.write("                    <option value=\"ES\">Espirito Santo</option>\n");
      out.write("                    <option value=\"GO\">Goiás</option>\n");
      out.write("                    <option value=\"MA\">Maranhão</option>\n");
      out.write("                    <option value=\"MS\">Mato Grosso do Sul</option>\n");
      out.write("                    <option value=\"MT\">Mato Grosso</option>\n");
      out.write("                    <option value=\"MG\">Minas Gerais</option>\n");
      out.write("                    <option value=\"PA\">Pará</option>\n");
      out.write("                    <option value=\"PB\">Paraíba</option>\n");
      out.write("                    <option value=\"PR\">Paraná</option>\n");
      out.write("                    <option value=\"PE\">Pernambuco</option>\n");
      out.write("                    <option value=\"PI\">Piauí</option>\n");
      out.write("                    <option value=\"RJ\">Rio de Janeiro</option>\n");
      out.write("                    <option value=\"RN\">Rio Grande do Norte</option>\n");
      out.write("                    <option value=\"RS\">Rio Grande do Sul</option>\n");
      out.write("                    <option value=\"RO\">Rondônia</option>\n");
      out.write("                    <option value=\"RR\">Roraima</option>\n");
      out.write("                    <option value=\"SC\">Santa Catarina</option>\n");
      out.write("                    <option value=\"SP\">São Paulo</option>\n");
      out.write("                    <option value=\"SE\">Sergipe</option>\n");
      out.write("                    <option value=\"TO\">Tocantins</option>\n");
      out.write("                </select><br>\n");
      out.write("                País:<br>\n");
      out.write("                <input type=\"text\" name=\"pais\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getPais()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /><br>\n");
      out.write("                <br><h4>Contato</h4> \n");
      out.write("                Telefone:<br>\n");
      out.write("                <input type=\"text\" name=\"telefone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getTelefone()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required pattern=\"[0-9]{10}\" title=\"Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos\" /><br>\n");
      out.write("                Celular:<br>\n");
      out.write("                <input type=\"text\" name=\"celular\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCelular()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" pattern=\"[0-9]{10,}\" required title=\"Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos\" /><br>\n");
      out.write("                <input type=\"submit\" class=\"inputSubmit\" value=\"Salvar alterações\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <form action=\"FrontController\" method=\"POST\" name=\"pessoaEditarPaciente\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"pessoa.irEditarPaciente\">\n");
      out.write("                <input type=\"hidden\" name=\"cpf\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCpf()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \n");
      out.write("                <input type=\"hidden\" name=\"idPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getIdPessoa()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">   \n");
      out.write("                <input type=\"submit\" class=\"inputSubmit\" style=\"width:150px;\" value=\"Editar paciente\">\n");
      out.write("            </form>  \n");
      out.write("\n");
      out.write("            <form action=\"FrontController\" method=\"POST\" name=\"pessoaEditarProfissional\">\n");
      out.write("                <input type=\"hidden\" name=\"command\" value=\"pessoa.irEditarProfissional\">\n");
      out.write("                <input type=\"hidden\" name=\"cpf\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getCpf()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \n");
      out.write("                <input type=\"hidden\" name=\"idPessoa\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pessoa.getIdPessoa()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> \n");
      out.write("                <input type=\"submit\" class=\"inputSubmit\" style=\"width:150px;\" value=\"Editar profissional\">\n");
      out.write("            </form>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        <div class=\"headerRight\">\n");
        out.write("            ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("            <form name=\"logout\" method=\"post\" action=\"FrontController\">\n");
        out.write("                <input type=\"hidden\" name=\"command\" value=\"user.logout\"/>\n");
        out.write("                <input type=\"submit\" name=\"Sair\" value=\"Sair\"/> \n");
        out.write("            </form>\n");
        out.write("        </div>\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
