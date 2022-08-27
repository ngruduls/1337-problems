class TrappingRainWater {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            left[i] = Math.max(height[i], max);
            max = left[i];
        }

        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i],max);
            max = right[i];
        }

        for (int i = 0; i < height.length; i++) {
            total = total + Math.min(left[i],right[i]) - height[i];
        }
        return total;
    }

    public static void main (String[] args) {
        TrappingRainWater a1 = new TrappingRainWater();
        int[] numbers = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = a1.trap(numbers);
        System.out.println(res);
    }
}
