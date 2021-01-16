/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff_graph;

import java.util.Random;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author cocol
 */
public class Partie {

    public static final int COTE = 5;
    public static final int NBCARTES = 5; // nomvres de cartes en jeu, 5 tirages sans remise
    
    private static final Random rand = new Random();

    public static void main(String[] args) {
        PlateauDeJeu plateau = Partie.initialiserPartie();
        boolean fini = false;
        while (!fini){
            System.out.println("C'est a " + plateau.getJoueurCourant().lireNom() + " de jouer (" + plateau.getJoueurCourant().lireCouleur() + ")");
            int choix = Partie.menuJoueur();
            switch (choix) {
                case 1:
                    // affichage des cartes
                    System.out.println("Voici les cartes que vous avez :");
                    System.out.println(plateau.getCarteJoueurCourant(0).toString());
                    System.out.println(plateau.getCarteJoueurCourant(1).toString());
                    System.out.println("La carte qui est en attente est la suivate :");
                    System.out.println(plateau.getCarteEnAttente().toString());

                    // choix de la carte a jouer
                    choix = Partie.menuCarte();
                    Carte carteAJouer = plateau.getCarteJoueurCourant(choix-1);

                    // choix du poin a jouer
                    Coordonnees coMonPion = Partie.menuCoordonnes();
                    Pion monPion = plateau.getCase(coMonPion.getX(), coMonPion.getY());
                    while (monPion == null || !(monPion.appartientA(plateau.getJoueurCourant()))){
                        System.out.println("La case sélectionnée ne correspond pas à l'un de vos pions");
                        Coordonnees coMonPion = Partie.menuCoordonnes();
                        Pion monPion = plateau.getCase(coMonPion.getX(), coMonPion.getY());
                    }

                    // choix de la destination
                    Coordonnees coDestination = Partie.menuCoordonnes();
                    Coordonnees testDeplacement = coDestination.getDeplacements(coMonPion);
                    boolean actionValide = false;
                    for (Coordonnees destPossible : carteAJouer.getDeplacements()){
                        if (testDeplacement.equals(destPossible)){
                            actionValide = true;
                        }
                    }

                    boolean continuer = true;
                    while (!actionValide){
                        System.out.println("Vous ne pouvez y aller!")
                        choix = Partie.menuChoixContinuerDepInvalide();
                        switch(choix){
                            case 1: coDestination = Partie.menuCoordonnes();
                                    testDeplacement = coDestination.getDeplacements(coMonPion);
                                    actionValide = false;
                                    for (Coordonnees destPossible : carteAJouer.getDeplacements()){
                                        if (testDeplacement.equals(destPossible)){
                                            actionValide = true;
                                        }
                                    }
                                    break;
                            case 2: continuer = false; break;
                        } 

                    }

                    if (continuer){
                        plateau.getCase(coMonPion).setPion(null);
                        Pion pionPresent = plateau.getCase(coDestination).getPion();
                        if (pionPresent != null){
                            if (pionPresent.appartientA(plateau.getJoueurCourant())){
                                System.out.println("Vous ne pouvez pas manger votre pion");
                            }
                            else {
                                if (pionPresent.lireRoyaute()){
                                    fini = true;
                                }
                                else {
                                    plateau.getCase(coDestination).setPion(monPion);
                                    plateau.setCarteCourante(carteAJouer);
                                    plateau.permuterCarte();
                                    plateau.getCarteJoueurCourant().getCartes().remove(carteAJouer);
                                    plateau.getCarteJoueurCourant().getCartes().add(plateau.getCarteCourante());
                                    plateau.updateJoueurCourant();
                                }
                            }
                        }
                        else {
                            if (monPion.lireRoyaute()){
                                if (coDestination.equals(new Coordonnees(0, 2) && plateau.getJoueurCourant().lireCouleur().equals("Bleu"))){
                                    fini = true;
                                }
                                else if (coDestination.equals(new Coordonnees(4, 2) && plateau.getJoueurCourant().lireCouleur().equals("Rouge"))) {
                                    fini = true;
                                }
                                else {
                                    plateau.getCase(coDestination).setPion(monPion);
                                    plateau.setCarteCourante(carteAJouer);
                                    plateau.permuterCarte();
                                    plateau.getCarteJoueurCourant().getCartes().remove(carteAJouer);
                                    plateau.getCarteJoueurCourant().getCartes().add(plateau.getCarteCourante());
                                    plateau.updateJoueurCourant();
                                }
                            }
                            else {
                                plateau.getCase(coDestination).setPion(monPion);
                                plateau.setCarteCourante(carteAJouer);
                                plateau.permuterCarte();
                                plateau.getCarteJoueurCourant().getCartes().remove(carteAJouer);
                                plateau.getCarteJoueurCourant().getCartes().add(plateau.getCarteCourante());
                                plateau.updateJoueurCourant();
                            }
                        }
                    }
                    break;

                case 9:
                    return;
            }
            fini = true;
        }
        System.out.println("Le joueur : " + plateau.getJoueurCourant().lireNom() + "a gagné");
    }

// *************************************************************************************************************************************

    public static PlateauDeJeu initialiserPartie() {

        //Création des joueurs
        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du J1 :");
        String nomJ1 = sc.nextLine();
        System.out.println("Choix du pseudo du J2 :");
        String nomJ2 = sc.nextLine();

        PlateauDeJeu plateauDeJeu = new PlateauDeJeu(nomJ1, nomJ2);

        System.out.println(plateauDeJeu.getJ1().lireNom() + " est de couleur " + plateauDeJeu.getJ1().lireCouleur());
        System.out.println(plateauDeJeu.getJ2().lireNom() + " est de couleur " + plateauDeJeu.getJ2().lireCouleur());

        // Les rois sont des conditions de Victoire perte du roi = perdu

        //Mise en place du plateau
        plateauDeJeu.viderPlateauDeJeu(); //potentiel pblm de null pointer
        plateauDeJeu.afficherPlateauDeJeuSurConsole();

        return plateauDeJeu;

    }

    public static int menuJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ?");
        System.out.println("1) Jouer un Pion");
        System.out.println("9) Quiter");
        int choix = sc.nextInt();
        while (choix != 1 && choix != 9) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    }

    public static int menuCarte() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle carte voulez prendre ?");
        System.out.println("1) Carte 1");
        System.out.println("2) Carte 2");
        int choix = sc.nextInt();
        while (choix != 1 && choix != 2) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    }

    public static int menuChoixContinuerDepInvalide() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qe voulez vous faire ?");
        System.out.println("1) Choisir une nouvelle destination");
        System.out.println("2) Choisir une nouvelle carte");
        int choix = sc.nextInt();
        while (choix != 1 && choix != 2) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        return choix;
    }

    public static Coordonnees menuCoordonnes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sur quelle ligne est le pion que vous voulez déplacer ?");
        int choix = sc.nextInt();
        while (choix <= 0 || choix >= 6) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        int x  = choix;
        System.out.println("Sur quelle colonne est le pion que vous voulez déplacer ?");
        int choix = sc.nextInt();
        while (choix <= 0 || choix >= 6) {
            System.out.println("Erreur : Entrer un choix qui existe :");
            choix = sc.nextInt();
        }
        int y  = choix;
        return new Coordonnees(x, y);
    }

    // void afficherdeplacementspossibles(int i, int j) {
    //     //permet d'afficher les déplacements possibles du pion sélectionné
    //     if (joueurCourant == Listejoueurs[0]) {
    //         for (int k = 0; k < CARTECOURANTE.DEPLACEMENT.length; k++) {
    //             System.out.println("en X : " + CARTECOURANTE.DEPLACEMENT[k][0] + "en Y : " + CARTECOURANTE.DEPLACEMENT[k][1]);
    //         }
    //     } else {
    //         for (int k = 0; k < CARTECOURANTE.DEPLACEMENT.length; k++) {
    //             int x = CARTECOURANTE.DEPLACEMENT[k][0];
    //             int x1 = -x; //renversement pour joueur du haut
    //             int y = CARTECOURANTE.DEPLACEMENT[k][1];
    //             int y1 = -y;
    //             System.out.println("en X : " + x1 + "en Y : " + y1);
    //         }
    //     }
    // }

    // void afficherdeplacementspossibles(int x, int y, int lignededeplacmeent) {
    //     if (joueurCourant == Listejoueurs[0]) {
    //         int deplacementenX = x + CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][0];
    //         int deplacementenY = y + CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][1];
    //     } else {
    //         int deplacementenX = x - CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][0];
    //         int deplacementenY = y - CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][1];
    //     }
 
    //             FenetreDeJeu.btn[deplacementenX][deplacementenY].setEnabled(true);
                
                
    //                     }

    // void possibilitededeplacement(Carte nom, int x, int y) {
    //     for (int i = 0; i < nom.DEPLACEMENT.length; i++) { //i est lignededeplacmeent
    //         if (testaffectation(x, y, i)) {
    //             afficherdeplacementspossibles(x, y, i);

    //         }
    //     }
    // }

    // boolean testaffectation(int i, int j, int lignededeplacmeent) {
    //     if (joueurCourant == Listejoueurs[0]) {
    //         int deplacementenX = i + CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][0];
    //         int deplacementenY = j + CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][1];
    //         if (deplacementenX < 0 || deplacementenX > (COTE - 1) || deplacementenY < 0 || deplacementenY > (COTE - 1) || joueurCourant.COULEUR.equals(plateau_de_jeu.TabCase[deplacementenX][deplacementenY].PIONCOURANT.COULEUR)) {
    //             return false; //attention la dernière condition peut être erronée
    //         } else {
    //             return true;
    //         }
    //     } else {
    //         int deplacementenX = i - CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][0];
    //         int deplacementenY = j - CARTECOURANTE.DEPLACEMENT[lignededeplacmeent][1];
    //         if (deplacementenX < 0 || deplacementenX > (COTE - 1) || deplacementenY < 0 || deplacementenY > (COTE - 1)|| joueurCourant.COULEUR.equals(plateau_de_jeu.TabCase[deplacementenX][deplacementenY].PIONCOURANT.COULEUR)) {
    //             return false;
    //         } else {
    //             return true;
    //         }
    //     }
    // }

    // /* void jouerPion(int i, int j, int lignededéplacmeent) {
    //     if ()
    // }*/

    // void debuterPartie() {
    //     initialiserPartie();
    //     Scanner sc = new Scanner(System.in);

    //     do {
    //         while (!tour_de_jeux()) {
    //             System.out.println("Recommencez votre tour");
    //         }
    //         plateau_de_jeu.afficherPlateau_de_jeuSurConsole();

    //         joueurCourant = ProchainJoueur(joueurCourant);
    //         //revoir les conditions de victoire
    //     } while (/*plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) != true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) != true*/0 < 1);
    //     /*
    //     if (plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) == true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) == true) {
    //         System.out.println("C'est " + joueurCourant.NOM + " qui a gagné !");
    //     } else {
    //         System.out.println("C'est " + ProchainJoueur(joueurCourant).NOM + " qui a gagné !");
    //     }*/

    // }

    // public static Joueur getJoueurcourant(Joueur j) {
    //     return j;
    // }

    // /*
    //     void jouerPion() {
    //     Scanner sc = new Scanner(System.in);
    //     boolean resultatAction;
    //     System.out.println("Pour délpver votre pion, veuillez saisir une colonne :");
    //     int colonne = sc.nextInt() - 1;
    //     while (colonne > COTE || colonne < 0) {
    //         System.out.println("Erreur : veuillez saisir une colonne :");
    //         colonne = sc.nextInt() - 1;
    //     }
    //     System.out.println("Pour délpver votre pion, veuillez saisir une ligne :");
    //     int ligne = sc.nextInt() - 1;
    //     while (ligne > COTE || ligne < 0) {
    //         System.out.println("Erreur : veuillez saisir une ligne :");
    //         ligne = sc.nextInt() - 1;
    //     }

    //     resultatAction = plateau_de_jeu.ajouterJetonDansColonne(JoueurCourant, colonne);
    //     while (!resultatAction) {
    //         System.out.println("La collone est pleine veuillez saisir une autre colonne :");
    //         colonne = sc.nextInt() - 1;
    //         resultatAction = plateau_de_jeu.ajouterJetonDansColonne(JoueurCourant, colonne);
    //     }

    // }
    //  */
    // boolean etreGagnantePourJoueur(Joueur j) {// revoir le fonctionnement
    //     //metre dans plateau avec qu'un paramètre joueur pour chaque cas
    //     //ça passera creme je crois

    //     //soit roi mort
    //     //soit roi adverse sur la bonne case
    //     Joueur j1 = new Joueur("j1");
    //     Joueur j2 = new Joueur("j2");
    //     j1 = Partie.getJoueurcourant(Listejoueurs[0]);
    //     j2 = Partie.getJoueurcourant(Listejoueurs[1]);
    //     if (plateau_de_jeu.TabCase[0][2].PIONCOURANT.ROYAUTE == true && plateau_de_jeu.TabCase[0][2].PIONCOURANT.COULEUR == "bleu") {
    //         if (j1.COULEUR == "bleu") {
    //             System.out.println("C'est " + j1.NOM + " qui remporte la victoire !");
    //         } else {
    //             System.out.println("C'est " + j2.NOM + " qui remporte la victoire !");
    //         }
    //     }
    //     if (plateau_de_jeu.TabCase[COTE - 1][2].PIONCOURANT.ROYAUTE == true && plateau_de_jeu.TabCase[COTE - 1][2].PIONCOURANT.COULEUR == "rouge") {
    //         if (j1.COULEUR == "rouge") {
    //             System.out.println("C'est " + j1.NOM + " qui remporte la victoire !");
    //         } else {
    //             System.out.println("C'est " + j2.NOM + " qui remporte la victoire !");
    //         }
    //     }
    //     if (j1.ROIVIVANT == false) {
    //         System.out.println("C'est " + j2.NOM + " qui remporte la victoire !");
    //     }
    //     if (j2.ROIVIVANT == false) {
    //         System.out.println("C'est " + j1.NOM + " qui remporte la victoire !");
    //     }
    //     return false;
    // }

}
