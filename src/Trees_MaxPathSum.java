import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Trees_MaxPathSum {
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

        printTree(root.right);
        System.out.print(root.val + " ");
        printTree(root.left);
        return;
    }

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        maxLeft = Math.max (0, maxLeft);
        maxRight = Math.max (0, maxRight);

        int maxWithBothSides = node.val + maxLeft + maxRight;
        res = Math.max(res, maxWithBothSides);

        int maxOneSidePath = node.val + Math.max(maxLeft, maxRight);

        return maxOneSidePath;
    }

    public static void main (String[] args) {
        Trees_MaxPathSum a1 = new Trees_MaxPathSum();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        a1.printTree(root);System.out.println();
        System.out.println(a1.maxPathSum(root));

    }
}
