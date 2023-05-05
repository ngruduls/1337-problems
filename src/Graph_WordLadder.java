import java.util.*;

public class Graph_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            StringBuilder string = null;
            for (int i = 0; i < word.length(); i++) {
                string = new StringBuilder(word);
                string.setCharAt(i, '*');
                List<String> matchedWordList = adjList.getOrDefault(string.toString(),
                        new ArrayList<String>());
                matchedWordList.add(word);
                adjList.put(string.toString(), matchedWordList);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        StringBuilder sb = null;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String str = queue.poll();

                for (int i = 0; i < str.length(); i++) {
                    sb = new StringBuilder(str);
                    sb.setCharAt(i, '*');
                    for (String patternMatched : adjList.get(sb.toString())) {
                        if (patternMatched.equals(endWord)) {
                            return step;
                        }
                        if (visited.contains(patternMatched)) {
                            continue;
                        }
                        queue.offer(patternMatched);
                        visited.add(patternMatched);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Graph_WordLadder a1 = new Graph_WordLadder();
        List<String> wlist = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));
        System.out.println(a1.ladderLength("hit", "cog", wlist));
    }
}
