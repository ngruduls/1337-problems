import java.util.LinkedList;
import java.util.Queue;

public class Graph_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.add(new int[] {i, j});
                else if (grid[i][j] == 1) fresh +=1;
            }
        }
        int count = 0;
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty() && fresh != 0) {
            count += 1;
            int sz = queue.size();
            for (int i = 0; i < sz; i += 1) {
                int[] rotten = queue.remove();
                int r = rotten[0]; int c = rotten[1];
                for (int[] dir : dirs) {
                    int x = r + dir[0]; int y = c + dir[1];
                    if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] { x, y });
                        fresh -= 1;
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }

    public static void main(String[] args) {
        Graph_RottingOranges a1 = new Graph_RottingOranges();
        int[][] grid = new int[][] { {2,1,1}, {1,1,0}, {0,1,1} };
        System.out.println(a1.orangesRotting(grid) );
    }
}
