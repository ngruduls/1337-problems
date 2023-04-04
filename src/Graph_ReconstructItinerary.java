import java.util.*;

public class Graph_ReconstructItinerary {
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        //1) build the graph
        for(List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                List<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                List<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin,destList);
            }
        }

        // Step 2) PriorityQue
        for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet() ) {
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        this.flights = tickets.size();
        LinkedList<String> route  = new LinkedList<>();
        route.add("JFK");

        // Step 3) backtracking
        this.backtracking("JFK", route);
        return this.result;
    }

    boolean backtracking (String origin, LinkedList<String> route) {
        if (route.size() == this.flights + 1) {
            this.result = (List<String>) route.clone(); return true; //-> return instantly
        }
        if (!this.flightMap.containsKey(origin)) { return false; }
        int i = 0;
        boolean[] bitmap = this.visitBitmap.get(origin);

        for (String dest : this.flightMap.get(origin)) {
            if (!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = this.backtracking(dest,route);
                route.pollLast();
                bitmap[i] = false;

                if (ret) {
                    return true;
                }
            }
            ++i;
        }

        return false;
    }

    public List<String> findItinerary2(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();

        for (List<String> ticket : tickets) {
            graph
                    .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                    .add(ticket.get(1));
        }

        stack.push("JFK");
        while (!stack.isEmpty()) {
            String nextDestination = stack.peek();

            if (
                    !graph
                            .getOrDefault(nextDestination, new PriorityQueue<>())
                            .isEmpty()
            ) {
                stack.push(graph.get(nextDestination).poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }

    public static void main(String[] args) {
        Graph_ReconstructItinerary a1 = new Graph_ReconstructItinerary();

        ArrayList<List<String>> itineraries = new ArrayList<>();
        itineraries.add(new ArrayList<String>(Arrays.asList("JFK","AAA") ) );
        itineraries.add(new ArrayList<String>(Arrays.asList("JFK","BBB") ) );
        itineraries.add(new ArrayList<String>(Arrays.asList("BBB","CCC") ) );
        itineraries.add(new ArrayList<String>(Arrays.asList("CCC","JFK") ) );

        for (String itinerary : a1.findItinerary2( itineraries ) ) {
            System.out.println(itinerary);
        }
    }
}
