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
    private Coordonnees position;     private Grille grille; //grille
    private Coordonnees positionFinale;    private ArrayList<Message> msgTraites;//liste des messages traités
    private ArrayList<Message> msgEnvoyes;//liste des messages envoyés
    private ArrayList<ArrayList<Message>> mailBox;
    private ArrayList<Agent> listAgents;
    
    public Agent(){
        
    }
    public Agent(Coordonnees p,Grille g, Coordonnees pf, ArrayList<ArrayList<Message>> mb){
        position = p;
        grille = g;
        positionFinale = pf;
        mailBox = mb;
        
    }
    
   
    public void Run(){
        
    }
    

    public Coordonnees getPosition() {
        return position;
    }

    public Grille getGrille() {
        return grille;
    }

    public Coordonnees getPositionFinale() {
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
    
    
    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public void setPositionFinale(Coordonnees positionFinale) {
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
