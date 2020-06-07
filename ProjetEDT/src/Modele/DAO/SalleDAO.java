/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Salle;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SalleDAO extends BaseDAO<Salle> {

    private final ArrayList<Salle> salles = new ArrayList<>();
    
    public SalleDAO() {
        super();
    }

    @Override
    public void create(Salle salleNv, Connection conn) throws SQLException {
        try {
            String nom = salleNv.getNom();
            int capacite = salleNv.getCapacite();
            int site = salleNv.getSite();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Salle (Nom, Capacite, ID_Site)"
                    + " VALUES (nom, capacite, site)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Salle salleSup, Connection conn) throws SQLException {
        try {
            int id = salleSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Salle WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Salle salleMaj, Connection conn) throws SQLException {
        try {
            int id = salleMaj.getId();
            String nom = salleMaj.getNom();
            int capacite = salleMaj.getCapacite();
            int site = salleMaj.getSite();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Salle SET Nom = nom, Capacite = capacite,"
                    + " ID_Site = site WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Salle find(int id) {
        for (int i = 0; i < salles.size(); i++) {
            Salle actuel = salles.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Salle pasTrouve = new Salle();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Salle salle = this.find(id);
        String nom = salle.getNom();
        return nom;
    }
    
    public int idSite(int id) {
        Salle salle = this.find(id);
        int idSite = salle.getSite();
        return idSite;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (salles.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Salle");
                if (rset.first()) {
                    do {
                        Salle salleActuelle = new Salle(
                                rset.getInt("ID"),
                                rset.getString("Nom"),
                                rset.getInt("Capacite"),
                                rset.getInt("ID_Site")
                        );
                        salles.add(salleActuelle);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        salles.clear();
    }
    
    public ArrayList<Salle> getSalles() {
        return salles;
    }
}
