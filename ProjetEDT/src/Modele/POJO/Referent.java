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
public class Referent extends Utilisateur {
    
    public Referent(int id, String email, String password, String nom, String prenom, int droit) {
        super(id, email, password, nom, prenom, droit);
    }
    
    public Referent() {
    }
    
    @Override
    public int getId() {
        return m_id;
    }

    @Override
    public void setId(int id) {
        this.m_id = id;
    }
    
    @Override
    public String getEmail() {
        return m_email;
    }

    @Override
    public void setEmail(String email) {
        this.m_email = email;
    }
    
    @Override
    public String getPassword() {
        return m_password;
    }

    @Override
    public void setPassword(String password) {
        this.m_password = password;
    }

    @Override
    public String getNom() {
        return m_nom;
    }

    @Override
    public void setNom(String nom) {
        this.m_nom = nom;
    }
    
    @Override
    public String getPrenom() {
        return m_prenom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.m_prenom = prenom;
    }
    
    @Override
    public int getDroit() {
        return m_droit;
    }

    @Override
    public void setDroit(int droit) {
        this.m_droit = droit;
    }
}
