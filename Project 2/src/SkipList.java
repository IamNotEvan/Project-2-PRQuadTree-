    
import java.lang.reflect.Array;
    
import java.util.Random;
    
import student.TestableRandom;
    
 
    
 
    
/**
    
This is SkipList class
    

    
@author Evan Lee
    
@version 09.30.2022
    
  *
    
@param <K>
    
     the key
    
@param <E>
    
     the value
    
*/
    
public class SkipList<K extends Comparable<K>, E> {
    
 
    
 private Random rng;
    
 private int deepestLevel;
    
 private SkipNode<K, E> head;
    
 private int size = 0;
    
 
    
 /**
    
  * Constructor for this class
    
  */
    
 public SkipList() {
    
     rng = new TestableRandom();
    
     deepestLevel = 0;
    
     head = new SkipNode<K, E>(0, null);
    
 }
    
 
    
 
    
 
    
 /**
    
  * Pick a level using a geometric distribution
    
  * 
    
  * @return
    
  *      the random number
    
  */
    
 private int randomLevel() 
    
 {
    
     int level = 0;
    
     while (rng.nextBoolean())
    
     {
    
         level++;
    
     }
    
     return level;
    
 }
    
 
    
 
    
 
    
 /**
    
  * Make the header node deeper
    
  * 
    
  * @param newLevel
    
  *      the depth for the node
    
  */
    
 private void adjustHead(int newLevel) {
    
     int i;
    
     SkipNode<K, E> temp = new SkipNode<K, E>(newLevel, null);
    
     for (i = 0; i <= deepestLevel; i++)
    
     {
    
         temp.setSkip(i, head.getSkip(i));
    
     }
    
     for (i = deepestLevel + 1; i < newLevel; i++)
    
     {
    
         temp.setSkip(i, null);
    
     }
    
     deepestLevel = newLevel;
    
     head = temp;
    
 }
    
 
    
 
    
 /**
    
  * Return the size
    
  * 
    
  * @return
    
  *      size of skipList
    
  */
    
 public int size() 
    
 {
    
     return size;
    
 }
    
 
    
 /**
    
  * This method returns the (first) matching matching element
    
  *  if one exists, null otherwise
    
  * 
    
  * @param key
    
  *      the search key
    
  * @return
    
  *      the matching pair
    
  */
    
 public KVPair<K, E> search(Comparable<K> key) {
    
     if (deepestLevel < 0)
    
     {
    
         return null;
    
     }
        
     SkipNode<K, E> x = head;                 
        
     for (int i = deepestLevel; i >= 0; i--)
        
     {
        
         while ((x.getSkip(i) != null) &&
        
             (key.compareTo(x
        
                 .getSkip(i).getKey()) > 0))
        
         {
        
             x = x.getSkip(i);     
        
         }
        
     }
        
     x = x.getSkip(0); 
        
     if ((x != null) && (key.compareTo(x.getKey()) == 0))
        
         return (KVPair<K, E>)x.getPair();
        
     else
        
         return null;
        
 }
        
 
        
 
        
 
        
 /**
        
  * This insert the newPair into the list
        
  * 
        
  * @param newPair
        
  *      inserting new Pair
        
  * 
        
  */
        
 public void insert(KVPair<K, E> newPair) {
        
     int newLevel = randomLevel();
        
     if (deepestLevel < newLevel) {
        
         adjustHead(newLevel); 
        
     }
        
     @SuppressWarnings("unchecked") 
        
     SkipNode<K, E>[] update = (SkipNode<K, E>[])Array.newInstance(
        
         SkipNode.class, deepestLevel + 1);
        
    
        
     Comparable<K> newKey = newPair.key();
        
     SkipNode<K, E> curr = head;
        
     for (int i = deepestLevel; i >= 0; i--) { 
        
         SkipNode<K, E> ahead = curr.getSkip(i);
        
         while (ahead != null &&
        
             newKey.compareTo(ahead.getKey()) > 0) {
        
             curr = ahead;
        
             ahead = ahead.getSkip(i);
        
         }
        
         update[i] = curr; 
        
     }
        
 
        
     curr = new SkipNode<K, E>(newLevel, newPair);
        
     for (int i = 0; i <= newLevel; i++) {
        
         curr.setSkip(i, update[i].getSkip(i));
        
         update[i].setSkip(i, curr);
        
     }
        
     size++; 
        
 }
        
 
        
 /**
        
  * Remove some record with key value "key" from the SkipList. 
        
  * In practice, this is the FIRST record with that key value.
        
  *
        
  * @param key Key value to find and remove
        
  * @return The KVPair of the removed node, or null if no key matches
        
  */
        
 public KVPair<K, E> remove(K key) {
        
     int i;
        
     @SuppressWarnings("unchecked") 
        
     SkipNode<K, E>[] update = (SkipNode<K, E>[])Array.newInstance(
        
         SkipNode.class, deepestLevel + 1);
        
 
        
     SkipNode<K, E> curr = head; 
        
     for (i = deepestLevel; i >= 0; i--) { 
        
         SkipNode<K, E> ahead = curr.getSkip(i);
        
         while (ahead != null && key.compareTo(ahead.getKey()) > 0) {
        
             curr = ahead;
        
             ahead = ahead.getSkip(i);
        
         }
        
         update[i] = curr; 
        
     }
        
 
        
     curr = curr.getSkip(0);     
        
     if (curr != null && key.compareTo(curr.getKey()) == 0) {
        
         for (i = 0; i <= curr.getLevel(); i++) {
        
             update[i].setSkip(i, curr.getSkip(i));
        
         }
        
         size--;
        
         return curr.getPair(); 
        
     }
        
     return null; 
        
 }
        
 
        
 /**
        
  * Remove node by using key and value
        
  * 
        
  * @param pair
        
  *       removing pair
        
  * @return
        
  *       the removed pair
        
  */
        
 @SuppressWarnings({ "rawtypes", "unchecked" })
        
 public KVPair<K, E> removeByValue(KVPair pair)
        
 {
        
     K key = (K)pair.key();
        
     Object object = pair.value();
        
     LinkedList pairList = new LinkedList();
        
     KVPair<K, E> returnPair = null;
        
     boolean exist = false;
        
     while (true)
        
     {
        
         KVPair<K, E> samplePair = this.remove(key);
        
         Object value = samplePair.value();
        
         if (value.equals(object))
        
         {
        
             returnPair = samplePair;
        
             exist = true;
        
             break;
        
         }
        
         else
        
         {
        
             pairList.append(samplePair);
        
         }
        
         if (this.search(key) == null)
        
         {
        
             break;
        
         }
        
     }
        
     pairList.moveToStart();
        
     for (int i = 0; i < pairList.length(); i++)
        
     {
        
         KVPair pair2 = (KVPair)pairList.getValue();
        
         this.insert(pair2);
        
         pairList.next();
        
     }
        
     
        
     if (exist)
        
     {
        
         return returnPair;
        
     }
        
     return null;
        
 }
        
  
        
 
        
 /**
        
  * Dump all the objects in the skip list
        
  * 
        
  * @return
        
  *      the string value of the output
        
  */
        
 @SuppressWarnings("rawtypes")
        
 public String dump()
        
 {
        
     StringBuilder dump = new StringBuilder("SkipList dump:");
        
     dump.append("\n");
        
     SkipIterator dumpIter = this.iterator1();
        
     if (!dumpIter.hasNext())
        
     {
        
         dump.append("Node has depth 1, Value (null)\n"
        
             + "SkipList size is: 0\n");
        
         String emptyDump = dump.toString();
        
         return emptyDump;
        
     }
        
     dump.append("Node has depth ");
        
     dump.append(this.head.getLevel());
        
     dump.append(", Value (null)\n");
        
     while (dumpIter.hasNext())
        
     {
        
         dump.append("Node has depth ");
        
         
        
         SkipNode currentNode = dumpIter.next();
        
         int numOfPointers = currentNode.getLevel();
        
         String valueOfPoint = currentNode.getPair().toString();    
        
         dump.append(numOfPointers + ", Value " + valueOfPoint + "\n");
        
     }
        
     dump.append("SkipList size is: " + this.size + "\n");
        
     String dumpStr = dump.toString();
        
     return dumpStr;
        
     
        
 }
        
 
        
 /**
        
  * This is a inner SkipIterator class
        
  * 
        
  * @author Evan Lee (evan0110)
        
  *
        
  * @param <K>
        
  *      the key
        
  * @param <E>
        
  *      the value
        
  */
        
 @SuppressWarnings("hiding")
        
 class SkipIterator<K, E> {
        
     
        
     private SkipNode<?, ?> currentNode;
        
     
        
     /**
        
      * creates new SKipIterator object
        
      */
        
     public SkipIterator()
        
     {
        
         //this.recList = newList;
        
         this.currentNode = head;
        
     }
        
     
        
     /**
        
      * This method shows it has next
        
      * 
        
      * @return
        
      *      has is or not
        
      */
        
     public boolean hasNext() {
        
         
        
         return currentNode != null 
        
             && currentNode.getSkip(0) != null;
        
     }
        
     
        
     /**
        
      * This method returns the next SkipNode
        
      * 
        
      * @return
        
      *      the next skipNode
        
      */
        
     public SkipNode<?, ?> next() {
        
         currentNode = currentNode.getSkip(0);
        
         return currentNode;
        
     }
        
 
        
 }
        
     
        
 
        
 /**
        
  * This method creates SkipIterator for this SkipList
        
  * 
        
  * @return
        
  *      the SkipIterator object
        
  */
        
 public SkipIterator<?, ?> iterator1()
        
 {
        
     return new SkipIterator<Object, Object>();
        
 }
        
 }