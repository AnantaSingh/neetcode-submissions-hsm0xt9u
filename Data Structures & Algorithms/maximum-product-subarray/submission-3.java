class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int currMin = 1;
        int currMax = 1;

        for(int n : nums)
        {
            int temp = n * currMin;
            currMin = Math.min(n, Math.min(n * currMin, n * currMax));
            currMax = Math.max(n, Math.max(temp, n * currMax));
            maxProd = Math.max(currMax, maxProd);

        }

        return maxProd;
        
    }
}
