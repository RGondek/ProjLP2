<%-- 
    Document   : cadastroProcedimento
    Created on : Nov 24, 2015, 3:39:28 AM
    Author     : gondekr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Adicionar Procedimento | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Adicionar Procedimento</h1><br>
            <form action="FrontController" method="POST" name="procedimentoCreate">
                <input type="hidden" name="command" value="procedimento.create">
                Nome do procedimento:<br>
                <input type="text" name="nome" placeholder="Exemplo: Remoção de tártaro" required title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                Valor do procedimento:<br>
                <input type="text" name="valor" placeholder="Exemplo: 99.90" required/><br>
                <input type="submit" class="inputSubmit" value="Concluir">
            </form>
            
        </div>
    </body>
</html>