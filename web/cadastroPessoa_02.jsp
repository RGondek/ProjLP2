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
            <form action="FrontController" method="POST" name="pessoaCreate">
                <input type="hidden" name="command" value="pessoa.create_02">
                <input type="hidden" name="nome" value="${nome}">
                <input type="hidden" name="rg" value="${rg}">
                <input type="hidden" name="cpf" value="${cpf}">
                <h4>Informações pessoais</h4>
                Sexo:<br>
                <select class="inputSelect" name="sexo" >
                    <option value="Nulo">Selecione</option>
                    <option value="feminino">Feminino</option>
                    <option value="masculino">Masculino</option>
                </select><br>
                Data de Nascimento:<br>
                <input type="date" name="dataNascimento" placeholder="Exemplo: 01/01/2000" required/><br>
                Nacionalidade:<br>
                <input type="text" name="nacionalidade" placeholder="Exemplo: Brasileiro" pattern="[A-Za-z\s]{4,}" title="Somente letras são permitidas, no mínimo 4 caracteres" required/><br>
                Estado Civil:<br>
                <select class="inputSelect" name="estadoCivil">
                    <option value="Nulo">Selecione</option>
                    <option value="solteiro">Solteiro(a)</option>
                    <option value="casado">Casado(a)</option>
                    <option value="divorciado">Divorciado(a)</option>
                    <option value="viuvo">Viúvo(a)</option>
                </select><br>
                <br><h4>Endereço</h4>                
                Rua:<br>
                <input type="text" name="rua" placeholder="Exemplo: Rua Pinheiro Filho" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Bairro:<br>
                <input type="text" name="bairro" placeholder="Exemplo: Vila Luz" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Complemento:<br>
                <input type="text" name="complemento" placeholder="Exemplo: Casa 2"  /><br>
                Número:<br>
                <input type="text" name="numero" placeholder="Exemplo: 111" required /><br>
                Cidade:<br>
                <input type="text" name="cidade" placeholder="Exemplo: São Paulo" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                CEP:<br>
                <input type="text" name="cep" placeholder="Exemplo: 11222333" required/><br>
                País:<br>
                <input type="text" name="pais" placeholder="Exemplo: Brasil" required pattern="[A-Za-z\s]{4,}" title="Somente letras podem ser inseridas nesse campo, no mínimo quatro caracteres" /><br>
                Estado:<br>
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
                <br><h4>Contato</h4> 
                Telefone:<br>
                <input type="text" name="telefone" placeholder="Exemplo: 1144536651"  required pattern="[0-9]{10}" title="Somente números são permitidos, exatamente 10 caracteres, espaços não são permitidos" /><br>
                Celular:<br>
                <input type="text" name="celular" placeholder="Exemplo: 11982785986" pattern="[0-9]{10,}" required title="Somente números são permitidos, no mínimo 10 caracteres, espaços não são permitidos" /><br>
                <input type="submit" class="inputSubmit" value="Próximo">
            </form>

        </div>
    </body>
</html>
