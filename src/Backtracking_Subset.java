import java.util.ArrayList;
import java.util.List;

public class Backtracking_Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(rez, 0, nums, list);
        return rez;
    }

    public void helper(List<List<Integer>> rez, int start, int[] nums, List<Integer> list) {
        if (start == nums.length) rez.add(new ArrayList<>(list));
        else {
            list.add(nums[start]);

            helper(rez, start + 1, nums, list);
            list.remove(list.size() - 1);
            helper(rez, start + 1, nums, list);
        }
    }

    public static void main(String[] args) {
        Backtracking_Subset a1 = new Backtracking_Subset();
        System.out.println(a1.subsets(new int[]{1, 2, 3}));
    }
}
