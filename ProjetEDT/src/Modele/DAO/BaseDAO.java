/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.DAO;

import java.sql.*;

/**
 *
 * @author guill
 */
/**
 *
 * @param <T>
 */
public abstract class BaseDAO<T> {
    /**
     * 
     * Constructeur
     */
    public BaseDAO() {
    }

    /**
     * Méthode de création
     *
     * @param obj
     * @param conn
     * @throws java.sql.SQLException
     */
    public abstract void create(T obj, Connection conn) throws SQLException;

    /**
     * Méthode pour effacer
     *
     * @param obj
     * @param conn
     * @throws java.sql.SQLException
     */
    public abstract void delete(T obj, Connection conn) throws SQLException;

    /**
     * Méthode de mise à jour
     *
     * @param obj
     * @param conn
     * @throws java.sql.SQLException
     */
    public abstract void update(T obj, Connection conn) throws SQLException;

    /**
     * Méthode de recherche des informations
     *
     * @param obj
     * @return T
     * @throws java.sql.SQLException
     */
    public abstract T find(int obj) throws SQLException;
    
    /**
     * Méthode pour récupérer tous les éléments d'une table de la BDD et les ajouter à un ArrayList
     *
     * @param conn
     * @throws java.sql.SQLException
     */
    public abstract void init(Connection conn) throws SQLException;
    
    /**
     * Méthode pour vider les ArrayList
     *
     */
    public abstract void vider();
}
