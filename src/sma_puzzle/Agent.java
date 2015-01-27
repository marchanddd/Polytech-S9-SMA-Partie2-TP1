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
    
    private String nom;
    
    private Coordonnees position; // X ordonnée / Y abcisse en commencant par 0 en haut à gauche
    private Coordonnees positionFinale;
    private Grille grille; //grille
    
    private ArrayList<Message> msgEnvoyes;//liste des messages envoyés
    private ArrayList<Message> mailBox;
    private ArrayList<Message> msgTraites;//liste des messages traités
    
    private ArrayList<Agent> listAgents;
    
    
    public Agent(Coordonnees p,Grille g, Coordonnees pf, String n){
        nom = n;
        position = p;
        grille = g;
        positionFinale = pf;
        mailBox = new ArrayList<Message>();
    }
    
   
    public void Run(){
        while (! grille.tousSatisfait()) {//tant que le puzzle n'est pas reconstitué on boucle 
            //autre solution : gain individuel failbe si on est dans la bonne position et meilleur gain si tout le monde y est.
            
            //regarder si on est en position finale
            if (! satisfait()) { 
                Coordonnees cible = plusCourtChemin();
                
            } else {
                traiterMessages();
            }
        }
    }
    
    private Coordonnees plusCourtChemin() {
        Coordonnees cible = (Coordonnees) position.clone();
        if (position.getX() != positionFinale.getX()) {
            cible.setX(position.getX() + 
                    (position.getX() < positionFinale.getX() ? 1 : -1));
            // TODO verification place libre et réaction
        } else if (position.getY() != positionFinale.getY()) {
            cible.setY(position.getY() + 
                    (position.getY() < positionFinale.getY() ? 1 : -1));
        }
        return cible;
    }
    
    /**
     * Etats
     */
    
    public boolean satisfait() {
        if (this.getPosition().equals(this.getPositionFinale())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Fonctions Messages
     */
    
    /**
     * consulter ses messages et les traiter
     */
    private void traiterMessages() {
        for (Message msg : mailBox) {
            // Verification que l'émetteur a toujours besoins 
            
            // Verification que l'on est toujours sur la position 
            if (msg.getPosition().equals(position)) {
                
            } else {
                mailBox.remove(msg);
            }
        }
    }
    
    public void recevoirMessage(Message msg) {
        mailBox.add(msg);
    }
    
    /**
     * Getters / Setters
     */
    
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

    public ArrayList<Message> getMailBox() {
        return mailBox;
    }

    public ArrayList<Agent> getListAgents() {
        return listAgents;
    }
    
    public String getNom(){
        return nom;
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

    public void setMailBox(ArrayList<Message> mailBox) {
        this.mailBox = mailBox;
    }
    
    public void setNom(String n){
        this.nom = n;
    }

    public void setListAgents(ArrayList<Agent> listAgents) {
        this.listAgents = listAgents;
    }

    
}
