class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1]; // we want the number of coins for subamounts, so that what this stores
        Arrays.fill(dp, amount+1); // imp to make it amount + 1
        // System.out.println(dp[0]);
        dp[0] = 0;

        for(int i=1; i <= amount; i++) // for dp array, so we need for amount hence equality
        {
            for(int c : coins)
            {
                if(i-c >= 0)
                {
                    dp[i] = Math.min(dp[i], dp[i-c] + 1); // imp to add 1
                } 
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
        
    }
}
