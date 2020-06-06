/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class AdminDAO extends BaseDAO<Admin> {
    
    private final ArrayList<Admin> admins = new ArrayList<>();
    
    public AdminDAO() {
        super();
    }

    @Override
    public void create(Admin adminNv, Connection conn) throws SQLException {
        try {
            String email = adminNv.getEmail();
            String password = adminNv.getPassword();
            String nom = adminNv.getNom();
            String prenom = adminNv.getPrenom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Utilisateur (Email, Password, Nom, Prenom)"
                    + " VALUES (email, password, nom, prenom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Admin adminSup, Connection conn) throws SQLException {
        try {
            int id = adminSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Utilisateur WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Admin adminMaj, Connection conn) throws SQLException {
        try {
            String email = adminMaj.getEmail();
            String password = adminMaj.getPassword();
            String nom = adminMaj.getNom();
            String prenom = adminMaj.getPrenom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Utilisateur SET Email = email, Password = password,"
                    + " Nom = nom, Prenom = prenom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Admin find(int id) throws SQLException {
        Admin actuel = admins.get(0);
        for (int i = 1; i < admins.size(); i++) {
            if (actuel.getId() == id) {
                return actuel;
            } else {
                actuel = admins.get(i);
            }
        }
        Admin pasTrouve = new Admin();
        return pasTrouve;
    }
    
    // Pour connexion
    public Admin find(String email, String password) throws SQLException {
        Admin actuel = admins.get(0);
        for (int i = 1; i < admins.size(); i++) {
            if ((actuel.getEmail() == email) && (actuel.getPassword() == password)) {
                return actuel;
            } else {
                actuel = admins.get(i);
            }
        }
        Admin pasTrouve = new Admin();
        return pasTrouve;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (admins.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Utilisateur WHERE Droit = 1");
                if (rset.first()) {
                    do {
                        Admin adminActuel = new Admin(
                                rset.getInt("ID"),
                                rset.getString("Email"),
                                rset.getString("Password"),
                                rset.getString("Nom"),
                                rset.getString("Prenom"),
                                rset.getInt("Droit")
                        );
                        admins.add(adminActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        admins.clear();
    }
    
    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}



