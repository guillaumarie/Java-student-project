/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele.POJO;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author guill
 */
public class Seance {

    private int m_id;
    private int m_semaine;
    private Date m_date;
    private Time m_debut;
    private Time m_fin;
    private boolean m_etat;
    private int m_cours;
    private int m_type;

    public Seance(int id, int semaine, Date date, Time debut, Time fin, boolean etat, int cours, int type) {
        this.m_id = id;
        this.m_semaine = semaine;
        this.m_date = date;
        this.m_debut = debut;
        this.m_fin = fin;
        this.m_etat = etat;
        this.m_cours = cours;
        this.m_type = type;
    }
    
    public Seance() {
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        this.m_id = id;
    }
    
    public int getSemaine() {
        return m_semaine;
    }

    public void setSemaine(int semaine) {
        this.m_semaine = semaine;
    }
    
    public Date getDate() {
        return m_date;
    }

    public void setDate(Date date) {
        this.m_date = date;
    }

    public Time getDebut() {
        return m_debut;
    }

    public void setDebut(Time debut) {
        this.m_debut = debut;
    }
    
    public Time getFin() {
        return m_fin;
    }

    public void setFin(Time fin) {
        this.m_fin = fin;
    }
    
    public boolean getEtat() {
        return m_etat;
    }

    public void setEtat(boolean etat) {
        this.m_etat = etat;
    }
    
    public int getCours() {
        return m_cours;
    }

    public void setCours(int cours) {
        this.m_cours = cours;
    }
    
    public int getType() {
        return m_type;
    }

    public void setType(int type) {
        this.m_type = type;
    }
}
