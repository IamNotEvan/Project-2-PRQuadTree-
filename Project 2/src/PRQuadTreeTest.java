    
import student.testingsupport.PrintStreamWithHistory;
    
 
    
/**
    
Test class for the PRQuadTree class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class PRQuadTreeTest extends student.TestCase {
    
 
    
 private PRQuadTree a;
    
 private Region b;
    
 @SuppressWarnings("unused")
    
 private Point d1;
    
 
    
 /**
    
  * Set up method for test class
    
  */
    
 public void setUp()
    
 {
    
     a = new PRQuadTree();
    
     b = new Region();
    
     d1 = new Point("a", 5, 5);
    
 }
    
 
    
 /**
    
  * Test insert and dump
    
  */
    
 public void testInsertAndDump()
    
 {
    
     
    
     PrintStreamWithHistory dump1 = systemOut();
    
     a.dump(b);
    
     assertEquals("QuadTree dump:\n"
    
         + "Node at 0, 0, 1024: Empty\n"
    
         + "1 quadtree nodes printed\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();
    
     Point a1 = new Point("p1", 4, 4);
    
     a.insert(b, a1);
    
     a.dump(b);
    
     assertEquals("QuadTree dump:\n"
    
         + "Node at 0, 0, 1024:\n"
    
         + "(p1, 4, 4)\n"
    
         + "1 quadtree nodes printed\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();
    
     
    
     
    
     a.insert(b, a1);
    
     a.dump(b);
    
     assertEquals("QuadTree dump:\n"
    
         + "Node at 0, 0, 1024:\n"
    
         + "(p1, 4, 4)\n"
    
         + "(p1, 4, 4)\n"
    
         + "1 quadtree nodes printed\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();
    
     
    
     
    
     
    
     a.insert(b, a1);
    
     a.dump(b);
    
     assertEquals("QuadTree dump:\n"
    
         + "Node at 0, 0, 1024:\n"
    
         + "(p1, 4, 4)\n"
    
         + "(p1, 4, 4)\n"
    
         + "(p1, 4, 4)\n"
    
         + "1 quadtree nodes printed\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();
    
     
    
     Point as = new Point("p2", 700, 100);
    
     a.insert(b, as);
    
     a.dump(b);
    
     assertEquals("QuadTree dump:\n"
    
         + "Node at 0, 0, 1024: Internal\n"
    
         + "  Node at 0, 0, 512:\n"
    
         + "  (p1, 4, 4)\n"
    
         + "  (p1, 4, 4)\n"
    
         + "  (p1, 4, 4)\n"
    
         + "  Node at 512, 0, 512:\n"
    
         + "  (p2, 700, 100)\n"
    
         + "  Node at 0, 512, 512: Empty\n"
    
         + "  Node at 512, 512, 512: Empty\n"
    
         + "5 quadtree nodes printed\n",
    
         dump1.getHistory());
    
     dump1.clearHistory();     
    
 }
    
 
    
 /**
    
  * Test complex part
    
  */
    
 public void testComplex() 
    
 {
    
     PrintStreamWithHistory dump1 = systemOut();
    
     Point a1 = new Point("p1", 4, 4);
    
     Point c1 = new Point("c", 4, 4);
        
     Point d = new Point("d", 4, 4);
        
     a.insert(b, a1);
        
     a.insert(b, c1);
        
     a.insert(b, d);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(c, 4, 4)\n"
        
         + "(d, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
 }
        
 
        
 /**
        
  * Test search by point
        
  */
        
 public void testSearchByPoint()
        
 {
        
     PrintStreamWithHistory dump1 = systemOut();
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p4 = new Point("p4", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.insert(b, p4);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.insert(b, p5);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     assertNull(a.searchByCoord(b, 6, 6));
        
     assertNull(a.searchByCoord(b, 700, 6));
        
     assertNull(a.searchByCoord(b, 0, 200));
        
     assertNull(a.searchByCoord(b, 700, 700));
        
     
        
     assertEquals(a.searchByCoord(b, 4, 4), p1);
        
     assertEquals(a.searchByCoord(b, 700, 4), p4);
        
 }
        
 
        
 /**
        
  * Test remove by point
        
  */
        
 public void testRemoveByPoint()
        
 {
        
     PrintStreamWithHistory dump1 = systemOut();
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p4 = new Point("p4", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     a.insert(b, p4);
        
     a.insert(b, p5);
        
     
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     Point noPoint = new Point("as", 7, 7);
        
     a.removeByPoint(b, noPoint);
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.removeByPoint(b, p5);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.removeByPoint(b, p4);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.insert(b, p4);
        
     a.insert(b, p5);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     Point p3 = new Point("p3", 4, 4);
        
     a.insert(b, p3);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p3, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.removeByPoint(b, p3);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     
        
     
        
     a.removeByPoint(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.removeByPoint(b, p5);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p4, 700, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();
        
     
        
     a.removeByPoint(b, p4);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dump1.getHistory());
        
     dump1.clearHistory();   
        
 }
        
 
        
 /**
        
  * Test duplicates
        
  */
        
 public void testDuplicates()
        
 {
        
     PrintStreamWithHistory dup = systemOut();
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p2 = new Point("p2", 300, 15);
        
     Point p4 = new Point("p4", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     
        
     a.insert(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.duplicates();
        
     assertEquals("Duplicate points:\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.insert(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.duplicates();
        
     assertEquals("Duplicate points:\n"
        
         + "(4, 4)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.insert(b, p4);
        
     a.insert(b, p5);
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512:\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  (p1, 4, 4)\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "5 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.duplicates();
        
     assertEquals("Duplicate points:\n"
        
         + "(4, 4)\n"
        
         + "(700, 4)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.insert(b, p2);
        
     a.insert(b, p2);
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024: Internal\n"
        
         + "  Node at 0, 0, 512: Internal\n"
        
         + "    Node at 0, 0, 256:\n"
        
         + "    (p1, 4, 4)\n"
        
         + "    (p1, 4, 4)\n"
        
         + "    Node at 256, 0, 256:\n"
        
         + "    (p2, 300, 15)\n"
        
         + "    (p2, 300, 15)\n"
        
         + "    Node at 0, 256, 256: Empty\n"
        
         + "    Node at 256, 256, 256: Empty\n"
        
         + "  Node at 512, 0, 512:\n"
        
         + "  (p4, 700, 4)\n"
        
         + "  (p5, 700, 4)\n"
        
         + "  Node at 0, 512, 512: Empty\n"
        
         + "  Node at 512, 512, 512: Empty\n"
        
         + "9 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.duplicates();
        
     assertEquals("Duplicate points:\n"
        
         + "(4, 4)\n"
        
         + "(300, 15)\n"
        
         + "(700, 4)\n", dup.getHistory());
        
     dup.clearHistory();
        
 }
        
 
        
 /**
        
  * Test webcat special case
        
  */
        
 @SuppressWarnings("unused")
        
 public void testWebcat()
        
 {
        
     PrintStreamWithHistory dup = systemOut();
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p2 = new Point("p2", 300, 15);
        
     Point p4 = new Point("p4", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.removeByPoint(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.insert(b, p2);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p2, 300, 15)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.removeByPoint(b, p2);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
  
        
     
        
 }
        
 /**
        
  * Test region search
        
  */
        
 public void testRegionSearch()
        
 {
        
     PrintStreamWithHistory dup = systemOut();
        
     assertTrue(true);
        
     a.regionSearch(b, 4, 4, -5, -5);
        
     assertEquals("Rectangle rejected: (4, 4, -5, -5)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     Point p1 = new Point("p1", 4, 4);
        
     a.insert(b, p1);
        
     a.insert(b, p1);
        
     a.dump(b);
        
     assertEquals("QuadTree dump:\n"
        
         + "Node at 0, 0, 1024:\n"
        
         + "(p1, 4, 4)\n"
        
         + "(p1, 4, 4)\n"
        
         + "1 quadtree nodes printed\n",
        
         dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.regionSearch(b, 0, 0, 1024, 1024);
        
     assertEquals("Points intersecting region (0, 0, 1024, 1024)\n"
        
         + "Point found: (p1, 4, 4)\n"
        
         + "Point found: (p1, 4, 4)\n"
        
         + "1 quadtree nodes visited\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.regionSearch(b, 4, 4, -5, 5);
        
     assertEquals("Rectangle rejected: (4, 4, -5, 5)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     a.regionSearch(b, 4, 4, 5, -5);
        
     assertEquals("Rectangle rejected: (4, 4, 5, -5)\n", dup.getHistory());
        
     dup.clearHistory();
        
     
        
     
        
     
        
 }
        
 
        
 }