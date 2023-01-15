import java.util.ArrayList;
import java.util.List;

public class Backtracking_Combinations {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allSets = new ArrayList<List<Integer>>();
        List<Integer> currentPermutation = new ArrayList<>();
        backtrack(candidates, target, allSets, currentPermutation, 0);
        return allSets;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> allSets, List<Integer> currentPermutation,
                          int index) {
        if (target == 0) allSets.add(new ArrayList<Integer>(currentPermutation));
        else if (target < 0 || index >= candidates.length) return;
        else {
            currentPermutation.add(candidates[index]);
            backtrack(candidates, target - candidates[index], allSets, currentPermutation, index);

            currentPermutation.remove(currentPermutation.size() - 1);
            backtrack(candidates, target, allSets, currentPermutation, index + 1);
        }
    }

    public static void main(String[] args) {
        Backtracking_Combinations a1 = new Backtracking_Combinations();
        List<List<Integer>> rez = a1.combinationSum(new int[ ] {2,3,6,7}, 7);
        for (List<Integer> a : rez) {
            System.out.println(a);
        }
    }
}
