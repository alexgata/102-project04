/**
 * DrawableSquare.java
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public class DrawableSquare extends Square implements Drawable 
{
   public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col) {
      super(up, right, down, left, row, col);
   }

   public void draw() {
   }
}
