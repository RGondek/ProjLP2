<%-- 
    Document   : editarProcedimento
    Created on : Nov 25, 2015, 3:24:18 AM
    Author     : gondekr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Editar Procedimento | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Editar Procedimento</h1><br>
            <form action="FrontController" method="POST" name="procedimentoEdit">
                <input type="hidden" name="command" value="procedimento.save">
                <input type="hidden" name="idProcedimento" value="${idProcedimento}">
                Nome do procedimento:<br>
                <input type="text" name="nome" placeholder="Exemplo: Remoção de tártaro" required title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                Valor do procedimento:<br>
                <input type="text" name="valor" placeholder="Exemplo: 99,90" pattern="[0-9]{0,}" title="Somente números permitidos, no mínimo 6 dígitos"required/><br>
                <input type="submit" class="inputSubmit" value="Salvar">
            </form>
            
        </div>
    </body>
</html>
