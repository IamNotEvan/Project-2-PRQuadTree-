
import student.TestCase;
    
 
    

/**   
Test class for point class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class PointTest extends TestCase {
    
 
    
 private Point point1;
    
 
    
 /**
    
  * Set Up method for test class
    
  */
    
 public void setUp()
    
 {
    
     point1 = new Point("a", 1, 1);
    
     
    
 }
    
 
    
 /**
    
  * Test all get and set methods
    
  */
    
 public void testGetAndSet()
    
 {
    
     assertEquals(point1.getName(), "a");
    
     point1.setName("b");
    
     assertEquals(point1.getName(), "b");
    
     assertEquals(point1.getXPoints(), 1);
    
     point1.setXPoints(2);
    
     assertEquals(point1.getXPoints(), 2);
    
     assertEquals(point1.getYPoints(), 1);
    
     point1.setYPoints(2);
    
     assertEquals(point1.getYPoints(), 2);  
    
     
    
 }
    
 
    
 
    
 /**
    
  * Test to string
    
  */
    
 public void testtoString()
    
 {
    
     assertEquals(point1.toString(), "a, 1, 1)");
    
     point1.setName(null);
    
     assertEquals(point1.toString(), "null"); 
    
 }
    
 
    
 /**
    
  * Test in the box
    
  */
    
 public void testInTheBox()
    
 {
    
     assertTrue(point1.inTheBox());
    
     Point point2 = new Point("a", -4, 3);
    
     assertFalse(point2.inTheBox());
    
     Point point3 = new Point("a", 4, -3);
    
     assertFalse(point3.inTheBox());
    
     Point point4 = new Point("a", 2000, 3);
    
     assertFalse(point4.inTheBox());
    
     Point point5 = new Point("a", 4, 2000);
    
     assertFalse(point5.inTheBox());
    
     
    
 }
    
 
    
   /**
    
    * Test has same point
    
    */
    
   public void testHasSamePoints()
    
   {
    
       Point a1 = new Point("a", 1, 1);
    
       Point a2 = new Point("a", 1, 2);
    
       Point a3 = new Point("a", 2, 2);
    
       Point a4 = new Point("a", 2, 1);
    
       assertTrue(point1.equals(a1));
    
       assertFalse(point1.equals(a2));
    
       assertFalse(point1.equals(a3));
    
       assertFalse(point1.equals(a4));
    
   }
    
 
    
 /**
    
  * Test same x y
    
  */
    
 public void testSameXY()
    
 {
    
     Point a1 = new Point("a", 1, 1);
    
     Point a2 = new Point("a", 1, 2);
    
     Point a3 = new Point("a", 2, 2);
    
     Point a4 = new Point("a", 2, 1);
    
     assertTrue(point1.sameXY(a1));
    
     assertFalse(point1.sameXY(a2));
    
     assertFalse(point1.sameXY(a3));
    
     assertFalse(point1.sameXY(a4));
    
 }
    
 
    
 /**
    
  * Test is in rec
        
  */
        
 public void testIsInRec()
        
 {
        
     Point a1 = new Point("a", 1, 1);
        
     Point a2 = new Point("a", 7, 7);
        
     assertTrue(a1.isInRec(0, 0, 5, 5));
        
     assertFalse(a2.isInRec(0, 0, 5, 5));
        
     
        
     assertFalse(a1.isInRec(100, 0, 0, 0));
        
     assertFalse(a1.isInRec(0, 0, -5, 0));
        
     assertFalse(a1.isInRec(0, 10, 5, 0));
        
     assertFalse(a1.isInRec(0, 0, 5, -5));
        
     
        
     
        
     
        
 }
        
 
        
 }