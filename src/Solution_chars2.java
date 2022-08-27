import java.util.ArrayList;

class Solution_chars2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int char_num = s.charAt(i);
            store[s.charAt(i) - 'a'] ++;
            store[t.charAt(i) - 'a'] --;
        }

        for (int n : store) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {

        Solution_chars2 s1 = new Solution_chars2();
        System.out.println(s1.isAnagram("ant", "tna"));
    }
}
