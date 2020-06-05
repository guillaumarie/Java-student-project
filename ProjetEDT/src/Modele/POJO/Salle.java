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
public class Salle {

    private int m_id = 0;
    private String m_nom = "";
    private int m_capacite = 0;
    private int m_site = 0;

    public Salle(int id, String nom, int capacite, int site) {
        this.m_id = id;
        this.m_nom = nom;
        this.m_capacite = capacite;
        this.m_site = site;
    }

    public Salle() {
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }

    public String getNom() {
        return m_nom;
    }

    public void setNom(String nom) {
        this.m_nom = nom;
    }
    
    public int getCapacite() {
        return m_capacite;
    }

    public void setCapacite(int capacite) {
        this.m_capacite = capacite;
    }
    
    public int getSite() {
        return m_site;
    }

    public void setSite(int site) {
        this.m_site = site;
    }
}
