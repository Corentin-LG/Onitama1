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
    
    private final static int COTE = 5;
    public Case TabCase[][] = new Case[COTE][COTE];
    public Carte CARTEENATTENTE = new Carte (new int[][]{{0, 0}, {0, 0}}, "CARTEENATTENTE");
    public Carte CARTECOURANTE = new Carte (new int[][]{{0, 0}, {0, 0}}, "CARTECOURANTE");
  
    
    Plateau_de_jeu() {
        for (int i = 0; i < COTE; i++) {
            for (int j = 0; j < COTE; j++) {
                TabCase[i][j] = new Case();
                TabCase[i][j].X = i;
                TabCase[i][j].Y = j; //Et hop, les coo c fait
            }
        }
    } 
   
    
    void viderPlateau_de_jeu() { //remttre les pions à leur position de départ
        //mettre les 5 pions de chaque joueur + mettre les noms des rois
        for (int i = 0; i < COTE; i++) {
            for (int j = 0; j < COTE; j++) {
                TabCase[i][j].PIONCOURANT = new Pion ();//faire très attentention: si null pointeur créer une fonction remettre les pion de base
            }
        }
        for (int j = 0; j < COTE; j++) {
            //TabCase[0][j].PIONCOURANT.COULEUR = "Rouge";
            TabCase[COTE-1][j].PIONCOURANT.COULEUR = "Bleu";
            TabCase[0][j].PIONCOURANT.COULEUR = "Rouge";

        }
        TabCase[0][2].PIONCOURANT.ROYAUTE = true;
        TabCase[COTE-1][2].PIONCOURANT.ROYAUTE = true;
    }
    
    //en réponse à la méthode au dessus, rajouter une méthode "initialiser pion" pour placer les pions à leur etat initial
    
    void placerPionsurPlateau () { //revoir avec vider plateau
        for (int i=0; i<COTE; i++) {
            TabCase[0][i].PIONCOURANT = new Pion ();
        }
    }

    
    void afficherPlateau_de_jeuSurConsole() {
 
        // boucle inversée : on affiche d'abord la ligne du haut
        for (int i = COTE-1; i >= 0; i--) {
            for (int j = 0; j < COTE; j++) {
                
                if (TabCase[i][j].PIONCOURANT.COULEUR == null) {
                    System.out.print("\u001B[0m N ");
                }
                else {
                    System.out.print(" "+TabCase[i][j].PIONCOURANT.COULEUR.substring(0,1)+" ");
                }
                /*else {
                    System.out.print(TabCase[i][j].PIONCOURANT); //revoir ce que ça affiche réellement, si besoin créer else if
                }*/
            }
            System.out.println(" " + (i+1));
        }
        for(int i=0; i<COTE;i++){
            System.out.print(" " + (i+1) + " "); //a revoir
        }
        System.out.println();
    }

    boolean caseOccupee(int ligne, int column) {
        if(TabCase[ligne][column].PIONCOURANT != null) {
            return true;
        }
        return false;
    }

    String lireCouleurDuPion(int ligne, int column) {
        return TabCase[ligne][column].lireCouleurDuPion();
    }
    
    Boolean supprimerPion(int ligne, int colonne) {//revoir
        if (TabCase[ligne][colonne].PIONCOURANT == null) {
            return false;
        }
        TabCase[ligne][colonne].PIONCOURANT = null;
        return true;
    }
    
    
        public boolean PermuterCarte (String nom_carte) {
        Carte COPIE = new Carte (new int[][]{{0, 0}, {0, 0}}, "COPIE");
        
        COPIE = CARTEENATTENTE; //suffisant manifestement
        CARTEENATTENTE = CARTECOURANTE;
        CARTECOURANTE = COPIE; //pivot
        
        /*COPIE.NOM = CARTEENATTENTE.NOM; //si je met dans deck ce code, on me dit "Non static contexte"
        COPIE.DEPLACEMENT [0] = CARTEENATTENTE.DEPLACEMENT [0];
        COPIE.DEPLACEMENT [1] = CARTEENATTENTE.DEPLACEMENT [1];*/
        
        return false; //pour l'intant osef
    }
        public boolean RenverserCarte (String nom_carte) {
        //changer les coordonnées en fonction de ta couleur
        return false; //pour l'intant osef
    }
        
}

