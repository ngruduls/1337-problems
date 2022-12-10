import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Trees_Reconstruct {
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
    class Pair {
        Boolean balanced;
        Integer height;
        Pair(Boolean bool, Integer h) { this.balanced = bool; this.height = h; }
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)  return null;
        TreeNode root = new TreeNode (preorder[0]);
        int mid = 0;
        for (int i =0 ; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {mid = i;break;}
        }
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );
        return root;
    }

    Map<Integer,Integer> inorderPositions = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;
        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }
        return builder(preorder,0,0,inorder.length - 1);
    }

    public TreeNode builder (int[] preorder, int currentPreorderIndex, int low, int hi) {
        if (currentPreorderIndex > preorder.length - 1 || low > hi) return null;
        int curr = preorder[currentPreorderIndex];
        TreeNode n = new TreeNode(curr);
        int mid = inorderPositions.get(curr);
        n.left = builder(preorder, currentPreorderIndex + 1, low, mid - 1);
        n.right = builder(preorder, currentPreorderIndex + (mid - low) + 1, mid + 1, hi);
        return n;
    }

    public static void main (String[] args) {
        Trees_Reconstruct a1 = new Trees_Reconstruct();
        TreeNode root = null;

        int[] preorder = {3,9,20,15,7}; int[] inorder = {9,3,15,20,7};

        //a1.printTree(root);
        //System.out.println();
        System.out.println(root = a1.buildTree(preorder,inorder));
        a1.printTree(root);
    }
}
