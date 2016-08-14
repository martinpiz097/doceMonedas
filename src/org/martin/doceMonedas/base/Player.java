/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.doceMonedas.base;

/**
 *
 * @author martin
 */
public class Player {
    
    private final String name;
    private boolean isPlaying;
    private int quantityVictories;

    public Player(String name, boolean isPlaying) {
        this.name = name;
        this.isPlaying = isPlaying;
        this.quantityVictories = 0;
    }

    public Player(String name) {
        this.name = name;
        this.isPlaying = true;
        this.quantityVictories = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
    
    public void setTurn(){
        isPlaying = !isPlaying;
    }

    public int getQuantityVictories() {
        return quantityVictories;
    }
    
    public void addVictory(){
        quantityVictories++;
    }
}
