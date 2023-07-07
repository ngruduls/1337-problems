import java.util.Arrays;

public class Dynamic2D_LongestIncresingMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int d[] : dp) Arrays.fill(d, -1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == -1) {
                    int pathfromHere = dfs (matrix, dp, rows, cols, i, j, -1);
                }
            }
        }
        int max = -1;
        for (int[] d : dp) {
            for (int i : d) max = Math.max(i, max);
        }
        return max;
    }

    public int dfs (int[][] matrix, int[][] dp, int rows, int cols, int i, int j, int prev) {
        if (i >= rows || j >= cols || i < 0 || j < 0 || matrix[i][j] <= prev) {
            return 0;
        }
        prev = matrix[i][j];
        int left = dfs (matrix, dp, rows, cols, i, j - 1, prev);
        int right = dfs (matrix, dp, rows, cols, i, j + 1, prev);
        int up = dfs (matrix, dp, rows, cols, i - 1, j, prev);
        int down = dfs (matrix, dp, rows, cols, i + 1, j, prev);
        dp[i][j] = 1 + Math.max(Math.max(left,right), Math.max(up, down));
        return dp[i][j];
    }

    public static void main(String[] args) {
        Dynamic2D_LongestIncresingMatrix a1 = new Dynamic2D_LongestIncresingMatrix();
        int[][] matrix = { {9,9,4}, {6,6,8}, {2,1,1}};
        System.out.println(a1.longestIncreasingPath(matrix));
    }
}
