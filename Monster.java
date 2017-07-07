/**
 * Monster.java
 * This class represent the Monster or enemy within the maze.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public class Monster extends RandomOccupant 
{
   public Monster(Maze maze) {
      super(maze);
   }

   public Monster(Maze maze, long seed){
      super(maze, seed);
   }

   public Monster(Maze maze, Square location) {
      super(maze, location);
   }
}
