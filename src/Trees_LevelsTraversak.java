import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Trees_LevelsTraversak {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null ) return res;

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelIntegers = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                levelIntegers.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(levelIntegers);
        }
        return res;
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
        Trees_LevelsTraversak a1 = new Trees_LevelsTraversak();
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

        List<List<Integer>> lists = a1.levelOrder(root);

        for (List<Integer> list: lists) {
            for(int listElem : list ) {
                System.out.print(listElem + " ");
            } System.out.println();
        }
    }
}
