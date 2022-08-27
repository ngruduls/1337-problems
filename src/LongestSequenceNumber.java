import java.util.HashSet;

class LongestSequenceNumber {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int n : nums) {
            // start of the sequence
            if (!set.contains(n - 1)) {
                int length = 1;
                while (set.contains(n + length)) {++length;}
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }

    public static void main (String[] args) {
        LongestSequenceNumber a1 = new LongestSequenceNumber();
        int[] nums = {100,4,200,1,3,2};
        int res = a1.longestConsecutive(nums);
        System.out.println(res);
    }
}
