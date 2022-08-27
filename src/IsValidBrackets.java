import java.util.ArrayList;
import java.util.HashMap;

class IsValidBrackets {

    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        ArrayList<Character> stack = new ArrayList<Character>();

        for (Character c : s.toCharArray()) {
            // opening
            if (map.containsValue(c)) {
                stack.add(c);
            } else if (stack.isEmpty() || stack.get(stack.size()-1) != map.get(c))  {
                return false;
            } else {
                stack.remove(stack.size()-1);
            }
        }
        return stack.isEmpty();
    }

    public static void main (String[] args) {
        IsValidBrackets a1 = new IsValidBrackets();
        String s1 = "()[]{}";
        System.out.println(a1.isValid(s1));
    }
}
