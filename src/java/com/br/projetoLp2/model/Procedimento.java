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
public class Procedimento implements Serializable {

    private String nomeProcedimento;
    private int idProcedimento;
    private double valor;

    public Procedimento(String nomeProcedimento, int idProcedimento, double valor) {
        this.nomeProcedimento = nomeProcedimento;
        this.idProcedimento = idProcedimento;
        this.valor = valor;
    }

    public Procedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public Procedimento(String nomeProcedimento, double valor) {
        this.nomeProcedimento = nomeProcedimento;
        this.valor = valor;
    }
    
    

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public int getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(int idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Procedimento{" + "nomeProcedimento=" + nomeProcedimento + ", idProcedimento=" + idProcedimento + ", valor=" + valor + '}';
    }

}
