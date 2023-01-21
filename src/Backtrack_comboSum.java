import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtrack_comboSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();
        combinations(candidates, target, resultSet, currentList, 0);
        return resultSet;
    }

    public void combinations(int[] candidates, int target, List<List<Integer>> resultSet,
                             List<Integer>currentList, int index_from) {
        if (target == 0) {
            resultSet.add(new ArrayList(currentList));
        } else if (target < 0 )  {
            return;
        } else {
            for (int currentIndex = index_from; currentIndex < candidates.length; currentIndex++) {
                if (currentIndex > index_from && candidates[currentIndex] == candidates[currentIndex - 1]) continue;
                currentList.add(candidates[currentIndex]);
                combinations(candidates, target - candidates[currentIndex], resultSet, currentList, currentIndex + 1);
                currentList.remove(currentList.get(currentList.size() - 1));
            }
        }
        return;
    }

    public static void main(String[] args) {
        Backtrack_comboSum a1 = new Backtrack_comboSum();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> rez = a1.combinationSum2(candidates, target);
        for (List<Integer> cur : rez) {
            System.out.println(cur);
        }
    }
}
