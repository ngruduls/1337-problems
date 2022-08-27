import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class MaximumSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int right=0; right < nums.length; right++) {
            if (!q.isEmpty() && (q.peekFirst() < left) ) {
                q.pollFirst();
            }
            while(!q.isEmpty() && (nums[q.peekLast()] < nums[right] ) ) {
                q.pollLast();
            }
            q.offer(right);
            if (right >= k - 1) {
                int idx = q.peekFirst();
                res[left] = nums[idx];
                left++;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        MaximumSlidingWindow a1 = new MaximumSlidingWindow();
        //int[] nums = {1,3,-1,-3,5,3,6,7}; k = 3;
        //int[] nums = {8,7,6,2}; int k = 2;
        int[] nums = {9,10,11,12,1,1,4,4,2}; int k = 3;
        //System.out.println(a1.climbStairsDP(3));
        System.out.println(Arrays.toString(a1.maxSlidingWindow(nums,k)));
    }
}
