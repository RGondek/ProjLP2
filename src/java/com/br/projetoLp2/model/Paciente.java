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
public class Paciente implements Serializable {
    private int idPaciente;
    private Pessoa pessoa;
    private String nomeMae;
    private String cpfMae;

    public Paciente(int idPaciente, String nomeMae, String cpfMae, Pessoa pessoa) {
        this.idPaciente = idPaciente;
        this.pessoa = pessoa;
        this.nomeMae = nomeMae;
        this.cpfMae = cpfMae;
    }
    
    public Paciente(String nomeMae, String cpfMae, Pessoa pessoa) {
        this.idPaciente = -1;
        this.pessoa = pessoa;
        this.nomeMae = nomeMae;
        this.cpfMae = cpfMae;
    }
    
    public Paciente(Pessoa pessoa) {
        this.idPaciente = -1;
        this.pessoa = pessoa;
        this.nomeMae = "Não definida";
        this.cpfMae = "Não definido";
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpfMae() {
        return cpfMae;
    }

    public void setCpfMae(String cpfMae) {
        this.cpfMae = cpfMae;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", pessoa=" + pessoa + ", nomeMae=" + nomeMae + ", cpfMae=" + cpfMae + '}';
    }
}
