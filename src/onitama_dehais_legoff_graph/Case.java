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
public class Case {
    
    
    private Pion piontCourant;
    private int x;
    private int y;
    
    public Case(){
        this.piontCourant = new Pion ();
    }

    public Case(int x, int y){
        this();
        this.x = x;
        this.y = y;
    }

    public Pion getPion(){
        return this.piontCourant;
    }

    public void setPion(Pion newPion){
        this.piontCourant = newPion;
    }
    
    public boolean affecterPion(Pion unPion){
        if(this.piontCourant == null){
            this.piontCourant = unPion;
            return true;
        }
        return false;
    }
       
    
    public boolean supprimerPion(){
        if(this.piontCourant == null){
            return false;
        }
        this.piontCourant = null;
        return true;
    }

    public String lireCouleurDuPion(){
        if(this.piontCourant == null){
            return "vide";
        }
        return this.piontCourant.lireCouleur();
    }
    
    public int lireAbscisse(){
        return this.x;
    } 
    public int lireOrdonnee(){
        return this.y;
    } 
}
