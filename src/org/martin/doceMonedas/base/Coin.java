/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.doceMonedas.base;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class Coin {
    private State state;
    private final ImageIcon image;
    private final JLabel lblCoin;
    
    public Coin(JLabel lbl) {
        state = State.IN_GAME;
        image = new ImageIcon(getClass()
                .getResource("/org/martin/doceMonedas/resources/coin 128-128.png"));
        this.lblCoin = lbl;
    }
    
    public boolean isDeleted(){
        return state == State.DELETED;
    }
    
    public void delete(){
        state = State.DELETED;
        lblCoin.hide();
    }

    public ImageIcon getImage() {
        return image;
    }
    
    public void draw(){
        lblCoin.setIcon(image);
        lblCoin.updateUI();
    }
}
