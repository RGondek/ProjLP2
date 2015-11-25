<%-- 
    Document   : pessoa
    Created on : 01/11/2015, 20:15:18
    Author     : Isabela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Editar Profissional | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Informações de Profissional do ${pessoa.getNome()}</h1><br>
            <form action="FrontController" method="POST" name="profissionalCreate">
                Formação: <br>
                <input type="text" name="formacao" value="${profissional.getFormacao()}" pattern="[A-Za-z\s]{6,}" title="Somente letras, no mínimo 6 caracteres" disabled/><br>
                Especialidade: <br>
                <input type="text" name="especialidade" value="${profissional.getEspecialidade()}" pattern="[A-Za-z\s]{6,}" title="Somente letras, no mínimo 6 caracteres" disabled/><br>
                Registro Profissional: <br>
                <input type="text" name="registroProfissional"value="${profissional.getRegistroProfissional()}" pattern="{6,}" title="Letras, números e caracteres especiais são permitidos, no mínimo 6 caracteres" disabled/><br>
            </form>

        </div>
    </body>
</html>

<!--        <c:if test="${profissionaisLista == null}">
            <c:redirect url="FrontController?command=profissional.read"></c:redirect>
         </c:if>
        <form>
            <input type="hidden" name="command" value="profissional.update">
            <select name="profissionalSelecionado">
                <c:forEach var="col" items="${profissionaisLista}">
                    <option value="${col.getIdProfissional()}">${col.getPessoa().getNome()}</option>
                </c:forEach>
            </select>-->
