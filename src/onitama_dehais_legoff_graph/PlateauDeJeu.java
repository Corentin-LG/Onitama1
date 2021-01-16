/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff_graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author cocol
 */
public class PlateauDeJeu {
    
    private static final int COTE = 5;
    private List<List<Case>> tabCase;
    private Carte carteEnAttente;
    private Carte carteCourante;
  
    private static final Random rand = new Random();
    
    private List<Joueur> listeJoueurs; //2 joueurs
    private Joueur joueurCourant; //joueur actuel

    public PlateauDeJeu(String nomJ1, String nomJ2) {
        this.tabCase = new ArrayList<>();
        for (int i = 0; i < COTE; i++) {
            List<Case> temp = new ArrayList<>();
            for (int j = 0; j < COTE; j++) {
                temp.add(new Case(i ,j));
            }
            this.tabCase.add(temp);
        }
        this.carteCourante = new Carte(null, "carteCourante");

        this.listeJoueurs = new ArrayList<>();
        this.listeJoueurs.add(new Joueur(nomJ1));
        this.listeJoueurs.add(new Joueur(nomJ2));
        this.joueurCourant = this.listeJoueurs.get(0);


        // attribution des cartes 
        List<Carte> mains = this.creerMains(); // on recupere les 5 cartes
        this.listeJoueurs.get(0).addCarte(mains.get(0)); // donne la premiere a j1
        this.listeJoueurs.get(0).addCarte(mains.get(1)); // donne la deuxieme a j1
        this.listeJoueurs.get(1).addCarte(mains.get(2)); // donne la troisiem a j2
        this.listeJoueurs.get(1).addCarte(mains.get(3)); // donne la quatrieme a j2
        this.setCarteEnAttente(mains.get(4)); // c'est la carte en attente
    }

    /**
     * *******************************
     */
    
    private List<Carte> deck(){
        /**
         *  Cette fonction crée la liste des 16 cartes jeux
         */
        List<Carte> toutesLesCartes = new ArrayList<>();

        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(0,-1), new Coordonnees(0, 2))), "Tigre"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,0), new Coordonnees(1, 0), new Coordonnees(0, 1))), "Sanglier"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,0), new Coordonnees(1, 1), new Coordonnees(1, -1))), "Cobra"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-2,0), new Coordonnees(2, 0), new Coordonnees(0, 1))), "Crabe"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(1, -1), new Coordonnees(0, 1))), "Grue"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(-2, 1), new Coordonnees(1, -1), new Coordonnees(1, 2))), "Dragon"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(-1, 1), new Coordonnees(1, 0))), "Anguille"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,0), new Coordonnees(-1, 1), new Coordonnees(1, 0), new Coordonnees(1, 1))), "Elephant"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-2,0), new Coordonnees(-1, 1), new Coordonnees(1, -1))), "Grenouille"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,0), new Coordonnees(-1, 1), new Coordonnees(1, 0), new Coordonnees(1, -1))), "Oie"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,0), new Coordonnees(0, 1), new Coordonnees(0, -1))), "Cheval"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(0,-1), new Coordonnees(-1, 1), new Coordonnees(1, 1))), "Mante"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(-1, 1), new Coordonnees(1, 1), new Coordonnees(1, -1))), "Singe"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(0,-1), new Coordonnees(0, 1), new Coordonnees(1, 0))), "Vache"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(1, 1), new Coordonnees(2, 0))), "Lapin"));
        toutesLesCartes.add(new Carte(new ArrayList<>(Arrays.asList(new Coordonnees(-1,-1), new Coordonnees(-1, 0), new Coordonnees(1, 0), new Coordonnees(1, 1))), "Coq"));

        return toutesLesCartes;
    }

    public List<Carte> creerMains(){
        /**
         * Cette fonction permet de iocher les 5 cartes 
         */
        List<Carte> res = new ArrayList<>();
        List<Carte> deck = this.deck(); // recupperation de toutes les cartes du jeu

        for (int i =0; i < Partie.NBCARTES; i++){
            int index = PlateauDeJeu.rand.nextInt(deck.size()); // on pioche 
            res.add(deck.get(index)); // on ajoute la carte dans la main 
            deck.remove(index); // on supprime la carte de la pioche
        }

        return res;
    }

    /**
     * *******************************
     */

    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }

    public Joueur getJ1(){
        return this.listeJoueurs.get(0);
    }

    public Joueur getJ2(){
        return this.listeJoueurs.get(1);
    }

    public Case getCase(int x, int y){
        return this.tabCase.get(x).get(y);
    }

    public Carte getCarteCourante(){
        return this.carteCourante;
    }

    public Carte getCarteEnAttente(){
        return this.carteEnAttente;
    }

    public void setCarteCourante(Carte carte){
        this.carteCourante = carte;
    }

    public void setCarteEnAttente(Carte carte){
        this.carteEnAttente = carte;
    }   

    public void updateJoueurCourant(){
        if (this.joueurCourant.equals(this.listeJoueurs.get(0))){ 
            this.joueurCourant = this.listeJoueurs.get(1);
        }
        else{
            this.joueurCourant = this.listeJoueurs.get(0);
        }
    }
    
    public void viderPlateauDeJeu() { //remttre les pions à leur position de départ
        //mettre les 5 pions de chaque joueur + mettre les noms des rois
        for (int i = 0; i < COTE; i++) {
            for (int j = 0; j < COTE; j++) {
                this.getCase(i, j).setPion(new Pion());//faire très attentention: si null pointeur créer une fonction remettre les pion de base
            }
        }
        for (int j = 0; j < COTE; j++) {
            //TabCase[0][j].PIONCOURANT.COULEUR = "Rouge";
            this.getCase(COTE-1, j).getPion().attribuerCouleur("Bleu");
            this.getCase(0, j).getPion().attribuerCouleur("Rouge");

        }
        this.getCase(0, 2).getPion().setRoyaute(true);
        this.getCase(COTE-1, 2).getPion().setRoyaute(true);
    }
    
    //en réponse à la méthode au dessus, rajouter une méthode "initialiser pion" pour placer les pions à leur etat initial
    
    public void placerPionsurPlateau () { //revoir avec vider plateau
        for (int i=0; i<COTE; i++) {
            this.getCase(0, i).setPion(new Pion());
        }
    }

    
    public void afficherPlateauDeJeuSurConsole() {
 
        // boucle inversée : on affiche d'abord la ligne du haut
        for (int i = COTE-1; i >= 0; i--) {
            for (int j = 0; j < COTE; j++) {
                
                if (this.getCase(i, j).getPion().lireCouleur() == null) {
                    System.out.print("\u001B[0m N ");
                }
                else {
                    System.out.print(" "+this.getCase(i, j).getPion().lireCouleur().substring(0,1)+" ");
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

    public boolean caseOccupee(int ligne, int column) {
        return this.getCase(ligne, column).getPion() != null;
    }

    public String lireCouleurDuPion(int ligne, int column) {
        return this.getCase(ligne, column).lireCouleurDuPion();
    }
    
    public boolean supprimerPion(int ligne, int colonne) {//revoir
        if (this.getCase(ligne, colonne).getPion() == null) {
            return false;
        }
        this.getCase(ligne, colonne).setPion(null);
        return true;
    }
    
    
    public boolean permuterCarte (String nomCarte) {//parametre inutile je pense
        
        Carte copie = this.carteEnAttente; //suffisant manifestement
        this.carteEnAttente = this.carteCourante;
        this.carteCourante = copie; //pivot
        
        /*COPIE.NOM = carteEnAttente.NOM; //si je met dans deck ce code, on me dit "Non static contexte"
        COPIE.DEPLACEMENT [0] = carteEnAttente.DEPLACEMENT [0];
        COPIE.DEPLACEMENT [1] = carteEnAttente.DEPLACEMENT [1];*/
        
        return false; //pour l'intant osef
    }

    public boolean renverserCarte (String nomCarte) {
        //changer les coordonnées en fonction de ta couleur
        return false; //pour l'intant osef
    }

}

