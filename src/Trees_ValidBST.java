class Trees_ValidBST {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean rez = dfs(root, null, null);
        return rez;
    }

    private boolean dfs(TreeNode node, Integer leftBoundary, Integer rightBoundary) {
        if (node == null) return true;

        if ( ((rightBoundary != null) && rightBoundary <= node.val) || ( (leftBoundary != null) && node.val <= leftBoundary )) {
            return false;
        }
        boolean leftOK = dfs (node.left, leftBoundary, node.val);
        boolean rightOK = dfs (node.right, node.val, rightBoundary);
        return leftOK && rightOK;
    }

    public static void main (String[] args) {
        Trees_ValidBST a1 = new Trees_ValidBST();
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.isValidBST(root));
    }
}
