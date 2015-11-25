<%-- 
    Document   : index
    Created on : 12/10/2015, 10:30:23
    Author     : Hugo Keniti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Login | Sistema</title>
    </head>
    <body>
            <c:if test="${codeInsert != null}">
                <c:choose>
                    <c:when test="${codeInsert == 1}">
                        <script>
                            alert("Usuário inserido com sucesso");
                        </script>
                    </c:when>
                </c:choose>
            </c:if>
                <section class="sectionLogin">
                    <h1>Login</h1><br>
                    <form name="login" method="post" action="FrontController">
                        <input type="hidden" name="command" value="user.login">
                        Usuário:<br>
                        <input type="text" name="username" placeholder="username" value="${cookie.user.value}" required /><br>
                        Senha:<br>
                        <input type="password" name="password" placeholder="password" value="${cookie.password.value}"required />
                        </br>
                            <input style="width: auto" type="checkbox" name="salvarSenha" value="true"> Salvar senha</input><br /><br />
                        <p>
                            <a class="inputButton" style="float: left;text-decoration: none;text-align:center;" href="signUp.jsp">Cadastre-se</a>
                        </p>
                        <input type="submit" class="inputSubmit" value="Entrar">
                        <c:if test="${!validaCampo.equals('')}">
                            <c:choose>
                                <c:when test="${validaCampo.equals('-1')}">
                                    <script>alert("Seu usuário não foi encontrado, tente novamente.");</script>
                                    <c:set var="validaCampo" value="" scope="session"></c:set>
                                </c:when>
                                <c:when test="${validaCampo.equals('-2')}">
                                    <script>alert("Sua senha está incorreta, tente novamente.");</script>
                                    <c:set var="validaCampo" value="" scope="session"></c:set>
                                </c:when>
                            </c:choose>
                        </c:if>
                    </form>
                </section>
            
        </body>
    </html>
