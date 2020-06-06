/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import vue.Connexion;

/**
 *
 * @author guill
 */
public class Main {

    private static final GestionModele gestionModele = new GestionModele();
    private static final GestionVue gestionVue = new GestionVue();    
    
    public static void main(String[] args) {
        
        gestionModele.ConnexionBDD();
        gestionModele.InitialiserTables();
        boolean b = gestionVue.ConnexionUtilisateur(gestionModele, "christophe.baujault@ece.fr", "admin");
        System.out.println(b);
    }
}
