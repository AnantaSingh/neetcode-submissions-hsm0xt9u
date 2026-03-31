

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // each element = [index, height]
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            // while current bar is shorter than the one on stack top
            // pop from stack and calculate area
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index; // we can extend the new bar to this popped index
            }

            stack.push(new int[]{start, heights[i]});
        }

        // handle bars still in stack
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
