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
public class Plateau_de_jeu {
    
    final static int COTE = 5;
    Case TabCase[][] = new Case[COTE][COTE];
    Carte CARTEENATTENTE = new Carte ("rien", 0, 0); //voir deck
    Carte CARTECOURANTE = new Carte ("rien", 0, 0); //voir deck
       
    
    Plateau_de_jeu() {
        for (int i = 0; i < COTE; i++) {
            for (int j = 0; j < COTE; j++) {
                TabCase[i][j] = new Case();
                TabCase[i][j].X = i;
                TabCase[i][j].Y = j; //Et hop, les coo c fait
            }
        }
    } 
   
    
    void viderPlateau_de_jeu() {
        for (int i = 0; i < COTE; i++) {
            for (int j = 0; j < COTE; j++) {
                TabCase[i][j].PIONCOURANT = null;
            }
        }
    }

    
    void afficherPlateau_de_jeuSurConsole() {
 
        // boucle inversée : on affiche d'abord la ligne du haut
        for (int i = COTE; i >= 0; i--) {
            for (int j = 0; j < COTE; j++) {
                
                if (TabCase[i][j].PIONCOURANT == null) {
                    System.out.print("\u001B[0m N ");
                }
                else {
                    System.out.print(TabCase[i][j].PIONCOURANT);
                }
            }
            System.out.println(" " + (i+1));
        }
        for(int i=0; i<COTE;i++){
            System.out.print(" " + (i+1) + " ");
        }
        System.out.println();
    }

    boolean celluleOccupee(int ligne, int column) {
        if(TabCase[ligne][column].PIONCOURANT != null) {
            return true;
        }
        return false;
    }

    String lireCouleurDuPion(int ligne, int column) {
        return TabCase[ligne][column].lireCouleurDuPion();
    }

    boolean etreGagnantePourJoueur(Joueur un_joueur) {
        //soit roi mort
        //soit roi adverse sur la bonne case
        return false;
    }

    Boolean supprimerPion(int ligne, int colonne) {
        if (TabCase[ligne][colonne].PIONCOURANT == null) {
            return false;
        }
        TabCase[ligne][colonne].PIONCOURANT = null;
        return true;
    }
    
        public boolean RenverserCarte (String nom_carte) {
        Carte COPIE = new Carte ("rien du tout", 0, 0);
        
        COPIE = CARTEENATTENTE; //suffisant manifestement
        
        /*COPIE.NOM = CARTEENATTENTE.NOM; //si je met dans deck ce code, on me dit "Non static contexte"
        COPIE.DEPLACEMENT [0] = CARTEENATTENTE.DEPLACEMENT [0];
        COPIE.DEPLACEMENT [1] = CARTEENATTENTE.DEPLACEMENT [1];*/
        
        CARTEENATTENTE = CARTECOURANTE;
        CARTECOURANTE = COPIE; //pivot
        
        
        return false; //pour l'intant osef
    }
}

