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
public class Case {
    
    
    Pion PIONCOURANT;
    int X;
    int Y;
    
    
    // constructeur appelé a la création d'une cellule
    Case(){
        PIONCOURANT = null;
        
    }
    
    boolean affecterPion(Pion un_pion){
        if(PIONCOURANT == null){
            PIONCOURANT = un_pion;
            return true;
        }
        return false;
    }
       
    
    boolean supprimerPion(){
        if(PIONCOURANT == null){
            return false;
        }
        PIONCOURANT = null;
        return true;
    }

    String lireCouleurDuPion(){
        if(PIONCOURANT == null){
            return "vide";
        }
        return PIONCOURANT.COULEUR;
    } 
}
