/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff_graph;

/**
 *
 * @author cocol
 */
public class Pion {
    
    private String nom; //où mettre le nom ?
    private String couleur;
    private boolean royaute;
    private Coordonnees coordonnees;
    
    public Pion(){
        this.couleur = null;
        this.royaute = false;
    }
    
    public Pion(String couleur){
        this.couleur = couleur;
        this.royaute = false;
    }

    public Pion(String couleur, Coordonnees coordonnees){
        this(couleur);
        this.coordonnees = coordonnees;
    }

    public Pion(String couleur, int x, int y){
        this(couleur, new Coordonnees(x, y));
    }

    public boolean appartientA(Joueur joueur){
        if (joueur == null){
            return false;
        }
        return this.couleur.equals(joueur.lireCouleur());
    }

    public String lireNom(){
        return this.nom;
    }

    public String lireCouleur(){
        return this.couleur;
    }

    public boolean lireRoyaute(){
        return this.royaute;
    }

    public Coordonnees getCoordonnees(){
        return this.coordonnees;
    }

    public void setCoordonnes(Coordonnees coordonnees){
        this.coordonnees = coordonnees;
    }

    public void attribuerCouleur(String couleur){
        this.couleur = couleur;
    }

    public void setRoyaute(boolean royaute){
        this.royaute = royaute;
    }
    
    @Override
    public String toString(){
        if(this.couleur.equals("Rouge"))
            return "\u001B[31m O ";
        return "\u001B[33m O ";
    }
}
