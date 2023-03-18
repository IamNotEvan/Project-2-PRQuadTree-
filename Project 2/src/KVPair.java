
/**
    
The KVPair class, for holding keys and values together,
    
and comparing them using only the Key
    

    
@author Evan Lee (evan0110)
    
@version 09.30.2022
    
  *
    
@param <K>
    
     the key
    
@param <V>
    
     the value
*/

    
public class KVPair<K extends Comparable<K>, V>
    
 implements Comparable<KVPair<K, V>> {
    
 private K theKey;
    
 private V theVal;
    
 
    
 /**
    
  * This is constructor
    
  * 
    
  * @param k
    
  *      the key
    
  * @param v
    
  *      the value
    
  */
    
 public KVPair(K k, V v) {
    
     theKey = k;
    
     theVal = v;
    
 }
    
 
    
 
    
 /**
    
  * Return the key
    
  * 
    
  * @return
    
  *      the key
    
  */
    
 public K key() {
    
     return theKey;
    
 }
    
 
    
 /**
    
  * Return the value
    
  * 
    
  * @return
    
  *      the value
    
  */
    
 public V value() {
    
     return theVal;
    
 }
    
 
    
 /**
    
  * Compare the key
    
  * 
    
  * @param it
    
  *      comparing key
    
  * @return
    
  *      the int type
    
  */
    
 public int compareTo(K it) 
    
 {
    
     return theKey.compareTo(it);
    
 }
    
 
    
 /**
    
  * Compare the key with KVPair
    
  * 
    
  * @param it
    
  *      comparing pair
    
  * @return 
    
  *      the int type
    
  */
    
 public int compareTo(KVPair<K, V> it) 
    
 {
    
     return theKey.compareTo(it.key());
    
 }
    
 
    
 /**
    
  * Print the string value
    
  * 
    
  * @return
    
  *      the string of this pair
    
  */
    
 public String toString() 
    
 {
    
     return "(" + theKey.toString() + ", " +
    
         theVal.toString();
    
 }
    
 }