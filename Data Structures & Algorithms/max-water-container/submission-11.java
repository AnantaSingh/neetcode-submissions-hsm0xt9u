class Solution 
{
    public int maxArea(int[] heights) 
    {
        int l= 0;
        int r = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(l < r)
        {
            int x = r - l;
            int y = Math.min(heights[l], heights[r]);
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
