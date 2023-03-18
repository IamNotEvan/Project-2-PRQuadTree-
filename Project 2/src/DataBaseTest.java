import java.io.FileNotFoundException;
    
import student.TestableRandom;
    
import student.testingsupport.PrintStreamWithHistory;
    
 
    

    
/**
 * This is test case for database
 * 
 * @author Evan Lee (evan0110)
 * @version 09.30.2022   
 *
 */
    

    

    

    
@SuppressWarnings("unused")
    
public class DataBaseTest extends student.TestCase {
    
 
    
 private DataBase a;
    
 private DataBase b;
    
 //private DataBase b;
    
 
    
 /**
    
  * set up method for this test case
    
  */
    
 public void setUp()
    
 {
    
     a = new DataBase();
    
     student.TestableRandom.setNextBooleans(new boolean[]
    
         {true, false, true, true, false, true, false,
    
             true, false, true, false, true, false, true, true, false});
    
     b = new DataBase("ExampleInput.txt");
    
 }
    
 
    
 /**
    
  * This test do command
    
  */
    
 public void testDoCommand()
    
 {
    
     assertTrue(true);
    
     try {
    
         b.doCommand();
    
     }
    
     catch (FileNotFoundException e) {
    
         
    
         e.printStackTrace();
    
     }
    
 }
    
 
    
 /**
    
  * Test case for insert
    
  */
    
 public void testInsert()
    
 {
    
     
    
     assertEquals("Point inserted: (p1, 4, 4)\n",
    
         a.insertPoints("p1", 4, 4));
    
     assertEquals(a.getList().size(), 1);
    
     assertEquals("Point inserted: (p1, 4, 4)\n",
    
         a.insertPoints("p1", 4, 4));
    
     assertEquals(a.getList().size(), 2);
    
     assertEquals("Point inserted: (p1, 4, 4)\n",
    
         a.insertPoints("p1", 4, 4));
    
     assertEquals(a.getList().size(), 3);
    
     assertEquals("Point inserted: (p2, 300, 15)\n",
    
         a.insertPoints("p2", 300, 15));
    
     assertEquals(a.getList().size(), 4);
    
     assertEquals("Point inserted: (p4, 700, 4)\n",
    
         a.insertPoints("p4", 700, 4));
    
     assertEquals(a.getList().size(), 5);
    
     assertEquals("Point inserted: (p5, 700, 4)\n",
    
         a.insertPoints("p5", 700, 4));
    
     assertEquals(a.getList().size(), 6);
    
     assertEquals("Point inserted: (pointy, 200, 900)\n",
    
         a.insertPoints("pointy", 200, 900));
    
     assertEquals(a.getList().size(), 7);
    
     assertEquals("Point rejected: (bad1, 1134, 12)\n",
    
         a.insertPoints("bad1", 1134, 12));
    
     assertEquals(a.getList().size(), 7);
    
     assertEquals("Point rejected: (bad2, 3, 3221)\n",
    
         a.insertPoints("bad2", 3, 3221));
    
     assertEquals(a.getList().size(), 7);
    
     assertEquals("Point rejected: (bad3, -3, 2)\n",
    
         a.insertPoints("bad3", -3, 2));
    
     assertEquals(a.getList().size(), 7);
    
     
    
 }
    
  
    
 /**
    
  * Test case for dump
    
  */
    
 public void testDump()
    
 {
    
     PrintStreamWithHistory dump = systemOut();
    
     assertEquals("SkipList dump:\n"
    
         + "Node has depth 1, Value (null)\n"
    
         + "SkipList size is: 0\n", a.dumpPoints());
    
     dump.clearHistory();
    
  
    
     assertEquals("Point inserted: (p1, 4, 4)\n",
    
         a.insertPoints("p1", 4, 4));
    
     assertEquals(a.getList().size(), 1);
    
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 2);
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 3);
        
     assertEquals("Point inserted: (p2, 300, 15)\n",
        
         a.insertPoints("p2", 300, 15));
        
     assertEquals(a.getList().size(), 4);
        
     assertEquals("Point inserted: (p4, 700, 4)\n",
        
         a.insertPoints("p4", 700, 4));
        
     assertEquals(a.getList().size(), 5);
        
     assertEquals("Point inserted: (p5, 700, 4)\n",
        
         a.insertPoints("p5", 700, 4));
        
     assertEquals(a.getList().size(), 6);
        
     assertEquals("Point inserted: (pointy, 200, 900)\n",
        
         a.insertPoints("pointy", 200, 900));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad1, 1134, 12)\n",
        
         a.insertPoints("bad1", 1134, 12));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad2, 3, 3221)\n",
        
         a.insertPoints("bad2", 3, 3221));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad3, -3, 2)\n",
        
         a.insertPoints("bad3", -3, 2));
        
     assertEquals(a.getList().size(), 7);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p2, p2, 300, 15)\n"
        
         + "Node has depth 1, Value (p4, p4, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 7\n", a.dumpPoints());
        
 }
        
 
        
 /**
        
  * Test class for remove by points
        
  */
        
 public void testRemoveByPoints()
        
 {
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 1);
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 2);
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 3);
        
     assertEquals("Point inserted: (p2, 300, 15)\n",
        
         a.insertPoints("p2", 300, 15));
        
     assertEquals(a.getList().size(), 4);
        
     assertEquals("Point inserted: (p4, 700, 4)\n",
        
         a.insertPoints("p4", 700, 4));
        
     assertEquals(a.getList().size(), 5);
        
     assertEquals("Point inserted: (p5, 700, 4)\n",
        
         a.insertPoints("p5", 700, 4));
        
     assertEquals(a.getList().size(), 6);
        
     assertEquals("Point inserted: (pointy, 200, 900)\n",
        
         a.insertPoints("pointy", 200, 900));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad1, 1134, 12)\n",
        
         a.insertPoints("bad1", 1134, 12));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad2, 3, 3221)\n",
        
         a.insertPoints("bad2", 3, 3221));
        
     assertEquals(a.getList().size(), 7);
        
     assertEquals("Point rejected: (bad3, -3, 2)\n",
        
         a.insertPoints("bad3", -3, 2));
        
     assertEquals(a.getList().size(), 7);
        
     
        
     assertEquals(a.removeByPoint(1552, 2),
        
         "Point rejected: (1552, 2)\n");
        
     assertEquals(a.removeByPoint(8912, 8912),
        
         "Point rejected: (8912, 8912)\n");
        
     assertEquals(a.removeByPoint(8, 8),
        
         "Point not found: (8, 8)\n");
        
     assertEquals(a.removeByPoint(300, 15),
        
         "Point removed: (p2, 300, 15)\n");
        
     assertEquals(a.removeByPoint(300, 15),
        
         "Point not found: (300, 15)\n");
        
     
        
     PrintStreamWithHistory dump = systemOut();
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p4, p4, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 6\n", a.dumpPoints());
        
 }
        
 
        
 /**
        
  * Test class for remove by name
        
  */
        
 public void testRemoveByName() 
        
 {
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 1);
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 2);
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals(a.getList().size(), 3);
        
     assertEquals("Point inserted: (p2, 300, 15)\n",
        
         a.insertPoints("p2", 300, 15));
        
     assertEquals(a.getList().size(), 4);
        
     assertEquals("Point inserted: (p4, 700, 4)\n",
        
         a.insertPoints("p4", 700, 4));
        
     assertEquals(a.getList().size(), 5);
        
     assertEquals("Point inserted: (p5, 700, 4)\n",
        
         a.insertPoints("p5", 700, 4));
        
     assertEquals(a.getList().size(), 6);
        
     assertEquals("Point inserted: (pointy, 200, 900)\n",
        
         a.insertPoints("pointy", 200, 900));
        
     assertEquals(a.getList().size(), 7);
        
     
        
     assertEquals(a.removeByName("pOINTy"),
        
         "Point not removed: pOINTy\n");
        
     assertEquals(a.removeByName("asd"),
        
         "Point not removed: asd\n");
        
     assertEquals(a.removeByName("what?"),
        
         "Point not removed: what?\n");
        
     assertEquals(a.removeByName("p2"),
        
         "Point removed: (p2, 300, 15)\n");
        
     
        
     PrintStreamWithHistory dump = systemOut();
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p4, p4, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 6\n", a.dumpPoints());   
        
 }
        
 
        
 /**
        
  * Test class for search
        
  */
        
 public void testSearch()
        
 {
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals("Point inserted: (p1, 4, 4)\n",
        
         a.insertPoints("p1", 4, 4));
        
     assertEquals("Point not found: a\n", a.search("a"));
        
     assertEquals("Found (p1, 4, 4)\n"
        
         + "Found (p1, 4, 4)\n"
        
         + "Found (p1, 4, 4)\n", a.search("p1"));
        
     //assertEquals("", a.search("p2"));
        
     
        
 }
        
 
        
 }