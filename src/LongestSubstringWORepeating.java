import java.util.HashMap;
import java.util.HashSet;

class LongestSubstringWORepeating {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> letters = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            Character c = s.charAt(right);
            if (letters.containsKey(c) ) {
                left = Math.max(left, letters.get(c) + 1);
            }
            letters.put(c, right);
            result = Math.max(result, right - left + 1);
            right += 1;
        }
        return  result;
    }

    public static void main (String[] args) {
        LongestSubstringWORepeating a1 = new LongestSubstringWORepeating();
        String s = "pwwkew";
        String s1 = "bbb";
        String s2 = "abcabcbb";
        System.out.println(a1.lengthOfLongestSubstring(s));
        System.out.println(a1.lengthOfLongestSubstring(s1));
        System.out.println(a1.lengthOfLongestSubstring(s2));
    }
}
