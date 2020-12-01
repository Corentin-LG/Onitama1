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
    int [] DEPLACEMENT = new int [2]; //parce que c'est plus facile avec les coo, enfin je crois XD
    
    public Carte (String nom, int x, int y){
        NOM = nom;
        DEPLACEMENT [0] = x;
        DEPLACEMENT [1] = y;
    }    
}
