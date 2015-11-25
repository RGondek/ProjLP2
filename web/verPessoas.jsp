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
        <title>Editar cadastros | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <c:if test="${pessoass == null}">
            <c:redirect url="FrontController?command=init.verPessoas"></c:redirect>
        </c:if>
            <div id="content">
                <h1>Todos os cadastros: </h1><br />
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Data e Nascimento</th>
                        <th colspan="2">Opções</th>
                    </tr> 
                <c:forEach items="${pessoass}" var="pessoa">
                    <tr>
                        <td>${pessoa.getNome()}</td>
                        <td>${pessoa.getCpf()}</td>
                        <td>${pessoa.getDataNascimento()}</td>
                    <form action="FrontController" method="POST" name="editar${pessoa.getNome()}">
                        <input type="hidden" name="command" value="pessoa.irEditar"/>
                        <input type="hidden" name="cpf" value="${pessoa.getCpf()}"/>
                        <td><input type="submit" value="Editar"/></td>
                    </form>
                    <form action="FrontController" method="POST" name="excluir${pessoa.getNome()}">
                        <input type="hidden" name="command" value="pessoa.excluir"/>
                        <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}"/>
                        <td><input type="submit" value="Excluir"/></td>
                    </form>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
