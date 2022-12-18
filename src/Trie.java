class Trie {
    Node root;

    class Node{
        private char value;
        private boolean isWord;
        private Node[] children;

        public Node(char val) {
            this.value = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    public Trie() {
        root = new Node('\0'); // dummy node;
    }

    public void insert(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null ) {
                curr.children[x - 'a'] = new Node (x);
            }
            curr = curr.children[x - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node res = getLast(word);
        return (res!= null && res.isWord);
    }

    public Node getLast(String word) {
        Node curr = root;
        for (char x : word.toCharArray()) {
            if (curr.children[x - 'a'] == null) {
                return null;
            }
            curr = curr.children[x - 'a'];
        }
        return curr;
    }

    public boolean startsWith(String prefix) {
        Node res = getLast(prefix);
        if (res == null) return false;
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("nauris");
        obj.insert("nav");
        System.out.println(obj.search("nauris"));
        System.out.println(obj.search("nauda"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

