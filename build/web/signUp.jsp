<%-- 
    Document   : signUp
    Created on : 23/11/2015, 19:26:38
    Author     : 41404998
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title> Cadastro de usuário</title>
    </head>
    <body>
        <div class="sectionLogin">
            <c:if test="${codeInsert != null}">
                <c:choose>
                    <c:when test="${codeInsert == -3 }">
                        <script>
                            alert("Usuário já existe");
                        </script>
                    </c:when>
                    <c:when test="${codeInsert == -5}">
                        <script>
                            alert("Usuário não inserido");
                        </script>
                    </c:when>
                    <c:when test="${codeInsert == -4}">
                        <script>
                            alert("Senhas não conferem");
                        </script>
                    </c:when>

                </c:choose>
            </c:if>
            <form name="cadastroUsuario" method="Post" action="FrontController">

                <input type="hidden" name="command" value="user.cadastro">
                <p> Nome de usuário: <input type="text" required placeholder="Nome de Usuário" name="username"/> </p>
                <p> Senha: <input type="password" required placeholder="Senha" name="password"/> </p>
                <p> Confirme a Senha: <input type="password" required placeholder="Repita a senha" name="password2"/> </p>
                <p>
                    Criar perfil como: <select class="inputSelect" name="tipoUsuario">
                        <option value="1"> Secretária </option>
                        <option value="2"> Médico </option>
                    </select>
                </p>
                <p> <input type="submit" value="Cadastrar" /> </p>
            </form>
        </div>
    </body>

</html>
