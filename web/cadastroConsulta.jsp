<%-- 
    Document   : cadastroConsulta
    Created on : 11/11/2015, 09:54:20
    Author     : 31411525
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Adicionar Consulta | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <c:if test="${pacientes == null || profissionais == null || procedimentos == null}">
            <h1> ENTROU </h1>
            <c:redirect url="FrontController?command=init.consulta"></c:redirect>
        </c:if>
        <div id="content">
            <h1>Adicionar Consulta</h1><br>
            <form action="FrontController" method="GET" name="cadastroConsulta">
                <input type="hidden" name="command" value="consulta.create">
                Paciente:<br>
                <select name="selectPaciente" class="inputSelect">
                    <c:forEach items="${pacientes}" var="pac">
                        <option value="${pac.getIdPaciente()}">${pac.getPessoa().getNome()}</option> 
                    </c:forEach>
                </select><br />
                Profissional:<br />
                <select name="selectProfissional" class="inputSelect">
                    <c:forEach items="${profissionais}" var="prof">
                        <option value="${prof.getIdProfissional()}">${prof.getPessoa().getNome()}</option> 
                    </c:forEach>
                </select>
                <br />
                Data:<br />
                <input type="date" name="data" placeholder="12345678910" pattern="[0-9]{15}" title="Somente números são permitidos, exatamente 11 caracteres." required/><br>
                Selecione os procedimentos da consulta: <br />
                <br />
                <c:forEach items="${procedimentos}" var="proc">
                    <input style="width: auto" name="procedures" type="checkbox" value="${proc.getIdProcedimento()}"> ${proc.getNomeProcedimento()} - ${proc.getValor()}</input><br />
                </c:forEach>
                <input type="submit" class="inputSubmit" value="Adicionar">
            </form>

        </div>
    </body>
</html>

