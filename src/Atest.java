public class Atest {
    public static void main(String[] args) {
        int[][] array = new int[2][3];

        int value = 1;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                array[row][col] = value++;
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
}
