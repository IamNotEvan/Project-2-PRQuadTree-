/**
    
    This is FlyweightNode class where this represent every
    
    node in quadtree with empty node
    

    
    @author Evan Lee (evan0110)
    
    @version 09.30.2022
    
  */
    

    
public class FlyweightNode implements TreeNode {
    
 
    
 /**
    
  * Constructor for this class
    
  */
    
 public FlyweightNode()      
    
 {
    
     
    
 }
    
 
    
 /**
    
  * Insert the point
    
  * 
    
  * @param region
    
  *      the region for this node
    
  *     
    
  * @param newPoint
    
  *      the inserting point
    
  *      
    
  * @return
    
  *      the current Node
    
  *      
    
  */
    
 @Override
    
 public TreeNode insert(Region region, Point newPoint) {
    
     
    
     LeafNode newLeaf = new LeafNode(region, newPoint);
    
     return newLeaf;
    
 }
    
 
    
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
    
 @Override
    
 public int dump(int size, Region region, int indent) {
    
     StringBuilder dump = new StringBuilder("");
    
     for (int i = 0; i < indent; i++)
    
     {
    
         dump.append("  ");
    
     }
    
     dump.append("Node at ");
    
     dump.append(region.toString());
    
     dump.append(": Empty\n"); 
    
     String dumpStr = dump.toString();
    
     size++;
    
     System.out.print(dumpStr);
    
     return size;
    
 }
    
 
    
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
    
 @Override
    
 public TreeNode removeByPoint(Region region, Point point) {
    
     
    
     return this;
    
 }
    
 
    
 /**
    
  * Check if this node is leaf node
    
  * 
    
  * @return
    
  *      whether this node is leaf or not
    
  */
    
 @Override
    
 public boolean isLeaf()
    
 {
    
     return false;
    
 }
    
 
    
 /**
    
  * Check if this node is internal node
        
  * 
        
  * @return
        
  *      whether this node is internal or not
        
  */
        
 @Override
        
 public boolean isInt() {
        
     
        
     return false;
        
 }
        
 
        
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
        
 @Override
        
 public Point searchByCoord(Region region, int x, int y) 
        
 {
        
     
        
     return null;
        
 }
        
 
        
 /**
        
  * Find the points with same coordinates
        
  * 
        
  * @return
        
  *      if they exist or not
        
  */
        
 @Override
        
 public boolean duplicates() {
        
     
        
     return false;
        
 }
        
 
        
 /**
        
  * Find the points in the given rectangle
        
  * 
        
  * @param size
        
  *      number of points in the rectangle
        
  * @param region
        
  *      the region for this node
        
  * @param x
        
  *      the x coord for the rectangle
        
  * @param y
        
  *      the y coord for the rectangle
        
  * @param w
        
  *      the width for the rectangle
        
  * @param h
        
  *      the height for the rectangle 
        
  * 
        
  */
        
 @Override
        
 public int regionSearch(int size, Region region,
        
     int x, int y, int w, int h)
        
 {
        
     
        
     if (region.intersect(x, y, w, h))
        
     {
        
         size++;
        
     }
        
     return size;
        
 }
        
 
        
 }