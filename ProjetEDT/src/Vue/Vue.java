package Vue;

import Controleur.GestionModele;
import Controleur.GestionVue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import java.util.*;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Vue extends JFrame {

    private String Groupe_Saisi = "";
    private String Salle_Saisi = "";
    private String Nom_Saisi = "";
    private String Semaine_Saisi = "";
    private JTextField TF_Groupe = new JTextField("");
    private JTextField TF_Salle = new JTextField("");
    private JTextField TF_Nom = new JTextField("");
    private JTextField TF_Semaine = new JTextField("");
    private int Semaine = 17;
    private GestionVue gestionVue = null;
    private GestionModele gestionModele = null;

    public Vue(GestionVue gestionVue_con, GestionModele gestionModele_con) {

        gestionVue = gestionVue_con;
        gestionModele = gestionModele_con;
        JFrame application = new JFrame();
        application.setTitle("application");
        application.setSize(1200, 1000);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);

        application.setVisible(true);

        JPanel principal = new JPanel();

        GridBagLayout Principal_Bag = new GridBagLayout();
        principal.setLayout(Principal_Bag);
        GridBagConstraints gbcPrincipal = new GridBagConstraints();

//---------------------------------------------------------------------------------------------------------------------------------------------------------
//                              Barre de Menu
        JMenuBar maBarre = new JMenuBar();
        JMenu mnuCours = new JMenu("Cours");
        JMenuItem mnuEDT = new JMenuItem("Emploi du temps");
        mnuCours.add(mnuEDT);
        JMenuItem mnuRecap = new JMenuItem("Recapitulatif des cours");
        mnuCours.add(mnuRecap);
        maBarre.add(mnuCours);
        JMenu mnuModif = new JMenu("Modification");
        JMenuItem mnuAjout = new JMenuItem("Modifier un cours");
        mnuAjout.addActionListener(new ModifCours());
        mnuModif.add(mnuAjout);
        maBarre.add(mnuModif);
        application.setJMenuBar(maBarre);

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//                              Barre de Recherche
        JPanel searchBag_Panel = new JPanel();

        GridBagLayout searchBar_Bag = new GridBagLayout();
        principal.setLayout(Principal_Bag);
        GridBagConstraints gbcSearchBag = new GridBagConstraints();

        JPanel TF_Groupe_searchBar_Panel = new JPanel();
        JLabel label_Groupe = new JLabel("Recherche par Groupe");
        JButton Button_TF_Search_Groupe = new JButton("OK");
        Button_TF_Search_Groupe.addActionListener(new BoutonListener_Groupe());

        Font police = new Font("Arial", Font.BOLD, 14);
        TF_Groupe.setFont(police);
        TF_Groupe.setPreferredSize(new Dimension(150, 30));
        TF_Groupe.setForeground(Color.BLACK);
        TF_Groupe_searchBar_Panel.add(label_Groupe);
        TF_Groupe_searchBar_Panel.add(TF_Groupe);
        TF_Groupe_searchBar_Panel.add(Button_TF_Search_Groupe);

        gbcSearchBag.gridx = 0;
        gbcSearchBag.gridy = 0;
        gbcSearchBag.gridheight = 1;
        gbcSearchBag.gridwidth = 1;
        searchBag_Panel.add(TF_Groupe_searchBar_Panel, gbcSearchBag);

        JPanel TF_Salle_searchBar_Panel = new JPanel();
        JLabel label_Salle = new JLabel("Recherche par Salle");
        JButton Button_TF_Search_Salle = new JButton("OK");
        Button_TF_Search_Salle.addActionListener(new BoutonListener_Salle());

        TF_Salle.setFont(police);
        TF_Salle.setPreferredSize(new Dimension(150, 30));
        TF_Salle.setForeground(Color.BLACK);
        TF_Salle_searchBar_Panel.add(label_Salle);
        TF_Salle_searchBar_Panel.add(TF_Salle);
        TF_Salle_searchBar_Panel.add(Button_TF_Search_Salle);

        gbcSearchBag.gridx = 0;
        gbcSearchBag.gridy = 1;
        gbcSearchBag.gridheight = 1;
        gbcSearchBag.gridwidth = 1;
        searchBag_Panel.add(TF_Salle_searchBar_Panel, gbcSearchBag);

        JPanel TF_Nom_searchBar_Panel = new JPanel();
        JLabel label_Nom = new JLabel("Recherche par Nom");
        JButton Button_TF_Search_Nom = new JButton("OK");

        Button_TF_Search_Nom.addActionListener(new BoutonListener_Nom());

        TF_Nom.setFont(police);
        TF_Nom.setPreferredSize(new Dimension(150, 30));
        TF_Nom.setForeground(Color.BLACK);
        TF_Nom_searchBar_Panel.add(label_Nom);
        TF_Nom_searchBar_Panel.add(TF_Nom);
        TF_Nom_searchBar_Panel.add(Button_TF_Search_Nom);

        gbcSearchBag.gridx = 0;
        gbcSearchBag.gridy = 2;
        gbcSearchBag.gridheight = 1;
        gbcSearchBag.gridwidth = 1;
        searchBag_Panel.add(TF_Nom_searchBar_Panel, gbcSearchBag);

        JPanel TF_Semaine_searchBar_Panel = new JPanel();
        JLabel label_Semaine = new JLabel("selection de la semaine");
        JButton Button_TF_Search_Semaine = new JButton("OK");
        Button_TF_Search_Semaine.addActionListener(new BoutonListener_Semaine());

        TF_Semaine.setFont(police);
        TF_Semaine.setPreferredSize(new Dimension(150, 30));
        TF_Semaine.setForeground(Color.BLACK);
        TF_Semaine_searchBar_Panel.add(label_Semaine);
        TF_Semaine_searchBar_Panel.add(TF_Semaine);
        TF_Semaine_searchBar_Panel.add(Button_TF_Search_Semaine);

        gbcSearchBag.gridx = 0;
        gbcSearchBag.gridy = 3;
        gbcSearchBag.gridheight = 1;
        gbcSearchBag.gridwidth = 1;
        searchBag_Panel.add(TF_Semaine_searchBar_Panel, gbcSearchBag);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        principal.add(searchBag_Panel, gbcPrincipal);

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//                              Boutons Semaines
        JPanel weeks_Panel = new JPanel();

        GridBagLayout weeks_Bag = new GridBagLayout();
        principal.setLayout(weeks_Bag);
        GridBagConstraints gbcWeeksBag = new GridBagConstraints();

        gbcWeeksBag.gridx = 0;
        gbcWeeksBag.gridy = 0;
        gbcWeeksBag.weightx = 1;
        gbcWeeksBag.weighty = 1;

        for (int i = 0; i < 52; ++i) {
            JPanel panel = new JPanel();
            JButton Button = new JButton(Integer.toString(i));
            gbcSearchBag.gridx = 0;
            gbcSearchBag.gridy = 2;
            panel.add(Button, gbcWeeksBag);
            weeks_Panel.add(panel, gbcWeeksBag);
        }
        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 1;
        //principal.add(weeks_Panel, gbcPrincipal);

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//                              EDT grille        
        //application.removeAll();
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
                }
                for (int lig_case = 0; lig_case < 7; ++lig_case) {

                    if (lig_edt != 0) {
                        case_edt.setPreferredSize(new Dimension(200, 100));
                        JPanel lig_case_edt = new JPanel();
                        String tamp = "";

                        if (lig_edt != 0 && col_edt == 0) {
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
                        }
                        System.out.println("size :" + gestionVue.getSemaines().size());
                        for (int m = 0; m < gestionVue.getSemaines().size(); ++m) {
                            System.out.println("ici");
                            System.out.println(m);
                            if (gestionVue.getSemaines().get(m) == Semaine) {
                                System.out.println(m);
                            }
                        }

                        gbcCase.gridx = 0;
                        gbcCase.gridy = lig_case;
                        gbcCase.weightx = 1;
                        gbcCase.weighty = 1;

                        case_edt.add(lig_case_edt, gbcCase);
                    }
                }

                gbcGrille.gridx = col_edt;
                gbcGrille.gridy = lig_edt;
                EDT.add(case_edt, gbcGrille);
            }
        }
        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 2;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;

        principal.add(EDT, gbcPrincipal);
        application.add(principal);

    }

    class BoutonListener_Groupe implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Groupe_Saisi = TF_Groupe.getText();
            System.out.println("groupe saisi " + Groupe_Saisi);
        }
    }

    class BoutonListener_Salle implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Salle_Saisi = TF_Salle.getText();
            System.out.println("salle saisi " + Salle_Saisi);
        }
    }

    class BoutonListener_Nom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Nom_Saisi = TF_Nom.getText();
            System.out.println("nom saisi " + Nom_Saisi);
        }
    }

    class BoutonListener_Semaine implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Semaine_Saisi = TF_Semaine.getText();
            System.out.println("semaine saisi " + Semaine_Saisi);
        }
    }

    class ModifCours implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            AjoutCours aj = new AjoutCours();
        }
    }

//    public static void main(String[] args) throws Exception {
//        //vue.Connexion con = new vue.Connexion();
//        //Vue fen = new Vue();
//
//    }
}
