import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs.length == 0) return res;

        HashMap<String, List<String>> buckets = new HashMap<>();

        for (String s : strs) {
            int[] chars = new int[26];
            for (char c : s.toCharArray()) {
                chars[c - 'a'] ++;
            }
            String key = Arrays.toString(chars);
            List<String> localList;
            if (!buckets.containsKey(key)) {
                localList = new ArrayList<String>();
            } else {
                localList = buckets.get(key);
            }
            localList.add(s);
            buckets.put(key,localList);
        }
        res.addAll(buckets.values());
        return res;
    }

    public static void main (String[] args) {
        groupAnagram a1 = new groupAnagram();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = new ArrayList<>();
        res = a1.groupAnagrams(strs);
        System.out.println(res);
    }
}
