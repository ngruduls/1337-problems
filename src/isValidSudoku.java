import java.util.HashSet;

class isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> sdk = new HashSet<String>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {

                    // chech whether contains any duplicates
                    if (sdk.contains("row" + i + board[i][j]) || sdk.contains("col" + j + board[i][j]) ) {
                        return false;
                    }
                    sdk.add("row" + i + board[i][j]);
                    sdk.add("col" + j + board[i][j]);

                    // box
                    if (sdk.contains("box" + (i/3) + (j/3) + board[i][j]) ) {
                        return  false;
                    }
                    sdk.add("box" + (i/3) + (j/3) + board[i][j]);
                    }
                }
            }
        return true;
    }

    public static void main (String[] args) {
        isValidSudoku a1 = new isValidSudoku();
        int[] nums = {1,2,3,4};
    }
}
