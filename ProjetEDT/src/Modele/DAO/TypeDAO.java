/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import Modele.POJO.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guill
 */
public class TypeDAO extends BaseDAO<Type> {

    private final ArrayList<Type> types = new ArrayList<>();
    
    public TypeDAO() {
        super();
    }

    @Override
    public void create(Type typeNv, Connection conn) throws SQLException {
        try {
            String nom = typeNv.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("INSERT INTO Type_Cours (Nom) VALUES (nom)");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Type typeSup, Connection conn) throws SQLException {
        try {
            int id = typeSup.getId();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("DELETE FROM Type_Cours WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Type typeMaj, Connection conn) throws SQLException {
        try {
            int id = typeMaj.getId();
            String nom = typeMaj.getNom();
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("UPDATE Type_Cours SET Nom = nom WHERE ID = id");
        } catch (SQLException e) {
            Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Type find(int id) {
        for (int i = 0; i < types.size(); i++) {
            Type actuel = types.get(i);
            if (actuel.getId() == id) {
                return actuel;
            }
        }
        Type pasTrouve = new Type();
        return pasTrouve;
    }
    
    public String nom(int id) {
        Type type = this.find(id);
        String nom = type.getNom();
        return nom;
    }
    
    @Override
    public void init(Connection conn) throws SQLException {
        if (types.isEmpty()) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery("SELECT * FROM Type_Cours");
                if (rset.first()) {
                    do {
                        Type typeActuel = new Type(
                                rset.getInt("ID"),
                                rset.getString("Nom")
                        );
                        types.add(typeActuel);
                    } while (rset.next());
                }
            } catch (SQLException e) {
                Logger.getLogger(CoursDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    @Override
    public void vider() {
        types.clear();
    }
    
    public ArrayList<Type> getTypes() {
        return types;
    }
}
