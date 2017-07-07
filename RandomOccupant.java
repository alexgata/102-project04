/**
 * RandomOccupant.java
 * This is an abstract class that extends Occupant and generates random objects in the maze.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

import java.util.*;

public abstract class RandomOccupant extends Occupant
{
   private Random randObj;
   private Maze maze;

   public RandomOccupant(Maze maze) {
      this.maze = maze; 
      randObj = new Random();
      super.moveTo(maze.getSquare(randObj.nextInt(maze.rows()),randObj.nextInt(maze.cols())));
   }

   public RandomOccupant(Maze maze, long seed){
      this.maze = maze;
      randObj = new Random(seed);
      int randRow = randObj.nextInt(maze.rows());
      int randCol = randObj.nextInt(maze.cols());
      super.moveTo(maze.getSquare(randRow, randCol));
   }

   public RandomOccupant(Maze maze, Square location){
      this.maze = maze;
      randObj = new Random();
      super.moveTo(location);
   }

   public void move() {
      int newRow = location().row();
      int newCol = location().col();
      int randDir = randObj.nextInt(4);

      while (location().wall(randDir)){
         randDir = randObj.nextInt(4);
      }

      if (randDir == Square.UP) {
         newRow -= 1;
      }

      if (randDir == Square.DOWN) {
         newRow += 1;
      }

      if (randDir == Square.RIGHT) {
         newCol += 1;
      }

      if(randDir == Square.LEFT) {
         newCol -= 1;
      }

     Square newLoc = maze.getSquare(newRow, newCol);
     super.moveTo(newLoc);
   }
   
   /*public String toText(char delimiter) {
      return super.toText(delimiter);
   }*/

   public void toObject(Scanner input) {
      int row = input.nextInt();
      int col = input.nextInt();
      Square loc = maze.getSquare(row, col);
      this.moveTo(loc);
   }

}
