
package com.mp.simplepong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Game extends JPanel 
  implements KeyListener, ActionListener {
    
    // -- Variables
    
    private int score = 0;
    
    // player-1
    private int posX1;
    private int posY1;
    
    // player-2
    private int posX2;
    private int posY2;
    
    // pongball
    private int posXB;
    private int posYB;
    private int dirXB;
    private int dirYB;
    
    // -- Event Listeners
    
    // <editor-fold defaultstate="collapsed" desc="Unused Overrides">
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
    // </editor-fold>
    
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }
    
}
