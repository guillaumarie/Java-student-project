/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Referent;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class ReferentDAO extends BaseDAO<Referent> {
    
    private final ArrayList<Referent> referents = new ArrayList<>();
    
    public ReferentDAO() {
        super();
    }

    @Override
    public void create(Referent referentNv, Connection conn) throws SQLException {
        try {
            String email = referentNv.getEmail();
            String password = referentNv.getPassword();
            String nom = referentNv.getNom();
            String prenom = referentNv.getPrenom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Utilisateur (Email, Password, Nom, Prenom)"
                    + " VALUES (email, password, nom, prenom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Referent referentSup, Connection conn) throws SQLException {
        try {
            int id = referentSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Utilisateur WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Referent referentMaj, Connection conn) throws SQLException {
        try {
            String email = referentMaj.getEmail();
            String password = referentMaj.getPassword();
            String nom = referentMaj.getNom();
            String prenom = referentMaj.getPrenom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Utilisateur SET Email = email, Password = password,"
                    + " Nom = nom, Prenom = prenom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Referent find(int id) throws SQLException {
        Referent actuel = referents.get(0);
        for (int i = 1; i < referents.size(); i++) {
            if (actuel.getId() == id) {
                return actuel;
            } else {
                actuel = referents.get(i);
            }
        }
        Referent pasTrouve = new Referent();
        return pasTrouve;
    }
    
    // Pour connexion
    public Referent find(String email, String password) throws SQLException {
        Referent actuel = referents.get(0);
        for (int i = 1; i < referents.size(); i++) {
            if ((actuel.getEmail().equals(email)) && (actuel.getPassword().equals(password))) {
                return actuel;
            } else {
                actuel = referents.get(i);
            }
        }
        Referent pasTrouve = new Referent();
        return pasTrouve;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (referents.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Utilisateur WHERE Droit = 2");
                if (rset.first()) {
                    do {
                        Referent referentActuel = new Referent(
                                rset.getInt("ID"),
                                rset.getString("Email"),
                                rset.getString("Password"),
                                rset.getString("Nom"),
                                rset.getString("Prenom"),
                                rset.getInt("Droit")
                        );
                        referents.add(referentActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        referents.clear();
    }
    
    public ArrayList<Referent> getReferents() {
        return referents;
    }
}



