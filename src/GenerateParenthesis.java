import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenerateParenthesis {
    ArrayList<String> res = new ArrayList<>();
    ArrayList<Character> stack = new ArrayList<>();
    /*    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]*/
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            String rez = "";
            for (int i = 0; i < stack.size(); i++) {
                rez += stack.get(i);
            }
            res.add(rez);
        }
        if (openN < n) {
            stack.add('(');
            backtrack(openN + 1, closedN, n);
            stack.remove(stack.size()-1);
        }
        if (closedN < openN) {
            stack.add(')');
            backtrack(openN, closedN + 1, n);
            stack.remove(stack.size()-1);
        }
    }

    public static void main (String[] args) {
        GenerateParenthesis a1 = new GenerateParenthesis();
        //System.out.println(a1.climbStairsDP(3));
        for (String parenthesis:a1.generateParenthesis(3)) {
            System.out.println(parenthesis);
        }
    }
}
