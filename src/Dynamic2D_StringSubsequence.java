public class Dynamic2D_StringSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        String a = text1  ; String b = text2;
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        Dynamic2D_StringSubsequence a1 = new Dynamic2D_StringSubsequence();
        String text1 = "abcde", text2 = "ace";
        System.out.println(a1.longestCommonSubsequence(text1, text2));
    }
}
