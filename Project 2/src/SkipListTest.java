    
/**
    
Test class for Skip list class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class SkipListTest extends student.TestCase {
    
 
    
 private SkipList<String, Point> a;
    
 private KVPair<String, Point> pair;
    
 private Point point;
    
 
    
 /**
    
  * Set up method for test class
    
  */
    
 public void setUp()
    
 {
    
     a = new SkipList<String, Point>();
    
     point = new Point("a", 1, 1);
    
     pair = new KVPair<String, Point>(point.getName(), point);
    
     student.TestableRandom.setNextBooleans(new boolean[] {true, false,
    
         true, true, false, true, false, true, false, true, false,
    
         true, false, true, true, false, true, false, true, false,
    
         true, false, true, false, true, false, true, false, true,
    
         false, true, false, true, false, true, false, true, false,
    
         true, false});
    
 }
    
 
    
 /** 
    
  * Test size
    
  */
    
 public void testSize()
    
 {
    
     assertEquals(a.size(), 0);
    
 }
    
 
    
 /**
    
  *  Test insert
    
  */
    
 public void testInsert()
    
 {
    
     a.insert(pair);
    
     assertEquals(a.size(), 1);
    
     a.insert(pair);
    
     assertEquals(a.size(), 2);
    
     Point point1 = new Point("b", 3, 5);
    
     KVPair<String, Point> pair1 =
    
         new KVPair<String, Point>(point1.getName(), point1);
    
     a.insert(pair1);
    
     assertEquals(a.size(), 3);
    
     a.insert(pair1);
    
     assertEquals(a.size(), 4);  
    
 }
    
 
    
 /**
    
  * Test remove
    
  */
    
 public void testRemove()
    
 {
    
     Point point1 = new Point("b", 3, 5);
    
     KVPair<String, Point> pair1 =
    
         new KVPair<String, Point>(point1.getName(), point1);
    
     assertNull(a.remove("c"));
    
     a.insert(pair);
    
     a.insert(pair1);
    
     assertEquals(a.size(), 2);
    
     assertEquals(a.remove(pair.key()), pair);
    
     assertEquals(a.size(), 1);
    
     assertEquals(a.remove(pair1.key()), pair1);
    
     assertEquals(a.size(), 0);
    
  
    
 }
    
 
    
 /**
    
  * Test dump
    
  */
    
 public void testDump()
    
 {
    
     Point point1 = new Point("b", 3, 5);
    
     KVPair<String, Point> pair1 =
    
         new KVPair<String, Point>(point1.getName(), point1);
    
     assertEquals(a.dump(), "SkipList dump:\n"
    
         + "Node has depth 1, Value (null)\n"
    
         + "SkipList size is: 0\n");
    
     a.insert(pair);
    
     a.insert(pair1);
    
     assertEquals(a.dump(), "SkipList dump:\n"
    
         + "Node has depth 2, Value (null)\n"
    
         + "Node has depth 1, Value (a, a, 1, 1)\n"
    
         + "Node has depth 2, Value (b, b, 3, 5)\n"
    
         + "SkipList size is: 2\n");
    
 }
    
 
    
 /**
    
  * Test search
    
  */
    
 public void testSearch()
    
 {
        
     Point point1 = new Point("b", 3, 5);
        
     KVPair<String, Point> pair1 =
        
         new KVPair<String, Point>(point1.getName(), point1);
        
     
        
     Point point2 = new Point("d", 3, 5);
        
     KVPair<String, Point> pair2 =
        
         new KVPair<String, Point>(point2.getName(), point2);
        
     assertNull(a.search(pair1.key()));
        
     a.insert(pair);
        
     a.insert(pair);
        
     a.insert(pair1);
        
     assertEquals(a.search(pair.key()), pair);
        
     assertEquals(a.search(pair1.key()), pair1);
        
     assertNull(a.search(pair2.key()));
        
 }
        
 
        
 /**
        
  * Test special cases
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public void testFR()
        
 {
        
     SkipList.SkipIterator it = a.iterator1();
        
     assertFalse(it.hasNext());
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p2 = new Point("p2", 300, 15);
        
     Point p4 = new Point("p4", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     Point pointy = new Point("pointy", 200, 900);
        
     
        
     KVPair p1Pair = new KVPair(p1.getName(), p1);
        
     KVPair p2Pair = new KVPair(p2.getName(), p2);
        
     KVPair p4Pair = new KVPair(p4.getName(), p4);
        
     KVPair p5Pair = new KVPair(p5.getName(), p5);
        
     KVPair pointyPair = new KVPair(pointy.getName(), pointy);
        
     
        
     a.insert(p1Pair);
        
     a.insert(p1Pair);
        
     a.insert(p1Pair);
        
     a.insert(p2Pair);
        
     a.insert(p4Pair);
        
     a.insert(p5Pair);
        
     a.insert(pointyPair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p2, p2, 300, 15)\n"
        
         + "Node has depth 1, Value (p4, p4, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 7\n", a.dump());
        
     
        
     a.remove("p2");
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p4, p4, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 6\n", a.dump());
        
 }
        
 
        
 /**
        
  * Test remove by value
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public void testRemoveByValue()
        
 {
        
     Point p1 = new Point("p1", 4, 4);
        
     Point p2 = new Point("p2", 300, 15);
        
     Point p4 = new Point("p2", 700, 4);
        
     Point p5 = new Point("p5", 700, 4);
        
     Point pointy = new Point("pointy", 200, 900);
        
     
        
     KVPair p1Pair = new KVPair(p1.getName(), p1);
        
     KVPair p2Pair = new KVPair(p2.getName(), p2);
        
     KVPair p4Pair = new KVPair(p4.getName(), p4);
        
     KVPair p5Pair = new KVPair(p5.getName(), p5);
        
     KVPair pointyPair = 
        
         new KVPair(pointy.getName(), pointy);
        
     
        
     a.insert(p1Pair);
        
     a.insert(p1Pair);
        
     a.insert(p1Pair);
        
     a.insert(p2Pair);
        
     a.insert(p4Pair);
        
     a.insert(p5Pair);
        
     a.insert(pointyPair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p2, p2, 700, 4)\n"
        
         + "Node has depth 1, Value (p2, p2, 300, 15)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 7\n", a.dump());
        
     
        
     assertEquals(a.removeByValue(p2Pair), p2Pair);
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p2, p2, 700, 4)\n"
        
         + "Node has depth 1, Value (p5, p5, 700, 4)\n"
        
         + "Node has depth 2, Value (pointy, pointy, 200, 900)\n"
        
         + "SkipList size is: 6\n", a.dump());  
        
 }
        
 
        
 /**
        
  * Test complex remove
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public void testComplexRemoveByValue()
        
 {
        
     Point a1 = new Point("p1", 1, 1);
        
     Point a2 = new Point("p1", 2, 2);
        
     Point a3 = new Point("p1", 3, 3);
        
     Point a4 = new Point("p1", 4, 4);
        
     Point a5 = new Point("p1", 5, 5);
        
     
        
     KVPair a1Pair = new KVPair(a1.getName(), a1);
        
     KVPair a2Pair = new KVPair(a2.getName(), a2);
        
     KVPair a3Pair = new KVPair(a3.getName(), a3);
        
     KVPair a4Pair = new KVPair(a4.getName(), a4);
        
     KVPair a5Pair = new KVPair(a5.getName(), a5);
        
     
        
    // assertNull(a.removeByValue(a3Pair));
        
     a.insert(a5Pair);
        
     a.insert(a4Pair);
        
     a.insert(a3Pair);
        
     a.insert(a2Pair);
        
     a.insert(a1Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 1, 1)\n"
        
         + "Node has depth 1, Value (p1, p1, 2, 2)\n"
        
         + "Node has depth 1, Value (p1, p1, 3, 3)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 5, 5)\n"
        
         + "SkipList size is: 5\n", a.dump());
        
     
        
     assertEquals(a.removeByValue(a3Pair), a3Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 2, Value (p1, p1, 2, 2)\n"
        
         + "Node has depth 1, Value (p1, p1, 1, 1)\n"
        
         + "Node has depth 2, Value (p1, p1, 4, 4)\n"
        
         + "Node has depth 1, Value (p1, p1, 5, 5)\n"
        
         + "SkipList size is: 4\n", a.dump());
        
 }
        
 
        
 /**
        
  * Test complex remove
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public void testComplexRemove()
        
 {
        
     Point a1 = new Point("p1", 1, 1);
        
     Point a2 = new Point("p2", 1, 1);
        
     Point a3 = new Point("p3", 1, 1);
        
     Point a4 = new Point("p4", 1, 1);
        
     Point a5 = new Point("p5", 1, 1);
        
     
        
     KVPair a1Pair = new KVPair(a1.getName(), a1);
        
     KVPair a2Pair = new KVPair(a2.getName(), a2);
        
     KVPair a3Pair = new KVPair(a3.getName(), a3);
        
     KVPair a4Pair = new KVPair(a4.getName(), a4);
        
     KVPair a5Pair = new KVPair(a5.getName(), a5);
        
     
        
     a.insert(a5Pair);
        
     a.insert(a4Pair);
        
     a.insert(a3Pair);
        
     a.insert(a2Pair);
        
     a.insert(a1Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 1, 1)\n"
        
         + "Node has depth 1, Value (p2, p2, 1, 1)\n"
        
         + "Node has depth 1, Value (p3, p3, 1, 1)\n"
        
         + "Node has depth 2, Value (p4, p4, 1, 1)\n"
        
         + "Node has depth 1, Value (p5, p5, 1, 1)\n"
        
         + "SkipList size is: 5\n", a.dump());
        
     
        
     assertEquals(a.removeByValue(a3Pair), a3Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p1, p1, 1, 1)\n"
        
         + "Node has depth 1, Value (p2, p2, 1, 1)\n"
        
         + "Node has depth 2, Value (p4, p4, 1, 1)\n"
        
         + "Node has depth 1, Value (p5, p5, 1, 1)\n"
        
         + "SkipList size is: 4\n", a.dump());
        
 }
        
 
        
 /**
        
  * Test webcat error
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public void testWebCatRemove()
        
 {
        
     Point a1 = new Point("p1", 1, 1);
        
     Point a2 = new Point("p2", 3, 3);
        
     
        
     KVPair a1Pair = new KVPair(a1.getName(), a1);
        
     KVPair a2Pair = new KVPair(a2.getName(), a2);
        
     
        
     a.insert(a2Pair);
        
     a.insert(a1Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 2, Value (p1, p1, 1, 1)\n"
        
         + "Node has depth 1, Value (p2, p2, 3, 3)\n"
        
         + "SkipList size is: 2\n", a.dump());
        
     
        
     assertEquals(a.remove(a1.getName()), a1Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 2, Value (null)\n"
        
         + "Node has depth 1, Value (p2, p2, 3, 3)\n"
        
         + "SkipList size is: 1\n", a.dump());
        
   
        
     assertEquals(a.remove(a2.getName()), a2Pair);
        
     
        
     assertEquals("SkipList dump:\n"
        
         + "Node has depth 1, Value (null)\n"
        
         + "SkipList size is: 0\n", a.dump());
        
     
        
     
        
     
        
 }
        
 }