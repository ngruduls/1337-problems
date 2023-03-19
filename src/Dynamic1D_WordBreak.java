import java.util.List;

public class Dynamic1D_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        for (int i = 0; i < dp.length; i++) { dp[i] = false; }
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (
                        ( (i + word.length()) <= s.length() ) &&
                                ( s.substring(i, i + word.length()).equals(word) )
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Dynamic1D_WordBreak a1 = new Dynamic1D_WordBreak();
        System.out.println(a1.wordBreak("neetcode", List.of(new String[]{"neet", "leet", "code"})) );
    }
}
