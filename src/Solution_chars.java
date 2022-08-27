import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution_chars {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> s_chars = new ArrayList<Character>();

        if (s.length() != t.length()) return false;

        for (char c : s.toCharArray()) {
            s_chars.add(c);
        }
        for (char c : t.toCharArray()) {
            if (s_chars.remove(Character.valueOf(c)) == false) {
                return false;
            }
        }
        if (!s_chars.isEmpty()) return false;
        return true;
    }

    public static void main (String[] args) {

        Solution_chars s1 = new Solution_chars();
        System.out.println(s1.isAnagram("ant", "tna"));
    }
}
