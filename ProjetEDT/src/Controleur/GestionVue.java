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
    
    private int typeSession = 0;
    private Admin sessionAdmin;
    private Referent sessionReferent;
    private Enseignant sessionEnseignant;
    private Etudiant sessionEtudiant;
    
    private int id = 0;
    private String nom = "";
    private String prenom = "";
    private ArrayList<Integer> listeIdSeances = new ArrayList<>();
    private ArrayList<Integer> listeSemaines = new ArrayList<>();
    private ArrayList<Date> listeDates = new ArrayList<>();
    private ArrayList<Time> listeHeuresDebut = new ArrayList<>();
    private ArrayList<Time> listeHeuresFin = new ArrayList<>();
    private ArrayList<Boolean> listeEtats = new ArrayList<>();
    private ArrayList<String> listePromos = new ArrayList<>();
    private ArrayList<ArrayList<String>> listeGroupes = new ArrayList<>();
    private ArrayList<String> listeCours = new ArrayList<>();
    private ArrayList<String> listeTypes = new ArrayList<>();
    private ArrayList<String> listeSites = new ArrayList<>();
    private ArrayList<ArrayList<String>> listeSalles = new ArrayList<>();
    private ArrayList<ArrayList<String>> listeNomProfs = new ArrayList<>();
    private ArrayList<ArrayList<String>> listePrenomProfs = new ArrayList<>();
    private String promo = "";
    private String groupe = "";
    private int numero = 0;
    
    
    public GestionVue() {
    }
    
    public boolean ConnexionUtilisateur(GestionModele gestionModele, String email, String password) {
        sessionAdmin = gestionModele.getAdminDAO().find(email, password);
        if (sessionAdmin.getId() != 0) {
            typeSession = 1;
            return true;
        }
        sessionReferent = gestionModele.getReferentDAO().find(email, password);
        if (sessionReferent.getId() != 0) {
            typeSession = 2;
            return true;
        }
        sessionEnseignant = gestionModele.getEnseignantDAO().find(email, password);
        if (sessionEnseignant.getId() != 0) {
            typeSession = 3;
            return true;
        }
        sessionEtudiant = gestionModele.getEtudiantDAO().find(email, password);
        if (sessionEtudiant.getId() != 0) {
            typeSession = 4;
            return true;
        }
        return false;
    }

    public void genererEDT(GestionModele gestionModele) {
        switch (typeSession) {
            case 1:
                id = sessionAdmin.getId();
                nom = sessionAdmin.getNom();
                prenom = sessionAdmin.getPrenom();

                ArrayList<Seance> seancesAdmin = gestionModele.getSeanceDAO().getSeances();
                for (int i = 0; i < seancesAdmin.size(); i++) {
                    Seance actuelle = seancesAdmin.get(i);

                    listeIdSeances.add(actuelle.getId());
                    listeSemaines.add(actuelle.getSemaine());
                    listeDates.add(actuelle.getDate());
                    listeHeuresDebut.add(actuelle.getDebut());
                    listeHeuresFin.add(actuelle.getFin());
                    listeEtats.add(actuelle.getEtat());
                    ArrayList<Integer> idGroupes = gestionModele.getSGDAO().listeIdGroupes(actuelle.getId());
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
                    ArrayList<Integer> idSallesProf = gestionModele.getSSDAO().listeIdSalles(actuelle.getId());
                    ArrayList<String> nomsSalles = new ArrayList<>();
                    for (int j = 0; j < idSallesProf.size(); j++) {
                        nomsSalles.add(gestionModele.getSalleDAO().nom(idSallesProf.get(j)));
                    }
                    int idSite = gestionModele.getSalleDAO().idSite(idSallesProf.get(0));
                    String nomSite = gestionModele.getSiteDAO().nom(idSite);
                    listeSites.add(nomSite);
                    listeSalles.add(nomsSalles);
                    ArrayList<Integer> idProfs = gestionModele.getSEDAO().listeIdEnseignants(actuelle.getId());
                    ArrayList<String> nomsProfs = new ArrayList<>();
                    ArrayList<String> prenomsProfs = new ArrayList<>();
                    for (int j = 0; j < idProfs.size(); j++) {
                        nomsProfs.add(gestionModele.getEnseignantDAO().nom(idProfs.get(j)));
                        prenomsProfs.add(gestionModele.getEnseignantDAO().prenom(idProfs.get(j)));
                    }
                    listeNomProfs.add(prenomsProfs);
                    listePrenomProfs.add(nomsProfs);

                }
                break;
            case 2:
                id = sessionReferent.getId();
                nom = sessionReferent.getNom();
                prenom = sessionReferent.getPrenom();

                ArrayList<Seance> seancesRef = gestionModele.getSeanceDAO().getSeances();
                for (int i = 0; i < seancesRef.size(); i++) {
                    Seance actuelle = seancesRef.get(i);

                    listeIdSeances.add(actuelle.getId());
                    listeSemaines.add(actuelle.getSemaine());
                    listeDates.add(actuelle.getDate());
                    listeHeuresDebut.add(actuelle.getDebut());
                    listeHeuresFin.add(actuelle.getFin());
                    listeEtats.add(actuelle.getEtat());
                    ArrayList<Integer> idGroupes = gestionModele.getSGDAO().listeIdGroupes(actuelle.getId());
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
                    ArrayList<Integer> idSallesProf = gestionModele.getSSDAO().listeIdSalles(actuelle.getId());
                    ArrayList<String> nomsSalles = new ArrayList<>();
                    for (int j = 0; j < idSallesProf.size(); j++) {
                        nomsSalles.add(gestionModele.getSalleDAO().nom(idSallesProf.get(j)));
                    }
                    int idSite = gestionModele.getSalleDAO().idSite(idSallesProf.get(0));
                    String nomSite = gestionModele.getSiteDAO().nom(idSite);
                    listeSites.add(nomSite);
                    listeSalles.add(nomsSalles);
                    ArrayList<Integer> idProfs = gestionModele.getSEDAO().listeIdEnseignants(actuelle.getId());
                    ArrayList<String> nomsProfs = new ArrayList<>();
                    ArrayList<String> prenomsProfs = new ArrayList<>();
                    for (int j = 0; j < idProfs.size(); j++) {
                        nomsProfs.add(gestionModele.getEnseignantDAO().nom(idProfs.get(j)));
                        prenomsProfs.add(gestionModele.getEnseignantDAO().prenom(idProfs.get(j)));
                    }
                    listeNomProfs.add(prenomsProfs);
                    listePrenomProfs.add(nomsProfs);

                }
                break;
            case 3:
                id = sessionEnseignant.getId();
                nom = sessionEnseignant.getNom();
                prenom = sessionEnseignant.getPrenom();

                ArrayList<Integer> idSeancesProf = gestionModele.getSEDAO().listeIdSeances(id);
                for (int i = 0; i < idSeancesProf.size(); i++) {
                    int idActuel = idSeancesProf.get(i);
                    Seance actuelle = gestionModele.getSeanceDAO().find(idActuel);

                    listeIdSeances.add(idActuel);
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
                break;
            case 4:
                id = sessionEtudiant.getId();
                nom = sessionEtudiant.getNom();
                prenom = sessionEtudiant.getPrenom();
                numero = sessionEtudiant.getNumero();

                int idGroupe = sessionEtudiant.getGroupe();
                groupe = gestionModele.getGroupeDAO().nom(idGroupe);
                int idPromo = gestionModele.getGroupeDAO().idPromo(idGroupe);
                promo = gestionModele.getPromoDAO().nom(idPromo);
                ArrayList<Integer> idSeancesEtudiant = gestionModele.getSGDAO().listeIdSeances(idGroupe);
                for (int i = 0; i < idSeancesEtudiant.size(); i++) {
                    int idActuel = idSeancesEtudiant.get(i);
                    Seance actuelle = gestionModele.getSeanceDAO().find(idActuel);

                    listeIdSeances.add(idActuel);
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
                break;
        }
    }
    
    // Getters pour Vue
    public int getTypeSession() {return typeSession;}
    public Admin getAdmin() {return sessionAdmin;}
    public Referent getReferent() {return sessionReferent;}
    public Enseignant getEnseignant() {return sessionEnseignant;}
    public Etudiant getEtudiant() {return sessionEtudiant;}
    
    public int getId() {return id;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public ArrayList<Integer> getIdSeances() {return listeIdSeances;}
    public ArrayList<Integer> getSemaines() {return listeSemaines;}
    public ArrayList<Date> getDates() {return listeDates;}
    public ArrayList<Time> getDebuts() {return listeHeuresDebut;}
    public ArrayList<Time> getFins() {return listeHeuresFin;}
    public ArrayList<Boolean> getEtats() {return listeEtats;}
    public ArrayList<String> getCours() {return listeCours;}
    public ArrayList<String> getTypes() {return listeTypes;}
    public ArrayList<String> getSites() {return listeSites;}
    public ArrayList<ArrayList<String>> getSalles() {return listeSalles;}
    // Uniquement pout Enseignant
    public ArrayList<String> getPromos() {return listePromos;}
    public ArrayList<ArrayList<String>> getGroupes() {return listeGroupes;}
    // Uniquement pour Etudiant
    public ArrayList<ArrayList<String>> getNomProfs() {return listeNomProfs;}
    public ArrayList<ArrayList<String>> getPrenomProfs() {return listePrenomProfs;}
    public String getNomPromo() {return promo;}
    public String getNomGroupe() {return groupe;}
    public int getNumero() {return numero;}
}
