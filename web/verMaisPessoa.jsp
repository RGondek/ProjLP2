<%-- 
    Document   : pessoa
    Created on : 01/11/2015, 20:15:18
    Author     : Isabela
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style/mainStyle.css">
        <title>Ver cadastros | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Informações pessoais</h1><br>
            <form action="FrontController" method="POST" name="pessoaVerMais">
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}" disabled>
                Nome Completo:<br>
                <input type="text" name="nome" value="${pessoa.getNome()}" disabled pattern="[A-Za-z\s]{2,}" title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"disabled/><br>
                RG:<br>
                <input type="text" name="rg" value="${pessoa.getRg()}" pattern="[0-9]{6,}" title="Somente números permitidos, no mínimo 6 dígitos" disabled/><br>
                CPF:<br>
                <input type="text" name="cpf" value="${pessoa.getCpf()}" pattern="[0-9]{11}" title="Somente números são permitidos, exatamente 11 caracteres." disabled/><br>
                <h4>Informações pessoais</h4>
                Sexo:<br>
                <input type="text" name="sexo" value="${pessoa.getSexo()}" disabled/><br>
                Data de Nascimento:<br>
                <input type="date" name="dataNascimento" value="${pessoa.getDataNascimento()}" disabled/><br>
                Nacionalidade:<br>
                <input type="text" name="nacionalidade" value="${pessoa.getNacionalidade()}" pattern="[A-Za-z\s]{4,}" title="Somente letras são permitidas, no mínimo 4 caracteres" disabled/><br>
                Estado Civil:</br>
                <input type="text" name="estadoCivil" value="${pessoa.getEstadoCivil()}" disabled/><br>
                
                <br><h4>Endereço</h4>                
                Rua:<br>
                <input type="text" name="rua" value="${pessoa.getRua()}" disabled pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Bairro:<br>
                <input type="text" name="bairro" value="${pessoa.getBairro()}" disabled pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Complemento:<br>
                <input type="text" name="complemento" value="${pessoa.getComplemento()}"  /><br>
                Número:<br>
                <input type="text" name="numero" value="${pessoa.getNumero()}" disabled /><br>
                Cidade:<br>
                <input type="text" name="cidade" value="${pessoa.getCidade()}" disabled pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                CEP:<br>
                <input type="text" name="cep" value="${pessoa.getCep()}" disabled/><br>
                Estado:<br> 
                <input type="text" name="sexo" value="${pessoa.getEstado()}" disabled/><br>
                País:<br>
                <input type="text" name="pais" value="${pessoa.getPais()}" disabled pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                <br><h4>Contato</h4> 
                Telefone:<br>
                <input type="text" name="telefone" value="${pessoa.getTelefone()}" disabled pattern="[0-9]{10}" title="Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos" /><br>
                Celular:<br>
                <input type="text" name="celular" value="${pessoa.getCelular()}" pattern="[0-9]{10,}" disabled title="Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos" /><br>
            </form>
                <br/><br/><br/><br /><br />
                
                <h1>Ver o perfil do ${pessoa.getNome()} de:</h1>
            <form action="FrontController" method="POST" name="pessoaVerMaisPaciente">
                <input type="hidden" name="command" value="paciente.verMais">
                <input type="hidden" name="cpf" value="${pessoa.getCpf()}"> 
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}">   
                <input type="submit" class="inputSubmit" style="width:150px;float:left;margin-right: 20px;" value="Paciente">
            </form>  

            <form action="FrontController" method="POST" name="pessoaVerMaisPaciente">
                <input type="hidden" name="command" value="profissional.verMais">
                <input type="hidden" name="cpf" value="${pessoa.getCpf()}"> 
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}"> 
                <input type="submit" class="inputSubmit" style="width:150px;float:left;" value="Profissional">
            </form>
        </div>
    </body>
</html>
