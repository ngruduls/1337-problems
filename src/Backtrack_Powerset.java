import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtrack_Powerset {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        subSet(nums, 0, powerset, set);
        return powerset;
    }

    public void subSet(int[] nums, int idx_start, List<List<Integer>> powerset, List<Integer> currentSet) {
        powerset.add(new ArrayList<>(currentSet)); System.out.println("powerset add:" + currentSet);
        for (int i = idx_start; i < nums.length; i++ ) {
            if (i > idx_start && nums[i] == nums[i - 1] ) continue;
            currentSet.add(nums[i]);p1(currentSet);
            subSet(nums, i + 1, powerset, currentSet);
            p1(currentSet);currentSet.remove(currentSet.size() - 1);p1(currentSet);
        }
        return;
    }
    private void p1(List<Integer> set) {
        System.out.println("Current set:" + set);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Backtrack_Powerset a1 = new Backtrack_Powerset();
        List<List<Integer>> powerset = a1.subsetsWithDup(nums);
        for (List<Integer> cur : powerset) {
            System.out.println(cur);
        }
    }
}