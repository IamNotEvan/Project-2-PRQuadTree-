
/**
    
This is test class for the linked list
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class LinkTest extends student.TestCase {
    
 
    
 private Link a;
    
 private Link b;
    
 private Point p;
    
 
    
 /**
    
  * Set up class for the test class
    
  */
    
 public void setUp()
    
 {
    
     p = new Point("p1", 4, 4);
    
     a = new Link(p, null);
    
     b = new Link(null);
    
 }
    
 
    
 /**
    
  * Test element()
    
  */
    
 public void testElement()
    
 {
    
     assertNull(b.element());
    
     assertEquals(a.element(), p);
    
 }
    
 
    
 /**
    
  * Test set element
    
  */
    
 public void testSetElement()
    
 {
    
     assertEquals(b.setElement(p), p);
    
     assertEquals(b.element(), p);
    
 }
    
 
    
 /**
    
  * Test next and set next
    
  */
    
 public void testNextandSetNext()
    
 {
    
     assertNull(a.next());
    
     assertEquals(a.setNext(a), a);
    
     assertEquals(a.next(), a);
    
 }
    
 
    
 }