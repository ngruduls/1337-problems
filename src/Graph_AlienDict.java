import java.util.*;

public class Graph_AlienDict {
    public String alienOrder(String[] words) {
        // Step 0 - create adj lists + indegree coutnt
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Step 1 : Find all edges
        for (int i = 0; i < words.length - 1; i ++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // invalid order
            }
            // find first non-match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j ++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j),  indegree.get(word2.charAt(j)) + 1  );
                    break;
                }
            }
        }

        // Step 2 : BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet() ) {
            if (indegree.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c  = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                indegree.put( next,  indegree.get(next) - 1 );
                if (indegree.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < indegree.size()) {
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph_AlienDict ad = new Graph_AlienDict();
        String[] words = { "wrt","wrf","er","ett","rftt", "xy", "ab"};
        System.out.println(ad.alienOrder(words));
    }
}
