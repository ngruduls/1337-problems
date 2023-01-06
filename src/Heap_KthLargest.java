import java.util.Comparator;
import java.util.PriorityQueue;

class Heap_KthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k ) { minHeap.poll(); }
        }
        return minHeap.peek();
    }

    public static void main (String[] args) {
        Heap_KthLargest a1 = new Heap_KthLargest();
        int[] list = {1,2,3,5,6,4};
        int k = 2;
        System.out.println(a1.findKthLargest(list,k));
    }
}
