/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Promo;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class PromoDAO extends BaseDAO<Promo> {

    private final ArrayList<Promo> promos = new ArrayList<>();
    
    public PromoDAO() {
        super();
    }

    @Override
    public void create(Promo promoNv, Connection conn) throws SQLException {
        try {
            String nom = promoNv.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Promotion (Nom) VALUES (nom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Promo promoSup, Connection conn) throws SQLException {
        try {
            int id = promoSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Promotion WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Promo promoMaj, Connection conn) throws SQLException {
        try {
            int id = promoMaj.getId();
            String nom = promoMaj.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Promotion SET Nom = nom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Promo find(int id) {
        for (int i = 0; i < promos.size(); i++) {
            Promo actuel = promos.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Promo pasTrouve = new Promo();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Promo promo = this.find(id);
        String nom = promo.getNom();
        return nom;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (promos.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Promotion");
                if (rset.first()) {
                    do {
                        Promo promoActuelle = new Promo(
                                rset.getInt("ID"),
                                rset.getString("Nom")
                        );
                        promos.add(promoActuelle);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        promos.clear();
    }
    
    public ArrayList<Promo> getPromos() {
        return promos;
    }
}
