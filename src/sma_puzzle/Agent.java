
package sma_puzzle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    // Compteur pour éviter de rester bloqué
    private int delay;
    
    
    public Agent(Coordonnees p,Grille g, Coordonnees pf, String n){
        nom = n;
        position = p;
        grille = g;
        positionFinale = pf;
        mailBox = new ArrayList<Message>();
        msgEnvoyes = new ArrayList<Message>();
        msgTraites = new ArrayList<Message>();
        delay=0;
    }
    
   
    public void run(){
        while (! grille.isTousSatisfait()) { //tant que le puzzle n'est pas reconstitué on boucle 
            //autre solution : gain individuel failbe si on est dans la bonne position et meilleur gain si tout le monde y est.
            
            //regarder si on est en position finale
            if (! isSatisfait()) {
                Coordonnees cible = plusCourtChemin();
                Agent agentCible = grille.getCase(cible);
                if(agentCible == null) { // Case cible libre
                    grille.moveAgent(this, cible);
                    grille.print();
                    delay = 0;
                } else {
                    if(delay < 10) {
                        // AMELIORATION : ne pas renvoyer le même message
                        Message msg = new Message(this, agentCible, Message.ACTLANGAGE.REQUEST, Message.ACTION.BOUGER, cible);
                        System.out.println("Agent " + nom + "a envoyé un message à Agent " +agentCible.getNom());
                        agentCible.recevoirMessage(msg);
                        msgEnvoyes.add(msg);
                        traiterMessages();
                    } else {
                        System.out.println("Agent "+nom+" est bloqué depuis 10 itérations, mouvement aléatoire effectué");
                        bougerAleatoirement();
                        grille.print();
                    }  
                }
            } else {
                System.out.println("Agent "+nom+" statisfait");
                traiterMessages();
            }
            delay++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//run()
    
    private Coordonnees plusCourtChemin() {
        Coordonnees cible = (Coordonnees) position.clone();
        // TODO AMELIORATION choix de l'axe aléatoirement
        if (position.getX() != positionFinale.getX()) {
            cible.setX(position.getX() + 
                    (position.getX() < positionFinale.getX() ? 1 : -1));
        } else if (position.getY() != positionFinale.getY()) {
            cible.setY(position.getY() + 
                    (position.getY() < positionFinale.getY() ? 1 : -1));
        }
        return cible;
    }
    
    /**
     * Etats
     */
    
    public boolean isSatisfait() {
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
        synchronized(mailBox) {
            Iterator<Message> iMailBox = mailBox.iterator();
            while (iMailBox.hasNext()) {
                Message msg = iMailBox.next();
                // Verification que l'émetteur a toujours besoin

                // Verification que l'on est toujours sur la position 
                if (msg.getPosition().equals(position)) {
                    bougerAleatoirement();
                    grille.print();
                    msgTraites.add(msg);
                }
                iMailBox.remove();
            }
        }
    }
    
    public void recevoirMessage(Message msg) {
        synchronized(mailBox) {
            mailBox.add(msg);
        }
    }
    
    public void bougerAleatoirement(){
        Coordonnees retour = new Coordonnees(position.getX(),position.getY());
        ArrayList<Coordonnees> casesPossible = new ArrayList<Coordonnees>();
        Coordonnees haut = new Coordonnees(position.getX()-1,position.getY());//Le haut
        Coordonnees bas = new Coordonnees(position.getX()+1,position.getY());//Le bas
        Coordonnees gauche = new Coordonnees(position.getX(),position.getY()-1);//La gauche
        Coordonnees droite = new Coordonnees(position.getX(),position.getY()+1);//La droite
        //Vérifier haut
        if(position.getX() > 0){
            if(grille.isLibre(haut)){
                casesPossible.add(haut);
            }
        }
        //Vérifier bas
        if(position.getX() < grille.getTaille()-1){
            if(grille.isLibre(bas)){
                casesPossible.add(bas);
            }
        }
         //Vérifier gauche
        if(position.getY() > 0){
            if(grille.isLibre(gauche)){
                casesPossible.add(gauche);
            }
        }
        //Vérifier droite
        if(position.getY() < grille.getTaille()-1){
            if(grille.isLibre(droite)){
                casesPossible.add(droite);
            }
        }
        if(casesPossible.size() > 0){
            retour = casesPossible.get((int)(Math.random())*(casesPossible.size()));
        }


        grille.moveAgent(this, retour);


    }//bougerAleatoirement()
    
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
