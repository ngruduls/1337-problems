class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int a = 0,b = 0;
        while (left < right) {
            a = numbers[left];
            b = numbers[right];
            if (a + b == target) {
                break;
            } else if (a + b < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {left + 1, right + 1};
    }

    public static void main (String[] args) {
        TwoSum a1 = new TwoSum();
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = a1.twoSum(numbers, target);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
