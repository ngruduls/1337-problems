class Trees_CommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (q.val < curr.val && p.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return curr;
    }

    public static void main (String[] args) {
        Trees_CommonAncestor a1 = new Trees_CommonAncestor();
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);


//        root.left = new TreeNode(2);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.lowestCommonAncestor(root, root.left, root.left.right).val );
    }
}
