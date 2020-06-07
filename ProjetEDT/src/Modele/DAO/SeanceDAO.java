/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Seance;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SeanceDAO extends BaseDAO<Seance> {
    
    private final ArrayList<Seance> seances = new ArrayList<>();
    
    public SeanceDAO() {
        super();
    }

    @Override
    public void create(Seance seanceNv, Connection conn) throws SQLException {
        try {
            int semaine = seanceNv.getSemaine();
            Date date = seanceNv.getDate();
            Time debut = seanceNv.getDebut();
            Time fin = seanceNv.getFin();
            boolean etat = seanceNv.getEtat();
            int cours = seanceNv.getCours();
            int type = seanceNv.getType();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Seance (Semaine, Date, Heure_Debut, Heure_Fin, Etat,"
                    + " ID_Cours, ID_Type) VALUES (semaine, date, debut, fin, etat, cours, type)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Seance seanceSup, Connection conn) throws SQLException {
        try {
            int id = seanceSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Seance WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Seance seanceMaj, Connection conn) throws SQLException {
        try {
            int id = seanceMaj.getId();
            int semaine = seanceMaj.getSemaine();
            Date date = seanceMaj.getDate();
            Time debut = seanceMaj.getDebut();
            Time fin = seanceMaj.getFin();
            boolean etat = seanceMaj.getEtat();
            int cours = seanceMaj.getCours();
            int type = seanceMaj.getType();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Seance SET Semaine = semaine, Date = date, Heure_Debut = debut,"
                    + " Heure_Fin = fin, Etat = etat, ID_Cours = cours, ID_Type = type WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Seance find(int id) {
        for (int i = 0; i < seances.size(); i++) {
            Seance actuel = seances.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Seance pasTrouve = new Seance();
        return pasTrouve;
    }
    
    public int last(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT ID FROM Seance ORDER BY ID DESC LIMIT 1");
        int id = rset.getInt("ID");
        return id;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (seances.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Seance");
                if (rset.first()) {
                    do {
                        Seance seanceActuelle = new Seance(
                                rset.getInt("ID"),
                                rset.getInt("Semaine"),
                                rset.getDate("Date"),
                                rset.getTime("Heure_Debut"),
                                rset.getTime("Heure_Fin"),
                                rset.getBoolean("Etat"),
                                rset.getInt("ID_Cours"),
                                rset.getInt("ID_Type")
                        );
                        seances.add(seanceActuelle);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        seances.clear();
    }
    
    public ArrayList<Seance> getSeances() {
        return seances;
    }
}
