/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.SeanceEnseignant;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class SeanceEnseignantDAO extends BaseDAO<SeanceEnseignant> {

    private final ArrayList<SeanceEnseignant> seanceEnseignants = new ArrayList<>();
    
    public SeanceEnseignantDAO() {
        super();
    }

    @Override
    public void create(SeanceEnseignant seNv, Connection conn) throws SQLException {
        try {
            int seance = seNv.getSeance();
            int enseignant = seNv.getEnseignant();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Seance_Enseignants (ID_Seance, ID_Enseignant)"
                    + " VALUES (seance, enseignant)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(SeanceEnseignant seSup, Connection conn) throws SQLException {
        try {
            int seance = seSup.getSeance();
            int enseignant = seSup.getEnseignant();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Seance_Enseignants WHERE ID_Seance = seance"
                    + " AND ID_Enseignant = enseignant");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public void update(SeanceEnseignant seMaj, Connection conn) throws SQLException {
    }

    public void update(SeanceEnseignant seAct, SeanceEnseignant seMaj, Connection conn) throws SQLException {
        try {
            int seanceAct = seAct.getSeance();
            int enseignantAct = seAct.getEnseignant();
            int seanceMaj = seMaj.getSeance();
            int enseignantMaj = seMaj.getEnseignant();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Seance_Enseignants SET ID_Seance = seanceMaj,"
                    + " ID_Enseignant = enseignantMaj WHERE ID_Seance = seanceAct AND ID_Enseignant = enseignantAct");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public SeanceEnseignant find(int id) {
        SeanceEnseignant se = new SeanceEnseignant();
        return se;
    }

    public SeanceEnseignant find(int seance, int enseignant) {
        for (int i = 0; i < seanceEnseignants.size()+1; i++) {
            SeanceEnseignant actuel = seanceEnseignants.get(i);
            if ((actuel.getSeance() == seance) && (actuel.getEnseignant() == enseignant)) {
                return actuel;
            }
        }
        SeanceEnseignant pasTrouve = new SeanceEnseignant();
        return pasTrouve;
    }
    
    public ArrayList<Integer> listeIdSeances(int idProf) {
        ArrayList<Integer> listeSeances = new ArrayList<>();
        SeanceEnseignant actuel = seanceEnseignants.get(0);
        for (int i = 1; i < seanceEnseignants.size()+1; i++) {
            if (actuel.getEnseignant() == idProf) {
                listeSeances.add(actuel.getSeance());
            }
            actuel = seanceEnseignants.get(i);
        }
        return listeSeances;
    }
    
    public ArrayList<Integer> listeIdEnseignants(int seance) {
        ArrayList<Integer> listeEnseignants = new ArrayList<>();
        SeanceEnseignant actuel = seanceEnseignants.get(0);
        for (int i = 1; i < seanceEnseignants.size()+1; i++) {
            if (actuel.getSeance() == seance) {
                listeEnseignants.add(actuel.getEnseignant());
            }
            actuel = seanceEnseignants.get(i);
        }
        return listeEnseignants;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (seanceEnseignants.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Seance_Enseignants");
                if (rset.first()) {
                    do {
                        SeanceEnseignant seActuel = new SeanceEnseignant(
                                rset.getInt("ID_Seance"),
                                rset.getInt("ID_Enseignant")
                        );
                        seanceEnseignants.add(seActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        seanceEnseignants.clear();
    }
    
    public ArrayList<SeanceEnseignant> getSE() {
        return seanceEnseignants;
    }
}
