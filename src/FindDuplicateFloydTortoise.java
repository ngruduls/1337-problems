import java.util.HashSet;

class FindDuplicateFloydTortoise {
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
      public int findDuplicate(int[] nums) {
          int fast = nums[0];
          int slow = nums[0];
          boolean first = true;
          while (first ||  fast != slow) {
              if (first) first  = false;
              slow = nums[slow];
              fast = nums[nums[fast]];
              if (fast == slow) break;
          }
          int slow2 = nums[0];
          while (slow2 != slow) {
              if (first) first = false;
              slow2= nums[slow2];
              slow = nums[slow];
              if (slow2 == slow) return slow;
          }
          return slow;
      }

    public static void main (String[] args) {
        FindDuplicateFloydTortoise a1 = new FindDuplicateFloydTortoise();
        int[] nums = {1,3,4,2,2};

        System.out.println(a1.findDuplicate(nums));
    }
}
