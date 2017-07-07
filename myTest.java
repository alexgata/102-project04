import java.util.*;
import java.io.*;

public class myTest
{
   public static void main(String[] args) throws MazeReadException, IOException 
   {

      Maze maze = new Maze();
      maze.readMazeFromFile("mazeGoodOutOfOrder.txt");
      maze.writeMazeToFile("test.txt");
      /*Maze maze = new Maze();
      maze.readMazeFromFile("mazeDupSquare.txt");*/
   }
}
