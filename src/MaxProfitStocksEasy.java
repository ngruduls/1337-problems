class MaxProfitStocksEasy {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int price : prices) {
            min = Math.min(min,price);
            res = Math.max(res, price - min);
        }
        return res;
    }

    public static void main (String[] args) {
        MaxProfitStocksEasy a1 = new MaxProfitStocksEasy();
        int[] nums = {7,1,5,3,6,4};
        int res = a1.maxProfit(nums);
        System.out.println(res);
    }
}
