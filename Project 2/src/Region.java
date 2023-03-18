
    
/**
    
This is region class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    

    
  */
    

    
public class Region {
    
 
    
 private int x;
    
 private int y;
    
 private int size;
    
 /**
    
  * This is the start x point
    
  */
    
 static final int START_X = 0;
    
 /**
    
  * This is the start y point
    
  */
    
 static final int START_Y = 0;
    
 /**
    
  * This is the size
    
  */
    
 static final int START_SIZE = 1024;
    
 
    
 /**
    
  * This is constructor for world region
    
  */
    
 public Region()
    
 {
    
     this.setX(START_X);
    
     this.setY(START_Y);
    
     this.setSize(START_SIZE);  
    
 }
    
 
    
 /**
    
  * This is constructor for specific region
    
  * 
    
  * @param x1
    
  *      x coord
    
  * @param y1
    
  *      y coord    
    
  * @param size1
    
  *      size
    
  */
    
 public Region(int x1, int y1, int size1)
    
 {
    
     this.x = x1;
    
     this.y = y1;
    
     this.size = size1;
    
 }
    
 
    
 
    
 /**
    
  * Get x coord
    
  * 
    
  * @return
    
  *      x coord
    
  */
    
 public int getX() {
    
     return x;
    
 }
    
 
    
 /**
    
  * set x coord
    
  * 
    
  * @param x
    
  *      new x point
    
  */
    
 public void setX(int x) {
    
     this.x = x;
    
 }
    
 
    
 /**
    
  * Get y coord
    
  * 
    
  * @return
    
  *      y coord
    
  */
    
 public int getY() {
    
     return y;
    
 }
    
 
    
 /**
    
  * Set y coord
    
  * 
    
  * @param y
    
  *      new y coord
    
  */
    
 public void setY(int y) {
    
     this.y = y;
    
 }
    
 
    
 /**
    
  * Get size
    
  * 
    
  * @return
    
  *      size
        
  */
        
 public int getSize() {
        
     return size;
        
 }
        
 
        
 /**
        
  * Set size
        
  * 
        
  * @param size
        
  *      new size
        
  */
        
 public void setSize(int size) {
        
     this.size = size;
        
 }
        
 
        
 /**
        
  * Create nW region
        
  * 
        
  * @return
        
  *      nW region
        
  */
        
 public Region nW()
        
 {
        
     Region nW = new Region(this.getX(),
        
         this.getY(), this.halfsize());
        
     return nW;
        
 }
        
 
        
 /**
        
  * Create nE region
        
  * 
        
  * @return
        
  *      nE region
        
  */
        
 public Region nE()
        
 {
        
     Region nE = new Region(this.getX()
        
             + this.halfsize(),
        
         this.getY(), this.halfsize());
        
     return nE;
        
 }
        
 
        
 /**
        
  * Create sW region
        
  * 
        
  * @return
        
  *      sW region
        
  */
        
 public Region sW()
        
 {
        
     Region sW = new Region(this.getX(),
        
         this.getY() + this.halfsize(),
        
         this.halfsize());
        
     return sW;
        
 }
        
 
        
 /**
        
  * Create sE region
        
  * 
        
  * @return
        
  *      sE region
        
  */
        
 public Region sE()
        
 {
        
     Region sE = new Region(this.getX()
        
         + this.halfsize(),
        
         this.getY() + this.halfsize(),
        
         this.halfsize());
        
     return sE;
        
 }
        
 
        
 /**
        
  * Half the size
        
  * 
        
  * @return
        
  *      half size
        
  */
        
 public int halfsize()
        
 {
        
     return (this.size / 2);
        
 }
        
 
        
 /**
        
  * Create string for this region
        
  * 
        
  * @return
        
  *      string value
        
  */
        
 public String toString()
        
 {
        
     StringBuilder str = new StringBuilder();
        
     str.append(this.getX() + ", ");
        
     str.append(this.getY() + ", ");
        
     str.append(this.getSize());
        
     String str1 = str.toString();
        
     return str1;
        
 }
        
 
        
 /**
        
  * Find if region and rec are intersecting 
        
  * 
        
  * @param x1
        
  *      x point for rec
        
  * @param y1
        
  *      y point for rec
        
  * @param w1
        
  *      width for rec
        
  * @param h1
        
  *      height for rec
        
  * @return
        
  *      if they intersect or not
        
  */
        
 public boolean intersect(int x1, int y1, int w1, int h1)
        
 {
        
     return !(x >= (x1 + w1) || x1 >= x + size)
        
         && !(y1 + h1 <= y || y + size <= y1) ;
        
 }
        
 
        
 
        
 
        
 }