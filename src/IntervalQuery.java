import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IntervalQuery {
    public static int[] minInterval(int[][] intervals, int[] queries) {
        // pair each query with its index and sort
        int[][] extendedQueries = new int [queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            extendedQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(extendedQueries, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[queries.length];
        int j = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] query : extendedQueries) {
            // Add all intervals starting before or at the query point to the heap
            while (j < intervals.length && intervals[j][0] <= query[0]) {
                heap.offer(new int[] {intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            // remove intervals that dont cover the query
            while (!heap.isEmpty() && heap.peek()[1] < query[0]) {
                heap.poll();
            }
            // the top of the heap is the smallest interval that covers the query
            result[query[1]] = heap.isEmpty() ? - 1 : heap.peek()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {4, 2, 3, 1, 5, 6};
        int[] answers = minInterval(intervals, queries);

        System.out.println("Query results:");
        for (int answer : answers) {
            System.out.println(answer);
        }
    }
}
