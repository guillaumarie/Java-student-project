/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.POJO;

/**
 *
 * @author guill
 */
public abstract class Utilisateur {

    protected int m_id = 0;
    protected String m_email = "";
    protected String m_password = "";
    protected String m_nom = "";
    protected String m_prenom = "";
    protected int m_droit = 0;

    public Utilisateur(int id, String email, String password, String nom, String prenom, int droit) {
        this.m_id = id;
        this.m_email = email;
        this.m_password = password;
        this.m_nom = nom;
        this.m_prenom = prenom;
        this.m_droit = droit;
    }
    
    public Utilisateur() {
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }
    
    public String getEmail() {
        return m_email;
    }

    public void setEmail(String email) {
        this.m_email = email;
    }
    
    public String getPassword() {
        return m_password;
    }

    public void setPassword(String password) {
        this.m_password = password;
    }

    public String getNom() {
        return m_nom;
    }

    public void setNom(String nom) {
        this.m_nom = nom;
    }
    
    public String getPrenom() {
        return m_prenom;
    }

    public void setPrenom(String prenom) {
        this.m_prenom = prenom;
    }
    
    public int getDroit() {
        return m_droit;
    }

    public void setDroit(int droit) {
        this.m_droit = droit;
    }
}
