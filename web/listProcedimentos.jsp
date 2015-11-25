<%-- 
    Document   : listProcedimentos
    Created on : Nov 25, 2015, 3:08:09 AM
    Author     : gondekr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Procedimentos | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <c:if test="${procs == null}">
            <c:redirect url="FrontController?command=procedimento.read"></c:redirect>
        </c:if>
            <div id="content">
                <h1>Todos os Procedimentos </h1><br />
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr> 
                <c:forEach items="${procs}" var="p">
                    <tr>
                        <td>${p.getNomeProcedimento()}</td>
                        <td>${p.getValor()}</td>
                        <td><a href="FrontController?command=procedimento.${p.getIdProcedimento()}.edit">Edit</a></td>
                        <td><a href="FrontController?command=procedimento.${p.getIdProcedimento()}.delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
