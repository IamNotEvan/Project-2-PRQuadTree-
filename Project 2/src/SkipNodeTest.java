    

/**    
Test class for Skip Node class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class SkipNodeTest extends student.TestCase {
    
 
    
 
    
 private SkipNode<String, Point> a;
    
 private KVPair<String, Point> b;
    
 private Point c;
    
 
    
 /**
    
  * Set up method for test class
    
  */
    
 public void setUp()
    
 {   
    
     c = new Point("a", 1, 1);
    
     b = new KVPair<String, Point>(c.getName(), c);
    
     a = new SkipNode<String, Point>(1, b);
    
 }
    
 
    
 /**
    
  * Test all get and set
    
  */
    
 public void testGetAndSet()
    
 {
    
     assertEquals(a.getKey(), b.key());
    
     assertEquals(a.getValue(), b.value());
    
     assertEquals(a.getPair(), b);
    
     a.setSkip(1, a);
    
     assertEquals(a.getSkip(1), a);
    
     assertEquals(a.getLevel(), 1);
    
     assertNotSame(a.getLevel(), 3);
    
     
    
 }
    
 
    
 }