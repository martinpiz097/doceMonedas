/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.doceMonedas.gui.events;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class CoinEvent extends MouseAdapter{
    
    private final JLabel lbl;

    public CoinEvent(JLabel lbl) {
        this.lbl = lbl;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getClickCount() == 2)
            if (lbl.isVisible())
                lbl.hide();
        
    }
    
}
