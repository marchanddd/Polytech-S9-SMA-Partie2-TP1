/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sma_puzzle;

/**
 *
 * @author Epulapp
 */
public class Coordonnees {
    
    private int x;
    private int y;
    

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    public boolean equals(Coordonnees c) {
        if (c.getX() == x && c.getY() == y) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public Coordonnees clone() {
        return new Coordonnees(x, y);
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
