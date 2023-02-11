import java.util.Arrays;

public class Dynamic1D_HouseRob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                robHelper(nums, 0, nums.length - 2),
                robHelper(nums, 1, nums.length - 1)
        );
    }
    public int robHelper(int[]nums, int start, int end) {
        int rob1 = 0; int rob2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                robHelperWithArray(Arrays.copyOfRange(nums,0,nums.length - 1)),
                robHelperWithArray(Arrays.copyOfRange(nums,1,nums.length - 0))
        );
    }
    public int robHelperWithArray(int[] nums) {
        int len = nums.length-1;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] robResult = new int[nums.length];
        robResult[0] = nums[0];
        robResult[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= len; i++) {
            int robHere = robResult[i - 2] + nums[i];
            int robNotHere = robResult[i - 1];
            int maxRobHere = Math.max(robHere, robNotHere);
            robResult[i] = maxRobHere;
        }
        return robResult[nums.length - 1];
    }

    public static void main(String[] args) {
        Dynamic1D_HouseRob2 a1 = new Dynamic1D_HouseRob2();
        int[] nums = {1,3,1,3,100};
        System.out.println(a1.rob2(nums));
    }
}
