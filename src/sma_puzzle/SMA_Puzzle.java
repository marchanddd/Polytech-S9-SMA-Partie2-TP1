
package sma_puzzle;

import java.util.ArrayList;

/**
 *
 * @author Epulapp
 */
public class SMA_Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nbAgents = 4;
        ArrayList<Agent> listAgents = new ArrayList<Agent>();
        
        Agent agt1 = new Agent(new Coordonnees(0,0),null,new Coordonnees(0,1), "1");
        Agent agt2 = new Agent(new Coordonnees(1,1),null,new Coordonnees(1,2), "2");
        Agent agt3 = new Agent(new Coordonnees(2,2),null,new Coordonnees(2,3), "3");
        Agent agt4 = new Agent(new Coordonnees(3,3),null,new Coordonnees(3,4), "4");
        
        listAgents.add(agt1);
        listAgents.add(agt2);
        listAgents.add(agt3);
        listAgents.add(agt4);
        
        Grille grille = new Grille(5,listAgents);
        
        grille.print();
        
        for(Agent a:listAgents){
            a.setGrille(grille);
            a.start();
        }
        
        
        
    }
    
}
