import java.util.HashSet;
import java.util.Locale;

class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int end = str.length() - 1;
        while (start < str.length()/2) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }

    public static void main (String[] args) {
        ValidPalindrome a1 = new ValidPalindrome();
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "aBBa";
        System.out.println(a1.isPalindrome(s1));
        System.out.println(a1.isPalindrome(s2));
    }
}
