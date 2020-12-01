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

    Joueur Listejoueurs[] = new Joueur[2];
    Joueur JOUEURCOURANT;
    Plateau_de_jeu plateau_de_jeu = new Plateau_de_jeu();

    
    
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
        //Mise en place de la grille
        plateau_de_jeu.viderPlateau_de_jeu();

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

        // On donne des jetons aux joueurs
        for (int i = 0; i < 21; i++) {

            Pion J = new Pion(Listejoueurs[0].COULEUR);

            J1.ajouterPion(J);

            J2.ajouterPion(new Pion(J2.COULEUR));
        }

        // Determine qui est le premier joueur
        Random r = new Random();
        boolean le_premier = r.nextBoolean();
        if (le_premier) {
            JOUEURCOURANT = Listejoueurs[0];
        }
        else {
            JOUEURCOURANT = Listejoueurs[1];
        }
        
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

    void jouerPion() {

    }

    boolean tour_de_jeux() {//revoir
        System.out.println("C'est a " + JOUEURCOURANT.NOM + " de jouer (" + JOUEURCOURANT.COULEUR + ")");
        if (JOUEURCOURANT.NOMBREPIONS == 1) {
        System.out.println("Attention, il vous reste " + JOUEURCOURANT.NOMBREPIONS + " seul pion");    
        }
        else {
        System.out.println("Il vous reste " + JOUEURCOURANT.NOMBREPIONS + " pions");
        }
        int choix = menu_joueur();
        switch (choix) {
            case 1:
                jouerPion();
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
        } while (plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) != true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) != true);

        if (plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[0]) == true && plateau_de_jeu.etreGagnantePourJoueur(Listejoueurs[1]) == true) {
            System.out.println("C'est " + JOUEURCOURANT.NOM + " qui a gagné !");
        } else {
            System.out.println("C'est " + ProchainJoueur(JOUEURCOURANT).NOM + " qui a gagné !");
        }

    }

}
