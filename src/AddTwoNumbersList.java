import java.util.HashMap;

class AddTwoNumbersList {
    /**
     * Definition for singly-linked list. */
      public static class ListNode {
          int val;
          ListNode next;
          //ListNode random;
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          int qCarry = 0; int n = 0; int sum = 0;
          ListNode newHead = null;
          ListNode temp = null;
          while (l1 != null || l2 != null) {
              sum = qCarry + ( (( l1 != null ) ? l1.val : 0) + ((l2 != null ) ? l2.val : 0) );
              n = sum % 10;
              qCarry = sum / 10;

              ListNode dummy = new ListNode(n);
              if (newHead == null ) {
                  newHead = dummy;
              } else  {
                  temp = newHead;
                  while (temp.next != null) {  temp = temp.next; }
                  temp.next = dummy; dummy.next = null;
              }
              if (l1 != null) { l1 = l1.next ; }
              if (l2 != null) { l2 = l2.next ; }
          }

          if (qCarry > 0 ) {
              ListNode dummy = new ListNode ( qCarry);
              temp = newHead;
              while (temp.next != null) { temp = temp.next; }
              temp.next = dummy; dummy.next = null;
          }
          return newHead;
    }

    public static void main (String[] args) {
        AddTwoNumbersList a1 = new AddTwoNumbersList();
        ListNode result = new ListNode();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        //a1.printList(a1.reverseList(head));
        result = a1.addTwoNumbers(head,head2);
        a1.printList(result);
    }
}
