class MergeTwoSortedLists {
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
          System.out.println();
          System.out.println(head.val);
          while (head.next != null) {
              System.out.println(head.next.val);
              head = head.next;
          }
      }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          ListNode start = new ListNode();
          ListNode curr = start;
          while (list1 != null && list2 != null) {
              if (list1.val < list2.val) {
                  ListNode temp = new ListNode(list1.val);
                  curr.next = temp; list1 = list1.next; curr = temp;
              } else {
                  ListNode temp = new ListNode(list2.val);
                  curr.next = temp; list2 = list2.next; curr = temp;
              }
          }
          if (list1 != null) curr.next = list1;
          if (list2 != null) curr.next = list2;
          return start.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            this.printList(list1);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list2.next, list1);
            this.printList(list2);
            return list2;
        }
    }

    public static void main (String[] args) {
        MergeTwoSortedLists a1 = new MergeTwoSortedLists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode (3);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(99);
        //a1.printList(a1.reverseList(head));
        a1.printList(a1.mergeTwoLists2(head,head2));
    }
}
