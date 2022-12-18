public class WordDictionary {
    Node root;
    private class Node {
        char value;
        boolean isWord;
        Node[] children;

        public Node(char value) {
            this.value = value;
            isWord = false;
            children = new Node[26];
        }
    }

    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper (String word, Node curr, int index) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node temp : curr.children) {
                    if (temp != null && searchHelper(word, temp, i + 1)) {
                        return true;
                    }
                } return false;
            }
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWord;
    }

    public static void main(String[] args) {
        WordDictionary a1 = new WordDictionary();
        a1.addWord("bad");
        a1.addWord("mad");
        System.out.println(a1.search("man"));
        System.out.println(a1.search("ma."));
        System.out.println(a1.search(".ad"));
    }
}
