class Solution {
    public int maxArea(int[] heights) {
        int area =0;

        for(int i=0; i < heights.length; i++)
        {
            for(int j=i+1; j< heights.length; j++)
            {
                int temp = (j-i) * Math.min(heights[i], heights[j]);
                area = Math.max(area, temp);

            }
        }

        return area;
        
    }
}
