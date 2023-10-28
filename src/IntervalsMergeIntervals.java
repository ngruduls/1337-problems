import java.util.ArrayList;
import java.util.Arrays;

public class IntervalsMergeIntervals {
    public int[][] merge (int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            if (curStart <= ans.get(ans.size() - 1)[1]) {
                // do the merging
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        return res;
    }

    public static void sortArrayByFirstElement(int[][] array) {
        int[][] sortedArray = new int[array.length][];

        // Initialize the sorted array with a default value
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = null;
        }

        for (int i = 0; i < array.length; i++) {
            int[] currentArray = array[i];

            // compare the first element of the current array to the first element of the sorted array
            int j = 0;
            while (j < sortedArray.length && sortedArray[j] != null && sortedArray[j][0] < currentArray[0]) {
                j++;
            }
            // insert the current array into the sorted array at the current index - right spot
            for (int k = sortedArray.length - 2; k >= j; k--) {
                sortedArray[k + 1] = sortedArray[k];
            }
            sortedArray[j] = currentArray;
        }
        array = sortedArray;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        IntervalsMergeIntervals a1 = new IntervalsMergeIntervals();
        for (int[] interval : a1.merge(intervals)) {
            System.out.println(interval[0] + "," +  interval[1]);
        }
    }
}
