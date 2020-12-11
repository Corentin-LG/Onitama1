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
public class Carte {
    String NOM;
    int [][] DEPLACEMENT; //parce que c'est plus facile avec les coo, enfin je crois XD

    public Carte (int [][] deplacement, String nom){
        this.DEPLACEMENT = deplacement;
	this.NOM  = nom;
    }
  
}