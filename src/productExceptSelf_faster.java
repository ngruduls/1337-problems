class productExceptSelf_faster {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len+1];
        int[] post = new int[len+1];
        pre[0] = 1; //nums[0]; post[len-1] = nums[len-1];
        post[len] = 1;
        for (int i = 1; i < len+1; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int res[] = new int[len];
        for (int i = len-1; i >= 0; i--) {
            post[i] = nums[i] * post[i + 1];
            res[i] = pre[i] * post[i + 1];
        }
        return res;
    }

    public static void main (String[] args) {
        productExceptSelf_faster a1 = new productExceptSelf_faster();
        int[] nums = {1,2,3,4};
        int[] res = a1.productExceptSelf(nums);
        for (int i = 0 ; i < res.length; i++) {
            if (i == 0) {
                System.out.print("[" + res[i]);
            } else if (i == res.length - 1) {
                System.out.print("," + res[i] + "]");
            } else {
                System.out.print("," + res[i]);
            }
        }
    }
}
