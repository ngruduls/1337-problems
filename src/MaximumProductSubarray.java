import java.util.Arrays;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int res = nums[0];
        int upperBound = 1;
        int lowerBound = 1;

        for (int n : nums) {
            int newMax = upperBound * n; int newMin = lowerBound * n;
            upperBound = Math.max(n, Math.max(newMax, newMin));
            lowerBound = Math.min(n, Math.min(newMax, newMin));
            res = Math.max(res,upperBound);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray a1 = new MaximumProductSubarray();
        int[] arr = { -2,2,3};
        System.out.println(Arrays.toString(arr));
        System.out.println(a1.maxProduct(arr));
    }
}
