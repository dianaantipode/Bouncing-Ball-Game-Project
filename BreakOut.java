//File:BreakOut.java
//Author: Chang Gao (dichgao@bu.edu)
//Assignment: Final Project
//Description: the main method; the main loop for the game; the judge of wining and losing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class BreakOut extends javax.swing.JFrame {

    // constants used to define the game field and bounds

    public static final int GAME_WINDOW_HEIGHT = 450;
    public static final int GAME_WINDOW_WIDTH = 450;
    public static final int GAME_HEIGHT = 440;
    public static final int GAME_WIDTH = 440;
    public Paddle paddle;
    public Ball ball;
    private int BLOCK_WIDTH=9,BLOCK_LENGTH=5;        //############################################
    private int blocks_num=BLOCK_WIDTH*BLOCK_LENGTH;      //############################################
    public Block[][] blocks = new Block[BLOCK_WIDTH][BLOCK_LENGTH];   //############################################
    // member variables
    private KeyHandler kh;      // handle keyboard events

    public BreakOut() {
        initComponents();

        // subscribe for events from keyboard
        kh = new KeyHandler();
        addKeyListener(kh);

    } // public BreakOut()

    public void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        setTitle("BreakOut");
        paddle = new Paddle();
        ball = new Ball();
        for(int i=0 ;i < BLOCK_WIDTH ;i++)
            for(int j=0; j<BLOCK_LENGTH;j++){
                blocks[i][j] = new Block(j*88,i*20+30);
            }
        // DO ANY ININITALIZATION WORK HERE
    } // public void initComponents()

    // The paint method handles the graphical rendering. 
    // From any other method, call repaint() to get this method to redraw the screen.
    public void paint(Graphics g) {
 // TO DO: WRITE YOUR CODE TO PAINT THE GAME HERE
        // DELEGATE WORK TO YOUR Paddle, Ball, and Block objects.
        // DO NOT CREATE ANY NEW OBJECT HERE! USE THE INSTANCE VARIABLES
        g.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        paddle.paint(g);
        ball.paint(g);
        for(int i=0 ;i < BLOCK_WIDTH ;i++)
            for(int j=0; j< BLOCK_LENGTH;j++){
                if(blocks[i][j].isVisible()) 
                    blocks[i][j].paint(g);
            }
    } // public void paint(Graphics g)

    // The play method is where the main game loop resides. 
    public void play() {
    //the jedgement of wining
     boolean win=false;     
      
        while(ball.y<450 ){
            repaint();
            
            if(this.blocks_num==0)  
            {
             win=true;
             break;
            }
            
            ball.move();
            Pause.wait(80);
            //check collision
            if(ball.x >= GAME_WIDTH - ball.r || ball.x < ball.r) ball.bounce(-1,1);
            if(paddle.collide(ball.x,ball.y, ball.r)) ball.bounce(1, -1);
            for(int i=0 ;i < BLOCK_WIDTH ;i++)
            for(int j=0; j< BLOCK_LENGTH;j++){
                if(blocks[i][j].isVisible()){
                    if(blocks[i][j].collide(ball.x, ball.y, ball.r)){
                        ball.bounce(1,-1);
                        blocks[i][j].setVisible(false);
                        blocks_num--;      
                        break;        
                    }
                }
            }
            if(ball.y <=ball.r)   ball.bounce(1, -1);  
            
            
        }
       
      if(win)
       System.out.println("You Win!");
      else
       System.out.println("Game Over!");
      
         
     
    } //  public void play()

    // This is an inner class that will help you to receive keyboard events.
    public class KeyHandler extends KeyAdapter {

        public void keyPressed(KeyEvent ke) {
            int key = ke.getKeyCode();
            System.out.println("keyPressed : " + key);
            if(key == KeyCodes.LEFT_ARROW_KEY){
                paddle.move(-5);
                repaint();
            }else if(key == KeyCodes.RIGHT_ARROW_KEY){
                paddle.move(5);
                repaint();
            }

            
        } // public void keyPressed(KeyEvent ke)
    } // public class KeyHandler extends KeyAdapter

    // The main method starts the game and delegates all work 
    //  to the play method. Do not add any code in this main method. 
    public static void main(String[] args) {

        BreakOut game = new BreakOut();
        game.setVisible(true);
        game.play();

    } // public static void main(String[] args)

} // end class BreakOut

