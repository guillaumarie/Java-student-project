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
public class Type {

    private int m_id;
    private String m_nom;

    public Type(int id, String nom) {
        this.m_id = id;
        this.m_nom = nom;
    }

    public Type() {
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
