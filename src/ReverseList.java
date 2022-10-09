class ReverseList {
    /**
     * Definition for singly-linked list. */
      static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      public void printList(ListNode head) {
          System.out.println(head);
          while (head.next != null) {
              System.out.println(head.next.val);
              head = head.next;
          }
      }
      // iterative
    public ListNode reverseList(ListNode head) {
          ListNode temp = null;
          ListNode curr = head;
          ListNode prev = null;
          while (curr != null) {
               temp = curr.next;
               curr.next = prev;
               // shift forward
               prev = curr;
               curr = temp;
          }
          return prev;
    }

    public ListNode reverseListRecurse (ListNode head) {
          return rev(head, null);
    }
    public ListNode rev(ListNode node, ListNode pre) {
          if (node == null) return pre;
          ListNode temp = node.next;
          node.next = pre;
          return rev(temp, node);
    }


    public static void main (String[] args) {
        ReverseList a1 = new ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //a1.printList(a1.reverseList(head));
        a1.printList(a1.reverseListRecurse(head));
    }
}
