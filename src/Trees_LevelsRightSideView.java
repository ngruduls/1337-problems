import java.util.*;

class Trees_LevelsRightSideView {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list  = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                if (i == 0) list.add(cur.val);
                if (cur.right != null) q.add(cur.right);
                if (cur.left != null) q.add(cur.left);
            }
        }
        return list;
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
        Trees_LevelsRightSideView a1 = new Trees_LevelsRightSideView();
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(9);


        a1.printTree(root);
        System.out.println();
        //System.out.println(a1.isBalanced(root));

        List<List<Integer>> lists = a1.levelOrder(root);

        for (List<Integer> list: lists) {
            for(int listElem : list ) {
                System.out.print(listElem + " ");
            } System.out.println();
        }
        List<Integer> rightside = a1.rightSideView(root);
        for (int elem : rightside) {
            System.out.println(elem);
        }
    }
}
