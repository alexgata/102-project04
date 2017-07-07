import java.util.*;

/**
 * Square.java
 * This class represent the squares within the maze where the explorer can navigate within.
 *
 * @author Alex Gata
 * @version Project 3
 * @version CPE 102-01
 * @version October 31, 2016
 *
 **/

public class Square implements DelimitedTextIO
{
   public static final int SQUARE_SIZE = 50;
   public static final int UP = 0;
   public static final int RIGHT = 1;
   public static final int DOWN = 2;
   public static final int LEFT = 3;

   private boolean[] wall = new boolean[4];
   private boolean seen = false;
   private boolean inView = false;
   private int row, col;
   private Treasure treasure = null;

   // 5 - project 4
   
   public Square(int row, int col) {
      this.row = row;
      this.col= col;
   }

   public Square(boolean up, boolean right, boolean down, boolean left, int row, int col){
      wall[UP] = up;
      wall[DOWN] = down;
      wall[RIGHT] = right;
      wall[LEFT] = left;
      this.row = row;
      this.col = col;
   }

   public boolean wall(int direction) {
      return wall[direction];
   }

   public boolean seen(){
      return seen;
   }

   public boolean inView(){
      return inView;
   }

   public int row() {
      return row;
   }

   public int col() {
      return col;
   }

   public Treasure treasure(){
      return treasure;
   }

   public int x(){
      return this.col()*SQUARE_SIZE;
   }

   public int y(){
      return this.row()*SQUARE_SIZE;
   }

   public void setInView(boolean inView){
      this.inView = inView;
      if(inView == true) {
         seen = true;
      }
   }

   public void setTreasure(Treasure t){
      this.treasure = t;
   }

   public void enter() {
      if (treasure != null){
         treasure.setFound();
       }
   }

   // 9 - project4
   public String toText(char delimiter) {
      return this.getClass().getName() + delimiter + row() + delimiter + col() + delimiter + wall[UP] + delimiter + wall[RIGHT] + delimiter + wall[DOWN] + delimiter + wall[LEFT] + delimiter + seen() + delimiter + inView();
   }

   public void toObject(Scanner input) {
        boolean up = input.nextBoolean();
        this.wall[UP] = up;
        boolean right = input.nextBoolean();
        this.wall[RIGHT] = right;
        boolean down = input.nextBoolean();
        this.wall[DOWN] = down;
        boolean left = input.nextBoolean();
        this.wall[LEFT] = left;
        seen = input.nextBoolean();
        inView = input.nextBoolean();
   }
   
}
