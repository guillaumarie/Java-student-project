package Vue;

import Controleur.GestionModele;
import Controleur.GestionVue;
import Vue.EDTGrille;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private int Semaine_Saisi = 0;
    private int format = 0;
    private JTextField TF_Groupe = new JTextField("");
    private JTextField TF_Salle = new JTextField("");
    private JTextField TF_Nom = new JTextField("");
    private JTextField TF_Semaine = new JTextField("");
    private GestionVue gestionVue = null;
    private GestionModele gestionModele = null;

    public class BoutonListener_Groupe implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Groupe_Saisi = TF_Groupe.getText();
            System.out.println("groupe saisi " + Groupe_Saisi);
        }
    }

    public class BoutonListener_Salle implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Salle_Saisi = TF_Salle.getText();
            System.out.println("salle saisi " + Salle_Saisi);
        }
    }

    public class BoutonListener_Nom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Nom_Saisi = TF_Nom.getText();
            System.out.println("nom saisi " + Nom_Saisi);
        }
    }

    public class BoutonListener_Semaine implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            Semaine_Saisi = Integer.parseInt(TF_Semaine.getText());
            System.out.println("semaine saisi " + Semaine_Saisi);
            Vue nouv = new Vue(gestionVue, gestionModele, Semaine_Saisi, format);
            close();
        }
    }

    public class EDTGrillelistener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Vue nouv = new Vue(gestionVue, gestionModele, Semaine_Saisi, 1);
            close();
        }
    }

    public class EDTListelistener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Vue nouv = new Vue(gestionVue, gestionModele, Semaine_Saisi, 2);
            close();
        }
    }

    public Vue(GestionVue gestionVue_con, GestionModele gestionModele_con, int semaine, int formatEdt) {

        gestionVue = gestionVue_con;
        gestionModele = gestionModele_con;
        Semaine_Saisi = semaine;
        format = formatEdt;
        //JFrame this = new JFrame();
        this.setTitle("application");
        this.setSize(1200, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //this.dispose();
        JPanel principal = new JPanel();

        GridBagLayout Principal_Bag = new GridBagLayout();
        principal.setLayout(Principal_Bag);
        GridBagConstraints gbcPrincipal = new GridBagConstraints();

//---------------------------------------------------------------------------------------------------------------------------------------------------------
//                              Barre de Menu
        JMenuBar maBarre = Barre_Menu();
        this.setJMenuBar(maBarre);

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//                              Barre de Recherche
        JPanel searchBag_Panel = Barre_Recherche();

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        principal.add(searchBag_Panel, gbcPrincipal);

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//                              EDT grille        
        if (format == 1) {
            //this.removeAll();
            EDTGrille EDT_Grille = new EDTGrille(gestionVue, gestionModele, Semaine_Saisi);

            JPanel EDT = EDT_Grille.EDT_Grille();

            gbcPrincipal.gridx = 0;
            gbcPrincipal.gridy = 1;
            gbcPrincipal.gridheight = 1;
            gbcPrincipal.gridwidth = 1;
            principal.add(EDT, gbcPrincipal);

        }
        if(format == 2){
            //this.removeAll();
            EDTListe EDT_Liste = new EDTListe(gestionVue, gestionModele, Semaine_Saisi);

            JPanel EDT = EDT_Liste.EDT_Grille();

            gbcPrincipal.gridx = 0;
            gbcPrincipal.gridy = 1;
            gbcPrincipal.gridheight = 1;
            gbcPrincipal.gridwidth = 1;
            principal.add(EDT, gbcPrincipal);
        }

        

        this.add(principal);

    }

    public void close() {
        this.dispose();
    }

    public JMenuBar Barre_Menu() {
        JMenuBar maBarre = new JMenuBar();
        JMenu mnuCours = new JMenu("Cours");
        JMenuItem mnuEDT = new JMenuItem("Emploi du temps");
        mnuCours.add(mnuEDT);
        JMenuItem mnuRecap = new JMenuItem("Recapitulatif des cours");
        mnuCours.add(mnuRecap);
        maBarre.add(mnuCours);

        JMenu mnuFormat = new JMenu("Format EDT");
        JMenuItem mnuGrille = new JMenuItem("En grille");
        mnuGrille.addActionListener(new EDTGrillelistener());
        mnuFormat.add(mnuGrille);
        JMenuItem mnuListe = new JMenuItem("En liste");
        mnuListe.addActionListener(new EDTListelistener());
        mnuFormat.add(mnuListe);
        maBarre.add(mnuFormat);

        JMenu mnuModif = new JMenu("Modification");
        JMenuItem mnuAjout = new JMenuItem("Modifier un cours");
        mnuAjout.addActionListener(new ModifCours());
        mnuModif.add(mnuAjout);
        maBarre.add(mnuModif);
        return maBarre;
    }

    public JPanel Barre_Recherche() {

        JPanel searchBag_Panel = new JPanel();

        GridBagLayout searchBar_Bag = new GridBagLayout();
        searchBag_Panel.setLayout(searchBar_Bag);
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

        gbcSearchBag.gridx = 1;
        gbcSearchBag.gridy = 0;
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

        gbcSearchBag.gridx = 2;
        gbcSearchBag.gridy = 0;
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

        gbcSearchBag.gridx = 3;
        gbcSearchBag.gridy = 0;
        gbcSearchBag.gridheight = 1;
        gbcSearchBag.gridwidth = 1;
        searchBag_Panel.add(TF_Semaine_searchBar_Panel, gbcSearchBag);
        return searchBag_Panel;
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
