import java.util.*;

/**
 * Occupant.java
 * This is an abstract class that includes properties common to all maze occupants that inhibit the maze.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public abstract class Occupant implements DelimitedTextIO
{
   private Square square;
 
   public Occupant() {
   }

   public Occupant(Square start) {
      square = start;
   }

   public Square location() {
      return square;
   }

   public void moveTo(Square newLoc) {
      square = newLoc;
      }
   
   public String toText(char delimiter) {
      return this.getClass().getName() + delimiter + square.row() + delimiter + square.col();    
   }

   /*public void toObject(Scanner input) {
      int row = input.nextInt();
      int col = input.nextInt();
      Square newLoc = new Square(row,col);
      moveTo(newLoc);
      }*/

}
