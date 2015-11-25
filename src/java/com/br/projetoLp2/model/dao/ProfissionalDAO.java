/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.model.Pessoa;
import com.br.projetoLp2.model.Profissional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41406133
 */
public class ProfissionalDAO implements GenericDAO<Profissional> {

    Connection conn;

    public ProfissionalDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Profissional profissional) {
        boolean res = false;
        String sql = "INSERT INTO Profissional(VC_Formacao, VC_Especialidade, VC_RegistroProfissional, NI_Pessoa)"
                + " VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, profissional.getFormacao());
            ps.setString(2, profissional.getEspecialidade());
            ps.setString(3, profissional.getRegistroProfissional());
            ps.setInt(4, profissional.getPessoa().getIdPessoa());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Profissional inserido com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao inserir profissional.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<Profissional> read() {
        List<Profissional> profissionais = new ArrayList<Profissional>();
        String sql = "SELECT * FROM Profissional INNER JOIN Pessoa ON Profissional.NI_Pessoa = Pessoa.NI_Pessoa";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
                Profissional profissional = new Profissional(rs.getInt("NI_Profissional"),
                        rs.getString("VC_Formacao"), rs.getString("VC_Especialidade"),
                        rs.getString("VC_RegistroProfissional"), pessoa);
                profissionais.add(profissional);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profissionais;
    }

    public Profissional readById(int id) {
        String sql = "SELECT * FROM Profissional "
                + "INNER JOIN Pessoa ON Profissional.NI_Pessoa = Pessoa.NI_Pessoa "
                + "WHERE NI_Profissional = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
                Profissional profissional = new Profissional(rs.getInt("NI_Profissional"),
                        rs.getString("VC_Formacao"), rs.getString("VC_Especialidade"),
                        rs.getString("VC_RegistroProfissional"), pessoa);
                return profissional;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Profissional readByIdPessoa(int id) {
        String sql = "SELECT * FROM Profissional "
                + "INNER JOIN Pessoa ON Profissional.NI_Pessoa = Pessoa.NI_Pessoa "
                + "WHERE Profissional.NI_Pessoa = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
                Profissional profissional = new Profissional(rs.getInt("NI_Profissional"),
                        rs.getString("VC_Formacao"), rs.getString("VC_Especialidade"),
                        rs.getString("VC_RegistroProfissional"), pessoa);
                return profissional;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Profissional profissional) {
        boolean res = false;
        String sql = "UPDATE Profissional SET VC_Formacao=?, VC_Especialidade=?, VC_RegistroProfissional=? "
                + "WHERE NI_Profissional=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, profissional.getFormacao());
            ps.setString(2, profissional.getEspecialidade());
            ps.setString(3, profissional.getRegistroProfissional());
            ps.setInt(4, profissional.getIdProfissional());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Profissional atualizado com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao atualizar profissional.");
                res = false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(Profissional profissional) {
        String sql = "DELETE FROM Profissional WHERE NI_Profissional = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, profissional.getIdProfissional());
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao deletar profissional.");
            } else {
                System.out.println("DAO: Profissional deletado com sucesso.");
                resp = true;
            }
            // Excluir Pessoa no BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Profissional WHERE NI_Profissional = ?";
        boolean resp = false;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int eu = ps.executeUpdate();
            if (eu == 0) {
                System.out.println("DAO: Falha ao deletar profissional.");
            } else {
                System.out.println("DAO: Profissional deletado com sucesso.");
                resp = true;
            }
            // Excluir Pessoa no BD
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}
