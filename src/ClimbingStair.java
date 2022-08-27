import java.util.Arrays;

class ClimbingStair {

    //bottom up
    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //top down with memo[]
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) {
            memo[n] = 1;
            return memo[n];
        }
        if (memo[n] != -1) return memo[n];

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }

    public static void main (String[] args) {
        ClimbingStair a1 = new ClimbingStair();
        //System.out.println(a1.climbStairsDP(3));
        System.out.println(a1.climbStairs(3));
    }
}
