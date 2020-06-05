/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Enseignant;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class EnseignantDAO extends BaseDAO<Enseignant> {
    
    private final ArrayList<Enseignant> enseignants = new ArrayList<>();
    
    public EnseignantDAO() {
        super();
    }

    @Override
    public void create(Enseignant enseignantNv, Connection conn) throws SQLException {
        try {
            String email = enseignantNv.getEmail();
            String password = enseignantNv.getPassword();
            String nom = enseignantNv.getNom();
            String prenom = enseignantNv.getPrenom();
            int cours = enseignantNv.getCours();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Utilisateur (Email, Password, Nom, Prenom)"
                    + " VALUES (email, password, nom, prenom)");
            rset = stmt.executeQuery("SELECT ID FROM Utilisateur ORDER BY ID DESC LIMIT 1");
            int id = rset.getInt("ID");
            rset = stmt.executeQuery("INSERT INTO Enseignant (ID_Utilisateur, ID_Cours) VALUES (id, cours)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Enseignant enseignantSup, Connection conn) throws SQLException {
        try {
            int id = enseignantSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Utilisateur WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Enseignant enseignantMaj, Connection conn) throws SQLException {
        try {
            int id = enseignantMaj.getId();
            String email = enseignantMaj.getEmail();
            String password = enseignantMaj.getPassword();
            String nom = enseignantMaj.getNom();
            String prenom = enseignantMaj.getPrenom();
            int cours = enseignantMaj.getCours();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Utilisateur SET Email = email, Password = password,"
                    + " Nom = nom, Prenom = prenom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Override inutile car un enseignant est identifié par 2 attributs en clé primaire
    @Override
    public Enseignant find(int id) throws SQLException {
        Enseignant enseignant = new Enseignant();
        return enseignant;
    }
    
    public Enseignant find(int id, int cours) throws SQLException {
        Enseignant actuel = enseignants.get(0);
        for (int i = 1; i < enseignants.size()+1; i++) {
            if ((actuel.getId() == id) && (actuel.getCours() == cours)) {
                return actuel;
            } else {
                actuel = enseignants.get(i);
            }
        }
        Enseignant pasTrouve = new Enseignant();
        return pasTrouve;
    }
    
    // Pour connexion
    public Enseignant find(String email, String password) throws SQLException {
        Enseignant actuel = enseignants.get(0);
        for (int i = 1; i < enseignants.size()+1; i++) {
            if ((actuel.getEmail() == email) && (actuel.getPassword() == password)) {
                return actuel;
            } else {
                actuel = enseignants.get(i);
            }
        }
        Enseignant pasTrouve = new Enseignant();
        return pasTrouve;
    }
    
    public String nom(int id) throws SQLException {
        Enseignant enseignant = this.find(id);
        String nom = enseignant.getNom();
        return nom;
    }
    
    public String prenom(int id) throws SQLException {
        Enseignant enseignant = this.find(id);
        String nom = enseignant.getPrenom();
        return nom;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (enseignants.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Utilisateur, Enseignant"
                        + " WHERE Utilisateur.ID = Enseignant.ID_Utilisateur AND Droit = 3");
                if (rset.first()) {
                    do {
                        Enseignant enseignantActuel = new Enseignant(
                                rset.getInt("ID"),
                                rset.getString("Email"),
                                rset.getString("Password"),
                                rset.getString("Nom"),
                                rset.getString("Prenom"),
                                rset.getInt("Droit"),
                                rset.getInt("ID_Cours")
                        );
                        enseignants.add(enseignantActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        enseignants.clear();
    }
    
    public ArrayList<Enseignant> getEnseignants() {
        return enseignants;
    }
}
