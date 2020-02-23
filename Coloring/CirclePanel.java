/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coloring;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author User
 */
public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
private int x,y;
private Color c;
private int width, height;
JPanel buttonPanel;
JPanel buttonPanel2;
JButton choose = new JButton("Choose Color");
JButton left = new JButton("Left");
JButton right = new JButton("Right");
JButton up = new JButton("Up");
JButton down = new JButton("Down");
//---------------------------------------------------------------
// Set up circle and buttons to move it.
//---------------------------------------------------------------
public CirclePanel(int width, int height)
{
// Set coordinates so circle starts in middle
x = (width/2)-(CIRCLE_SIZE/2);
y = (height/2)-(CIRCLE_SIZE/2);
c = Color.green;
this.width=width;
this.height=height;// Need a border layout to get the buttons on the bottom
this.setLayout(new BorderLayout());
//create buttons to repaint the circle
JButton red = new JButton("red");
JButton green = new JButton("green");
JButton white = new JButton("white");
JButton yellow = new JButton("yellow");
red.setBackground(Color.RED);
green.setBackground(Color.green);
white.setBackground(Color.white);
yellow.setBackground(Color.YELLOW);
// Create buttons to move the circle

left.setMnemonic('l');
right.setMnemonic('r');
up.setMnemonic('u');
down.setMnemonic('d');
left.setToolTipText("move 20 pixel to the left");
right.setToolTipText("move 20 pixel to the right");
up.setToolTipText("move 20 pixel up");
down.setToolTipText("move 20 pixel down");
// Add listeners to the buttons

// Add listeners to coloring button
red.addActionListener(new ColorListener(Color.RED));
green.addActionListener(new ColorListener(Color.green));
white.addActionListener(new ColorListener(Color.white));
yellow.addActionListener(new ColorListener(Color.yellow));
choose.addActionListener(new ColorListener(null));
// Need a panel to put the buttons on or they'll be on
right.addActionListener(new MoveListener(20,0));
left.addActionListener(new MoveListener(-20,0));
up.addActionListener(new MoveListener(0,-20));
down.addActionListener(new MoveListener(0,20));
// top of each other.
buttonPanel = new JPanel();
buttonPanel.add(left);
buttonPanel.add(right);
buttonPanel.add(up);
buttonPanel.add(down);

buttonPanel2 = new JPanel();
buttonPanel2.add(red);
buttonPanel2.add(green);
buttonPanel2.add(choose);
buttonPanel2.add(yellow);
buttonPanel2.add(white);
// Add the button panel to the bottom of the main panel
this.add(buttonPanel, "South");
this.add(buttonPanel2, "North");
}
//---------------------------------------------------------------
// Draw circle on CirclePanel
//---------------------------------------------------------------
@Override
public void paintComponent(Graphics page)
{
    super.paintComponent(page);
    page.setColor(c);
    page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    
}
//---------------------------------------------------------------
// Class to listen for button clicks that move circle.
//---------------------------------------------------------------
private class MoveListener implements ActionListener
{
private int dx;
private int dy;
//---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------
public MoveListener(int dx, int dy)
{
this.dx = dx;
this.dy = dy;
}
//---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------
@Override
public void actionPerformed(ActionEvent e)
{
 if(dx!=0) {
     if((x+dx)<=(width-CIRCLE_SIZE)){
         if((x+dx)>0){
             x+=dx;
             left.setEnabled(true);
             right.setEnabled(true);
             
         } else {
             left.setEnabled(false);
         }
     } else {
         right.setEnabled(false);
     }
 }
 if(dy!=0){
         int pnlHeight = buttonPanel.getSize().height;
         if((y+dy)<=(height-pnlHeight-CIRCLE_SIZE)){
             if(y+dy>0){
                 y+=dy;
                 up.setEnabled(true);
                 down.setEnabled(true);
             }else{
                 up.setEnabled(false);
             }
         } else {
             down.setEnabled(false);
         }
     }
  repaint();
 }
 

}


private class ColorListener implements ActionListener
{
private Color warna;
//---------------------------------------------------------------
// Parameters tell how to move circle at click.
//---------------------------------------------------------------
public ColorListener(Color warna)
{
 this.warna = warna;
}
//---------------------------------------------------------------
// Change x and y coordinates and repaint.
//---------------------------------------------------------------
@Override
public void actionPerformed(ActionEvent e)
{
    if(this.warna != null){
        c = warna;
        
    } else {
        c = JColorChooser.showDialog(null, "Choose a Color", c);
    }
    repaint();
}
}

}
