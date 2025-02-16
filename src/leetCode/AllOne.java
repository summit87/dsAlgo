package leetCode;
import java.util.*;

public class AllOne {

    /**
     * We will create map of key and Node as object let say it is map
     * @param args
     */

    public static void main(String[] args) {
        AllOnes allOnes = new AllOnes();
        allOnes.inc("hello");
        allOnes.inc("bar");
        allOnes.inc("hello");
        allOnes.inc("bar");
        allOnes.inc("bar");
        allOnes.inc("bar");
        allOnes.dec("bar");
        allOnes.dec("bar");
        allOnes.dec("bar");

        System.out.println(allOnes.getMaxKey());
        System.out.println(allOnes.getMinKey());
    }


}

class AllOnes{
    
    Node head = null;
    Node tail = null;
    Map<String,Node> map;
    public AllOnes(){
        map = new HashMap<>();
        
    }

   
    public  void inc(String key) {
        /**
         * 1. If map contains key , then if we are adding that key , then key from existing node should be removed , and add it to next node 
         *      If next node is empty , that means if current node can be head or tail , 
         *          if(currentNode is head) then we will create new node and set the frequency of from current to current+1
         *          if(currentNode is tail or b/w the linked list)  then we will remove the key from the set of current node and add that key to next node
         *      as soon as if we are rempvng the node from previus node and the key set is empty from previous node then, we will remove the prevous node
         * 
         *   If key not present in the map , then ,
         *      if head == null, then 
         *          then create node assing the frequency to 1 
         *          add it to the map
         *      if head is not null ,
         *      then the key should be into tail set
         * 
         */

        
         
    }

    public  void dec(String key) {
       /**
        * If key is in tail 
        *   remove the key from tail set
            if tail set is empty ,
            then remove the node
          if key is in head
            remove the key from head set 
            add the same key in head previous node
          else
            remove the key from curernt node seet and add it into prevous node
        */

    }

    public  String getMaxKey() {
        /*
         * Max key will be always in the head of list
         */
        return head.set.iterator().next();
    }

    public String getMinKey() {
        /**
         * Minkey always into tail of the key
         */
        return tail.set.iterator().next();
    }

}

class Node {
    int count;
    Node next;
    Node prev;
    Set<String> set = new HashSet<>();

    public Node(int count) {
        this.count = count;
        next = null;
        prev = null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */