<%-- 
    Document   : cadastroPaciente
    Created on : Nov 2, 2015, 7:57:54 PM
    Author     : lucas
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Editar Paciente | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Editar Paciente: ${pessoa.getNome()}</h1><br>
            <form action="FrontController" method="POST" name="cadastroPaciente">
                <input type="hidden" name="command" value="paciente.editar">
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}">
                <input type="hidden" name="idPaciente" value="${paciente.getIdPaciente()}">
                Nome da mãe:<br>
                <input type="text" name="nomeMae" value="${paciente.getNomeMae()}" required pattern="[A-Za-z\s]{2,}" title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                CPF da mãe:<br>
                <input type="text" name="cpfMae" value="${paciente.getCpfMae()}" pattern="[0-9]{11}" title="Somente números são permitidos, exatamente 11 caracteres." required/><br>
                <input type="submit" class="inputSubmit" value="Salvar">
            </form>

        </div>
    </body>
</html>
