class RemoveNthNodeFromList {
    /**
     * Definition for singly-linked list. */
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      public void printList(ListNode head) {
          System.out.println();
          System.out.println(head.val);
          while (head.next != null) {
              System.out.println(head.next.val);
              head = head.next;
          }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
          if (head == null || head.next == null) return null;
          ListNode dummy = new ListNode(0);
          dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast= fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main (String[] args) {
        RemoveNthNodeFromList a1 = new RemoveNthNodeFromList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        //a1.printList(a1.reverseList(head));
        a1.removeNthFromEnd(head,2);
        a1.printList(head);
    }
}
