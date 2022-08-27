import java.util.Arrays;

class ClimbingStairMinCost {

    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        res[cost.length] = 0;
        res[cost.length - 1] = cost[cost.length - 1];

        for (int i = cost.length - 2; i >= 0; i--) {
            res[i] = Math.min(cost[i] + res[i+1], cost[i] + res[i+2]);
        }
        return Math.min(res[0], res[1]);
    }

    public static void main (String[] args) {
        ClimbingStairMinCost a1 = new ClimbingStairMinCost();
        //System.out.println(a1.climbStairsDP(3));
        int[] stair = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(a1.minCostClimbingStairs(stair));
    }
}
