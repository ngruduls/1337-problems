import java.util.HashMap;
import java.util.Map;

public class Dynamic2D_StringsubStrings {
    private Map<Pair, Integer> memo;

    class Pair {
        Integer i;
        Integer j;
        Pair(Integer i, Integer j) { this.i = i; this.j = j; }
    }

    private int recurse (String s, String t, int i, int j) {
        int M = s.length();
        int N = t.length();

        // Base case
        if (i == M || j == N || M - i < N - j) {
            return j == t.length() ? 1 : 0;
        }

        Pair key = new Pair(i, j);

        // check to see if result for this recursive call is already cached
        if (memo.containsKey(key)) {
            return this.memo.get(key);
        }

        // this result is always needed
        int ans = this.recurse(s, t, i + 1, j);
        if (s.charAt(i) == t.charAt(j)) { int rez = this.recurse(s, t, i + 1, j + 1);
            ans += rez; };

        this.memo.put(key, ans);
        return ans;
    }

    public int numDistinct(String s, String t) {
        this.memo = new HashMap<Pair, Integer>();
        return this.recurse(s, t, 0, 0);
    }

    public static void main(String[] args) {
        Dynamic2D_StringsubStrings a1 = new Dynamic2D_StringsubStrings();
        System.out.println(a1.numDistinct("rabbbit", "rabbit"));
    }
}
