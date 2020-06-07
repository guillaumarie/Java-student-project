/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.GestionModele;
import Controleur.GestionVue;
import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author killian
 */
public class EDTGrille extends JFrame {

    private GestionVue gestionVue = null;
    private GestionModele gestionModele = null;

    private int Semaine = 0;

    public EDTGrille(GestionVue gestionVue_con, GestionModele gestionModele_con, int Sem) {
        gestionVue = gestionVue_con;
        gestionModele = gestionModele_con;
        Semaine = Sem;
    }

    public JPanel EDT_Grille() {
        String jours[] = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
        String heures[] = {"08h30", "10h00", "10h15", "11h45", "12h00", "13h30", "13h45", "15h15", "15h30", "17h00", "17h15", "18h45", "19h00", "20h30"};
        int cpt_jours = 0;
        // mise en place edt grille

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

        for (int lig_edt = 0; lig_edt < 8; ++lig_edt) {
            for (int col_edt = 0; col_edt < 7; ++col_edt) {

                JPanel case_edt = new JPanel();
                case_edt.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                case_edt.setPreferredSize(new Dimension(200, 30));

                GridBagLayout grille_case_edt = new GridBagLayout();
                case_edt.setLayout(grille_case_edt);
                GridBagConstraints gbcCase = new GridBagConstraints();

                String couleur_Cours = null;
                if (lig_edt == 0 && col_edt != 0) {
                    String tamp = "";
                    JPanel lig_case_edt = new JPanel();

                    tamp = jours[col_edt - 1];
                    lig_case_edt.add(new JLabel(tamp));

                    lig_case_edt.setBackground(Color.ORANGE);
                    case_edt.setBackground(Color.ORANGE);

                    gbcCase.gridx = 0;
                    gbcCase.gridy = 0;
                    gbcCase.weightx = 1;
                    gbcCase.weighty = 1;

                    case_edt.add(lig_case_edt, gbcCase);
                    gbcGrille.gridx = col_edt;
                    gbcGrille.gridy = lig_edt;
                    case_edt.setBackground(Color.ORANGE);
                    EDT.add(case_edt, gbcGrille);
                }

                if (lig_edt != 0 && col_edt == 0) {
                    for (int lig_case = 0; lig_case < 7; ++lig_case) {
                        case_edt.setPreferredSize(new Dimension(200, 100));

                        JPanel lig_case_edt = new JPanel();
                        String tamp = "";

                        if (lig_case == 2 || lig_case == 4) {
                            tamp = heures[cpt_jours];
                            lig_case_edt.add(new JLabel(tamp));
                            ++cpt_jours;
                        }
                        if (lig_case == 3) {
                            tamp = "-";
                            lig_case_edt.add(new JLabel(tamp));

                        }
                        lig_case_edt.setBackground(Color.yellow);
                        case_edt.setBackground(Color.yellow);

                        gbcCase.gridx = 0;
                        gbcCase.gridy = lig_case;
                        gbcCase.weightx = 1;
                        gbcCase.weighty = 1;

                        case_edt.add(lig_case_edt, gbcCase);
                    }
                    gbcGrille.gridx = col_edt;
                    gbcGrille.gridy = lig_edt;
                    case_edt.setBackground(Color.yellow);
                    EDT.add(case_edt, gbcGrille);

                }

            }
        }

        for (int m = 0; m < gestionVue.getSemaines().size(); ++m) {
            JPanel case_edt = new JPanel();
            case_edt.setBorder(BorderFactory.createLineBorder(Color.black, 1));

            GridBagLayout grille_case_edt = new GridBagLayout();
            case_edt.setLayout(grille_case_edt);
            GridBagConstraints gbcCase = new GridBagConstraints();

            int lig = 0;
            int col = 0;

            if (gestionVue.getSemaines().get(m) == Semaine) {

                // répartition sur les colonnes en fonction du jour de la semaine
                Date auj = gestionVue.getDates().get(m);
                SimpleDateFormat formater = null;
                formater = new SimpleDateFormat("EEEE");
                if (formater.format(auj).equals("lundi")) {
                    col = 1;
                }
                if (formater.format(auj).equals("mardi")) {
                    col = 2;
                }
                if (formater.format(auj).equals("mercredi")) {
                    col = 3;
                }
                if (formater.format(auj).equals("jeudi")) {
                    col = 4;
                }
                if (formater.format(auj).equals("vendredi")) {
                    col = 5;
                }
                if (formater.format(auj).equals("samedi")) {
                    col = 6;
                }

                Time heureD = gestionVue.getDebuts().get(m);
                int heure = heureD.getHours();
                int minutes = heureD.getMinutes();
                String hour = String.valueOf(heure) + "h" + String.valueOf(minutes);
                if (hour.equals("8h30")) {
                    lig = 1;
                }
                if (hour.equals("10h15")) {
                    lig = 2;
                }
                if (hour.equals("12h00")) {
                    lig = 3;
                }
                if (hour.equals("13h45")) {
                    lig = 4;
                }
                if (hour.equals("15h30")) {
                    lig = 5;
                }
                if (hour.equals("17h15")) {
                    lig = 6;
                }
                if (hour.equals("19h00")) {
                    lig = 7;
                }

                for (int g = 0; g < 7; ++g) {
                    case_edt.setPreferredSize(new Dimension(200, 100));
                    JPanel lig_case_edt = new JPanel();
                    String tamp = "";

                    if (g == 1) {
                        tamp = gestionVue.getCours().get(m);
                        lig_case_edt.add(new JLabel(tamp));
                        //System.out.println(tamp);

                    }
                    if (g == 2) {
                        tamp = gestionVue.getNomProfs().get(m).get(0);
                        System.out.println(tamp);

                        lig_case_edt.add(new JLabel(tamp));
                        //System.out.println(tamp);

                    }
                    if (g == 3) {
                        tamp = gestionVue.getNomGroupe();
                        lig_case_edt.add(new JLabel(tamp));
                        //System.out.println(tamp);

                    }
                    if (g == 4) {
                        tamp = gestionVue.getSalles().get(m).get(0);
                        lig_case_edt.add(new JLabel(tamp));
                        //System.out.println(tamp);

                    }
                    if (g == 5) {
                        tamp = gestionVue.getTypes().get(m);
                        lig_case_edt.add(new JLabel(tamp));
                        //System.out.println(tamp);

                    }
                    lig_case_edt.setBackground(Color.PINK);
                    gbcCase.gridx = 0;
                    gbcCase.gridy = g;
                    gbcCase.weightx = 1;
                    gbcCase.weighty = 1;
                    case_edt.add(lig_case_edt, gbcCase);

                }
                // si cours annulé ==> rouge
                if (gestionVue.getEtats().get(m) == false) {
                    case_edt.setBackground(Color.RED);
                }

                gbcGrille.gridx = col;
                gbcGrille.gridy = lig;
                case_edt.setBackground(Color.PINK);
                EDT.add(case_edt, gbcGrille);

            }
        }

        return EDT;

    }

}
