import java.util.HashSet;

class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1cnt = new int[26];
        int[] s2cnt = new int[26];
        int matches = 0;
        for (int i = 0; i < s1.length(); i++) {
            s1cnt[s1.charAt(i) - 'a'] += 1;
            s2cnt[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) { if (s1cnt[i] == s2cnt[i]) matches++; }
        for (int left = 0,right = s1.length(); right < s2.length(); right++,left++) {
            if (matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            s2cnt[index] += 1;
            if (s1cnt[index] == s2cnt[index]) {
                matches += 1;
            } else if (s1cnt[index] + 1 == s2cnt[index]) { // if it was matching but no longer is
                matches -= 1;
            }

            index = s2.charAt(left) - 'a';
            s2cnt[index] -= 1;
            if (s1cnt[index] == s2cnt[index]) {
                matches += 1;
            } else if (s1cnt[index] - 1 == s2cnt[index]) {
                matches -= 1;
            }
        }
        return matches == 26;
    }

    public static void main (String[] args) {
        PermutationInString a1 = new PermutationInString();
        String s1 = "ab", s2 = "aaeba";
        System.out.println(a1.checkInclusion(s1,s2));
    }
}
