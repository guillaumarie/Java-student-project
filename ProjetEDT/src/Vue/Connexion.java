/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Controleur.GestionModele;
import Controleur.GestionVue;

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
import Vue.Vue;

/**
 *
 * @author killian
 */
public class Connexion {

    private JTextField TF_ID = new JTextField("");
    private JTextField TF_MDP = new JTextField("");
    private String ID_Saisi = "";
    public String MDP_Saisi = "";
    private boolean verif_connexion=false;
    private GestionVue gestionVue =null;
    private GestionModele gestionModele =null;
    

    public Connexion(GestionVue gestionVue_con, GestionModele gestionModele_con ) {

        gestionVue=gestionVue_con;
        gestionModele=gestionModele_con;
        JFrame application = new JFrame();
        application.setTitle("application");
        application.setSize(600, 400);
        //application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);
        application.setVisible(true);

        JPanel principal = new JPanel();

        GridBagLayout Principal_Bag = new GridBagLayout();
        principal.setLayout(Principal_Bag);
        GridBagConstraints gbcPrincipal = new GridBagConstraints();

        JPanel TF_ID_Panel = new JPanel();
        JLabel label_ID = new JLabel("Identifiant : ");

        Font police = new Font("Arial", Font.BOLD, 14);
        TF_ID.setFont(police);
        TF_ID.setPreferredSize(new Dimension(150, 30));
        TF_ID.setForeground(Color.BLACK);
        TF_ID_Panel.add(label_ID);
        TF_ID_Panel.add(TF_ID);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        gbcPrincipal.fill = GridBagConstraints.BOTH;
        gbcPrincipal.anchor = GridBagConstraints.CENTER;
        principal.add(TF_ID_Panel, gbcPrincipal);

        JPanel TF_MDP_Panel = new JPanel();
        JLabel label_MDP = new JLabel("Mot de passe : ");

        TF_MDP.setFont(police);
        TF_MDP.setPreferredSize(new Dimension(150, 30));
        TF_MDP.setForeground(Color.BLACK);
        TF_MDP_Panel.add(label_MDP);
        TF_MDP_Panel.add(TF_MDP);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 1;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        gbcPrincipal.fill = GridBagConstraints.BOTH;
        gbcPrincipal.anchor = GridBagConstraints.CENTER;
        principal.add(TF_MDP_Panel, gbcPrincipal);

        JPanel connexion_button_Panel = new JPanel();
        JButton Button_connexion = new JButton("Se connecter");
        Button_connexion.addActionListener(new BoutonListener());
        connexion_button_Panel.add(Button_connexion);

        connexion_button_Panel.add(Button_connexion);

        gbcPrincipal.gridx = 0;
        gbcPrincipal.gridy = 2;
        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridwidth = 1;
        gbcPrincipal.fill = GridBagConstraints.BOTH;
        gbcPrincipal.anchor = GridBagConstraints.CENTER;
        principal.add(connexion_button_Panel, gbcPrincipal);
        application.add(principal);
        
        
        
    }

    // recup ID et MDP from connexion
    class BoutonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
//            System.out.println("Identifiant " + TF_ID.getText());
//            System.out.println("Mot de passe " + TF_MDP.getText());
            ID_Saisi = TF_ID.getText();
            MDP_Saisi = TF_MDP.getText();
            System.out.println("Id saisi " + ID_Saisi);
            System.out.println("Mot de passe saisi " + MDP_Saisi);
            verif_connexion=gestionVue.ConnexionUtilisateur(gestionModele, ID_Saisi, MDP_Saisi);
            System.out.println(verif_connexion);
            if(verif_connexion==true){
                Vue fen = new Vue(gestionVue, gestionModele);
                // fermer la fenetre de connexion
            }
        }
    }

    public String getID() {
        String retID = this.ID_Saisi;
        return retID;
    }

    public String getMDP() {
        String retMDP = this.MDP_Saisi;
        return retMDP;
    }

    
}
