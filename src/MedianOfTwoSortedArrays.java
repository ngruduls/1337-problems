class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (B.length < A.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = A.length + B.length;
        int half = (total + 1) / 2;
        int l = 0;
        int r = A.length; // A is the shortest length
        double result = 0;

        while (l <= r) {
            int i = l + (r - l) / 2; // A-mid
            int j = half - i; // B
            // 4x
            int Aleft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < A.length) ? A[i] : Integer.MAX_VALUE;
            int Bleft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < B.length) ? B[j] : Integer.MAX_VALUE;
            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright ) {
                if (total % 2 == 0 ) result = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                else result = Math.max(Aleft, Bleft);
                break;
            } else if ( Aleft > Bright ) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }
        return result;
    }

    public static void main (String[] args) {
        MedianOfTwoSortedArrays a1 = new MedianOfTwoSortedArrays();
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,7};
        System.out.println(a1.findMedianSortedArrays(nums1,nums2));
    }
}
