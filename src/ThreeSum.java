import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && (nums[i] == nums[i-1]) ) continue;
            //two-sum
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]); tuple.add(nums[left]); tuple.add(nums[right]);
                    res.add(tuple);
                    while (left < right && (nums[left]  == nums[left +1]) ) left++;
                    while (left < right && (nums[right] == nums[right-1]) ) right--;
                    left++; right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

    public static void main (String[] args) {
        ThreeSum a1 = new ThreeSum();
        int[] numbers = {-1,0,1,2,-1,-4};
        int[] numbers2 = {-1,-1,0,1,2,-1,-4};
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        res = a1.threeSum(numbers2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
