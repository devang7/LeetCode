import java.util.*;

public class LRU {
  public static void main(String args[]) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
  }
}
class LRUCache {

    LinkedList<Node> doublyll;
    HashMap<Integer, Node> hs;
    int size;
    public LRUCache(int capacity) {
      doublyll = new LinkedList<>();
      hs = new HashMap<>();
      size = capacity;
    }

    public int get(int key) {
      if(!hs.containsKey(key)) return -1;
      Node node = hs.get(key);
      doublyll.remove(node);
      doublyll.addFirst(node);
      return node.val;
    }

    public void put(int key, int value) {
      if(size == 0) return;
      if(hs.containsKey(key)) {
        Node node = hs.get(key);
        node.val = value;
        doublyll.remove(node);
        doublyll.addFirst(node);
        return;
      }
      if(size == doublyll.size()) {
        Node last = doublyll.removeLast();
        hs.remove(last.key);
      }
      Node node = new Node(key, value);
      hs.put(key, node);
      doublyll.addFirst(node);
    }
}
class Node {
  int key;
  int val;
  Node(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

/*
=> Important to consider the case of Duplicate Keys in put method.
=> Java LinkedList take O(n) time to remove item from linkedList(even though we know the ref)
=> Implemented doubly linkedList on your own to impove efficency to O(1) get and put.
*/
