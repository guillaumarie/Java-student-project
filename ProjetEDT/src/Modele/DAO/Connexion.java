/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import java.sql.*;

/**
 *
 * @author guill
 */
public class Connexion {
    
    private static Connection m_conn;
    
    public Connexion() throws SQLException, ClassNotFoundException {
        // Test pour ne pas se reconnecter à la DB si déjà connecté
        if (m_conn == null) {
            // Chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");

            // Création d'une connexion JDBC à la base ("url", "login", "password")
            m_conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/edt", "root", "");
        }
    }
    
    public Connection getConnexion() {
        return m_conn;
    }
}
