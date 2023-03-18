
import student.testingsupport.PrintStreamWithHistory;
    
 
    
/**  
    This is test class for Int node class
   
    @author Evan Lee (evan0110)
    
    @version 09.30.2022   
*/
    

    
public class IntNodeTest extends student.TestCase {
    
 
    
 private IntNode i1;
    
 @SuppressWarnings("unused")
    
 private IntNode i2;
    
 private LeafNode l1;
    
 private Region region;
    
 private Point p1;
    
 
    
 /**
    
  * Set up method for test
    
  */
    
 public void setUp()
    
 {
    
     region = new Region();
    
     p1 = new Point("p1", 4, 4);
    
     l1 = new LeafNode(region, p1);
    
     l1.insert(region, p1);
    
     i1 = new IntNode(region, l1);
    
     i2 = new IntNode();
    
 }
    
 
    
 /**
    
  * Test insert
    
  */
    
 public void testInsert()
    
 {
    
     assertEquals(i1.insert(region, p1), i1);  
    
 }
    
 
    
 /**
    
  * Test new region
    
  */
    
 public void testNewRegion()
    
 {
    
     Region nW = i1.newRegion(region, 0);
    
     assertEquals(nW.getSize(), 512);
    
     assertEquals(nW.getX(), 0);
    
     assertEquals(nW.getY(), 0);
    
     
    
     Region nE = i1.newRegion(region, 1);
    
     assertEquals(nE.getSize(), 512);
    
     assertEquals(nE.getX(), 512);
    
     assertEquals(nE.getY(), 0);
    
     
    
     Region sW = i1.newRegion(region, 2);
    
     assertEquals(sW.getSize(), 512);
    
     assertEquals(sW.getX(), 0);
    
     assertEquals(sW.getY(), 512);
    
     
    
     Region sE = i1.newRegion(region, 3);
    
     assertEquals(sE.getSize(), 512);
    
     assertEquals(sE.getX(), 512);
    
     assertEquals(sE.getY(), 512);
    
 }
    
 
    
 /**
    
  * Test pick position number
    
  */
    
 public void testPickPos()
    
 {
    
     assertEquals(i1.pickPos(region, p1), 0);
    
     Point p2 = new Point("a", 700, 4);
    
     assertEquals(i1.pickPos(region, p2), 1);
    
     Point p3 = new Point("a", 4, 700);
    
     assertEquals(i1.pickPos(region, p3), 2);
    
     Point p4 = new Point("a", 700, 700);
    
     assertEquals(i1.pickPos(region, p4), 3);
    
     
    
     Point a1 = new Point("a", 0, 0);
    
     assertEquals(i1.pickPos(region, a1), 0);
    
     
    
     Point a2 = new Point("a", 512, 0);
    
     assertEquals(i1.pickPos(region, a2), 1);
    
     
    
     Point a3 = new Point("a", 0, 512);
    
     assertEquals(i1.pickPos(region, a3), 2);
    
     
    
     Point a4 = new Point("a", 512, 512);
    
     assertEquals(i1.pickPos(region, a4), 3);
    
     
    
     
    
     
    
     
    
     
    
     
    
     
    
 }
    
 
    
 /**
        
  * Test dump
        
  */
        
 public void testDump()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
 }
        
 
        
 /**
        
  * Test is leaf and int methods
        
  */
        
 public void testIsMethods()
        
 {
        
     assertFalse(i1.isLeaf());
        
     assertTrue(i1.isInt());
        
 }
        
 
        
 /**
        
  * Test search by coordinates
        
  */
        
 public void testSearchByCoord()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(i1.insert(region, p1), i1);
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     Point p2 = new Point("p2", 700, 10);
        
     assertEquals(i1.insert(region, p2), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertNull(i1.searchByCoord(region, 700, 700));
        
     assertNull(i1.searchByCoord(region, 5, 5));
        
     assertNull(i1.searchByCoord(region, 705, 12));
        
     
        
     assertEquals(i1.searchByCoord(region, 4, 4), p1);
        
     assertEquals(i1.searchByCoord(region, 700, 10), p2);
        
     
        
     Point p3 = new Point("p3", 700, 10);
        
     assertEquals(i1.insert(region, p3), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(i1.searchByCoord(region, 700, 10), p2);
        
     
        
     
        
 }
        
 
        
 /**
        
  * Test remove by point
        
  */
        
 public void testRemoveByPoint()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     Point p2 = new Point("p2", 700, 10);
        
     assertEquals(i1.insert(region, p2), i1);
        
     Point p3 = new Point("p3", 700, 10);
        
     assertEquals(i1.insert(region, p3), i1);
        
     assertEquals(i1.insert(region, p1), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     
        
     assertEquals(i1.removeByPoint(region, p2), i1);
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(i1.removeByPoint(region, p1).isLeaf());
        
     
        
 }
        
 
        
 /**
        
  * Test remove by points
        
  */
        
 public void testRemoveByPoint2()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     assertEquals(i1.insert(region, p1), i1);
        
     assertEquals(i1.insert(region, p1), i1);
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     Point p2 = new Point("p2", 700, 10);
        
     assertEquals(i1.insert(region, p2), i1);
        
     Point p3 = new Point("p3", 700, 10);
        
     assertEquals(i1.insert(region, p3), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(i1.removeByPoint(region, p2), i1);
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(i1.removeByPoint(region, p3).isLeaf());
        
     
        
 }
        
 
        
 /**
        
  * Test duplicates
        
  */
        
 public void testDuplicates()
        
 {
        
     PrintStreamWithHistory dup = systemOut();
        
     
        
     
        
     assertTrue(i1.removeByPoint(region, p1).isLeaf());
        
     assertFalse(i1.duplicates());
        
     dup.clearHistory();
        
     
        
     Point p2 = new Point("p2", 700, 10);
        
     assertEquals(i1.insert(region, p2), i1);
        
     Point p3 = new Point("p3", 700, 10);
        
     assertEquals(i1.insert(region, p3), i1);
        
     assertEquals(i1.insert(region, p1), i1);
        
     assertEquals(i1.insert(region, p1), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     assertTrue(i1.duplicates());
        
     assertEquals("(4, 4)\n"
        
         + "(700, 10)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     Point p5 = new Point("p5", 300, 15);
        
     assertEquals(i1.insert(region, p5), i1);
        
     assertEquals(i1.insert(region, p5), i1);
        
     assertEquals(i1.removeByPoint(region, p1), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512: Internal\n"
        
         + "    Node at 0, 0, 256:\n"
        
         + "    (p1, 4, 4)\n"
        
         + "    (p1, 4, 4)\n"
        
         + "    Node at 256, 0, 256:\n"
        
         + "    (p5, 300, 15)\n"
        
         + "    (p5, 300, 15)\n"
        
         + "    Node at 0, 256, 256: Empty\n"
        
         + "    Node at 256, 256, 256: Empty\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  (p3, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     assertTrue(i1.duplicates());
        
     assertEquals("(4, 4)\n"
        
         + "(300, 15)\n"
        
         + "(700, 10)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
 }
        
 
        
 /**
        
  * Test region search
        
  */
        
 public void testregionSearch()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512: Empty\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(i1.insert(region, p1), i1);
        
     Point p2 = new Point("p2", 700, 10);
        
     assertEquals(i1.insert(region, p2), i1);
        
     
        
     i1.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p2, 700, 10)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(i1.regionSearch(0, region, 0, 0, 1024, 1024), 5);
        
     assertEquals("Point found: (p1, 4, 4)\n"
        
         + "Point found: (p1, 4, 4)\n"
        
         + "Point found: (p1, 4, 4)\n"
        
         + "Point found: (p2, 700, 10)\n",
        
         dump.getHistory());
        
 }
        
 
        
 }