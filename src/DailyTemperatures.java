import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class DailyTemperatures {

    //bottom up
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int [temperatures.length];
        ArrayList<ArrayList<Integer>> stack = new ArrayList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && (temperatures[i] > stack.get(stack.size()-1).get(0))) {
                int temp = stack.get(stack.size()-1).get(0);
                int index = stack.get(stack.size()-1).get(1);
                stack.remove(stack.size() - 1);
                res[index] = i - index;
            }
            stack.add(new ArrayList<>(Arrays.asList(temperatures[i],i)));
        }
        return res;
    }

    public static void main (String[] args) {
        DailyTemperatures a1 = new DailyTemperatures();
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(a1.dailyTemperatures(arr)));
        //System.out.println(a1.climbStairsDP(3));
    }
}
