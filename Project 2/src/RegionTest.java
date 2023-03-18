    
/**
    
This is test class for region class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  */
    

    
public class RegionTest extends student.TestCase {
    
 
    
 private Region a;
    
 private Region b;
    
 
    
 /**
    
  * Set up method for this test class
    
  */
    
 public void setUp()
    
 {
    
     a = new Region();
    
     b = new Region(5, 5, 300);
    
 }
    
 
    
 /**
    
  * Test all get and set method
    
  */
    
 public void testGetAndSet()
    
 {
    
     assertEquals(a.getSize(), 1024);
    
     assertEquals(b.getSize(), 300);
    
     assertEquals(a.getX(), 0);
    
     assertEquals(b.getX(), 5);
    
     assertEquals(a.getY(), 0);
    
     assertEquals(b.getY(), 5);
    
     
    
     b.setSize(1024);
    
     assertEquals(b.getSize(), 1024);
    
     
    
     b.setX(0);
    
     assertEquals(b.getX(), 0);
    
     
    
     b.setY(0);
    
     assertEquals(b.getY(), 0);     
    
 }
    
 
    
 /**
    
  * Test half size
    
  */
    
 public void testHalfSize()
    
 {
    
     assertEquals(a.halfsize(), 512);
    
     assertEquals(b.halfsize(), 150);
    
 }
    
 
    
 /**
    
  * Test all children region class
    
  */
    
 public void testChildern()
    
 {
    
     Region nW = a.nW();
    
     assertEquals(nW.getSize(), 512);
    
     assertEquals(nW.getX(), 0);
    
     assertEquals(nW.getY(), 0);
    
     
    
     Region nE = a.nE();
    
     assertEquals(nE.getSize(), 512);
    
     assertEquals(nE.getX(), 512);
    
     assertEquals(nE.getY(), 0);
    
     
    
     Region sW = a.sW();
    
     assertEquals(sW.getSize(), 512);
    
     assertEquals(sW.getX(), 0);
    
     assertEquals(sW.getY(), 512);
    
     
    
     Region sE = a.sE();
    
     assertEquals(sE.getSize(), 512);
    
     assertEquals(sE.getX(), 512);
    
     assertEquals(sE.getY(), 512);
    
     
    
     Region nWnE = nW.nE();
    
     assertEquals(nWnE.getSize(), 256);
    
     assertEquals(nWnE.getX(), 256);
    
     assertEquals(nWnE.getY(), 0);
    
    
    
 }
    
 /**
    
  * Test all children region class
    
  */
    
 public void testChildern2()
    
 {
    
     a.setSize(2024);
    
     Region nW = a.nW();
    
     assertEquals(nW.getSize(), 1012);
    
     assertEquals(nW.getX(), 0);
    
     assertEquals(nW.getY(), 0);
    
     
    
     Region nE = a.nE();
    
     assertEquals(nE.getSize(), 1012);
    
     assertEquals(nE.getX(), 1012);
    
     assertEquals(nE.getY(), 0);
    
     
        
     Region sW = a.sW();
        
     assertEquals(sW.getSize(), 1012);
        
     assertEquals(sW.getX(), 0);
        
     assertEquals(sW.getY(), 1012);
        
     
        
     Region sE = a.sE();
        
     assertEquals(sE.getSize(), 1012);
        
     assertEquals(sE.getX(), 1012);
        
     assertEquals(sE.getY(), 1012);
        
     
        
     Region nWnE = nW.nE();
        
     assertEquals(nWnE.getSize(), 506);
        
     assertEquals(nWnE.getX(), 506);
        
     assertEquals(nWnE.getY(), 0);
        
    
        
 }
        
 
        
 /**
        
  * Test intersect
        
  */
        
 public void testIntersect()
        
 {
        
     assertTrue(a.intersect(0, 0, 5, 5));
        
     assertFalse(a.intersect(-10, -10, 5, 5));
        
     assertFalse(a.intersect(0, 3, 0, 3));
        
     assertFalse(a.intersect(2000, 3, 0, 3));
        
     assertFalse(a.intersect(3, 0, 3, 0));
        
     assertFalse(a.intersect(3, 2000, 3, 0));
        
     
        
     assertFalse(a.intersect(2000, 0, -2000, 0));
        
     assertFalse(a.intersect(5, 0, -5, 0));
        
     assertFalse(a.intersect(2000, 0, 2000, 0));
        
     
        
     assertFalse(a.intersect(0, 0, -5, 0));
        
     assertFalse(a.intersect(0, 2000, -5, -2000));
        
     assertFalse(a.intersect(0, 2000, -5, 1000));
        
     
        
     
        
     
        
     
        
 }
        
 
        
 
        
 }