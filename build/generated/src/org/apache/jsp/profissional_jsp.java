package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profissional_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_redirect_url_nobody.release();
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
      out.write("        <title>Profissional</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>CREATE</h1>\n");
      out.write("        <form action=\"FrontController\" method=\"POST\" name=\"profissionalCreate\">\n");
      out.write("            <p>Informações pessoais:</p>\n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"profissional.create\">\n");
      out.write("            <p> Nome Completo: <input type=\"text\" name=\"nome\" placeholder=\"Nome\" required pattern=\"[A-Za-z\\s]{2,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres\"/></p>\n");
      out.write("            <p>Endereço: <input type=\"text\" name=\"endereco\" placeholder=\"Endereço\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /></p>\n");
      out.write("            <p> Data de Nascimento: <input type=\"date\" name=\"dataNascimento\" placeholder=\"Data de Nascimento\" required/></p>\n");
      out.write("            <p>Telefone: <input type=\"text\" name=\"telefone\" placeholder=\"Ex: 1144536651\"  required pattern=\"[0-9]{10}\" title=\"Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos\" /></p>\n");
      out.write("            <p>Celular: <input type=\"text\" name=\"celular\" placeholder=\"Ex: 11982785986\" pattern=\"[0-9]{10,}\" required title=\"Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos\" /> </p>\n");
      out.write("            <p>Profissão: <input type=\"text\" name=\"profissao\" placeholder=\"Profissão\"   pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/></p>\n");
      out.write("            <p> Sexo: <select required name=\"sexo\" >\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"feminino\">Feminino</option>\n");
      out.write("                    <option value=\"masculino\">Masculino</option>\n");
      out.write("                </select></p>\n");
      out.write("            <p>Nacionalidade:<input type=\"text\" name=\"nacionalidade\" placeholder=\"Nacionalidade\" pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/></p>\n");
      out.write("            <p>RG: <input type=\"text\" name=\"rg\" placeholder=\"123456\" pattern=\"[0-9]{6,}\" title=\"Somente números permitidos, no mínimo 6 dígitos\"required/></p>\n");
      out.write("            <p>CPF: <input type=\"text\" name=\"cpf\" placeholder=\"12345678910\" pattern=\"[0-9]{11}\" title=\"Somente números são permitidos, exatamente 11 caracteres.\" required/></p>\n");
      out.write("            <p>Estado Civil:<select required name=\"estadoCivil\">\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"solteiro\">Solteiro(a)</option>\n");
      out.write("                    <option value=\"casado\">Casado(a)</option>\n");
      out.write("                    <option value=\"divorciado\">Divorciado(a)</option>\n");
      out.write("                    <option value=\"viuvo\">Viúvo(a)</option>\n");
      out.write("                </select></p>\n");
      out.write("            <p>Informações profissionais:</p>\n");
      out.write("            <p>Formação: <input type=\"text\" name=\"formacao\" placeholder=\"Formação\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\"required/></p>\n");
      out.write("            <p>Especialidade: <input type=\"text\" name=\"especialidade\" placeholder=\"Especialidade\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\" required/></p>\n");
      out.write("            <p>Registro Profissional:<input type=\"text\" name=\"registroProfissional\" placeholder=\"Registro do Profissional\" pattern=\"{6,}\" title=\"Letras, números e caracteres especiais são permitidos, no mínimo 6 caracteres\" required/></p>\n");
      out.write("            <p><input type=\"submit\" value=\"Criar\"></p>\n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        <h1>UPDATE</h1>\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"profissional.update\">\n");
      out.write("            <select name=\"profissionalSelecionado\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <p>Informações pessoais:</p>\n");
      out.write("            <p> Nome Completo: <input type=\"text\" name=\"nomeUpdate\" placeholder=\"Nome\" required pattern=\"[A-Za-z\\s]{2,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres\"/></p>\n");
      out.write("            <p>Endereço: <input type=\"text\" name=\"enderecoUpdate\" placeholder=\"Endereço\" required pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres\" /></p>\n");
      out.write("            <p> Data de Nascimento: <input type=\"date\" name=\"dataNascimentoUpdate\" placeholder=\"Data de Nascimento\" required/></p>\n");
      out.write("            <p>Telefone: <input type=\"text\" name=\"telefoneUpdate\" placeholder=\"Ex: 1144536651\"  required pattern=\"[0-9]{10}\" title=\"Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos\" /></p>\n");
      out.write("            <p>Celular: <input type=\"text\" name=\"celularUpdate\" placeholder=\"Ex: 11982785986\" pattern=\"[0-9]{10,}\" required title=\"Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos\" /> </p>\n");
      out.write("            <p>Profissão: <input type=\"text\" name=\"profissaoUpdate\" placeholder=\"Profissão\"   pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/></p>\n");
      out.write("            <p> Sexo: <select required name=\"sexoUpdate\" >\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"feminino\">Feminino</option>\n");
      out.write("                    <option value=\"masculino\">Masculino</option>\n");
      out.write("                </select></p>\n");
      out.write("            <p>Nacionalidade:<input type=\"text\" name=\"nacionalidadeUpdate\" placeholder=\"Nacionalidade\" pattern=\"[A-Za-z\\s]{4,}\" title=\"Somente letras são permitidas, no mínimo 4 caracteres\" required/></p>\n");
      out.write("            <p>RG: <input type=\"text\" name=\"rgUpdate\" placeholder=\"123456\" pattern=\"[0-9]{6,}\" title=\"Somente números permitidos, no mínimo 6 dígitos\"required/></p>\n");
      out.write("            <p>CPF: <input type=\"text\" name=\"cpfUpdate\" placeholder=\"12345678910\" pattern=\"[0-9]{11}\" title=\"Somente números são permitidos, exatamente 11 caracteres.\" required/></p>\n");
      out.write("            <p>Estado Civil:<select required name=\"estadoCivilUpdate\">\n");
      out.write("                    <option value=\"\"> </option>\n");
      out.write("                    <option value=\"solteiro\">Solteiro(a)</option>\n");
      out.write("                    <option value=\"casado\">Casado(a)</option>\n");
      out.write("                    <option value=\"divorciado\">Divorciado(a)</option>\n");
      out.write("                    <option value=\"viuvo\">Viúvo(a)</option>\n");
      out.write("                </select></p>\n");
      out.write("            <p>Informações profissionais:</p>\n");
      out.write("            <p>Formação: <input type=\"text\" name=\"formacaoUpdate\" placeholder=\"Formação\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\"required/></p>\n");
      out.write("            <p>Especialidade: <input type=\"text\" name=\"especialidadeUpdate\" placeholder=\"Especialidade\" pattern=\"[A-Za-z\\s]{6,}\" title=\"Somente letras, no mínimo 6 caracteres\" required/></p>\n");
      out.write("            <p>Registro Profissional:<input type=\"text\" name=\"registroProfissionalUpdate\" placeholder=\"Registro do Profissional\" pattern=\"{6,}\" title=\"Letras, números e caracteres especiais são permitidos, no mínimo 6 caracteres\" required/></p>\n");
      out.write("            <p><input type=\"submit\" value=\"Atualizar\"></p>\n");
      out.write("        </form>\n");
      out.write("        <h1>DELETE</h1>\n");
      out.write("        <form>\n");
      out.write("            <input type=\"hidden\" name=\"command\" value=\"profissional.delete\">\n");
      out.write("            <select name=\"profissionalParaRemover\">\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <p><input type=\"submit\" value=\"Remover\"></p>\n");
      out.write("        </form>\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profissionaisLista == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("         ");
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

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("FrontController?command=profissional.read");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("col");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profissionaisLista}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getIdProfissional()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getPessoa().getNome()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("col");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profissionaisLista}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getIdProfissional()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${col.getPessoa().getNome()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
