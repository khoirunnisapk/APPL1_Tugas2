/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coloring;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class MoveCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame ("MoveCircle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400,400));
        frame.getContentPane().add(new CirclePanel(400,400));
        frame.pack();
        frame.setVisible(true);
    }
    
}
