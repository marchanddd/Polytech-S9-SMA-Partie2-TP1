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
public class Grille {
    private int taille;
    private Agent[][] grille;
    private ArrayList<Agent> listAgents;
    
    public Grille(){
        
    }
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
            grille[a.getPosition().getX()][a.getPosition().getY()] = a;
        }
    }
}
