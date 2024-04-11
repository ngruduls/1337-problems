import java.util.Arrays;

public class JumpGame {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minJumps = new int[n];

        // Initialize with the maximum values.
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;  // Starting point

        for (int position = 0; position < n; position++) {
            // Not necessary to consider if this point is unreachable.
            if (minJumps[position] == Integer.MAX_VALUE) continue;

            for (int nextPosition = position + 1; nextPosition <= position + nums[position] && nextPosition < n; nextPosition++) {
                minJumps[nextPosition] = Math.min(minJumps[nextPosition], minJumps[position] + 1);
            }
        }

        return minJumps[n - 1];
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Minimum number of jumps: " + game.jump(nums)); // Expected: 2
    }
}