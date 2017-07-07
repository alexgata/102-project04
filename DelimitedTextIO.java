import java.util.*;

public interface DelimitedTextIO 
{
   String toText(char delimiter);

   /**
    * This method returns a String containing all the data of the implementing class as text with each element separated by the provided delimiter.
    */

   void toObject(Scanner input);

   /** This method uses the provided Scanner input to parse delimited text representing the date for the implementing class and initializes the objects instance variables with the parsed values; The delimiter to use must be specified fot the Scanner input beore calling this method.
    */
}
