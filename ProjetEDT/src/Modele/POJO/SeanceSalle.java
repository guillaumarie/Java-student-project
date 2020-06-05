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
public class SeanceSalle{

    private int m_seance;
    private int m_salle;

    public SeanceSalle(int seance, int salle) {
        this.m_seance = seance;
        this.m_salle = salle;
    }

    public SeanceSalle() {
    }

    public int getSeance() {
        return m_seance;
    }

    public void setSeance(int seance) {
        this.m_seance = seance;
    }

    public int getSalle() {
        return m_salle;
    }

    public void setSalle(int salle) {
        this.m_salle = salle;
    }
}
