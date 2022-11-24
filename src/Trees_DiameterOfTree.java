import java.util.Stack;

class Trees_DiameterOfTree {
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
int result = -1;
    public int diameterOfBinaryTree(TreeNode root) {
          int deepest_depth = dfs(root);
          return result;
    }

    private int dfs (TreeNode current) {
          if (current == null) return -1;
          int left = 1 + dfs(current.left);
          int right = 1 + dfs(current.right);
          result = Math.max(result, (left + right)) ;
          return Math.max(left,right);//height
    }

    public static void main (String[] args) {
        Trees_DiameterOfTree a1 = new Trees_DiameterOfTree();
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.diameterOfBinaryTree(root));
    }
}
