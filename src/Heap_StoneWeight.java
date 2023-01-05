import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class Heap_StoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int stone : stones) maxHeap.add(stone);
        //for (int i = 0 ; i < maxHeap.size(); i ++ ) System.out.println(maxHeap.poll());
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2= maxHeap.poll();
            if (stone1 != stone2 ) maxHeap.add(stone1 - stone2);
        } return maxHeap.size() != 0 ? (maxHeap.poll()) : 0;
    }

    public static void main (String[] args) {
        Heap_StoneWeight a1 = new Heap_StoneWeight();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(a1.lastStoneWeight(stones));
    }
}
