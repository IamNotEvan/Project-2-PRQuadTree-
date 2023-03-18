import java.io.File;
    
import java.io.FileNotFoundException;
       
import java.util.Scanner;
      
 /**     
  * This is a DataBase class with Quadtree and skiplist implemented     
  * 
       
  * @author Evan Lee (evan0110)
       
  * @version 09.30.2022
      
  *
    
  */
    
 public class DataBase {
  
     

     private String fileName; 
  
     @SuppressWarnings("rawtypes")
  
     private SkipList pointList;
     private PRQuadTree pointTree;
     private Region world;
  
     //private static final int BOXLENG = 1024;

 
     
     /**
    
      * This is constructor
   
      * 
      
      * @param inputFile
      
      *      the name of the file
      
      */
      
     @SuppressWarnings("rawtypes")
      
     public DataBase(String inputFile)
      
     {
    
         this.fileName = inputFile;
    
         pointList = new SkipList();
    
         pointTree = new PRQuadTree();
   
         world = new Region();
 
     }

     
 
     /**
      * This is also a constructor without a filename input     
      */ 
     @SuppressWarnings("rawtypes")
  
     public DataBase()  
     {    
         pointList = new SkipList();   
         pointTree = new PRQuadTree(); 
         world = new Region();   
     }
  
  
     /** 
      * This return the skiplist 
      *     
      * @return
      *      the skiplist
      */
    
     @SuppressWarnings("rawtypes")
   
     public SkipList getList()
     
     {
   
         return this.pointList;
     }
     
     /**
      
      * This return the quadtree
      
      * 
      
      * @return
      
      *      the quadTree
      
      */
      
     public PRQuadTree getTree()
      
     {
      
         return this.pointTree;
     
     }
     
 
      
 
      
     /**
      
      * This read text file and create output
      
      * 
      
      * @throws FileNotFoundException
      
      *      throws exception when the file name is not found
      
      */
      
     public void doCommand() throws FileNotFoundException
      
     {
      
         
      
         Scanner file = new Scanner(new File(fileName));
      
         String command = "";
      
         String pointName = "";
    
         int pointX = 0;
    
         int pointY = 0;
    
         int width = 0;
   
         int height = 0;
  
         //StringBuilder outPut = new StringBuilder();
   
         
   
         while (file.hasNextLine())
    
         {
    
             if (!file.hasNext())
    
             {
    
                 break;
  
             }
 
             command = file.next();
 
             switch(command) 
     
             {
     
                 case "insert":
   
                     pointName = file.next();
 
                     pointX = Integer.parseInt(file.next());
       
                     pointY = Integer.parseInt(file.next());       
                     String outPutInsert =
        
                         this.insertPoints(pointName, pointX, pointY);
     
                     System.out.print(outPutInsert);
       
                     //outPut.append(outPutInsert);
     
                     break;
     
      
                     
       
                 case "dump":
       
      
                     String outPutDump = dumpPoints();
    
                     System.out.print(outPutDump);
    
                     //outPut.append(outPutDump);
      
                     pointTree.dump(world);
      
                     break;
       
                     
     
                 case "remove":
     
                     if (file.hasNextInt())
    
                     {
      
                         pointX = Integer.parseInt(file.next());
      
                         pointY = Integer.parseInt(file.next());
       
                         String outPutRemovePoint =
         
                             this.removeByPoint(pointX, pointY);
         
                         System.out.print(outPutRemovePoint);
         
                         break;
         
                     }
         
                     else
         
                     {
         
                         pointName = file.next();
         
                         String outPutRemoveName =
         
                             this.removeByName(pointName);
         
                         System.out.print(outPutRemoveName);
         
                         break;
         
                     }
         
 
         
                     
         
                 case "duplicates":
         
                     
         
                     pointTree.duplicates();
         
                     break;
         
                     
         
                 case "regionsearch":
         
                     
         
                     pointX = Integer.parseInt(file.next());
         
                     pointY = Integer.parseInt(file.next());
         
                     width = Integer.parseInt(file.next());
         
                     height = Integer.parseInt(file.next());
         
                     pointTree.regionSearch(world,
         
                         pointX, pointY, width, height);
        
                     break;
       
                     
                 case "search":
         
                     
         
                     pointName = file.next();
         
                     String outPutSearch = this.search(pointName);
         
                     System.out.print(outPutSearch);
         
                     break;      
         
                 
         
             }
         
             if (file.hasNextLine())
         
             {
         
                 file.nextLine();
         
             }  
         
             
         
         }
         
         
         
     
         
     }
         
     
         
     
         
     
         
     /**
         
      * This insert point in skiplist and quadtree
         
      * 
         
      * @param newName
         
      *      name of the point
         
      * @param newX
         
      *      x coord of the point
         
      * @param newY
         
      *      y coord of the point
         
      * @return
         
      *      the string value
         
      */
         
     @SuppressWarnings({ "rawtypes", "unchecked" })
         
     public String insertPoints(String newName, int newX, int newY)
         
     {
         
         Point newPoint = new Point(newName, newX, newY);
         
         if (newPoint.inTheBox())
         
         {
         
             StringBuilder insertStr = new StringBuilder("Point inserted: (");
         
             insertStr.append(newPoint.toString() + "\n");
         
             String format = insertStr.toString();
         
             KVPair pointPair = new KVPair(newPoint.getName(), newPoint);
         
             this.pointList.insert(pointPair);
         
             this.pointTree.insert(world, newPoint);
         
             return format;
         
         }
         
         else
         
         {
         
             StringBuilder rejectStr = new StringBuilder("Point rejected: (");
         
             rejectStr.append(newPoint.toString());
         
             rejectStr.append("\n");
         
             String format = rejectStr.toString();
         
             return format;
         
         }
         
         
         
     }
         
     
         
     /**
         
      * This create dump string output
         
      * 
         
      * @return
         
      *      dump string
         
      */
         
     public String dumpPoints()
         
     {
         
         
         
         StringBuilder dump = new StringBuilder("");
         
         dump.append(pointList.dump());
         
         String dumpStr = dump.toString();
         
         
         
         //pointTree.dump(world);
         
         return dumpStr;
         
     }
         
     
         
     /**
         
      * This remove the point with using coords
         
      * 
         
      * @param x
         
      *      removing point's x coord
         
      * @param y
         
      *      removing point's y coord
         
      * @return
         
      *      the remove string
         
      */
         
     @SuppressWarnings({ "unchecked", "rawtypes" })
         
     public String removeByPoint(int x, int y)
         
     {
         
         StringBuilder removeByPoint = new StringBuilder("");
         
         Point sample = new Point("sample", x, y);
         
         if (!sample.inTheBox())
         
         {
         
             removeByPoint.append("Point rejected: ");
         
             removeByPoint.append("(" + x + ", " + y + ")\n");
         
             String removeByPointStr = removeByPoint.toString();
         
             return removeByPointStr;
         
         }
         
         Point removed = pointTree.searchByCoord(world, x, y);
         
         if (removed == null)
         
         {
         
             removeByPoint.append("Point not found: ");
         
             removeByPoint.append("(" + x + ", " + y + ")\n");
         
         }
         
         else
         
         {
         
             String pointName = removed.getName();
         
             KVPair pointPair = new KVPair(pointName, removed);
         
             removeByPoint.append("Point removed: (");
         
             removeByPoint.append(removed.toString() + "\n");
         
             pointTree.removeByPoint(world, removed);
         
             pointList.removeByValue(pointPair);
         
             //pointList.remove(pointName);
         
         }
         
         String removeByPointStr = removeByPoint.toString();
         
         return removeByPointStr;
         
     }
         
     
         
     /**
         
      * This remove the point with using name
         
      * 
         
      * @param name
         
      *      removing point's name
         
      * @return
         
      *      the remove string value
         
      */
         
     @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
         
     public String removeByName(String name)
         
     {
         
         StringBuilder removeByName = new StringBuilder("");
         
         KVPair pair = pointList.search(name);
         
         
         
         if (pair == null)
         
         {
         
             removeByName.append("Point not removed: ");
         
             removeByName.append(name);
         
             removeByName.append("\n");        
         
         }
         
         else
         
         {
         
             
         
             removeByName.append("Point removed: (");
         
             removeByName.append(pair.value().toString());
         
             removeByName.append("\n"); 
         
             Point point = (Point)pointList.remove(name).value();
         
             int x = point.getXPoints();
         
             int y = point.getYPoints();
         
             pointTree.removeByPoint(world, point);
         
         }
         
         String removeNameStr = removeByName.toString();
         
         return removeNameStr;
         
     }
         
     
         
     /**
         
      * This search points using the name        
      * 
         
      * @param name
         
      *      searching point's name
         
      * @return
         
      *      the search String
         
      */
         
     @SuppressWarnings({ "rawtypes", "unchecked" })
         
     public String search(String name)
         
     {
         
         //Point samplePoint = new Point(name, 3, 3);
         
         KVPair pair = pointList.search(name);
         
         //Point point = (Point)pair.value();
         
         
         
         StringBuilder search = new StringBuilder("");
         
         if (pair == null)
         
         {
         
             search.append("Point not found: ");
         
             search.append(name);
         
             search.append("\n");
         
         }
         
         else
         
         {
         
             SkipList.SkipIterator points = pointList.iterator1();
         
             while (points.hasNext())
         
             {
         
                 Point point = (Point)points.next().getValue();
         
                 if (name.equals(point.getName()))
         
                 {
         
                     search.append("Found (");
         
                     search.append(point.toString() + "\n");        
               }
      
             }
        
         }
       
         String searchStr = search.toString();
        
         return searchStr;    
     }      
 }
