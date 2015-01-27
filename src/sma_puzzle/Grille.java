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
    }//Grille()
    
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
