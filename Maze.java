import java.util.*;
import java.io.*;

/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author (Alex Gata) 
 * @version (CPE 102 -01)
 */
public class Maze
{
   // 3 - project 3
   //private ArrayList<RandomOccupant> ro; 

   public Maze() {
      randOccupants = new ArrayList<RandomOccupant>();
   }

   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
      this.squares = squares;
      this.rows = rows;
      this.cols = cols;
      this.randOccupants = new ArrayList<RandomOccupant>();
		
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {
      return randOccupants.size();
   }
	
   // COMMANDS
   public void addRandomOccupant(RandomOccupant ro) {randOccupants.add(ro); }
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      for(RandomOccupant r : randOccupants) {
         r.move();}
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
      if (foundAllTreasures()) {
         status = EXPLORER_WIN;
      }

      else {

         for (RandomOccupant r : (randOccupants)) {
            if (r instanceof Monster) {
               if (r.location() == explorer.location())
                  status = MONSTER_WIN;
            }
         }
      }
      
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      //search through all the occupants to see if the Treasures have been found.  Return false if
      //- there is a Treasure that hasn't been found.
        
      ArrayList <Treasure> t = new ArrayList();
      int numt = 0;
      for (RandomOccupant rand : randOccupants) {
         if (rand instanceof Treasure) {
            Treasure treasR = (Treasure) rand;
            t.add(treasR);
            if (treasR.found())
                numt++;
         }
      }
      if (numt == t.size())
         return foundAll;
      else
         return false;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      // Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
      //        - Check the diagonal squares.  If there isn't a wall in the way, set their inview to true.
      
      Square sq;
      Square diag;
      
      if (!s.wall(Square.UP)) { 
         sq = getSquare(row-1, col);
         sq.setInView(true);

         if (!sq.wall(Square.RIGHT)) {
            diag =getSquare(row -1,col +1);
            diag.setInView(true);
         }
         
         if (!sq.wall(Square.LEFT)) {
            diag = getSquare(row-1, col-1);
            diag.setInView(true);
         }
      }
      
      if (!s.wall(Square.RIGHT)) { 
         sq = getSquare(row, col + 1);
         sq.setInView(true);

         if (!sq.wall(Square.UP)) {
            diag =getSquare(row -1,col -1);
            diag.setInView(true);
         }
         
         if (!sq.wall(Square.DOWN)) {
            diag = getSquare(row+1, col+1);
            diag.setInView(true);
         }
      }
        
      if (!s.wall(Square.DOWN)) { 
         sq = getSquare(row+1, col);
         sq.setInView(true);

         if (!sq.wall(Square.RIGHT)) {
            diag = getSquare(row +1,col +1);
            diag.setInView(true);
         }
         
         if (!sq.wall(Square.LEFT)) {
            diag = getSquare(row+1, col-1);
            diag.setInView(true);
         }
 
      }

      if (!s.wall(Square.LEFT)) { 
         sq = getSquare(row, col-1);
         sq.setInView(true);

         if (!sq.wall(Square.UP)) {
            diag =getSquare(row -1,col -1);
            diag.setInView(true);
         }
         
         if (!sq.wall(Square.DOWN)) {
            diag = getSquare(row+1, col-1);
            diag.setInView(true);
         }
      }

   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }

   public void writeMazeToFile(String fileName) throws IOException {
      PrintStream ps = new PrintStream(new File(fileName));
      ps.println(rows + "," +cols);
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j <cols; j++) {
             ps.println(squares[i][j].toText(','));
         }
      } 

      if (explorer != null) {
         ps.println(this.explorer.toText(','));
      }

      for (RandomOccupant r: randOccupants) {
         ps.println(r.toText(','));
      }
   }

   public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException{
      Scanner in = new Scanner(new File(fileName));
      String line = in.nextLine();
      Scanner in2 = new Scanner(line);
      in2.useDelimiter(",");
      int lineNumber = 1;

      if (in2.hasNextInt()) {
         rows = in2.nextInt();
         cols = in2.nextInt();
         squares = new Square[rows][cols];
         lineNumber += 1;
      }

      else {
         throw new MazeReadException("Rows and columns not specified.", line, lineNumber); 
      }

      while (in.hasNext()) {
         line = in.nextLine();
         in2 = new Scanner(line);
         in2.useDelimiter(",");
         int row = 0;
         int col = 0;
         
         try {
            String type = in2.next();

            if (type.equals("Square")) {
               try {
                  row = in2.nextInt();
                  col = in2.nextInt();

                  if (getSquare(row, col) == null){
                     Square square = new Square(row, col);
                     square.toObject(in2);
                     squares[row][col] = square;
                  }

                  else {
                     throw new MazeReadException("Duplicate square.", line, lineNumber);
                  }

                  lineNumber += 1;
               }

               catch (MazeReadException e) {
                  throw e;
               }

               catch (Exception e) {
                  throw new MazeReadException("Line format or other error.", line, lineNumber);
               }

            }
   
            else if (type.equals("Explorer")) {              
               Explorer ex = new Explorer(this);
               try {
                  ex.toObject(in2);
               }

               catch (Exception e) {
                  throw new MazeReadException("Line format or other error.", line, lineNumber);
               }
               explorer = ex;
               lineNumber += 1;
            }

            else if (type.equals("Treasure")) {
               Treasure treasure = new Treasure(this);
               try {
                  treasure.toObject(in2);
               }
               catch (Exception e) {
                  throw new MazeReadException("Line format or other error.", line, lineNumber);
               }
            
               addRandomOccupant(treasure);
               lineNumber += 1;
            }

            else if (type.equals("Monster")) {
               Monster monster = new Monster(this);
               try {
                  monster.toObject(in2);
               }

               catch (Exception e) {
                  throw new MazeReadException("Line format or other error.", line, lineNumber);
               }

               addRandomOccupant(monster);
               lineNumber += 1;
            }

            else {
               throw new MazeReadException("Unknown type.", line, lineNumber );
            }
         }

         catch (MazeReadException e) {
            throw e ;
         }

         catch (Exception e) {
            throw new MazeReadException("Line format or other error.", line, lineNumber);
         }
      }
   }
}
