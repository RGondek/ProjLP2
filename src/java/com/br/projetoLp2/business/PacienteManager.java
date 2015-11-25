/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.business;

import com.br.projetoLp2.model.Paciente;
import com.br.projetoLp2.model.Profissional;
import com.br.projetoLp2.model.dao.PacienteDAO;
import com.br.projetoLp2.model.dao.ProfissionalDAO;
import java.util.List;

/**
 *
 * @author lucas
 */
public class PacienteManager {

    private static Paciente paciente = null;

    /**
     * @param paciente
     * @return 1 for "Professional inserted" -5 for "Professional not inserted"
     */
    public static int insert(Paciente paciente) {
        PacienteDAO dao = new PacienteDAO();
        if (dao.insert(paciente)) {
            System.out.println("Manager: Paciente " + paciente.getPessoa().getNome() + " inserido com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir paciente.");
            return -5;
        }
    }

    public static List<Paciente> read() {
        PacienteDAO dao = new PacienteDAO();
        return dao.read();
    }

    public static Paciente readById(int id) {
        PacienteDAO dao = new PacienteDAO();
        return dao.readById(id);
    }

    public static Paciente readByIdPessoa(int id) {
        PacienteDAO dao = new PacienteDAO();
        return dao.readByIdPessoa(id);
    }

    public static boolean update(Paciente paciente) {
        PacienteDAO dao = new PacienteDAO();
        return dao.update(paciente);
    }

    public static boolean delete(int id) {
        PacienteDAO dao = new PacienteDAO();
        return dao.deleteById(id);
    }

    public static Paciente getPaciente() {
        return paciente;
    }

    public static void setPaciente(Paciente paciente) {
        PacienteManager.paciente = paciente;
    }
}
