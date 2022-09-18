import java.util.Arrays;

class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int speed = (l + r) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / speed);
            }
            if (hours <= h) {
                res = Math.min(speed,res);
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        KokoEatingBanana a1 = new KokoEatingBanana();
        //int[] nums = {3,6,7,11}; int h = 8;
        int[] nums = {30,11,23,4,20}; int h = 5;
        System.out.println(a1.minEatingSpeed(nums,h));
    }
}
