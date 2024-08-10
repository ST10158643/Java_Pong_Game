package ponggame;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
;
public class GamePanel extends JPanel implements Runnable//runnable interface to allow class to run in a thread
{
/*VARIABLES: Static,thus belongs to the class[all instantces of GamePanel Class and it's varibles are shared]
             Final,thus cannot modifiy varibles (also make run slightly faster)*/
 static final int GAME_WIDTH = 1000;
 static final int GAME_HEIGHT = (int)(GAME_WIDTH*(0.5555));
 static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
 
 static final int BALL_DIAMETER = 20;
 static final int PADDLE_WIDTH = 25;
 static final int PADDLE_HEIGHT = 100;

 
 //Instances
 Thread gameThread;
 Image image;
 Graphics graphics;
 Random  random;
 Paddle paddle0;
 Paddle paddle1;
 Ball ball; 
 Score score; 
 //Panel is surrounded be Frame 
    GamePanel()
    {  
       newPaddles();
       newBall();
       score = new Score(GAME_WIDTH, GAME_HEIGHT);
          
          this.setFocusable(true);
          this.setVisible(true);
          this.addKeyListener(new AL());//adding inner class to the GamePanel with instnace on class
          this.setPreferredSize(SCREEN_SIZE);
          
          gameThread = new Thread(this);
          gameThread.start();
          
    }
    public void newBall()
    {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
        
        
    }
    public void newPaddles()
    {
        paddle0 = new Paddle(0,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle1 = new Paddle((GAME_WIDTH-PADDLE_WIDTH),((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void paint(Graphics g)//to paint on screen 
    {
        image = createImage(getWidth(),getHeight());//passing Image methods to retrieve Panel
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g)//To call draw methods of Classes||to draw in Panel 
    { 
      paddle0.draw(g);  
      paddle1.draw(g);
      ball.draw(g);
      score.draw(g);
    }
    public void move()//To call move methods of Classes||to move smoother in Panel 
    { //after each iteration of game loop 
      paddle0.move();
      paddle1.move(); 
      ball.move();
        
    }
    public void checkCollision()
    {
   //Paddle 0 + Ball
    if(ball.intersects(paddle0))/*(ball.x == (paddle0.x+(PADDLE_WIDTH-3)))*/
    {
            ball.setYDirection(-ball.yVelocity);
            ball.setXDirection(-ball.xVelocity);
            ball.xVelocity--; 
            score.player1++;
            System.out.println("hello 1");
    
     }
           //score()
  //Paddle 1 + Ball 
    if(ball.intersects(paddle1))/*(ball.x == (paddle1.x-(PADDLE_WIDTH+2)))*/
    {
               ball.setYDirection(-ball.yVelocity);
               ball.setXDirection(-ball.xVelocity);
               ball.xVelocity++;
               score.player2++;
               System.out.println("hello 2");
        
    }
           //score()*/

    //stops ball from leaving Panel 
        if(ball.y <= 0)//top of panel 
           ball.setYDirection(-ball.yVelocity);//will change dirction 
        if(ball.y >= GAME_HEIGHT - BALL_DIAMETER)//bottom of panel 
           ball.setYDirection(-ball.yVelocity);//will change dirction 
        if(ball.x <= 0)//side of panel 
           ball.setXDirection(-ball.xVelocity);//will change dirction 
        if(ball.x >= GAME_WIDTH - BALL_DIAMETER)//side of panel 
           ball.setXDirection(-ball.xVelocity);//will change dirction 
       
    //stops paddle from leaving Panel 
        if(paddle0.y <= 0)//top of panel 
           paddle0.y = 0; 
        if(paddle0.y >=(GAME_HEIGHT - PADDLE_HEIGHT))//bottom of panel 
           paddle0.y = GAME_HEIGHT - PADDLE_HEIGHT;
        if(paddle1.y <= 0)//top of panel 
           paddle1.y = 0; 
        if(paddle1.y >=(GAME_HEIGHT - PADDLE_HEIGHT))//bottom of panel 
           paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
        
    }

    public void run()
    {//GAME LOOP: set game length ??
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double nanoSeconds = 1000000000 / amountOfTicks;
      double delta = 0;
      
      while(true)
              {
                  long now = System.nanoTime();
                  delta += (now - lastTime)/nanoSeconds;
                  lastTime = now;
                  if(delta >= 1)
                  {
                     
                      move();//for smoother run
                      checkCollision();
                      repaint();//Method of JPanel Class
                      delta--;
                  }
              }
        
    }
//innner class: will hold action listioners for class methods||Java Keyadapter(awt.event)Class to set keyboard funtionalitiy  
    public class AL extends KeyAdapter
    {
       public void keyPressed(KeyEvent e)
       {
        paddle0.keyPressed(e);
        paddle1.keyPressed(e);
         
       }
       public void keyReleased(KeyEvent e)
       {
        paddle0.keyReleased(e);
        paddle1.keyReleased(e);
       }
    }

}
