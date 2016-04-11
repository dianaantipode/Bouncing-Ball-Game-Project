//File: Paddle.java
//Author: Chang Gao (dichgao@bu.edu)
//Assignment: Final Project
//Description: to paint the paddle, make the paddle moveable and judge for the collision of the ball to the paddle.

import java.awt.Color;
import java.awt.Graphics;


public class Paddle {
    private int x = (BreakOut.GAME_WIDTH - PADDLE_WIDTH)/2;
    private int y = BreakOut.GAME_HEIGHT - PADDLE_HEIGHT;
    public static final int PADDLE_WIDTH = 88;  
    public static final int PADDLE_HEIGHT = 20;
    
    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillRoundRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, 10, 10);
    }
    public void move(int dx){
        x += dx;
    }
    public boolean collide(int px, int py, int radius) {
        if (px >= x - radius && px <= x + PADDLE_WIDTH + radius && py >= y - radius && py <= y + PADDLE_HEIGHT + radius) {
            if (px < x) {
                if (py < y) {
                    if ((px - x) * (px - x) + (py - y) * (py - y) > radius * radius) {
                        return false;
                    }
                }
                if (py > y + PADDLE_HEIGHT) {
                    if ((px - x) * (px - x) + (py - y - PADDLE_HEIGHT) * (py - y - PADDLE_HEIGHT) > radius * radius) {
                        return false;
                    }
                }
            }
            if (px > x + PADDLE_WIDTH) {
                if (py < y) {
                    if ((px - x - PADDLE_WIDTH) * (px - x - PADDLE_WIDTH) + (py - y) * (py - y) > radius * radius) {
                        return false;
                    }
                }
                if (py > y + PADDLE_HEIGHT) {
                    if ((px - x - PADDLE_WIDTH) * (px - x - PADDLE_WIDTH) + (py - y - PADDLE_HEIGHT) * (py - y - PADDLE_HEIGHT) > radius * radius) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
