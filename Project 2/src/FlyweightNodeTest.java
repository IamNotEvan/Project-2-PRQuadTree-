import student.testingsupport.PrintStreamWithHistory;
    
 
    

/**  
    This is test class for flyweight node class
     
    @author Evan Lee (evan0110)
    
    @version 09.30.2022
    
*/
    

    
public class FlyweightNodeTest extends student.TestCase {
    
 
    
 private FlyweightNode a;
    
 private Point b;
    
 private LeafNode c;
    
 private Region d;
    
 
    
 /**
    
  * Set up method for test class
    
  */
    
 public void setUp()
    
 {
    
     a = new FlyweightNode();
    
     b = new Point("a", 1, 3);
    
     c = new LeafNode(d, b);
    
     d = new Region();
    
 }
    
 
    
 /**
    
  * Test insert
    
  */
    
 public void testInsert()
    
 {
    
     assertEquals(a.insert(d, b).getClass(),
    
         c.getClass());
    
 }
    
 
    
 /**
    
  * Test dump
    
  */
    
 public void testDump()
    
 {
    
     PrintStreamWithHistory dump1 = systemOut();
    
     assertEquals(a.dump(0, d, 0), 1);
    
     assertEquals("Node at 0, 0, 1024: Empty\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();
    
     assertEquals(a.dump(0, d, 2), 1);
    
     assertEquals("    Node at 0, 0, 1024: Empty\n",
    
         dump1.getHistory());
    
 }
    
 
    
 /**
    
  * Test remove by point
    
  */
    
 public void testRemoveByPoint()
    
 {
    
     assertEquals(a.removeByPoint(d, b), a);
    
 }
    
 
    
 /**
    
  * Test is leaf
    
  */
    
 public void testIsLeaf()
    
 {
    
     assertFalse(a.isLeaf());
    
 }
    
 
    
 /**
    
  * Test is int
    
  */
    
 public void testIsInt()
    
 {
    
     assertFalse(a.isInt());
    
 }
    
 
    
 /**
    
  * Test search by coord
    
  */
    
 public void testSearchByCoord()
    
 {
    
     assertNull(a.searchByCoord(d, 3, 4));
    
 }
    
 
    
 /**
    
  * Test duplicates
    
  */
    
 public void testDuplicates()
    
 {
    
     assertFalse(a.duplicates());
    
 }
    
 
    
 /**
    
  * Test region search
    
  */
    
 public void testRegionSearch()
    
 {
    
     assertEquals(a.regionSearch(0,
    
         d, 0, 0, 5, 5), 1);
    
     assertEquals(a.regionSearch(0,
        
         d, 2000, 0, 5, 5), 0);
        
 }
        
 
        
 }