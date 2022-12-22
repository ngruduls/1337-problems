import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Trie_WordSearch2 {
    private Trie currentTrie;
    private static int COLS;
    private static int ROWS;
    class Trie {
        public HashMap<Character, Trie> children;
        public boolean isWord;
        public int refs = 0;
        public Trie() { children = new HashMap<>(); }
        public void addWord(String word) {
            currentTrie = this; currentTrie.refs++;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!currentTrie.children.containsKey(currentChar)) {
                    currentTrie.children.put(currentChar, new Trie());
                } currentTrie = currentTrie.children.get(currentChar);
                currentTrie.refs += 1;
            }
            currentTrie.isWord = true;
        }
        public void removeWord(String word) {
            currentTrie = this; currentTrie.refs--;
            for (int i = 0; i < word.length(); i++) {
                if (currentTrie.children.containsKey(word.charAt(i))) {
                    currentTrie = currentTrie.children.get(word.charAt(i)); currentTrie.refs--;
                }
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trieRoot = new Trie();
        for (String word : words) { trieRoot.addWord(word); }
        ROWS = board.length; COLS = board[0].length;
        HashSet<String> res = new HashSet<>();
        HashSet<String> visit = new HashSet<>();
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                dfs (r, c, trieRoot, "", res, visit, board, trieRoot);
            }
        }
        return new ArrayList<>(res);
    }
    public void dfs (int r, int c, Trie trieNode, String word, HashSet<String> res, HashSet<String> visit, char[][]board, Trie trieRoot) {
        if ( r < 0 || c < 0 || r == ROWS || c == COLS ) return;
        char currentChar = board[r][c];
        if (!trieNode.children.containsKey(currentChar) || trieNode.children.get(currentChar).refs < 1 || visit.contains(r +"-"+ c)) {
            return;
        }
                visit.add(r +"-"+ c);
        trieNode = trieNode.children.get(currentChar);
        word += currentChar;
        if (trieNode.isWord) {
            trieNode.isWord = false;
            res.add(word);
            trieRoot.removeWord(word);
        }
        dfs(r+1, c, trieNode, word, res, visit, board, trieRoot);
        dfs(r-1, c, trieNode, word, res, visit, board, trieRoot);
        dfs(r,c+1, trieNode, word, res, visit, board, trieRoot);
        dfs(r,c-1, trieNode, word, res, visit, board, trieRoot);
                visit.remove(r +"-"+ c);
    }

    public static void main(String[] args) {
        Trie_WordSearch2 obj = new Trie_WordSearch2();
        char[][] board = {{'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        for (String word : obj.findWords(board,words)) {
            System.out.println("word found:" + word);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

