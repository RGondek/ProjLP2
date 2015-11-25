/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31411525
 */
public class ProcedimentoDAO implements GenericDAO<Procedimento>{
    Connection conn;

    public ProcedimentoDAO() {
        conn = ConnectionDB.getInstance();
    }

    public boolean insertDefault(Procedimento procedimento) {
        boolean res = false;
        String sql = "INSERT INTO ProcedimentoPadrao (VC_Nome_procedimento, ND_valor)"
                + " VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, procedimento.getNomeProcedimento());
            ps.setDouble(2, procedimento.getValor());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Procedimento Padrão inserido com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao inserir procedimento.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public boolean insert(Procedimento procedimento, int id_consulta) {
        boolean res = false;
        String sql = "INSERT INTO Procedimento(NI_Consulta, VC_Nome_procedimento, ND_valor)"
                + " VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_consulta);
            ps.setString(2, procedimento.getNomeProcedimento());
            ps.setDouble(3, procedimento.getValor());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Procedimento inserido com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao inserir procedimento.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Procedimento> read() {
        List<Procedimento> procedimentos = new ArrayList<Procedimento>();
        String sql = "SELECT * FROM Procedimento";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento(rs.getString("VC_Nome_procedimento"),
                        rs.getInt("NI_Procedimento"), rs.getDouble("ND_valor"));
                procedimentos.add(procedimento);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedimentos;
    }

    public List<Procedimento> readByConsulta(int id_consulta) {
        List<Procedimento> procedimentos = new ArrayList<Procedimento>();
        String sql = "SELECT * FROM Procedimento WHERE NI_Consulta = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento(rs.getString("VC_Nome_Procedimento"),
                        rs.getInt("NI_Procedimento"), rs.getDouble("ND_Valor"));
                        
                procedimentos.add(procedimento);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedimentos;
    }
    
    public Procedimento readById(int id) {
        String sql = "SELECT * FROM Procedimento WHERE NI_Procedimento = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento(rs.getString("VC_Nome_Procedimento"),
                        rs.getInt("NI_Procedimento"), rs.getDouble("ND_Valor"));
                return procedimento;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Procedimento readDefaultById(int id) {
        String sql = "SELECT * FROM ProcedimentoPadrao WHERE NI_ProcPadrao = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento(rs.getString("VC_Nome_Procedimento"),
                        rs.getInt("NI_ProcPadrao"), rs.getDouble("ND_Valor"));
                return procedimento;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Procedimento> readDefault() {
        List<Procedimento> procedimentos = new ArrayList<Procedimento>();
        String sql = "SELECT * FROM ProcedimentoPadrao ORDER BY VC_Nome_Procedimento";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Procedimento procedimento = new Procedimento(rs.getString("VC_Nome_Procedimento"),
                        rs.getInt("NI_ProcPadrao"), rs.getDouble("ND_Valor"));
                        
                procedimentos.add(procedimento);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedimentos;
    }
    

    @Override
    public boolean update(Procedimento procedimento) {
        boolean res = false;
        String sql = "UPDATE ProcedimentoPadrao SET VC_Nome_Procedimento = ?, ND_valor = ? "
                + "WHERE NI_ProcPadrao=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, procedimento.getNomeProcedimento());
            ps.setDouble(2, procedimento.getValor());
            ps.setInt(3, procedimento.getIdProcedimento());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Procedimento atualizado com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao atualizar procedimento.");
                res = false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    
    
    @Override
    public boolean delete(Procedimento procedimento) {
        String sql = "DELETE FROM Procedimento WHERE NI_Procedimento = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, procedimento.getIdProcedimento());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao deletar procedimento.");
            } else {
                System.out.println("DAO: Procedimento deletado com sucesso.");
                resp = true;
            }
            // Excluir Pessoa no BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
    
    public boolean deleteDefault(Procedimento procedimento) {
        String sql = "DELETE FROM ProcedimentoPadrao WHERE NI_ProcPadrao = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, procedimento.getIdProcedimento());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao deletar procedimento.");
            } else {
                System.out.println("DAO: Procedimento deletado com sucesso.");
                resp = true;
            }
            // Excluir Pessoa no BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
    
    public boolean deleteAllInConsulta(int id_consulta) {
        String sql = "DELETE FROM Procedimento WHERE NI_Consulta = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_consulta);
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao deletar procedimentos.");
            } else {
                System.out.println("DAO: "+ eu +" Procedimentos deletado com sucesso.");
                resp = true;
            }
            // Excluir Pessoa no BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean insert(Procedimento t) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }
}
