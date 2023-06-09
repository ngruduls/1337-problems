import java.util.HashMap;

public class Dynamic2D_TargetEquation {
    public int[] nums;
    public int target;
    public HashMap<Pair,Integer> map;

    class Pair {
        Integer index;
        Integer total;
        Pair(Integer n, Integer h) { this.index = n; this.total = h; }
    }

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        map = new HashMap<>();
        return helper(0, 0);
    }

    public int helper(int idx, int currentTotal) {
        if (idx == nums.length) {
            if (target == currentTotal) return 1;
            else return 0;
        }
        if (map.containsKey(new Pair(idx, currentTotal))) {
            return map.get( new Pair(idx, currentTotal) );
        }
        int minus = helper(idx + 1, currentTotal - nums[idx]);
        int plus = helper(idx + 1, currentTotal + nums[idx]);
        Pair newPair = new Pair(idx, currentTotal);
        map.put(newPair, minus + plus);
        return map.get( newPair );
    }

    public static void main(String[] args) {
        Dynamic2D_TargetEquation a1 = new Dynamic2D_TargetEquation();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(a1.findTargetSumWays(nums, target));
    }
}
