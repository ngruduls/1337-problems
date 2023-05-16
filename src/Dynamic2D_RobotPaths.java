public class Dynamic2D_RobotPaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // last row
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // last column
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Dynamic2D_RobotPaths a1 = new Dynamic2D_RobotPaths();
        System.out.println(a1.uniquePaths(3,7));
    }
}
