/**
 * DrawableMonster.java
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public class DrawableMonster extends Monster implements Drawable 
{
   public DrawableMonster(Maze maze) {
      super(maze);
   }

   public DrawableMonster(Maze maze, Square location) {
      super(maze, location);
   }

   public DrawableMonster(Maze maze, long seed) {
      super(maze, seed);
   }

   public void draw() {
   }
}
