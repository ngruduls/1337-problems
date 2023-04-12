import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_PacificAtlantic {
    int rows, cols;
    private int[][] res;
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = heights;

        rows = heights.length; cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific);
            dfs(i, cols - 1, atlantic);
        }
        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific);
            dfs(rows - 1, i, atlantic);
        }

        List<List<Integer>> common = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    common.add(List.of(i,j));
                }
            }
        }
        return common;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                continue;
            }
            if (reachable[newRow][newCol]) {
                continue;
            }
            if (res[newRow][newCol] < res[row][col]) {
                continue;
            }
            dfs(newRow, newCol, reachable);
        }
    }

    public static void main(String[] args) {
        Graph_PacificAtlantic a1 =new Graph_PacificAtlantic();
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        System.out.println(a1.pacificAtlantic(heights).toString());
    }
}
