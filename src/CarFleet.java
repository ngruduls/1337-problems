import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) return 1;
        Stack<Double> stack = new Stack<>();
        int[][] zip = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            zip[i][0] = position[i];
            zip[i][1] = speed[i];
        }
        Arrays.sort(zip, (a1,a2) -> a1[0]-a2[0]);
        for (int i = zip.length - 1; i >= 0; i--) {
            double timeToTarget = (double) (target - zip[i][0]) / zip[i][1];
            if (!stack.isEmpty() && timeToTarget <= stack.peek()) {
                // finish out before the previous car on the road
                continue;
            } else {
                stack.push(timeToTarget);
            }
        }
        return stack.size();
    }

    public static void main (String[] args) {
        CarFleet a1 = new CarFleet();
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(a1.carFleet(12,position,speed));
    }
}
