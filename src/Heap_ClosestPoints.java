import java.util.Comparator;
import java.util.PriorityQueue;

class Heap_ClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]) ;
            }
        });
        for (int[] point : points) {
            q.add(point);
            //remove when size increase k
            if (q.size() > k) {
                q.remove();
            }
        }
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] cur = q.poll();
            ans[i][0] = cur[0];
            ans[i][1] = cur[1];
        }
        return ans;
    }

    public static void main (String[] args) {
        Heap_ClosestPoints a1 = new Heap_ClosestPoints();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        int [][] rez = a1.kClosest(points,k);
        for (int i = 0; i < rez.length; i++) {
            for (int j = 0; j < rez[i].length; j++) {
                System.out.print(rez[i][j] + " ");
            }
            System.out.println();
        }
    }
}
