import java.util.*;

class Trees_Kth_smallest {
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.add(curr);
                curr= curr.left;
            }
            curr= stack.pop();
            k = k-1;
            if (k==0) return curr.val;
            curr= curr.right;
        }
        return curr.val;
    }

        int k;
    public int kthSmallest2(TreeNode root, int k) { this.k = k;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int rez = list.get(list.size()-1);
        return rez;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inorder(node.left, list);
        if (list.size() >= k) return;
        list.add(node.val);
        if (list.size() >= k) return;
        inorder(node.right,list);
    }

    public static void main (String[] args) {
        Trees_Kth_smallest a1 = new Trees_Kth_smallest();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        System.out.println(a1.kthSmallest(root, 1));

    }
}
