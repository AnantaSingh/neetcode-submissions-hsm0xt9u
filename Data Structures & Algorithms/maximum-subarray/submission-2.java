class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int prefixSum = 0;

        for(int n : nums)
        {
            if(prefixSum < 0)
            {
                prefixSum = 0;
            }
            prefixSum = prefixSum + n;
            maxSum = Math.max(maxSum, prefixSum); 
        }


        return maxSum;
        
    }
}
