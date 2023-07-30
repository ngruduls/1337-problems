public class Greedy_MaxSubarray {

    public int maxSubArray(int [] nums) {
        if (nums.length == 1) return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int n : nums ) {
            sum += n;
            max = Math.max(max, sum) ;
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Greedy_MaxSubarray a1 = new Greedy_MaxSubarray();
        System.out.println(a1.maxSubArray(new int [] {-7, -3, -6, -5}));
    }
}
