import java.awt.*;

public class DrawFaces {
   public static void main(String[] args){
      DrawingPanel panel =new DrawingPanel(520, 180);

  Graphics g = panel.getGraphics();

  g.setColor(Color.BLACK);
  g.drawOval( 10, 30, 100, 100);    //face outline
  g.drawOval( 110, 30, 100, 100);
  g.drawOval( 210, 30, 100, 100);
  g.drawOval( 310, 30, 100, 100);
  g.drawOval( 410, 30, 100, 100);
  
  
  g.setColor(Color.BLUE);
  g.fillOval(30, 60, 20, 20);   //eyes
  g.fillOval(70, 60, 20, 20);

  g.setColor(Color.RED);      //mouth
  g.drawLine(40, 100, 80,100);
   for(int i=1; i <=5; i++){
      g.drawLine(40, 100, 80, 100);
   } 

}
   }