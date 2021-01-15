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
  
}