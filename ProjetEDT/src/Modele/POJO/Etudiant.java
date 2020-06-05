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
public class Etudiant extends Utilisateur {

    private int m_numero;
    private int m_groupe;

    public Etudiant(int id, String email, String password, String nom, String prenom, int droit, int numero, int groupe) {
        super(id, email, password, nom, prenom, droit);
        this.m_numero = numero;
        this.m_groupe = groupe;
    }
    
    public Etudiant() {
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
    
    public int getNumero() {
        return m_numero;
    }

    public void setNumero(int numero) {
        this.m_numero = numero;
    }
    
    public int getGroupe() {
        return m_groupe;
    }

    public void setGroupe(int groupe) {
        this.m_groupe = groupe;
    }
}
