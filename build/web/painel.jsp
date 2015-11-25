<%-- 
    Document   : home
    Created on : 21/10/2015, 09:41:28
    Author     : 41406133
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:choose>
                <c:when test="${user.getUserType() == 1}">
                    <c:redirect url="painelSecretaria.jsp"/>
                </c:when>
                <c:when test="${user.getUserType() == 1}">
                    <c:redirect url="painel.jsp"/>
                </c:when>
            </c:choose>
            <h1>Seja bem vindo ${user.getUsername()}</h1>
      
            <nav class="sectionCenter">
                <ul>
                    <a class="inputButton" href="listConsultas.jsp"><li>Consultas</li></a>
                    <a class="inputButton" href="listProcedimentos.jsp"><li>Procedimentos</li></a> 
                    <a class="inputButton" href="listPessoas.jsp"><li>Cadastros</li></a> 
                </ul>
            </nav>
            <br>

        </div>
    </body>
</html>
