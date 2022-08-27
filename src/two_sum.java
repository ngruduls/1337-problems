import java.util.HashMap;

class two_sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // [2,7,11,15] target - 26
        for (int i = 0; i < nums.length; i++) {
            if ( map.containsKey(target - nums[i]) ) {
                return new int[]{ map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main (String[] args) {

        two_sum s1 = new two_sum();
        int[] rez = s1.twoSum(new int []{1,2,3,98}, 6);
        for (int i : rez) {
            System.out.println(i + " ");
        }
    }
}
