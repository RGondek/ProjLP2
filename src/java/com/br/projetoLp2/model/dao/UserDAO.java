/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import com.br.projetoLp2.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1147106
 */
public class UserDAO implements GenericDAO<User>{

    private Connection conn;

    public UserDAO() {
        //1. Realizar a conexão
        conn = ConnectionDB.getInstance();
    }
    
    @Override
    public boolean insert(User user) {
        boolean resp = false;    
        String sql = "INSERT INTO user_login(VC_Username,VC_Password,NI_UserType) VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3,user.getUserType());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Error: user not inserted");
            } else {
                System.out.println("User inserted succefully");
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<User> read() {
        List<User> users = new ArrayList<>();
        //2. Criar o preparedStatement
        String sql = "SELECT * FROM user_login";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //3. Executa a query
            ResultSet rs = ps.executeQuery();
            
            //4. Mostrar os resultados
            while(rs.next()){
                User user = new User();
                user.setId_user( rs.getInt("NI_idUser") );
                user.setUsername( rs.getString("VC_Username") );
                user.setPassword( rs.getString("VC_Password") );
                user.setUserType(rs.getInt("NI_userType"));
                users.add(user);
            }
            
            //5. Fechar tudo
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }
    
    public User readByUsername(String username) {
        User user = new User();
        //2. Criar o preparedStatement
        String sql = "SELECT * FROM user_login WHERE VC_Username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            //3. Executa a query
            ResultSet rs = ps.executeQuery();
            
            //4. Mostrar os resultados
            while(rs.next()){
                user.setId_user( rs.getInt("NI_idUser") );
                user.setUsername( rs.getString("VC_Username") );
                user.setPassword( rs.getString("VC_Password") );
                user.setUserType(rs.getInt("NI_UserType"));
            }
            
            //5. Fechar tudo
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean resp = false;
        String sql = "UPDATE user_login SET VC_Username=?,VC_Password=?,NI_UserType WHERE NI_IdUser=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUserType());
            ps.setInt(4, user.getId_user());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Error: user not updated");
            } else {
                System.out.println("User updated successfully");
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(User user) {
        boolean resp = false;
        String sql = "DELETE FROM user_login WHERE NI_IdUser=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId_user());
            int resposta = ps.executeUpdate();
            if(resposta == 0){
                System.out.println("Error: user not removed");
            } else {
                System.out.println("User removed successfully");
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

}
