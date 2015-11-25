/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ta-ma
 */
public class Consulta implements Serializable {

    private int idConsulta;
    private Date dataHora;
    private double valorTotal;
    private List<Procedimento> procedimentos;
    private Paciente paciente;
    private Profissional profissional;

    public Consulta(Date dataHora, double valorTotal, int idConsulta, Paciente paciente,Profissional profissional) {
        this.idConsulta = idConsulta;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
        this.procedimentos = new ArrayList<>();
        this.paciente = paciente;
        this.profissional = profissional;
    }
    
    public Consulta(Date dataHora, double valorTotal, Paciente paciente,Profissional profissional, List<Procedimento> procs) {
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
        this.procedimentos = procs;
        this.paciente = paciente;
        this.profissional = profissional;
    }

    public Consulta() {
        this.idConsulta = -1;
        this.valorTotal = -1;
        this.dataHora = new Date();
        this.procedimentos = new ArrayList<>();
        this.paciente = null;
        this.profissional = null;
    }

    public Consulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public void addProcedimento(Procedimento procedimento) {
        procedimentos.add(procedimento);
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }
    

    @Override
    public String toString() {
        return "Consulta{" + "dataHora=" + dataHora + ", valorTotal=" + valorTotal + '}';
    }

}
