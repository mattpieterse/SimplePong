
package com.mp.simplepong;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        
        JFrame scene = new JFrame();
        
        scene.setSize(700, 600);
        scene.setLocationRelativeTo(null);
        scene.setTitle("SkeetPong (0.0.1)");
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setResizable(false);
        scene.setVisible(true);
    }
}
