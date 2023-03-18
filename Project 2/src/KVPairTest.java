
import student.TestCase;
    
 
    
/**
    
    Test class for KVPair class
 
    @author Evan Lee (evan0110)
    
    @version 09.04.2022

*/
    
public class KVPairTest extends TestCase {
    
 private KVPair<?, ?> intPair;
    
 private KVPair<?, ?> pointPair;
    
 private Point point1;
    
 
    
 /**
    
  * Test setUp method
    
  */
    
 @SuppressWarnings({ "unchecked", "rawtypes" })
    
 public void setUp()
    
 {
    
     point1 = new Point("b", 1, 2);
    
     intPair = new KVPair(1, 3);
    
     pointPair = new KVPair(point1.getName(),
    
         point1);  
    
 }
    
 
    
 /**
    
  * Test get key and value
    
  */
    
 public void testKeyAndValue()
    
 {
    
     assertEquals(intPair.key(), 1);
    
     assertEquals(pointPair.key(), "b");
    
     assertEquals(intPair.value(), 3);
    
     assertEquals(pointPair.value(),
    
         point1);
    
 }
    
 
    
 /**
    
  * Test compareTo
    
  */
    
 @SuppressWarnings({ "rawtypes", "unchecked" })
    
 public void testCompareTo()
    
 {
    
     KVPair samplePair0 = new KVPair(1, 4);
    
     KVPair samplePair1 = new KVPair(2, 4);
    
     KVPair samplePair2 = new KVPair(0, 4);
    
     KVPair samplePair3 = new KVPair("a", point1);
    
     KVPair samplePair4 = new KVPair("b", point1);
    
     KVPair samplePair5 = new KVPair("c", point1);
    
     
    
     
    
     assertEquals(intPair.
    
         compareTo(samplePair1), -1);
    
     assertEquals(intPair.
    
         compareTo(samplePair0), 0);
    
     assertEquals(intPair.
    
         compareTo(samplePair2), 1);
    
     assertEquals(pointPair.
    
         compareTo(samplePair4), 0);
    
     assertEquals(pointPair.
    
         compareTo(samplePair3), 1);
    
     assertEquals(pointPair.
    
         compareTo(samplePair5), -1);
    
 }
    
 
    
 /**
    
  * Test to string
    
  */
    
 public void testToString()
    
 {
    
     assertEquals(intPair.toString(), "(1, 3");
    
     assertEquals(pointPair.toString(),
    
         "(b, b, 1, 2)");
    
 }
    
 }