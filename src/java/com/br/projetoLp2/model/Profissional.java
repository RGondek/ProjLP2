/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model;

import java.io.Serializable;

/**
 *
 * @author ta-ma
 */
public class Profissional extends TipoPessoa implements Serializable {
    private int idProfissional;
    private String formacao;
    private String especialidade;
    private String registroProfissional;
    private Pessoa pessoa;
    

    public Profissional(int idProfissional, String formacao, String especialidade, String registroProfissional, Pessoa pessoa) {
        this.idProfissional = idProfissional;
        this.formacao = formacao;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.pessoa = pessoa;
    }
    
    public Profissional(String formacao, String especialidade, String registroProfissional, Pessoa pessoa) {
        this.idProfissional = -1;
        this.formacao = formacao;
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.pessoa = pessoa;
    }
    
    public Profissional() {
        this.idProfissional = -1;
        this.formacao = "Não definida";
        this.especialidade = "Não definida";
        this.registroProfissional = "Não definido";
        this.pessoa = null;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    @Override
    public String toString() {
        return "Profissional{" + "formacao=" + formacao + ", especialidade=" + especialidade + ", registroProfissional=" + registroProfissional + '}';
    }
}
