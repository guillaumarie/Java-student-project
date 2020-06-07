/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.SeanceGroupe;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SeanceGroupeDAO extends BaseDAO<SeanceGroupe> {

    private final ArrayList<SeanceGroupe> seanceGroupes = new ArrayList<>();
    
    public SeanceGroupeDAO() {
        super();
    }

    @Override
    public void create(SeanceGroupe sgNv, Connection conn) throws SQLException {
        try {
            int seance = sgNv.getSeance();
            int groupe = sgNv.getGroupe();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Seance_Groupes (ID_Seance, ID_Groupe)"
                    + " VALUES (seance, groupe)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(SeanceGroupe sgSup, Connection conn) throws SQLException {
        try {
            int seance = sgSup.getSeance();
            int groupe = sgSup.getGroupe();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Seance_Groupes WHERE ID_Seance = seance"
                    + " AND ID_Groupe = groupe");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void update(SeanceGroupe sgMaj, Connection conn) throws SQLException {
    }

    public void update(SeanceGroupe sgAct, SeanceGroupe sgMaj, Connection conn) throws SQLException {
        try {
            int seanceAct = sgAct.getSeance();
            int groupeAct = sgAct.getGroupe();
            int seanceMaj = sgMaj.getSeance();
            int groupeMaj = sgMaj.getGroupe();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Seance_Groupes SET ID_Seance = seanceMaj,"
                    + " ID_Groupe = groupeMaj WHERE ID_Seance = seanceAct AND ID_Groupe = groupeAct");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public SeanceGroupe find(int id) {
        SeanceGroupe sg = new SeanceGroupe();
        return sg;
    }

    public SeanceGroupe find(int seance, int groupe) {
        for (int i = 0; i < seanceGroupes.size(); i++) {
            SeanceGroupe actuel = seanceGroupes.get(i);
            if ((actuel.getSeance() == seance) && (actuel.getGroupe() == groupe)) {
                return actuel;
            }
        }
        SeanceGroupe pasTrouve = new SeanceGroupe();
        return pasTrouve;
    }
    
    public ArrayList<Integer> listeIdSeances(int groupe) {
        ArrayList<Integer> listeSeances = new ArrayList<>();
        for (int i = 0; i < seanceGroupes.size(); i++) {
            SeanceGroupe actuel = seanceGroupes.get(i);
            if (actuel.getGroupe() == groupe) {
                listeSeances.add(actuel.getSeance());
            }
        }
        return listeSeances;
    }
    
    public ArrayList<Integer> listeIdGroupes(int seance) {
        ArrayList<Integer> listeGroupes = new ArrayList<>();
        for (int i = 0; i < seanceGroupes.size(); i++) {
            SeanceGroupe actuel = seanceGroupes.get(i);
            if (actuel.getSeance() == seance) {
                listeGroupes.add(actuel.getGroupe());
            }
        }
        return listeGroupes;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (seanceGroupes.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Seance_Groupes");
                if (rset.first()) {
                    do {
                        SeanceGroupe sgActuel = new SeanceGroupe(
                                rset.getInt("ID_Seance"),
                                rset.getInt("ID_Groupe")
                        );
                        seanceGroupes.add(sgActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        seanceGroupes.clear();
    }
    
    public ArrayList<SeanceGroupe> getSG() {
        return seanceGroupes;
    }
}
