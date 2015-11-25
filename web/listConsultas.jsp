<%-- 
    Document   : pessoa
    Created on : 01/11/2015, 20:15:18
    Author     : Isabela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Consultas | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <c:if test="${consultas == null}">
            <c:redirect url="FrontController?command=consulta.read"></c:redirect>
        </c:if>
        <div id="content">
            <h1>Todos as consultas </h1><br />
            <table>
                <tr>
                    <th>Data/Hora</th>
                    <th>Paciente</th>
                    <th>Profissional</th>
                    <th>Valor Total</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr> 
                <c:forEach items="${consultas}" var="c">
                    <tr>
                        <td>${c.getDataHora()}</td>
                        <td>${c.getPaciente().getPessoa().getNome()}</td>
                        <td>${c.getProfissional().getPessoa().getNome()}</td>
                        <td>${c.getValorTotal()}</td>
                        <td><a href="FrontController?command=consulta.${c.getIdConsulta()}.edit">Edit</a></td>
                        <td><a href="FrontController?command=consulta.${c.getIdConsulta()}.delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
