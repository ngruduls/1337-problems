import java.util.ArrayList;
import java.util.List;

public class Backtrack_PalindromeSubstrings  {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s.equals("")) { res.add(new ArrayList<String>()); return res; }
        for (int indexUntil = 0; indexUntil < s.length(); indexUntil++) {
            if (isPalindrome(s, indexUntil + 1)) {
                List<List<String>> partitions = partition(s.substring(indexUntil + 1, s.length()));
                for (List<String> list : partitions) {
                    list.add(0, s.substring(0, indexUntil + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome (String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Backtrack_PalindromeSubstrings a1 = new Backtrack_PalindromeSubstrings();
        List<List<String>> res = a1.partition("baa");
        for (List<String> listItem : res) {
            System.out.println(listItem);
        }
    }
}
