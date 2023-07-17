public class Dynamic2D_BurstBalloons {
    public int maxCoins (int[] nums) {
        // add 1 beginning [] end
        int n = nums.length + 2;
        int [] balloons = new int[n];
        System.arraycopy(nums, 0, balloons, 1, n - 2);
        balloons[0] = 1; balloons[n - 1] = 1;

        // cache the results of dp
        int[][] memo = new int[n][n];

        return dp(memo, balloons, 1, n -2);
    }

    public int dp (int[][] memo, int[] nums, int left, int right) {
        if (right - left < 0) {
            return 0;
        }
        // already seen
        if (memo[left][right] > 0) {
            return memo[left][right];
        }

        // find the last burst one in nums[left]...nums[right]
        int result = 0;
        for (int i = left; i <= right; i++) {
            // i  nums[i] is the last burst one
            int gain = nums[left - 1] * nums[i] * nums[right + 1];
            // nums[i] is fixed, recursively call left and right side
            int remaining_left = dp(memo, nums, left, i - 1);
            int remaining_right = dp(memo, nums, i + 1, right);
            int remaining = remaining_left + remaining_right;
            result = Math.max(result, gain + remaining);
        }
        // add to cache
        memo[left][right] = result;
        return result;
    }

    public static void main(String[] args) {
        Dynamic2D_BurstBalloons b1 = new Dynamic2D_BurstBalloons();
        int []  numz = {3,1,5,8};

        System.out.println(b1.maxCoins(numz));
    }
}
