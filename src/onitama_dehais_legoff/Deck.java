/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff;

import java.util.Random;

/**
 *
 * @author cocol
 */
public class Deck {
    
    Carte [] deck = new Carte [16];
    Carte [] Cartesenjeu = new Carte [5];
    int [] idCartes = new int [5];
    //je veux uartes = new int [5]ne méthode permettant de tirer aux hazard 5 nbr différents
    //chacuns de c'est nombres 
    
    //creer les 16 en brutal
        public Deck (){
            //pour chaque carte, une fois créé, la stocker dans une case du tableau
}
    //tirer les 5 au hazard : liste fixe mais random tirage
      
        
        public boolean creationDeck () {
            for (int i=0; i<deck.length; i++) {
                deck[i] = ;
            }
            
            
        }
        
        
        
        
        
        
        
        
        
        public boolean TirageNombres() {
            Random r = new Random(16);
            int coeff;
            coeff = r.nextInt();
            boolean b = false;
            do {
               
               for (int i = 0; i< idCartes.length; i++) {
               if (coeff.equals(idCartes[i])) {
                   b = true;
                   break;
               }
               }
            } while (b != true); //l'idée est là mais pas sûr du tout que ça marche
            
            for (int i=0; i < Plateau_de_jeu.COTE; i++) { //faire final static sur COTE
        
            
        }
        return false; // a modifier
        }
        
        public void remplireidCartes () {
            

            
        }
        
        
        
        
        
        
        
        
        //faire un tableau de 5 chiffres pour les 5 cartes d'une partie
public boolean TirageCartes () {
    for (int i=0; i < Plateau_de_jeu.COTE; i++) { //faire final static sur COTE
        if (i==2){
            //carte abandonnée
        }
        else {
            
        }
    }
    
    return false; //a modifier si besion
}
    //init carte abandonnée


}
