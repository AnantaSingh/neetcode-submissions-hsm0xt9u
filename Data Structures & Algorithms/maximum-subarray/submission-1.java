class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; //2
        int prefixSum = 0;

        for(int n : nums)
        {
            prefixSum = prefixSum + n;
            if(prefixSum < 0)
            {
                maxSum = Math.max(maxSum, prefixSum); 
                prefixSum = 0;
                continue;
            }
            maxSum = Math.max(maxSum, prefixSum); 
        }


        return maxSum;
        
    }
}
