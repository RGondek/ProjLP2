/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.business;

import com.br.projetoLp2.model.Consulta;
import com.br.projetoLp2.model.dao.ConsultaDAO;
import java.util.List;

/**
 * @param Consulta
 * @return 1 for "Consulta inserted" -5 for "Consulta not inserted"
 */
public class ConsultaManager {

    private static Consulta consulta = null;

    public static int insert(Consulta consulta) {
        ConsultaDAO dao = new ConsultaDAO();
        if (dao.insert(consulta)) {
            System.out.println("Manager: Consulta " + consulta.getIdConsulta() + " inserida com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir consulta.");
            return -5;
        }
    }

    public static List<Consulta> read() {
        ConsultaDAO dao = new ConsultaDAO();
        return dao.read();
    }
    
    public static Consulta readById(int id) {
        ConsultaDAO dao = new ConsultaDAO();
        return dao.readById(id);
    }

    public static int update(int idAntigo, Consulta consulta) {
        ConsultaDAO proDao = new ConsultaDAO();
        consulta.setIdConsulta(idAntigo);
        if (proDao.update(consulta)) {
            System.out.println("Consulta " + consulta.getIdConsulta() + " updated successfully");
            return 1;
        } else {
            System.out.println("Error: consulta not updated");
            return -5;
        }
    }

    public static int delete(int id) {
        ConsultaDAO proDao = new ConsultaDAO();
        Consulta c = new Consulta(id);
        if (proDao.delete(c)) {
            System.out.println("Consulta " + id + " deleted successfully");
            return 1;
        } else {
            System.out.println("Error: consulta not deleted");
            return -5;
        }

    }
    public static boolean deleteAllProfissional(int id) {
        ConsultaDAO proDao = new ConsultaDAO();
        return proDao.deleteAllProfissional(id);
    }
    
    public static boolean deleteAllPaciente(int id) {
        ConsultaDAO proDao = new ConsultaDAO();
        return proDao.deleteAllPaciente(id);
    }


    public static Consulta getConsulta() {
        return consulta;
    }

    public static void setConsulta(Consulta consulta) {
        ConsultaManager.consulta = consulta;
    }

}
