import java.util.*;

class Trees_GoodNodes {
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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int res = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        res += dfs(node.left, max);
        res += dfs(node.right, max);
        return res;
    }

    public static void main (String[] args) {
        Trees_GoodNodes a1 = new Trees_GoodNodes();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.goodNodes(root));
    }
}
