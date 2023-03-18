/**
    
This is LeafNode class which is the node with points in it
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/
    

    
public class LeafNode implements TreeNode {
    
 
    
 private LinkedList pointList;
    
 //private Link singlePoint;
    
 
    
 /**
    
  * This is constructor
    
  * 
    
  * @param region
    
  *      the region for this node
    
  * @param point
    
  *      the point that will be inserted
    
  */
    
 public LeafNode(Region region, Point point)
    
 {
    
     pointList = new LinkedList();
    
     pointList.append(point);
    
 }
    
 
    
 /**
    
  * This is constructor
    
  * 
    
  * @param region
    
  *      the region for this node
    
  */
    
 public LeafNode(Region region)
    
 {
    
     pointList = new LinkedList();
    
 }
    
 
    
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
    
 @Override
    
 public TreeNode insert(Region region, Point newPoints) {
    
     
    
     if (decomposition(newPoints))
    
     {
    
         pointList.append(newPoints);
    
         IntNode iNode = new IntNode(region, this);
    
         return iNode;   
    
     }
    
     else
    
     {
    
         pointList.append(newPoints);
    
         return this; 
    
     }
    
     
    
 }
    
 
    
 /**
    
  * Return the pointList
    
  * 
    
  * @return
    
  *      the pointList
    
  */
    
 public LinkedList getPointList()
    
 {
    
     return this.pointList;
    
 }
    
 
    
 /**
    
  * Set the pointList
    
  * 
    
  * @param points
    
  *      the linkedlist of points that will be inserted
    
  */
    
 public void setPointList(LinkedList points)
    
 {
    
     this.pointList = points;
    
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
        
     dump.append(region.toString() + ":\n");
        
     pointList.moveToStart();
        
     
        
     for (int i = 0; i < pointList.length(); i++)
        
     {
        
         for (int g = 0; g < indent; g++)
        
         {
        
             dump.append("  ");
        
         }
        
             
        
         Point newPoint = (Point)pointList.getValue();
        
         dump.append("(" + newPoint.toString() + "\n");
        
         pointList.next();
        
          
        
     }
        
     size = size + 1;
        
 
        
 
        
     String dumpStr = dump.toString();
        
     System.out.print(dumpStr);
        
     return size;       
        
 }
        
 
        
 /**
        
  * This checks if this node need to split or not after inserting
        
  * this point
        
  *  
        
  * @param point
        
  *      the inserting point
        
  * @return
        
  *      needs to be split or not
        
  */
        
 public boolean decomposition(Point point)
        
 { 
        
     boolean diffPoints = false;
        
     if (pointList.length() < 3)
        
     {
        
         return false;
        
     }
        
     pointList.moveToStart();
        
     for (int i = 1; i <= pointList.length(); i++)
        
     {
        
         
        
         Point aPoint = (Point)pointList.getValue();
        
         int tempX = aPoint.getXPoints();
        
         int tempY = aPoint.getYPoints();
        
         if (point.getXPoints() != tempX 
        
             || point.getYPoints() != tempY)
        
         {
        
             diffPoints = true;
        
         }
        
         pointList.next();
        
         // Checks point to pointList.next()
        
         // If not equal, set diffPoints to true
        
     }
        
     
        
     return diffPoints;
        
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
        
 public Point searchByCoord(Region region, int x, int y) {
        
     
        
     pointList.moveToStart();
        
     for (int i = 0; i < pointList.length(); i++)
        
     {
        
         Point aPoint = (Point)pointList.getValue();
        
         if (aPoint.getXPoints() == x 
        
             && aPoint.getYPoints() == y)
        
         {
        
             return aPoint;  
        
         }
        
         pointList.next();     
        
     }
        
     
        
     return null;
        
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
        
     
        
     pointList.moveToStart();
        
     for (int i = 0; i < pointList.length(); i++)
        
     {
        
         Point aPoint = (Point)pointList.getValue();
        
         if (aPoint.equals(point))
        
         {
        
             pointList.remove();
        
             if (pointList.length() == 0)
        
             {
        
                 return new FlyweightNode();
        
             }
        
             return this;
        
         }
        
         pointList.next(); 
        
     }
        
     return this;
        
 }
        
 
        
 /**
        
  * Check if this node is leaf node
        
  * 
        
  * @return
        
  *      whether this node is leaf or not
        
  */
        
 @Override
        
 public boolean isLeaf() {
        
     
        
     return true;
        
 }
        
 
        
 /**
        
  * Find the points with same coordinates
        
  * 
        
  * @return
        
  *      if they exist or not
        
  */
        
 @Override
        
 public boolean duplicates() {
        
     
        
     if (pointList.length() > 1)
        
     {
        
         StringBuilder duplicates = new StringBuilder("");
        
         if (pointList.length() > 3)
        
         {
        
             pointList.moveToStart();
        
             Point point = (Point)pointList.getValue();
        
             duplicates.append("(" + point.getXPoints() + ", " 
        
                 + point.getYPoints() + ")\n");
        
             String duplicatesStr = duplicates.toString();
        
             System.out.print(duplicatesStr);
        
             return true;
        
         }
        
         else if (pointList.length() == 2)
        
         {
        
             pointList.moveToStart();
        
             Point point = (Point)pointList.getValue();
        
             
        
             pointList.next();
        
             Point point2 = (Point)pointList.getValue();
        
             if (point.sameXY(point2))
        
             {
        
                 duplicates.append("(" + point.getXPoints() + ", "
        
                     + point.getYPoints() + ")\n");
        
                 String duplicatesStr = duplicates.toString();
        
                 System.out.print(duplicatesStr);
        
                 return true;
        
             }   
        
         }
        
         else if (pointList.length() == 3)
        
         {
        
             pointList.moveToStart();
        
             Point point1 = (Point)pointList.getValue();
        
             
        
             pointList.next();
        
             Point point2 = (Point)pointList.getValue();
        
             
        
             pointList.next();
        
             Point point3 = (Point)pointList.getValue();
        
             
        
             if (point1.sameXY(point2))
        
             {
        
                 duplicates.append("(" + point1.getXPoints() + ", "
        
                     + point1.getYPoints() + ")\n");
        
                 String duplicatesStr = duplicates.toString();
        
                 System.out.print(duplicatesStr);
        
                 return true;
        
             }
        
             else if (point1.sameXY(point3))
        
             {
        
                 duplicates.append("(" + point1.getXPoints() + ", "
        
                     + point1.getYPoints() + ")\n");
        
                 String duplicatesStr = duplicates.toString();
        
                 System.out.print(duplicatesStr);
        
                 return true;
        
             }
        
             else if (point2.sameXY(point3))
        
             {
        
                 duplicates.append("(" + point2.getXPoints() + ", "
        
                     + point2.getYPoints() + ")\n");
        
                 String duplicatesStr = duplicates.toString();
        
                 System.out.print(duplicatesStr);
        
                 return true;
        
             } 
        
         } 
        
     }
        
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
        
 public int regionSearch(int size, Region region, int x,
        
     int y, int w, int h) {
        
     
        
     StringBuilder regionSearch = new StringBuilder();
        
     if (region.intersect(x, y, w, h))
        
     {
        
         size++;
        
         pointList.moveToStart();
        
         for (int i = 0; i < pointList.length(); i++)
        
         {
        
             Point point = (Point)pointList.getValue();
        
             if (point.isInRec(x, y, w, h))
        
             {
        
                 regionSearch.append("Point found: (");
        
                 regionSearch.append(point.toString() + "\n");
        
                 
        
             }         
        
             pointList.next();
        
         }
        
         String regionSearchStr = regionSearch.toString();
        
         System.out.print(regionSearchStr);
        
     }
        
     
        
     return size;
        
 }
     
}