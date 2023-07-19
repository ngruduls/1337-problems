public class UnionFind {

    private int[] parent;
    private int[] size;

    public UnionFind(int n ) {
        // all are parents of themselfves
        parent = new int [n];
        size = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            size[node] = 1;
        }
    }

    public int find(int A) {
        // step 1 - find the root
        int root = A;
        while (parent[A] != A) {
            root = parent[A];
        }
        // do second run and compress paths, point all nodes to A
        while (A != root) {
            int oldRoot = parent[A];
            parent[A] = root;
            A = oldRoot;
        }
        return root;
    }

    public boolean merge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) { return false; }

        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }

}
