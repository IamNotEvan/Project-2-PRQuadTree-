
/**
    
    This is IntNode class where this node always has 4 children

    @author Evan Lee (evan0110)
    
    @version 09.30.2022
    
*/
    

    
public class IntNode implements TreeNode {
    
 
    
 private TreeNode[] children;
    
 /**
    
  * The empty fly node
    
  */
    
 static final TreeNode THE_FLY = new FlyweightNode();
    
 /**
    
  * The number of children
    
  */
    
 static final int NUM_CHILDREN = 4;
    

    
 
    
 /**
    
  * This is constructor for this class
    
  */
    
 public IntNode()
    
 {
    
     // for testing purpose
    
 }
    
 
    
 /**
    
  * This creates new internal node
    
  * 
    
  * @param region
    
  *      the region for this node
    
  * @param leaf
    
  *      the leaf node that will be turned to internal node
    
  */
    
 public IntNode(Region region, LeafNode leaf)
    
 {
    
     this.children = new TreeNode[NUM_CHILDREN];
    
     
    
     for (int i = 0; i < NUM_CHILDREN; i++)
    
     {
    
         this.children[i] = THE_FLY;
    
     }
    
     
    
     LinkedList points = leaf.getPointList();
    
     points.moveToStart();
    
     
    
     for (int i = 0; i < points.length(); i++)
    
     {
    
         Point newPoint = (Point)points.getValue();
    
         points.next();
    
         this.insert(region, newPoint);    
    
     }
    
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
    
     int pos = this.pickPos(region, newPoint);
    
     Region newRegion = this.newRegion(region, pos);
    
     children[pos] = children[pos].insert(newRegion, newPoint);
    
     return this;
    
 }
    
 
    
 /**
    
  * This create new region based on base region and position number
    
  * @param region
    
  *      the base region
    
  * @param pos
    
  *      the position number
    
  * @return
    
  *      the new region
    
  */
    
 public Region newRegion(Region region, int pos)
    
 {
    
     if (pos == 0)
    
     {
    
         Region nW = region.nW();
    
         return nW;
    
     }
    
     else if (pos == 1)
    
     {
    
         Region nE = region.nE();
    
         return nE;
    
         
        
     }
        
     else if (pos == 2)
        
     {
        
         Region sW = region.sW(); 
        
         return sW;
        
     }
        
     Region sE = region.sE();
        
     return sE;
        
 }
        
 
        
 /**
        
  * This find the position number with based region and the point
        
  * 
        
  * @param region
        
  *      base region
        
  * @param newPoint
        
  *      base point
        
  * @return
        
  *      position integer
        
  */
        
 public int pickPos(Region region, Point newPoint) {
        
     
        
     if (newPoint.getXPoints() >= region.getX() 
        
         && newPoint.getXPoints() < region.getX() + region.halfsize()
        
         && newPoint.getYPoints() >= region.getY()
        
         && newPoint.getYPoints() < region.getY() + region.halfsize())
        
     {
        
         return 0;
        
     }
        
     else if (newPoint.getXPoints() >= region.getX() + region.halfsize()
        
         && newPoint.getXPoints() < region.getX() + region.getSize() 
        
         && newPoint.getYPoints() >= region.getY()
        
         && newPoint.getYPoints() < region.getY() + region.halfsize())
        
     {
        
         return 1;
        
     }
        
     else if (newPoint.getXPoints() >= region.getX() &&
        
         newPoint.getXPoints() < region.getX() + region.halfsize() 
        
         && newPoint.getYPoints() >= region.getY() + region.halfsize()
        
         && newPoint.getYPoints() < region.getY() + region.getSize())
        
     {
        
         return 2;
        
     }
        
     
        
     return 3;
        
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
        
     dump.append(": Internal\n");
        
     size = size + 1;        
        
     String dumpStr = dump.toString();
        
     System.out.print(dumpStr);
        
     indent++;
        
     for (int i = 0; i < NUM_CHILDREN; i++)
        
     {
        
         
        
         Region newRegion = this.newRegion(region, i);   
        
         int y = this.children[i]
        
             .dump(size, newRegion, indent);
        
         size = y;
        
     }
        
 
        
     return size;
        
     
        
 }
        
 
        
 
        
 /**
        
  * Check if this node is leaf node
        
  * 
        
  * @return
        
  *      whether this node is leaf or not
        
  */
        
 @Override
        
 public boolean isLeaf() {
        
     
        
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
        
 public Point searchByCoord(Region region, int x, int y) {
        
     Point temp = new Point("sample", x, y);
        
     int pos = this.pickPos(region, temp);
        
     Region newRegion = this.newRegion(region, pos);
        
     Point point = this.children[pos]
        
         .searchByCoord(newRegion, x, y);
        
     return point;
        
 }
        
 
        
 /**
        
  * Check if this node is internal node
        
  * 
        
  * @return
        
  *      whether this node is internal or not
        
  */
        
 @Override
        
 public boolean isInt() {
        
     
        
     return true;
        
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
        
     LinkedList points = new LinkedList();
        
     int pos = this.pickPos(region, point);
        
     Region newRegion = this.newRegion(region, pos);
        
     TreeNode tempNode = this.children[pos]
        
         .removeByPoint(newRegion, point);
        
     this.children[pos] = tempNode;
        
     for (int i = 0; i < NUM_CHILDREN; i++)
        
     {
        
         if (this.children[i].isInt())
        
         {
        
             return this;
        
         }
        
         if (this.children[i].isLeaf())
        
         {
        
             LinkedList tempList = ((LeafNode)this
        
                 .children[i])
        
                 .getPointList();
        
             tempList.moveToStart();
        
             for (int j = 0; j < tempList.length(); j++)
        
             {
        
                 points.append(tempList.getValue());
        
                 tempList.next();
        
             }
        
         }  
        
     }
        
     if (points.length() <= 3 || points.allSame())
        
     {
        
         LeafNode leaf = new LeafNode(region);
        
         leaf.setPointList(points);
        
         return leaf;
        
     }
        
     return this;
        
 }
        
 
        
 /**
        
  * Find the points with same coordinates
        
  * 
        
  * @return
        
  *      if they exist or not
        
  */
        
 @Override
        
 public boolean duplicates() {
        
     
        
     boolean dup = false;
        
     for (int i = 0; i < NUM_CHILDREN; i++)
        
     {
        
         if (this.children[i].duplicates())
        
         {
        
             dup = true;
        
         }
        
         
        
     }
        
     return dup;
        
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
        
     for (int i = 0; i < NUM_CHILDREN; i++)
        
     {
        
         Region newRegion = this.newRegion(region, i);
        
         int count = this.children[i].regionSearch(size,
        
             newRegion, x, y, w, h);
        
         size = count;
        
     }
        
     
        
     return size;
        
 }
        
 
        
 }
