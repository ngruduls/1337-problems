import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class KthGroupReverseList {
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

    public ListNode reverseKGroup1(ListNode head, int k) {
          ListNode cur = head;
          int count = 0;
          while (cur != null && count != k) {
              cur = cur.next;
              count++;
          }
          if (count == k) {
              cur = reverseKGroup1(cur, k);
              while (count-- > 0) {
                  ListNode temp = head.next;
                  head.next = cur;
                  cur = head;
                  head = temp;
              }
              head = cur;
          }
          return head;
    }

    public ListNode reverseKGroup2 (ListNode head, int k) {
          ListNode dummyStart = new ListNode(0, head);
          ListNode curr = head;
          ListNode groupPrev = dummyStart;
          ListNode groupStart = null;
          int count = k;
          while (curr != null) {
              if (count > 1) {
                  groupStart = groupPrev.next;
                  groupPrev.next = curr.next;
                  curr.next = curr.next.next;
                  groupPrev.next.next = groupStart;
                  count--;
              } else {
                  groupPrev = curr;
                  curr = curr.next;
                  ListNode end = curr;
                  for (int i = 0; i < k; i++) {
                      if (end == null) return dummyStart.next;
                      end = end.next;
                  }
                  count = k;
              }
          }

          return dummyStart.next;
    }

    public static void main (String[] args) {
        KthGroupReverseList a1 = new KthGroupReverseList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        //a1.reverseKGroup1(l1,2);
        ListNode rez = a1.reverseKGroup2(l1,2);
        a1.printList(rez);

    }
}
