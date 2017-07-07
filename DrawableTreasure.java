/**
 * DrawableTreasure.java
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public class DrawableTreasure extends Treasure implements Drawable 
{
   public DrawableTreasure(Maze maze) {
      super(maze);
   }

   public DrawableTreasure(Maze maze, long seed) {
      super(maze, seed);
   }

   public DrawableTreasure(Maze maze, Square location) {
      super(maze, location);
   }

   public void draw(){
   }
}

