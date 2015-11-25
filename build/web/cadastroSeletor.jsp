<%-- 
    Document   : cadastroSeletor
    Created on : Nov 2, 2015, 7:28:42 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Adicionar Perfil</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>O ${nome} é um:</h1><br>
            <section class="sectionCenter">
                <form action="FrontController" method="POST" name="cadastroSeletor">
                    <input type="hidden" name="command" value="seletor.paciente">
                    <input type="hidden" name="idPessoa" value="${idPessoa}">
                    <input type="submit" class="inputButton" value="Paciente">
                </form>
                <form action="FrontController" method="POST" name="cadastroSeletor">
                    <input type="hidden" name="command" value="seletor.profissional">
                    <input type="hidden" name="idPessoa" value="${idPessoa}">
                    <input type="submit" class="inputButton" value="Profissional">
                </form>
            </section>
        </div>
    </body>
</html>
