/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sma_puzzle;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Agent extends Thread {
    private int[][] position; // (ligne,colonne) à partir de 0 en haut à gauche
    private Grille grille; //grille
    private int[][] positionFinale;//position finale
    private ArrayList<Message> msgTraites;//liste des messages traités
    private ArrayList<Message> msgEnvoyes;//liste des messages envoyés
    private ArrayList<ArrayList<Message>> mailBox;
    
    public Agent(){
        
    }
    public Agent(int[][] p,Grille g, int[][] pf, ArrayList<ArrayList<Message>> mb){
        position = p;
        grille = g;
        positionFinale = pf;
        mailBox = mb;
        
    }
    

    public int[][] getPosition() {
        return position;
    }

    public Grille getGrille() {
        return grille;
    }

    public int[][] getPositionFinale() {
        return positionFinale;
    }

    public ArrayList<Message> getMsgTraites() {
        return msgTraites;
    }

    public ArrayList<Message> getMsgEnvoyes() {
        return msgEnvoyes;
    }

    public ArrayList<ArrayList<Message>> getMailBox() {
        return mailBox;
    }
    
    public void setPosition(int[][] position) {
        this.position = position;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setPositionFinale(int[][] positionFinale) {
        this.positionFinale = positionFinale;
    }

    public void setMsgTraites(ArrayList<Message> msgTraites) {
        this.msgTraites = msgTraites;
    }

    public void setMsgEnvoyes(ArrayList<Message> msgEnvoyes) {
        this.msgEnvoyes = msgEnvoyes;
    }

    public void setMailBox(ArrayList<ArrayList<Message>> mailBox) {
        this.mailBox = mailBox;
    }
    
    
    
    //tant que le puzzle n'est pas reconstitué on boucle 
    //autre solution : gain individuel failbe si on est dans la bonne position et meilleur gain si tout le monde y est.
    
        //regarder si on est en position finale
        //consulter ses messages et les traiter

    
}
