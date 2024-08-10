package ponggame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball extends Rectangle 
{
    Random random;
    int xVelocity;
    int yVelocity;
    int intialSpeed = 2;
    
  Ball(int x,int y, int ball_W,int ball_H)
  {
    super(x, y, ball_W,ball_H);
    random = new Random();
    int randomX = random.nextInt(2);
    if(randomX == 0)
        randomX--;
      setXDirection(randomX*intialSpeed);
    int randomY = random.nextInt(2);
    if(randomY == 0)
        randomY--;
      setYDirection(randomY*intialSpeed);
  }
  public void setXDirection(int randomX)
  {
    xVelocity = randomX;  
  }
  public void setYDirection(int randomY)
  {
     yVelocity = randomY;
  }
  public void move()
  {
    x += xVelocity; 
    y += yVelocity;
  }
  public void draw(Graphics g)
  {
     g.setColor(Color.cyan);
     g.fillOval(x, y, width, height);
  } 
}
