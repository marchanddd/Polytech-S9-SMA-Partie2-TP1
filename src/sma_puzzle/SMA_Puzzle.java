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
public class SMA_Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nbAgents = 4;
        ArrayList<Agent> listAgents = new ArrayList<Agent>();
        
        ArrayList<ArrayList<Message>> mailBox = new ArrayList<ArrayList<Message>>();
        for (int i=0;i<nbAgents;i++){
            mailBox.add(new ArrayList<Message>());
        }
        
        Agent agt1 = new Agent(new Coordonnees(1,3),null,new Coordonnees(2,3),mailBox,"Agent1");
        Agent agt2 = new Agent(new Coordonnees(2,3),null,new Coordonnees(1,4),mailBox,"Agent2");
        Agent agt3 = new Agent(new Coordonnees(3,3),null,new Coordonnees(0,3),mailBox,"Agent3");
        Agent agt4 = new Agent(new Coordonnees(4,3),null,new Coordonnees(3,1),mailBox,"Agent4");
        
        listAgents.add(agt1);
        listAgents.add(agt2);
        listAgents.add(agt3);
        listAgents.add(agt4);
        
        Grille grille = new Grille(5,listAgents);
        
        for(Agent a:listAgents){
            a.setGrille(grille);
            a.Run();
        }
        
        
        
    }
    
}
