class Solution {
    static class Bar
    {
        int start;
        int height;
        Bar(int start, int height)
        {
            this.start = start;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Deque<Bar> stack = new ArrayDeque<>();// each element = [index, height]
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            // while current bar is shorter than the one on stack top
            // pop from stack and calculate area
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                Bar top = stack.pop();
                maxArea = Math.max(maxArea, top.height * (i - top.start));
                start = top.start; // we can extend the new bar to this popped index
            }

            stack.push(new Bar(start, heights[i]));
        }

        // handle bars still in stack
        while (!stack.isEmpty())
        {
            Bar pair = stack.pop();
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.start));
        }

        return maxArea;
    }
}
