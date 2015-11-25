/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.business;

import com.br.projetoLp2.model.*;
import com.br.projetoLp2.model.dao.*;
import java.util.List;

/**
 *
 * @author 31411525
 */
public class ProcedimentoManager {

    private static Procedimento procedimento = null;

    /**
     * @param procedimento
     * @return 1 for "Procedure inserted" -5 for "Procedure not inserted"
     */
    
    public static int insertDefault(Procedimento proc) {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        if (dao.insertDefault(proc)) {
            System.out.println("Manager: Procedimento " + proc.getNomeProcedimento() + " inserido com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir procedimento.");
            return -5;
        }
    }
    
    public static int insert(Procedimento procedimento) {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        if (dao.insert(procedimento)) {
            System.out.println("Manager: Procedimento " + procedimento.getNomeProcedimento() + " inserido com sucesso.");
            return 1;
        } else {
            System.out.println("Manager: Falha ao inserir procedimento.");
            return -5;
        }
    }

    public static List<Procedimento> readByConsulta(int id_consulta) {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        return dao.readByConsulta(id_consulta);
    }
    
    public static List<Procedimento> readDefault() {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        return dao.readDefault();
    }
    
    public static Procedimento readById(int id) {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        return dao.readById(id);
    }
    
    public static Procedimento readDefaultById(int id) {
        ProcedimentoDAO dao = new ProcedimentoDAO();
        return dao.readDefaultById(id);
    }

    public static int update(Procedimento procedimento, int id) {
        ProcedimentoDAO proDao = new ProcedimentoDAO();
        procedimento.setIdProcedimento(id);
        if (proDao.update(procedimento)) {
            System.out.println("Procedure " + procedimento.getNomeProcedimento() + " updated successfully");
            return 1;
        } else {
            System.out.println("Error: professional not updated");
            return -5;
        }
    }

    public static int deleteDefault(int id) {
        ProcedimentoDAO proDao = new ProcedimentoDAO();
        Procedimento p = new Procedimento(id);
        if (proDao.deleteDefault(p)) {
            System.out.println("Procedure " + p.getNomeProcedimento() + " deleted successfully");
            return 1;
        } else {
            System.out.println("Error: professional not deleted");
            return -5;
        }
    }
    
    public static int delete(int id) {
        ProcedimentoDAO proDao = new ProcedimentoDAO();
        Procedimento p = new Procedimento(id);
        if (proDao.delete(p)) {
            System.out.println("Procedure " + p.getNomeProcedimento() + " deleted successfully");
            return 1;
        } else {
            System.out.println("Error: professional not deleted");
            return -5;
        }
    }

    public static Procedimento getProcedimento() {
        return procedimento;
    }

    public static void setProcedimento(Procedimento procedimento) {
        ProcedimentoManager.procedimento = procedimento;
    }
}
