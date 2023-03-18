/**
    
This is test class for linked list class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class LinkedListTest extends student.TestCase {
    
 
    
 private LinkedList link;
    
 private Point p;
    
 
    
 /**
    
  * Set up method for this test class
    
  */
    
 public void setUp()
    
 {
    
     link = new LinkedList();
    
     p = new Point("p1", 4, 4);
    
 }
    
 
    
 /**
    
  * Test append
    
  */
    
 public void testAppend()
    
 {
    
     
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertEquals(link.length(), 2);
    
     link.clear();
    
     assertEquals(link.length(), 0);  
    
     //assertNull(link.remove());
    
 }
    
 
    
 /**
    
  * 
    
  */
    
 public void testRemove()
    
 {
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     
    
     link.moveToStart();
    
     assertEquals(link.remove(), p);
    
     assertEquals(link.length(), 2);
    
     
    
     link.moveToStart();
    
     assertEquals(link.remove(), p);
    
     assertEquals(link.length(), 1);
    
     
    
     link.moveToStart();
    
     assertEquals(link.remove(), p);
    
     assertEquals(link.length(), 0);
    
     
    
     link.moveToStart();
    
     assertNull(link.remove());
    
     link.next();
    
     
    
     
    
     //assertEquals(link.length(), 2);
    
 }
    
 
    
 /**
    
  * Test all methods
    
  */
    
 public void testAll()
    
 {
    
     Point p2 = new Point("b", 1, 1);
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p2));
    
   
    
     link.moveToStart();
    
     assertEquals(link.getValue(), p);
    
     link.next();
    
     assertEquals(link.getValue(), p2);
    
     assertEquals(link.length(), 2); 
    
 }
    
 
    
 /**
    
  * Test all methods 2
    
  */
    
 public void testAll2()
    
 {
    
     Point p2 = new Point("b", 1, 1);
    
     assertTrue(link.append(p2));
    
     assertEquals(link.length(), 1);
    
     link.clear();
    
     assertEquals(link.length(), 0);
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertTrue(link.append(p));
    
     assertTrue(link.allSame());
    
     
    
     assertTrue(link.append(p2));
        
     assertFalse(link.allSame());
        
 }
        
 }
