
package com.mp.simplepong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel 
  implements KeyListener, ActionListener {
    
    // -- Variables
    
    private Timer timer;
    
    private boolean isAlive = false;
    
    private int score1 = 0;
    private int score2 = 0;
    
    private int delay = 8;
    
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
    
    // -- Class Methods
    
    public Game() {
        
        addKeyListener(this);
        setFocusTraversalKeysEnabled(true);
        setFocusable(true);
        
        timer = new Timer(delay, this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
        
        // gui-bg
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 600);
        
        // gui-scores
        
        // gui-players
        
        // gui-pong
        
        // gui-endscreen
        if (true) {
            // win-screen
        }
        
        g.dispose();
    }
    
    // -- Event Listeners
    
    // <editor-fold defaultstate="collapsed" desc="Unused Listeners">
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
        
        timer.start();
        
        if (isAlive) {
            
            // update dynamic collision boxes
            Rectangle ballCollider = new Rectangle(/* TODO */);
            Rectangle playColliderA = new Rectangle(/* TODO */);
            Rectangle playColliderB = new Rectangle(/* TODO */);
            
            // change ball direction upon collision with any paddle
            if (collisionExists(ballCollider, playColliderA, playColliderB)) {
                dirXB = -dirXB;
            }
        }
        
        repaint();
    }
    
    private boolean collisionExists(Rectangle pong, Rectangle playerA, Rectangle playerB) {
        if (pong.intersects(playerA) || pong.intersects(playerB)) {
            return true;
        }
        return false;
    }
    
}
