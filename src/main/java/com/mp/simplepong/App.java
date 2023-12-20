
package com.mp.simplepong;

import java.awt.Dimension;
import javax.swing.JFrame;

public class App {
    
    public static final int SIZE_W = 800;
    public static final int SIZE_H = 600;

    public static void main(String[] args) {
        
        Game game = new Game();
        JFrame scene = new JFrame();
        
        scene.setTitle("SimplePong (0.0.1)");
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setResizable(false);
        game.setPreferredSize(new Dimension(SIZE_W, SIZE_H));
        scene.add(game);
        scene.pack();
        scene.setLocationRelativeTo(null);
        scene.setVisible(true);
    }
}
