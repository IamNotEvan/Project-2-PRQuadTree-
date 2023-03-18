
    
/**
    
This is PRQuadTree class
    
    
    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/
    

    
public class PRQuadTree {
    
 
    
 private TreeNode root;
    
 
    
 /**
    
  * Constructor for this class
    
  */
    
 public PRQuadTree()
    
 {
    
     root = new FlyweightNode();       
    
 }
    
 
    
 /**
    
  * Insert the point in the region
    
  * 
    
  * @param region
    
  *      region that point will be inserted
    
  * @param newPoint
    
  *      inserting point
    
  */
    
 public void insert(Region region, Point newPoint)
    
 {
    
     root = root.insert(region, newPoint);
    
        
    
 }
    
 
    
 /**
    
  * Dump the nodes and points in the quad tree
    
  * 
    
  * @param region
    
  *      the base region
    
  */
    
 public void dump(Region region) {
    
     
    
     System.out.print("QuadTree dump:\n");      
    
     int size = root.dump(0, region, 0);
    
     StringBuilder dump = new StringBuilder();
    
     dump.append(size +
    
         " quadtree nodes printed\n");
    
     String dumpStr = dump.toString();
    
     System.out.print(dumpStr);
    
 }
    
 
    
 /**
    
  * Remove point in the base region
    
  * 
    
  * @param region
    
  *      base region
    
  * @param point
    
  *      removing point
    
  */
    
 public void removeByPoint(Region region, Point point)
    
 {
    
     root = root.removeByPoint(region,
    
         point);
    
 }
    
 
    
 /**
    
  * Search point that has exact x y coord in base region
    
  * 
    
  * @param region
    
  *      base region
    
  * @param x
    
  *      x coord
    
  * @param y
    
  *      y coord
    
  * @return
    
  *      if they exist or not
    
  */
    
 public Point searchByCoord(Region region, int x, int y)
    
 {
    
     return root.searchByCoord(region, x, y);
    
 }
    
 
    
 /**
    
  * Find if there are any duplicates in tree
    
  */
    
 public void duplicates()
    
 {
    
     System.out.print("Duplicate points:\n");
    
     root.duplicates();
    
 }
    
 
    
 /**
    
  * Find all the points and intersecting
    
  *  region with given
    
  *      rectangle
    
  * @param region
    
  *      base region
    
  * @param x
    
  *      x coord for the rec
    
  * @param y
        
  *      y coord for the rec
        
  * @param w
        
  *      width for the rec
        
  * @param h
        
  *      height for the rec
        
  */
        
 public void regionSearch(Region region, int x,
        
     int y, int w, int h)
        
 {
        
     StringBuilder regionSearch = new StringBuilder("");
        
     boolean legit = true;
        
     if (w <= 0 || h <= 0)
        
     {
        
         legit = false;
        
     }
        
     if (!legit)
        
     {
        
         regionSearch.append("Rectangle rejected: (" + x +
        
             ", " + y + ", " + w + ", " + h + ")\n");
        
         String regionSearchStr = regionSearch.toString();
        
         System.out.print(regionSearchStr);
        
     }
        
     else
        
     {
        
         regionSearch.append("Points intersecting region ("
        
             + x + ", " + y + ", " + w + ", " + h + ")\n");
        
         String regionSearchStr = regionSearch.toString();
        
         System.out.print(regionSearchStr);
        
         int count = root.regionSearch(0, region, x, y, w, h);
        
         
        
         System.out.print(count);
        
         System.out.print(" quadtree nodes visited\n");
        
 
        
     }        
        
 }
        
 
        

        
 
        
 }