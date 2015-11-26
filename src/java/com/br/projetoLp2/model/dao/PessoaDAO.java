/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.business.PessoaNaoInseridaException;
import com.br.projetoLp2.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41406133
 */
public class PessoaDAO implements GenericDAO<Pessoa> {

    Connection conn;

    public PessoaDAO() {
        conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Pessoa pessoa) {
        boolean res = false;
        String sql = "INSERT INTO Pessoa(VC_Nome, VC_Rua, VC_Bairro, VC_Complemento, VC_Numero, "
                + "VC_Cep, VC_Cidade, VC_Estado, VC_Pais, DT_Nascimento, NI_Telefone, NI_Celular, "
                + "VC_Sexo, VC_Nacionalidade, VC_RG, VC_CPF, VC_EstadoCivil) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getRua());
            ps.setString(3, pessoa.getBairro());
            ps.setString(4, pessoa.getComplemento());
            ps.setInt(5, pessoa.getNumero());
            ps.setString(6, pessoa.getCep());
            ps.setString(7, pessoa.getCidade());
            ps.setString(8, pessoa.getEstado());
            ps.setString(9, pessoa.getPais());
            ps.setDate(10, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            ps.setLong(11, pessoa.getTelefone());
            ps.setLong(12, pessoa.getCelular());
            ps.setString(13, pessoa.getSexo());
            ps.setString(14, pessoa.getNacionalidade());
            ps.setString(15, pessoa.getRg());
            ps.setString(16, pessoa.getCpf());
            ps.setString(17, pessoa.getEstadoCivil());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Pessoa inserida com sucesso.");
                res = true;
            } else {
                throw new PessoaNaoInseridaException("DAO: Pessoa não foi inserida com sucesso.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public int getLastID() {
        String sql = "SELECT MAX(NI_Pessoa) FROM Pessoa";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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
    public List<Pessoa> read() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        String sql = "SELECT * FROM Pessoa";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("vc_nome"));
                pessoa.setRua(rs.getString("VC_Rua"));
                pessoa.setBairro(rs.getString("VC_Bairro"));
                pessoa.setComplemento(rs.getString("VC_Complemento"));
                pessoa.setNumero(rs.getInt("VC_Numero"));
                pessoa.setCep(rs.getString("VC_Cep"));
                pessoa.setCidade(rs.getString("VC_Cidade"));
                pessoa.setEstado(rs.getString("VC_Estado"));
                pessoa.setPais(rs.getString("VC_Pais"));
                pessoa.setDataNascimento(rs.getDate("DT_Nascimento"));
                pessoa.setTelefone(rs.getLong("NI_Telefone"));
                pessoa.setCelular(rs.getLong("NI_Celular"));
                pessoa.setSexo(rs.getString("VC_Sexo"));
                pessoa.setNacionalidade(rs.getString("VC_Nacionalidade"));
                pessoa.setRg(rs.getString("VC_RG"));
                pessoa.setCpf(rs.getString("VC_CPF"));
                pessoa.setEstadoCivil(rs.getString("VC_EstadoCivil"));
                pessoa.setIdPessoa(rs.getInt("NI_Pessoa"));
                pessoas.add(pessoa);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public Pessoa readById(int id) {
        Pessoa pessoa = new Pessoa();
        String sql = "SELECT * FROM Pessoa WHERE NI_PESSOA = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pessoa.setNome(rs.getString("vc_nome"));
                pessoa.setRua(rs.getString("VC_Rua"));
                pessoa.setBairro(rs.getString("VC_Bairro"));
                pessoa.setComplemento(rs.getString("VC_Complemento"));
                pessoa.setNumero(rs.getInt("VC_Numero"));
                pessoa.setCep(rs.getString("VC_Cep"));
                pessoa.setCidade(rs.getString("VC_Cidade"));
                pessoa.setEstado(rs.getString("VC_Estado"));
                pessoa.setPais(rs.getString("VC_Pais"));
                pessoa.setDataNascimento(rs.getDate("DT_Nascimento"));
                pessoa.setTelefone(rs.getLong("NI_Telefone"));
                pessoa.setCelular(rs.getLong("NI_Celular"));
                pessoa.setSexo(rs.getString("VC_Sexo"));
                pessoa.setNacionalidade(rs.getString("VC_Nacionalidade"));
                pessoa.setRg(rs.getString("VC_RG"));
                pessoa.setCpf(rs.getString("VC_CPF"));
                pessoa.setEstadoCivil(rs.getString("VC_EstadoCivil"));
                pessoa.setIdPessoa(id);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public Pessoa readByCpf(String cpf) {
        Pessoa pessoa = null;
        String sql = "SELECT * FROM Pessoa WHERE VC_CPF = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("vc_Nome"));
                pessoa.setRua(rs.getString("VC_Rua"));
                pessoa.setBairro(rs.getString("VC_Bairro"));
                pessoa.setComplemento(rs.getString("VC_Complemento"));
                pessoa.setNumero(rs.getInt("VC_Numero"));
                pessoa.setCep(rs.getString("VC_Cep"));
                pessoa.setCidade(rs.getString("VC_Cidade"));
                pessoa.setEstado(rs.getString("VC_Estado"));
                pessoa.setPais(rs.getString("VC_Pais"));
                pessoa.setDataNascimento(rs.getDate("DT_Nascimento"));
                pessoa.setTelefone(rs.getLong("NI_Telefone"));
                pessoa.setCelular(rs.getLong("NI_Celular"));
                pessoa.setSexo(rs.getString("VC_Sexo"));
                pessoa.setNacionalidade(rs.getString("VC_Nacionalidade"));
                pessoa.setRg(rs.getString("VC_RG"));
                pessoa.setCpf(rs.getString("VC_CPF"));
                pessoa.setEstadoCivil(rs.getString("VC_EstadoCivil"));
                pessoa.setIdPessoa(rs.getInt("NI_Pessoa"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    @Override
    public boolean update(Pessoa pessoa) {
        boolean res = false;
        String sql = "UPDATE Pessoa SET VC_Nome=?, VC_Rua=?, VC_Bairro=?, VC_Complemento=?,"
                + "VC_Numero=?, VC_Cep=?, VC_Cidade=?, VC_Estado=?, VC_Pais=?, "
                + "DT_Nascimento=?, NI_Telefone=?, NI_Celular=?, VC_Sexo=?, VC_Nacionalidade=?, "
                + "VC_RG=?, VC_CPF=?, VC_EstadoCivil=? WHERE NI_Pessoa = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getRua());
            ps.setString(3, pessoa.getBairro());
            ps.setString(4, pessoa.getComplemento());
            ps.setInt(5, pessoa.getNumero());
            ps.setString(6, pessoa.getCep());
            ps.setString(7, pessoa.getCidade());
            ps.setString(8, pessoa.getEstado());
            ps.setString(9, pessoa.getPais());
            ps.setDate(10, new java.sql.Date(pessoa.getDataNascimento().getTime()));
            ps.setLong(11, pessoa.getTelefone());
            ps.setLong(12, pessoa.getCelular());
            ps.setString(13, pessoa.getSexo());
            ps.setString(14, pessoa.getNacionalidade());
            ps.setString(15, pessoa.getRg());
            ps.setString(16, pessoa.getCpf());
            ps.setString(17, pessoa.getEstadoCivil());
            ps.setInt(18, pessoa.getIdPessoa());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Pessoa atualizada com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao atualizar pessoa.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean delete(Pessoa pessoa) {
        boolean res = false;
        String sql = "DELETE FROM Pessoa WHERE NI_Pessoa = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pessoa.getIdPessoa());
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Pessoa removido com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao remover pessoa.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean deleteById(int id) {
        boolean res = false;
        String sql = "DELETE FROM Pessoa WHERE NI_Pessoa = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int resposta = ps.executeUpdate();
            if (resposta == 1) {
                System.out.println("DAO: Pessoa removido com sucesso.");
                res = true;
            } else {
                System.out.println("DAO: Falha ao remover pessoa.");
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
