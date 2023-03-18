    
import java.lang.reflect.Array;
    
 
    

/**    
Skipnode class for SkipList
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  *
    
@param <K>
    
     the key
    
@param <V>
    
     the value
*/

    
public class SkipNode<K extends Comparable<K>, V> {
    
 
    
 private KVPair<K, V> pair;
    
 private SkipNode<K, V>[] skips;
    
 
    
 /**
    
  * This is constructor for this class
    
  * 
    
  * @param level
    
  *      the level of node
    
  * @param pair
    
  *      the KV pair in this node
    
  */
    
 @SuppressWarnings("unchecked")
    
 public SkipNode(int level, KVPair<K, V> pair) {
    
     this.pair = pair;
    
     skips = (SkipNode[])Array.newInstance(SkipNode.class, level + 1);
    
     for (int i = 0; i < skips.length; i++) {
    
         skips[i] = null;
    
     }
    
 }
    
 
    
 /**
    
  * Return the key
    
  * 
    
  * @return
    
  *      key
    
  */
    
 public K getKey() {
    
     return pair.key();
    
 }
    
 
    
 
    
 /**
    
  * Return the value
    
  * 
    
  * @return
    
  *      value
    
  */
    
 public V getValue() {
    
     return pair.value();
    
 }
    
 
    
 
    
 /**
    
  * Return the pair
    
  * 
    
  * @return
    
  *      pair
    
  */
    
 public KVPair<K, V> getPair() {
    
     return pair;
    
 }
    
 
    
 
    
 /**
    
  * This set Skip
    
  * 
    
  * @param level
    
  *      random level
    
  * @param nextNode
    
  *      next node
    
  */
    
 public void setSkip(int level, SkipNode<K, V> nextNode) {
    
     skips[level] = nextNode;
    
 }
    
 
    
 /**
    
  * Get the skip array
    
  * 
    
  * @param level
    
  *      at that depth
    
  * @return
    
  *      the skip array
    
  */
    
 public SkipNode<K, V> getSkip(int level) {
    
     return skips[level];
    
 }
    
 
    
 /**
    
  * Get the level of the node
    
  * 
    
  * @return
    
  *      level of the node
    
  */
    
 public int getLevel() {
        
     return skips.length - 1;
        
 }
        
 
        
 
        
 
        
 }