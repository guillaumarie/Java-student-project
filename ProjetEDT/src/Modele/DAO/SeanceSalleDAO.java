/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.SeanceSalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SeanceSalleDAO extends BaseDAO<SeanceSalle> {

    private final ArrayList<SeanceSalle> seanceSalles = new ArrayList<>();
    
    public SeanceSalleDAO() {
        super();
    }

    @Override
    public void create(SeanceSalle ssNv, Connection conn) throws SQLException {
        try {
            int seance = ssNv.getSeance();
            int salle = ssNv.getSalle();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Seance_Salles (ID_Seance, ID_Salle)"
                    + " VALUES (seance, salle)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(SeanceSalle ssSup, Connection conn) throws SQLException {
        try {
            int seance = ssSup.getSeance();
            int salle = ssSup.getSalle();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Seance__Salles WHERE ID_Seance = seance"
                    + " AND ID_Salle = salle");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void update(SeanceSalle ssMaj, Connection conn) throws SQLException {
    }

    public void update(SeanceSalle ssAct, SeanceSalle ssMaj, Connection conn) throws SQLException {
        try {
            int seanceAct = ssAct.getSeance();
            int salleAct = ssAct.getSalle();
            int seanceMaj = ssMaj.getSeance();
            int salleMaj = ssMaj.getSalle();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Seance_Salles SET ID_Seance = seanceMaj,"
                    + " ID_Salle = salleMaj WHERE ID_Seance = seanceAct AND ID_Salle = salleAct");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public SeanceSalle find(int id) {
        SeanceSalle ss = new SeanceSalle();
        return ss;
    }

    public SeanceSalle find(int seance, int salle) {
        for (int i = 0; i < seanceSalles.size()+1; i++) {
            SeanceSalle actuel = seanceSalles.get(i);
            if ((actuel.getSeance() == seance) && (actuel.getSalle() == salle)) {
                return actuel;
            }
        }
        SeanceSalle pasTrouve = new SeanceSalle();
        return pasTrouve;
    }
    
    public ArrayList<Integer> listeIdSalles(int seance) {
        ArrayList<Integer> listeSalles = new ArrayList<>();
        for (int i = 0; i < seanceSalles.size()+1; i++) {
            SeanceSalle actuel = seanceSalles.get(i);
            if (actuel.getSeance() == seance) {
                listeSalles.add(actuel.getSalle());
            }
        }
        return listeSalles;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (seanceSalles.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Seance_Salles");
                if (rset.first()) {
                    do {
                        SeanceSalle ssActuel = new SeanceSalle(
                                rset.getInt("ID_Seance"),
                                rset.getInt("ID_Salle")
                        );
                        seanceSalles.add(ssActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        seanceSalles.clear();
    }
    
    public ArrayList<SeanceSalle> getSS() {
        return seanceSalles;
    }
}
