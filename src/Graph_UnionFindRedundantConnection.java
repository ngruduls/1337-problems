import java.util.Arrays;

public class Graph_UnionFindRedundantConnection {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) parent[i] = i;
        rank = new int[edges.length];

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) return edge;
            else union(
                    edge[0],
                    edge[1]
            );
        }
        // should never happen
        return new int[2];
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }

    public static void main(String[] args) {
        Graph_UnionFindRedundantConnection a1 = new Graph_UnionFindRedundantConnection();
        int[][] input = new int[][]{ {1,2}, {1,3}, {2,3} };
        System.out.print(Arrays.toString(a1.findRedundantConnection(input)) );
    }
}
