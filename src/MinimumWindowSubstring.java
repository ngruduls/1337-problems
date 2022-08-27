import java.util.Arrays;
import java.util.HashMap;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        // initialize small
        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int left = 0;
        int min = s.length() + 1;
        int startIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                //trying to equalize to 0
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) matched++;
            }
            // move the tail
            while (matched == map.size()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    startIndex = left;
                }
                char pop = s.charAt(left++);
                if (map.containsKey(pop)) {
                    if (map.get(pop) == 0) matched--;
                    map.put(pop, map.get(pop) + 1);
                }
            }
        }
        return min > s.length() ? "" : s.substring(startIndex, startIndex + min);
    }

    public static void main (String[] args) {
        MinimumWindowSubstring a1 = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        //System.out.println(a1.climbStairsDP(3));
        System.out.println(a1.minWindow(s,t));
    }
}
