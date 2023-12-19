
package com.mp.simplepong;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        
        Game game = new Game();
        JFrame scene = new JFrame();
        
        scene.setSize(800, 600);
        scene.setLocationRelativeTo(null);
        scene.setTitle("SimplePong (0.0.1)");
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setResizable(false);
        scene.add(game);
        scene.setVisible(true);
    }
}
