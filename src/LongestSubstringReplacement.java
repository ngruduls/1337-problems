import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class LongestSubstringReplacement {

    public int maxValueFromMap(Map<Character,Integer> map) {
        int max = 0;
        for (int cnt : map.values()) {
            if (cnt > max) max = cnt;
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> counts = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character cur = s.charAt(right);
            if (!counts.containsKey(cur)) {
                counts.put(cur,1);
            } else {
                counts.put(cur, counts.get(cur) + 1);
            }
            while ((right - left + 1) - (maxValueFromMap(counts)) > k) {
                Character leftChar = s.charAt(left);
                counts.put(leftChar,counts.get(leftChar) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main (String[] args) {
        LongestSubstringReplacement a1 = new LongestSubstringReplacement();
        //String s = "AABABBBAA";
        String s =
                "AABABBA";
        int k = 1;
        System.out.println(a1.characterReplacement(s,k));
    }
}
