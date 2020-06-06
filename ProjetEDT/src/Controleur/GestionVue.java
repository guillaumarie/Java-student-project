/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.POJO.*;
import Vue.Vue;

import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.Connexion;

/**
 *
 * @author guill
 */
public class GestionVue {

    private int typeSession;
    private Admin sessionAdmin;
    private Referent sessionReferent;
    private Enseignant sessionEnseignant;
    private Etudiant sessionEtudiant;

    public GestionVue() {
    }
    

    public void ConnexionUtilisateur(GestionModele gestionModele) {
        String email = "";
        String password = "";
        

        try {
            sessionAdmin = gestionModele.getAdminDAO().find(email, password);
            if (sessionAdmin.getId() != 0) {
                typeSession = 1;
            }
            sessionReferent = gestionModele.getReferentDAO().find(email, password);
            if (sessionReferent.getId() != 0) {
                typeSession = 2;
            }
            sessionEnseignant = gestionModele.getEnseignantDAO().find(email, password);
            if (sessionEnseignant.getId() != 0) {
                typeSession = 3;
            }
            sessionEtudiant = gestionModele.getEtudiantDAO().find(email, password);
            if (sessionEtudiant.getId() != 0) {
                typeSession = 4;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionVue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void genererEDT(GestionModele gestionModele) {
        switch (typeSession) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                try {
                    int id = sessionEnseignant.getId();

                    String nom = sessionEnseignant.getNom();
                    String prenom = sessionEnseignant.getPrenom();
                    ArrayList<Integer> listeSemaines = new ArrayList<>();
                    ArrayList<Date> listeDates = new ArrayList<>();
                    ArrayList<Time> listeHeuresDebut = new ArrayList<>();
                    ArrayList<Time> listeHeuresFin = new ArrayList<>();
                    ArrayList<Boolean> listeEtats = new ArrayList<>();
                    ArrayList<String> listePromos = new ArrayList<>();
                    ArrayList<ArrayList<String>> listeGroupes = new ArrayList<>();
                    ArrayList<String> listeCours = new ArrayList<>();
                    ArrayList<String> listeTypes = new ArrayList<>();
                    ArrayList<String> listeSites = new ArrayList<>();
                    ArrayList<ArrayList<String>> listeSalles = new ArrayList<>();

                    ArrayList<Integer> idSeances = gestionModele.getSEDAO().listeIdSeances(id);
                    for (int i = 0; i < idSeances.size(); i++) {
                        int idActuel = idSeances.get(i);
                        Seance actuelle = gestionModele.getSeanceDAO().find(idActuel);

                        listeSemaines.add(actuelle.getSemaine());
                        listeDates.add(actuelle.getDate());
                        listeHeuresDebut.add(actuelle.getDebut());
                        listeHeuresFin.add(actuelle.getFin());
                        listeEtats.add(actuelle.getEtat());
                        ArrayList<Integer> idGroupes = gestionModele.getSGDAO().listeIdGroupes(idActuel);
                        ArrayList<String> nomsGroupes = new ArrayList<>();
                        for (int j = 0; j < idGroupes.size(); j++) {
                            nomsGroupes.add(gestionModele.getGroupeDAO().nom(idGroupes.get(j)));
                        }
                        int idPromo = gestionModele.getGroupeDAO().idPromo(idGroupes.get(0));
                        String nomPromo = gestionModele.getPromoDAO().nom(idPromo);
                        listePromos.add(nomPromo);
                        listeGroupes.add(nomsGroupes);
                        int idCours = actuelle.getCours();
                        listeCours.add(gestionModele.getCoursDAO().nom(idCours));
                        int idType = actuelle.getType();
                        listeTypes.add(gestionModele.getTypeDAO().nom(idType));
                        ArrayList<Integer> idSallesProf = gestionModele.getSSDAO().listeIdSalles(idActuel);
                        ArrayList<String> nomsSalles = new ArrayList<>();
                        for (int j = 0; j < idSallesProf.size(); j++) {
                            nomsSalles.add(gestionModele.getSalleDAO().nom(idSallesProf.get(j)));
                        }
                        int idSite = gestionModele.getSalleDAO().idSite(idSallesProf.get(0));
                        String nomSite = gestionModele.getSiteDAO().nom(idSite);
                        listeSites.add(nomSite);
                        listeSalles.add(nomsSalles);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GestionVue.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                try {
                    int id = sessionEtudiant.getId();

                    String nom = sessionEtudiant.getNom();
                    String prenom = sessionEtudiant.getPrenom();
                    int numero = sessionEtudiant.getNumero();
                    String promo = "";
                    String groupe = "";
                    ArrayList<Integer> listeSemaines = new ArrayList<>();
                    ArrayList<Date> listeDates = new ArrayList<>();
                    ArrayList<Time> listeHeuresDebut = new ArrayList<>();
                    ArrayList<Time> listeHeuresFin = new ArrayList<>();
                    ArrayList<Boolean> listeEtats = new ArrayList<>();
                    ArrayList<String> listeCours = new ArrayList<>();
                    ArrayList<String> listeTypes = new ArrayList<>();
                    ArrayList<String> listeSites = new ArrayList<>();
                    ArrayList<ArrayList<String>> listeSalles = new ArrayList<>();
                    ArrayList<ArrayList<String>> listeNomProfs = new ArrayList<>();
                    ArrayList<ArrayList<String>> listePrenomProfs = new ArrayList<>();

                    int idGroupe = sessionEtudiant.getGroupe();
                    groupe = gestionModele.getGroupeDAO().nom(idGroupe);
                    int idPromo = gestionModele.getGroupeDAO().idPromo(idGroupe);
                    promo = gestionModele.getPromoDAO().nom(idPromo);
                    ArrayList<Integer> idSeances = gestionModele.getSGDAO().listeIdSeances(idGroupe);
                    for (int i = 0; i < idSeances.size(); i++) {
                        int idActuel = idSeances.get(i);
                        Seance actuelle = gestionModele.getSeanceDAO().find(idActuel);

                        listeSemaines.add(actuelle.getSemaine());
                        listeDates.add(actuelle.getDate());
                        listeHeuresDebut.add(actuelle.getDebut());
                        listeHeuresFin.add(actuelle.getFin());
                        listeEtats.add(actuelle.getEtat());
                        int idCours = actuelle.getCours();
                        listeCours.add(gestionModele.getCoursDAO().nom(idCours));
                        int idType = actuelle.getType();
                        listeTypes.add(gestionModele.getTypeDAO().nom(idType));
                        ArrayList<Integer> idSalles = gestionModele.getSSDAO().listeIdSalles(idActuel);
                        ArrayList<String> nomsSalles = new ArrayList<>();
                        for (int j = 0; j < idSalles.size(); j++) {
                            nomsSalles.add(gestionModele.getSalleDAO().nom(idSalles.get(j)));
                        }
                        int idSite = gestionModele.getSalleDAO().idSite(idSalles.get(0));
                        String nomSite = gestionModele.getSiteDAO().nom(idSite);
                        listeSites.add(nomSite);
                        listeSalles.add(nomsSalles);

                        ArrayList<Integer> idProfs = gestionModele.getSEDAO().listeIdEnseignants(idActuel);
                        ArrayList<String> nomsProfs = new ArrayList<>();
                        ArrayList<String> prenomsProfs = new ArrayList<>();
                        for (int j = 0; j < idProfs.size(); j++) {
                            nomsProfs.add(gestionModele.getEnseignantDAO().nom(idProfs.get(j)));
                            prenomsProfs.add(gestionModele.getEnseignantDAO().prenom(idProfs.get(j)));
                        }
                        listeNomProfs.add(prenomsProfs);
                        listePrenomProfs.add(nomsProfs);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(GestionVue.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}
