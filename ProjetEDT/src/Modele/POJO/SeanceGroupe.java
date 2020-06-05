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
public class SeanceGroupe {

    private int m_seance;
    private int m_groupe;

    public SeanceGroupe(int seance, int groupe) {
        this.m_seance = seance;
        this.m_groupe = groupe;
    }

    public SeanceGroupe() {
    }

    public int getSeance() {
        return m_seance;
    }

    public void setSeance(int seance) {
        this.m_seance = seance;
    }

    public int getGroupe() {
        return m_groupe;
    }

    public void setGroupe(int groupe) {
        this.m_groupe = groupe;
    }
}
