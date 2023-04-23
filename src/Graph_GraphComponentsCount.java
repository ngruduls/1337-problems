public class Graph_GraphComponentsCount {
    private int[] parent;
    private int[] size;

    private int find(int node) {
        int result = node;

        while (parent[result] != result) {
            parent[result] = parent[parent[result]];
            result = parent[result];
        }
        return result;
    }

    private int union(int n1, int n2) {
        int p1 = this.find(n1);
        int p2 = this.find(n2);

        if (p1 == p2) { return 0; }

        if (size[p2] > size[p1]) {
            parent[p1] = p2;
            size[p2] += size[p1];
        } else {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
        return 1;
    }

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int result = n;
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1]) == 1) {
                result--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}}; //[[0,1],[1,2],[3,4]]
        Graph_GraphComponentsCount a1 = new Graph_GraphComponentsCount();
        System.out.println(a1.countComponents(n, edges));
    }
}
