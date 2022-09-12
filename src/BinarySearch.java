import java.util.Arrays;
import java.util.Stack;

class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (nums[mid] == target ) return mid;
            else if (nums[mid] < target ) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main (String[] args) {
        BinarySearch a1 = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(a1.search(nums,9));
    }
}
