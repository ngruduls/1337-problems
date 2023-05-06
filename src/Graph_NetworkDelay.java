import java.util.Arrays;

public class Graph_NetworkDelay {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Djikstra. n = nodes count, k = source node, times = edges
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            // copy of paths
            int[] temp = new int[n];
            temp = Arrays.copyOf(paths, paths.length);

            //loop through times
            for (int j = 0; j < times.length; j++) {
                int src = times[j][0];
                int trg = times[j][1];
                int time = times[j][2];
                if (temp[src - 1] != Integer.MAX_VALUE && //reachable
                    temp [src - 1] + time < temp[trg - 1]) { //new minimums
                    temp[trg - 1] = temp [src - 1] + time;
                }
            }
            paths = temp;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (paths[i] == Integer.MAX_VALUE) {
                return - 1;
            }
            result = Math.max(result, paths[i]);
        }
        return result;
    }
}
