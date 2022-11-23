import java.util.Stack;

class Trees_MaxDepthOfTree {
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

    public int maxDepth(TreeNode root) {
          class TreeStack {
              TreeNode node;
              int depth;
              TreeStack(TreeNode node, int depth) {this.node = node; this.depth = depth; }
          }
        Stack<TreeStack> stacker = new Stack<>();
          stacker.add(new TreeStack(root,1));
          int res = 0;

          while (!stacker.isEmpty()) {
              TreeStack temp = stacker.pop();
              TreeNode node = temp.node;
              int depth = temp.depth;

              if (node != null ) {
                  res = Math.max(res,depth);
                  stacker.add(new TreeStack(node.left,depth + 1));
                  stacker.add(new TreeStack(node.right, depth + 1));
              }
          }
          return res;
    }

    public static void main (String[] args) {
        Trees_MaxDepthOfTree a1 = new Trees_MaxDepthOfTree();
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.maxDepth(root));
    }
}
