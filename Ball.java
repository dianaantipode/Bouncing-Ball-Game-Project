//File: Ball.java
//Author: Chang Gao (dichgao@bu.edu)
//Assignment: Final Project
//Description: draw the ball, make the ball moveable and determine the bounce.

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    public int x = BreakOut.GAME_WIDTH/2;
    public int y = BreakOut.GAME_HEIGHT - 40;
    public int r = 10;
    private int dx = 7;    
    private int dy = -7;   
        
    
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }
    public void move(){
        x += dx;
        y += dy;
    }
    public void bounce(int x,int y){
        dx *= x;
        dy *= y;
    }
}
