package ponggame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Score extends Rectangle 
{
    static int GAME_WIDTH ;
    static int GAME_HEIGHT;
    int player1; 
    int player2;
  Score(int GAME_W, int GAME_H)
  {
      Score.GAME_WIDTH = GAME_W;
      Score.GAME_HEIGHT = GAME_H;
  }
  public void draw(Graphics g)
  {
      g.setColor(Color.white);
      g.setFont(new Font("Bauhaus 93",Font.BOLD, 50));
      g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
      g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-90, 50);
      g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+25, 50);

       }
    
}
