class Trees_SubtreeOfAnotherTree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        boolean same = isSameTree(root,subRoot);
        if (same) { return true; }
        boolean one = isSubtree(root.left, subRoot); if (one) return true;
        boolean two = isSubtree(root.right, subRoot); if (two) return true;
        return one || two;
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            return (isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right) );
        } return false;
    }

    public static void main (String[] args) {
        Trees_SubtreeOfAnotherTree a1 = new Trees_SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subroot = new TreeNode(4);
        subroot.left = new TreeNode(1);
        subroot.right = new TreeNode(2);

        a1.printTree(root); System.out.println(); a1.printTree(subroot);System.out.println();
        System.out.println(a1.isSubtree(root,subroot));
    }
}
