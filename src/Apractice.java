public class Apractice {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = arr[arr.length - 1];
        int[] rez = new int[arr.length];
        rez [arr.length - 1] = -1;

        for (int i = arr.length - 1; i > 0; i-- ) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            rez[i-1] =  maxSoFar;
        }
        return rez;
    }

    public static void main(String[] args) {
        Apractice a1 = new Apractice();
        // inputs
        int[] arr = {17,18,5,4,6,1};

        // outputs
        int[] newArr = a1.replaceElements(arr);
        for (int num : newArr) { System.out.println("num = " + num);}
    }
}
