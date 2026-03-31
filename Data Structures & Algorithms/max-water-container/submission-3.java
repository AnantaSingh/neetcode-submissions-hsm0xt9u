class Solution {
    public int maxArea(int[] heights) {

        int l = 0;
        int r = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(l < r)
        {
            int y = Math.min(heights[l], heights[r]);
            int x = r-l;
            maxArea = Math.max(maxArea, x*y);

            if(heights[l] > heights[r])
            {
                r--;
            }
            else
            {
                l++;
            } 

        }

        return maxArea;
        
    }
}
