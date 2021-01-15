/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onitama_dehais_legoff_graph;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author cocol
 */
public class CaseGraphique extends JButton{
    
    Case caseAssociee;
    //ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    
    public CaseGraphique (Case uneCase) {
    caseAssociee = uneCase;   
    }
    
      @Override
    public void paintComponent (Graphics G) {
        super.paintComponent(G);
        /*
        if (caseAssociee.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        }
        else if (celluleAssociee.presenceDesintegrateur() == true) {
            setIcon(img_desint);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "vide":
                    setIcon(img_vide); // on attribue l'image celluleVide.png
                    break;
                case "Rouge":
                    setIcon(img_jetonRouge);
                    break;
                case "Jaune":
                    setIcon(img_jetonJaune);
                    break;
                    
            }
        }*/
    }  
}
