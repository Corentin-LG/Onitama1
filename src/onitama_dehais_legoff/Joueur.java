/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff;

/**
 *
 * @author cocol
 */
public class Joueur {
    
    String NOM;
    String COULEUR;
    Pion ListeJetons[] = new Pion [5]; //à remplir
    Carte ListeCartes[] = new Carte [2];//à remplir
    int NOMBREPIONS;
    int NOMBRECARTES;
    
    Joueur(String nom_joueur){
        NOM = nom_joueur;
        COULEUR = null ; //créer une méthode pour donner la couleur
        NOMBREPIONS = 0; //faire une boucle méthode init de remplissage
        NOMBRECARTES = 0;
    }
    
    void ajouterPion(Pion un_pion){
        ListeJetons[NOMBREPIONS++] = un_pion;
    }
    
    void affecterCouleur(String coul){
        COULEUR = coul;
    }  
    
}
