/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ta-ma
 */
public class Pessoa implements Serializable {
    private int idPessoa;
    private String nome;
    private String rua;
    private String bairro;
    private String complemento;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private Date dataNascimento;
    private long telefone;
    private long celular;
    private String sexo;
    private String nacionalidade;
    private String rg;
    private String cpf;
    private String estadoCivil;
    private TipoPessoa tipoPessoa;

    public Pessoa(int id, String nome, String rua, String bairro, String complemento, int numero, String cep, String cidade, String estado, String pais, Date dataNascimento, long telefone, long celular, String sexo, String nacionalidade, String rg, String cpf, String estadoCivil) {
        this.idPessoa = id;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.rg = rg;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }
    
    public Pessoa(String nome, String rua, String bairro, String complemento, int numero, String cep, String cidade, String estado, String pais, Date dataNascimento, long telefone, long celular, String sexo, String nacionalidade, String rg, String cpf, String estadoCivil) {
        this.idPessoa = -1;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.sexo = sexo;
        this.nacionalidade = nacionalidade;
        this.rg = rg;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public int getIdPessoa() {
        return idPessoa;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", rua=" + rua + ", bairro=" + bairro + ", complemento=" + complemento + ", numero=" + numero + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + ", celular=" + celular + ", sexo=" + sexo + ", nacionalidade=" + nacionalidade + ", rg=" + rg + ", cpf=" + cpf + ", estadoCivil=" + estadoCivil + ", tipoPessoa=" + tipoPessoa + '}';
    }

}
