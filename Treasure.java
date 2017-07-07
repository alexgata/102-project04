import java.util.*;
/**
 * Treasure.java
 * This class represent the Treasures within the maze.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/


public class Treasure extends RandomOccupant
{
   private boolean found = false;

   public Treasure(Maze maze) {
      super(maze);
      super.location().setTreasure(this);
   }

   public Treasure(Maze maze, long seed) {
      super(maze, seed);
      super.location().setTreasure(this);
   }

   public Treasure(Maze maze, Square location) {
      super(maze, location);
      super.location().setTreasure(this);
   }

   public boolean found() {
      return found;
   }

   public void setFound() {
      found = true;
   }

   public void move() {

   }

   // 6 - project 4

   @Override public void moveTo(Square newLoc) {
      if (location() != null) {
         location().setTreasure(null);
      }
      super.moveTo(newLoc);
      location().setTreasure(this);
   }

   public String toText(char delimiter) {
      return super.toText(delimiter) + delimiter + found;
   }

   public void toObject(Scanner input) {
      super.toObject(input);
      this.found = input.nextBoolean();
      

   }
}
