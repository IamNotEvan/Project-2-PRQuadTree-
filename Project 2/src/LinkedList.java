
/**
    
This is Linked List class
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
*/
    

    
public class LinkedList {
    
 
    
 private Link head;        
    
 private Link tail;         
    
 private Link curr;       
    
 private int listSize;     
    
 
    
 
    
 /**
    
  * This is constructor for this class
    
  */
    
 public LinkedList()
    
 { 
    
     clear();
    
 }
    
 
    
 /**
    
  * Clear the entire linked List
    
  */
    
 public void clear() 
    
 {
    
     curr = new Link(null);
    
     tail = new Link(null);
    
     head = new Link(tail);
    
     listSize = 0;
    
 }
    
 
    
 /**
    
  * Append it to the list
    
  * 
    
  * @param it
    
  *      object
    
  * @return
    
  *      always true
    
  */
    
 public boolean append(Object it) 
    
 {
    
     tail.setNext(new Link(null));
    
     tail.setElement(it);
    
     tail = tail.next();
    
     listSize++;
    
     return true;
    
 }
    
 
    
 /**
    
  * This method remove the current node
    
  * 
    
  * @return
    
  *      The removed object
    
  */
    
 public Object remove() 
    
 {
    
     if (curr == tail)
    
     {
    
         return null;
    
     }
    
     Object it = curr.element();
    
     curr.setElement(curr.next().element());
    
     if (curr.next() == tail)
    
     {
    
         tail = curr;
    
     }
    
     curr.setNext(curr.next().next());
    
     listSize--;
    
     return it;
    
 }
    
  
    
 /**
    
  * Move pointer to the first object
    
  */
    
 public void moveToStart()
    
 { 
    
     curr = head.next();
    
 } 
    
 
    
 /**
    
  * Move pointer to the next link
    
  */
    
 public void next() 
    
 { 
    
     if (curr != tail)
    
     {
    
         curr = curr.next();      
    
     }
    
 }
    
 
    
 /**
    
  * Return the number of objects in the linked list
    
  * 
    
  * @return
    
  *      the size
        
  */
        
 public int length() 
        
 { 
        
     return listSize; 
        
 }
        
 /**
        
  * Get the current node's object
        
  * 
        
  * @return
        
  *      object
        
  */
        
 public Object getValue() 
        
 {
        
     return curr.element(); 
        
 }
        
 
        
 /**
        
  * Check all the objects in Linked is same
        
  * 
        
  * @return
        
  *      if they are same or not
        
  */
        
 public boolean allSame()
        
 {
        
     this.moveToStart();
        
     Point first = (Point)curr.element();
        
     for (int i = 0; i < this.length(); i++)
        
     {
        
       
        
         Point temp = (Point)this.getValue();
        
         if (!first.equals(temp))
        
         {
        
             return false;
        
         }
        
         this.next();  
        
     }
        
     return true;
        
 }
        
 
        
 }