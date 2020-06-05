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
public class Groupe {

    private int m_id = 0;
    private String m_nom = "";
    private int m_promo = 0;

    public Groupe(int id, String nom, int promo) {
        this.m_id = id;
        this.m_nom = nom;
        this.m_promo = promo;
    }

    public Groupe() {
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
    
    public int getPromo() {
        return m_promo;
    }

    public void setPromo(int promo) {
        this.m_promo = promo;
    }
}
