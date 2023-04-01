public class Graph_MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int rez = 0; int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    rez = Math.max( dfs(grid, row, col, rows, cols/*new int[] {0}*/), rez );
                }
            }
        }
        return rez;
    }

    public int dfs(int[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return 0;
        }
        int result = 1;
        grid[row][col] = 0;

        result += dfs(grid, row - 1, col, rows, cols);
        result += dfs(grid, row, col - 1, rows, cols);
        result += dfs(grid, row + 1, col, rows, cols);
        result += dfs(grid, row, col + 1, rows, cols);
        return result;
    }

    public static void main(String[] args) {
        Graph_MaxAreaOfIslands a1 = new Graph_MaxAreaOfIslands();
        int[][] islands = {
                {0,0,1,0},
                {0,0,0,0},
                {0,1,1,1}
                };
        System.out.println(a1.maxAreaOfIsland(islands));
    }
}
