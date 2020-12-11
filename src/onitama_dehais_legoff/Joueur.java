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
    boolean ROIVIVANT; //à remplir
    Carte ListeCartes[] = new Carte [2];//à remplir
    int NOMBRECARTES;
    
    Joueur(String nom_joueur){
        NOM = nom_joueur;
        COULEUR = null ; //créer une méthode pour donner la couleur
        ROIVIVANT = false;
        NOMBRECARTES = 0;
    }
    String lireNom(){
        return NOM;
    }
    String lireCouleur(){
        return COULEUR;
    }
    boolean lireRoyVivant(){
        return ROIVIVANT;
    }
    int lireNombredecarte(){
        return NOMBRECARTES;
    }   
    void affecterCouleur(String coul){
        COULEUR = coul;
    }  
    
}
