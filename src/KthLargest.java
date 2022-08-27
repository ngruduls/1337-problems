import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    private Queue<Integer> heap;
    private int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        // create initial heap from the array
        heap = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int num : nums) {
            heap.add(num);
        }
        // pop out extra remainder of the elements
        while (heap.size() > capacity) {
            int dropped_elem = heap.poll();
            System.out.println("Dropping: " + dropped_elem);
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > capacity) { heap.poll(); }
        //System.out.println("Peeking: " + pq.peek());
        return heap.peek();
    }

    public static void main (String[] args) {
        int[] numbers = {4, 5, 8, 2};
        int target = 3;

        KthLargest a1 = new KthLargest(target, numbers);
        System.out.println(a1.add(3));   // return 4
        System.out.println(a1.add(5));   // return 5
        System.out.println(a1.add(10));  // return 5
        System.out.println(a1.add(9));   // return 8
        System.out.println(a1.add(4));   // return 8
    }
}
