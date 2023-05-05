import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph_ConnectPrims {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0] ); //pq = edge weight, + index of next node
        pq.add(new int[] { 0,0 });
        int len = points.length;
        Set<Integer> visited = new HashSet<>();
        int cost = 0;

        while (visited.size() < len) {
            int[] arr = pq.remove();
            int weight = arr[0]; int currNode = arr[1];

            if (visited.contains(currNode)) continue;

            visited.add(currNode);
            cost += weight;

            for (int nextNode = 0; nextNode < len; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight =
                            Math.abs(points[nextNode][0] - points[currNode][0]) +
                                    Math.abs(points[nextNode][1] - points[currNode][1]);
                    pq.offer(new int[] { nextWeight, nextNode });
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Graph_ConnectPrims a1 = new Graph_ConnectPrims();
        int[][] points = new int[][] { {3,12}, {-2,5}, {-4,1} };

        System.out.println(a1.minCostConnectPoints(points));
    }
}
