import java.io.File;
    
import java.io.FileNotFoundException;
    
 
    
 
    
/**
    
Main for CS3114 Quadtree/SkipList Point project
    
Usage: java Point2 <command-file>
    
  *
    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/

    
public class Point2 {
    
 
    
 /**
    
  * This is main fuction that start this program
    
  * @param args
    
  *      the file name
    
  * @throws FileNotFoundException
    
  *      if file is not found
    
  */
    
 public static void main(String[] args) throws FileNotFoundException {
    
     if (args.length != 1) {
    
         System.out.println("Usage: java Point2 <command-file>");
    
         return;
    
     }
    
 
    
     String filename = args[0].trim();
    
     File commandFile = new File(filename);
    
     if (!commandFile.exists()) {
    
         System.out.println("File does not exist: " + filename);
    
         return;
    
     }
    
     try
    
     {
    
         DataBase listAndTree = new DataBase(filename);
    
         listAndTree.doCommand();
    
 
    
     }
    
     catch (FileNotFoundException e)
    
     {
    
         System.out.println("Invalid Input");
    
         throw new FileNotFoundException();
    
     }
    
     
    
 }
    
 
    
 }