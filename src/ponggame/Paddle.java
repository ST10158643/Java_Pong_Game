package ponggame;

import java.awt.event.*;
import java.awt.*;

public class Paddle extends Rectangle 
{
    int player;
    int yVelocity;//speed of paddle moving up and down 
    int speed = 10;

    public Paddle(int x, int y , int PADDLE_W, int PADDLE_H, int playerNO)
    {
        super(x,y,PADDLE_W,PADDLE_H);
        this.player = playerNO;
    }
 /*Adding GamePanel's ActionListener to Paddle Class to set fuctionality*/
    public void keyPressed(KeyEvent e)
    {
       switch(player)
       {
           case 1:
               if(e.getKeyCode()==KeyEvent.VK_W)//if W id pressed
               {
                   setYDirection(-speed);
                   move();            
               }
               if(e.getKeyCode()==KeyEvent.VK_S)//if S id pressed
               {
                   setYDirection(speed);
                   move();            
               }break;
               case 2:
               if(e.getKeyCode()==KeyEvent.VK_UP)//if UP id pressed
               {
                   setYDirection(-speed);
                   move();            
               }
               if(e.getKeyCode()==KeyEvent.VK_DOWN)//if DOWN id pressed
               {
                   setYDirection(speed);
                   move();            
               }
               break;
       }
    }
    public void keyReleased(KeyEvent e)
    {
       switch(player)
       {
           case 1:
               if(e.getKeyCode()==KeyEvent.VK_W)//if W id pressed
               {
                   setYDirection(0);
                   move();            
               }
               if(e.getKeyCode()==KeyEvent.VK_S)//if S id pressed
               {
                   setYDirection(0);
                   move();            
               }break;
               case 2:
               if(e.getKeyCode()==KeyEvent.VK_UP)//if UP id pressed
               {
                   setYDirection(0);
                   move();            
               }
               if(e.getKeyCode()==KeyEvent.VK_DOWN)//if DOWN id pressed
               {
                   setYDirection(0);
                   move();            
               }
               break;
        }
    }
    public void setYDirection(int yD)
    {
       yVelocity = yD;
    }
    public void move()
    {
       y = y + yVelocity;
    }
    public void draw(Graphics g)
    {
      if(player == 1)
       g.setColor(Color.blue);
      else
       g.setColor(Color.red);
      g.fillRect(x, y, width, height); 
       
    }
     

    
}
