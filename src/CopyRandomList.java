import java.util.HashMap;

class CopyRandomList {
    /**
     * Definition for singly-linked list. */
      public static class Node {
          int val;
          Node next;
          Node random;
          Node() {}
         Node(int val) { this.val = val; }
         Node(int val, Node next, Node random) { this.val = val; this.next = next; this.random = random; }
      }
      public void printList(Node head) {
          System.out.println();
          System.out.println(head.val);
          while (head.next != null) {
              System.out.println(head.next.val);
              head = head.next;
          }
      }

    public Node copyRandomList(Node head) {
          Node cur = head;
          HashMap<Node, Node> map = new HashMap<>();
          while (cur != null) {
              map.put(cur, new Node(cur.val));
              cur = cur.next;
          }
          cur = head;
          while (cur != null ) {
              map.get(cur).next = map.get(cur.next);
              map.get(cur).random = map.get(cur.random);
              cur  = cur.next;
          }
          return map.get(head);
    }

    public static void main (String[] args) {
        CopyRandomList a1 = new CopyRandomList();
        Node head2 = new Node();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        //a1.printList(a1.reverseList(head));
        head2 = a1.copyRandomList(head);
        a1.printList(head2);
    }
}
