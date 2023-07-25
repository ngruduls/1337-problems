import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Intervals_MeetingRooms2 {
    public int minMeetingRooms (int [][] intervals) {
        if (intervals.length == 0 ) return 0;

        // min heap
        PriorityQueue<Integer> roomAllocator = new PriorityQueue<Integer>( new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        // sort the intervals by start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(final int[] a, final int[] b) {
                return a[0] - b[0];
            }
        });

        // add the first meeting
        roomAllocator.add(intervals[0][1]); // add end time

        //iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // if the room dues to fo free up thea earliest is free, assing that room to this meeting
            if (intervals[i][0] >= roomAllocator.peek()) {
                roomAllocator.poll();
            }

            // if a new room is to be assigned, we also add it to the heap. otherwise with updated end time (as it was just popped)
            roomAllocator.add(intervals[i][1]);
        }

        return roomAllocator.size();
    }

    public static void main(String[] args) {
        Intervals_MeetingRooms2 a1 = new Intervals_MeetingRooms2();
        System.out.println(
                a1.minMeetingRooms(new int [][] { {1,7}, {3,4}, {9,10} })
        );
    }
}
