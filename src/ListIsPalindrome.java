import java.util.*;

class ListIsPalindrome {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = dummy;
        ListNode temp = null;

        int count = k;

        while (curr != null) {
            if (count > 1) {
                temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;

                count--;
            } else {
                prev = curr;
                curr = curr.next;

                ListNode end = curr;

                for (int i = 0; i < k; ++i) {
                    if (end == null) {
                        return dummy.next;
                    }
                    end = end.next;
                }
                count = k;
            }
        }

        return dummy.next;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null) return false; if (head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        int listLength = 1;

        while (fast != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow.next != null) {
            if (slow.val != stack.pop()) return false;
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) return false; if (head.next == null) return true;
        String normal = "";
        ListNode cur = head;
        while (cur != null) {
            normal += (cur.val);
            cur = cur.next;
        }
        String reversed = "";
        for (int i = normal.length()-1 ; i >= 0 ; i--) { reversed = reversed + normal.charAt(i); }
        for (int i = 0; i<normal.length(); i++) { if(normal.charAt(i) != reversed.charAt(i)) return false; }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null) return false; if (head.next == null) return true;
        List<Integer> vals = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            vals.add(cur.val);
            cur = cur.next;
        }
        int front = 0; int back = vals.size() - 1;
        while (front < back ) {
            if (vals.get(front) != vals.get(back)) return false;
            front++; back--;
        }
        return true;
    }

    public static void main (String[] args) {
        ListIsPalindrome a1 = new ListIsPalindrome();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(1);

        System.out.println(a1.isPalindrome1(l1));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        System.out.println(a1.isPalindrome3(l2));
    }
}
