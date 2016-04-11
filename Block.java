//File: Block.java
//Author: Chang Gao (dichgao@bu.edu)
//Assignment: Final Project
//Description: set the color and shape of the blocks, determine the if the block should "disappear", determine the collision.

import java.awt.Color;
import java.awt.Graphics;

public class Block {

    public static Color[] colors = {Color.PINK, Color.BLUE, Color.ORANGE, Color.GREEN, Color.YELLOW};
    private int x;
    private int y;
    private Color color;
    private boolean visible;
    public static final int BLOCK_WIDTH = 88;
    public static final int BLOCK_HEIGHT = 20;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        int i = (int) (Math.random() * colors.length);
        this.color = colors[i];
        this.visible = true;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(x, y, 88, 20, 10, 10);
    }

    public boolean collide(int px, int py, int radius) {
        if (px >= x - radius && px <= x + BLOCK_WIDTH + radius && py >= y - radius && py <= y + BLOCK_HEIGHT + radius) {
            if (px < x) {
                if (py < y) {
                    if ((px - x) * (px - x) + (py - y) * (py - y) > radius * radius) {
                        return false;
                    }
                }
                if (py > y + BLOCK_HEIGHT) {
                    if ((px - x) * (px - x) + (py - y - BLOCK_HEIGHT) * (py - y - BLOCK_HEIGHT) > radius * radius) {
                        return false;
                    }
                }
            }
            if (px > x + BLOCK_WIDTH) {
                if (py < y) {
                    if ((px - x - BLOCK_WIDTH) * (px - x - BLOCK_WIDTH) + (py - y) * (py - y) > radius * radius) {
                        return false;
                    }
                }
                if (py > y + BLOCK_HEIGHT) {
                    if ((px - x - BLOCK_WIDTH) * (px - x - BLOCK_WIDTH) + (py - y - BLOCK_HEIGHT) * (py - y - BLOCK_HEIGHT) > radius * radius) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
