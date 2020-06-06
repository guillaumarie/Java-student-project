/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Site;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SiteDAO extends BaseDAO<Site> {

    private final ArrayList<Site> sites = new ArrayList<>();
    
    public SiteDAO() {
        super();
    }

    @Override
    public void create(Site siteNv, Connection conn) throws SQLException {
        try {
            String nom = siteNv.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Site (Nom) VALUES (nom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Site siteSup, Connection conn) throws SQLException {
        try {
            int id = siteSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Site WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Site siteMaj, Connection conn) throws SQLException {
        try {
            int id = siteMaj.getId();
            String nom = siteMaj.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Site SET Nom = nom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Site find(int id) {
        for (int i = 0; i < sites.size()+1; i++) {
            Site actuel = sites.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Site pasTrouve = new Site();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Site site = this.find(id);
        String nom = site.getNom();
        return nom;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (sites.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Site");
                if (rset.first()) {
                    do {
                        Site siteActuel = new Site(
                                rset.getInt("ID"),
                                rset.getString("Nom")
                        );
                        sites.add(siteActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        sites.clear();
    }
    
    public ArrayList<Site> getSites() {
        return sites;
    }
}
