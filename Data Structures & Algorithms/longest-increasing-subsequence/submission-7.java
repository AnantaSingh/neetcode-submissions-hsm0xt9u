class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxlength = dp[n-1];
        

        for(int i= n-1; i >= 0; i--)
        {
            for(int j=i+1; j<n; j++)
            {
                if(nums[i] < nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                // else if(nums[i] == nums[j])
                // {
                //      dp[i] = dp[j];
                // }
                // else
                // {
                //     dp[i] = 1;
                // }
                System.out.println("nums[i] = " + nums[i]);
                System.out.println("nums[j] = " + nums[j] + " dp[i] = " + dp[i]);
                maxlength = Math.max(maxlength, dp[i]);
                // System.out.println("maxlength = " + maxlength);
                // System.out.println();
            }
        }

        return maxlength;
        
    }
}
