import java.util.ArrayList;
import java.util.List;

public class Graph_CheckTree {
    public boolean validTree(int n, int[][] edges) {

        // Condition 1: The graph must contain n - 1 edges
        if (edges.length != n - 1) {   return false; }

        // Condition 2 : The graph must contain a single connected component
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.merge(A, B)) {
                return false;
            }
        }
        // if got here, no cycle
        return true;
    }

    public static void main(String[] args) {
        Graph_CheckTree a1 = new Graph_CheckTree();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(a1.validTree(5, edges));
    }
}
