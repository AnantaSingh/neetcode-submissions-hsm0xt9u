class Solution {
    public int maxProfit(int[] prices) 
    {
        int i = 0;
        int j = i+1;
        int maxProfit = 0;

        while(j < prices.length)
        {
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            if(prices[j] < prices[i])
            {
                i=j;
            }
            j++;
        }

        return maxProfit;  
    }
}
