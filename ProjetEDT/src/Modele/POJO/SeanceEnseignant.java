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
public class SeanceEnseignant {

    private int m_seance;
    private int m_enseignant;

    public SeanceEnseignant(int seance, int enseignant) {
        this.m_seance = seance;
        this.m_enseignant = enseignant;
    }

    public SeanceEnseignant() {
    }

    public int getSeance() {
        return m_seance;
    }

    public void setSeance(int seance) {
        this.m_seance = seance;
    }

    public int getEnseignant() {
        return m_enseignant;
    }

    public void setEnseignant(int enseignant) {
        this.m_enseignant = enseignant;
    }
}
