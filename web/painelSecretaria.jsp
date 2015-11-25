<%-- 
    Document   : painelSecretaria
    Created on : 23/11/2015, 17:46:01
    Author     : 41404998
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Home | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Seja bem vindo ${user.getUsername()}</h1>
            <br />

            <nav class="sectionCenter">
                <ul>
                    <a class="inputButton" href="cadastroPessoa_01.jsp"><li>Adicionar Cadastro</li></a>
                    <a class="inputButton" href="verPessoas.jsp" ><li>Editar Cadastros</li></a>
                    <a class="inputButton" href="cadastroConsulta.jsp"><li>Adicionar Consulta</li></a>
                    <a class="inputButton" href="cadastroProcedimento.jsp"><li>Adicionar Procedimento</li></a>
                </ul>
            </nav>
            <br />

        </div>
    </body>
</html>