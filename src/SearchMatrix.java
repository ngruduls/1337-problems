class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowlength = matrix[0].length - 1;
        int rowcount = matrix.length;
        int top = 0, bot = rowcount-1;
        while (top <= bot) {
            int row = (top + bot ) / 2;
            if (target > matrix[row][rowlength])  top = row + 1;
            else if (target < matrix[row][0] ) bot = row - 1;
            else break;
        }

        if ((top <= bot) == false) return false;
        int finalrow = (top + bot ) / 2;
        int l=0, r=rowlength;
        while (l <= r ) {
            int m = (l + r ) / 2;
            if (target > matrix[finalrow][m] ) l = m + 1;
            else if (target < matrix[finalrow][m]) r = m - 1;
            else return true;
        }
        return false;
    }

    public static void main (String[] args) {
        SearchMatrix a1 = new SearchMatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int[][] matrix = {{1,1}};
        System.out.println(a1.searchMatrix(matrix,16));
    }
}
