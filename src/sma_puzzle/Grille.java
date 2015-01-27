package sma_puzzle;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class Grille {
    
    private int taille;
    private Agent[][] grille;
    private ArrayList<Agent> listAgents;
    
    // Etat
    private boolean tousSatisait;

    public Grille(int t,ArrayList<Agent> la){
        taille = t;
        listAgents = la;
        grille = new Agent[t][t];
        for(int i=0;i<t;i++){
            for(int j=0;j<t;j++){
                grille[i][j]=null;
            }
        }
        
        for(Agent a : la){
            if (grille[a.getPosition().getX()][a.getPosition().getY()] == null) {
                grille[a.getPosition().getX()][a.getPosition().getY()] = a;
            }
        }
        tousSatisfait();
    }//Grille()
    
    
    /**
     * Fait bouger un agent sur une case adjacente
     * @param a
     * @param cible
     * @return Agent a
     */
    public synchronized Agent moveAgent(Agent a, Coordonnees cible) {
        // Verifications
            // TODO verification c'est à coté ?
        if (grille[cible.getX()][cible.getY()] != null) {
            return a;
        }
        
        // Modification de la position
        grille[a.getPosition().getX()][a.getPosition().getY()] = null;
        grille[cible.getX()][cible.getY()] = a;
        a.setPosition(cible);
        
        return a;
    }
    
    /**
     * Verifie que tous les agents soient satisfaits
     */
    public boolean tousSatisfait() {
        tousSatisait = true;
        for (Agent a : listAgents) {
            if (! a.satisfait()) {
                tousSatisait = false;
                return tousSatisait;
            }
        }
        return tousSatisait;
    }
    
    
    public void print(){
        System.out.println("_____________________________________");
        String ligne="";
        
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                if(grille[i][j] !=null){
                    ligne+="["+grille[i][j].getNom()+"]";
                }else{
                   ligne+="[ ]";
                }
            }
            System.out.println(ligne);
            ligne ="";
        }
        
        System.out.println("_____________________________________");
        
    }
    
    
}
