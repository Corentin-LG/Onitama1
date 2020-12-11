/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cocol
 */

public class Partie {

    public final static int COTE = 5;

    public Joueur Listejoueurs[] = new Joueur[2]; //2 joueurs
    public Joueur JOUEURCOURANT; //joueur actuel
    Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu(); //init plateau
    
    int[] idCartes = new int[5]; //5 tirages sans remise
    public Carte[] Cartesenjeu = new Carte[5]; //5 cartes courantes
    
    public Pion PIONDEBASE = new Pion();
    
    /**********************************/
    public Carte[] deck = new Carte[]{TIGRE, DRAGON, CRAPAUD, LAPIN, CRABE, ELEPHANT, OIE, COQ, SINGE, MANTE, CHEVAL, VACHE, GRUE, SANGLIER, ANGUILLE, COBRA};
    //deck construit
    public static Carte TIGRE;
    public static Carte DRAGON;
    public static Carte CRAPAUD;
    public static Carte LAPIN;
    public static Carte CRABE;
    public static Carte ELEPHANT;
    public static Carte OIE;
    public static Carte COQ;
    public static Carte SINGE;
    public static Carte MANTE;
    public static Carte CHEVAL;
    public static Carte VACHE;
    public static Carte GRUE;
    public static Carte SANGLIER;
    public static Carte ANGUILLE;
    public static Carte COBRA;
    /**********************************/
    

    void attribuercoeff() {
        Random r = new Random();
        int coeff;
        coeff = r.nextInt(16);//16 nombres ENTIERS ENTRE 0 ET 15
        idCartes[0] = coeff;
        for (int i = 1; i < idCartes.length; i++) {
            coeff = r.nextInt(16);
            for (int j = i; j > 0; j--) {
                if (idCartes[j - 1] == coeff) {
                    coeff = r.nextInt(16);
                    j = i;
                }
            }
            idCartes[i] = coeff;
        }

    }
    
    void attribuercarte () {
        for (int i = 0; i > idCartes.length; i++) {
            Cartesenjeu [i] = deck[idCartes[i]];
        }
    }

    void attribuerCouleursAuxJoueurs() {
        Random r = new Random();
        boolean couleur;
        couleur = r.nextBoolean();
        if (couleur) {
            Listejoueurs[0].COULEUR = "Rouge";
            Listejoueurs[1].COULEUR = "Bleu";
        } else {
            Listejoueurs[0].COULEUR = "Bleu";
            Listejoueurs[1].COULEUR = "Rouge";
        }
    }

    Joueur ProchainJoueur(Joueur un_joueur) {
        if (Listejoueurs[0] == JOUEURCOURANT) {
            return Listejoueurs[1];
        }
        return Listejoueurs[0];
    }

    void initialiserPartie() {
        

        //Création des joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du J1 :");
        Joueur J1 = new Joueur(sc.nextLine());
        System.out.println("Choix du pseudo du J2 :");
        Joueur J2 = new Joueur(sc.nextLine());
        Listejoueurs[0] = J1;
        Listejoueurs[1] = J2;

        attribuerCouleursAuxJoueurs();

        System.out.println(J1.NOM + " est de couleur " + J1.COULEUR);
        System.out.println(J2.NOM + " est de couleur " + J2.COULEUR);

        // Les rois sont des conditions de Victoire perte du roi = perdu
        
        J1.ROIVIVANT = true;
        J2.ROIVIVANT = true;
        
        // Determine qui est le premier joueur
        Random r = new Random();
        boolean le_premier = r.nextBoolean();
        if (le_premier) {
            JOUEURCOURANT = Listejoueurs[0];
        } else {
            JOUEURCOURANT = Listejoueurs[1];
        }
        
        //Mise en place du plateau
        plateau_de_jeu.viderPlateau_de_jeu(); //potentiel pblm de null pointer
        plateau_de_jeu.afficherPlateau_de_jeuSurConsole();

    }

    int menu_joueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Jouer un Pion");
        System.out.println("9) Quiter");
        int choix = sc.nextInt();
        while (choix != 1 || choix != 9) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    }
/*
    void jouerPion(int i, int j) { //bordel a idées
        carte.deplacement
                //permet d'afficher les déplacements possibles du pion sélectionné
              if (JOUEURCOURANT == ListeJoueurs [0]) {
              for (int i=0; i<carte.deplacement.length, i++){
                  System.out.println("en X : " + carte.deplacement[i][0] + "en Y : " + carte.deplacement[i][1]);
              }  
              else {
                 for (int i=0; i<carte.deplacement.length, i++){
                      int x = carte.deplacement[i][0];
                      int x1 = -x; //renversement pour joueur du haut
                      int y = carte.deplacement[i][1];
                      int y1 = -y;
                  System.out.println("en X : " + x1 + "en Y : " + y1);
              }       
                      }
              }
              
        plateau_de_jeu.TabCase[i][j];
    }*/

    boolean tour_de_jeux() {//revoir
        System.out.println("C'est a " + JOUEURCOURANT.NOM + " de jouer (" + JOUEURCOURANT.COULEUR + ")");
        int choix = menu_joueur();
        switch (choix) {
            case 1:
                //jouerPion();
                return true;

            case 9:
                //quitter la partie
                break;
        }
        return true;
    }

    void debuterPartie() {
        initialiserPartie();
        Scanner sc = new Scanner(System.in);

        do {
            while (!tour_de_jeux()) {
                System.out.println("Recommencez votre tour");
            }
            plateau_de_jeu.afficherPlateau_de_jeuSurConsole();

            JOUEURCOURANT = ProchainJoueur(JOUEURCOURANT);
        //revoir les conditions de victoire
        } while (/*plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) != true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) != true*/ 0<1);
/*
        if (plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) == true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) == true) {
            System.out.println("C'est " + JOUEURCOURANT.NOM + " qui a gagné !");
        } else {
            System.out.println("C'est " + ProchainJoueur(JOUEURCOURANT).NOM + " qui a gagné !");
        }*/

    }

    public static void creationCartes() {
        TIGRE = new Carte(new int[][]{{0, 2}, {0, -1}}, "TIGRE");
        DRAGON = new Carte(new int[][]{{-2, 1}, {-1, -1}, {1, -1}, {2, 1}}, "DRAGON");
        CRAPAUD = new Carte(new int[][]{{-2, 0}, {-1, 1}, {1, -1}}, "CRAPAUD");
        LAPIN = new Carte(new int[][]{{1, 1}, {-1, -1}, {2, 0}}, "LAPIN");
        CRABE = new Carte(new int[][]{{2, 0}, {-2, 0}, {0, 1}}, "CRABE");
        ELEPHANT = new Carte(new int[][]{{1, 0}, {-1, 0}, {1, 1}, {-1, 1}}, "ELEPHANT");
        OIE = new Carte(new int[][]{{-1, 1}, {1, -1}, {-1, 0}, {1, 0}}, "OIE");
        COQ = new Carte(new int[][]{{-1, -1}, {1, 1}, {-1, 0}, {1, 0}}, "COQ");
        SINGE = new Carte(new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}}, "SINGE");
        MANTE = new Carte(new int[][]{{0, -1}, {-1, 1}, {1, 1}}, "MANTE");
        CHEVAL = new Carte(new int[][]{{-1, 0}, {0, 1}, {0, -1}}, "CHEVAL");
        VACHE = new Carte(new int[][]{{1, 0}, {0, 1}, {0, -1}}, "VACHE");
        GRUE = new Carte(new int[][]{{-1, -1}, {1, -1}, {0, 1}}, "GRUE");
        SANGLIER = new Carte(new int[][]{{-1, 0}, {1, 0}, {0, 1}}, "SANGLIER");
        ANGUILLE = new Carte(new int[][]{{-1, 1}, {-1, -1}, {1, 0}}, "ANGUILLE");
        COBRA = new Carte(new int[][]{{1, 1}, {1, -1}, {-1, 0}}, "COBRA");
    }

    public static Joueur getJoueurcourant (Joueur j) {
        return j;
    }
    
    
    boolean etreGagnantePourJoueur(Joueur j) {// revoir le fonctionnement
        //metre dans plateau avec qu'un paramètre joueur pour chaque cas
        //ça passera creme je crois
        
        //soit roi mort
        //soit roi adverse sur la bonne case
        Joueur j1 = new Joueur("j1");
        Joueur j2 = new Joueur("j2");
        j1 = Partie.getJoueurcourant(Listejoueurs[0]);
        j2 = Partie.getJoueurcourant(Listejoueurs[1]);
        if (plateau_de_jeu.TabCase[0][2].PIONCOURANT.ROYAUTE == true && plateau_de_jeu.TabCase[0][2].PIONCOURANT.COULEUR == "bleu") {
            if (j1.COULEUR == "bleu"){
                System.out.println("C'est "+j1.NOM+" qui remporte la victoire !");
            }
            else {
                System.out.println("C'est "+j2.NOM+" qui remporte la victoire !"); 
            }
        }
        if (plateau_de_jeu.TabCase[COTE][2].PIONCOURANT.ROYAUTE == true && plateau_de_jeu.TabCase[COTE][2].PIONCOURANT.COULEUR == "rouge") {
            if (j1.COULEUR == "rouge"){
                System.out.println("C'est "+j1.NOM+" qui remporte la victoire !");
            }
            else {
                System.out.println("C'est "+j2.NOM+" qui remporte la victoire !"); 
            }
        }
        if (j1.ROIVIVANT == false) {
            System.out.println("C'est "+j2.NOM+" qui remporte la victoire !");
        }
        if (j2.ROIVIVANT == false) {
            System.out.println("C'est "+j1.NOM+" qui remporte la victoire !");
        }
        return false;
    }
    
    
}
