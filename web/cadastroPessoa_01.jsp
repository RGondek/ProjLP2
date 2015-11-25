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
        <title>Adicionar Perfil | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Adicionar Perfil</h1><br>
            <form action="FrontController" method="POST" name="pessoaCreate_01">
                <input type="hidden" name="command" value="pessoa.create_01">
                Nome Completo:<br>
                <input type="text" name="nome" placeholder="Exemplo: João da Silva Júnior" required pattern="[A-Za-z\s]{2,}" title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                RG:<br>
                <input type="text" name="rg" placeholder="Exemplo: 112223334" pattern="[0-9]{6,}" title="Somente números permitidos, no mínimo 6 dígitos"required/><br>
                CPF:<br>
                <input type="text" name="cpf" placeholder="Exemplo: 11122233344" pattern="[0-9]{11}" title="Somente números são permitidos, exatamente 11 caracteres." required/><br>
                <input type="submit" class="inputSubmit" value="Próximo">
            </form>
            
        </div>
    </body>
</html>
