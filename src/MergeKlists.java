import java.util.PriorityQueue;
import java.util.Queue;

class MergeKlists {
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

    public ListNode mergeKLists(ListNode[] lists) {
          Queue<Integer> minHeap = new PriorityQueue<>();

          for (ListNode nodes : lists) {
              ListNode cur = nodes;
              while (cur != null ) {
                  minHeap.add(cur.val);
                  cur = cur.next;
              }
          }

          ListNode dummy = new ListNode(0);
          ListNode cur = dummy;

          while (!minHeap.isEmpty() ) {
              cur.next = new ListNode (minHeap.poll());
              cur = cur.next;
          }
          return dummy.next;
    }

    public ListNode mergeKListsRecursively(ListNode[] lists) {
          int size = lists.length;
          int interval = 1;
          while (size > interval) {
              for (int i = 0; i < size - interval; i += 2*interval) {
                  lists[i]= merge (lists[i],lists[i + interval]);
              } interval *= 2;
          }
          return size > 0 ? lists[0] : null;
    }

    private ListNode merge (ListNode l1, ListNode l2) {
          ListNode dummy = new ListNode(0);
          ListNode cur = dummy;

          while (l1 != null && l2 != null) {
              ListNode temp = new ListNode();
              if (l1.val <= l2.val) { temp.val = l1.val;
                  cur.next = temp;cur = cur.next;
                  l1 = l1.next; }
              else { temp.val = l2.val;
                  cur.next = temp;cur = cur.next;
                  l2 = l2.next; }
          }

          if (l1 != null ) cur.next = l1;
          else cur.next = l2;

          return dummy.next;
    }

    public static void main (String[] args) {
        MergeKlists a1 = new MergeKlists();


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode[] lists = {l1,l2};
        //a1.printList(a1.reverseList(head));
        //ListNode result = a1.mergeKLists(lists);
        ListNode result = a1.mergeKListsRecursively(lists);
        a1.printList(result);
    }
}
