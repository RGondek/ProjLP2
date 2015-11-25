package com.br.projetoLp2.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.br.projetoLp2.business.*;
import com.br.projetoLp2.model.*;
import com.br.projetoLp2.model.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 41406133
 */
public class FrontController extends HttpServlet {

    private String command;
    private int code;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet FrontController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet FrontController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");

            // Fazer só na pagina de cadastro de consulta
            if (command.startsWith("init")) {
                if (command.endsWith("consulta")) {
                    List<Paciente> pacientes = PacienteManager.read();
                    request.getSession().setAttribute("pacientes", pacientes);

                    List<Profissional> profs = ProfissionalManager.read();
                    request.getSession().setAttribute("profissionais", profs);

                    List<Procedimento> procs = ProcedimentoManager.readDefault();
                    request.getSession().setAttribute("procedimentos", procs);

                    System.out.println(procs);

                    RequestDispatcher rd = request.getRequestDispatcher("/cadastroConsulta.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("consultaEdit")) {
                    List<Paciente> pacientes = PacienteManager.read();
                    request.getSession().setAttribute("pacientes", pacientes);

                    List<Profissional> profs = ProfissionalManager.read();
                    request.getSession().setAttribute("profissionais", profs);

                    List<Procedimento> procs = ProcedimentoManager.readDefault();
                    request.getSession().setAttribute("procedimentos", procs);

                    RequestDispatcher rd = request.getRequestDispatcher("/editarConsulta.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("verPessoas")) {
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    RequestDispatcher rd = request.getRequestDispatcher("/verPessoas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("listPessoas")) {
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    RequestDispatcher rd = request.getRequestDispatcher("/listPessoas.jsp");
                    rd.forward(request, response);
                }
            }

            if (command.startsWith("user")) {
                if (command.endsWith("login")) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String salvar = request.getParameter("salvarSenha");
                    if (salvar == null) {
                        salvar = "false";
                    } else if (salvar.equals("true")) {
                        Cookie pass = new Cookie("password", password);
                        Cookie user = new Cookie("user", username);
                        user.setMaxAge(60 * 60 * 24 * 7);
                        pass.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(pass);
                        response.addCookie(user);
                    }
                    if (salvar.equals("false")) {

                        Cookie pass = new Cookie("password", "");
                        Cookie user = new Cookie("user", "");
                        user.setMaxAge(60 * 60 * 24 * 7);
                        pass.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(pass);
                        response.addCookie(user);
                    }

                    code = UserManager.authorize(username, password);
                    if (code == -1) {
                        request.getSession().setAttribute("validaCampo", "-1");
                        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    } else if (code == -2) {
                        request.getSession().setAttribute("validaCampo", "-2");
                        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    } else if (code == 1) {
                        request.getSession().setAttribute("user", UserManager.getUser());
                        RequestDispatcher rd = request.getRequestDispatcher("/painel.jsp");
                        rd.forward(request, response);
                    } else {
                        request.getSession().setAttribute("code", code);
                        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    }
                } else if (command.endsWith("logout")) {
                    request.getSession().invalidate();
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } else if (command.endsWith("cadastro")) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String password2 = request.getParameter("password2");
                    int tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
                    User user = new User(username, password, tipoUsuario);
                    int codeInsert = UserManager.insert(user, password2);
                    request.getSession().setAttribute("codeInsert", codeInsert);
                    if (codeInsert == 1) {
                        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                        rd.forward(request, response);
                    } else {
                        RequestDispatcher rd = request.getRequestDispatcher("/signUp.jsp");
                        rd.forward(request, response);
                    }
                }

            }

            if (command.startsWith("procedimento")) {
                if (command.endsWith("create")) {
                    Procedimento proc = new Procedimento(
                            request.getParameter("nome"), Double.parseDouble(request.getParameter("valor"))
                    );
                    ProcedimentoManager.insertDefault(proc);
                    RequestDispatcher rd = request.getRequestDispatcher("/painelSecretaria.jsp");
                    rd.forward(request, response);
                } else if (command.endsWith("read")) {
                    List<Procedimento> procs = ProcedimentoManager.readDefault();
                    request.getSession().setAttribute("procs", procs);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/listProcedimentos.jsp");
                    rd.forward(request, response);
                } else if (command.endsWith("edit")) {
                    String cm = command;
                    String re = "";
                    int count = 0;
                    for (int i = 0; i < cm.length(); i++) {
                        if (cm.charAt(i) == '.') {
                            if (count >= 1) {
                                break;
                            } else {
                                re = "";
                                count++;
                            }
                        } else {
                            re += cm.charAt(i);
                        }
                    }
                    int index = Integer.parseInt(re);
                    request.getSession().setAttribute("idProcedimento", index);
                    RequestDispatcher rd = request.getRequestDispatcher("/editarProcedimento.jsp");
                    rd.forward(request, response);
                } else if (command.endsWith("delete")) {
                    String cm = command;
                    String re = "";
                    int count = 0;
                    for (int i = 0; i < cm.length(); i++) {
                        if (cm.charAt(i) == '.') {
                            if (count >= 1) {
                                break;
                            } else {
                                re = "";
                                count++;
                            }
                        } else {
                            re += cm.charAt(i);
                        }
                    }
                    System.out.println(re);
                    ProcedimentoManager.deleteDefault(Integer.parseInt(re));
                    request.getSession().setAttribute("procs", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/listProcedimentos.jsp");
                    rd.forward(request, response);
                } else if (command.endsWith("save")) {
                    Procedimento proc = new Procedimento(
                            request.getParameter("nome"), Double.parseDouble(request.getParameter("valor"))
                    );
                    ProcedimentoManager.update(proc, Integer.parseInt(request.getParameter("idProcedimento")));
                    request.getSession().setAttribute("procs", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/listProcedimentos.jsp");
                    rd.forward(request, response);
                }
            } else if (command.startsWith("pessoa")) {
                if (command.endsWith("create_01")) {
                    request.setAttribute("nome", request.getParameter("nome"));
                    request.setAttribute("cpf", request.getParameter("cpf"));
                    request.setAttribute("rg", request.getParameter("rg"));
                    Pessoa pessoa = PessoaManager.readByCpf(request.getParameter("cpf"));
                    if (pessoa == null) {
                        RequestDispatcher rd = request.getRequestDispatcher("/cadastroPessoa_02.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("idPessoa", pessoa.getIdPessoa());
                        RequestDispatcher rd = request.getRequestDispatcher("/cadastroSeletor.jsp");
                        rd.forward(request, response);
                    }
                }
                if (command.endsWith("create_02")) {
                    request.setAttribute("nome", request.getParameter("nome"));
                    String data = request.getParameter("dataNascimento");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sdf.parse(data);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Pessoa pessoa = new Pessoa(
                            request.getParameter("nome"), request.getParameter("rua"),
                            request.getParameter("bairro"), request.getParameter("complemento"),
                            Integer.parseInt(request.getParameter("numero")), request.getParameter("cep"),
                            request.getParameter("cidade"), request.getParameter("estado"),
                            request.getParameter("pais"), birthday, Long.parseLong(request.getParameter("telefone")),
                            Long.parseLong(request.getParameter("celular")), request.getParameter("sexo"),
                            request.getParameter("nacionalidade"), request.getParameter("rg"),
                            request.getParameter("cpf"), request.getParameter("estadoCivil")
                    );
                    if (PessoaManager.insert(pessoa) == 1) {
                        request.setAttribute("idPessoa", PessoaManager.readByCpf(pessoa.getCpf()).getIdPessoa());
                        request.getSession().setAttribute("pessoass", null);
                        RequestDispatcher rd = request.getRequestDispatcher("/cadastroSeletor.jsp");
                        rd.forward(request, response);
                    } else {
                        out.println("Deu ruim");
                    }

                }
                if (command.endsWith("irEditar")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    RequestDispatcher rd = request.getRequestDispatcher("/editarPessoa.jsp");
                    rd.forward(request, response);
                }

                if (command.endsWith("editar")) {
                    request.setAttribute("nome", request.getParameter("nome"));
                    String data = request.getParameter("dataNascimento");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday = null;
                    try {
                        birthday = sdf.parse(data);
                    } catch (ParseException ex) {
                        Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Pessoa pessoa = new Pessoa(
                            Integer.parseInt(request.getParameter("idPessoa")), request.getParameter("nome"), request.getParameter("rua"),
                            request.getParameter("bairro"), request.getParameter("complemento"),
                            Integer.parseInt(request.getParameter("numero")), request.getParameter("cep"),
                            request.getParameter("cidade"), request.getParameter("estado"),
                            request.getParameter("pais"), birthday, Long.parseLong(request.getParameter("telefone")),
                            Long.parseLong(request.getParameter("celular")), request.getParameter("sexo"),
                            request.getParameter("nacionalidade"), request.getParameter("rg"),
                            request.getParameter("cpf"), request.getParameter("estadoCivil")
                    );
                    PessoaManager.update(pessoa);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/verPessoas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("excluir")) {
                    int id = Integer.parseInt(request.getParameter("idPessoa"));
                    Profissional profissional = ProfissionalManager.readByIdPessoa(id);
                    System.out.println("Profissional: " + profissional);
                    if (profissional != null) {
                        ConsultaManager.deleteAllProfissional(profissional.getIdProfissional());
                        ProfissionalManager.delete(profissional.getIdProfissional());
                    }
                    Paciente paciente = PacienteManager.readByIdPessoa(id);
                    System.out.println("Paciente: " + paciente);
                    if (paciente != null) {
                        ConsultaManager.deleteAllPaciente(paciente.getIdPaciente());
                        PacienteManager.delete(paciente.getIdPaciente());
                    }
                    PessoaManager.delete(id);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/verPessoas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("verMais")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    RequestDispatcher rd = request.getRequestDispatcher("/verMaisPessoa.jsp");
                    rd.forward(request, response);
                }

            }

            if (command.startsWith("seletor")) {
                if (command.endsWith("paciente")) {
                    request.setAttribute("idPessoa", request.getParameter("idPessoa"));
                    RequestDispatcher rd = request.getRequestDispatcher("/cadastroPaciente.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("profissional")) {
                    request.setAttribute("idPessoa", request.getParameter("idPessoa"));
                    RequestDispatcher rd = request.getRequestDispatcher("/cadastroProfissional.jsp");
                    rd.forward(request, response);
                }
            }

            if (command.startsWith("profissional")) {
                if (command.endsWith("create")) {
                    Profissional profissional = new Profissional(
                            request.getParameter("formacao"), request.getParameter("especialidade"),
                            request.getParameter("registroProfissional"), PessoaManager.readById(Integer.parseInt(request.getParameter("idPessoa")))
                    );
                    ProfissionalManager.insert(profissional);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/painelSecretaria.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("editar")) {
                    Profissional profissional = new Profissional(
                            request.getParameter("formacao"), request.getParameter("especialidade"),
                            request.getParameter("registroProfissional"), PessoaManager.readById(Integer.parseInt(request.getParameter("idPessoa")))
                    );
                    ProfissionalManager.update(Integer.parseInt(request.getParameter("idProfissional")), profissional);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/verPessoas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("read")) {
                    int idPessoal = Integer.parseInt(request.getParameter("idPessoa"));
                }
                if (command.endsWith("verMais")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    request.getSession().setAttribute("profissional", ProfissionalManager.readByIdPessoa(Integer.parseInt(request.getParameter("idPessoa"))));
                    RequestDispatcher rd = request.getRequestDispatcher("/verMaisProfissional.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("irEditar")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    request.getSession().setAttribute("profissional", ProfissionalManager.readByIdPessoa(Integer.parseInt(request.getParameter("idPessoa"))));
                    RequestDispatcher rd = request.getRequestDispatcher("/editarProfissional.jsp");
                    rd.forward(request, response);
                }

            } else if (command.startsWith("paciente")) {
                if (command.endsWith("create")) {
                    Paciente paciente = new Paciente(
                            request.getParameter("nomeMae"), request.getParameter("cpfMae"),
                            PessoaManager.readById(Integer.parseInt(request.getParameter("idPessoa")))
                    );
                    PacienteManager.insert(paciente);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/painelSecretaria.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("editar")) {
                    Paciente paciente = new Paciente(
                            Integer.parseInt(request.getParameter("idPaciente")), request.getParameter("nomeMae"), request.getParameter("cpfMae"),
                            PessoaManager.readById(Integer.parseInt(request.getParameter("idPessoa")))
                    );
                    PacienteManager.update(paciente);
                    request.getSession().setAttribute("pessoass", null);
                    request.getSession().setAttribute("pacientes", null);
                    request.getSession().setAttribute("profissionais", null);
                    request.getSession().setAttribute("procedimentos", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/verPessoas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("verMais")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    request.getSession().setAttribute("paciente", PacienteManager.readByIdPessoa(Integer.parseInt(request.getParameter("idPessoa"))));
                    RequestDispatcher rd = request.getRequestDispatcher("/verMaisPaciente.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("irEditar")) {
                    String cpf = request.getParameter("cpf");
                    Pessoa pessoa = PessoaManager.readByCpf(cpf);
                    request.setAttribute("pessoa", pessoa);
                    List<Pessoa> pess = PessoaManager.read();
                    request.getSession().setAttribute("pessoass", pess);
                    request.getSession().setAttribute("paciente", PacienteManager.readByIdPessoa(Integer.parseInt(request.getParameter("idPessoa"))));
                    RequestDispatcher rd = request.getRequestDispatcher("/editarPaciente.jsp");
                    rd.forward(request, response);
                }
            } else if (command.startsWith("consulta")) {
                if(command.endsWith("delete")){
                    // TODO - Por algum motivo o split Não funciona
                    String cm = command;
                    String re = "";
                    int count = 0;
                    for (int i = 0; i < cm.length(); i++) {
                        if (cm.charAt(i) == '.') {
                            if (count >= 1) {
                                break;
                            } else {
                                re = "";
                                count++;
                            }
                        } else {
                            re += cm.charAt(i);
                        }
                    }
                    int index = Integer.parseInt(re);
                    ConsultaManager.delete(index);
                    request.getSession().setAttribute("consultas", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/listConsultas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("create")) {
                    Paciente paciente = PacienteManager.readById(Integer.parseInt(request.getParameter("selectPaciente")));
                    Profissional prof = ProfissionalManager.readById(Integer.parseInt(request.getParameter("selectProfissional")));
                    String[] idsProc = request.getParameterValues("procedures");
                    System.out.println(request.getParameterValues("procedures"));
                    System.out.println(Arrays.toString(idsProc));
                    System.out.println(paciente);
                    System.out.println(prof);
                    System.out.println("\n\n\n\n\n");
                    List<Procedimento> procs = new ArrayList<>();
                    for (String id : idsProc) {
                        procs.add(ProcedimentoManager.readDefaultById(Integer.parseInt(id)));
                    }
                    System.out.println(procs);
                    String data = request.getParameter("data");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dtConsulta = null;
                    try {
                        dtConsulta = sdf.parse(data);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    double valor = 0;
                    for (Procedimento p : procs) {
                        if (p != null) {
                            valor += p.getValor();
                        }
                    }
                    Consulta consulta = new Consulta(dtConsulta, valor, paciente, prof, procs);
                    ConsultaManager.insert(consulta);
                    RequestDispatcher rd = request.getRequestDispatcher("/painelSecretaria.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("read")) {
                    List<Consulta> cons = ConsultaManager.read();
                    request.getSession().setAttribute("consultas", cons);
                    RequestDispatcher rd = request.getRequestDispatcher("/listConsultas.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("edit")) {

                    // TODO - Por algum motivo o split Não funciona
                    String cm = command;
                    String re = "";
                    int count = 0;
                    for (int i = 0; i < cm.length(); i++) {
                        if (cm.charAt(i) == '.') {
                            if (count >= 1) {
                                break;
                            } else {
                                re = "";
                                count++;
                            }
                        } else {
                            re += cm.charAt(i);
                        }
                    }
                    int index = Integer.parseInt(re);
                    request.getSession().setAttribute("idConsulta", index);
                    RequestDispatcher rd = request.getRequestDispatcher("/editarConsulta.jsp");
                    rd.forward(request, response);
                }
                if (command.endsWith("save")) {
                    Paciente paciente = PacienteManager.readById(Integer.parseInt(request.getParameter("selectPaciente")));
                    Profissional prof = ProfissionalManager.readById(Integer.parseInt(request.getParameter("selectProfissional")));
                    String[] idsProc = request.getParameterValues("procedures");
                    System.out.println(request.getParameterValues("procedures"));
                    System.out.println(Arrays.toString(idsProc));
                    System.out.println(paciente);
                    System.out.println(prof);
                    System.out.println("\n\n\n\n\n");
                    List<Procedimento> procs = new ArrayList<>();
                    for (String id : idsProc) {
                        procs.add(ProcedimentoManager.readDefaultById(Integer.parseInt(id)));
                    }
                    System.out.println(procs);
                    String data = request.getParameter("data");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dtConsulta = null;
                    try {
                        dtConsulta = sdf.parse(data);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    double valor = 0;
                    for (Procedimento p : procs) {
                        if (p != null) {
                            valor += p.getValor();
                        }
                    }
                    Consulta consulta = new Consulta(dtConsulta, valor, paciente, prof, procs);

                    ConsultaManager.update(Integer.parseInt(request.getParameter("idConsulta")), consulta);
                    request.getSession().setAttribute("consultas", null);
                    RequestDispatcher rd = request.getRequestDispatcher("/listConsultas.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        command = request.getParameter("command");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        command = request.getParameter("command");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
