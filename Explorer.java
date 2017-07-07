import java.util.*;

/**
 * Explorer.java
 * This class extends Occupant and represents the explorer within the maze.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

import java.awt.event.KeyEvent;
public class Explorer extends Occupant
{
   private String name;
   private Maze maze;

   public Explorer(Maze maze) {
      this.maze = maze;
   }

   public Explorer(Square location, Maze maze, String name) {
      super(location);
      this.maze = maze;
      this.name = name;
      maze.lookAround(location);

   }

   public String name() {
      return name;
   }

   public void move(int key){ 
     int row = super.location().row();
     int col = super.location().col();
     Square location = maze.getSquare(row,col);

      if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP) {
         if (location.wall(Square.UP) == false)
            moveTo(maze.getSquare(row -1, col));
      }

      else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN) {
         if (location.wall(Square.DOWN) == false)
            moveTo(maze.getSquare(row + 1, col));
      }

      else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_KP_RIGHT) {
         if (location.wall(Square.RIGHT) == false)
            moveTo(maze.getSquare(row, col+1));
      }

      else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_KP_LEFT) {
         if (location.wall(Square.LEFT) == false)
            moveTo(maze.getSquare(row, col-1));
      }

   }

   public void moveTo(Square s){
      maze.lookAround(s);
      super.moveTo(s);
      s.enter();
   }

   public String toText(char delimiter) {
      return super.toText(delimiter) + delimiter + name;
   }

   public void toObject(Scanner input) {
      int row = input.nextInt();
      int col = input.nextInt();
      moveTo(maze.getSquare(row, col));
      name = input.next();
      
   }

}
