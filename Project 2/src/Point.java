
/**
    
This class is for the Point objects
    

    
@author Evan Lee (evan0110)
    
@version 2022.09.01
    
  */
    

    
public class Point {
    
 
    
    private String name;
    
    private int xPoint;
    
    private int yPoint;
    
    private final int bOXSIZE = 1024;
    
 
    
 
    
 /**
    
  * New poinsts object
    
  * 
    
  * @param newName
    
  *      the name of the point
    
  * @param x
    
  *      the x coordinate of the point
    
  * @param y
    
  *      the y coordinate of the point
    
  */
    
 public Point(String newName, int x, int y)
    
 {
    
     this.name = newName;
    
     this.xPoint = x;
    
     this.yPoint = y;
    
 }
    
 
    
 /**
    
  * Return name
    
  * 
    
  * @return
    
  *      the name
    
  */
    
 public String getName()
    
 {
    
     return this.name;
    
 }
    
 
    
 /**
    
  * Set the name
    
  * 
    
  * @param newName
    
  *      the new name
    
  */
    
 public void setName(String newName)
    
 {
    
     this.name = newName;
    
 }
    
 
    
 /**
    
  * Get the x point
    
  * 
    
  * @return
    
  *      x point
    
  */
    
 public int getXPoints()
    
 {
    
     return this.xPoint;
    
 }
    
 
    
 /**
    
  * Set the x point
    
  * 
    
  * @param newX
    
  *      the new x point
    
  */
    
 public void setXPoints(int newX)
    
 {
    
     this.xPoint = newX;
    
 }
    
 
    
 /**
    
  * Get the y point
    
  * 
    
  * @return
    
  *      y point
    
  */
    
 public int getYPoints()
    
 {
    
     return this.yPoint;
    
 }
    
 
    
 /**
    
  * Set the new Y point
    
  * 
    
  * @param newY
    
  *      the new y point
    
  */
    
 public void setYPoints(int newY)
    
 {
    
     this.yPoint = newY;
    
 }
    
 
    
 
        
 /**
        
  * Create string for this point
        
  * 
        
  * @return
        
  *      the string value of the point
        
  */
        
 public String toString()
        
 {
        
     if (this.getName() == null)
        
     {
        
         String noPoint = "null"; 
        
         return noPoint;
        
     }
        
     StringBuilder format2 = new StringBuilder();
        
     format2.append(this.getName() + ", ");
        
     format2.append(this.getXPoints() + ", ");
        
     format2.append(this.getYPoints() + ")");
        
     
        
     String pointStr = format2.toString();
        
     return pointStr;
        
 }
        
 
        
 /**
        
  * Checks if point is in the box
        
  * 
        
  * @return
        
  *      if it is in the box or not
        
  */
        
 public boolean inTheBox()
        
 {
        
     return !(this.xPoint < 0 || this.yPoint < 0
        
         || this.xPoint >= 
        
         this.bOXSIZE || this.yPoint >= this.bOXSIZE);
        
 }
        
  
        
 
        
   /**
        
    * Checks if two points are equals
        
    * 
        
    * @param point
        
    *      comparing point
        
    * @return
        
    *      if they equal or not
        
    */
        
   public boolean equals(Point point)
        
   {
        
       return (this.getName() == point.getName()
        
           && this.getXPoints() == point.getXPoints()
        
           && this.getYPoints() == point.getYPoints());
        
   }
        
 
        
 /**
        
  * Check if two points have same coordinates
        
  * 
        
  * @param point
        
  *      the comparing point
        
  * @return
        
  *      if they have same X Y or not
        
  */
        
 public boolean sameXY(Point point)
        
 {
        
     return ((this.getXPoints() == point.getXPoints()) 
        
         && (this.getYPoints() == point.getYPoints()));
        
 }
        
 
        
 /**
        
  * Check is point is in the rec
        
  * 
        
  * @param x
        
  *      x coord for rec
        
  * @param y
        
  *      y coord for rec
        
  * @param w
        
  *      width for rec
        
  * @param h
        
  *      height for rec
        
  * @return
        
  *      if point is in or not
        
  */
        
 public boolean isInRec(int x, int y, int w, int h)
        
 {
        
     return (xPoint >= x && xPoint <= x + w 
        
         && yPoint >= y && yPoint <= y + h);
        
 }
        
 
        
 }