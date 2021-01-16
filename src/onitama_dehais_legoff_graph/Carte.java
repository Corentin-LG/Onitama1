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
public class Carte {

    private String nom;
    private List<Coordonnees> deplacements; //parce que c'est plus facile avec les coo, enfin je crois XD

    public Carte (List<Coordonnees> deplacements, String nom){
        this.deplacements = deplacements;
	    this.nom  = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public List<Coordonnees> getDeplacements(){
        return this.deplacements;
    }

    @Override
    public String toString(){
        String toPrint = "La carte : " + this.nom + " permet les deplacements :\n";
        for (int i = 0; i<5; i++){
            String temp = "";
            for (int j = 0; j<5; j++){
                Coordonnees co = new Coordonnees(i-2,j-2);
                if (i == 2 && j == 2){
                    temp += " D";
                }
                else {
                    boolean ok = false; 
                    for (Coordonnees dep : this.deplacements){
                        if (co.equals(dep)){
                            ok = true;
                        }
                    }
                    if (ok){
                        temp += " P";
                    }
                    else {
                        temp += " .";
                    }
                }
            }
            temp += "\n";
            toPrint += temp;
        }
        return toPrint;
    }
  
}