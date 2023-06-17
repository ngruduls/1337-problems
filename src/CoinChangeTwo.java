import java.util.Arrays;

public class CoinChangeTwo {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++ ) {
                if (coin <= i) {
                    dp[i] = dp[i] + dp[ i - coin];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeTwo a1 = new CoinChangeTwo();
        int[] coins = {1,2,5};
        int amt = 5;
        System.out.println(a1.change(amt,coins));
    }
}
