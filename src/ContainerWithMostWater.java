class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int len = right - left;
            int hi = Math.min(height[left], height[right]);
            int area = len * hi;
            res = Math.max(area, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        ContainerWithMostWater a1 = new ContainerWithMostWater();
        int[] numbers = {1,8,6,2,5,4,8,3,7};
        int res = a1.maxArea(numbers);
        System.out.println(res);
    }
}
