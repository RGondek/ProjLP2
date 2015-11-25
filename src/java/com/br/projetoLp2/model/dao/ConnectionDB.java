/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ta-ma
 */
public class ConnectionDB {
   private static String driver = "org.apache.derby.jdbc.ClientDriver";
    private static String protocolo = "jdbc:derby:";
    private static String dominio = "//localhost:1527/";
    private static String db = "db_projeto";
    private static String user = "adm";
    private static String password = "123";
    private static Connection connection = null;
    
    public static Connection getInstance(){
        if(connection == null){
            try {
                Class.forName(driver).newInstance();
                connection = DriverManager.getConnection(protocolo+dominio+db,user,password);
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
