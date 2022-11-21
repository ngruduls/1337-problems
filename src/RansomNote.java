import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        char[] magazineArray = magazine.toCharArray();
        for (char c: magazineArray){
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.put(c,map.get(c)+1);
            }
        }
        for (char c: ransomNote.toCharArray()) {
            if (!map.containsKey(c)) return false;
            else {
                int count = map.get(c);
                count = count - 1;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c,count);
                }
            }
        }
        return true;
    }

    public static void main (String[] args) {
        RansomNote a1 = new RansomNote();
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(a1.canConstruct(ransomNote,magazine));
        //System.out.println(a1.climbStairsDP(3));
    }
}
