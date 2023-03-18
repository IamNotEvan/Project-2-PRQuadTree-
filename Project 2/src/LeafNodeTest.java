import student.testingsupport.PrintStreamWithHistory;
    
 
    
/**
    
This is test class for leaf node
    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/
    

    
public class LeafNodeTest extends student.TestCase {
    
 
    
 private LeafNode a;
    
 private LeafNode a1;
    
 private Point point1;
    
 private Region region;
    
 private IntNode b;
    
 private FlyweightNode c;
    
 
    
 /**
    
  * Set up method for test class
    
  */
    
 public void setUp()
    
 {   
    
     region = new Region();
    
     point1 = new Point("p1", 4, 4);
    
     a = new LeafNode(region, point1);
    
     a1 = new LeafNode(region);
    
     b = new IntNode();
    
     c = new FlyweightNode();
    
     //list = new LinkedList();
    
 }
    
 
    
 /**
    
  * Test get Skiplist and set SkipList
    
  */
    
 public void testGetAndSetPointList()
    
 {
    
     assertEquals(a.getPointList().length(), 1);
    
     LinkedList list = new LinkedList();
    
     a.setPointList(list);
    
     assertEquals(a.getPointList().length(), 0);
    
 }
    
 
    
 /**
    
  * Test insert
    
  */
    
 public void testInsert()
    
 {
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 2);
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 3);
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 4);
    
     
    
     Point p2 = new Point("p2", 300, 15);
    
     assertEquals(a.insert(region, p2).getClass(),
    
         b.getClass()); 
    
     
    
     assertEquals(a1.insert(region, point1), a1);
    
 }
    
 
    
 /**
    
  * Test dump
    
  */
    
 public void testDump()
    
 {
    
     PrintStreamWithHistory dump = systemOut();
    
     a.dump(0, region, 0);
    
     assertEquals("Node at 0, 0, 1024:\n"
    
         + "(p1, 4, 4)\n", dump.getHistory());
    
     dump.clearHistory();
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 2);
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 3);
    
     a.dump(0, region, 0);
    
     assertEquals("Node at 0, 0, 1024:\n"
    
         + "(p1, 4, 4)\n"
    
         + "(p1, 4, 4)\n"
    
         + "(p1, 4, 4)\n", dump.getHistory());
    
     dump.clearHistory();
    
     Point p2 = new Point("p2", 300, 15);
    
     assertEquals(a.insert(region, p2).getClass(),
    
         b.getClass());
    
 }
    
 
    
 /**
    
  * test decomposition
    
  */
    
 public void testDecomposition()
    
 {
    
     Point p2 = new Point("p2", 300, 15);
    
     assertFalse(a.decomposition(p2));
    
     assertFalse(a.decomposition(point1));
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 2);
    
     assertEquals(a.insert(region, point1), a);
    
     assertEquals(a.getPointList().length(), 3);
        
     assertTrue(a.decomposition(p2));
        
     assertFalse(a.decomposition(point1));
        
     
        
     
        
     Point a2 = new Point("p2", 5, 4);
        
     Point b2 = new Point("p2", 4, 5);
        
     assertTrue(a.decomposition(a2));
        
     assertTrue(a.decomposition(b2));
        
     
        
 }
        
 /**
        
  * Test all is method
        
  */
        
 public void testIsMethod()
        
 {
        
     assertTrue(a.isLeaf());
        
     assertFalse(a.isInt());
        
 }
        
 
        
 /**
        
  * Test seach by coord
        
  */
        
 public void testSearchByCoord()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     Point p2 = new Point("p2", 4, 4);
        
     Point p3 = new Point("p3", 4, 4);
        
     assertEquals(a.insert(region, p3), a);
        
     assertEquals(a.getPointList().length(), 2);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p3, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertNull(a.searchByCoord(region, 5, 5));
        
     assertEquals(a.searchByCoord(region, 4, 4), point1);
        
     
        
     assertEquals(a.insert(region, p2), a);
        
     assertEquals(a.getPointList().length(), 3);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p3, 4, 4)\n"
        
         + "(p2, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.searchByCoord(region, 4, 4), point1);
        
 }
        
 /**
        
  * Test remove by point
        
  */
        
 public void testRemoveByPoint()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     Point p2 = new Point("p2", 4, 4);
        
     Point p3 = new Point("p3", 4, 4);
        
     assertEquals(a.insert(region, p3), a);
        
     assertEquals(a.getPointList().length(), 2);
        
     assertEquals(a.insert(region, p2), a);
        
     assertEquals(a.getPointList().length(), 3);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p3, 4, 4)\n"
        
         + "(p2, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, p3), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     assertEquals(a.getPointList().length(), 2);
        
     
        
     Point p21 = new Point("p2", 300, 15);
        
     assertEquals(a.insert(region, p21), a);
        
     assertEquals(a.getPointList().length(), 3);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 4, 4)\n"
        
         + "(p2, 300, 15)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, p21), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     assertEquals(a.getPointList().length(), 2);
        
     
        
     assertEquals(a.removeByPoint(region, point1), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p2, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     assertEquals(a.getPointList().length(), 1);
        
     
        
     assertEquals(a.removeByPoint(region, p2).getClass(),
        
         c.getClass());
        
     
        
 }
        
 
        
 /**
        
  * Test remove
        
  */
        
 public void testRemove()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     assertEquals(a.insert(region, point1), a);
        
     assertEquals(a.insert(region, point1), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, point1), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
 }
        
 
        
 /**
        
  * Test duplicates
        
  */
        
 public void testDuplicates()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     assertFalse(a1.duplicates());
        
     assertFalse(a.duplicates());
        
     
        
     Point p2 = new Point("p2", 4, 4);
        
     Point p3 = new Point("p3", 4, 4);
        
     
        
     
        
     assertEquals(a.insert(region, point1), a);
        
     assertEquals(a.insert(region, p2), a);
        
     assertEquals(a.insert(region, p3), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 4, 4)\n"
        
         + "(p3, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(a.duplicates());
        
     assertEquals("(4, 4)\n", dump.getHistory()); 
        
 }
        
 
        
 /**
        
  * Test duplicates when there are 2 points in node
        
  */
        
 public void testDuplicates2()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     assertFalse(a1.duplicates());
        
     assertFalse(a.duplicates());
        
     
        
     Point p2 = new Point("p2", 5, 4);
        
     Point p3 = new Point("p3", 4, 4);
        
     assertEquals(a.insert(region, p2), a);
        
     assertFalse(a.duplicates());
        
     dump.clearHistory();
        
     assertEquals(a.removeByPoint(region, p2), a);
        
     assertEquals(a.insert(region, p3), a);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p3, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     assertTrue(a.duplicates());
        
     assertEquals("(4, 4)\n", dump.getHistory());  
        
 }
        
 
        
 /**
        
  * Test duplicates when there are 3 points in node
        
  */
        
 public void testDuplicates3()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     assertFalse(a1.duplicates());
        
     assertFalse(a.duplicates());
        
     
        
     Point p2 = new Point("p2", 5, 4);
        
     Point p3 = new Point("p3", 4, 4);
        
     Point p4 = new Point("p2", 7, 7);
        
     
        
     assertEquals(a.insert(region, p2), a);
        
     assertEquals(a.insert(region, p4), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 5, 4)\n"
        
         + "(p2, 7, 7)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertFalse(a.duplicates());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, p2), a);
        
     assertEquals(a.insert(region, p3), a);
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 7, 7)\n"
        
         + "(p3, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(a.duplicates());
        
     assertEquals("(4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, p4), a);
        
     assertEquals(a.insert(region, p2), a);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p3, 4, 4)\n"
        
         + "(p2, 5, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(a.duplicates());
        
     assertEquals("(4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.removeByPoint(region, p3), a);
        
     Point p5 = new Point("p5", 5, 4);
        
     assertEquals(a.insert(region, p5), a);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 5, 4)\n"
        
         + "(p5, 5, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertTrue(a.duplicates());
        
     assertEquals("(5, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
 }
        
 
        
 /**
        
  * Test region search
        
  */
        
 public void testRegionSearch()
        
 {
        
     PrintStreamWithHistory dump = systemOut();
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.insert(region, point1), a);
        
     
        
     a.dump(0, region, 0);
        
     assertEquals("Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n", dump.getHistory());
        
     dump.clearHistory();
        
     
        
     assertEquals(a.regionSearch(0, region,
        
         7, 7, 5, 5), 1);
        
     assertEquals(a.regionSearch(0, region,
        
         4000, 40000, 5, 5), 0);
        
 
        
     assertEquals(a.regionSearch(0, region, 0, 0, 5, 5), 1);
        
     assertEquals("Point found: (p1, 4, 4)\n"
        
         + "Point found: (p1, 4, 4)\n",
        
         dump.getHistory());
        
     dump.clearHistory();
        
      
        
     
        
 }
        
 }