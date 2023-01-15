import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Backtracking_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backtrack(resultSet, nums, 0);
        return resultSet;
    }

    public void backtrack (List<List<Integer>> resultSet, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (Integer n : nums) list.add(n); System.out.println("added: " + list);
            resultSet.add(list);
        }
        for (int i = start; i < nums.length; i++) {
            if (start != i) swap (nums, start, i);
            backtrack(resultSet, nums, start + 1);
            if (start != i) swap (nums, start, i);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Backtracking_Permutations a1 = new Backtracking_Permutations();
        List<List<Integer>> rez = a1.permute(new int[ ] {1,2,3});
        for (List<Integer> a : rez) {
            System.out.println(a);
        }
    }
}
