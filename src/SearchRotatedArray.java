class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int splitPoint = findRotatePoint(nums);
        int leftSearch = search(nums,low,splitPoint-1,target);
        int rightSearch = search(nums,splitPoint,high,target);
        return Math.max(leftSearch,rightSearch);
    }

    private int findRotatePoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            if (high == low) return low;

            int mid = (high + low) / 2;
            // right part is sorted, lowest must be in this part
            if (arr[mid] < arr[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int low, int high, int target) {
        while (high >= low) {
            int mid = (high + low) / 2;
            if (nums[mid] == target ) return mid;
            else if (nums[mid] < target ) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main (String[] args) {
        SearchRotatedArray a1 = new SearchRotatedArray();
        int[] nums = {4,5,6,7,0,1,2}; int target = 0;
        System.out.println(a1.search(nums,target));
    }
}
