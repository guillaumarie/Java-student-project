/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author killian
 */

public class AjoutCours {

    private JTextField TF_Ajout_Semaine = new JTextField("");
    private JTextField TF_Ajout_Date = new JTextField("");
    private JTextField TF_Ajout_HeureD = new JTextField("");
    private JTextField TF_Ajout_HeureF = new JTextField("");
    private JTextField TF_Ajout_Prof = new JTextField("");
    private JTextField TF_Ajout_TD = new JTextField("");
    private JTextField TF_Ajout_Salle = new JTextField("");
    private JTextField TF_Ajout_Cours = new JTextField("");
    private JTextField TF_Ajout_TypeCours = new JTextField("");

    private String[] Saisies_Ajout = new String[9];
    private String[] Saisies_Suppr = new String[9];

    public AjoutCours() {
        int ret = 0;
        JFrame application = new JFrame();
        application.setTitle("Ajout de cours");
        application.setSize(600, 400);
        //application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

        JPanel principal = new JPanel();

        GridBagLayout Principal_Bag = new GridBagLayout();
        principal.setLayout(Principal_Bag);
        GridBagConstraints gbcPrincipal = new GridBagConstraints();

        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        gbcPrincipal.fill = GridBagConstraints.BOTH;
        gbcPrincipal.anchor = GridBagConstraints.CENTER;

//------------------------------------------------------------------------------
//                                  Ajout
        JPanel Ajout_Panel = new JPanel();

        GridBagLayout Ajout_Bag = new GridBagLayout();
        Ajout_Panel.setLayout(Ajout_Bag);
        GridBagConstraints gbcAjout = new GridBagConstraints();

        gbcAjout.gridheight = 1;
        gbcAjout.gridwidth = 1;
        gbcAjout.fill = GridBagConstraints.BOTH;
        gbcAjout.anchor = GridBagConstraints.CENTER;

        JPanel TF_Semaine_Panel = new JPanel();
        JLabel label_Semaine = new JLabel("Semaine : ");

        Font police = new Font("Arial", Font.BOLD, 14);
        TF_Ajout_Semaine.setFont(police);
        TF_Ajout_Semaine.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_Semaine.setForeground(Color.BLACK);
        TF_Semaine_Panel.add(label_Semaine);
        TF_Semaine_Panel.add(TF_Ajout_Semaine);

        gbcAjout.gridx = 0;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_Semaine_Panel, gbcAjout);

        JPanel TF_Date_Panel = new JPanel();
        JLabel label_Date = new JLabel("Date : ");

        TF_Ajout_Date.setFont(police);
        TF_Ajout_Date.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_Date.setForeground(Color.BLACK);
        TF_Date_Panel.add(label_Date);
        TF_Date_Panel.add(TF_Ajout_Date);

        gbcAjout.gridx = 1;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_Date_Panel, gbcAjout);

        JPanel TF_HeureD_Panel = new JPanel();
        JLabel label_HeureD = new JLabel("Heure début : ");

        TF_Ajout_HeureD.setFont(police);
        TF_Ajout_HeureD.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_HeureD.setForeground(Color.BLACK);
        TF_HeureD_Panel.add(label_HeureD);
        TF_HeureD_Panel.add(TF_Ajout_HeureD);

        gbcAjout.gridx = 2;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_HeureD_Panel, gbcAjout);

        JPanel TF_HeureF_Panel = new JPanel();
        JLabel label_HeureF = new JLabel("Heure Fin : ");

        TF_Ajout_HeureF.setFont(police);
        TF_Ajout_HeureF.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_HeureF.setForeground(Color.BLACK);
        TF_HeureF_Panel.add(label_HeureF);
        TF_HeureF_Panel.add(TF_Ajout_HeureF);

        gbcAjout.gridx = 3;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_HeureF_Panel, gbcAjout);

        JPanel TF_Prof_Panel = new JPanel();
        JLabel label_Prof = new JLabel("prof : ");

        TF_Ajout_Prof.setFont(police);
        TF_Ajout_Prof.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_Prof.setForeground(Color.BLACK);
        TF_Prof_Panel.add(label_Prof);
        TF_Prof_Panel.add(TF_Ajout_Prof);

        gbcAjout.gridx = 4;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_Prof_Panel, gbcAjout);

        JPanel TF_TD_Panel = new JPanel();
        JLabel label_TD = new JLabel("TD : ");

        TF_Ajout_TD.setFont(police);
        TF_Ajout_TD.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_TD.setForeground(Color.BLACK);
        TF_TD_Panel.add(label_TD);
        TF_TD_Panel.add(TF_Ajout_TD);

        gbcAjout.gridx = 5;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_TD_Panel, gbcAjout);

        JPanel TF_Salle_Panel = new JPanel();
        JLabel label_Salle = new JLabel("Salle : ");

        TF_Ajout_Salle.setFont(police);
        TF_Ajout_Salle.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_Salle.setForeground(Color.BLACK);
        TF_Salle_Panel.add(label_Salle);
        TF_Salle_Panel.add(TF_Ajout_Salle);

        gbcAjout.gridx = 6;
        gbcAjout.gridy = 0;

        Ajout_Panel.add(TF_Salle_Panel, gbcAjout);

        JPanel TF_Cours_Panel = new JPanel();
        JLabel label_Cours = new JLabel("Cours : ");

        TF_Ajout_Cours.setFont(police);
        TF_Ajout_Cours.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_Cours.setForeground(Color.BLACK);
        TF_Cours_Panel.add(label_Cours);
        TF_Cours_Panel.add(TF_Ajout_Cours);

        gbcAjout.gridx = 0;
        gbcAjout.gridy = 1;

        Ajout_Panel.add(TF_Cours_Panel, gbcAjout);

        JPanel TF_TypeCours_Panel = new JPanel();
        JLabel label_TYpeCours = new JLabel("Type de cours : ");

        TF_Ajout_TypeCours.setFont(police);
        TF_Ajout_TypeCours.setPreferredSize(new Dimension(150, 30));
        TF_Ajout_TypeCours.setForeground(Color.BLACK);
        TF_TypeCours_Panel.add(label_TYpeCours);
        TF_TypeCours_Panel.add(TF_Ajout_TypeCours);

        gbcAjout.gridx = 1;
        gbcAjout.gridy = 1;

        Ajout_Panel.add(TF_TypeCours_Panel, gbcAjout);

        JPanel ajout_button_Panel = new JPanel();
        JButton Button_ajout = new JButton("Ajouter");
        Button_ajout.addActionListener(new BoutonListenerAjout());
        ajout_button_Panel.add(Button_ajout);

        ajout_button_Panel.add(Button_ajout);

        gbcAjout.gridx = 0;
        gbcAjout.gridy = 2;

        Ajout_Panel.add(ajout_button_Panel, gbcAjout);

        JPanel suppr_button_Panel = new JPanel();
        JButton Button_suppr = new JButton("Supprimer");
        Button_suppr.addActionListener(new BoutonListenerSuppr());
        suppr_button_Panel.add(Button_suppr);

        ajout_button_Panel.add(Button_suppr);

        gbcAjout.gridx = 1;
        gbcAjout.gridy = 2;

        Ajout_Panel.add(suppr_button_Panel, gbcAjout);

        principal.add(Ajout_Panel, gbcPrincipal);
        application.add(principal);
    }

    // recup ID et MDP from connexion
    class BoutonListenerAjout implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Saisies_Ajout[0] = TF_Ajout_Semaine.getText();
            Saisies_Ajout[1] = TF_Ajout_Date.getText();
            Saisies_Ajout[2] = TF_Ajout_HeureD.getText();
            Saisies_Ajout[3] = TF_Ajout_HeureF.getText();
            Saisies_Ajout[4] = TF_Ajout_Prof.getText();
            Saisies_Ajout[5] = TF_Ajout_TD.getText();
            Saisies_Ajout[6] = TF_Ajout_Salle.getText();
            Saisies_Ajout[7] = TF_Ajout_Cours.getText();
            Saisies_Ajout[8] = TF_Ajout_TypeCours.getText();
            for(int i=0;i<9;++i){
                System.out.println(Saisies_Ajout[i]);
            }

        }
    }

    class BoutonListenerSuppr implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            Saisies_Suppr[0] = TF_Ajout_Semaine.getText();
            Saisies_Suppr[1] = TF_Ajout_Date.getText();
            Saisies_Suppr[2] = TF_Ajout_HeureD.getText();
            Saisies_Suppr[3] = TF_Ajout_HeureF.getText();
            Saisies_Suppr[4] = TF_Ajout_Prof.getText();
            Saisies_Suppr[5] = TF_Ajout_TD.getText();
            Saisies_Suppr[6] = TF_Ajout_Salle.getText();
            Saisies_Suppr[7] = TF_Ajout_Cours.getText();
            Saisies_Suppr[8] = TF_Ajout_TypeCours.getText();
            for(int i=0;i<9;++i){
                System.out.println(Saisies_Suppr[i]);
            }

        }
    }

//    public static void main(String[] args) throws Exception {
//        AjoutCours con = new AjoutCours();
//    }
}
