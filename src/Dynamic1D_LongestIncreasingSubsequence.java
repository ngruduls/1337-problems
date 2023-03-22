import java.util.Arrays;

public class Dynamic1D_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int[] LIS = new int[nums.length];
        Arrays.fill(LIS, 1);
        int maximumSoFar = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(1 + LIS[j], LIS[i]);
                }
            }
            maximumSoFar = Math.max(maximumSoFar, LIS[i]);
        }
        return maximumSoFar;
    }

    public static void main(String[] args) {
        Dynamic1D_LongestIncreasingSubsequence a1 = new Dynamic1D_LongestIncreasingSubsequence();
        System.out.println(a1.lengthOfLIS( new int[] {1,2,4,3} ));
    }
}
