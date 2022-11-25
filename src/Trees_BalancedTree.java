class Trees_BalancedTree {
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
    private Pair dfs(TreeNode root){
        if (root == null) { return new Pair(true, 0); }
        var left = dfs(root.left);
        var right = dfs(root.right);
        var balanced = left.balanced && right.balanced && (Math.abs(left.height - right.height) <= 1 );
        return new Pair(balanced, 1 + Math.max(left.height, right.height) );
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    public static void main (String[] args) {
        Trees_BalancedTree a1 = new Trees_BalancedTree();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.isBalanced(root));
    }
}
