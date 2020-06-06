/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Cours;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class CoursDAO extends BaseDAO<Cours> {

    private final ArrayList<Cours> cours = new ArrayList<>();
    
    public CoursDAO() {
        super();
    }

    @Override
    public void create(Cours coursNv, Connection conn) throws SQLException {
        try {
            String nom = coursNv.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Cours (Nom) VALUES (nom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Cours coursSup, Connection conn) throws SQLException {
        try {
            int id = coursSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Cours WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Cours coursMaj, Connection conn) throws SQLException {
        try {
            int id = coursMaj.getId();
            String nom = coursMaj.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Cours SET Nom = nom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Cours find(int id) {
        for (int i = 0; i < cours.size()+1; i++) {
            Cours actuel = cours.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Cours pasTrouve = new Cours();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Cours cours = this.find(id);
        String nom = cours.getNom();
        return nom;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (cours.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Cours");
                if (rset.first()) {
                    do {
                        Cours coursActuel = new Cours(
                                rset.getInt("ID"),
                                rset.getString("Nom")
                        );
                        cours.add(coursActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        cours.clear();
    }
    
    public ArrayList<Cours> getCours() {
        return cours;
    }
}
