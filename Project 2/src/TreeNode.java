

/**    
    This is Tree Node interface

    @author Evan Lee (evan0110)
    
    @version 09.30.2022
    
*/
    

    
public interface TreeNode {
    
 
    
 /**
    
  * Insert the point
    
  * 
    
  * @param region
    
  *      the region for this node
    
  *     
    
  * @param newPoints
    
  *      the inserting point
    
  *      
    
  * @return
    
  *      the current Node
    
  *      
    
  */
    
 public TreeNode insert(Region region, Point newPoints);
    
 
    
 /**
    
  * Dump the points in current Node
    
  * 
    
  * @param size
    
  *      number of points in this node
    
  *      
    
  * @param region
    
  *      the region for this node
    
  * 
    
  * @param indent
    
  *      the depth of this node in tree
    
  *      
    
  * @return
    
  *      the number of nodes
    
  */
    
 public int dump(int size, Region region, int indent);
    
 
    
 /**
    
  * Search the point with that coordinate
    
  * 
    
  * @param region
    
  *      region for this node
    
  * @param x
    
  *      the x coord for the point
    
  * @param y
    
  *      the y coord for the point
    
  * @return 
    
  *      the point with exact coordinates
    
  */
    
 public Point searchByCoord(Region region, int x, int y);
    
 
    
 /**
    
  * Remove the point in the node by point
    
  * 
    
  * @param region
    
  *      region for this node
    
  * @param point
    
  *      the removing point
    
  * @return
    
  *      the current node
    
  */
    
 public TreeNode removeByPoint(Region region, Point point);
    
 
    
 /**
    
  * Find the points with same coordinates
    
  * 
    
  * @return
    
  *      if they exist or not
    
  */
    
 public boolean duplicates();
    
 
    
 /**
    
  * Search the point with that coordinate
    
  * 
    
  * @param size
    
  *      number of dups
    
  * @param region
    
  *      region for this node
    
  * @param x
    
  *      the x coord for the point
    
  * @param y
    
  *      the y coord for the point
    
  * @param w 
    
  *      width of rec
    
  * @param h
    
  *      height of rec
    
  * @return 
    
  *      the point with exact coordinates
    
  */
    
 public int regionSearch(int size, Region region,
    
     int x, int y, int w, int h);
    
 
    
 /**
    
  * Check if this node is leaf node
    
  * 
        
  * @return
        
  *      whether this node is leaf or not
        
  */
        
 public boolean isLeaf();
        
 
        
 /**
        
  * Check if this node is internal node
        
  * 
        
  * @return
        
  *      whether this node is internal or not
        
  */
        
 public boolean isInt();
        
 
        
 
        
 }
