package leetCode;

import java.util.*;

public class AllOne {

    /**
     * We will create map of key and Node as object let say it is map
     *
     * @param args
     */
    public static void main(String[] args) {
        AllOnes allOnes = new AllOnes();
        allOnes.inc("hello");
        allOnes.inc("goodbye");
        allOnes.inc("hello");
        allOnes.inc("hello");
        System.out.println(allOnes.getMaxKey());
        allOnes.inc("leet");
        allOnes.inc("code");
        allOnes.inc("leet");
        allOnes.dec("hello");
        allOnes.inc("leet");
        allOnes.inc("code");

        allOnes.inc("code");
        allOnes.print();

    }

}

class AllOnes {

    Node head = null;
    Node tail = null;
    Map<String, Node> map;

    public AllOnes() {
        map = new HashMap<>();
        /**
         * This we doing to make sure we are handling the NPE
         */
        head = new Node(-1);
        tail = new Node(-1);
        tail.next = head;
        head.prev = tail;
        tail.prev = null;
        head.next = null;
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node n = new Node(1);
            n.set.add(key);

            head.prev.next = n;
            n.prev = head.prev;
            n.next = head;
            head.prev = n;
            map.put(key, n);
            return;
        }
        Node cntNode = map.get(key);
        cntNode.set.remove(key);
        if (cntNode.prev.count != -1 && cntNode.prev.count == (cntNode.count + 1)) {
            cntNode.prev.set.add(key);
            map.put(key, cntNode.prev);
        } else {
            Node n = new Node(cntNode.count + 1);
            n.set.add(key);
            n.next = cntNode.next;
            cntNode.next.prev = n;
            cntNode.next = n;
            n.prev = cntNode;
            map.put(key, n);
        }
        if (cntNode.set.size() == 0 || cntNode.set.isEmpty()) {
            cntNode.prev.next = cntNode.next;
            cntNode.next.prev = cntNode.prev;

        }
    }

    public void dec(String key) {
        Node keyNode = map.get(key);
        int count = keyNode.count;
        keyNode.set.remove(key);
        if (count - 1 == 0) {
            if (keyNode.set.size() == 0) {
                keyNode.prev.next = keyNode.next;
                keyNode.next.prev = keyNode.prev;
                map.remove(key);
            }
            return;
        }
        if (keyNode.next.count != -1 && keyNode.next.count == (keyNode.count - 1)) {
            keyNode.next.set.add(key);
            map.put(key, keyNode.next);
        } else {
            Node n = new Node(count - 1);
            n.set.add(key);
            n.next = keyNode.next;
            keyNode.next.prev = n;
            keyNode.next = n;
            n.prev = keyNode;
            map.put(key, n);
        }
        if (keyNode.set.size() == 0) {
            keyNode.prev.next = keyNode.next;
            keyNode.next.prev = keyNode.prev;
            map.remove(key);
        }

    }

    public String getMaxKey() {
        return tail.next.set.iterator().next();
    }

    public String getMinKey() {
        return head.prev.set.iterator().next();
    }

    public void print(){
        Node tail1 = tail.next;
        while(tail1.count > 0){
            System.out.print(tail1.count+" : ");
            Iterator<String> it = tail1.set.iterator();
            while(it.hasNext()){
                System.out.print(it.next()+",");
            }
            System.out.print(" -> ");
            tail1 = tail1.next;
        }
    }

}

class Node {

    int count;
    Node next;
    Node prev;
    Set<String> set;

    public Node(int count) {
        this.count = count;
        set = new HashSet<>();
        next = null;
        prev = null;
    }
}
