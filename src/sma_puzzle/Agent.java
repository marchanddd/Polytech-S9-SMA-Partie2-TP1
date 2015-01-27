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
    private Coordinate2D position; // (ligne,colonne) à partir de 0 en haut à gauche
    private Grille grille; //grille
    private Coordinate2D positionFinale;//position finale
    private ArrayList<Message> msgTraites;//liste des messages traités
    private ArrayList<Message> msgEnvoyes;//liste des messages envoyés
    private ArrayList<ArrayList<Message>> mailBox;
    private ArrayList<Agent> listAgents;
    
    public Agent(){
        
    }
    public Agent(Coordinate2D p,Grille g, Coordinate2D pf, ArrayList<ArrayList<Message>> mb){
        position = p;
        grille = g;
        positionFinale = pf;
        mailBox = mb;
        
    }
    
   
    public void Run(){
        
    }
    

    public Coordinate2D getPosition() {
        return position;
    }

    public Grille getGrille() {
        return grille;
    }

    public Coordinate2D getPositionFinale() {
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

    public ArrayList<Agent> getListAgents() {
        return listAgents;
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

    public void setListAgents(ArrayList<Agent> listAgents) {
        this.listAgents = listAgents;
    }

    
}
