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
        <title>Editar Perfil | Sistema</title>
    </head>
    <body>
        <%@ include file="header.jspf"%>
        <div id="content">
            <h1>Editar Perfil Pessoal</h1><br>
            <form action="FrontController" method="POST" name="pessoaEditar">
                <input type="hidden" name="command" value="pessoa.editar">
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}">
                Nome Completo:<br>
                <input type="text" name="nome" value="${pessoa.getNome()}" required pattern="[A-Za-z\s]{2,}" title="Somente letras podem ser inseridas nesse campo, no mínimo dois caracteres"/><br>
                RG:<br>
                <input type="text" name="rg" value="${pessoa.getRg()}" pattern="[0-9]{6,}" title="Somente números permitidos, no mínimo 6 dígitos"required/><br>
                CPF:<br>
                <input type="text" name="cpf" value="${pessoa.getCpf()}" pattern="[0-9]{11}" title="Somente números são permitidos, exatamente 11 caracteres." required/><br>
                <h4>Informações pessoais</h4>
                Sexo (Atual: ${pessoa.getSexo()}):<br>
                <select class="inputSelect" name="sexo" >
                    <option value="Nulo">Selecione</option>
                    <option value="feminino">Feminino</option>
                    <option value="masculino">Masculino</option>
                </select><br>
                Data de Nascimento:<br>
                <input type="date" name="dataNascimento" value="${pessoa.getDataNascimento()}" required/><br>
                Nacionalidade:<br>
                <input type="text" name="nacionalidade" value="${pessoa.getNacionalidade()}" pattern="[A-Za-z\s]{4,}" title="Somente letras são permitidas, no mínimo 4 caracteres" required/><br>
                Estado Civil (Atual: ${pessoa.getEstadoCivil()}):</br>
                <select class="inputSelect" name="estadoCivil">
                    <option value="Nulo">Selecione</option>
                    <option value="solteiro">Solteiro(a)</option>
                    <option value="casado">Casado(a)</option>
                    <option value="divorciado">Divorciado(a)</option>
                    <option value="viuvo">Viúvo(a)</option>
                </select><br>
                <br><h4>Endereço</h4>                
                Rua:<br>
                <input type="text" name="rua" value="${pessoa.getRua()}" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Bairro:<br>
                <input type="text" name="bairro" value="${pessoa.getBairro()}" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Complemento:<br>
                <input type="text" name="complemento" value="${pessoa.getComplemento()}"  /><br>
                Número:<br>
                <input type="text" name="numero" value="${pessoa.getNumero()}" required /><br>
                Cidade:<br>
                <input type="text" name="cidade" value="${pessoa.getCidade()}" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                CEP:<br>
                <input type="text" name="cep" value="${pessoa.getCep()}" required/><br>
                Estado (Atual: ${pessoa.getEstado()}):<br> 
                <select class="inputSelect" name="estado">
                    <option value="Nulo">Selecione</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espirito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select><br>
                País:<br>
                <input type="text" name="pais" value="${pessoa.getPais()}" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                <br><h4>Contato</h4> 
                Telefone:<br>
                <input type="text" name="telefone" value="${pessoa.getTelefone()}" required pattern="[0-9]{10}" title="Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos" /><br>
                Celular:<br>
                <input type="text" name="celular" value="${pessoa.getCelular()}" pattern="[0-9]{10,}" required title="Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos" /><br>
                <input type="submit" class="inputSubmit" value="Salvar">
            </form>
                <br/><br/><br/><br /><br />
                
                <h1>Editar o perfil do ${pessoa.getNome()} de:</h1>
            <form action="FrontController" method="POST" name="editarPaciente">
                <input type="hidden" name="command" value="paciente.irEditar">
                <input type="hidden" name="cpf" value="${pessoa.getCpf()}"> 
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}">   
                <input type="submit" class="inputSubmit" style="width:150px;float:left;margin-right: 20px;" value="Paciente">
            </form>  

            <form action="FrontController" method="POST" name="editarProfissional">
                <input type="hidden" name="command" value="profissional.irEditar">
                <input type="hidden" name="cpf" value="${pessoa.getCpf()}"> 
                <input type="hidden" name="idPessoa" value="${pessoa.getIdPessoa()}"> 
                <input type="submit" class="inputSubmit" style="width:150px;float:left;" value="Profissional">
            </form>
        </div>
    </body>
</html>
