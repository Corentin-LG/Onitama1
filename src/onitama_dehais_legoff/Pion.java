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
public class Pion {
    
    String NOM; //où mettre le nom ?
    String COULEUR;
    boolean ROYAUTE;
    
    Pion(String coul){
        COULEUR = coul;
        ROYAUTE = false;
    }
    String lireNom(){
        return NOM;
    }
    String lireCouleur(){
        return COULEUR;
    }
    boolean lireRoyaute(){
        return ROYAUTE;
    }
    
    @Override
    public String toString(){
        if("Rouge".equals(COULEUR))
            return "\u001B[31m O ";
        return "\u001B[33m O ";
    }
}