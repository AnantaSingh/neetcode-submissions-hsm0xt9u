class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int currMin = 1;
        int currMax = 1;

        for(int n : nums)
        {
            int temp = n * currMax;
            currMax = Math.max(n, Math.max(n * currMin, n * currMax));
            currMin = Math.min(n, Math.min(n * currMin, temp));
            maxProd = Math.max(currMax, maxProd);

        }

        return maxProd;
        
    }
}
