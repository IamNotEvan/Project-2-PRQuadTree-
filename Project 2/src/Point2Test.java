
import java.io.IOException;
    
import student.TestCase;
    
 
    

/**  
This class tests the Point2 project
    
  *
    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/
    

    
public class Point2Test extends TestCase {
    
 
    
 /**
    
  * Set up method for this test class
    
  */
    
 public void setUp() 
    
 {
    
     
    
 }
    
 
    
 /**
    
  * Test bad files
    
  * 
    
  * @throws IOException
    
  *      if file not found
    
  */
    
 public void testBadFile() throws IOException
    
 {
    
     String[] args = new String[1];
    
     args[0] = "NO_input_file_exists.txt";
    
     Point2.main(args);
    
     String out = systemOut().getHistory();
    
     assertFuzzyEquals(
    
         "File does not exist: NO_input_file_exists.txt", out);
    
 }
    
 
    
 }