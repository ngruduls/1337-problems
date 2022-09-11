import java.util.Arrays;
import java.util.Stack;

class LargestRectangleInHistorgram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] furthestRight = new int[n];
        Stack<Integer> right = new Stack<>();
        Arrays.fill(furthestRight, heights.length);
        for (int i = 0; i < heights.length; i++) {
            if (right.isEmpty() || heights[i] >= heights[right.peek()]) {
                right.add(i);
            } else {
                while (!right.isEmpty() && heights[i] <heights[right.peek()] ) {
                    furthestRight[right.pop()] = i;
                }
                right.add(i);
            }
        }

        int[] furthestLeft = new int[n];
        Stack<Integer> left = new Stack<>();
        Arrays.fill(furthestLeft, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            if (left.isEmpty() || heights[i] >= heights[left.peek()]) {
                left.add(i);
            } else {
                while (!left.isEmpty() && heights[i] < heights[left.peek()]) {
                    furthestLeft[left.pop()] = i;
                }
                left.add(i);
            }
        }

        int area = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            area = Math.max(area, heights[i] * (furthestRight[i] - furthestLeft[i] - 1));
        }
        return area;
    }

    public static void main (String[] args) {
        LargestRectangleInHistorgram a1 = new LargestRectangleInHistorgram();
        //System.out.println(a1.climbStairsDP(3));
        int[] arr = {2,1,5,6,2,3};
        System.out.println(a1.largestRectangleArea(arr));
    }
}
