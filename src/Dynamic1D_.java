public class Dynamic1D_ {
    //top down with memoization
//    public int numDecodings(String s) {
//        return numDecodings(s, 0, new Integer[s.length()]);
//    }
//
//    private int numDecodings(String s, int i, Integer[] dp) {
//        if (i == s.length()) return 1;
//        if (s.charAt(i) == '0') return 0;
//        if (dp[i] != null) return dp[i];
//        int count = 0;
//        count += numDecodings(s, i + 1, dp);
//        if ( i < s.length() - 1 &&
//                (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7') ) {
//            count += numDecodings(s, i + 2, dp);
//        }
//        dp[i] = count;
//        return dp[i];
//    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;//empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

//    public int numDecodings(String s) {
//        //int[] dp = new int[s.length() + 1];
//        int twoBack = 1;
//        int oneBack = s.charAt(0) == '0' ? 0 : 1;
//        int current = oneBack;
//        for (int i = 2; i < s.length() + 1; i++) {
//            current = 0;
//            if (s.charAt(i - 1) != '0') {
//                current += oneBack;
//            }
//            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')  {
//                current += twoBack;
//            }
//            twoBack = oneBack;
//            oneBack = current;
//        }
//        return current;
//    }

    public static void main(String[] args) {
        Dynamic1D_ a1 = new Dynamic1D_();
        String s = "226";
        int rez = a1.numDecodings(s);
        System.out.println(rez);
    }
}
