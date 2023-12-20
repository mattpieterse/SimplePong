
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
    private int sizeW1 = 10;
    private int sizeH1 = 150;
    private int posX1 = 10;
    private int posY1 = (App.SIZE_H / 2) - (sizeH1 / 2);
    
    // player-2
    private int sizeW2 = 10;
    private int sizeH2 = 150;
    private int posX2 = (App.SIZE_W - (10 + sizeW2));
    private int posY2 = (App.SIZE_H / 2) - (sizeH2 / 2);
    
    // pongball
    private int sizeWB = 20;
    private int sizeHB = 20;
    private int posXB = (App.SIZE_W / 2) - (sizeWB / 2);
    private int posYB = (App.SIZE_H / 2) - (sizeHB / 2);
    private int dirXB = -1;
    private int dirYB = -2;
    
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
        g.fillRect(0, 0, App.SIZE_W, App.SIZE_H);
        
        // gui-scores
        
        // gui-players
        g.setColor(Color.WHITE);
        g.fillRect(posX1, posY1, sizeW1, sizeH1); // player-1
        g.fillRect(posX2, posY2, sizeW2, sizeH2); // player-2
        
        // gui-pong
        g.setColor(Color.WHITE);
        g.fillOval(posXB, posYB, sizeHB, sizeWB);
        
        // gui-endscreen
        if (posXB <= 0 || posXB >= (App.SIZE_W - sizeWB)) {
            // win-screen
            isAlive = false;
            dirXB = 0;
            dirYB = 0;
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
    public void actionPerformed(ActionEvent e) {
        
        timer.start();
        
        if (isAlive) {
            // update dynamic collision boxes
            Rectangle playColliderA = new Rectangle(posX1, posY1, sizeW1, sizeH1);
            Rectangle playColliderB = new Rectangle(posX2, posY2, sizeW2, sizeH2);
            Rectangle ballCollider = new Rectangle(posXB, posYB, sizeWB, sizeHB);
            
            // change ball direction upon collision with any paddle
            if (collisionExists(ballCollider, playColliderA, playColliderB)) {           
                if (collisionExists(ballCollider, playColliderA)) score1++;
                if (collisionExists(ballCollider, playColliderB)) score2++;
                dirXB = -dirXB;
            }
        }
        
        posXB += dirXB;
        posYB += dirYB;
        
        if (posYB <= 0 || posYB >= (App.SIZE_H - sizeHB)) {
            dirYB = -dirYB;
        }
        
        repaint();
    }
    
    private boolean collisionExists(Rectangle pong, Rectangle playerA, Rectangle playerB) {
        if (pong.intersects(playerA) || pong.intersects(playerB)) {
            return true;
        }
        return false;
    }
    
    private boolean collisionExists(Rectangle pong, Rectangle player) {
        if (pong.intersects(player)) {
            return true;
        }
        return false;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_Q) -> {
                // p1-up
                if (posY1 <= 0) {
                    posY1 = 0;
                    return;
                }
                isAlive = true;
                posY1 -= 20;
            }
            case (KeyEvent.VK_W) -> {
                // p1-down
                if (posY1 >= (App.SIZE_H - sizeH1)) {
                    posY1 = (App.SIZE_H - sizeH1);
                    return;
                }
                isAlive = true;
                posY1 += 20;
            }
            case (KeyEvent.VK_O) -> {
                // p2-up
                if (posY2 <= 0) {
                    posY2 = 0;
                    return;
                }
                isAlive = true;
                posY2 -= 20;
            }
            case (KeyEvent.VK_P) -> {
                // p2-down
                if (posY2 >= (App.SIZE_H - sizeH2)) {
                    posY2 = (App.SIZE_H - sizeH2);
                    return;
                }
                isAlive = true;
                posY2 += 20;
            }
            case (KeyEvent.VK_ENTER) -> {
                // restart
                if (!isAlive) {
                    
                }
            }
        }
    }
}
