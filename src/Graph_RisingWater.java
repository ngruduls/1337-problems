import java.util.PriorityQueue;

public class Graph_RisingWater {
    private int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        if (n == 1 ) return 0;
        var seen = new boolean[n][n];
        seen[0][0] = true;

        var minHeap = new PriorityQueue<Integer[]>( (a, b) -> a[0] - b[0] );
        minHeap.add(new Integer[] { grid[0][0], 0, 0 });
        int result = 0;
        while (!minHeap.isEmpty()) {
            var curr = minHeap.remove();
            result  = Math.max(result, curr[0]);
            if (curr[1] == n - 1 && curr[2] == n - 1) break;

            for (int i = 0; i < 4; i++) {
                int x = curr[1] + dirs[i][0];
                int y = curr[2] + dirs[i][1];
                if (x < 0 || x >= n || y < 0 || y >= n || seen[x][y]) {
                    continue;
                }
                minHeap.add(new Integer[] { grid[x][y], x, y });
                seen[x][y] = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph_RisingWater a1 = new Graph_RisingWater();
        int[][] grid = new int[][] {{0,2}, {1,3}};
        System.out.println(a1.swimInWater(grid));
    }
}
