enum Result { TRUE, FALSE }

public class Dynamic2D_PatternMatching {
    // does text i and pattern j match
    Result[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp (0, 0, s, p);
    }

    public boolean dp (int textIndex, int patternIndex, String text, String pattern) {
        if (memo[textIndex][patternIndex]!= null) {
            return memo[textIndex][patternIndex] == Result.TRUE;
        }
        boolean rez;
        if (patternIndex == pattern.length()) {
            rez = textIndex == text.length();
        } else {
            boolean first_match = ( textIndex < text.length() &&
                    (pattern.charAt(patternIndex) == text.charAt(textIndex) ||
                            pattern.charAt(patternIndex) == '.'));
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                boolean ignorePattern = dp(textIndex, patternIndex+2, text, pattern);
                boolean keepAlive = first_match && dp (textIndex + 1, patternIndex, text, pattern);
                rez = ignorePattern || keepAlive;
            } else {
                rez = first_match && dp (textIndex + 1, patternIndex + 1, text, pattern);
            }
        }
        memo[textIndex][patternIndex] = rez ? Result.TRUE : Result.FALSE;
        return rez;
    }

    public static void main(String[] args) {
        Dynamic2D_PatternMatching a1 = new Dynamic2D_PatternMatching();
        System.out.println(a1.isMatch("aaacc", "a*b*c*"));
    }
}
