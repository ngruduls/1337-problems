import java.util.*;

public class CloneGraph {

    public HashMap<Integer,Node> map = new HashMap<Integer, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, newNode);
        for (Node neighbor : node.neighbors ) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    public static void main(String[] args) {
        CloneGraph a1 = new CloneGraph();

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(three);
        three.neighbors.add(four);

        Node graph = a1.cloneGraph(one);
        Deque<Node> bfs  = new ArrayDeque<Node>();
        bfs.add(graph);
        while (!bfs.isEmpty()) {
            Node curr = bfs.pop();
            System.out.println(curr.val);
            for (Node neighbor : curr.neighbors) {
                bfs.addLast(neighbor);
            }
        }

    }

}
