/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Etudiant;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class EtudiantDAO extends BaseDAO<Etudiant> {
    
    private final ArrayList<Etudiant> etudiants = new ArrayList<>();
    
    public EtudiantDAO() {
        super();
    }

    @Override
    public void create(Etudiant etudiantNv, Connection conn) throws SQLException {
        try {
            String email = etudiantNv.getEmail();
            String password = etudiantNv.getPassword();
            String nom = etudiantNv.getNom();
            String prenom = etudiantNv.getPrenom();
            int numero = etudiantNv.getNumero();
            int groupe = etudiantNv.getGroupe();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Utilisateur (Email, Password, Nom, Prenom)"
                    + " VALUES (email, password, nom, prenom)");
            rset = stmt.executeQuery("SELECT ID FROM Utilisateur ORDER BY ID DESC LIMIT 1");
            int id = rset.getInt("ID");
            rset = stmt.executeQuery("INSERT INTO Etudiant (ID_Utilisateur, Numero, ID_Groupe) VALUES (id, numero, groupe)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Etudiant etudiantSup, Connection conn) throws SQLException {
        try {
            int id = etudiantSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Utilisateur WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Etudiant etudiantMaj, Connection conn) throws SQLException {
        try {
            int id = etudiantMaj.getId();
            String email = etudiantMaj.getEmail();
            String password = etudiantMaj.getPassword();
            String nom = etudiantMaj.getNom();
            String prenom = etudiantMaj.getPrenom();
            int numero = etudiantMaj.getNumero();
            int groupe = etudiantMaj.getGroupe();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Utilisateur SET Email = email, Password = password,"
                    + " Nom = nom, Prenom = prenom WHERE ID = id");
            rset = stmt.executeQuery("UPDATE Etudiant SET Numero = numero, Groupe = groupe WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Etudiant find(int id) {
        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant actuel = etudiants.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Etudiant pasTrouve = new Etudiant();
        return pasTrouve;
    }
    
    // Pour connexion
    public Etudiant find(String email, String password) {
        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant actuel = etudiants.get(i);
            if ((actuel.getEmail().equals(email)) && (actuel.getPassword().equals(password))) {
                return actuel;
            }
        }
        Etudiant pasTrouve = new Etudiant();
        return pasTrouve;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (etudiants.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Utilisateur, Etudiant"
                        + " WHERE Utilisateur.ID = Etudiant.ID_Utilisateur AND Droit = 4");
                if (rset.first()) {
                    do {
                        Etudiant etudiantActuel = new Etudiant(
                                rset.getInt("ID"),
                                rset.getString("Email"),
                                rset.getString("Password"),
                                rset.getString("Nom"),
                                rset.getString("Prenom"),
                                rset.getInt("Droit"),
                                rset.getInt("Numero"),
                                rset.getInt("ID_Groupe")
                        );
                        etudiants.add(etudiantActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        etudiants.clear();
    }
    
    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }
}
