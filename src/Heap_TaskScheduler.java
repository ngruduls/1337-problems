import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Heap_TaskScheduler {
    class QueuePair {
        Integer letterCount;
        Integer timeWhenReady;
        QueuePair(Integer num1, Integer num2) { this.letterCount = num1; this.timeWhenReady = num2; }
    }

    public int leastInterval(char[] tasks, int n) {if (n == 0) return tasks.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        Queue<QueuePair> cooldownQueue = new LinkedList<>();
        int[] alphabet = new int[26];
        for (char c : tasks) alphabet[c - 'A']++;
        for (int cnt : alphabet ) if (cnt > 0) maxHeap.add(cnt);
        int time = 0;
        while (!(maxHeap.isEmpty() && cooldownQueue.isEmpty())) {  time ++;
            if (!maxHeap.isEmpty()) {
                int letterCount = maxHeap.poll();
                if (letterCount - 1 > 0) {
                    cooldownQueue.add(new QueuePair(letterCount - 1, time + n));
                }
            }
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek().timeWhenReady == time)
                maxHeap.add(cooldownQueue.poll().letterCount);
        }
        return time;
    }

    public static void main (String[] args) {
        Heap_TaskScheduler a1 = new Heap_TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(a1.leastInterval(tasks,2));
    }
}
