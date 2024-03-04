import java.util.ArrayList;
import java.util.Arrays;

public class IntervalsRemoveOverlapping {

    public int eraseOverlapIntervals(int[][] intervals) {
        int removedCount = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
        }

        int lastComparisonIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[lastComparisonIndex][1]) {
                // remove the largest end
                if (intervals[i][1] > intervals[lastComparisonIndex][1]) {
                    lastComparisonIndex = lastComparisonIndex;
                } else {
                    lastComparisonIndex = i;
                }
                removedCount++;
            } else {
                ans.add(intervals[lastComparisonIndex]);
                lastComparisonIndex = i;
            }
        }

        System.out.println("-----------------------------------------------");
        ans.add(intervals[lastComparisonIndex]);

        for (int i = 0; i < ans.size(); i++) {
            System.out.println("[" + ans.get(i)[0] + ", " + ans.get(i)[1] + "]");
        }

        return removedCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        IntervalsRemoveOverlapping a1 = new IntervalsRemoveOverlapping();
        System.out.println(a1.eraseOverlapIntervals(intervals));
//        for (int[] interval : a1.merge(intervals)) {
//            System.out.println(interval[0] + "," +  interval[1]);
//        }
    }
}
