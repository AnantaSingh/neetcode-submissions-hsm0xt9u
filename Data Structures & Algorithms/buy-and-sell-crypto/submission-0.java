class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for(int i=0;i < prices.length-1; i++)
        {
            for(int j=i+1; j < prices.length; j++)
            {
                int temp = prices[j] - prices[i];
                if(maxProfit < temp)
                {
                    maxProfit = temp;
                }          
            }
        }

        return maxProfit;
        
    }
}
