<%-- 
    Document   : cadastroPaciente
    Created on : Nov 2, 2015, 7:57:54 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Adicionar Paciente | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Adicionar Paciente</h1><br>
            <form action="FrontController" method="POST" name="cadastroPaciente">
                <input type="hidden" name="command" value="paciente.create">
                <input type="hidden" name="idPessoa" value="${idPessoa}">
                Nome da mãe:<br>
                <input type="text" name="nomeMae" placeholder="Exemplo: Maria Josefina" required pattern="[A-Za-z\s]{2,}" title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                CPF da mãe:<br>
                <input type="text" name="cpfMae" placeholder="Exemplo: 11122233344" pattern="[0-9]{11}" title="Somente números são permitidos, exatamente 11 caracteres." required/><br>
                <input type="submit" class="inputSubmit" value="Adicionar">
            </form>

        </div>
    </body>
</html>
