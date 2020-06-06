/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Groupe;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class GroupeDAO extends BaseDAO<Groupe> {

    private final ArrayList<Groupe> groupes = new ArrayList<>();
    
    public GroupeDAO() {
        super();
    }

    @Override
    public void create(Groupe groupeNv, Connection conn) throws SQLException {
        try {
            String nom = groupeNv.getNom();
            int promo = groupeNv.getPromo();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Groupe (Nom, ID_Promotion) VALUES (nom, promo)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Groupe groupeSup, Connection conn) throws SQLException {
        try {
            int id = groupeSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Groupe WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Groupe groupeMaj, Connection conn) throws SQLException {
        try {
            int id = groupeMaj.getId();
            String nom = groupeMaj.getNom();
            int promo = groupeMaj.getPromo();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Groupe SET Nom = nom, ID_Promotion = promo WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Groupe find(int id) {
        for (int i = 0; i < groupes.size()+1; i++) {
            Groupe actuel = groupes.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Groupe pasTrouve = new Groupe();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Groupe groupe = this.find(id);
        String nom = groupe.getNom();
        return nom;
    }
    
    public int idPromo(int id) {
        Groupe groupe = this.find(id);
        int idPromo = groupe.getPromo();
        return idPromo;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (groupes.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Groupe");
                if (rset.first()) {
                    do {
                        Groupe groupeActuel = new Groupe(
                                rset.getInt("ID"),
                                rset.getString("Nom"),
                                rset.getInt("ID_Promotion")
                        );
                        groupes.add(groupeActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        groupes.clear();
    }
    
    public ArrayList<Groupe> getGroupes() {
        return groupes;
    }
}
