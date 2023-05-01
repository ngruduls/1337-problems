import java.util.Arrays;

public class Graph_UnsurroundedRegion {
    public void solve(char[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        // Temp capture
        for (int i = 0; i < nCols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[nRows - 1][i] == 'O') {
                dfs(board, nRows - 1, i);
            }
        }
        for (int i = 0; i < nRows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][nCols - 1] == 'O') {
                dfs(board, i, nCols - 1);
            }
        }

        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if (board[r][c] == 'O') { board[r][c] = 'X';
                }
                if (board[r][c] == 'T') {board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        int nRows = board.length;
        int nCols = board[0].length;
        if (row < 0 || col < 0 || row >= nRows || col >= nCols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Graph_UnsurroundedRegion a1 = new Graph_UnsurroundedRegion();
        a1.solve(board);

        for (int row = 0; row < board.length; row ++) {
            System.out.println(Arrays.toString(board[row]));
        }
    }
}
