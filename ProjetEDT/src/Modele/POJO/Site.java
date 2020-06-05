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
public class Site {

    private int m_id = 0;
    private String m_nom = "";

    public Site(int id, String nom) {
        this.m_id = id;
        this.m_nom = nom;
    }

    public Site() {
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
}
