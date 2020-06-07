/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.GestionModele;
import Controleur.GestionVue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author killian
 */
public class EDTListe extends JFrame {

    private GestionVue gestionVue = null;
    private GestionModele gestionModele = null;

    private int Semaine = 0;

    public EDTListe(GestionVue gestionVue_con, GestionModele gestionModele_con, int Sem) {
        gestionVue = gestionVue_con;
        gestionModele = gestionModele_con;
        Semaine = Sem;
    }

    public JPanel EDT_Grille() {
        JPanel EDT = new JPanel();

        GridBagLayout grille_edt = new GridBagLayout();
        EDT.setLayout(grille_edt);
        GridBagConstraints gbcGrille = new GridBagConstraints();

        gbcGrille.gridx = 0;
        gbcGrille.gridy = 0;

        gbcGrille.weightx = 1;
        gbcGrille.weighty = 1;

        gbcGrille.fill = GridBagConstraints.BOTH;
        gbcGrille.anchor = GridBagConstraints.CENTER;

        JPanel lundi = Jour_Panel("lundi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 0;
        lundi.setPreferredSize(new Dimension(600, 100));

        EDT.add(lundi, gbcGrille);
        JPanel mardi = Jour_Panel("mardi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 1;
        EDT.add(mardi, gbcGrille);
        JPanel mercredi = Jour_Panel("mercredi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 2;
        EDT.add(mercredi, gbcGrille);
        JPanel jeudi = Jour_Panel("jeudi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 3;
        EDT.add(jeudi, gbcGrille);
        JPanel vendredi = Jour_Panel("vendredi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 4;
        EDT.add(vendredi, gbcGrille);
        JPanel samedi = Jour_Panel("samedi");
        gbcGrille.gridx = 0;
        gbcGrille.gridy = 5;
        EDT.add(samedi, gbcGrille);

//        JScrollPane js=new JScrollPane(EDT);
//        js.setVisible(true);
//        add(js);
        return EDT;
    }

    public JPanel Jour_Panel(String Jour) {
        JPanel panelLundi = new JPanel();
        int cpt = 0;

        GridBagLayout jour_edt = new GridBagLayout();
        panelLundi.setLayout(jour_edt);
        GridBagConstraints gbcJour = new GridBagConstraints();

        gbcJour.gridx = 0;
        gbcJour.gridy = 0;

        gbcJour.weightx = 1;
        gbcJour.weighty = 1;

        gbcJour.fill = GridBagConstraints.BOTH;
        gbcJour.anchor = GridBagConstraints.CENTER;
        String heures = "salut";

        for (int m = 0; m < gestionVue.getSemaines().size(); ++m) {

            if (gestionVue.getSemaines().get(m) == Semaine) {

                Date auj = gestionVue.getDates().get(m);
                SimpleDateFormat formater = null;
                formater = new SimpleDateFormat("EEEE");
                
                Date dateAffiche = gestionVue.getDates().get(m);
                SimpleDateFormat formaterAffiche = null;
                formaterAffiche = new SimpleDateFormat("EEE d MMMM yyyy");

                if (formater.format(auj).equals(Jour)) {
                    if (cpt == 0) {
                        // ajout date 
                        JPanel dateP = new JPanel();
                        JLabel date = new JLabel(formaterAffiche.format(dateAffiche));
                        dateP.add(date);
                        gbcJour.gridx = 0;
                        gbcJour.gridy = 0;
                        panelLundi.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                        dateP.setBackground(Color.yellow);

                        panelLundi.add(dateP, gbcJour);
                        cpt++;
                    }
                    
                    JPanel panel_cours = new JPanel();
                    GridBagLayout cours_edt = new GridBagLayout();
                    panel_cours.setLayout(cours_edt);
                    GridBagConstraints gbcCours = new GridBagConstraints();

                    gbcCours.gridx = 0;
                    gbcCours.gridy = 0;

                    gbcCours.weightx = 1;
                    gbcCours.weighty = 1;

                    gbcCours.fill = GridBagConstraints.BOTH;
                    gbcCours.anchor = GridBagConstraints.CENTER;

                    Time heureD = gestionVue.getDebuts().get(m);
                    int heure = heureD.getHours();
                    int minutes = heureD.getMinutes();
                    String hour = String.valueOf(heure) + "h" + String.valueOf(minutes);

                    Time heureF = gestionVue.getFins().get(m);
                    int heuref = heureF.getHours();
                    int minutesf = heureF.getMinutes();
                    String hourf = String.valueOf(heuref) + "h" + String.valueOf(minutesf);

                    heures = hour + " - " + hourf;
                    JPanel pheure = new JPanel();
                    JLabel jheure = new JLabel(heures);
                    pheure.add(jheure);
                    gbcCours.gridx = 0;
                    gbcCours.gridy = 0;
                    pheure.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    pheure.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(pheure, gbcCours);

                    String cours = gestionVue.getCours().get(m);
                    JPanel pcours = new JPanel();
                    JLabel jcours = new JLabel(cours);
                    pcours.add(jcours);
                    gbcCours.gridx = 1;
                    gbcCours.gridy = 0;
                    pcours.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    pcours.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(pcours, gbcCours);

                    String prof = gestionVue.getNomProfs().get(m).get(0);
                    System.out.println(prof);
                    JPanel pprof = new JPanel();
                    JLabel jprof = new JLabel(prof);
                    pprof.add(jprof);
                    gbcCours.gridx = 2;
                    gbcCours.gridy = 0;
                    pprof.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    pprof.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(pprof, gbcCours);

                    String groupe = gestionVue.getNomGroupe();
                    JPanel pgroupe = new JPanel();
                    JLabel jgroupe = new JLabel(groupe);
                    pgroupe.add(jgroupe);
                    gbcCours.gridx = 3;
                    gbcCours.gridy = 0;
                    pgroupe.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    pgroupe.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(pgroupe, gbcCours);

                    String salle = gestionVue.getSalles().get(m).get(0);
                    JPanel psalle = new JPanel();
                    JLabel jsalle = new JLabel(salle);
                    psalle.add(jsalle);
                    gbcCours.gridx = 4;
                    gbcCours.gridy = 0;
                    psalle.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    psalle.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(psalle, gbcCours);

                    String type = gestionVue.getTypes().get(m);
                    JPanel ptype = new JPanel();
                    JLabel jtype = new JLabel(type);
                    ptype.add(jtype);
                    gbcCours.gridx = 5;
                    gbcCours.gridy = 0;
                    ptype.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    ptype.setPreferredSize(new Dimension(200, 30));

                    panel_cours.add(ptype, gbcCours);
                    panelLundi.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                    gbcJour.gridx = 0;
                    gbcJour.gridy = cpt;
                    panelLundi.add(panel_cours, gbcJour);
                    cpt++;
                }
            }
        }

        return panelLundi;
    }
}
