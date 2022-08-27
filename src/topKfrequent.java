import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class topKfrequent {

    public int[] topKFrequent(int[] nums, int k) {
        //[1,1,1,2,2,3], k = 2 => [1,2]
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        //int[][] frequencies = new int[nums.length][]; // array of arrays
        ArrayList<Integer> [] frequencies = new ArrayList[nums.length+1];
        for (int x = 0; x < nums.length+1; x++) {frequencies[x] = new ArrayList<Integer>();}

        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num,1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            List<Integer> lst;
            lst = frequencies[cnt];
            lst.add(num);
        }
        int[] res = new int[k];
        List<Integer> lst = new ArrayList<>();
        for (int i = frequencies.length -1; i > 0; i--) {
            // output k elements
            if (!frequencies[i].isEmpty()) {
                for (int j = 0; j < frequencies[i].size(); j++) {
                    lst.add(frequencies[i].get(j));
                    if (lst.size() == k) {
                        for (int z = 0; z < k; z++) {
                            res[z] = lst.get(z);
                        }
                        return res;
                    }
                }
            }
            if (lst.size() == k) break;
        }
        for (int i = 0; i < k; i++) {
            res[i] = lst.get(i);
        }
        return res;
    }

    public static void main (String[] args) {
        topKfrequent a1 = new topKfrequent();
        //String[] strs = {"eat","tea","tan","ate","nat","bat"};
        //int[] nums = {1,1,1,2,2,3};
        int[] nums = {1,2};
        int k = 2;
        int[] res = a1.topKFrequent(nums,k);
        for (int i = 0 ; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
