/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.model.Paciente;
import com.br.projetoLp2.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ta-ma
 */
public class PacienteDAO implements GenericDAO<Paciente> {

    private Connection connection;

    public PacienteDAO() {
        connection = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Paciente paciente) {
        String sql = "INSERT INTO Paciente(NI_Pessoa, VC_NomeMae, VC_CpfMae) VALUES(?, ?, ?)";
        boolean resp = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, paciente.getPessoa().getIdPessoa());
            ps.setString(2, paciente.getNomeMae());
            ps.setString(3, paciente.getCpfMae());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao inserir paciente.");
            } else {
                System.out.println("DAO: Paciente inserido com sucesso.");
                resp = true;
            }
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Paciente> read() {
        List<Paciente> pacientes = new ArrayList();
        String sql = "SELECT * FROM Paciente INNER JOIN Pessoa ON Paciente.NI_Pessoa = Pessoa.NI_Pessoa";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getInt("NI_Pessoa"), rs.getString("VC_Nome"),
                        rs.getString("VC_Rua"), rs.getString("VC_Bairro"),
                        rs.getString("VC_Complemento"), rs.getInt("VC_Numero"),
                        rs.getString("VC_Cep"), rs.getString("VC_Cidade"),
                        rs.getString("VC_Estado"), rs.getString("VC_Pais"),
                        rs.getDate("DT_Nascimento"), rs.getLong("NI_Telefone"),
                        rs.getLong("NI_Celular"), rs.getString("VC_Sexo"),
                        rs.getString("VC_Nacionalidade"), rs.getString("VC_RG"),
                        rs.getString("VC_CPF"), rs.getString("VC_EstadoCivil")
                );
                Paciente paciente = new Paciente(rs.getInt("NI_Paciente"), "VC_NomeMae", "VC_CpfMae", pessoa);
                pacientes.add(paciente);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pacientes;
    }

    public Paciente readById(int id) {
        String sql = "SELECT * FROM Paciente pa "
                + "INNER JOIN Pessoa pe ON pa.NI_Pessoa= pe.NI_Pessoa "
                + "WHERE NI_Paciente = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getInt("NI_Pessoa"), rs.getString("VC_Nome"),
                        rs.getString("VC_Rua"), rs.getString("VC_Bairro"),
                        rs.getString("VC_Complemento"), rs.getInt("VC_Numero"),
                        rs.getString("VC_Cep"), rs.getString("VC_Cidade"),
                        rs.getString("VC_Estado"), rs.getString("VC_Pais"),
                        rs.getDate("DT_Nascimento"), rs.getLong("NI_Telefone"),
                        rs.getLong("NI_Celular"), rs.getString("VC_Sexo"),
                        rs.getString("VC_Nacionalidade"), rs.getString("VC_RG"),
                        rs.getString("VC_CPF"), rs.getString("VC_EstadoCivil")
                );
                Paciente paciente = new Paciente(rs.getInt("NI_Paciente"), rs.getString("VC_NomeMae"),
                        rs.getString("VC_CpfMae"), pessoa);
                return paciente;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Paciente readByIdPessoa(int id) {
        String sql = "SELECT * FROM Paciente pa "
                + "INNER JOIN Pessoa pe ON pa.NI_Pessoa= pe.NI_Pessoa "
                + "WHERE pa.NI_Pessoa = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(rs.getInt("NI_Pessoa"), rs.getString("VC_Nome"),
                        rs.getString("VC_Rua"), rs.getString("VC_Bairro"),
                        rs.getString("VC_Complemento"), rs.getInt("VC_Numero"),
                        rs.getString("VC_Cep"), rs.getString("VC_Cidade"),
                        rs.getString("VC_Estado"), rs.getString("VC_Pais"),
                        rs.getDate("DT_Nascimento"), rs.getLong("NI_Telefone"),
                        rs.getLong("NI_Celular"), rs.getString("VC_Sexo"),
                        rs.getString("VC_Nacionalidade"), rs.getString("VC_RG"),
                        rs.getString("VC_CPF"), rs.getString("VC_EstadoCivil")
                );
                Paciente paciente = new Paciente(rs.getInt("NI_Paciente"), rs.getString("VC_NomeMae"),
                        rs.getString("VC_CpfMae"), pessoa);
                return paciente;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Paciente paciente) {
        String sql = "UPDATE paciente SET NI_PESSOA=?, VC_NomeMae=?, VC_CpfMae=? WHERE NI_PACIENTE=?";
        boolean resp = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, paciente.getPessoa().getIdPessoa());
            ps.setString(2, paciente.getNomeMae());
            ps.setString(3, paciente.getCpfMae());
            ps.setInt(4, paciente.getIdPaciente());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao atualizar paciente.");
            } else {
                System.out.println("DAO: Paciente atualizado com sucesso.");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Paciente paciente) {
        String sql = "DELETE FROM Paciente WHERE NI_Paciente = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, paciente.getIdPaciente());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao apagar paciente.");
            } else {
                System.out.println("DAO: Paciente apagado com sucesso.");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Paciente WHERE NI_Paciente = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao apagar paciente.");
            } else {
                System.out.println("DAO: Paciente apagado com sucesso.");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
