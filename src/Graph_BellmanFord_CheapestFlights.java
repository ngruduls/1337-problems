import java.util.Arrays;

public class Graph_BellmanFord_CheapestFlights {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Shortest Distance from source to All other nodes
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        // price from source to source is always 0
        distTo[src] = 0;

        for (int i = 0; i <= k; i++) {
            //make a copy of prices
            int[] temp = new int[n]; temp = Arrays.copyOf(distTo, distTo.length);

            // loop through flights
            for (int j = 0; j < flights.length; j++) {
                int source = flights[j][0];
                int destination = flights[j][1];
                int price = flights[j][2];
                // unreachable
                if (distTo[source] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distTo[source] + price < temp[destination]) {
                    temp[destination] = distTo[source] + price;
                }
            }
            distTo = temp;
        }

        if (distTo[dst] != Integer.MAX_VALUE) {
            return distTo[dst];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Graph_BellmanFord_CheapestFlights a1  = new Graph_BellmanFord_CheapestFlights();
        int[][] flights = new int[][] {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(a1.findCheapestPrice(3, flights, 0, 2, 1));
    }
}
