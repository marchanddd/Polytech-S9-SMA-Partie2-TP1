
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
        //test2();
        Grille grille = generateGrille(10,20);
        grille.print();
        
        for(Agent a : grille.getListAgents()){
            System.out.println("Agent "+a.getNom()+" position finale : ("+a.getPositionFinale().getX()+","+a.getPositionFinale().getY()+")");
            a.start();
        }
        
        grille.print();
        
        
    }//main()
    
    private static void test1() {
        ArrayList<Agent> listAgents = new ArrayList<Agent>();
        listAgents.add(new Agent(new Coordonnees(0,0),null,new Coordonnees(0,1), "1"));
        listAgents.add(new Agent(new Coordonnees(1,1),null,new Coordonnees(1,2), "2"));
        listAgents.add(new Agent(new Coordonnees(2,2),null,new Coordonnees(2,3), "3"));
        listAgents.add(new Agent(new Coordonnees(3,3),null,new Coordonnees(3,4), "4"));
        
        Grille grille = new Grille(5, listAgents);
        grille.print();
        
        for(Agent a:listAgents){
            a.setGrille(grille);
            a.start();
        }
    }//test1()
    
    private static void test2() {
        ArrayList<Agent> listAgents = new ArrayList<Agent>();
        listAgents.add(new Agent(new Coordonnees(0,0),null,new Coordonnees(0,4), "1"));
        listAgents.add(new Agent(new Coordonnees(1,0),null,new Coordonnees(0,3), "2"));
        listAgents.add(new Agent(new Coordonnees(2,0),null,new Coordonnees(0,2), "3"));
        listAgents.add(new Agent(new Coordonnees(3,0),null,new Coordonnees(0,1), "4"));
        
        Grille grille = new Grille(5, listAgents);
        grille.print();
        
        for(Agent a:listAgents){
            a.setGrille(grille);
            a.start();
        }
    }//test1()
    
    
    public static Grille generateGrille(int taille,int nbAgent){
        Grille grille = new Grille(taille,null);
        ArrayList<Coordonnees> listeDestinations = new ArrayList<Coordonnees>();
        
        for(int k=0;k<nbAgent;k++){
            
            Coordonnees cDepart;
            Coordonnees cArrivee;
            
            do{
                cDepart = new Coordonnees((int)((Math.random())*(taille)),(int)(Math.random()*(taille)));
            }while(!grille.isLibre(cDepart));
            
            
            do{
                cArrivee = new Coordonnees((int)((Math.random())*(taille)),(int)(Math.random()*(taille)));
            }while(isInTheList(listeDestinations,cArrivee));
            
            
            Agent a = new Agent(cDepart,grille,cArrivee,""+k);
            listeDestinations.add(cArrivee);
            grille.moveAgent(a, cDepart);
            grille.getListAgents().add(a);
            
        }

        return grille;
    }
    
    public static boolean isInTheList(ArrayList<Coordonnees> list,Coordonnees c){
        boolean retour = false;
        
        for(Coordonnees myCoor:list){
            if(myCoor.getY() == c.getY()){
                if(myCoor.getX() == c.getX()){
                    retour = true;
                }
            }
        }
        
        return retour;
    }
    
}
