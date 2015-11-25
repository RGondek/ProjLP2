/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo Keniti
 */
public class ConsultaDAO implements GenericDAO<Consulta> {

    private Connection connection;

    public ConsultaDAO() {
        connection = ConnectionDB.getInstance();
    }

    public int getLastID() {
        String sql = "SELECT MAX(NI_Consulta) FROM Consulta";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean insert(Consulta consulta) {
        String sql = "INSERT INTO Consulta(DT_dataHora,ND_valorTotal,NI_Paciente,NI_Profissional) VALUES(?,?,?,?)";
        boolean resp = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(consulta.getDataHora().getTime()));
            ps.setDouble(2, consulta.getValorTotal());
            ps.setInt(3, consulta.getPaciente().getIdPaciente());
            ps.setInt(4, consulta.getProfissional().getIdProfissional());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("Impossivel inserir!");
            } else {
                System.out.println("Inserção realizada com sucesso!");
                resp = true;
            }
            if (resp) {
                ProcedimentoDAO procDAO = new ProcedimentoDAO();
                int idConsulta = getLastID();
                for (Procedimento p : consulta.getProcedimentos()) {
                    procDAO.insert(p, idConsulta);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return resp;
    }

    @Override
    public List<Consulta> read() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta c "
                + "INNER JOIN Paciente p ON p.NI_Paciente = c.NI_Paciente "
                + "JOIN Profissional pr ON pr.NI_Profissional = c.NI_Profissional";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ProfissionalDAO profissionalDAO = new ProfissionalDAO();
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            while (rs.next()) {
                Paciente paciente = pacienteDAO.readById(rs.getInt("NI_Paciente"));
                Profissional profissional = profissionalDAO.readById(rs.getInt("NI_Profissional"));
                Consulta consulta = new Consulta(rs.getDate("DT_dataHora"), rs.getDouble("ND_valorTotal"),
                        rs.getInt("NI_Consulta"), paciente, profissional);
                consulta.setProcedimentos(procedimentoDAO.readByConsulta(consulta.getIdConsulta()));
                consultas.add(consulta);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return consultas;
    }

    public Consulta readById(int id) {
        String sql = "SELECT * FROM Consulta c "
                + "INNER JOIN Paciente p ON p.NI_Paciente = c.NI_Paciente "
                + "JOIN Profissional pr ON pr.NI_Profissional = c.NI_Profissional "
                + "WHERE NI_Consulta = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ProfissionalDAO profissionalDAO = new ProfissionalDAO();
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            while (rs.next()) {
                Paciente paciente = pacienteDAO.readById(rs.getInt("NI_Paciente"));
                Profissional profissional = profissionalDAO.readById(rs.getInt("NI_Profissional"));
                Consulta consulta = new Consulta(rs.getDate("DT_dataHora"), rs.getDouble("ND_valorTotal"),
                        rs.getInt("NI_Consulta"), paciente, profissional);
                consulta.setProcedimentos(procedimentoDAO.readByConsulta(consulta.getIdConsulta()));
                ps.close();
                rs.close();
                return consulta;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Consulta consulta) {
        boolean resp = false;
        String sql = "UPDATE Consulta SET DT_dataHora=?,ND_valorTotal=?, NI_Paciente = ?, NI_Profissional = ? WHERE NI_Consulta=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(consulta.getDataHora().getTime()));
            ps.setDouble(2, consulta.getValorTotal());
            ps.setInt(3, consulta.getPaciente().getIdPaciente());
            ps.setInt(4, consulta.getProfissional().getIdProfissional());
            ps.setInt(5, consulta.getIdConsulta());
            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro, não foi possivel atualizar");
            } else {
                System.out.println("Atualizado com sucesso");
                resp = true;
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Consulta consulta) {
        boolean resp = false;
        String sql = "DELETE FROM Consulta WHERE NI_Consulta = ?";
        try {
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            procedimentoDAO.deleteAllInConsulta(consulta.getIdConsulta());

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, consulta.getIdConsulta());
            int resposta = ps.executeUpdate();
            if (resposta == 0) {
                System.out.println("Erro, impossivel remover!");
            } else {
                System.out.println("Remoção da consulta realizada com sucesso!");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    public boolean deleteAllProfissional(int id) {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta where NI_Profissional = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ProfissionalDAO profissionalDAO = new ProfissionalDAO();
            while (rs.next()) {
                Paciente paciente = pacienteDAO.readById(rs.getInt("NI_Paciente"));
                Profissional profissional = profissionalDAO.readById(rs.getInt("NI_Profissional"));
                Consulta consulta = new Consulta(rs.getDate("DT_dataHora"), rs.getDouble("ND_valorTotal"),
                        rs.getInt("NI_Consulta"), paciente, profissional);
                consulta.setProcedimentos(procedimentoDAO.readByConsulta(consulta.getIdConsulta()));
                procedimentoDAO.deleteAllInConsulta(consulta.getIdConsulta());
                delete(consulta);
            }
            ps.close();
            rs.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteAllPaciente(int id) {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM Consulta where NI_Paciente = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ProfissionalDAO profissionalDAO = new ProfissionalDAO();
            while (rs.next()) {
                Paciente paciente = pacienteDAO.readById(rs.getInt("NI_Paciente"));
                Profissional profissional = profissionalDAO.readById(rs.getInt("NI_Profissional"));
                Consulta consulta = new Consulta(rs.getDate("DT_dataHora"), rs.getDouble("ND_valorTotal"),
                        rs.getInt("NI_Consulta"), paciente, profissional);
                consulta.setProcedimentos(procedimentoDAO.readByConsulta(consulta.getIdConsulta()));
                procedimentoDAO.deleteAllInConsulta(consulta.getIdConsulta());
                delete(consulta);
            }
            ps.close();
            rs.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
