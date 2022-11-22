import java.util.Stack;

class Trees_InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
          if (root == null) return null;
          TreeNode node = new TreeNode(root.val);

          node.left = invertTree(root.right);
          node.val = root.val;
          node.right = invertTree(root.left);
          return node;
    }

    public static void main (String[] args) {
        Trees_InvertBinaryTree a1 = new Trees_InvertBinaryTree();
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        a1.printTree(root);
        TreeNode newTree = a1.invertTree(root);System.out.println();
        a1.printTree(newTree);
    }
}
