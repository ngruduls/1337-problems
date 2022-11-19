import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node left;
    private Node right;

      private static class Node {
          int key;
          int val;
          Node next;
          Node prev;
          //ListNode random;
          Node() {}
         Node(int key, int val) { this.key = key; this.val = val; }
         Node(int key, int val, Node next) { this.key = key; this.val = val; this.next = next; }
      }
      public void printList(Node head) {
          System.out.println();
          System.out.println(head.val);
          while (head.next != null) {
              System.out.println(head.next.val);
              head = head.next;
          }
      }

    public LRUCache(int capacity) {
          this.capacity = capacity;
          cache = new HashMap<>();
          this.left = new Node(0,0);
          this.right = new Node(0,0);
          this.left.next = this.right;
          this.right.prev = this.left;
    }

    public int get(int key) {
          if (cache.containsKey(key) ) {
              remove(cache.get(key));
              insert(cache.get(key));
              return cache.get(key).val;
          } else { return -1 ; }
    }

    private void insert(Node node) {
          Node prev = this.right.prev;
          Node next = this.right;
          prev.next = node; next.prev = node;
          node.next = next; node.prev = prev;
    }

    private void remove(Node node) {
          Node prev = node.prev;
          Node next = node.next;
          prev.next = next;
          next.prev = prev;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)) ;
        } cache.put (key, new Node(key,value));
        insert(cache.get(key)) ;
        if (cache.size() > capacity) {
            Node lru = this.left.next; // first real node
            remove(lru); cache.remove(lru.key) ;
        }
    }

    public static void main (String[] args) {
        LRUCache a1 = new LRUCache(2);
        Node result = new Node();

        a1.put(1,1);
        a1.put(2,2);
        System.out.println(a1.get(1));
        a1.put(3,3);
        System.out.println(a1.get(2));
        a1.put(4,4);
        System.out.println(a1.get(1));
        System.out.println(a1.get(3));
        System.out.println(a1.get(4));

        //a1.printList(result);
    }
}
