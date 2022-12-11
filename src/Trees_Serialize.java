import java.util.ArrayList;
import java.util.List;

class Trees_Serialize {
    /**
     * Definition for singly-linked list. */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right;}
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        TreeNode node = new TreeNode(root.val);

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
        return;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeDfs(root,list);
        return String.join(",",list);
    }
    private int i;
    public void serializeDfs(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("N"); return;
        }
        list.add(String.valueOf(node.val));
        serializeDfs(node.left, list);
        serializeDfs(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDfs(tokens);
    }

    private TreeNode deserializeDfs(String[] tokens) {
        String token = tokens[i];
        if (token.equals("N")) {
            i++; return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        i++;
        node.left = deserializeDfs(tokens);
        node.right = deserializeDfs(tokens);
        return node;
    }

    public static void main (String[] args) {
        Trees_Serialize a1 = new Trees_Serialize();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        a1.printTree(root);System.out.println();
        String tree = a1.serialize(root);
        System.out.println(tree);
        System.out.println(a1.deserialize(tree));
    }
}
