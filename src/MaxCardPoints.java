class MaxCardPoints {

    public int indexHelper(int index, int[] array) {
        int maxIndex = array.length - 1;
        if (index >= 0 && index <= maxIndex) {
            return index;
        } else if (index < 0) {
            return maxIndex - Math.abs(index) + 1;
        } else {
            // > maxindex
            return index - maxIndex;
        }
    }

    public int maxScore(int[] cardPoints, int k) {
        int rollingSum = 0;
        int maxSum = 0;
        int left = 0;
        int right = k - 1;
        // calculate initial rolling sum
        for (int i = left; i <= right; i++) {
            rollingSum += cardPoints[i];
        }
        maxSum = rollingSum;
        // slide the window
        for (int i = 0; i < k; i++) {
            int left_old = left;
            int right_old = right;
            right = indexHelper(right - 1, cardPoints);
            left = indexHelper(left - 1, cardPoints);
            rollingSum += cardPoints[left] - cardPoints[right_old];
            maxSum = Math.max(rollingSum,maxSum);
        }
        return maxSum;
    }

    public static void main (String[] args) {
        MaxCardPoints a1 = new MaxCardPoints();
        int[] nums = {1,2,3,4,5,6,1};
        int k = 3;
        int res = a1.maxScore(nums,k);
        System.out.println(res);
    }
}
