/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.doceMonedas.base;

import java.awt.event.MouseAdapter;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class TwelveCoins {
    private final Player[] players;
    private State state;
    private final Coin[] coins;
    private int playsFollowed;
    
    public TwelveCoins(Player player1, Player player2) {
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        coins = new Coin[12];
        playsFollowed = 0;
    }
    
    public boolean hasWinner(){
        final boolean hasWinner = Arrays.stream(coins).allMatch(Coin::isDeleted);
        if (hasWinner) finalize();

        return hasWinner;
    }

    public boolean isFinished(){
        final boolean isFinished = Arrays.stream(coins).allMatch(Coin::isDeleted);
        if (isFinished && state != State.FINISHED) state = State.FINISHED;
        return isFinished;
    }
    
    public void builtCoins(JButton btnSetTurn, JLabel... lbls){
        final int len = lbls.length;
        btnSetTurn.setEnabled(false);
        if(len != 12) return;
        
        for (int i = 0; i < len; i++) coins[i] = new Coin(lbls[i]);
    }
    
    public void drawAll(){
        Arrays.stream(coins).forEach(Coin::draw);
    }
    
    public void setTurn(){
        Arrays.stream(players).forEach(Player::setTurn);
        playsFollowed = 0;
    }
    
    public String getPlayerNameIsPlaying(){
        return Arrays.stream(players)
                .filter(Player::isPlaying).findFirst().orElse(null).getName();
    }
    
    public void deleteCoin(int index){
        if (playsFollowed < 2) 
            coins[index].delete();
        playsFollowed++;
    }

    public void finalize(){
        state = State.FINISHED;
    }
    
    public String getPlayerNameWinner(){
        if (!isFinished()) return null;
        return Arrays.stream(players)
                .filter(p -> !p.isPlaying()).findFirst().orElse(null).getName();
    }

    public int getPlaysFollowed() {
        return playsFollowed;
    }
    
}
