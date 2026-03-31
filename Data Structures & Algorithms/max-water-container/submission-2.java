class Solution {
    public int maxArea(int[] heights) { 
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while(left < right)
        {
            int x = right - left;
            int y = Math.min(heights[right], heights[left]);
            maxArea = Math.max(maxArea, x*y);
            if(heights[right] < heights[left])
            {
                right--;
            }
            else
            {
                left++;
            }

        }
        return maxArea;

        
    }
}
