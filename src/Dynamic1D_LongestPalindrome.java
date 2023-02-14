public class Dynamic1D_LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0, right = 1, max = 0;
        var A = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    A[i][j] = true; System.out.println(s.substring(i,j+1));
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        A[i][j] = true; System.out.println(s.substring(i,j+1));
                    } else {
                        A[i][j] = A[i + 1][j - 1]; if (A[i][j]) {System.out.println(s.substring(i,j+1));}
                    }
                }

                if (A[i][j] && j - i + 1 > max ) {
                    max = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }

        return s.substring(left,right);
    }

    public static void main(String[] args) {
        Dynamic1D_LongestPalindrome a1 = new Dynamic1D_LongestPalindrome();
        System.out.println(a1.longestPalindrome("bananas"));
        System.out.println("nauris".substring(0,3));
    }
}
