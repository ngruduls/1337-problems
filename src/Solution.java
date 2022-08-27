import java.util.LinkedList;
import java.util.Queue;

    class Solution {
        public int orangesRotting(int[][] grid) {
            if(grid==null || grid.length == 0) return -1;

            int totalFreshOranges = 0;
            // Implement a BFS algorithm
            // BFS uses Queue & it implements it as a linkedlist
            Queue<int[]> queue = new LinkedList();
            int numberOfRows = grid.length, numberOfColumns = grid[0].length;

            for(int r = 0; r < numberOfRows; r++) {
                for(int c = 0; c < numberOfColumns; c++) {
                    if(grid[r][c] == 2) {
                        queue.offer(new int[] {r,c});
                    }
                    else if(grid[r][c]==1) totalFreshOranges++;
                }
            }

            int minutes = 0;
            int dirs[][] = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

            while(!queue.isEmpty() && totalFreshOranges > 0) {
                int size = queue.size();
                for(int i = 0;i<size;i++){
                    int[] pair = queue.poll();
                    int row = pair[0];
                    int col = pair[1];
                    for(int[] dir:dirs){
                        int r = row+dir[0];
                        int c = col+dir[1];
                        if(r < 0 || r >= numberOfRows || c < 0
                                || c >= numberOfColumns || grid[r][c] == 0 || grid[r][c] == 2)
                            continue;

                        // mark as a visited
                        grid[r][c] = 2;
                        queue.add(new int[] {r,c});
                        totalFreshOranges--;
                    }
                }
                minutes++;
            }
            return totalFreshOranges == 0? minutes : -1;
        }

        public static void main (String[] args) {

            Solution s1 = new Solution();
            System.out.println(s1.orangesRotting(new int [][] {{2,1,1},{0,1,1},{1,0,1}}));
            System.out.println(s1.orangesRotting(new int [][] {{2,1,1}, {1,1,0}, {0,1,1}}));
        }
    }
