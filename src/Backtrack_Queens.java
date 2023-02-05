import java.util.ArrayList;
import java.util.List;

public class Backtrack_Queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        boolean board[][] = new boolean[n][n];
        queens(board, 0, ans);
        return ans;
    }

    public void queens(boolean[][] board, int row, List<List<String>> finalAns) {
        if (row == board.length) {
            ArrayList<String> boardState = new ArrayList<String>();
            createAnswer(board, boardState);
            finalAns.add(boardState);
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board,row + 1, finalAns);
                board[row][col] = false;
            }
        }
    }

    public void createAnswer (boolean[][] board, ArrayList<String> answer) {
        for (int row =  0; row < board.length; row ++) {
            StringBuilder str = new StringBuilder();
            for (int col = 0; col < board[0].length; col ++) {
                if (board[row][col] ) { str.append("Q");
                } else {
                    str.append(".");
                }
            }
            answer.add(str.toString());
        }
    }

    public boolean isSafe (boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        int maxLeft = Math.min(row,col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Backtrack_Queens a1 = new Backtrack_Queens();
        List<List<String>> rez = a1.solveNQueens(4);
        for (List<String> currentBoard : rez) {
            for (String currentRow : currentBoard) {
                System.out.println(currentRow);
            }
            System.out.println();
        }
    }
}
