/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff_graph;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author cocol
 */
public class Joueur {
    
    private String nom;
    private String couleur;
    private boolean roiVivant; //à remplir
    private List<Carte> cartes;//à remplir
    
    public Joueur(String nom){
        this.nom = nom;
        this.couleur = null ; //créer une méthode pour donner la couleur
        this.roiVivant = true;
        this.cartes = new ArrayList<>();
    }

    public List<Carte> getCartes(){
        return this.cartes;
    }

    public void addCarte(Carte carte){
        this.cartes.add(carte);
    }

    public void supprCarte(Carte carte){
        this.cartes.remove(carte);
    }

    public String lireNom(){
        return this.nom;
    }

    public String lireCouleur(){
        return this.couleur;
    }

    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    public boolean lireRoyVivant(){
        return roiVivant;
    } 

    public void affecterCouleur(String coul){
        couleur = coul;
    }  
    
}
