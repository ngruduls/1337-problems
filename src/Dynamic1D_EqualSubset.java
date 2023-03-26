import java.util.HashSet;
import java.util.Set;

public class Dynamic1D_EqualSubset {
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int ithNumber = nums[i - 1];
                if (i == 0 || j == 0) {
                    if (i == 0) dp[i][j] = false;
                    else if (j == 0) dp[i][j] = true;
                } else if (j >= ithNumber) {
                    boolean skip = dp[i - 1][j];
                    boolean include = dp[i - 1][j - ithNumber];
                    dp[i][j] = skip || include;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean dp[][] = new boolean[n + 1][subSetSum + 1];
        ///dp[i][j]=true if the sum jjj can be formed by array elements in subset nums[0]..nums[i]\text{nums[0]} .. \text{nums[i]}nums[0]..nums[i]
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                boolean without = dp[i - 1][j];
                if (j < curr)
                    dp[i][j] = without;
                else
                    dp[i][j] = without ||  dp[i - 1][j - curr];
            }
        }
        return dp[n][subSetSum];
    }

    public static void main(String[] args) {
        Dynamic1D_EqualSubset a1 = new Dynamic1D_EqualSubset();
        System.out.println(a1.canPartition(new int[] { 4,4,2 }));
    }
}
