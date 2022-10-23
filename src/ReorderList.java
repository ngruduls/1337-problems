class ReorderList {
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

    public void reorderList(ListNode head) {
          ListNode slow = head;
          ListNode fast = head.next;
          while (fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next.next;
          }
          ListNode second = slow.next;
          ListNode lag = slow.next = null;
          while (second != null) {
              ListNode temp = second.next;
              second.next = lag;
              lag = second;
              second = temp;
          }

          ListNode first = head;
          //second = prev;
          while (lag != null) {
              ListNode temp1 = first.next;
              ListNode temp2 = lag.next;
              first.next = lag;
              lag.next = temp1;
              first = temp1;
              lag  = temp2;
          }
    }

    public static void main (String[] args) {
        ReorderList a1 = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        head.next.next.next = new ListNode (4);
        //a1.printList(a1.reverseList(head));
        a1.reorderList(head);
        a1.printList(head);
    }
}
