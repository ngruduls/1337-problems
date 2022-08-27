import java.util.ArrayList;
import java.util.List;

class GenerateParenthesis2 {
    ArrayList<String> res = new ArrayList<>();
    String stack = "";
    /*    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]*/
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n);
        return res;
    }

    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0) ? null : (s.substring(0,s.length() - 1));
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            res.add(stack);
        }
        if (openN < n) {
            stack += '(';
            backtrack(openN + 1, closedN, n);
            stack = removeLastChar(stack);
        }
        if (closedN < openN) {
            stack += ')';
            backtrack(openN, closedN + 1, n);
            stack = removeLastChar(stack);
        }
    }

    public static void main (String[] args) {
        GenerateParenthesis2 a1 = new GenerateParenthesis2();
        //System.out.println(a1.climbStairsDP(3));
        for (String parenthesis:a1.generateParenthesis(3)) {
            System.out.println(parenthesis);
        }
    }
}
