public class Backtrack_WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (check(board,word, i, j, rows, cols, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean check(char[][] board, String word, int i, int j, int m, int n, int cur) {
        if (cur == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        boolean exist = false;
        if (board[i][j] == word.charAt(cur)) {
            board[i][j] += 100;
            boolean existWest = check(board, word, i, j + 1, m, n, cur + 1);
            boolean existSouth = check(board, word, i + 1, j, m, n, cur + 1);
            boolean existNorth = check(board, word, i - 1, j, m, n, cur + 1);
            boolean existEast = check(board, word, i, j - 1, m, n, cur + 1);
            if (existNorth || existSouth || existEast || existWest) {
                exist = true;
            }
            board[i][j] -= 100;
        }
        return exist;
    }

    public static void main(String[] args) {
        Backtrack_WordSearch a1 = new Backtrack_WordSearch();
        char[][] board = {{'b','a'},{'d','c'}};
        String word = "ac";
        System.out.println(a1.exist(board,word));
    }
}
