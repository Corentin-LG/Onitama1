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
public class Carte {
    String NOM;
    int [][] DEPLACEMENT; //parce que c'est plus facile avec les coo, enfin je crois XD
    int COMTEURCARTE;
    
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
    
    public Carte (int [][] deplacement, String nom, int compteurcartee){
        this.DEPLACEMENT = deplacement;
	this.NOM  = nom;
        this.COMTEURCARTE = compteurcartee;
    }
    
    public static void creationCartes() {
		TIGRE    = new Carte(new int[][] {{0,2},  {0,-1}},"TIGRE",0);
		DRAGON   = new Carte(new int[][] {{-2,1}, {-1,-1}, {1,-1}, {2,1}} ,"DRAGON",1);
		CRAPAUD     = new Carte(new int[][] {{-2,0}, {-1,1},  {1,-1}},"CRAPAUD",2);
		LAPIN   = new Carte(new int[][] {{1,1},  {-1,-1}, {2,0}},"LAPIN",3);
		CRABE     = new Carte(new int[][] {{2,0},  {-2,0},  {0,1}},"CRABE",4);
		ELEPHANT = new Carte(new int[][] {{1,0},  {-1,0},  {1,1},  {-1,1}},"ELEPHANT",5);
		OIE    = new Carte(new int[][] {{-1,1}, {1,-1},  {-1,0}, {1,0}} ,"OIE",6);
		COQ  = new Carte(new int[][] {{-1,-1},{1,1},   {-1,0}, {1,0}} ,"COQ",7);
		SINGE   = new Carte(new int[][] {{1,1},  {-1,-1}, {1,-1}, {-1,1}},"SINGE",8);
		MANTE   = new Carte(new int[][] {{0,-1}, {-1,1},{1,1}},"MANTE",9);
		CHEVAL    = new Carte(new int[][] {{-1,0}, {0,1},{0,-1}},"CHEVAL",10);
		VACHE       = new Carte(new int[][] {{1,0},  {0,1},   {0,-1}},"VACHE",11);
		GRUE    = new Carte(new int[][] {{-1,-1},{1,-1},  {0,1}},"GRUE",12);
		SANGLIER     = new Carte(new int[][] {{-1,0}, {1,0},   {0,1}},"SANGLIER",13);
		ANGUILLE      = new Carte(new int[][] {{-1,1}, {-1,-1}, {1,0}},"ANGUILLE",14);
		COBRA    = new Carte(new int[][] {{1,1},  {1,-1},  {-1,0}},"COBRA",15);
	}
    
    
}